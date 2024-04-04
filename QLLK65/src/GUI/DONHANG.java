package GUI;

import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.MatteBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DONHANG extends JPanel {
	private JTable table;
	private DefaultTableModel tableModel;
	private JTextField textField;
	/**
	 * Create the panel.
	 */
	public DONHANG() {
		setBackground(new Color(0, 255, 255));
		setLayout(null);



		JPanel panel = new JPanel();
		panel.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		panel.setBackground(new Color(0, 255, 255));
		panel.setBounds(0, 0, 939, 556);
		add(panel);
		panel.setLayout(null);

		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
			},
			new String[] {
				"M\u00E3 h\u00F3a \u0111\u01A1n", "M\u00E3 nh\u00E2n vi\u00EAn", "T\u00EAn s\u1EA3n ph\u1EA9m", "M\u00E3 kh\u00E1ch h\u00E0ng", "T\u00EAn kh\u00E1ch h\u00E0ng", "Ng\u00E0y l\u1EADp h\u00F3a \u0111\u01A1n", "T\u1ED5ng ti\u1EC1n"
			}
		));

		table.setFont(new Font("Arial", Font.PLAIN, 12));
		table.setBounds(0, 0, 1, 1);
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(0, 46, 937, 445);
		panel.add(scrollPane);

		JButton btnNewButton_tim = new JButton("Tìm kiếm");
		btnNewButton_tim.setIcon(new ImageIcon("D:\\BAI_TAP_JAVA\\QLLK_NEW\\src\\img\\Search-icon.png"));
		btnNewButton_tim.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnNewButton_tim.setBackground(new Color(255, 182, 193));
		btnNewButton_tim.setBounds(319, 503, 135, 42);
		panel.add(btnNewButton_tim);

		JLabel lblNewLabel = new JLabel("Tìm kiếm hóa đơn:");
		lblNewLabel.setBounds(24, 510, 110, 28);
		panel.add(lblNewLabel);

		textField = new JTextField();
		textField.setBounds(144, 509, 150, 29);
		panel.add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton_sua = new JButton("Sửa");
		btnNewButton_sua.setIcon(new ImageIcon("D:\\BAI_TAP_JAVA\\QLLK_NEW\\src\\img\\Pencil-icon.png"));
		btnNewButton_sua.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnNewButton_sua.setBackground(new Color(219, 189, 70));
		btnNewButton_sua.setBounds(491, 503, 125, 42);
		panel.add(btnNewButton_sua);
		
		JButton btnNewButton_xoa = new JButton("Xóa");
		btnNewButton_xoa.setIcon(new ImageIcon("D:\\BAI_TAP_JAVA\\QLLK_NEW\\src\\img\\delete-icon.png"));
		btnNewButton_xoa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_xoa.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnNewButton_xoa.setBackground(new Color(255, 128, 128));
		btnNewButton_xoa.setBounds(663, 503, 125, 42);
		panel.add(btnNewButton_xoa);
		
		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBackground(new Color(119, 255, 187));
		panel_2.setBounds(0, 0, 937, 47);
		panel.add(panel_2);
		
		JLabel lbNhanVien_1_1_1 = new JLabel("CHI TIẾT HÓA ĐƠN");
		lbNhanVien_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lbNhanVien_1_1_1.setForeground(Color.RED);
		lbNhanVien_1_1_1.setFont(new Font("Arial", Font.BOLD, 25));
		lbNhanVien_1_1_1.setBackground(new Color(4, 255, 130));
		lbNhanVien_1_1_1.setBounds(0, 0, 937, 47);
		panel_2.add(lbNhanVien_1_1_1);
	}

}
