package gui;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.sql.Date;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.JTable;
import javax.swing.JScrollBar;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JRadioButton;
import com.toedter.components.JLocaleChooser;

import dao.Dao_CaLamViec;
import dao.Dao_CongDoan;
import dao.Dao_CongNhan;
import dao.Dao_PhanCong;
import dao.Dao_PhongBan;
import dao.Dao_SanPham;
import db.ConnectDB;
import entity.CaLamViec;
import entity.CongDoan;
import entity.CongNhan;
import entity.EChucVu;
import entity.ETiengAnh;
import entity.ETrinhDo;
import entity.NhanVienHanhChanh;
import entity.PhieuPhanCong;
import entity.PhongBan;
import entity.SanPham;
import model.TableModel_CongNhan;
import model.TableModel_CongNhanThuGon;
import model.TableModel_DShanCongCongNhan;

import com.toedter.calendar.JCalendar;
import com.toedter.calendar.JDayChooser;
import com.toedter.calendar.JDateChooser;
import javax.swing.DefaultComboBoxModel;
import java.awt.Panel;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableCellRenderer;
import javax.swing.border.EtchedBorder;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;

import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.InputMethodEvent;
import java.awt.event.InputMethodListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.awt.event.ActionEvent;
import javax.swing.JCheckBox;

public class Pn_PhanCongCongNhan extends JPanel implements ActionListener, PropertyChangeListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField txt_Ten;
	private JTable tbl_PhanCong;
	private JTable tbl_CongNhan;
	private JButton btn_XoaTrang;
	private JButton btn_Sua;
	private JButton btn_PhanCong;
	private JButton btn_Xoa;
	private JComboBox cmb_SanPham;
	private JComboBox cmb_SapXep;
	private JComboBox cmb_CongDoan;
	private JComboBox cmb_CaLamViec;
	private JTextField txt_NgayPhan;
	private JDateChooser dch_NgayPhan;

	private Dao_SanPham daoSanPham = new Dao_SanPham(ConnectDB.getInstance().getConnection());
	private Dao_CongDoan daoCongDoan = new Dao_CongDoan(ConnectDB.getInstance().getConnection());
	private Dao_PhanCong daoPhanCong = new Dao_PhanCong(ConnectDB.getInstance().getConnection());
	private Dao_CongNhan daoCongNhan = new Dao_CongNhan(ConnectDB.getInstance().getConnection());
	private List<PhieuPhanCong> listPhieuPhanCong = daoPhanCong.layDS_PhanCong();
	private List<CongNhan> listCongNhan = daoCongNhan.layDS_CongNhan();

	private TableModel_CongNhanThuGon tableModel_CongNhanThuGon;
	private TableModel_DShanCongCongNhan tableModel_DSPhanCong;

