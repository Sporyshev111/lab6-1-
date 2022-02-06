package com.company;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;

public class CountryTableModel extends AbstractTableModel {
    private int columnCount = 4;
    private ArrayList<String[]> dataArrayList;

    public static final int COUNTRY_CASE = 0;
    public static final int CAPITAL_CASE = COUNTRY_CASE + 1;

    public CountryTableModel() {
        dataArrayList = new ArrayList<String[]>();
        for (int i = 0; i < dataArrayList.size(); i++) {
            dataArrayList.add(new String[getColumnCount()]);
        }
    }

    @Override
    public int getRowCount() {
        return dataArrayList.size();
    }

    @Override
    public int getColumnCount() {
        return columnCount;
    }

    @Override
    public String getColumnName(int columnIndex) {
        switch (columnIndex) {
            case COUNTRY_CASE:
                return "country";
            case CAPITAL_CASE:
                return "capital";
            case 2:
                return "population";
            case 3:
                return "stroy";

            default:
                throw new IllegalStateException("Unexpected value: " + columnIndex);
        }
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        String[] rows = dataArrayList.get(rowIndex);

        return rows[columnIndex];
    }

    public void addDate(String[] row) {
        String[] rowTable = new String[getColumnCount()];
        rowTable = row;
        dataArrayList.add(rowTable);
    }

}
