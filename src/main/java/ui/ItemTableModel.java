package ui;

import hello.AddressBook;
import hello.BuddyInfo;

import java.util.List;
import javax.swing.table.AbstractTableModel;

public class ItemTableModel extends AbstractTableModel {
    AddressBook addressBook;

    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }

    public int getColumnCount() {
        return 1;
    }

    public String getColumnName(int column) {
        return "Items";
    }

    public void setAddressBook(AddressBook addressBook) {
        this.addressBook = addressBook;
    }

    public int getRowCount() {
        return addressBook.size();
    }

    public void setValueAt(Object value, int rowIndex, int columnIndex) {

    }

    public Object getValueAt(int rowIndex, int columnIndex) {
        return addressBook.getBuddy(rowIndex);
    }
}