//	private List<CongNhan> listCongNhan = daoCongNhan.layDS_CongNhan();

	/**
	 * Create the panel.
	 * 
	 * @throws SQLException
	 */
	public Pn_PhanCongCongNhan() throws SQLException {
		setLayout(null);

		JLabel lbl_TieuDe = new JLabel("PHÂN CÔNG CÔNG NHÂN");
		lbl_TieuDe.setBounds(10, 10, 1241, 25);
		lbl_TieuDe.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_TieuDe.setFont(new Font("Tahoma", Font.BOLD, 20));
		add(lbl_TieuDe);

		JLabel lbl_Ten = new JLabel("Họ và tên");
		lbl_Ten.setHorizontalAlignment(SwingConstants.LEFT);
		lbl_Ten.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbl_Ten.setBounds(75, 74, 105, 32);
		add(lbl_Ten);

		JLabel lbl_CaLamViec = new JLabel("Ca Làm Việc");
		lbl_CaLamViec.setHorizontalAlignment(SwingConstants.LEFT);
		lbl_CaLamViec.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbl_CaLamViec.setBounds(71, 113, 105, 32);
		add(lbl_CaLamViec);

		JLabel lbl_SanPham = new JLabel("Sản Phẩm");
		lbl_SanPham.setHorizontalAlignment(SwingConstants.LEFT);
		lbl_SanPham.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbl_SanPham.setBounds(75, 152, 105, 32);
		add(lbl_SanPham);

		JLabel lbl_CongDoan = new JLabel("Công Đoạn");
		lbl_CongDoan.setHorizontalAlignment(SwingConstants.LEFT);
		lbl_CongDoan.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbl_CongDoan.setBounds(75, 189, 105, 32);
		add(lbl_CongDoan);

		JLabel lbl_NgayPhan = new JLabel("Ngày Phân");
		lbl_NgayPhan.setHorizontalAlignment(SwingConstants.LEFT);
		lbl_NgayPhan.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbl_NgayPhan.setBounds(75, 230, 105, 32);
		add(lbl_NgayPhan);

		txt_Ten = new JTextField();
		txt_Ten.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txt_Ten.setColumns(10);
		txt_Ten.setBounds(202, 75, 365, 32);
		txt_Ten.setEditable(false);
		add(txt_Ten);

		txt_NgayPhan = new JTextField();
		txt_NgayPhan.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txt_NgayPhan.setColumns(10);
		txt_NgayPhan.setBounds(202, 225, 174, 32);
		add(txt_NgayPhan);

//Table Phân công
		JPanel pn_BangPhanCong = new JPanel();
		pn_BangPhanCong.setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)),
				"Danh sách đã phân công", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		pn_BangPhanCong.setBounds(10, 342, 1241, 288);
		add(pn_BangPhanCong);
		pn_BangPhanCong.setLayout(null);

		String[] headLinePhanCong = { "Mã PPC", "Mã Công nhân", "Họ và tên", "Ca làm việc", "Sản phẩm", "Công đoạn",
				"Ngày phân công" };

		tableModel_DSPhanCong = new TableModel_DShanCongCongNhan(listPhieuPhanCong, headLinePhanCong);
		tbl_PhanCong = new JTable(tableModel_DSPhanCong) {
			@Override
			public Component prepareRenderer(TableCellRenderer renderer, int row, int column) {
				Component c = super.prepareRenderer(renderer, row, column);
				if (isCellSelected(row, column)) {
					c.setBackground(getSelectionBackground());
				} else {
					if (row % 2 == 0) {
						c.setBackground(new Color(220, 239, 255));
					} else {
						c.setBackground(new Color(255, 255, 255));
					}
				}
				return c;
			}
		};

		DefaultTableCellRenderer rightRenderer = new DefaultTableCellRenderer();
		tbl_PhanCong.getColumnModel().getColumn(0).setCellRenderer(rightRenderer);
		JTableHeader header = tbl_PhanCong.getTableHeader();
		header.setBackground(Color.BLUE);
		header.setForeground(Color.WHITE);
		header.setFont(new Font("Tahoma", Font.BOLD, 15));
		header.setPreferredSize(new Dimension(header.getWidth(), 30));

		tbl_PhanCong.setFont(new Font("Tahoma", Font.PLAIN, 15));
		tbl_PhanCong.setBackground(UIManager.getColor("Button.light"));
		tbl_PhanCong.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		tbl_PhanCong.setSelectionBackground(new Color(190, 210, 255));
		tbl_PhanCong.setRowHeight(35);

		JScrollPane slp_PhanCong = new JScrollPane();
		slp_PhanCong.setBounds(10, 34, 1221, 243);
		pn_BangPhanCong.add(slp_PhanCong);

		slp_PhanCong.setViewportView(tbl_PhanCong);

		tbl_PhanCong.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int index = tbl_PhanCong.getSelectedRow();
				try {
					capNhatLenTruongPhanCong(index);
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}

			private void capNhatLenTruongPhanCong(int index) throws SQLException {
				PhieuPhanCong ppc = listPhieuPhanCong.get(index);

				txt_Ten.setText(ppc.getCongNhan().getTenCN() != null ? ppc.getCongNhan().getTenCN() : "");
				cmb_CaLamViec.setSelectedIndex(ppc.getCaLamViec().layTenCa().equals("Ca 1") ? 1
						: ppc.getCaLamViec().layTenCa().equals("Ca 2") ? 2 : 3);

				List<String> a = layDS_SanPham();
				int n = 0;
				for (String sp : a) {
					if (sp.equalsIgnoreCase(ppc.getCongDoan().getSanPham().getTenSP())) {
						cmb_SanPham.setSelectedIndex(n);
						break;
					}
					n++;
				}

				List<String> b = layDS_CongDoanTheoMaSP(ppc.getCongDoan().getSanPham().getMaSP());
				int k = 0;
				for (String cd : b) {
					if (cd.equalsIgnoreCase(ppc.getCongDoan().getTenCD())) {
						cmb_CongDoan.setSelectedIndex(k);
						break;
					}
					k++;
				}

				dch_NgayPhan.setDate(ppc.getNgayPhan() != null ? java.sql.Date.valueOf(ppc.getNgayPhan()) : null);
			}
		});

