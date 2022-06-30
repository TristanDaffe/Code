package ViewPackage;

import ControllerPackage.ApplicationController;
import ExceptionPackage.AccessException;
import ExceptionPackage.GetException;
import ModelPackage.*;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.*;

import static java.util.Calendar.YEAR;
import static javax.swing.SwingConstants.CENTER;
import static javax.swing.SwingConstants.RIGHT;

public class UserProfilePanel extends JPanel {
    private ApplicationController controller;
    private User user;
    private JLabel emailLabel;
    private JLabel emailValue;
    private JLabel lastNameLabel;
    private JLabel lastNameValue;
    private JLabel firstNameLabel;
    private JLabel firstNameValue;
    private JLabel birthdayLabel;
    private JLabel birthdayValue;
    private JLabel localityLabel;
    private JLabel localityValue;
    private JLabel phoneNumberLabel;;
    private JLabel phoneNumberValue;
    private JLabel pubConsentLabel;;
    private JLabel pubConsentValue;
    private JLabel sponsorLabel;;
    private JLabel sponsorValue;
    private JLabel selectYearLabel;
    private JButton changeInfoButton;
    private JComboBox yearBox;
    private HiringStat hiringForm;
    private JLabel nbHiringLabel;
    private JLabel nbHiringTotLabel;
    private ProfilForm profilForm;
    private JLabel mostUseStationLabel;
    private JLabel mostReturnStationLabel;
    private StationForm mostTakenStationForm;
    private StationForm mostReturnStationForm;
    private Station mostTakenStation;
    private Station mostReturnStation;
    private JScrollPane hiringGraph;

    public UserProfilePanel(User user){
        try {

            controller = new ApplicationController();
            this.setPreferredSize(new Dimension(350, 700));
            setBackground(ViewUtils.backGroundColor);
            this.user = user;

            profilForm = new ProfilForm();
            hiringForm = new HiringStat(GregorianCalendar.getInstance().YEAR);

            lastNameLabel = new JLabel("Last name :", RIGHT);
            lastNameValue = new JLabel(this.user.getLastName(), CENTER);
            profilForm.add(lastNameLabel);
            profilForm.add(lastNameValue);

            firstNameLabel = new JLabel("First name", RIGHT);
            firstNameValue = new JLabel(this.user.getFirstName(), CENTER);
            profilForm.add(firstNameLabel);
            profilForm.add(firstNameValue);

            emailLabel = new JLabel("Email : ", RIGHT);
            emailValue = new JLabel(this.user.getEmailAddress(), CENTER);
            profilForm.add(emailLabel);
            profilForm.add(emailValue);

            birthdayLabel = new JLabel("Birthday :", RIGHT);
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MMMM-YYYY");
            Date birthday = this.user.getBirthday().getTime();
            birthdayValue = new JLabel(dateFormat.format(birthday), CENTER);
            profilForm.add(birthdayLabel);
            profilForm.add(birthdayValue);

            localityLabel = new JLabel("Locality : ", RIGHT);
            localityValue = new JLabel(controller.getLocality(user.getEmailAddress()).toString(), CENTER);
            profilForm.add(localityLabel);
            profilForm.add(localityValue);

            phoneNumberLabel = new JLabel("Phone : ", RIGHT);
            String phoneNumber = this.user.getPhoneNumber();
            if (phoneNumber == null)
                phoneNumber = "none";
            phoneNumberValue = new JLabel(phoneNumber, CENTER);
            profilForm.add(phoneNumberLabel);
            profilForm.add(phoneNumberValue);

            pubConsentLabel = new JLabel("Pub consent :", RIGHT);
            String consent = this.user.isAgreeReceivePub() ? "yes" : "no";
            pubConsentValue = new JLabel(consent, CENTER);
            profilForm.add(pubConsentLabel);
            profilForm.add(pubConsentValue);

            sponsorLabel = new JLabel("Sponsor : ", RIGHT);
            String sponsor = this.user.getSponsor();
            if (sponsor == null)
                sponsor = "none";
            sponsorValue = new JLabel(sponsor, CENTER);
            profilForm.add(sponsorLabel);
            profilForm.add(sponsorValue);

            changeInfoButton = new JButton("Change info");
            changeInfoButton.addActionListener(e -> {
                try {
                    ViewUtils.changePanel(new ChangeUserInfoPanel());
                } catch (AccessException ex) {
                    throw new RuntimeException(ex);
                } catch (GetException ex) {
                    ViewUtils.showException(ex);
                }
            });
            profilForm.add(changeInfoButton);
            profilForm.add(new JLabel());

            nbHiringLabel = new JLabel("you hire a total of ", RIGHT);
            nbHiringTotLabel = new JLabel(controller.getTotBikeHire(this.user.getEmailAddress()) +" bikes");
            nbHiringLabel.setFont(new Font("Consolas", Font.BOLD, 15));
            profilForm.add(nbHiringLabel);
            profilForm.add(nbHiringTotLabel);

            //information générale du user
            add(profilForm, BorderLayout.CENTER);

            mostTakenStation = controller.getMostUsedStation(this.user.getEmailAddress());
            if(mostTakenStation == null) {
                mostUseStationLabel = new JLabel("Most taken station :");
                mostUseStationLabel.setFont(new Font("Consolas", Font.BOLD, 15));
                add(new JLabel("you haven't hired a bike yet !"));
            }
            else {
                mostTakenStationForm = new StationForm(mostTakenStation, "Most taken station :");
                add(mostTakenStationForm, BorderLayout.CENTER);
            }

            mostReturnStation = controller.getMostUsedReturnStation(this.user.getEmailAddress());
            if(mostTakenStation == null) {
                mostUseStationLabel = new JLabel("Most returned station :");
                mostUseStationLabel.setFont(new Font("Consolas", Font.BOLD, 15));
                add(new JLabel("you haven't returned a bike yet !"));
            }
            else {
                mostReturnStationForm = new StationForm(mostReturnStation, "Most returned station :");
                add(mostReturnStationForm, BorderLayout.CENTER);
            }


            //information changeant en fonction de l'année choisie
            selectYearLabel = new JLabel("Hiring for the year :");
            LinkedHashSet<Integer> years = new LinkedHashSet<>();
            for(Integer i = GregorianCalendar.getInstance().get(YEAR); i >= ViewUtils.creationYears ; i--)
                years.add(i);
            yearBox = new JComboBox(years.toArray());
            yearBox.addActionListener(e -> {
                try {
                    hiringForm =  new HiringStat(((int)yearBox.getSelectedItem()));
                } catch (GetException ex) {
                    hiringForm = null;
                }
                hiringGraph.removeAll();
                remove(hiringGraph);
                hiringGraph = new JScrollPane(hiringForm);
                hiringGraph.setPreferredSize(new Dimension(400, 150));
                add(hiringGraph);
                validate();
                repaint();
            });

            add(selectYearLabel);
            add(yearBox);

            hiringGraph = new JScrollPane(hiringForm);
            hiringGraph.setPreferredSize(new Dimension(400, 150));
            add(hiringGraph, BorderLayout.CENTER);

        }
        catch (Exception ex){
            ViewUtils.showException(ex);
        }
    }

