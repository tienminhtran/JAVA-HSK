import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

public class JTableComboBoxExample {

    public static void main(String[] args) {

        // Khởi tạo JTable với 3 cột
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Name");
        model.addColumn("Age");
        model.addColumn("Gender");

        // Thêm dữ liệu vào JTable
        model.addRow(new Object[]{"John", 25, "Male"});
        model.addRow(new Object[]{"Mary", 30, "Female"});
        model.addRow(new Object[]{"Bob", 35, "Male"});

        // Tạo đối tượng JComboBox và thêm các giá trị "Male" và "Female" vào nó
        JComboBox<String> comboBox = new JComboBox<String>();
        comboBox.addItem("Male");
        comboBox.addItem("Female");

        // Thiết lập kiểu JCombobox cho cột giới tính của JTable
        TableColumn genderColumn = table.getColumnModel().getColumn(2);
        genderColumn.setCellEditor(new DefaultCellEditor(comboBox));

        // Tạo đối tượng JTable từ model
        JTable table = new JTable(model);

        // Tạo một JScrollPane chứa JTable
        JScrollPane scrollPane = new JScrollPane(table);

        // Tạo JFrame và thêm JScrollPane vào nó
        JFrame frame = new JFrame();
        frame.add(scrollPane);

        // Thiết lập kích thước, vị trí và hiển thị JFrame
        frame.setSize(400, 300);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
