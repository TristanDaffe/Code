package ViewPackage;

import ControllerPackage.ApplicationController;
import ModelPackage.*;

import javax.swing.*;
import java.awt.*;
import java.util.GregorianCalendar;


import static javax.swing.SwingConstants.CENTER;

public class ReturnBikePanel extends JPanel {
    private ApplicationController controller;
    private JTextField bikeLabel;
    private Bike currentBike;
    private JLabel returnLabel;
    private JComboBox stationBox;
    private JButton returnButton;
    private ButtonForm buttonForm;
    private ReturnFrom form;
    public ReturnBikePanel(){
        try {
            controller = new ApplicationController();

            this.setBackground(ViewUtils.backGroundColor);
            this.setPreferredSize(new Dimension(275, 700));

            form = new ReturnFrom();
            buttonForm = new ButtonForm();

            currentBike = controller.getCurrentBike(ViewUtils.currentUser.getEmailAddress());
            bikeLabel = new JTextField(currentBike.toString());
            bikeLabel.setEditable(false);
            form.add(bikeLabel);

            returnLabel = new JLabel("Select a locality to return your bike : ", CENTER);
            stationBox = new JComboBox(controller.getAllStation().toArray());
            form.add(returnLabel);
            form.add(stationBox);

            returnButton = new JButton("return bike");
            returnButton.addActionListener(e -> {
                try {
                    controller.updateHire(ViewUtils.currentUser, currentBike, new GregorianCalendar(), (Station) stationBox.getSelectedItem());
                    ViewUtils.changePanel(new ReturnedBikePanel());
                } catch (Exception ex) {
                    ViewUtils.showException(ex);
                }
            });
            buttonForm.add(returnButton);

            add(form);
            add(buttonForm);
        } catch (Exception e) {
            ViewUtils.showException(e);
        }

    }
    private class ReturnFrom extends JPanel{
        public ReturnFrom(){
            this.setPreferredSize(new Dimension(275,100));
            this.setBackground(ViewUtils.backGroundColor);
            this.setLayout(new GridLayout(3,1,10,10));
        }
    }
    private class ButtonForm extends JPanel{
        public ButtonForm(){
            setPreferredSize(new Dimension(350, 50));
            setBackground(ViewUtils.backGroundColor);
        }
    }

}
