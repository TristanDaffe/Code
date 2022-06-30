package ViewPackage;

import ModelPackage.User;

import javax.swing.table.AbstractTableModel;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class AllUserModel extends AbstractTableModel {
    private ArrayList<String> columnNames;
    private ArrayList<User> contents;

    public AllUserModel(ArrayList<User> contents){
        columnNames = new ArrayList<>();
        columnNames.add("Last Name");
        columnNames.add("First Name");
        columnNames.add("Email address");
        columnNames.add("Birthday");
        columnNames.add("Phone number");
        columnNames.add("Pub agreement");
        columnNames.add("Sponsor");
        setContents(contents);
    }
    public void setContents(ArrayList<User> contents){
        this.contents = (ArrayList<User>) contents.clone();
    }
    public int getColumnCount ( ) {
        return columnNames .size ( );
    }
    public int getRowCount ( ) {
        return contents .size ( );
    }
    public String getColumnName (int column ){
        return columnNames.get(column);
    }
    public User getUser(int row){
        return contents.get(row);
    }

    @Override
    public Object getValueAt(int row, int column) {
        User result = contents.get(row);
        switch(column){
            case 0: return result.getLastName();
            case 1: return result.getFirstName();
            case 2: return result.getEmailAddress();
            case 3:
                SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MMMM-YYYY");
                Date date = result.getBirthday().getTime();
                return dateFormat.format(date);
            case 4: return result.getPhoneNumber();
            case 5: return result.isAgreeReceivePub();
            case 6: return result.getSponsor();
            default: return null;
        }
    }
}
