package ViewPackage;

import ModelPackage.ResultSearchBikeInterval;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;

public class BikeHireModel extends AbstractTableModel {

    private ArrayList<String> columnNames;
    private ArrayList<ResultSearchBikeInterval> contents;

    public BikeHireModel(ArrayList<ResultSearchBikeInterval> contents){
        columnNames = new ArrayList<>();
        columnNames.add("Bike id");
        columnNames.add("Bike type");
        columnNames.add("Start station");
        columnNames.add("Start date");
        columnNames.add("User email");
        setContents(contents);
    }

    private void setContents(ArrayList<ResultSearchBikeInterval> contents) {
        this.contents = (ArrayList<ResultSearchBikeInterval>) contents.clone();
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

    @Override
    public Object getValueAt(int row, int column) {
        ResultSearchBikeInterval result = contents.get(row);
        switch(column){
            case 0: return result.getBike().getId();
            case 1: return result.getBike().getType();
            case 2: return result.getStartStationLabel();
            case 3: return result.getStartDate();
            case 4: return result.getUserEmail();
            default: return null;
        }
    }
}
