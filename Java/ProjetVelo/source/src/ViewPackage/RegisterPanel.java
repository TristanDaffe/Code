package ViewPackage;

import ControllerPackage.*;
import ExceptionPackage.*;
import ModelPackage.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.ArrayList;

import static javax.swing.SwingConstants.*;

public class RegisterPanel extends JPanel {
    //region variables
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
    private JLabel  passwordLabel;
    private JPasswordField passwordField;
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
    private JButton registerButton;
    private JButton backButton;
//endregion
    public RegisterPanel() throws AccessException, GetException {
        controller = new ApplicationController();
        this.setBackground(ViewUtils.backGroundColor);
        this.setPreferredSize(new Dimension(350, 700));

        form = new FormPanel();
        buttons = new ButtonsPanel();
        lastNameLabel = new JLabel("Last name * :", RIGHT);
        form.add(lastNameLabel);
        lastNameField = new JTextField();
        form.add(lastNameField);
        firstNameLabel = new JLabel("First name * :", RIGHT);
        form.add(firstNameLabel);
        firstNameField= new JTextField();
        form.add(firstNameField);

        birthDayLabel = new JLabel("Birthday * :", RIGHT);
        form.add(birthDayLabel);
        dateModel = new SpinnerDateModel();
        birthdaySpinner = new JSpinner(dateModel);
        editor = new JSpinner.DateEditor(birthdaySpinner, "dd-MMMM-yyyy");
        birthdaySpinner.setEditor(editor);
        birthdaySpinner.setValue(new GregorianCalendar().getTime());
        form.add(birthdaySpinner);

        eMailLabel = new JLabel("Email * :", RIGHT);
        form.add(eMailLabel);
        eMailField = new JTextField();
        form.add(eMailField);

        passwordLabel = new JLabel("Password * :", RIGHT);
        form.add(passwordLabel);
        passwordField = new JPasswordField();
        form.add(passwordField);

        telLabel = new JLabel("Tel :", RIGHT);
        form.add(telLabel);
        telField = new JTextField();
        form.add(telField);

        pubConsentLabel = new JLabel("Receive pubs on your email * :", RIGHT);
        form.add(pubConsentLabel);
        form.add(new JLabel());
        pubAgree = new JRadioButton("Yes", true);
        pubAgree.setBackground(ViewUtils.backGroundColor);
        pubAgree.setHorizontalAlignment(CENTER );
        form.add(pubAgree);
        pubDisagree = new JRadioButton("No", false);
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
        residenceBox.setMaximumRowCount(5);
        form.add(residenceBox);

        backButton = new JButton("Back");
        backButton.addActionListener(event -> ViewUtils.changePanel(new HomePagePanel()));
        buttons.add(backButton);

        registerButton = new JButton("Register");
        registerButton.addActionListener(new ConnectionButton());
        buttons.add(registerButton);

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
                GregorianCalendar birthday = new GregorianCalendar();
                birthday.setTime(((Date) birthdaySpinner.getValue()));

                String emailAddress = eMailField.getText();
                String password = new String (passwordField.getPassword());
                String telNumber = telField.getText();
                boolean pubConsent = pubAgree.isSelected();
                String sponsor = sponsorField.getText();
                Locality residence = (Locality) residenceBox.getSelectedItem();

                //vérifie les champs
                if(lastName.isEmpty() || lastName.isBlank())
                    throw new NullFieldException("last name");
                if(firstName.isEmpty() || firstName.isBlank())
                    throw new NullFieldException("first name");

                if(emailAddress.isEmpty())
                    throw new NullFieldException("email address");
                if(password.length() == 0)
                    throw new NullFieldException("password");
                //ajoute le user et le met dans le viewUtils
                User user = controller.addUser(lastName, firstName, birthday, emailAddress.toLowerCase(), password, telNumber, pubConsent, sponsor, residence);
                ViewUtils.connectUser(user);

            } catch (Exception exception) {
                ViewUtils.showException(exception);
            }
        }
    }
}