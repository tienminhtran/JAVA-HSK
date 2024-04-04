package gui;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class frm_ThongKe extends JPanel {
	private JTable table;
	private DefaultTableModel tableModel;
	private JTextField txtTim;
	private JTextField btnTong;

	/**
	 * Create the panel.
	 */
	public frm_ThongKe() {
		setBackground(new Color(192, 192, 192));
		setLayout(null);
		
		JPanel panelHoaDon = new JPanel();
		panelHoaDon.setBackground(new Color(0, 128, 0));
		panelHoaDon.setBounds(0, 0, 917, 47);
		add(panelHoaDon);
		panelHoaDon.setLayout(null);
		
		JLabel lbThongKe = new JLabel("Thống kê doanh thu");
		lbThongKe.setIcon(new ImageIcon("D:\\Nhom01_QuanLyCuaHangMuaBanLinhKien\\QuanLyLinhKien\\src\\images_menu\\huydathang.png"));
		lbThongKe.setForeground(new Color(255, 255, 255));
		lbThongKe.setFont(new Font("Arial", Font.BOLD, 25));
		lbThongKe.setHorizontalAlignment(SwingConstants.CENTER);
		lbThongKe.setBounds(241, 0, 452, 47);
		panelHoaDon.add(lbThongKe);
		
		JLabel lbTimKiem = new JLabel("Tìm kiếm linh kiện:");
		lbTimKiem.setIcon(new ImageIcon("D:\\Nhom01_QuanLyCuaHangMuaBanLinhKien\\QLLK\\src\\images_menu\\search11.png"));
		lbTimKiem.setFont(new Font("Arial", Font.BOLD, 15));
		lbTimKiem.setBounds(10, 57, 245, 29);
		add(lbTimKiem);
		
		
		
		
		table = new JTable();
		table.setFont(new Font("Arial", Font.PLAIN, 12));
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"STT", "M\u00E3 linh ki\u1EC7n", "T\u00EAn linh ki\u1EC7n", "N\u0103m", "S\u1ED1 l\u01B0\u1EE3ng b\u00E1n", "T\u1ED5ng doanh thu"
			}
		));
		
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(10, 125, 897, 426);
		add(scrollPane);
		
		JButton btnFirst = new JButton("<<");
		btnFirst.setForeground(Color.WHITE);
		btnFirst.setFont(new Font("Arial", Font.PLAIN, 10));
		btnFirst.setBackground(Color.GRAY);
		btnFirst.setBounds(10, 561, 47, 21);
		add(btnFirst);
		
		JButton btnBack = new JButton("<");
		btnBack.setForeground(Color.WHITE);
		btnBack.setFont(new Font("Arial", Font.PLAIN, 10));
		btnBack.setBackground(Color.GRAY);
		btnBack.setBounds(67, 561, 47, 21);
		add(btnBack);
		
		JButton btnNext = new JButton(">");
		btnNext.setForeground(Color.WHITE);
		btnNext.setFont(new Font("Arial", Font.PLAIN, 10));
		btnNext.setBackground(Color.GRAY);
		btnNext.setBounds(125, 561, 47, 21);
		add(btnNext);
		
		JButton btnLast = new JButton(">>");
		btnLast.setForeground(Color.WHITE);
		btnLast.setFont(new Font("Arial", Font.PLAIN, 10));
		btnLast.setBackground(Color.GRAY);
		btnLast.setBounds(182, 561, 47, 21);
		add(btnLast);
		
		JButton btnTim = new JButton("Tìm");
		btnTim.setForeground(Color.WHITE);
		btnTim.setFont(new Font("Arial", Font.BOLD, 15));
		btnTim.setBackground(new Color(0, 128, 255));
		btnTim.setBounds(437, 57, 85, 26);
		add(btnTim);
		
		txtTim = new JTextField();
		txtTim.setFont(new Font("Arial", Font.PLAIN, 10));
		txtTim.setColumns(10);
		txtTim.setBounds(195, 57, 233, 25);
		add(txtTim);
		
		JLabel btnTongDoanhThu = new JLabel("Tổng doanh thu: ");
		btnTongDoanhThu.setFont(new Font("Arial", Font.BOLD, 15));
		btnTongDoanhThu.setBounds(10, 606, 135, 29);
		add(btnTongDoanhThu);
		
		btnTong = new JTextField();
		btnTong.setFont(new Font("Arial", Font.PLAIN, 10));
		btnTong.setColumns(10);
		btnTong.setBounds(137, 609, 233, 25);
		add(btnTong);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setFont(new Font("Arial", Font.PLAIN, 15));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Năm", "Tháng"}));
		comboBox.setBounds(380, 609, 72, 25);
		add(comboBox);
		btnFirst.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				table.setRowSelectionInterval(0, 0);
			}
		});
		btnLast.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int row = table.getRowCount() - 1;
				table.setRowSelectionInterval(row, row);
			}
		});
		btnNext.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int row = table.getSelectedRow();
				if(row < table.getRowCount() - 1)
					table.setRowSelectionInterval(row + 1, row + 1);
			}
		});
		btnBack.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int row = table.getSelectedRow();
				if(row > 0)
					table.setRowSelectionInterval(row - 1, row - 1);
				
			}
		});
	}
}
