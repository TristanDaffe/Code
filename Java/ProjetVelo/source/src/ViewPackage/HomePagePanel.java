package ViewPackage;

import ExceptionPackage.AccessException;

import javax.swing.*;

public class HomePagePanel extends JPanel {
    private JButton connectionButton;
    private JButton registerButton;

    public HomePagePanel() {
        //bouton pour une connection
        connectionButton = new JButton("connection");
        connectionButton.addActionListener(event -> {
            try {
                ViewUtils.changePanel(new ConnectionPanel());
            } catch (AccessException e) {
                ViewUtils.showException(e);
            }
        });

        //bouton pour une inscription
        registerButton = new JButton("register");
        registerButton.addActionListener(event -> {
            try {
                ViewUtils.changePanel(new RegisterPanel());
            } catch (Exception e) {
                ViewUtils.showException(e);
            }
        });

        this.setBackground(ViewUtils.backGroundColor);

        this.add(connectionButton);
        this.add(registerButton);
    }
}
