package gui;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.FileDialog;
import java.awt.Font;
import java.awt.Image;
import java.awt.Panel;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.sql.Date;
import java.text.DecimalFormat;
import java.util.ArrayList;

import javax.swing.ButtonGroup;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import com.mindfusion.drawing.Colors;

import dao.DAOLoaiPhong;
import dao.DAOPhatSinhMa;
import dao.DAOPhong;
import dao.Regex;
import entity.LoaiPhong;
import entity.Phong;
import jiconfont.icons.FontAwesome;
import jiconfont.swing.IconFontSwing;


public class FrmPhong extends JFrame implements ActionListener, MouseListener, ItemListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@SuppressWarnings("unused")
	private String sHeaderMaNV;
	@SuppressWarnings("unused")
	private String sHeaderTenNV;
	private Panel pMain;
	@SuppressWarnings("unused")
	private Date dNgayHienTai;
	private JTextField txtTK;
	private JTextField txtTenP;
	private JTextField txtGiaPhong;
	private JButton btnTim;
	private JButton btnThemP;
	private JButton btnXoaP;
	private JButton btnSuaP;
	private JButton btnReset;
	private JComboBox<String> cboLoaiP;
	private JComboBox<String> cboTinhTrangP;
	private JTable tblPhong;
	private DefaultTableModel modelPhong;
	private DAOPhong daoPhong;
	private DAOLoaiPhong daoLoaiP;
	private DAOPhatSinhMa daoMa;
	private DecimalFormat dfGiaP, dftxtGiaP;
	private Regex regex;
	private ArrayList<LoaiPhong> loaiP;
	private Phong p;
	private JPanel pNhapThongTin;
	private JLabel lblNhapThongTin;
	private ButtonGroup bgRdo;

	public Panel getFrmPhong() {
		return this.pMain;
	}
	public FrmPhong(String sHeaderTenNV, String sHeaderMaNV, Date dNgayHienTai) {

		//Khai bao dao
		daoPhong = new DAOPhong();
		daoLoaiP = new DAOLoaiPhong();
		daoMa = new DAOPhatSinhMa();
		regex = new Regex();
		//dinh dang
		dfGiaP=new DecimalFormat("###,###");
		dftxtGiaP=new DecimalFormat("######");
		//giao dien
		getContentPane().setLayout(null);
		pMain = new Panel();
		pMain.setBackground(Color.WHITE);
		pMain.setBounds(0, 0, 1281, 629);
		getContentPane().add(pMain);
		pMain.setLayout(null);

		pNhapThongTin = new JPanel();
		pNhapThongTin.setBorder(new LineBorder(new Color(114, 23, 153)));
		pNhapThongTin.setBackground(Color.WHITE);
		pNhapThongTin.setBounds(0, 55, 1247, 158);
		pMain.add(pNhapThongTin);
		pNhapThongTin.setLayout(null);

		lblNhapThongTin = new JLabel("Nhập thông tin phòng");
		lblNhapThongTin.setHorizontalAlignment(SwingConstants.CENTER);
		lblNhapThongTin.setFont(new Font("SansSerif", Font.BOLD, 18));
		lblNhapThongTin.setBounds(0, 10, 246, 26);
		pNhapThongTin.add(lblNhapThongTin);

		
		JLabel lblLoaiP = new JLabel("Loại phòng:");
		lblLoaiP.setBounds(28, 46, 84, 26);
		pNhapThongTin.add(lblLoaiP);
		lblLoaiP.setFont(new Font("SansSerif", Font.PLAIN, 15));
		
		// Loai phong
		cboLoaiP = new JComboBox<String>();
		cboLoaiP.setBounds(108, 46, 191, 35);
		pNhapThongTin.add(cboLoaiP);
		cboLoaiP.setBackground(new Color(255, 255, 255));
		cboLoaiP.setFont(new Font("SansSerif", Font.PLAIN, 14));
		cboLoaiP.setBorder(new LineBorder(new Color(114, 23, 153), 1, true));

		// tinh trang phong
		JLabel lblTinhTrangP = new JLabel("Tình trạng phòng:");
		lblTinhTrangP.setBounds(911, 46, 125, 26);
		pNhapThongTin.add(lblTinhTrangP);
		lblTinhTrangP.setFont(new Font("SansSerif", Font.PLAIN, 15));

		cboTinhTrangP = new JComboBox<String>();
		cboTinhTrangP.setBounds(1046, 42, 191, 35);
		pNhapThongTin.add(cboTinhTrangP);
		cboTinhTrangP.setFont(new Font("SansSerif", Font.PLAIN, 15));
		cboTinhTrangP.setBorder(new LineBorder(new Color(114, 23, 153), 1, true));
		cboTinhTrangP.setBackground(Color.WHITE);
		String cbbTinhTrang[] = { "Trống", "Đang hoạt động", "Đã đặt" };
		for (int i = 0; i < cbbTinhTrang.length; i++) {
			cboTinhTrangP.addItem(cbbTinhTrang[i]);
		}
		cboTinhTrangP.setEnabled(false);
		
		//nhap gia phong
		txtGiaPhong = new JTextField();
		txtGiaPhong.setBounds(690, 46, 191, 35);
		pNhapThongTin.add(txtGiaPhong);
		txtGiaPhong.setBackground(new Color(255, 255, 255));
		txtGiaPhong.setFont(new Font("SansSerif", Font.PLAIN, 14));
		txtGiaPhong.setBorder(new LineBorder(new Color(114, 23, 153), 1, true));
		txtGiaPhong.setColumns(20);
		
		JLabel lblGiaP = new JLabel("Giá phòng:");
		lblGiaP.setBounds(613, 50, 111, 26);
		pNhapThongTin.add(lblGiaP);
		lblGiaP.setFont(new Font("SansSerif", Font.PLAIN, 15));
		
		//ten Phong
		txtTenP = new JTextField();
		txtTenP.setBounds(397, 46, 191, 35);
		pNhapThongTin.add(txtTenP);
		txtTenP.setFont(new Font("SansSerif", Font.PLAIN, 14));
		txtTenP.setBorder(new LineBorder(new Color(114, 23, 153), 1, true));
		txtTenP.setEnabled(false);
		txtTenP.setColumns(30);
		
		JLabel lblTenPhong = new JLabel("Tên phòng: ");
		lblTenPhong.setBounds(321, 50, 102, 26);
		pNhapThongTin.add(lblTenPhong);
		lblTenPhong.setFont(new Font("SansSerif", Font.PLAIN, 15));


		// lblTim
		JLabel lblTim = new JLabel("Tìm kiếm:");
		lblTim.setFont(new Font("SansSerif", Font.BOLD, 14));
		lblTim.setBounds(350, 11, 90, 35);
		pMain.add(lblTim);

		// txtTK
		txtTK = new JTextField();
		txtTK.setText("Tìm theo mã phòng, loại phòng, tình trạng phòng");
		txtTK.setFont(new Font("SansSerif", Font.ITALIC, 15));
		txtTK.setForeground(Colors.LightGray);
		txtTK.setBorder(new LineBorder(new Color(114, 23, 153), 2, true));
		txtTK.setBounds(425, 11, 529, 33);
		txtTK.addFocusListener(new FocusAdapter() { // place holder
			@Override
			public void focusGained(FocusEvent e) {
				if (txtTK.getText().equals("Tìm theo mã phòng, loại phòng, tình trạng phòng")) {
					txtTK.setText("");
					txtTK.setFont(new Font("SansSerif", Font.PLAIN, 15));
					txtTK.setForeground(Color.BLACK);
				}
			}

			@Override
			public void focusLost(FocusEvent e) {
				if (txtTK.getText().equals("")) {
					txtTK.setFont(new Font("SansSerif", Font.ITALIC, 15));
					txtTK.setText("Tìm theo mã phòng, loại phòng, tình trạng phòng");
					txtTK.setForeground(Colors.LightGray);
				}
			}
		});
		pMain.add(txtTK);

		// btnTim
		btnTim = new FixButton("Tìm");
		btnTim.setForeground(Color.WHITE);

		btnTim.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnTim.setFont(new Font("SansSerif", Font.BOLD, 14));
		btnTim.setBorder(new LineBorder(new Color(0, 146, 182), 2, true));
		btnTim.setBackground(new Color(114, 23, 153));
		btnTim.setBounds(964, 12, 127, 33);
		
		
		pMain.add(btnTim);
		//Icon iconExcel = IconFontSwing.buildIcon(FontAwesome.FILE_EXCEL_O, 20, Color.white);
		

		// nút thêm
		btnThemP = new FixButton("Thêm");
		btnThemP.setForeground(Color.WHITE);

		btnThemP.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnThemP.setFont(new Font("SansSerif", Font.BOLD, 14));
		btnThemP.setBackground(new Color(57, 210, 247));
		btnThemP.setBounds(198, 110, 148,35);
		
		pNhapThongTin.add(btnThemP);
		
		//nút sửa
		btnSuaP = new FixButton("Sửa");
		btnSuaP.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnSuaP.setForeground(Color.WHITE);
		btnSuaP.setFont(new Font("SansSerif", Font.BOLD, 14));
		btnSuaP.setBackground(new Color(133, 217, 191));
		btnSuaP.setBounds(421, 110, 148, 35);
		
		pNhapThongTin.add(btnSuaP);
		
		//nút xóa set loại phòng về ngưng hoạt động
		btnXoaP = new FixButton("Xóa");
		btnXoaP.setForeground(Color.WHITE);
		btnXoaP.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnXoaP.setFont(new Font("SansSerif", Font.BOLD, 14));
		btnXoaP.setBackground(new Color(0xE91940));
		btnXoaP.setBounds(655, 110, 148, 35);
		
		pNhapThongTin.add(btnXoaP);
		
		//nút làm mới
		btnReset = new FixButton("Làm mới");
		btnReset.setForeground(Color.WHITE);
		btnReset.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnReset.setFont(new Font("SansSerif", Font.BOLD, 14));
		btnReset.setBackground(new Color(114, 23, 153));
		btnReset.setBounds(888, 110, 148, 35);
		
		pNhapThongTin.add(btnReset);
		

		bgRdo=new ButtonGroup();
		bgRdo.clearSelection();
		
		//tạo bảng
		//tên các cột trong bảng
		String phong [] = {"Mã phòng","Loại phòng", "Giá phòng", "Tình trạng phòng"};
		modelPhong = new DefaultTableModel(phong,0);

		tblPhong = new JTable(modelPhong);
		tblPhong.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		tblPhong.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		tblPhong.setShowHorizontalLines(true);
		tblPhong.setShowGrid(true);
		tblPhong.setBackground(Color.WHITE);
		tblPhong.setFont(new Font("SansSerif", Font.PLAIN, 14));
		tblPhong.setSelectionBackground(new Color(164, 44, 167, 30));
		tblPhong.setSelectionForeground(new Color(114, 23, 153));
		tblPhong.setRowHeight(30);
		
		JTableHeader tbHeader = tblPhong.getTableHeader();
		tbHeader.setBackground(new Color(164, 44, 167));
		tbHeader.setForeground(Color.white);
		tbHeader.setFont(new Font("SansSerif", Font.BOLD, 14));
		
		//thanh cuốn lên xuống
		JScrollPane spPhong = new JScrollPane(tblPhong, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		spPhong.setBounds(0, 223, 1247, 396);
		spPhong.setBorder(new LineBorder(new Color(164, 44, 167), 1, true));
		spPhong.setBackground(new Color(164, 44, 167));
		spPhong.getHorizontalScrollBar();
		pMain.add(spPhong);
		
		//chỉnh độ dài từng cột
		tblPhong.getColumnModel().getColumn(0).setPreferredWidth(240);
		tblPhong.getColumnModel().getColumn(1).setPreferredWidth(240);
		tblPhong.getColumnModel().getColumn(2).setPreferredWidth(240);
		tblPhong.getColumnModel().getColumn(3).setPreferredWidth(240);
		
		//Chữ canh lề trái, số canh lề phải
		DefaultTableCellRenderer rightRenderer=new DefaultTableCellRenderer();
		rightRenderer.setHorizontalAlignment(JLabel.RIGHT);
		DefaultTableCellRenderer leftRenderer = new DefaultTableCellRenderer();
		leftRenderer.setHorizontalAlignment(JLabel.LEFT);
		tblPhong.getColumnModel().getColumn(0).setCellRenderer(leftRenderer);
		tblPhong.getColumnModel().getColumn(1).setCellRenderer(leftRenderer);
		tblPhong.getColumnModel().getColumn(2).setCellRenderer(rightRenderer);
		tblPhong.getColumnModel().getColumn(3).setCellRenderer(leftRenderer);
		
		///Background
		JLabel lblBackGround=new JLabel("");
		lblBackGround.setIcon(new ImageIcon("data\\img\\background.png"));
		lblBackGround.setBounds(0, 0, 1281, 629);
		Image imgBackGround = Toolkit.getDefaultToolkit().getImage("data\\img\\background.png");
		Image resizeBG = imgBackGround.getScaledInstance(lblBackGround.getWidth(), lblBackGround.getHeight(), 0);
		lblBackGround.setIcon(new ImageIcon(resizeBG));
		pMain.add(lblBackGround);
		// load loai Phong
		loaiP = daoLoaiP.getAllLoaiPhong();
		for(LoaiPhong lp : loaiP) {
			cboLoaiP.addItem(lp.getTenLoaiPhong());
		}

		loadDanhSachPhong();
		//add actions
		tblPhong.addMouseListener(this);
		btnReset.addActionListener(this);
		btnThemP.addActionListener(this);
		btnSuaP.addActionListener(this);
		btnXoaP.addActionListener(this);
		btnTim.addActionListener(this);
		
	
		
		
	}
	// end giao dien

	//Lam moi danh sach
	public void clearTable() {
		while (tblPhong.getRowCount() > 0) {
			modelPhong.removeRow(0);
		}
	}

	//Load danh sach cac phong
	public void loadDanhSachPhong() {
		clearTable();
		ArrayList<Phong> lsP = daoPhong.getDanhSachPhong();
		for (Phong p : lsP) {
			LoaiPhong loaiP = daoLoaiP.getLoaiPhongTheoMa(p.getLoaiPhong().getMaLoaiPhong());
			modelPhong.addRow(new Object[] {p.getMaPhong(), loaiP.getTenLoaiPhong(), dfGiaP.format(p.getGiaPhong()), p.getTinhTrangPhong() });
		}
	}
	
	/**
	 * load danh sách phòng
	 * @param lstP: danh sách phòng
	 */
	private void loadDanhSachPhong(ArrayList<Phong> lstP) {
		clearTable();
		for (Phong p : lstP) {
			LoaiPhong loaiP = daoLoaiP.getLoaiPhongTheoMa(p.getLoaiPhong().getMaLoaiPhong());
			modelPhong.addRow(new Object[] {p.getMaPhong(), loaiP.getTenLoaiPhong(), dfGiaP.format(p.getGiaPhong()), p.getTinhTrangPhong() });
		}
	}

	/**
	 * load danh sách 1 phòng
	 * @param Phong p: thôgn tin phòng được chọn
	 */
	public void loadPhongDuocChon(Phong p) {
		LoaiPhong loaiP = daoLoaiP.getLoaiPhongTheoMa(p.getLoaiPhong().getMaLoaiPhong());
		modelPhong.addRow(new Object[] {p.getMaPhong(), loaiP.getTenLoaiPhong(), dfGiaP.format(p.getGiaPhong()), p.getTinhTrangPhong() });
	}
	
	/**
	 * load danh sách phòng theo loại
	 * @param p2: danh sách các phong đã được lấy ra theo mã loại phòng
	 */
	private void loadDanhSachPhongTheoLoai(ArrayList<Phong> p2) {
		clearTable();
		String maLoai = daoLoaiP.getMaLoaiPTheoTen(txtTK.getText());

		ArrayList<Phong> lstName = daoPhong.getPhongTheoLoai(maLoai);
		for (Phong p : lstName) {
			LoaiPhong loaiP = daoLoaiP.getLoaiPhongTheoMa(p.getLoaiPhong().getMaLoaiPhong());
			modelPhong.addRow(new Object[] {p.getMaPhong(), loaiP.getTenLoaiPhong(), dfGiaP.format(p.getGiaPhong()), p.getTinhTrangPhong() });
		}
	}
	
	/**
	 * load danh sách phòng theo mã
	 * @param lstP: danh sách các phòng đã được lấy ra theo mã phòng
	 */
	public void loadDanhSachPhongTheoMa(ArrayList<Phong> lstP) {
		clearTable();
		ArrayList<Phong> lsP = daoPhong.getPhongTheoMaP(txtTK.getText());
		for (Phong p : lsP) {
			LoaiPhong loaiP = daoLoaiP.getLoaiPhongTheoMa(p.getLoaiPhong().getMaLoaiPhong());
			modelPhong.addRow(new Object[] {p.getMaPhong(), loaiP.getTenLoaiPhong(), dfGiaP.format(p.getGiaPhong()), p.getTinhTrangPhong() });
		}
	}
	
	/**
	 * load danh sách các phòng theo tình trạng
	 * @param lstP: danh sách các phòng đã đươc lấy ra theo tình trạng
	 */
	public void loadDanhSachPhongTheoTinhTrang(ArrayList<Phong> lstP) {
		clearTable();
		ArrayList<Phong> lsP = daoPhong.getPhongTheoTinhTrang(txtTK.getText());
		for (Phong p : lsP) {
			LoaiPhong loaiP = daoLoaiP.getLoaiPhongTheoMa(p.getLoaiPhong().getMaLoaiPhong());
			modelPhong.addRow(new Object[] {p.getMaPhong(), loaiP.getTenLoaiPhong(), dfGiaP.format(p.getGiaPhong()), p.getTinhTrangPhong() });
		}
	}

	//Them phong
	/**
	 * Thêm Phòng vào trong danh sách
	 * kiểm tra giá phòng phải >0
	 * Xuất ra danh sách phòng
	 */
	public void themPhong() {
		if(regex.regexGiaP(txtGiaPhong)) {
			float giaP = Float.parseFloat(txtGiaPhong.getText());
			String maP = daoMa.getMaP();
			String tinhTrang = "Trống";
			LoaiPhong loaiP = new LoaiPhong(daoLoaiP.getMaLoaiPTheoTen(cboLoaiP.getSelectedItem().toString()));

			Phong p = new Phong(maP, tinhTrang, giaP, loaiP);

			daoPhong.themPhong(p);
			clearTable();
			//loadPhongDuocChon(p);
			loadDanhSachPhong();
			JOptionPane.showMessageDialog(this, "Thêm phòng thành công");
		}
	}

	//Sua thong tin phong
	public void suaThongTin() {
		int row = tblPhong.getSelectedRow();
		if (row >= 0) {
			int update = JOptionPane.showConfirmDialog(this, "Bạn muốn sửa thông tin phòng này không?", "Thông báo",
					JOptionPane.YES_NO_OPTION);
			if (update == JOptionPane.YES_OPTION) {
				JTextField txtTam = new JTextField();
				String maP = modelPhong.getValueAt(row, 0).toString();
				double gia = Math.round(daoPhong.getPhongTheoMa(maP).getGiaPhong());
				txtTam.setText(String.valueOf(Math.round(gia)));
				if (regex.regexGiaP(txtTam)) {
					try {
						LoaiPhong loaiP = new LoaiPhong(daoLoaiP.getMaLoaiPTheoTen(cboLoaiP.getSelectedItem().toString()));
						double giaP = Double.parseDouble(txtGiaPhong.getText().toString());
						String tinhTrang = cboTinhTrangP.getSelectedItem().toString();
						Phong p = new Phong(maP, tinhTrang, giaP, loaiP);
						clearTable();
						daoPhong.suaThongTinPhong(p);
						//loadPhongDuocChon(p);
						loadDanhSachPhong();
						JOptionPane.showMessageDialog(this, "Thông tin phòng đã được sửa!", "Thông báo",
								JOptionPane.OK_OPTION);
					} catch (Exception e) {
						JOptionPane.showMessageDialog(null, "Vui lòng kiểm tra lại giá phòng!!", "Thông báo",
								JOptionPane.ERROR_MESSAGE);
					}
				}
			}
		} else {
			JOptionPane.showMessageDialog(null, "Vui lòng chọn thông tin phòng sửa!", "Thông báo",
					JOptionPane.WARNING_MESSAGE);
		}
	}

	//xoa phong 
	private boolean xoaPhong() {
		int row = tblPhong.getSelectedRow();
		if (row >= 0) {
			int cancel = JOptionPane.showConfirmDialog(null, "Bạn muốn xóa phòng này?", "Thông báo",
					JOptionPane.YES_NO_OPTION);
			if (cancel == JOptionPane.YES_OPTION && cboTinhTrangP.getSelectedIndex()==0) {
				String maP = tblPhong.getValueAt(row, 0).toString();
				try {
					modelPhong.removeRow(row);
					clearTable();
					daoPhong.huyP(maP);
					JOptionPane.showMessageDialog(null, "Đã xóa phòng!", "Thông báo", JOptionPane.OK_OPTION);
				} catch (Exception e1) {
					e1.printStackTrace();
					JOptionPane.showMessageDialog(null, "xóa phòng thất bại!", "Thông báo",
							JOptionPane.ERROR_MESSAGE);
				}
			}else {
				JOptionPane.showMessageDialog(null, "Vui lòng chọn lại và kiểm tra tinh trạng phòng");
			}
		} else {
			JOptionPane.showMessageDialog(null, "Bạn chưa chọn thông tin phòng cần hủy!", "Thông báo",
					JOptionPane.WARNING_MESSAGE);
		}
		return false;
	}

	//Tìm kiếm phòng
	private void findPhong() {
		ArrayList<Phong> lstP = null;
		String regexMaPhong = "((P|p)[0-9]{3})";
		if (!txtTK.getText().equals("") && !txtTK.getText().equals("Tìm theo mã phòng, loại phòng, tình trạng phòng")) {
			if(regex.regexTimPhong(txtTK)) {
				if (txtTK.getText().trim().matches(regexMaPhong)) {
					lstP = daoPhong.getPhongTheoMaP(txtTK.getText().trim());
					loadDanhSachPhongTheoMa(lstP);
				}
			if(regex.regexTimKiemLoaiPhong(txtTK)) {
					lstP = daoPhong.getPhongTheoLoai(daoLoaiP.getMaLoaiPTheoTen(txtTK.getText()).trim());
					loadDanhSachPhongTheoLoai(lstP);
			}
			if(regex.regexTimKiemTinhTrang(txtTK)) {
					lstP = daoPhong.getPhongTheoTinhTrang(txtTK.getText());
					loadDanhSachPhongTheoTinhTrang(lstP);
			}
			if(lstP.size() == 0) {
				JOptionPane.showMessageDialog(this, "Không tìm thấy thông tin tìm kiếm phù hợp!");
				loadDanhSachPhong(lstP);
			}
			}
		}else {
			clearTable();
			JOptionPane.showMessageDialog(this, "Vui lòng nhập thông tin tìm kiếm!", "Thông báo",
					JOptionPane.WARNING_MESSAGE);
		}
	}		
	

	//Làm mới
	public void resetAll() {
		txtTK.setText("Tìm theo mã phòng, loại phòng, tình trạng phòng");
		txtTK.setFont(new Font("SansSerif", Font.ITALIC, 15));
		txtTK.setForeground(Colors.LightGray);
		
		txtGiaPhong.setText("");
		txtTenP.setText("");
		
		loadDanhSachPhong();
	}

	
	@Override
	public void itemStateChanged(ItemEvent e) {
		// TODO Auto-generated method stub

	}
	@Override

	//Hien thi thong tin phong khi chon vao bang
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		Object o = e.getSource();
		if(o.equals(tblPhong)) {
			int row = tblPhong.getSelectedRow();
			String maPhong = tblPhong.getValueAt(row, 0).toString();
			
			txtTenP.setText(modelPhong.getValueAt(row, 0).toString());
			cboLoaiP.setSelectedItem(modelPhong.getValueAt(row, 1));
			
			ArrayList<Phong> lstPhong = daoPhong.getDanhSachPhong();
			for(Phong p : lstPhong) {
				if(maPhong.equals(p.getMaPhong())) 
					txtGiaPhong.setText(dftxtGiaP.format(Math.round(p.getGiaPhong())));
			}
			
			cboTinhTrangP.setSelectedItem(modelPhong.getValueAt(row, 3).toString());
		}

	}
	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}
	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}
	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}
	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object o = e.getSource();
		if(o.equals(btnReset)) {
			resetAll();
		}
		if(o.equals(btnThemP)) {
			themPhong();
		}
		if(o.equals(btnSuaP)) {
			suaThongTin();
		}
		if(o.equals(btnXoaP)) {
			xoaPhong();
			resetAll();
		}
		
		if(o.equals(btnTim)) {
			findPhong();
		}
		
	}
	
}
