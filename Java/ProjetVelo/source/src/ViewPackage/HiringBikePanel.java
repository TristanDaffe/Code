package ViewPackage;

import javax.swing.*;

public class HiringBikePanel extends JPanel {
    private JLabel welcomeMessage;

    public HiringBikePanel(){
        this.setBackground(ViewUtils.backGroundColor);
        this.setSize(100, 250);
        welcomeMessage = new JLabel("You are hiring a bike");
        welcomeMessage.setHorizontalAlignment(JLabel.CENTER);
        add(welcomeMessage);
    }
}
