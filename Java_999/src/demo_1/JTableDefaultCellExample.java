package demo_1;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JTableDefaultCellExample extends JFrame {

    private JTable table;
    private DefaultTableModel model;

    public JTableDefaultCellExample() {
        super("JTable Default Cell Example");

        // Khởi tạo JTable với 3 cột
        model = new DefaultTableModel();
        model.addColumn("Name");
        model.addColumn("Age");
        model.addColumn("Gender");

        // Thêm dữ liệu vào JTable
        model.addRow(new Object[]{"John", 25, "Male"});
        model.addRow(new Object[]{"Mary", 30, "Female"});
        model.addRow(new Object[]{"Bob", 35, "Male"});

        // Thiết lập model cho JTable
        table = new JTable(model);

        // Thiết lập Renderer cho cột giới tính
        table.getColumnModel().getColumn(2).setCellRenderer(new GenderRenderer());

        // Tạo JPopupMenu
        JPopupMenu popupMenu = new JPopupMenu();

        // Tạo JMenuItem cho Nam
        JMenuItem maleItem = new JMenuItem("Nam");
        maleItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Lấy chỉ số của hàng đang được chọn
                int row = table.getSelectedRow();
                // Thiết lập giá trị cho ô tại cột giới tính của hàng đó là "Nam"
                model.setValueAt("Nam", row, 2);
            }
        });
        popupMenu.add(maleItem);

        // Tạo JMenuItem cho Nữ
        JMenuItem femaleItem = new JMenuItem("Nữ");
        femaleItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Lấy chỉ số của hàng đang được chọn
                int row = table.getSelectedRow();
                // Thiết lập giá trị cho ô tại cột giới tính của hàng đó là "Nữ"
                model.setValueAt("Nữ", row, 2);
            }
        });
        popupMenu.add(femaleItem);

        // Thiết lập JPopupMenu cho JTable
        table.setComponentPopupMenu(popupMenu);

        // Tạo JScrollPane chứa JTable
        JScrollPane scrollPane = new JScrollPane(table);

        // Thiết lập kích thước và vị trí của JFrame
        setPreferredSize(new Dimension(400, 300));
        setLocationRelativeTo(null);

        // Thêm JScrollPane vào JFrame
        add(scrollPane);

        // Hiển thị JFrame
        pack();
        setVisible(true);
    }

    // Renderer cho cột giới tính
    class GenderRenderer extends JLabel implements TableCellRenderer {

        public GenderRenderer() {
            setOpaque(true);
            setHorizontalAlignment(JLabel.CENTER);
        }

        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            setText(value.toString());
            setBackground(table.getSelectionBackground());
            setForeground(table.getSelectionForeground());

            // Nếu giá trị của ô là "Nam", đặt màu nền là xanh
            if (value.toString().equals("Nam
                    setBackground(table.getSelectionBackground());
                    setForeground(table.getSelectionForeground());

                    // Nếu giá trị của ô là "Nam", đặt màu nền là xanh
                    if (value.toString().equals("Nam")) {
                        setBackground(Color.BLUE);
                    }

                    // Nếu giá trị của ô là "Nữ", đặt màu nền là hồng
                    if (value.toString().equals("Nữ")) {
                        setBackground(Color.PINK);
                    }

                    return this;
                }
            }

            public static void main(String[] args) {
                new JTableDefaultCellExample();
            }
        }
