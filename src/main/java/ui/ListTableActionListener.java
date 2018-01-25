package ui;

import hello.AddressBook;

import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JTable;

public abstract class ListTableActionListener implements ActionListener {
    protected JTable table;
    protected AddressBook book;

    public void setList(AddressBook book) {
        this.book = book;
    }

    public void setTable(JTable itemTable) {
        this.table = itemTable;
    }
}

