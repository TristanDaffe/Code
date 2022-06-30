package ViewPackage;

import ControllerPackage.ApplicationController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SearchBikeHistory extends JPanel {
    private ApplicationController controller;
    private JLabel selectBikeIdLabel;
    private JComboBox bikeIdBox;
    private JButton submitButton;
    private JTable resultTable;
    private JScrollPane resultScrollPanel;

    private SelectForm selectForm;
    private ButtonForm buttonForm;

    public SearchBikeHistory() {
        try{
            this.setBackground(ViewUtils.backGroundColor);
            this.setPreferredSize(new Dimension(350, 700));

            controller = new ApplicationController();

            selectForm = new SelectForm();
            buttonForm = new ButtonForm();
            resultTable = new JTable();

            resultScrollPanel = new JScrollPane(resultTable);
            resultScrollPanel.setPreferredSize(new Dimension(350, 300));

            resultScrollPanel = new JScrollPane(resultTable);
            resultScrollPanel.setPreferredSize(new Dimension(350, 300));

            selectBikeIdLabel = new JLabel("Select the bike :");
            bikeIdBox = new JComboBox(controller.getAllBikeId());
            selectForm.add(selectBikeIdLabel);
            selectForm.add(bikeIdBox);

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
                int type = Integer.parseInt((String) bikeIdBox.getSelectedItem());

                BikeHistoryModel result = new BikeHistoryModel(controller.getBikeHistory(type));

                resultScrollPanel.removeAll();
                remove(resultScrollPanel);

                resultTable = new JTable(result);
                resultTable.getColumnModel().getColumn(0).setMinWidth(100);
                resultTable.getColumnModel().getColumn(1).setMinWidth(100);
                resultTable.getColumnModel().getColumn(2).setMinWidth(100);
                resultTable.getColumnModel().getColumn(3).setMinWidth(150);
                resultTable.getColumnModel().getColumn(4).setMinWidth(100);
                resultTable.getColumnModel().getColumn(5).setMinWidth(150);

                resultTable.setAutoResizeMode( JTable.AUTO_RESIZE_OFF );
                resultTable.setSelectionMode( ListSelectionModel.SINGLE_SELECTION);
                resultTable.getTableHeader().setReorderingAllowed(false);

                resultScrollPanel = new JScrollPane(resultTable);
                resultScrollPanel.setPreferredSize(new Dimension(400, 400));

                add(resultScrollPanel);
                validate();
                repaint();
            } catch (Exception exception) {
                ViewUtils.showException(exception);
            }
        }
    }
}
