package ViewPackage;

import javax.swing.*;

public class ReturnedBikePanel extends JPanel {
    private JLabel welcomeMessage;

    public ReturnedBikePanel(){
        this.setBackground(ViewUtils.backGroundColor);
        this.setSize(100, 250);
        welcomeMessage = new JLabel("Thank you for returning the bike. See you soon!");
        welcomeMessage.setHorizontalAlignment(JLabel.CENTER);
        add(welcomeMessage);
    }
}
