package ViewPackage;

import ModelPackage.ResultSearchBikeHistory;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;

public class BikeHistoryModel extends AbstractTableModel {
    private ArrayList<String> columnNames;
    private ArrayList<ResultSearchBikeHistory> contents;

    public BikeHistoryModel(ArrayList<ResultSearchBikeHistory> contents){
        columnNames = new ArrayList<>();
        columnNames.add("Last name");
        columnNames.add("First name");
        columnNames.add("Start date");
        columnNames.add("Start station");
        columnNames.add("End date");
        columnNames.add("End station");
        setContents(contents);
    }

    private void setContents(ArrayList<ResultSearchBikeHistory> contents) {
        this.contents = (ArrayList<ResultSearchBikeHistory>) contents.clone();
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
        ResultSearchBikeHistory result = contents.get(row);
        switch(column){
            case 0: return result.getUserName();
            case 1: return result.getUserFirstName();
            case 2: return result.getStartStation();
            case 3: return result.getStartDate();
            case 4: return result.getEndStation();
            case 5: return result.getEndDate();

            default: return null;
        }
    }
}
