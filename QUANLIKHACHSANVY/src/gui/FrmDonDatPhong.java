package gui;

import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.Panel;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import java.sql.Date;
import java.sql.SQLException;
import java.sql.Time;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;

import javax.swing.ButtonGroup;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
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
import com.toedter.calendar.JDateChooser;

import connection.ConnectDB;
import dao.DAODonDatPhong;
import dao.DAOKhachHang;
import dao.DAOLoaiKH;
import dao.DAOLoaiPhong;
import dao.DAONhanVien;
import dao.DAOPhatSinhMa;
import dao.DAOPhong;
import dao.Regex;
import entity.DonDatPhong;
import entity.KhachHang;
import entity.LoaiKH;
import entity.LoaiPhong;
import entity.NhanVien;
import entity.Phong;
import jiconfont.icons.FontAwesome;
import jiconfont.swing.IconFontSwing;

public class FrmDonDatPhong extends JPanel implements ActionListener, FocusListener{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@SuppressWarnings("unused")
	private String sHeaderMaNV, sHeaderTenNV;
	private Panel pMain;
	private Date dNgayHienTai;
	private JLabel lblTim, lblTenKH, lblLoaiKH, lblNgayDen, lblSDT, lblGioDen, lblTinhTrangDDP, lblDiaChi, lblChonPhong, lblBackGround;
	private JTextField txtTim, txtTenKH, txtSDT, txtDiaChi;
	private JComboBox<Object> cboTrangThaiDDP;
	private JComboBox<String> cboLoaiKH, cboGio, cboPhut;
	private JTable tblPhong, tblDDP;
	private DefaultTableModel modelPhong, modelDDP;
	private JButton btnTim, btnThemDDP, btnSuaDDP, btnLamMoiDDP;
	private ButtonGroup bg;
	private SimpleDateFormat dfNgay, dfHienGio;
	private DecimalFormat dfGiaPhong, dftxtGio, dftxtPhut;
	private java.util.Date timeNow1, timeNow2;
	private long nowHours, nowMinutes;
	@SuppressWarnings("unused")
	private Date dNow;
	private LocalDate now;
	private int ngay, thang, nam;
	private JDateChooser chooserNgayDen;

	private DAOPhong daoPhong;
	private DAOLoaiPhong daoLoaiPhong;
	private DAODonDatPhong daoDonDatPhong;
	private DAOKhachHang daoKhachHang;
	private DAOLoaiKH daoLoaiKH;
	private DAONhanVien daoNhanVien;
	private DAOPhatSinhMa daoPhatSinhMa;
	private Regex regex;

	private DonDatPhong ddp;
	private JPanel pNhapThongTin;
	private JLabel lblNhapThongTin;


	/**
	 * @return pMain
	 */
	public Panel getFrmDDP() {
		return this.pMain;
	}
	
