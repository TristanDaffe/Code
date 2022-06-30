package ViewPackage;

import javax.swing.*;

public class ConnectedPanel extends JPanel {
    private JLabel welcomeMessage;

    public ConnectedPanel(){
        this.setBackground(ViewUtils.backGroundColor);
        this.setSize(100, 250);
        welcomeMessage = new JLabel("Welcome, you are connected as "+ ViewUtils.userState);
        welcomeMessage.setHorizontalAlignment(JLabel.CENTER);
        add(welcomeMessage);
    }
}