    private class ProfilForm extends JPanel{
        public ProfilForm() {
            this.setPreferredSize(new Dimension(350,220));
            this.setLayout(new GridLayout(11,2,10,3));
            Border blackline = BorderFactory.createLineBorder(Color.black);
            Border border = BorderFactory.createTitledBorder(blackline, "Profil");
            this.setBorder(border);
        }
    }

    private class HiringStat extends JPanel{
        private HashMap<String, Integer> hiringPerMonth;
        private String[] months = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};

        public HiringStat(int year) throws GetException {
            setLayout(new GridLayout(2, 12, 10, 10));
            setPreferredSize(new Dimension(1000,100));

            hiringPerMonth = controller.getHiringsPerMonth(user.getEmailAddress(), year);
            for(String month : months){
                JLabel monthLabel = new JLabel(month, CENTER);
                add(monthLabel);
            }
            for(int i = 0; i < 12; i++){
                JLabel hiringValue = new JLabel(""+ hiringPerMonth.get(months[i]), CENTER);
                add(hiringValue);
            }
        }
    }

    private class StationForm extends JPanel{
        public StationForm(Station station, String name){
            this.setPreferredSize(new Dimension(175,110));
            this.setLayout(new GridLayout(4,1,5,0));
            Border blackline = BorderFactory.createLineBorder(Color.black);
            Border border = BorderFactory.createTitledBorder(blackline, name);
            this.setBorder(border);

            JLabel mostUseStationName = new JLabel(station.getLabel());
            JLabel mostUseStationLocality = new JLabel(station.getLocality().toString());
            JLabel mostUseStationPhone = new JLabel(station.getPhoneNumber());
            this.add(mostUseStationName);
            this.add(mostUseStationLocality);
            this.add(mostUseStationPhone);
        }
    }
}
