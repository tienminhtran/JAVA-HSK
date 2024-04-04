package GUI;

import java.awt.BorderLayout;
import java.awt.HeadlessException;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import entity.NhanVien;

public class NhanvienGIU extends JFrame {

	private ArrayList<NhanVien> dsnv;
	private JTable jTable;
	private DefaultTableModel model;

	public NhanvienGIU(ArrayList<NhanVien> dsnv, String title) {
		this.setTitle(title);
		this.setSize(600,380);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.dsnv = dsnv;
		String colum[] = {"Mã", "Họ", "Tên", "Phòng ban", "Tuổi", "Tiền lương"};
//		model = new DefaultTableModel(colum, 0);		
		jTable = new JTable(model = new DefaultTableModel(colum, 0));

		for(int i = 0; i<dsnv.size();i++) {
			NhanVien nv = dsnv.get(i);
			String hang[] = {nv.getMaSo(), nv.getHo(), nv.getTen(), nv.getPhongBan().toString(), nv.getTuoi()+"", nv.getTienLuong()+""};
			model.addRow(hang);
		}
		jTable.setRowHeight(30);
		add(new JScrollPane(jTable), BorderLayout.CENTER);
	}
	
}
