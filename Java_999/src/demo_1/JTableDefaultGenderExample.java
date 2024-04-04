package demo_1;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JTableDefaultGenderExample {
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        DefaultTableModel model = new DefaultTableModel(
                new Object[][]{{"John", 25, "Male"}, {"Mary", 30, "Female"}, {"Bob", 35, "Male"}},
                new Object[]{"Name", "Age", "Gender"});

        JTable table = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(table);
        JPanel panel = new JPanel(new BorderLayout());
        panel.add(scrollPane, BorderLayout.CENTER);

        JMenu editMenu = new JMenu("Edit");
        JMenuItem setMaleItem = new JMenuItem("Set Male");
        setMaleItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int row = table.getSelectedRow();
                int col = table.getColumnModel().getColumnIndex("Gender");
                if (row >= 0 && col >= 0) {
                    model.setValueAt("Male", row, col);
                }
            }
        });
        JMenuItem setFemaleItem = new JMenuItem("Set Female");
        setFemaleItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int row = table.getSelectedRow();
                int col = table.getColumnModel().getColumnIndex("Gender");
                if (row >= 0 && col >= 0) {
                    model.setValueAt("Female", row, col);
                }
            }
        });
        editMenu.add(setMaleItem);
        editMenu.add(setFemaleItem);

        JMenuBar menuBar = new JMenuBar();
        menuBar.add(editMenu);
        frame.setJMenuBar(menuBar);

        frame.add(panel);
        frame.pack();
        frame.setVisible(true);
    }
}

