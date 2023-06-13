package org.bookmanager.forms;

import javax.swing.*;

public class BookManagerFrame extends JFrame {
    public BookManagerFrame(String message){
        this.setTitle(message);
        this.setContentPane(mainPanel);
        this.setVisible(true);
    }
    private JLabel mainPanel;
    private JTextField textFieldBookCode;
    private JTextField textFieldBookName;
    private JTextField textFieldCategory;
    private JComboBox comboBoxPrice;
    private JButton buttonUpdate;
    private JButton buttonAddNew;
    private JButton buttonShowAll;
    private JButton buttonDelete;


}