	/**
	 * Kế thừa tên và mã NV, ngày hiện tại của FrmQuanLy
	 * @param sHeaderTenNV
	 * @param sHeaderMaNV
	 * @param dNgayHienTai
	 */
	@SuppressWarnings("deprecation")
	public FrmDonDatPhong(String sHeaderTenNV, String sHeaderMaNV, Date dNgayHienTai) {

		this.sHeaderMaNV = sHeaderMaNV;
		this.sHeaderTenNV = sHeaderTenNV;
		this.dNgayHienTai = dNgayHienTai;

		/**
		 * Kết nối database
		 */
		try {
			ConnectDB.getinstance().connect();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}

		/**
		 * Khai báo các DAO
		 */
		daoPhong=new DAOPhong();
		daoLoaiPhong=new DAOLoaiPhong();
		daoDonDatPhong=new DAODonDatPhong();
		daoKhachHang=new DAOKhachHang();
		daoLoaiKH=new DAOLoaiKH();
		daoNhanVien=new DAONhanVien();
		daoPhatSinhMa=new DAOPhatSinhMa();
		regex=new Regex();

		/**
		 * Khai báo các entity
		 */
		Phong p=new Phong();
		ddp=new DonDatPhong();

		/**
		 * Định dạng giá, ngày, giờ, phút trong bảng
		 */
		dfNgay=new SimpleDateFormat("dd/MM/yyyy");
		dfHienGio=new SimpleDateFormat("HH:mm a");
		dfGiaPhong=new DecimalFormat("###,###");
		dftxtGio=new DecimalFormat("##");
		dftxtPhut=new DecimalFormat("##");

		/**
		 * Frame DonDatPhong
		 */
		setLayout(null);
		pMain = new Panel();
		pMain.setBackground(Color.WHITE);
		pMain.setBounds(0, 0, 1273, 629);
		add(pMain);
		pMain.setLayout(null);

		/**
		 * Nhập thông tin đơn đặt phòng mới
		 * Panel pNhapThongTin
		 */
		pNhapThongTin = new JPanel();
		pNhapThongTin.setToolTipText("Các thông tin ĐĐP cần nhập");
		pNhapThongTin.setBorder(new LineBorder(new Color(114, 23, 153)));
		pNhapThongTin.setBackground(Color.WHITE);
		pNhapThongTin.setBounds(10, 48, 1250, 231);
		pMain.add(pNhapThongTin);
		pNhapThongTin.setLayout(null);

		lblNgayDen = new JLabel("Ngày đến:");
		lblNgayDen.setBounds(361, 146, 84, 23);
		lblNgayDen.setFont(new Font("SansSerif", Font.BOLD, 15));
		pNhapThongTin.add(lblNgayDen);

		lblSDT = new JLabel("SĐT:");
		lblSDT.setBounds(895, 45, 46, 28);
		lblSDT.setFont(new Font("SansSerif", Font.BOLD, 15));
		pNhapThongTin.add(lblSDT);

		lblNhapThongTin = new JLabel("Nhập thông tin đơn đặt phòng");
		lblNhapThongTin.setHorizontalAlignment(SwingConstants.CENTER);
		lblNhapThongTin.setFont(new Font("SansSerif", Font.BOLD, 18));
		lblNhapThongTin.setBounds(10, 11, 292, 29);
		pNhapThongTin.add(lblNhapThongTin);

		txtTenKH = new JTextField();
		txtTenKH.setBounds(490, 39, 302, 40);
		txtTenKH.setFont(new Font("SansSerif", Font.PLAIN, 15));
		txtTenKH.setColumns(10);
		txtTenKH.setBorder(new LineBorder(new Color(114, 23 ,153), 1, true));
		pNhapThongTin.add(txtTenKH);


		//test data nhanh
		txtTenKH.setText("Đinh Quang Tuấn");

		lblTenKH = new JLabel("Tên khách hàng:");
		lblTenKH.setBounds(361, 50, 133, 19);
		lblTenKH.setFont(new Font("SansSerif", Font.BOLD, 15));
		pNhapThongTin.add(lblTenKH);

		lblLoaiKH = new JLabel("Loại khách hàng:");
		lblLoaiKH.setBounds(10, 50, 133, 19);
		lblLoaiKH.setFont(new Font("SansSerif", Font.BOLD, 15));
		pNhapThongTin.add(lblLoaiKH);

		cboLoaiKH = new JComboBox<String>();
		cboLoaiKH.setToolTipText("Chọn loại khách hàng");
		cboLoaiKH.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		cboLoaiKH.setBounds(144, 42, 175, 35);
		cboLoaiKH.setFont(new Font("SansSerif", Font.PLAIN, 15));
		cboLoaiKH.setBorder(new LineBorder(new Color(114, 23 ,153), 1, true));
		cboLoaiKH.setBackground(Color.white);
		pNhapThongTin.add(cboLoaiKH);
		ArrayList<LoaiKH> lsLoaiKH = daoLoaiKH.getAllLoaiKH();
		for(LoaiKH lkh : lsLoaiKH) 
			cboLoaiKH.addItem(lkh.getTenLoaiKH());

		chooserNgayDen = new JDateChooser();
		chooserNgayDen.getCalendarButton().setToolTipText("Chọn ngày đến");
		chooserNgayDen.getCalendarButton().setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		chooserNgayDen.setBounds(490, 139, 176, 38);
		chooserNgayDen.getCalendarButton().setPreferredSize(new Dimension(30, 24));
		chooserNgayDen.getCalendarButton().setBackground(new Color(102, 0, 153));
		chooserNgayDen.setFont(new Font("SansSerif", Font.PLAIN, 15));
		chooserNgayDen.setDateFormatString("dd/MM/yyyy");
		chooserNgayDen.setBorder(new LineBorder(new Color(114, 23, 153), 1, true));
		Icon iconCalendar = IconFontSwing.buildIcon(FontAwesome.CALENDAR, 18, Color.white);
		chooserNgayDen.setIcon((ImageIcon) iconCalendar);
		pNhapThongTin.add(chooserNgayDen);

		txtSDT = new JTextField();
		txtSDT.setBounds(1016, 39, 224, 41);
		txtSDT.setColumns(10);
		txtSDT.setFont(new Font("SansSerif", Font.PLAIN, 15));
		txtSDT.setBorder(new LineBorder(new Color(114, 23, 153), 1, true));
		txtSDT.setText("0903142210");
		pNhapThongTin.add(txtSDT);

		lblDiaChi = new JLabel("Địa chỉ:");
		lblDiaChi.setBounds(10, 99, 61, 20);
		lblDiaChi.setFont(new Font("SansSerif", Font.BOLD, 15));
		pNhapThongTin.add(lblDiaChi);

		txtDiaChi = new JTextField();
		txtDiaChi.setBounds(144, 89, 648, 40);
		txtDiaChi.setFont(new Font("SansSerif", Font.PLAIN, 15));
		txtDiaChi.setBorder(new LineBorder(new Color(114, 23, 153), 1, true));
		txtDiaChi.setText("118 Hoàng Văn Thụ, P9, Q.Phú Nhuận");
		pNhapThongTin.add(txtDiaChi);

		lblGioDen = new JLabel("Giờ đến:");
		lblGioDen.setBounds(10, 148, 74, 19);
		lblGioDen.setFont(new Font("SansSerif", Font.BOLD, 15));
		pNhapThongTin.add(lblGioDen);

		cboGio=new JComboBox<String>();
		cboGio.setToolTipText("Chọn số giờ đến");
		cboGio.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		cboGio.setBounds(144, 139, 72, 37);
		cboGio.setFont(new Font("SansSerif", Font.PLAIN, 15));
		cboGio.setBorder(new LineBorder(new Color(114, 23 ,153), 1, true));
		cboGio.setBackground(Color.white);
		pNhapThongTin.add(cboGio);
		////
		cboPhut = new JComboBox<String>();
		cboPhut.setToolTipText("Chọn số phút đến");
		cboPhut.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		cboPhut.setBounds(245, 139, 74, 37);
		cboPhut.setFont(new Font("SansSerif", Font.PLAIN, 15));
		cboPhut.setBorder(new LineBorder(new Color(114, 23 ,153), 1, true));
		cboPhut.setBackground(Color.white);
		pNhapThongTin.add(cboPhut);
		for(int i=0; i<24; i++)
			cboGio.addItem(""+i);
		for(int i=0; i<60; i++)
			cboPhut.addItem(""+i);

		JLabel lblHaiCham = new JLabel(" :");
		lblHaiCham.setHorizontalAlignment(SwingConstants.CENTER);
		lblHaiCham.setBounds(215, 139, 21, 39);
		lblHaiCham.setFont(new Font("SansSerif", Font.PLAIN, 25));
		pNhapThongTin.add(lblHaiCham);

		lblTinhTrangDDP = new JLabel("Trạng thái ĐĐP:");
		lblTinhTrangDDP.setBounds(895, 100, 133, 19);
		lblTinhTrangDDP.setFont(new Font("SansSerif", Font.BOLD, 15));
		pNhapThongTin.add(lblTinhTrangDDP);

		cboTrangThaiDDP = new JComboBox<Object>(new Object[] {"Chờ xác nhận", "Đã xác nhận", "Hủy", "Đã trả phòng"});
		cboTrangThaiDDP.setToolTipText("Chọn trạng thái ĐĐP");
		cboTrangThaiDDP.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		cboTrangThaiDDP.setBounds(1016, 90, 175, 39);
		cboTrangThaiDDP.setFont(new Font("SansSerif", Font.PLAIN, 15));
		cboTrangThaiDDP.setBorder(new LineBorder(new Color(114, 23 ,153), 1, true));
		cboTrangThaiDDP.setBackground(Color.white);
		pNhapThongTin.add(cboTrangThaiDDP);

		/**
		 * Tìm kiếm đơn đặt phòng theo họ tên và sđt khách hàng.
		 * Tìm khách hàng theo sđt.
		 * Label lblTim
		 * JTextField txtTim
		 * Sự kiện placeholder tìm DDP: FocusListener
		 * Nút tìm DDP và KH
		 * Icon iconTim
		 */
		lblTim = new JLabel("Tìm kiếm:");
		lblTim.setFont(new Font("SansSerif", Font.BOLD, 14));
		lblTim.setBounds(255, 11, 80, 35);
		pMain.add(lblTim);
		//
		txtTim = new JTextField();
		txtTim.setToolTipText("Tìm kiếm thông tin ĐĐP và khách hàng");
		txtTim.setText("Tìm đơn đặt phòng theo họ tên và sđt khách hàng, tìm khách hàng theo sđt.");
		txtTim.setFont(new Font("SansSerif", Font.ITALIC, 15));
		txtTim.setForeground(Colors.LightGray);
		txtTim.setBorder(new LineBorder(new Color(114, 23 ,153), 2, true));
		txtTim.setBounds(348, 12, 514, 33);
		pMain.add(txtTim);
		//
		btnTim = new FixButton("Tìm");
		btnTim.setForeground(Color.WHITE);
		btnTim.setFont(new Font("SansSerif", Font.BOLD, 14));
		btnTim.setBorder(new LineBorder(new Color(0, 146, 182), 2, true));
		btnTim.setBackground(new Color(114, 23, 153));
		btnTim.setBounds(922, 12, 104, 33);
		
		pMain.add(btnTim);


		/**
		 * Bảng chứa các thông tin phòng
		 * JScrollPane scrollPaneChonPhong
		 * String col[]: tên các cột
		 * JTable tblPhong: nội dung của bảng
		 * JTableHeader tbHeaderPhong: định dạng khung các tên cột
		 */
		lblChonPhong = new JLabel("Chọn phòng:");
		lblChonPhong.setFont(new Font("SansSerif", Font.BOLD, 18));
		lblChonPhong.setBounds(10, 289, 136, 29);
		pMain.add(lblChonPhong);

		JScrollPane scrollPaneChonPhong = new JScrollPane(tblPhong, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPaneChonPhong.setToolTipText("Danh sách thông tin phòng");
		scrollPaneChonPhong.setBorder(new LineBorder(new Color(164, 44, 167), 1, true));
		scrollPaneChonPhong.setBackground(new Color(164, 44, 167));
		scrollPaneChonPhong.setBounds(10, 319, 370, 300);
		scrollPaneChonPhong.getHorizontalScrollBar();
		pMain.add(scrollPaneChonPhong);

		String colPhong[] = {"Mã phòng", "Loại phòng", "Giá phòng", "Tình trạng phòng"};
		modelPhong=new DefaultTableModel(colPhong, 0);

		tblPhong=new JTable(modelPhong);
		tblPhong.setToolTipText("Chọn thông tin phòng muốn đặt");
		tblPhong.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		tblPhong.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		tblPhong.setShowHorizontalLines(true);
		tblPhong.setShowGrid(true);
		tblPhong.setBackground(Color.white);
		tblPhong.setFont(new Font("SansSerif", Font.PLAIN, 13));
		tblPhong.setSelectionBackground(new Color(164, 44, 167, 30));
		tblPhong.setSelectionForeground(new Color(114, 23, 153));
		tblPhong.setRowHeight(30);
		tblPhong.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

		JTableHeader tbHeaderPhong = tblPhong.getTableHeader();
		tbHeaderPhong.setToolTipText("Chọn thông tin phòng muốn đặt");
		tbHeaderPhong.setBackground(new Color(164, 44, 167));
		tbHeaderPhong.setForeground(Color.white);
		tbHeaderPhong.setFont(new Font("SansSerif", Font.BOLD, 14));

		tblPhong.getColumnModel().getColumn(0).setPreferredWidth(100);//maphong
		tblPhong.getColumnModel().getColumn(1).setPreferredWidth(120);//loaiphong
		tblPhong.getColumnModel().getColumn(2).setPreferredWidth(100);//giaphong
		tblPhong.getColumnModel().getColumn(3).setPreferredWidth(150);//tinhtrangphong

		DefaultTableCellRenderer rightRenderer=new DefaultTableCellRenderer();
		rightRenderer.setHorizontalAlignment(JLabel.RIGHT);
		tblPhong.getColumnModel().getColumn(2).setCellRenderer(rightRenderer);

		scrollPaneChonPhong.setViewportView(tblPhong);

		//ngay thang nam lap DDP
		now = LocalDate.now();
		ngay = now.getDayOfMonth();
		thang = now.getMonthValue()-1;
		nam = now.getYear()-1900;
		dNow = new Date(nam, thang, ngay);
		pNhapThongTin.setLayout(null);

		/**
		 * Thêm 1 DDP vào danh sách bảng DDP
		 * Nút thêm DDP
		 * JButton btnThemDDP
		 * Icon iconThemDDP
		 */
		btnThemDDP = new FixButton("Thêm");
		btnThemDDP.setForeground(Color.black);
		btnThemDDP.setFont(new Font("SansSerif", Font.BOLD, 14));
		btnThemDDP.setBorder(new LineBorder(new Color(0, 146, 182), 2, true));
		btnThemDDP.setBackground(new Color(57, 210, 247));
		btnThemDDP.setBounds(308, 187, 148, 35);
		
		pNhapThongTin.add(btnThemDDP);

		/**
		 * Sửa thông tin DDP
		 * Nút sửa DDP
		 * JButton btnSuaDDP
		 * Icon iconSuaDDP
		 */
		btnSuaDDP = new FixButton("Sửa");
		btnSuaDDP.setForeground(Color.black);
		btnSuaDDP.setFont(new Font("SansSerif", Font.BOLD, 14));
		btnSuaDDP.setBorder(new LineBorder(new Color(0, 146, 182), 2, true));
		btnSuaDDP.setBackground(new Color(133, 217, 191));
		btnSuaDDP.setBounds(546, 187, 148, 35);
		
		pNhapThongTin.add(btnSuaDDP);

		/**
		 * Làm mới: xóa trắng các text, xóa tất cả nội dung trong bảng DDP, đặt mặc định các combobox, bỏ chọn checkbox và các radiobutton
		 * Nút làm mới
		 * JButton btnLamMoiDDP
		 * Icon iconLamMoiDDP
		 */
		btnLamMoiDDP = new FixButton("Làm mới");
		btnLamMoiDDP.setForeground(Color.white);
		btnLamMoiDDP.setFont(new Font("SansSerif", Font.BOLD, 14));
		btnLamMoiDDP.setBorder(new LineBorder(new Color(0, 146, 182), 2, true));
		btnLamMoiDDP.setBackground(new Color(114, 23, 153));
		btnLamMoiDDP.setBounds(808, 187, 148, 35);
		
		pNhapThongTin.add(btnLamMoiDDP);

		/**
		 * Nhóm các radiobutton
		 * ButtonGroup bg
		 */
		bg=new ButtonGroup();


		/**
		 * Bảng chứa các thông tin đơn đặt phòng
		 * JScrollPane scrollPaneDDP
		 * String col[]: tên các cột
		 * JTable tblDDP: nội dung của bảng
		 * JTableHeader tbHeaderDDP: định dạng khung các tên cột
		 */
		JScrollPane scrollPaneDDP = new JScrollPane();
		scrollPaneDDP.setToolTipText("Danh sách thông tin ĐĐP");
		scrollPaneDDP.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPaneDDP.setBorder(new LineBorder(new Color(164, 44, 167), 1, true));
		scrollPaneDDP.setBackground(new Color(164, 44, 167));
		scrollPaneDDP.setBounds(390, 319, 873, 300);
		scrollPaneDDP.getHorizontalScrollBar();
		pMain.add(scrollPaneDDP);

		String colDDP[] = {"Mã DDP", "Mã phòng", "Tên KH", "SĐT", "Ngày đến", "Giờ đến" , "Tên NV lập", "Ngày lập", "Trạng thái DDP"};
		modelDDP=new DefaultTableModel(colDDP, 0);

		tblDDP=new JTable(modelDDP);
		tblDDP.setToolTipText("Chọn thông tin ĐĐP để thực hiện các chức năng");
		tblDDP.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		tblDDP.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		tblDDP.setShowHorizontalLines(true);
		tblDDP.setShowGrid(true);
		tblDDP.setBackground(Color.white);
		tblDDP.setFont(new Font("SansSerif", Font.PLAIN, 13));
		tblDDP.setSelectionBackground(new Color(164, 44, 167, 30));
		tblDDP.setSelectionForeground(new Color(114, 23, 153));
		tblDDP.setRowHeight(30);
		tblDDP.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		tblDDP.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				choose1DDP();
			}
		});


		JTableHeader tbHeaderDDP = tblDDP.getTableHeader();
		tbHeaderDDP.setToolTipText("Danh sách thông tin ĐĐP");
		tbHeaderDDP.setBackground(new Color(164, 44, 167));
		tbHeaderDDP.setForeground(Color.white);
		tbHeaderDDP.setFont(new Font("SansSerif", Font.BOLD, 14));

		tblDDP.getColumnModel().getColumn(0).setPreferredWidth(80);
		tblDDP.getColumnModel().getColumn(1).setPreferredWidth(100);
		tblDDP.getColumnModel().getColumn(2).setPreferredWidth(180);
		tblDDP.getColumnModel().getColumn(3).setPreferredWidth(100);
		tblDDP.getColumnModel().getColumn(4).setPreferredWidth(100);
		tblDDP.getColumnModel().getColumn(5).setPreferredWidth(80);
		tblDDP.getColumnModel().getColumn(6).setPreferredWidth(180);
		tblDDP.getColumnModel().getColumn(7).setPreferredWidth(90);
		tblDDP.getColumnModel().getColumn(8).setPreferredWidth(130);

		DefaultTableCellRenderer rightRenderer2=new DefaultTableCellRenderer();
		rightRenderer2.setHorizontalAlignment(JLabel.RIGHT);
		tblDDP.getColumnModel().getColumn(3).setCellRenderer(rightRenderer2);
		tblDDP.getColumnModel().getColumn(4).setCellRenderer(rightRenderer2);
		tblDDP.getColumnModel().getColumn(5).setCellRenderer(rightRenderer2);
		tblDDP.getColumnModel().getColumn(7).setCellRenderer(rightRenderer2);

		scrollPaneDDP.setViewportView(tblDDP);

		/**
		 * Hình nền của giao diện
		 */
		lblBackGround=new JLabel("");
		lblBackGround.setIcon(new ImageIcon("data\\img\\background.png"));
		lblBackGround.setBounds(0, 0, 1281, 629);
		Image imgBackGround = Toolkit.getDefaultToolkit().getImage("data\\img\\background.png");
		Image resizeBG = imgBackGround.getScaledInstance(lblBackGround.getWidth(), lblBackGround.getHeight(), 0);
		lblBackGround.setIcon(new ImageIcon(resizeBG));
		pMain.add(lblBackGround);


		/**
		 * Load ngày, giờ, phút hiện tại
		 */
		chooserNgayDen.setDate(dNgayHienTai);

		timeNow1 = new java.util.Date();
		nowHours = timeNow1.getHours();
		nowMinutes = timeNow1.getMinutes();
		cboGio.setSelectedItem(dftxtGio.format(nowHours));
		cboPhut.setSelectedItem(dftxtPhut.format(nowMinutes));

		/**
		 * Các sự kiện của giao diện quản lý đơn đặt phòng
		 */
		loadDanhSachDDP(ddp);

		txtTim.addFocusListener(this);

		loadDSPhongTrongVaDaDat(p);

		btnTim.addActionListener(this);
		btnThemDDP.addActionListener(this);
		btnSuaDDP.addActionListener(this);
		btnLamMoiDDP.addActionListener(this);

	
	}


	/**
	 * Xóa hết dữ liệu trong bảng danh sách thông tin chọn phòng
	 * @param defaultTableModel trả về modelPhong
	 */
	private void removeDanhSachPhong(DefaultTableModel defaultTableModel) {
		while(tblPhong.getRowCount() > 0)
			modelPhong.removeRow(0);
	}

	/**
	 * @param defaultTableModel trả về modelDDP
	 */
	private void removeDanhSachDDP(DefaultTableModel defaultTableModel) {
		while(tblDDP.getRowCount() > 0)
			modelDDP.removeRow(0);
	}

	/**
	 * Xóa trắng textfield và textarea, đặt lại mặc định các combobox và các button
	 */
	@SuppressWarnings("deprecation")
	private void resetAll() {
		txtTim.setText("Tìm đơn đặt phòng theo họ tên và sđt khách hàng, tìm khách hàng theo sđt.");
		txtTim.setFont(new Font("SansSerif", Font.ITALIC, 15));
		txtTim.setForeground(Colors.LightGray);
		
		cboLoaiKH.setEnabled(true);
		txtTenKH.setText("");
		txtTenKH.setEditable(true);
		txtSDT.setText("");
		txtSDT.setEditable(true);
		txtDiaChi.setText("");
		txtDiaChi.setEditable(true);

		chooserNgayDen.setDate(dNgayHienTai);

		timeNow2 = new java.util.Date();
		nowHours = timeNow2.getHours();
		nowMinutes = timeNow2.getMinutes();
		cboGio.setSelectedItem(dftxtGio.format(nowHours));
		cboPhut.setSelectedItem(dftxtPhut.format(nowMinutes));
		
		cboTrangThaiDDP.setSelectedItem("Chờ xác nhận");

		bg.clearSelection();

		removeDanhSachPhong(modelPhong);
		loadDSPhongTrongVaDaDat(new Phong());

		removeDanhSachDDP(modelDDP);
		loadDanhSachDDP(ddp);
		
		txtTenKH.requestFocus();
	}

	/**
	 * Hiển thị danh sách thông tin phòng trống và đã đặt gồm:
	 * mã phòng, loại phòng, giá phòng, tình trạng phòng
	 * @param p
	 */
	private void loadDSPhongTrongVaDaDat(Phong p) {
		removeDanhSachPhong(modelPhong);
		ArrayList<Phong> lstP = daoPhong.getPhongTrongVaDaDat();
		for(Phong infoP : lstP) {
			LoaiPhong lp = daoLoaiPhong.getLoaiPhongTheoMa(infoP.getLoaiPhong().getMaLoaiPhong());
			String gia = dfGiaPhong.format(infoP.getGiaPhong());
			modelPhong.addRow(new Object[] {
					infoP.getMaPhong(), lp.getTenLoaiPhong(), gia, infoP.getTinhTrangPhong()
			});
		}
		changeColorRow(tblPhong);
	}

	/**
	 * Hiển thị danh sách thông tin đơn đặt phòng, không hiển thị đơn đã hủy, thông tin gồm:
	 * mã ĐĐP, mã phòng, tên KH, sđt, ngày đến, giờ đến, tên NV lập, ngày lập, trạng thái ĐĐP
	 * @param ddp
	 */
	private void loadDanhSachDDP(DonDatPhong ddp) {
		removeDanhSachDDP(modelDDP);
		ArrayList<DonDatPhong> lstDDP = daoDonDatPhong.getDanhSachDDPChoXacNhanVaDaXacNhan();
		for(DonDatPhong infoDDP : lstDDP) {
			KhachHang kh = daoKhachHang.getKHTheoMa(infoDDP.getKhachHang().getMaKhangHang());
			NhanVien nv = daoNhanVien.getMaVaSdtNVChoDDP(infoDDP.getNhanVien().getMaNhanVien());
			modelDDP.addRow(new Object[] {
					infoDDP.getMaDDP(), infoDDP.getPhong().getMaPhong(), kh.getTenKH(), kh.getSdt(),
					dfNgay.format(infoDDP.getNgayDen()), dfHienGio.format(infoDDP.getGioDen()), nv.getTenNhanVien(), dfNgay.format(infoDDP.getNgayLap()), infoDDP.getTrangThaiDDP()
			});
		}
		
	}
	
	/**
	 * Thay đổi màu của dòng trong bảng chọn phòng có trạng thái phòng "Đã đặt"
	 * @param tb
	 */
	public void changeColorRow(JTable tb) {
		tb.setDefaultRenderer(Object.class, new DefaultTableCellRenderer(){
			private static final long serialVersionUID = 5206972278640725451L;

			@Override
		    public Component getTableCellRendererComponent(JTable table,
		            Object value, boolean isSelected, boolean hasFocus, int row, int col) {

		        super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, col);

		        String status = (String)table.getModel().getValueAt(row, 3);
		        if ("Đã đặt".equals(status)) {
		            setBackground(Color.yellow);
		            setForeground(Color.red);
		        } else {
		            setBackground(table.getBackground());
		            setForeground(table.getForeground());
		        }       
		        return this;
		    }   
		});
	}

	/**
	 * Hiện danh sách thông tin ĐĐP theo sđt của KH
	 * @param list
	 */
	private void loadDDPTheoSdtKH(ArrayList<DonDatPhong> list) {
		removeDanhSachDDP(modelDDP);
		KhachHang khachHang = daoKhachHang.getKHTheoSDT(txtTim.getText().trim());
		ArrayList<DonDatPhong> lstDDP = daoDonDatPhong.getDDPTheoMaKH(khachHang.getMaKhangHang());
		for(DonDatPhong infoDDP : lstDDP) {
			NhanVien nv = daoNhanVien.getMaVaSdtNVChoDDP(infoDDP.getNhanVien().getMaNhanVien());
			modelDDP.addRow(new Object[] {
					infoDDP.getMaDDP(), infoDDP.getPhong().getMaPhong(), khachHang.getTenKH(), khachHang.getSdt(),
					dfNgay.format(infoDDP.getNgayDen()), dfHienGio.format(infoDDP.getGioDen()), nv.getTenNhanVien(), dfNgay.format(infoDDP.getNgayLap()), infoDDP.getTrangThaiDDP()
			});
		}
	}

	/**
	 * Hiện danh sách thông tin ĐĐP theo họ tên của KH
	 * @param list
	 */
	private void loadDDPTheoTenKH(ArrayList<DonDatPhong> list) {
		removeDanhSachDDP(modelDDP);
		KhachHang khachHang = daoKhachHang.getKHTheoTen(txtTim.getText().trim());
		ArrayList<DonDatPhong> lstDDP = daoDonDatPhong.getDDPTheoMaKH(khachHang.getMaKhangHang());
		for(DonDatPhong infoDDP : lstDDP) {
			NhanVien nv = daoNhanVien.getMaVaSdtNVChoDDP(infoDDP.getNhanVien().getMaNhanVien());
			modelDDP.addRow(new Object[] {
					infoDDP.getMaDDP(), infoDDP.getPhong().getMaPhong(), khachHang.getTenKH(), khachHang.getSdt(),
					dfNgay.format(infoDDP.getNgayDen()), dfHienGio.format(infoDDP.getGioDen()), nv.getTenNhanVien(), dfNgay.format(infoDDP.getNgayLap()), infoDDP.getTrangThaiDDP()
			});
		}
	}

	/**
	 * Chọn 1 dòng thông tin đơn đặt phòng trong bảng danh sách thông tin ĐĐP
	 */
	@SuppressWarnings("deprecation")
	private void choose1DDP() {
		int selectedRow = tblDDP.getSelectedRow();
		if((selectedRow>=0 && tblPhong.getSelectedRow()==-1) || (selectedRow>=0 && tblPhong.getSelectedRow()!=-1)) {
			cboLoaiKH.setEnabled(false);
			txtTenKH.setEditable(false);
			txtTenKH.setForeground(Color.gray);
			txtSDT.setEditable(false);
			txtSDT.setForeground(Color.gray);
			txtDiaChi.setEditable(false);
			txtDiaChi.setForeground(Color.gray);
			
			String maDDP = tblDDP.getValueAt(selectedRow, 0).toString();
			String sdt = tblDDP.getValueAt(selectedRow, 3).toString();

			ArrayList<KhachHang> lstKH = daoKhachHang.getMaVaSDTKH(sdt);
			for(KhachHang khachHang : lstKH) {
				if(sdt.equals(khachHang.getSdt())) {
					LoaiKH loaiKH = daoLoaiKH.getLoaiKHTheoMaLoai(khachHang.getLoaiKH().getMaLoaiKH());

					cboLoaiKH.setSelectedItem(loaiKH.getTenLoaiKH());
					txtTenKH.setText(khachHang.getTenKH());
					txtSDT.setText(khachHang.getSdt());
					txtDiaChi.setText(khachHang.getDiaChi());
				}
			}

			ArrayList<DonDatPhong> lstDDP = daoDonDatPhong.getAllDanhSachDDP();
			for(DonDatPhong ddp : lstDDP) {
				if(maDDP.equals(ddp.getMaDDP())) {
					chooserNgayDen.setDate(ddp.getNgayDen());
					cboGio.setSelectedItem(dftxtGio.format(ddp.getGioDen().getHours()));
					cboPhut.setSelectedItem(dftxtPhut.format(ddp.getGioDen().getMinutes()));
					cboTrangThaiDDP.setSelectedItem(ddp.getTrangThaiDDP()+"");
				}
			}
		}
	}

	/**
	 * Sự kiện tìm kiếm thông tin ĐĐP theo họ tên và sđt của KH
	 * Sự kiện tìm kiếm thông tin KH theo sđt của KH
	 */
	@SuppressWarnings("deprecation")
	private void findKHVaDDP() {
		String input = txtTim.getText().trim();
		input = input.toUpperCase();
		String regexTenKH= "^[ A-Za-za-zA-ZÀÁÂÃÈÉÊÌÍÒÓÔÕÙÚĂĐĨŨƠàáâãèéêìíòóôõùúăđĩũơƯĂẠẢẤẦẨẪẬẮẰẲẴẶẸẺẼỀỀỂẾưăạảấầẩẫậắằẳẵặẹẻẽềềểếỄỆỈỊỌỎỐỒỔỖỘỚỜỞỠỢỤỦỨỪễệỉịọỏốồổỗộớờởỡợụủứừỬỮỰỲỴÝỶỸửữựỳỵỷỹ]+$";
		String regexSDT  = "^(0[0-9]{9})$";

		ArrayList<KhachHang> lstKH1 = null;
		ArrayList<KhachHang> lstKH2 = null;

		if(regex.regexTimDDPTheoKH(txtTim)) {
			if(input.matches(regexSDT)) {
				lstKH1 = daoKhachHang.getMaVaSDTKH(input);
				for(KhachHang khachHang : lstKH1) {
					ArrayList<DonDatPhong> lstDDP = daoDonDatPhong.getDDPTheoMaKH(khachHang.getMaKhangHang());
					if(input.equals(khachHang.getSdt())) {
						KhachHang kh = daoKhachHang.getKHTheoSDT(input);
						LoaiKH lkh = daoLoaiKH.getLoaiKHTheoMaLoai(kh.getLoaiKH().getMaLoaiKH());

						cboLoaiKH.setSelectedItem(lkh.getTenLoaiKH());
						txtTenKH.setText(khachHang.getTenKH());
						txtSDT.setText(khachHang.getSdt());
						txtDiaChi.setText(khachHang.getDiaChi());

						loadDDPTheoSdtKH(lstDDP);
					}
				}
				if(lstKH1.size()==0) {
					JOptionPane.showMessageDialog(this, "Không tìm thấy thông tin tìm kiếm phù hợp!", "Thông báo", JOptionPane.ERROR_MESSAGE);
					txtTim.requestFocus();
					txtTim.selectAll();
				}
			}
			else if(input.matches(regexTenKH)) {
				lstKH2 = daoKhachHang.getTenKH(input);
				for(KhachHang khachHang : lstKH2) {
					ArrayList<DonDatPhong> lstDDP = daoDonDatPhong.getDDPTheoMaKH(khachHang.getMaKhangHang());
					if(daoKhachHang.getTenKH(input) != null) {
						KhachHang kh = daoKhachHang.getKHTheoTen(input);
						LoaiKH lkh = daoLoaiKH.getLoaiKHTheoMaLoai(kh.getLoaiKH().getMaLoaiKH());

						cboLoaiKH.setSelectedItem(lkh.getTenLoaiKH());
						txtTenKH.setText(khachHang.getTenKH());
						txtSDT.setText(khachHang.getSdt());
						txtDiaChi.setText(khachHang.getDiaChi());

						loadDDPTheoTenKH(lstDDP);
					}
				}
				if(lstKH2.size()==0) {
					JOptionPane.showMessageDialog(this, "Không tìm thấy thông tin tìm kiếm phù hợp!", "Thông báo", JOptionPane.ERROR_MESSAGE);
					txtTim.requestFocus();
					txtTim.selectAll();
				}
			}
		}
		

//		
		cboTrangThaiDDP.setSelectedItem("Chờ xác nhận");
	}

	/**
	 * Kiểm tra các thông tin khách hàng trước khi đặt đơn
	 * Tìm kiếm KH theo sđt, nếu thông tin KH đã có trong dữ liệu thì hiện thông tin KH lên và đặt đơn
	 * Nếu KH mới, tìm không có thông tin thì thêm 1 KH mới và dữ liệu và được đặt đơn
	 */
	@SuppressWarnings({ "deprecation", "unused" })
	private void checkInfoKH() {
		String hoTen = txtTenKH.getText();
		String sdt = txtSDT.getText();
		String diaChi = txtDiaChi.getText();
		if(!hoTen.equals("") && !sdt.equals("") && !diaChi.equals("")) {
			String phatSinhMaDDP = daoPhatSinhMa.getMaDDP();
			String loaiKH = cboLoaiKH.getSelectedItem().toString();
			String trangThaiDDP = cboTrangThaiDDP.getSelectedItem().toString();

			java.util.Date date = chooserNgayDen.getDate();
			Date ngayDen = new Date(date.getYear(), date.getMonth(), date.getDate());

			Date ngayLap = dNgayHienTai;

			int gio = Integer.parseInt(cboGio.getSelectedItem().toString());
			int phut = Integer.parseInt(cboPhut.getSelectedItem().toString());
			Time gioDen = new Time(gio, phut, 0);

			int chonPhong = tblPhong.getSelectedRow(); //chọn phòng lấy info từ maPhong

			KhachHang kh = daoKhachHang.getKHTheoSDT(sdt);	//lấy maKH, tenKH từ sđt
			//info new KH
			String phatSinhMaKH = daoPhatSinhMa.getMaKH();
			String maLoaiKH = daoLoaiKH.getMaLoaiKHTheoTen(loaiKH);

			String maNV = sHeaderMaNV; //lấy info NV từ maNV
			NhanVien nv= daoNhanVien.getMaVaSdtNVChoDDP(maNV);

			if(chonPhong>=0) {
				String maPhongChon = tblPhong.getValueAt(chonPhong, 0).toString();
				Phong p = daoPhong.getPhongTheoMa(maPhongChon);
				String tinhTrangPhong = tblPhong.getValueAt(chonPhong, 3).toString();
				if(regex.regexTen(txtTenKH) && regex.regexSDT(txtSDT) && regex.regexDiaChi(txtDiaChi)) {
					if(tinhTrangPhong.equals("Đã đặt")) 
						JOptionPane.showMessageDialog(null, "Phòng này đã được đặt, vui lòng chọn phòng khác!", "Thông báo", JOptionPane.OK_OPTION);
					else {
						if(daoKhachHang.checkSdtKH(sdt)) { //kq=true thì lấy thông tin KH cũ
							//them vao data
							DonDatPhong ddp=new DonDatPhong(phatSinhMaDDP, ngayLap, trangThaiDDP, ngayDen, gioDen, kh, nv, p);
							try {
								if(trangThaiDDP.equals("Chờ xác nhận")) {
									daoDonDatPhong.themDDP(ddp);
									daoPhong.capnhatTrangThaiPhong(maPhongChon, "Đã đặt");
									resetAll();
									JOptionPane.showMessageDialog(this, "Thêm đơn đặt phòng thành công!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
								}
								if(trangThaiDDP.equals("Đã xác nhận")) {
									daoDonDatPhong.themDDP(ddp);
									daoPhong.capnhatTrangThaiPhong(maPhongChon, "Đang hoạt động");
									resetAll();
									JOptionPane.showMessageDialog(this, "Thêm đơn đặt phòng thành công!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
								}
								if(trangThaiDDP.equals("Hủy") || trangThaiDDP.equals("Đã trả phòng"))
									JOptionPane.showMessageDialog(this, "Không được thêm đơn đặt phòng có trạng thái đơn là hủy hoặc đã trả phòng!", "Thông báo", JOptionPane.WARNING_MESSAGE);
							}catch (SQLException e) {
								e.printStackTrace();
								JOptionPane.showMessageDialog(this, "Thêm đơn đặt phòng thất bại!", "Thông báo", JOptionPane.ERROR_MESSAGE);
							}

						}

						if(!daoKhachHang.checkSdtKH(sdt)) {	//kq=false thì thêm KH mới
							try {
								if(trangThaiDDP.equals("Chờ xác nhận")) {
									KhachHang newKH = new KhachHang(phatSinhMaKH, new LoaiKH(daoLoaiKH.getMaLoaiKHTheoTen("Khách hàng thường")), hoTen, sdt, diaChi);
									daoKhachHang.themDanhSachKH(newKH);
									
									DonDatPhong ddp=new DonDatPhong(phatSinhMaDDP, ngayLap, trangThaiDDP, ngayDen, gioDen, newKH, nv, p);
									daoDonDatPhong.themDDP(ddp);
									daoPhong.capnhatTrangThaiPhong(maPhongChon, "Đã đặt");
									
									resetAll();
									JOptionPane.showMessageDialog(this, "Thêm đơn đặt phòng thành công!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
								}
								if(trangThaiDDP.equals("Đã xác nhận")) {
									KhachHang newKH = new KhachHang(phatSinhMaKH, new LoaiKH(daoLoaiKH.getMaLoaiKHTheoTen("Khách hàng thường")), hoTen, sdt, diaChi);
									daoKhachHang.themDanhSachKH(newKH);
									
									DonDatPhong ddp=new DonDatPhong(phatSinhMaDDP, ngayLap, trangThaiDDP, ngayDen, gioDen, newKH, nv, p);
									daoDonDatPhong.themDDP(ddp);
									daoPhong.capnhatTrangThaiPhong(maPhongChon, "Đang hoạt động");
									
									resetAll();
									JOptionPane.showMessageDialog(this, "Thêm đơn đặt phòng thành công!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
								}
								if(trangThaiDDP.equals("Hủy") || trangThaiDDP.equals("Đã trả phòng"))
									JOptionPane.showMessageDialog(this, "Không được thêm đơn đặt phòng có trạng thái đơn là hủy hoặc đã trả phòng!", "Thông báo", JOptionPane.WARNING_MESSAGE);
							}catch (SQLException e) {
								e.printStackTrace();
								JOptionPane.showMessageDialog(this, "Thêm đơn đặt phòng thất bại!", "Thông báo", JOptionPane.ERROR_MESSAGE);
							}
						}
						
						removeDanhSachPhong(modelPhong);
						loadDSPhongTrongVaDaDat(p);
					}
				}
			}else
				JOptionPane.showMessageDialog(null, "Vui lòng chọn phòng muốn đặt!", "Thông báo", JOptionPane.OK_OPTION);
		}else {
			JOptionPane.showMessageDialog(this, "Vui lòng nhập thông tin đầy đủ!", "Thông báo", JOptionPane.WARNING_MESSAGE);
		}
	}

	/**
	 * Thêm 1 ĐĐP mới vào dữ liệu và hiện lên bảng danh sách
	 */
	@SuppressWarnings("deprecation")
	private void addDDP() {
		if(chooserNgayDen.getDate()!=null) {
			java.util.Date date = chooserNgayDen.getDate();
			Date ngayDen = new Date(date.getYear(), date.getMonth(), date.getDate());

			int gio = Integer.parseInt(cboGio.getSelectedItem().toString());
			int phut = Integer.parseInt(cboPhut.getSelectedItem().toString());

			java.util.Date dateNow = new java.util.Date();
			int hourNow = dateNow.getHours();
			int minNow = dateNow.getMinutes();

			if(ngayDen.equals(dNgayHienTai)) {
				if(gio>hourNow)
					checkInfoKH();
				if(gio==hourNow && phut>=minNow) 
					checkInfoKH();
				if(gio<hourNow || (gio==hourNow && phut<minNow))
					JOptionPane.showMessageDialog(this, "Giờ đến phải được đặt sau hoặc ngay giờ hiện tại! \nGiờ hiện tại là: "+dfHienGio.format(dateNow), "Thông báo", JOptionPane.WARNING_MESSAGE);
			}
			else
				JOptionPane.showMessageDialog(this, "Ngày đến phải đặt trong ngày hôm nay! \nNgày hôm nay là: " +dfNgay.format(dNgayHienTai), "Thông báo", JOptionPane.WARNING_MESSAGE);

			removeDanhSachDDP(modelDDP);
			loadDanhSachDDP(ddp);
		}else 
			JOptionPane.showMessageDialog(this, "Vui lòng nhập thông tin đầy đủ!", "Thông báo", JOptionPane.WARNING_MESSAGE);
	}

	/**
	 * Sửa, cập nhật thông tin ĐĐP, trong giao diện quản lý ĐĐP không được sửa thông tin KH
	 * @throws SQLException
	 */
	@SuppressWarnings({ "deprecation", "unused" })
	private void updateDDP() throws SQLException { //thông tin KH trong ddp ko đc sửa
		int row = tblDDP.getSelectedRow();
		if(row>=0) {
			int update = JOptionPane.showConfirmDialog(this, "Bạn muốn sửa thông tin đơn đặt phòng này?", "Thông báo", JOptionPane.YES_NO_OPTION);
			if(update == JOptionPane.YES_OPTION) {
				String maDDP = tblDDP.getValueAt(row, 0).toString();
				String maPhong = tblDDP.getValueAt(row, 1).toString();

				String sdt = tblDDP.getValueAt(row, 3).toString();
				KhachHang kh = daoKhachHang.getKHTheoSDT(sdt);

				String maNV = sHeaderMaNV; //lấy info NV từ maNV
				NhanVien nv= daoNhanVien.getMaVaSdtNVChoDDP(maNV);

				java.util.Date date = chooserNgayDen.getDate();
				Date ngayDen = new Date(date.getYear(), date.getMonth(), date.getDate());
				Date ngayLap = dNgayHienTai;

				int gio = Integer.parseInt(cboGio.getSelectedItem().toString());
				int phut = Integer.parseInt(cboPhut.getSelectedItem().toString());
				Time gioDen = new Time(gio, phut, 0);

				java.util.Date dateNow = new java.util.Date();
				int hourNow = dateNow.getHours();
				int minNow = dateNow.getMinutes();

				String trangThaiDDP = cboTrangThaiDDP.getSelectedItem().toString();

				ArrayList<KhachHang> lstKH = daoKhachHang.getMaVaSDTKH(sdt);
				for(KhachHang khachHang : lstKH) {
					if(sdt.equals(khachHang.getSdt())) {
						LoaiKH loaiKH = daoLoaiKH.getLoaiKHTheoMaLoai(khachHang.getLoaiKH().getMaLoaiKH());

						cboLoaiKH.setSelectedItem(loaiKH.getTenLoaiKH());
						txtTenKH.setText(khachHang.getTenKH());
						txtSDT.setText(khachHang.getSdt());
						txtDiaChi.setText(khachHang.getDiaChi());
					}
				}
				
				DonDatPhong ddp=new DonDatPhong();
				ddp.setNgayLap(ngayLap);
				ddp.setGioDen(gioDen);
				ddp.setNgayDen(ngayDen);
				ddp.setTrangThaiDDP(trangThaiDDP);

				daoDonDatPhong.capNhatDDP(ddp, maDDP);
				removeDanhSachPhong(modelDDP);
				if(trangThaiDDP.equals("Chờ xác nhận"))
					daoPhong.capnhatTrangThaiPhong(maPhong, "Đã đặt");
				if(trangThaiDDP.equals("Đã xác nhận"))
					daoPhong.capnhatTrangThaiPhong(maPhong, "Đang hoạt động");
				if(trangThaiDDP.equals("Hủy") || trangThaiDDP.equals("Đã trả phòng"))
					daoPhong.capnhatTrangThaiPhong(maPhong, "Trống");
				loadDSPhongTrongVaDaDat(new Phong());

				resetAll();
				removeDanhSachDDP(modelDDP);
				modelDDP.setRowCount(0);
				modelDDP.addRow(new Object[] {
						maDDP, maPhong, kh.getTenKH(), kh.getSdt(),
						dfNgay.format(ngayDen), dfHienGio.format(gioDen), nv.getTenNhanVien(), dfNgay.format(ngayLap), trangThaiDDP
				});
				JOptionPane.showMessageDialog(this, "Sửa thông tin đơn đặt phòng thành công!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
			}
		}
		else
			JOptionPane.showMessageDialog(this, "Vui lòng chọn thông tin đơn đặt phòng cần sửa!", "Thông báo", JOptionPane.WARNING_MESSAGE);
	}


	/**
	 *Code sự kiện
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();

		if(o.equals(btnTim)) {
			if(txtTim.getText().equals("") || txtTim.getText().equals("Tìm đơn đặt phòng theo họ tên và sđt khách hàng, tìm khách hàng theo sđt.")) {
				removeDanhSachDDP(modelDDP);
				JOptionPane.showMessageDialog(this, "Vui lòng nhập thông tin tìm kiếm!", "Thông báo", JOptionPane.WARNING_MESSAGE);
				txtTim.requestFocus();
			}else 
				findKHVaDDP();
		}

		//thêm ddp
		if(o.equals(btnThemDDP)) {
			addDDP();
		}

		//sửa ddp
		if(o.equals(btnSuaDDP)) {
			try {
				updateDDP();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}

		//làm mới
		if(o.equals(btnLamMoiDDP)) {
			resetAll();
		}


	}

	/**
	 *Sự kiện placeholder của txtTim
	 */
	@Override
	public void focusGained(FocusEvent e) {
		if(txtTim.getText().equals("Tìm đơn đặt phòng theo họ tên và sđt khách hàng, tìm khách hàng theo sđt.")) {
			txtTim.setFont(new Font("SansSerif", Font.PLAIN, 15));
			txtTim.setForeground(Color.BLACK);
			txtTim.setText("");
		}
	}
	@Override
	public void focusLost(FocusEvent e) {
		if(txtTim.getText().equals("")) {
			txtTim.setFont(new Font("SansSerif", Font.ITALIC, 15));
			txtTim.setForeground(Colors.LightGray);
			txtTim.setText("Tìm đơn đặt phòng theo họ tên và sđt khách hàng, tìm khách hàng theo sđt.");
		}
	}
	
	
}