//	Table Công nhân

		JPanel pn_BangCongNhan = new JPanel();
		pn_BangCongNhan.setLayout(null);
		pn_BangCongNhan.setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)),
				"Danh sách công nhân", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		pn_BangCongNhan.setBounds(633, 47, 618, 243);
		add(pn_BangCongNhan);
		pn_BangCongNhan.setLayout(null);

		String[] headLineCongNhan = { "Mã", "Họ và tên", "Giới Tính", "Phòng Ban" };

		tableModel_CongNhanThuGon = new TableModel_CongNhanThuGon(listCongNhan, headLineCongNhan);
		tbl_CongNhan = new JTable(tableModel_CongNhanThuGon) {
			@Override
			public Component prepareRenderer(TableCellRenderer renderer, int row, int column) {
				Component c = super.prepareRenderer(renderer, row, column);
				if (isCellSelected(row, column)) {
					c.setBackground(getSelectionBackground());
				} else {
					if (row % 2 == 0) {
						c.setBackground(new Color(220, 239, 255));
					} else {
						c.setBackground(new Color(255, 255, 255));
					}
				}
				return c;
			}
		};

		DefaultTableCellRenderer rightRenderer_CongNhan = new DefaultTableCellRenderer();
		tbl_CongNhan.getColumnModel().getColumn(0).setCellRenderer(rightRenderer_CongNhan);
		JTableHeader header_CongNhan = tbl_CongNhan.getTableHeader();
		header_CongNhan.setBackground(Color.BLUE);
		header_CongNhan.setForeground(Color.WHITE);
		header_CongNhan.setFont(new Font("Tahoma", Font.BOLD, 15));
		header_CongNhan.setPreferredSize(new Dimension(header_CongNhan.getWidth(), 30));

		tbl_CongNhan.setFont(new Font("Tahoma", Font.PLAIN, 15));
		tbl_CongNhan.setBackground(UIManager.getColor("Button.light"));
		tbl_CongNhan.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		tbl_CongNhan.setSelectionBackground(new Color(190, 210, 255));
		tbl_CongNhan.setRowHeight(35);

		JScrollPane slp_CongNhan = new JScrollPane();
		slp_CongNhan.setBounds(10, 21, 598, 211);
		pn_BangCongNhan.add(slp_CongNhan);

		slp_CongNhan.setViewportView(tbl_CongNhan);

		tbl_CongNhan.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int index = tbl_CongNhan.getSelectedRow();
				try {
					capNhatLenTruongCongNhan(index);
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}

			private void capNhatLenTruongCongNhan(int index) throws SQLException {
				CongNhan cn = listCongNhan.get(index);
				txt_Ten.setText(cn.getTenCN() != null ? cn.getTenCN() : "");
				cmb_CongDoan.setSelectedIndex(0);
				cmb_SanPham.setSelectedIndex(0);
				cmb_CaLamViec.setSelectedIndex(0);
				dch_NgayPhan.setDate(null);
			}
		});

		dch_NgayPhan = new JDateChooser();
		dch_NgayPhan.setBounds(378, 225, 21, 32);
		add(dch_NgayPhan);

		cmb_SanPham = new JComboBox();
		cmb_SanPham.setModel(new DefaultComboBoxModel(layDS_SanPham().toArray()));
		cmb_SanPham.setBackground(Color.WHITE);
		cmb_SanPham.setFont(new Font("Tahoma", Font.PLAIN, 14));
		cmb_SanPham.setBounds(202, 152, 365, 32);
		add(cmb_SanPham);

		cmb_CongDoan = new JComboBox();
		try {
			cmb_CongDoan.setModel(new DefaultComboBoxModel(layDS_CongDoanTheoMaSP(
					daoSanPham.timKiemSanPhamBangTen(cmb_SanPham.getSelectedItem().toString()).getMaSP()).toArray()));

		} catch (Exception e) {
			e.printStackTrace();
		}

		cmb_CongDoan.setFont(new Font("Tahoma", Font.PLAIN, 14));
		cmb_CongDoan.setBackground(Color.WHITE);
		cmb_CongDoan.setBounds(202, 189, 365, 32);
		add(cmb_CongDoan);

		cmb_SapXep = new JComboBox();
		cmb_SapXep.setToolTipText("Chọn để sắp xếp bảng");
		cmb_SapXep.setModel(new DefaultComboBoxModel(new String[] { "Không sắp xếp", "Theo tên", "Theo ngày phân" }));
		cmb_SapXep.setFont(new Font("Tahoma", Font.PLAIN, 10));
		cmb_SapXep.setBounds(1118, 10, 113, 22);
		pn_BangPhanCong.add(cmb_SapXep);

		cmb_CaLamViec = new JComboBox();
		cmb_CaLamViec.setModel(new DefaultComboBoxModel(layDS_CaLamViec().toArray()));
		cmb_CaLamViec.setFont(new Font("Tahoma", Font.PLAIN, 14));
		cmb_CaLamViec.setBackground(Color.WHITE);
		cmb_CaLamViec.setBounds(202, 113, 183, 32);
		add(cmb_CaLamViec);

		btn_Xoa = new JButton("Xóa");
		btn_Xoa.setToolTipText("Làm rỗng các thông tin trên");
		btn_Xoa.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btn_Xoa.setBounds(905, 301, 105, 32);
		add(btn_Xoa);

		btn_XoaTrang = new JButton("Xóa trắng");
		btn_XoaTrang.setToolTipText("Làm rỗng các thông tin trên");
		btn_XoaTrang.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btn_XoaTrang.setBounds(792, 301, 105, 32);
		add(btn_XoaTrang);

		btn_Sua = new JButton("Sửa");

		btn_Sua.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btn_Sua.setBounds(1020, 301, 105, 32);
		add(btn_Sua);
		btn_PhanCong = new JButton("Phân Công");
		btn_PhanCong.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btn_PhanCong.setBounds(1135, 301, 105, 32);
		add(btn_PhanCong);

		btn_PhanCong.addActionListener(this);
		btn_Sua.addActionListener(this);
		btn_Xoa.addActionListener(this);
		btn_XoaTrang.addActionListener(this);

		dch_NgayPhan.addPropertyChangeListener(this);
		cmb_CongDoan.addActionListener(this);
		cmb_SanPham.addActionListener(this);
		cmb_SapXep.addActionListener(this);

	}

	private List<String> layDS_SanPham() throws SQLException {
		Dao_SanPham daoSanPham = new Dao_SanPham(ConnectDB.getInstance().getConnection());
		List<String> list = new ArrayList<String>();
		daoSanPham.layDS_SanPham().forEach(i -> list.add(i.getTenSP()));
		return list;
	}

	private List<String> layDS_CongDoanTheoMaSP(String maSP) throws SQLException {
		Dao_CongDoan dao_CongDoan = new Dao_CongDoan(ConnectDB.getInstance().getConnection());
		List<String> list = new ArrayList<String>();
		list.add("null");
		dao_CongDoan.timKiemCongDoanBangMaSanPham(maSP).forEach(i -> list.add(i.getTenCD()));
		return list;
	}
	private List<String> layDS_CongDoan() throws SQLException {
		Dao_CongDoan dao_CongDoan = new Dao_CongDoan(ConnectDB.getInstance().getConnection());
		List<String> list = new ArrayList<String>();
		list.add("null");
		dao_CongDoan.layDS_CongDoan().forEach(i -> list.add(i.getTenCD()));
		return list;
	}
	private List<String> layDS_CaLamViec() throws SQLException {
		Dao_CaLamViec daoCaLamViec = new Dao_CaLamViec(ConnectDB.getInstance().getConnection());
		List<String> list = new ArrayList<String>();
		list.add("null");
		daoCaLamViec.layDS_CaLamViec().forEach(i -> list.add(i.layTenCa()));
		return list;
	}

	private int layKQSoSanh(String tenNVHC1, String tenNVHC2) {

		String[] arrTenNVHC1 = tenNVHC1.split(" ");
		String[] arrTenNVHC2 = tenNVHC2.split(" ");

		if (arrTenNVHC1[arrTenNVHC1.length - 1].compareTo(arrTenNVHC2[arrTenNVHC2.length - 1]) != 0)
			return arrTenNVHC1[arrTenNVHC1.length - 1].compareTo(arrTenNVHC2[arrTenNVHC2.length - 1]);

		return arrTenNVHC1[arrTenNVHC1.length - 1].compareTo(arrTenNVHC2[arrTenNVHC2.length - 1]);
	}

	private void capNhatBang() {
		tableModel_DSPhanCong.setList(listPhieuPhanCong);
		tbl_PhanCong.updateUI();
	}

	private String layThayDoi(PhieuPhanCong ppcCu, PhieuPhanCong ppcMoi) {
		String thayDoi = "";
		if (ppcCu.getNgayPhan().compareTo(ppcMoi.getNgayPhan()) != 0)
			thayDoi += "    *Ngày sinh: '"
					+ new SimpleDateFormat("dd/MM/yyyy").format(Date.valueOf(ppcCu.getNgayPhan())) + "' thành '"
					+ new SimpleDateFormat("dd/MM/yyyy").format(Date.valueOf(ppcMoi.getNgayPhan())) + "'\n";

		if (!ppcCu.getCaLamViec().getMaCLV().equals(ppcCu.getCaLamViec().getMaCLV()))
			thayDoi += "    *Ca Làm việc: '" + ppcCu.getCaLamViec().layTenCa() + "' thành '"
					+ ppcMoi.getCaLamViec().layTenCa() + "'\n";

		if (!ppcCu.getCongDoan().getSanPham().getMaSP().equals(ppcMoi.getCongDoan().getSanPham().getMaSP()))
			thayDoi += "    *Sản phẩm: '" + ppcCu.getCongDoan().getSanPham().getTenSP() + "' thành '"
					+ ppcMoi.getCongDoan().getSanPham().getTenSP() + "'\n";

		if (!ppcCu.getCongDoan().getMaCD().equals(ppcMoi.getCongDoan().getMaCD()))
			thayDoi += "    *Công đoạn: '" + ppcCu.getCongDoan().getTenCD() + "' thành '"
					+ ppcMoi.getCongDoan().getTenCD() + "'\n";

		return thayDoi;
	}

	private CaLamViec layCaLamViec() throws SQLException {
		Dao_CaLamViec dao_CaLamViec = new Dao_CaLamViec(ConnectDB.getInstance().getConnection());

		String tenCaLamViec = (String) layDS_CaLamViec().toArray()[cmb_CaLamViec.getSelectedIndex()];

		String maCa = "";
		if (tenCaLamViec.equals("Ca 1"))
			maCa = "clv_0000000";
		if (tenCaLamViec.equals("Ca 2"))
			maCa = "clv_0000001";
		if (tenCaLamViec.equals("Ca 3"))
			maCa = "clv_0000002";
		return dao_CaLamViec.timKiemCaLamViecBangMa(maCa);
	}

	private SanPham laySanPham() throws SQLException {
		Dao_SanPham dao_SanPham = new Dao_SanPham(ConnectDB.getInstance().getConnection());
		String tenSanPham = (String) layDS_SanPham().toArray()[cmb_SanPham.getSelectedIndex()];

		return dao_SanPham.timKiemSanPhamBangTen(tenSanPham);
	}

	private CongDoan layCongDoan() throws SQLException {
		Dao_CongDoan dao_CongDoan = new Dao_CongDoan(ConnectDB.getInstance().getConnection());
		String tenCongDoan = (String) layDS_CongDoanTheoMaSP(laySanPham().getMaSP()).toArray()[cmb_CongDoan
				.getSelectedIndex()];
		return dao_CongDoan.timKiemCongDoanBangTen(tenCongDoan);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if (o.equals(btn_XoaTrang)) {
			txt_Ten.setText("");
			cmb_CaLamViec.setSelectedIndex(0);
			cmb_SanPham.setSelectedIndex(0);
			cmb_CongDoan.setSelectedIndex(0);
			dch_NgayPhan.setDate(null);
		} else if (o.equals(btn_Xoa)) {
			int index = tbl_PhanCong.getSelectedRow();
			if (index < 0) {
				JOptionPane.showMessageDialog(this, "Chưa chọn phiếu phân công!", "Phần Mềm Tính Lương", 2);
				return;
			}
			int i = JOptionPane.showConfirmDialog(this,
					"Bạn có muốn xóa phiếu phân công có mã \"" + listPhieuPhanCong.get(index).getMaPPC() + "\" không?",
					"Phần Mềm Tính Lương", 2);
			if (i == 0) {
				try {
					daoPhanCong.xoaPhieuPhanCong(listPhieuPhanCong.get(index).getMaPPC());

					listPhieuPhanCong = daoPhanCong.layDS_PhanCong();
					capNhatBang();
					JOptionPane.showMessageDialog(this, "Xóa thành công!", "Phần Mềm Tính Lương", 2);
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(this, "Xóa thất bại!", "Phần Mềm Tính Lương", 2);
				}
			} else
				return;
		} else if (o.equals(btn_Sua)) {
			int index = tbl_PhanCong.getSelectedRow();
			if (index < 0) {
				JOptionPane.showMessageDialog(this, "Chưa chọn phiếu phân công!", "Phần Mềm Tính Lương", 2);
				return;
			}
			PhieuPhanCong p = new PhieuPhanCong();
			PhieuPhanCong pCu = listPhieuPhanCong.get(index);
			try {
				p = new PhieuPhanCong(pCu.getMaPPC(),
						dch_NgayPhan.getDate() != null
								? LocalDate.parse(new SimpleDateFormat("yyyy-MM-dd").format(dch_NgayPhan.getDate()))
								: null,
						pCu.getCongNhan(), layCongDoan(), layCaLamViec());

			} catch (NumberFormatException e2) {
				e2.printStackTrace();
			} catch (SQLException e2) {
				e2.printStackTrace();
			}
			String thayDoi = layThayDoi(pCu, p);
			if (thayDoi.equals("")) {
				JOptionPane.showMessageDialog(this, "Không có sự thay đổi mới nào!", "Phần Mềm Tính Lương", 2);
				return;
			}
			int i = JOptionPane.showConfirmDialog(this,
					"Sửa thông tin phiếu phân công có mã '" + pCu.getMaPPC() + "':\n" + thayDoi, "Phần Mềm Tính Lương",
					2);
			if (i == 0) {
				boolean rs = daoPhanCong.suaPhieuPhanCong(p);
				if (rs) {
					JOptionPane.showMessageDialog(this, "Sửa thành công!", "Phần Mềm Tính Lương", 1);
					try {
						listPhieuPhanCong = daoPhanCong.layDS_PhanCong();
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
					capNhatBang();
				} else
					JOptionPane.showMessageDialog(this, "Sửa thất bại!", "Phần Mềm Tính Lương", 1);
			}
		} else if (o.equals(btn_PhanCong)) {
			PhieuPhanCong p = null;
			try {
				p = new PhieuPhanCong(
						dch_NgayPhan.getDate() != null
								? LocalDate.parse(new SimpleDateFormat("yyyy-MM-dd").format(dch_NgayPhan.getDate()))
								: null,
						daoCongNhan.timKiemCongNhan("", txt_Ten.getText(), "", null, "").get(0), layCongDoan(), layCaLamViec());

			} catch (NumberFormatException e2) {
				e2.printStackTrace();
			} catch (SQLException e2) {
				e2.printStackTrace();
			}
			boolean rs = daoPhanCong.themPhieuPhanCong(p);
			if (rs) {
				JOptionPane.showMessageDialog(this, "Phân công thành công!", "Phần Mềm Tính Lương", 1);
				try {
					listPhieuPhanCong = daoPhanCong.layDS_PhanCong();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				capNhatBang();
			} else
				JOptionPane.showMessageDialog(this, "Phân công thất bại!", "Phần Mềm Tính Lương", 2);

		} else if (o.equals(cmb_SapXep)) {
			if (cmb_SapXep.getSelectedIndex() == 0) {
				Collections.sort(listPhieuPhanCong, (p1, p2) -> p1.getMaPPC().compareTo(p2.getMaPPC()));
				capNhatBang();
			} else if (cmb_SapXep.getSelectedIndex() == 1) {
				Collections.sort(listPhieuPhanCong,
						(p1, p2) -> layKQSoSanh(p1.getCongNhan().getTenCN(), p2.getCongNhan().getTenCN()));
				capNhatBang();
			} else if (cmb_SapXep.getSelectedIndex() == 2) {
				Collections.sort(listPhieuPhanCong, (p1, p2) -> p1.getNgayPhan().compareTo(p2.getNgayPhan()));
				capNhatBang();
			}
		}else if (o.equals(cmb_SanPham)) {
			try {
				cmb_CongDoan.setModel(new DefaultComboBoxModel(layDS_CongDoanTheoMaSP(
						daoSanPham.timKiemSanPhamBangTen(cmb_SanPham.getSelectedItem().toString()).getMaSP()).toArray()));

			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}

	}

	@Override
	public void propertyChange(PropertyChangeEvent evt) {
		Object o = evt.getSource();
		if (o.equals(dch_NgayPhan) && dch_NgayPhan.getDate() != null)
			txt_NgayPhan.setText(new SimpleDateFormat("dd/MM/yyyy").format(dch_NgayPhan.getDate()));
	}
}
