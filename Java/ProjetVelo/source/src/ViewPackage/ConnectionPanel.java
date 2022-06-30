package ViewPackage;

import ControllerPackage.*;
import ExceptionPackage.*;
import ModelPackage.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static javax.swing.SwingConstants.CENTER;

public class ConnectionPanel extends JPanel {
    private ApplicationController controller;
    private FormPanel form;
    private ButtonsPanel buttons;
    private JLabel eMailLabel, passwordLabel;
    private JTextField eMailField;
    private JPasswordField passwordField;
    private JButton connectionButton;
    private JButton backButton;

    public ConnectionPanel() throws AccessException {
        this.setBackground(ViewUtils.backGroundColor);
        setController(new ApplicationController());
        form = new FormPanel();
        buttons = new ButtonsPanel();

        eMailLabel = new JLabel("email :", CENTER);
        form.add(eMailLabel);
        eMailField = new JTextField();
        form.add(eMailField);

        passwordLabel = new JLabel("Password :", CENTER);
        form.add(passwordLabel);
        passwordField = new JPasswordField();
        form.add(passwordField);

        backButton = new JButton("Back");
        backButton.addActionListener(event -> ViewUtils.changePanel(new HomePagePanel()));
        buttons.add(backButton);

        connectionButton = new JButton("Connect");
        connectionButton.addActionListener(new ConnectionButton());
        buttons.add(connectionButton);

        this.add(form, BorderLayout.CENTER);
        this.add(buttons, BorderLayout.SOUTH);
    }

    public void setController(ApplicationController controller) {
        this.controller = controller;
    }

    public class FormPanel extends JPanel{
        public FormPanel (){
            this.setPreferredSize(new Dimension(300,75));
            this.setBackground(ViewUtils.backGroundColor);
            this.setLayout(new GridLayout(2,2,0,3));
        }
    }
    public class ButtonsPanel extends JPanel{
        public ButtonsPanel (){
            this.setBackground(ViewUtils.backGroundColor);
            this.setLayout(new FlowLayout());
        }
    }
    public class ConnectionButton implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String email = eMailField.getText();
            String password = new String(passwordField.getPassword());

            try {
                String userType = controller.connectUser(email, password);
                if(userType == "admin"){
                    ViewUtils.connectAdmin();
                }
                else{
                    User user = controller.getUser(email);
                    ViewUtils.connectUser(user);
                }
            } catch (Exception exception) {
                ViewUtils.showException(new UserConnectionException());
            }
        }
    }
}