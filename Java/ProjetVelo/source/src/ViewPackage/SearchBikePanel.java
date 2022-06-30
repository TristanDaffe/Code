package ViewPackage;

import ControllerPackage.ApplicationController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.util.GregorianCalendar;


public class SearchBikePanel extends JPanel {
    private ApplicationController controller;

    private JLabel  startDateLabel;
    private JSpinner startDateSpinner;
    private JLabel  endDateLabel;
    private JSpinner endDateSpinner;
    private JSpinner.DateEditor editor;
    private JSpinner.DateEditor editor2;
    private JButton submitButton;
    private FormPanel form;
    private ButtonPanel buttons;
    private ResultPanel resultPanel;
    private JTable resultTable;
    private JScrollPane resultScrollPanel;

    public SearchBikePanel(){
        try{
            controller = new ApplicationController();
            this.setBackground(ViewUtils.backGroundColor);
            this.setPreferredSize(new Dimension(350, 700));

            form = new FormPanel();
            buttons = new ButtonPanel();
            resultPanel = new ResultPanel();
            resultTable = new JTable();


            resultScrollPanel = new JScrollPane(resultPanel);
            resultScrollPanel.setPreferredSize(new Dimension(400, 300));

            startDateLabel = new JLabel("Select the starting date :");
            startDateSpinner = new JSpinner(new SpinnerDateModel());
            editor = new JSpinner.DateEditor(startDateSpinner, "dd-MMMM-yyyy");
            startDateSpinner.setEditor(editor);
            startDateSpinner.setValue(new GregorianCalendar().getTime());

            endDateLabel = new JLabel("Select the ending date :");
            endDateSpinner = new JSpinner(new SpinnerDateModel());
            editor2 = new JSpinner.DateEditor(endDateSpinner, "dd-MMMM-yyyy");
            endDateSpinner.setEditor(editor2);
            endDateSpinner.setValue(new GregorianCalendar().getTime());

            form.add(startDateLabel);
            form.add(startDateSpinner);
            form.add(endDateLabel);
            form.add(endDateSpinner);

            submitButton = new JButton("Submit");
            submitButton.addActionListener(new SearchButton());
            buttons.add(submitButton);

            add(form);
            add(buttons);
            add(resultScrollPanel);
        }
        catch (Exception e){
            ViewUtils.showException(e);
        }
    }
    public class FormPanel extends JPanel{
        public FormPanel (){
            this.setPreferredSize(new Dimension(350,150));
            this.setBackground(ViewUtils.backGroundColor);
            this.setLayout(new GridLayout(4,2,10,3));
        }
    }
    public class ButtonPanel extends JPanel{
        public ButtonPanel (){
            this.setPreferredSize(new Dimension(350,50));
            this.setBackground(ViewUtils.backGroundColor);
        }
    }
    public class ResultPanel extends JPanel{
        public ResultPanel (){
            this.setPreferredSize(new Dimension(500,150));
            this.setBackground(ViewUtils.backGroundColor);
        }
    }

    public class SearchButton implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            try {
                GregorianCalendar startDate = new GregorianCalendar();
                startDate.setTime(((Date) startDateSpinner.getValue()));

                GregorianCalendar endDate = new GregorianCalendar();
                endDate.setTime(((Date) endDateSpinner.getValue()));

                BikeHireModel table = new BikeHireModel(controller.getBikeInIntervalleForUser(startDate, endDate));

                resultScrollPanel.removeAll();
                remove(resultScrollPanel);

                resultTable = new JTable(table);
                resultTable.getColumnModel().getColumn(0).setMaxWidth(50);
                resultTable.getColumnModel().getColumn(1).setMaxWidth(75);
                resultTable.getColumnModel().getColumn(2).setMinWidth(100);
                resultTable.getColumnModel().getColumn(3).setMinWidth(100);
                resultTable.getColumnModel().getColumn(4).setMinWidth(150);

                resultTable.setAutoResizeMode( JTable.AUTO_RESIZE_OFF );
                resultTable.setSelectionMode( ListSelectionModel.SINGLE_SELECTION);
                resultTable.getTableHeader().setReorderingAllowed(false);

                resultScrollPanel = new JScrollPane(new ResultPanel().add(resultTable));
                resultScrollPanel.setPreferredSize(new Dimension(425, 300));

                add(resultScrollPanel);
                validate();
                repaint();
            } catch (Exception exception) {
                ViewUtils.showException(exception);
            }
        }
    }
}
