package ViewPackage;

import ControllerPackage.ApplicationController;
import ExceptionPackage.AccessException;
import ExceptionPackage.GetException;
import ModelPackage.Locality;
import ModelPackage.User;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.ArrayList;

import static javax.swing.SwingConstants.CENTER;
import static javax.swing.SwingConstants.RIGHT;

public class ChangeUserInfoPanel extends JPanel{
    //region variable
    private ApplicationController controller;

    private ArrayList<Locality> localitys;

    private JLabel necessaryLabel;
    private String necessaryTexte;
    //panel contenant tout
    private FormPanel form;
    private ButtonsPanel buttons;
    //lastname
    private JLabel lastNameLabel;
    private JTextField lastNameField;
    //firstname
    private JLabel firstNameLabel;
    private JTextField firstNameField;
    //birthday
    private JLabel  birthDayLabel;
    private JSpinner birthdaySpinner;
    private SpinnerDateModel dateModel;
    private JSpinner.DateEditor editor;
    //email
    private JLabel  eMailLabel;
    private JTextField  eMailField;
    //password
    //tel
    private JLabel  telLabel;
    private JTextField  telField;
    //pub consent
    private JLabel  pubConsentLabel;
    private ButtonGroup pubConstent;
    private JRadioButton pubAgree, pubDisagree;
    //sponsor
    private JTextField  sponsorField;
    private JLabel   sponsorLabel;
    //residence
    private JLabel residenceLabel;
    private JComboBox residenceBox;
    //bouton
    private JButton submitButton;
    private JButton backButton;
    //endregion

    public ChangeUserInfoPanel() throws AccessException, GetException {
        controller = new ApplicationController();
        this.setBackground(ViewUtils.backGroundColor);
        this.setPreferredSize(new Dimension(350, 700));

        form = new FormPanel();
        buttons = new ButtonsPanel();
        
        lastNameLabel = new JLabel("Last name * :", RIGHT);
        form.add(lastNameLabel);
        lastNameField = new JTextField(ViewUtils.currentUser.getLastName());
        form.add(lastNameField);
        firstNameLabel = new JLabel("First name * :", RIGHT);
        form.add(firstNameLabel);
        firstNameField= new JTextField(ViewUtils.currentUser.getFirstName());
        form.add(firstNameField);

        birthDayLabel = new JLabel("Birthday * :", RIGHT);
        form.add(birthDayLabel);
        dateModel = new SpinnerDateModel(ViewUtils.currentUser.getBirthday().getTime(), ViewUtils.currentUser.getBirthday().getTime(), new Date(), 0);
        birthdaySpinner = new JSpinner(dateModel);
        editor = new JSpinner.DateEditor(birthdaySpinner, "dd-MMMM-yyyy");
        birthdaySpinner.setEditor(editor);
        birthdaySpinner.setValue(ViewUtils.currentUser.getBirthday().getTime());
        form.add(birthdaySpinner);

        eMailLabel = new JLabel("Email * :", RIGHT);
        form.add(eMailLabel);
        eMailField = new JTextField(ViewUtils.currentUser.getEmailAddress());
        eMailField.setEditable(false);
        form.add(eMailField);
        
        telLabel = new JLabel("Tel :", RIGHT);
        form.add(telLabel);
        telField = new JTextField(ViewUtils.currentUser.getPhoneNumber());
        form.add(telField);

        pubConsentLabel = new JLabel("Receive pubs on your email * :", RIGHT);
        form.add(pubConsentLabel);
        form.add(new JLabel());
        pubAgree = new JRadioButton("Yes", ViewUtils.currentUser.isAgreeReceivePub());
        pubAgree.setBackground(ViewUtils.backGroundColor);
        pubAgree.setHorizontalAlignment(CENTER );
        form.add(pubAgree);
        pubDisagree = new JRadioButton("No", !ViewUtils.currentUser.isAgreeReceivePub());
        pubDisagree.setBackground(ViewUtils.backGroundColor);
        form.add(pubDisagree);

        pubConstent = new ButtonGroup();
        pubConstent.add(pubAgree);
        pubConstent.add(pubDisagree);

        sponsorLabel = new JLabel("Email of a Sponsor :", RIGHT);
        form.add(sponsorLabel);
        sponsorField = new JTextField();
        form.add(sponsorField);

        residenceLabel = new JLabel("Locality * :", RIGHT);
        form.add(residenceLabel);
        localitys = controller.getAllLocality();
        residenceBox = new JComboBox(localitys.toArray());
        //selectionne la localité du user
        //residenceBox.setSelectedItem(controller.getLocality(ViewUtils.currentUser.getEmailAddress()));
        residenceBox.setMaximumRowCount(5);
        form.add(residenceBox);

        backButton = new JButton("Back");
        backButton.addActionListener(event -> ViewUtils.changePanel(new UserProfilePanel(ViewUtils.currentUser)));
        buttons.add(backButton);

        submitButton = new JButton("Submit");
        submitButton.addActionListener(new ConnectionButton());
        buttons.add(submitButton);

        necessaryTexte = "* Required filed";
        necessaryLabel = new JLabel(necessaryTexte);

        this.add(form, BorderLayout.CENTER);
        this.add(buttons, BorderLayout.SOUTH);
        this.add(necessaryLabel, BorderLayout.CENTER);
    }

    public class FormPanel extends JPanel{
        public FormPanel (){
            this.setPreferredSize(new Dimension(350,400));
            this.setBackground(ViewUtils.backGroundColor);
            this.setLayout(new GridLayout(10,2,10,3));
        }
    }
    public class ButtonsPanel extends JPanel{
        public ButtonsPanel (){
            this.setPreferredSize(new Dimension(350,100));
            this.setBackground(ViewUtils.backGroundColor);
            this.setLayout(new FlowLayout());
        }
    }

    public class ConnectionButton implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            try {
                //récupère les données et vérifie si les champs sont vides ou null
                String lastName = lastNameField.getText();
                String firstName = firstNameField.getText();
                //date de naissance conversion Date en GregorianCalendar
                //ne peut pas être null
                GregorianCalendar birthday = new GregorianCalendar();
                birthday.setTime(((Date) birthdaySpinner.getValue()));

                String emailAddress = eMailField.getText();
                String password = "00";
                String telNumber = telField.getText();
                boolean pubConsent = pubAgree.isSelected();
                String sponsor = sponsorField.getText();
                Locality residence = (Locality) residenceBox.getSelectedItem();
                User user = controller.updateUserInfo(lastName, firstName, birthday, emailAddress.toLowerCase(), password, telNumber, pubConsent, sponsor, residence);

                ViewUtils.currentUser = user;
                ViewUtils.changePanel(new UserProfilePanel(ViewUtils.currentUser));

            } catch (Exception exception) {
                ViewUtils.showException(exception);
            }
        }
    }

}
