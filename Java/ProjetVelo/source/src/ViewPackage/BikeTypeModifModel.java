package ViewPackage;

import ModelPackage.ResultSearchModifBiketype;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;

public class BikeTypeModifModel extends AbstractTableModel {
    private ArrayList<String> columnNames;
    private ArrayList<ResultSearchModifBiketype> contents;

    public BikeTypeModifModel(ArrayList<ResultSearchModifBiketype> contents){
        columnNames = new ArrayList<>();
        columnNames.add("Bike id");
        columnNames.add("Date of the change");
        columnNames.add("Name of the admin");
        setContents(contents);

    }

    private void setContents(ArrayList<ResultSearchModifBiketype> contents) {
        this.contents = (ArrayList<ResultSearchModifBiketype>) contents.clone();
    }

    public
    int getColumnCount ( ) {
        return columnNames .size ( );
    }
    public int getRowCount ( ) {
        return contents .size ( );
    }
    public String getColumnName (int column ){
        return columnNames.get(column);
    }

    @Override
    public Object getValueAt(int row, int column) {
        ResultSearchModifBiketype result = contents.get(row);
        switch(column){
            case 0: return result.getBikeId();
            case 1: return result.getDateChange();
            case 2: return result.getAdmin();

            default: return null;
        }
    }
}
