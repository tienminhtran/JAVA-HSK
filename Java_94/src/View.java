import java.awt.BorderLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class View extends JFrame{

	private JMenuBar jmb;
	private JMenu jm;
	private JMenuItem jmi_1;
	private JMenuItem jmi_2;
	private JMenuItem jmi_3;
	public View() {
		this.setTitle("Java 94");
		this.setSize(1620,740);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		//SET icon cho JFAME
		URL url_icon_jfame = View.class.getResource("Apps-text-editor-icon.png");
		Image img = Toolkit.getDefaultToolkit().createImage(url_icon_jfame);
		this.setIconImage(img);
		
		
		jmb = new JMenuBar();
			jm = new JMenu("Menu");
			
					jmi_1 = new JMenuItem("Open");
						
					
					//jmi_1.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(View.class.getResource("folder-open-icon.png"))));
					
						URL url_icon_open = View.class.getResource("folder-open-icon.png");
						Image img_open = Toolkit.getDefaultToolkit().createImage(url_icon_open);
						jmi_1.setIcon(new ImageIcon(img_open));
					
					jmi_2 = new JMenuItem("Save");
						URL url_icon_save = View.class.getResource("Save-icon.png");
						Image img_save = Toolkit.getDefaultToolkit().createImage(url_icon_save);
						jmi_2.setIcon(new ImageIcon(img_save));
					
					jmi_3 = new JMenuItem("Print");
						URL url_icon_Print = View.class.getResource("Devices-printer-icon.png");
						Image img_Print = Toolkit.getDefaultToolkit().createImage(url_icon_Print);
						jmi_3.setIcon(new ImageIcon(img_Print));
						
						
						jm.add(jmi_1);
						jm.add(jmi_2);
						jm.add(jmi_3);
	
				JMenu jm_sub_menu = new JMenu("Sub Menu");
					
					JMenuItem jmi_4 = new JMenuItem("Exit");
						URL url_icon_Exit = View.class.getResource("Close-2-icon.png");
						Image img_Exit = Toolkit.getDefaultToolkit().createImage(url_icon_Exit);
						jmi_4.setIcon(new ImageIcon(img_Exit));
						
					JMenuItem jmi_5 = new JMenuItem("Restore Down");
						URL url_icon_Restore_Down = View.class.getResource("backup-restore-icon.png");
						Image img_Restore_Down = Toolkit.getDefaultToolkit().createImage(url_icon_Restore_Down);
						jmi_5.setIcon(new ImageIcon(img_Restore_Down));
				jm_sub_menu.add(jmi_4);
				jm_sub_menu.add(jmi_5);
	
			jm.add(jm_sub_menu);
		jmb.add(jm);
		
		JLabel jl = new JLabel("..................", JLabel.CENTER);
		jl.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(View.class.getResource("Untitled.png"))));

		JButton jb = new JButton("TEST BUTTON");
		jb.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(View.class.getResource("Button-Ok-icon.png"))));

		jb.setSize(100, 100);

		
		this.setLayout(new BorderLayout());
		this.add(jb, BorderLayout.SOUTH);
		this.add(jl,BorderLayout.CENTER);
		//this.add(jmb, BorderLayout.NORTH);
		this.setJMenuBar(jmb);
		
		this.setVisible(true);

	}
	public static void main(String[] args) {
		new View();
	}
}
