package ViewPackage;

import ControllerPackage.ApplicationController;
import ModelPackage.BikeType;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class SearchModifOnBikeType extends JPanel {
        private ApplicationController controller;
            private JLabel selectTypeLabel;
            private JComboBox bikeTypeBox;
            private JButton submitButton;
            private JTable resultTable;
            private JScrollPane resultScrollPanel;

            private SelectForm selectForm;
            private ButtonForm buttonForm;

    public SearchModifOnBikeType() {
                try{
                    this.setBackground(ViewUtils.backGroundColor);
                    this.setPreferredSize(new Dimension(350, 700));

                    controller = new ApplicationController();

                    selectForm = new SelectForm();
                    buttonForm = new ButtonForm();
                    resultTable = new JTable();

                    resultScrollPanel = new JScrollPane(resultTable);
                    resultScrollPanel.setPreferredSize(new Dimension(350, 300));

                    selectTypeLabel = new JLabel("Select the type :");
                    bikeTypeBox = new JComboBox(controller.getAllBikeTypes().toArray());
                    selectForm.add(selectTypeLabel);
                    selectForm.add(bikeTypeBox);

                    submitButton = new JButton("Submit");
                    submitButton.addActionListener(new SearchButton());
                    buttonForm.add(submitButton);

                    add(selectForm);
                    add(buttonForm);
        }
        catch(Exception e){
            ViewUtils.showException(e);
        }
    }
    private class SelectForm extends JPanel{
        public SelectForm() {
            this.setBackground(ViewUtils.backGroundColor);
            this.setPreferredSize(new Dimension(350,50));
        }
    }
    private class ButtonForm extends JPanel{
        public ButtonForm() {
            this.setBackground(ViewUtils.backGroundColor);
            this.setPreferredSize(new Dimension(350,50));
        }
    }

    public class SearchButton implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            try {
                BikeType type = (BikeType) bikeTypeBox.getSelectedItem();
                BikeTypeModifModel result = new BikeTypeModifModel(controller.getAllModifOnType(type));

                resultScrollPanel.removeAll();
                remove(resultScrollPanel);

                resultTable = new JTable(result);
                resultTable.getColumnModel().getColumn(0).setMinWidth(50);
                resultTable.getColumnModel().getColumn(1).setMinWidth(150);
                resultTable.getColumnModel().getColumn(2).setMinWidth(100);

                resultTable.setAutoResizeMode( JTable.AUTO_RESIZE_OFF );
                resultTable.setSelectionMode( ListSelectionModel.SINGLE_SELECTION);
                resultTable.getTableHeader().setReorderingAllowed(false);

                resultScrollPanel = new JScrollPane(resultTable);
                resultScrollPanel.setPreferredSize(new Dimension(300, 200));

                add(resultScrollPanel);
                validate();
                repaint();
            } catch (Exception exception) {
                ViewUtils.showException(exception);
            }
        }
    }
}
