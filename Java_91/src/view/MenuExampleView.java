package view;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JToolBar;
import javax.swing.KeyStroke;

import Controller.MenuExampleController;

public class MenuExampleView extends JFrame {

	private JLabel jl;

	public MenuExampleView() {
		this.setTitle("Java 91S");
		this.setSize(700, 700);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLayout(new BorderLayout());

		
		MenuExampleController mec = new MenuExampleController(this);
		
		JMenuBar jmb = new JMenuBar();
			JMenu jm_1 = new JMenu("File");
			jm_1.setMnemonic(KeyEvent.VK_F);
	
				JMenu jm_1_1 = new JMenu("File_1_1");

					JMenuItem jmi_new = new JMenuItem("New");
					jmi_new.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, InputEvent.CTRL_DOWN_MASK));
					jmi_new.addActionListener(mec);
				
				JMenuItem jmi_OpenFile = new JMenuItem("Open File");
				jmi_OpenFile.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, InputEvent.ALT_DOWN_MASK));
				jmi_OpenFile.addActionListener(mec);

					jm_1_1.add(jmi_new);
			
			jm_1.add(jm_1_1);
			jm_1.addSeparator();//tạo dòng kẻ ngang
			jm_1.add(jmi_OpenFile);
			
					
				
			JMenu jm_2 = new JMenu("Edit");
			jm_2.setMnemonic(KeyEvent.VK_E);
			//jm_2.setMnemonic(KeyStroke.getKeyStroke(KeyEvent.VK_E, InputEvent.CTRL_DOWN_MASK));

				JMenuItem jmi_paste = new JMenuItem("Paste");
				jmi_paste.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, InputEvent.CTRL_DOWN_MASK));
				jmi_paste.addActionListener(mec);

				JMenuItem jmi_delete = new JMenuItem("Exit");
				jmi_delete.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X, InputEvent.CTRL_DOWN_MASK));
				jmi_delete.addActionListener(mec);

			jm_2.add(jmi_paste);
			jm_2.addSeparator();//tạo dòng kẻ ngang			
			jm_2.add(jmi_delete);

		jmb.add(jm_1);
		jmb.add(jm_2);
		
		this.setJMenuBar(jmb);
		
		
		
		// TẠO THANH TOOLBAR
		JToolBar jtb = new JToolBar();
		
			JButton jb_run = new JButton("Run");
			jb_run.addActionListener(mec);
			jb_run.setToolTipText("Run");
			
			JButton jb_run_last_tool = new JButton("Run last tool");
			jb_run_last_tool.addActionListener(mec);
			jb_run_last_tool.setToolTipText("Run last tool");

			JButton jb_Open_type = new JButton("Open type");
			jb_Open_type.addActionListener(mec);
			jb_Open_type.setToolTipText("Open type");

			JButton jb_Undo = new JButton("Undo");
			jb_Undo.addActionListener(mec);
			jb_Undo.setToolTipText("Undo");

			JButton jb_Redo = new JButton("Redo");
			jb_Redo.addActionListener(mec);
			jb_Redo.setToolTipText("Redo");

		jtb.add(jb_run);
		jtb.add(jb_run_last_tool);
		jtb.add(jb_Open_type);
		jtb.add(jb_Undo);
		jtb.add(jb_Redo);
		this.add(jtb, BorderLayout.NORTH);

		//khung chính
		jl = new JLabel();
		
		this.add(jl,BorderLayout.CENTER);
		// đẩy toolbar vào khung chính
	
		this.setVisible(true);
		
	}
	public void Text(String s) {
		this.jl.setText(s);
	}
}
