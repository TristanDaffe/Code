package ViewPackage;

import ControllerPackage.ApplicationController;
import ExceptionPackage.UpdateFielExcpetion;
import ModelPackage.User;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class DeleteUserConfirmationPanel extends JPanel {
    private ApplicationController controller;
    private AllUserModel allUser;
    private JTable resultTable;
    private JScrollPane scrollPane;
    private JButton submitButton;
    private JButton cancelButton;
    private ButtonForm buttonForm;

    public DeleteUserConfirmationPanel( ArrayList<User> usersToDelete) {
        try{
            controller = new ApplicationController();

            this.setBackground(ViewUtils.backGroundColor);
            this.setPreferredSize(new Dimension(350, 700));

            allUser = new AllUserModel(usersToDelete);
            resultTable = new JTable(allUser);
            buttonForm = new ButtonForm();

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

            submitButton = new JButton("Submit");
            submitButton.addActionListener(e ->{
                   ArrayList<String> usersEmailToDelete = new ArrayList<>();
                   for(int i = 0; i < allUser.getRowCount(); i++) {
                       usersEmailToDelete.add(allUser.getUser(i).getEmailAddress());
                   }
                   try {
                       controller.deleteUserList(usersEmailToDelete);
                       ViewUtils.changePanel(new DeleteUserPanel());
                   } catch (UpdateFielExcpetion ex) {
                       ViewUtils.showException(ex);
                   }
            });
            buttonForm.add(submitButton);

            cancelButton = new JButton("Cancel");
            cancelButton.addActionListener(e -> ViewUtils.changePanel(new DeleteUserPanel()));
            buttonForm.add(cancelButton);

            add(scrollPane);
            add(buttonForm);
        }
        catch (Exception e){
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
