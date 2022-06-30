package ViewPackage;

import ControllerPackage.ApplicationController;
import ExceptionPackage.AccessException;
import ExceptionPackage.IsHiringException;
import ExceptionPackage.IsNotHiringBike;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import static javax.swing.text.StyleConstants.setIcon;

public class MainWindow extends JFrame {

    private static int WIDHT = 450;
    private static int HEIGHT = 700;
    private Container mainContainer;
    private JMenuBar menuBar;
    private JMenu application;
    private JMenuItem exit;
    private ApplicationController controller;
    private Image image;
    public MainWindow(){
        super("main");

        //place au milieu de l ecran
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        setSize(WIDHT, HEIGHT);
        setLocationRelativeTo(null);

        image = new ImageIcon(getClass().getResource("../image/logo/logo.jpg")).getImage();
        setIconImage(image);

        setTitle("Bike app");

        mainContainer = this.getContentPane();
        new ViewUtils(this);
        try {
            controller = new ApplicationController();
        } catch (AccessException e) {
            ViewUtils.showException(e);
        }
        ViewUtils.changePanel(new HomePagePanel());

        menuBar = new JMenuBar();
        setJMenuBar(menuBar);

        application = new JMenu("Application");
        menuBar.add(application);
        exit = new JMenuItem("Exit");
        exit.addActionListener(e -> System.exit(0));
        application.add(exit);

        addWindowListener (new WindowAdapter() {
            public void windowClosing (WindowEvent e) {
                System.exit(0);
            }
        } );
        setVisible(true);
    }

    public void addMenuBar(){
        JMenu account;
        JMenuItem disconnect;


        //commun aux user et admin
        account = new JMenu("Account");
        menuBar.add(account);

        if(ViewUtils.userState == ViewUtils.USER){
            JMenuItem subscription = new JMenuItem("Subscription");
            subscription.addActionListener(e -> ViewUtils.changePanel(new ChangeSubPanel()));
            account.add(subscription);

            JMenu bike = new JMenu("Bike");
            menuBar.add(bike);
            JMenuItem hire = new JMenuItem("Hire");
            hire.addActionListener(e -> {
                if(!controller.isHiringBike(ViewUtils.currentUser.getEmailAddress()))
                    ViewUtils.changePanel(new HireBikePanel());
                else{
                    ViewUtils.showException(new IsHiringException());
                }
            });
            JMenuItem returnBike = new JMenuItem("Return");
            returnBike.addActionListener(e -> {
                if(controller.isHiringBike(ViewUtils.currentUser.getEmailAddress()))
                    ViewUtils.changePanel(new ReturnBikePanel());
                else{
                    ViewUtils.showException(new IsNotHiringBike());
                }
            });
            bike.add(hire);
            bike.add(returnBike);

            JMenuItem profil = new JMenuItem("Profil");
            profil.addActionListener(event -> {
                ViewUtils.changePanel(new UserProfilePanel(ViewUtils.currentUser));
            });
            account.add(profil);
        }
        else {
            //check comme sécurité
            if (ViewUtils.userState == ViewUtils.ADMIN) {
                JMenu searchMenu = new JMenu("Search");
                JMenuItem searchBikeIntervale = new JMenuItem("Search bike interval");
                searchBikeIntervale.addActionListener(e -> ViewUtils.changePanel(new SearchBikePanel()));

                JMenuItem searchModif = new JMenuItem("Search modification");
                searchModif.addActionListener(e -> ViewUtils.changePanel(new SearchModifOnBikeType()));

                JMenuItem searchBikeHistory = new JMenuItem("Search bike history");
                searchBikeHistory.addActionListener(e -> ViewUtils.changePanel(new SearchBikeHistory()));

                JMenu crudMenu = new JMenu("C.R.U.D");
                JMenuItem updateUser = new JMenuItem("Delete user");
                updateUser.addActionListener(e -> ViewUtils.changePanel(new DeleteUserPanel()));

                searchMenu.add(searchBikeIntervale);
                searchMenu.add(searchModif);
                searchMenu.add(searchBikeHistory);

                crudMenu.add(updateUser);

                menuBar.add(searchMenu);
                menuBar.add(crudMenu);
            }
        }

        disconnect = new JMenuItem("Disconnect");
        disconnect.addActionListener(event -> ViewUtils.disconnectUser());
        account.add(disconnect);
        menuBar.setVisible(true);
        menuBar.validate();
        repaint();
    }
    public void deleteMenuBar(){
        menuBar.removeAll();
        menuBar.add(application);
        repaint();
    }
}
