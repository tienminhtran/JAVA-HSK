
package GUI;

import java.awt.BorderLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;

import entity.Congty;
import entity.NhanVien;
import entity.PhongBan;

public class Application extends JFrame{

	private ArrayList<PhongBan>dspb;
	private DefaultMutableTreeNode root;
	private JTree tree;

	public Application(ArrayList<PhongBan> dspb) {
		super();
		this.setTitle("---^^---");
//		this.setExtendedState(MAXIMIZED_BOTH);
		this.setSize(800,480);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.dspb = dspb;
		
		root = new DefaultMutableTreeNode("Danh sách phòng ban");
		tree= new JTree(root);
		tree.setShowsRootHandles(true);
		
		int sophongban = dspb.size();
		for(int i = 0; i<sophongban; i++) {
			PhongBan pb = dspb.get(i);
			DefaultMutableTreeNode node = new DefaultMutableTreeNode(pb);
			root.add(node);
		}
		add(new JScrollPane(tree), BorderLayout.CENTER);
		tree.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				if(e.getClickCount()==2) {
					DefaultMutableTreeNode x = (DefaultMutableTreeNode) tree.getLastSelectedPathComponent();
					if(x!=null) {
						Object gt = x.getUserObject();
						if(gt instanceof PhongBan) {
							PhongBan pb = (PhongBan) x.getUserObject();
							ArrayList<NhanVien> dsnv = pb.getDsnv();
							NhanvienGIU giu = new NhanvienGIU(dsnv, pb.getTenPhong());
							giu.show();
						}
					}
				}
			}
		});
	}
		
	public static void main(String[] args) {
		Congty ct = new Congty();
		PhongBan tc, kt;
		ct.themPhongBna(tc = new PhongBan("TC", "Phòng Tài chính"));
		ct.themPhongBna(kt = new PhongBan("KT", "Phòng Kỹ Thuật"));
		
		
		tc.themNhanVien("1112", "Trần", "Na", true, 25, 366666);
		kt.themNhanVien("8888", "Trần", "Tiến", true, 25, 366666);
		tc.themNhanVien("1111", "Trần", "Huỳnh", true, 25, 366666);
		kt.themNhanVien("1000", "Phan", "Sinh", true, 15, 366666);
		kt.themNhanVien("7777", "Nguyễn", "Tài", true, 15, 366666);
		tc.themNhanVien("6666", "Trần", "Kỹ", false, 25, 366666);
		
		

		
		ArrayList<PhongBan> dspb = ct.getDspb();
		new Application(dspb).setVisible(true);
	}
	
}
