package ui;

import hello.BuddyInfo;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class AddNewButtonActionListener extends ListTableActionListener {
    public void actionPerformed(ActionEvent e) {
        String name = JOptionPane.showInputDialog("Enter name:");
        String number = JOptionPane.showInputDialog("Enter number:");

        book.addBuddy(new BuddyInfo(name, number));
        table.revalidate();
    }
}
