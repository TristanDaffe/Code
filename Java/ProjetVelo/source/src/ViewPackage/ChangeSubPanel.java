package ViewPackage;

import ControllerPackage.ApplicationController;
import ModelPackage.Subscription;

import javax.swing.*;
import java.awt.*;

public class ChangeSubPanel extends JPanel {
    private ApplicationController controller;
    JTextField currentSubscriptionField;
    private JComboBox subscriptionsBox;
    private JButton submit;
    private SelectForm form;
    private ButtonsPanel buttons;

    public ChangeSubPanel(){
        try {
            setBackground(ViewUtils.backGroundColor);

            controller = new ApplicationController();
            form = new SelectForm();
            buttons = new ButtonsPanel();

            currentSubscriptionField = new JTextField(controller.getSubscriptionType(ViewUtils.currentUser.getEmailAddress()).toString());
            form.add(currentSubscriptionField);

            subscriptionsBox = new JComboBox(controller.getAllSubscriptionType().toArray());
            form.add(subscriptionsBox);

            submit = new JButton("Submit");
            submit.addActionListener(e-> {
                try{
                    controller.changeSubscription(ViewUtils.currentUser.getEmailAddress(), (Subscription) subscriptionsBox.getSelectedItem());
                    ViewUtils.changePanel(new ConnectedPanel());
                }
                catch(Exception ex){
                    ViewUtils.showException(ex);
                }
            });
            buttons.add(submit);

            add(form);
            add(buttons);
        }
        catch (Exception e) {
            ViewUtils.showException(e);
        }
    }
    private class SelectForm extends JPanel{
        public SelectForm(){
            setPreferredSize(new Dimension(350, 200));
            setLayout(new GridLayout(5, 1, 10, 10));
            setBackground(ViewUtils.backGroundColor);
        }
    }
    public class ButtonsPanel extends JPanel{
        public ButtonsPanel (){
            this.setPreferredSize(new Dimension(350,100));
            this.setBackground(ViewUtils.backGroundColor);
            this.setLayout(new FlowLayout());
        }
    }
}
