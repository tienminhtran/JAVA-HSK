package demo_1;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellEditor;
import java.awt.*;

public class JTableGenderComboBoxExample {
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        String[] genders = {"Male", "Female"};

        DefaultTableModel model = new DefaultTableModel(
                new Object[][]{{"John", 25, "Male"}, {"Mary", 30, "Female"}, {"Bob", 35, "Male"}},
                new Object[]{"Name", "Age", "Gender"}) {
            @Override
            public Class<?> getColumnClass(int columnIndex) {
                if (columnIndex == 2) {
                    return JComboBox.class;
                } else {
                    return Object.class;
                }
            }
        };

        JTable table = new JTable(model);
        table.getColumnModel().getColumn(2).setCellEditor(new DefaultCellEditor(new JComboBox<>(genders)));

        JScrollPane scrollPane = new JScrollPane(table);
        JPanel panel = new JPanel(new BorderLayout());
        panel.add(scrollPane, BorderLayout.CENTER);

        frame.add(panel);
        frame.pack();
        frame.setVisible(true);
    }
}

