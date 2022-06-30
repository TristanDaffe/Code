package ViewPackage;

import ControllerPackage.ApplicationController;
import ModelPackage.User;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class DeleteUserPanel extends JPanel {
    private ApplicationController controller;
    private AllUserModel allUser;
    private JTable resultTable;
    private JScrollPane scrollPane;
    private JButton deleteButton;

    private ButtonForm buttonForm;
    public DeleteUserPanel() {
        try {
            controller = new ApplicationController();

            this.setBackground(ViewUtils.backGroundColor);
            this.setPreferredSize(new Dimension(350, 700));

            buttonForm = new ButtonForm();

            allUser = new AllUserModel(controller.getAllUser());
            resultTable = new JTable(allUser);

            resultTable.getColumnModel().getColumn(0).setMinWidth(100);
            resultTable.getColumnModel().getColumn(1).setMinWidth(100);
            resultTable.getColumnModel().getColumn(2).setMinWidth(150);
            resultTable.getColumnModel().getColumn(3).setMinWidth(150);
            resultTable.getColumnModel().getColumn(4).setMinWidth(100);
            resultTable.getColumnModel().getColumn(5).setMinWidth(75);
            resultTable.getColumnModel().getColumn(6).setMinWidth(150);
            resultTable.setAutoResizeMode( JTable.AUTO_RESIZE_OFF );
            resultTable.setSelectionMode( ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);

            scrollPane = new JScrollPane(resultTable);
            scrollPane.setPreferredSize(new Dimension(400, 400));

            deleteButton = new JButton("Delete selection");
            deleteButton.addActionListener(e ->{
                ArrayList<User> usersToDelete = new ArrayList<>();
                int[] selectedBox = resultTable.getSelectedRows();
                for(int i = 0; i < selectedBox.length; i++) {
                    usersToDelete.add(allUser.getUser(selectedBox[i]));
                }
                if(!usersToDelete.isEmpty())
                    ViewUtils.changePanel(new DeleteUserConfirmationPanel(usersToDelete));
            });
            buttonForm.add(deleteButton);

            add(scrollPane);
            add(buttonForm);
        } catch (Exception e) {
            ViewUtils.showException(e);
        }
    }

    private class ButtonForm extends JPanel{
        public ButtonForm() {
            this.setBackground(ViewUtils.backGroundColor);
            this.setPreferredSize(new Dimension(350,50));
        }
    }
}