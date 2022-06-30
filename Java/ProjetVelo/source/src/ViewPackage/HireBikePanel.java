package ViewPackage;

import ControllerPackage.ApplicationController;
import ModelPackage.Bike;
import ModelPackage.BikeType;
import ModelPackage.Station;

import javax.swing.*;
import java.awt.*;
import java.util.GregorianCalendar;

public class HireBikePanel extends JPanel {
    private ApplicationController controller;

    private JComboBox bikeTypesBox;
    private JLabel selectBikeTypeLabel;
    private JComboBox bikesBox;
    private JComboBox stationBox;
    private JLabel selectStationLabel;
    private JButton selectBikeButton;
    private HireForm form;
    private ButtonForm buttonForm;
    public HireBikePanel(){
        try {
            controller = new ApplicationController();
            this.setBackground(ViewUtils.backGroundColor);
            this.setPreferredSize(new Dimension(350, 700));

            form = new HireForm();
            buttonForm = new ButtonForm();

            selectBikeTypeLabel = new JLabel("Select the type :");
            bikeTypesBox = new JComboBox(controller.getAllBikeTypes().toArray());
            bikeTypesBox.addActionListener(e -> {
                try{
                    form.remove(bikesBox);
                    bikesBox = new JComboBox(controller.getAllBikesType((BikeType)bikeTypesBox.getSelectedItem()).toArray());
                    form.add(bikesBox, 2);
                    validate();
                    repaint();
                }
                catch (Exception ex){
                    ViewUtils.showException(ex);
                }
            });
            form.add(selectBikeTypeLabel);
            form.add(bikeTypesBox, BorderLayout.CENTER);

            bikesBox = new JComboBox(controller.getAllBikesType((BikeType)bikeTypesBox.getSelectedItem()).toArray());
            form.add(bikesBox);

            selectStationLabel = new JLabel("Select a station to pick the bike up : ");
            stationBox = new JComboBox(controller.getAllStation().toArray());
            form.add(selectStationLabel);
            form.add(stationBox);

            selectBikeButton = new JButton("select");
            selectBikeButton.addActionListener(e -> {
                try {
                    controller.addHire(ViewUtils.currentUser, (Bike) bikesBox.getSelectedItem(), new GregorianCalendar(), (Station) stationBox.getSelectedItem());
                    ViewUtils.changePanel(new HiringBikePanel());
                } catch (Exception ex) {
                    ViewUtils.showException(ex);
                }
            });
            buttonForm.add(selectBikeButton);

            add(form);
            add(buttonForm);
        }
        catch (Exception e) {
            ViewUtils.showException(e);
        }
    }
    private class HireForm extends JPanel{
        public HireForm(){
            setPreferredSize(new Dimension(350, 250));
            setLayout(new GridLayout(5, 1, 10, 10));
            setBackground(ViewUtils.backGroundColor);
        }
    }
    private class ButtonForm extends JPanel{
        public ButtonForm(){
            setPreferredSize(new Dimension(350, 50));
            setBackground(ViewUtils.backGroundColor);
        }
    }
}
