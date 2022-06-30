package ViewPackage;

import ModelPackage.User;

import javax.swing.*;
import java.awt.*;

public final class ViewUtils {

    public static Color backGroundColor = new Color(51, 153, 255);
    public static int creationYears = 2012;
    public static MainWindow mainWindow;
    public static Container container;
    private static BikeLogo bikeLogo;
    public static String userState;
    public static User currentUser;
    public static String USER = "user";
    public static String ADMIN = "admin";
    public static String NOT_CONNECTED = "not connected";


    public ViewUtils(MainWindow mainWindow) {
        this.mainWindow = mainWindow;
        this.container = mainWindow.getContentPane();
        bikeLogo = new BikeLogo();
        new bikeLogoThread(bikeLogo).start();
        userState = NOT_CONNECTED;
        currentUser = null;
    }

    public static void changePanel(JPanel panel){
        container.removeAll();
        panel.add(bikeLogo, 0);
        container.add(panel, BorderLayout.CENTER);
        container.validate();
        container.repaint();
        container.setVisible(true);
    }

    public static void showException(Exception exception){
        JOptionPane.showMessageDialog (null ,exception.getMessage(), exception.getClass().getSimpleName(),JOptionPane.ERROR_MESSAGE );
    }
    public static void connectAdmin(){
        userState = ADMIN;
        changePanel(new ConnectedPanel());
        mainWindow.addMenuBar();
    }
    public static void connectUser(User user){
        userState = USER;
        currentUser = user;
        changePanel(new ConnectedPanel());
        mainWindow.addMenuBar();
    }
    public static void disconnectUser(){
        userState = NOT_CONNECTED;
        currentUser = null;
        changePanel(new HomePagePanel());
        mainWindow.deleteMenuBar();
    }
}
