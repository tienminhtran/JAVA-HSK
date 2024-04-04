package demone;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

public class MainFrame extends JFrame {
    private JComboBox<String> bookComboBox;
    private JTable bookTable;
    private DefaultComboBoxModel<String> comboBoxModel;
    private DefaultTableModel tableModel;

    public MainFrame() {
        // Khởi tạo JComboBox và DefaultComboBoxModel
        bookComboBox = new JComboBox<String>();
        comboBoxModel = new DefaultComboBoxModel<String>();
        bookComboBox.setModel(comboBoxModel);

        // Khởi tạo JTable và DefaultTableModel
        bookTable = new JTable();
        tableModel = new DefaultTableModel();
        bookTable.setModel(tableModel);
        tableModel.addColumn("Mã sách");
        tableModel.addColumn("Tên sách");
        tableModel.addRow(new Object[] { "1", "Sách 1" });
        tableModel.addRow(new Object[] { "2", "Sách 2" });
        tableModel.addRow(new Object[] { "3", "Sách 3" });

        // Thêm dữ liệu của cột "Mã sách" vào JComboBox
        for (int i = 0; i < tableModel.getRowCount(); i++) {
            comboBoxModel.addElement(tableModel.getValueAt(i, 0).toString());
        }

        // Lắng nghe sự kiện khi chọn một hàng trên bảng
        bookTable.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent event) {
                // Lấy giá trị của cột mã sách tương ứng với hàng đã chọn
                int selectedRow = bookTable.getSelectedRow();
                String bookCode = tableModel.getValueAt(selectedRow, 0).toString();

                // Set giá trị cho JComboBox
                bookComboBox.setSelectedItem(bookCode);
            }
        });

        // Thêm JTable vào JScrollPane
        JScrollPane scrollPane = new JScrollPane(bookTable);

        // Thêm JComboBox và JScrollPane vào JFrame
        this.add(bookComboBox);
        this.add(scrollPane);

        // Cài đặt kích thước và hiển thị JFrame
        this.setSize(400, 300);
        this.setLayout(null);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        new MainFrame();
    }
}
