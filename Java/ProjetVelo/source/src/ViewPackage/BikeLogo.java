package ViewPackage;

import javax.swing.*;
import java.awt.*;

public class BikeLogo extends JPanel {
    private ImageIcon bike;
    private JLabel label;

    public BikeLogo(){
        this.setBackground(ViewUtils.backGroundColor);
        this.setPreferredSize(new Dimension(400, 90));

        label = new JLabel();
        bike = new ImageIcon(getClass().getResource("../image/gif/bike_frame (1).gif"));
        label.setIcon(bike);
        this.add(label);
    }
    public void changeFrame(int frame){
        bike = new ImageIcon(getClass().getResource("../image/gif/bike_frame ("+ frame +").gif"));
        label.setIcon(bike);
    }
}
