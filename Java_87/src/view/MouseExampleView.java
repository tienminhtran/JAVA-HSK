package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.HeadlessException;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Controller.MouseExampleController;
import model.MouseExampleModel;

public class MouseExampleView extends JFrame{
	private MouseExampleModel mouseExampleModel;
	private JPanel jp_mouse;
	private JLabel jl_x;
	private JLabel jl_y;
	private JLabel jl_position;
	private JLabel jl_name_click;
	private JLabel jl_click_mac_dinh;
	private JLabel jl_1;
	private JLabel jl_mouse_checkin;
	private JLabel jl_mouse_checkin_mac_dinh;
	private JLabel jl_2;

	public MouseExampleView() throws HeadlessException {
		this.mouseExampleModel = new MouseExampleModel();
		this.init();
	}

	private void init() {
		this.setTitle("MouseExample");
		this.setSize(700,700);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		// set font
		Font f = new Font("Cambria", Font.PLAIN, 20);

		// mouse listener
		MouseExampleController mec = new MouseExampleController(this);
		
		
		// khung di chuột
		jp_mouse = new JPanel();
		jp_mouse.setLayout(new BorderLayout());
		jp_mouse.setBackground(Color.CYAN);
		jp_mouse.setOpaque(true);
		jp_mouse.addMouseListener(mec);
		jp_mouse.addMouseMotionListener(mec);
		
		// khung hiển thị
		JPanel jp_hienthi = new JPanel();
		jp_hienthi.setLayout(new GridLayout(3,3));
		
		jl_position = new JLabel("Position");
		jl_position.setFont(f);
		
		jl_x = new JLabel("x = ");	
		jl_x.setFont(f);

		jl_y = new JLabel("y = ");
		jl_y.setFont(f);

		jl_name_click = new JLabel("Number of click: ");
		jl_name_click.setFont(f);

		jl_click_mac_dinh = new JLabel("n");
		jl_click_mac_dinh.setFont(f);

		jl_1 = new JLabel(); //rỗng 
		jl_1.setFont(f);

		jl_mouse_checkin = new JLabel("Mouse is in component: ");
		jl_mouse_checkin.setFont(f);

		jl_mouse_checkin_mac_dinh = new JLabel("No");
		jl_mouse_checkin_mac_dinh.setFont(f);

		jl_2 = new JLabel();
		jl_2.setFont(f);

		jp_hienthi.add(jl_position);
		jp_hienthi.add(jl_x);
		jp_hienthi.add(jl_y);
		jp_hienthi.add(jl_name_click);
		jp_hienthi.add(jl_click_mac_dinh);
		jp_hienthi.add(jl_1);
		jp_hienthi.add(jl_mouse_checkin);
		jp_hienthi.add(jl_mouse_checkin_mac_dinh);
		jp_hienthi.add(jl_2);
		
		//khung chính
		
		this.setLayout(new BorderLayout());
		this.add(jp_mouse, BorderLayout.CENTER);
		this.add(jp_hienthi, BorderLayout.SOUTH);


		this.setVisible(true);
	}
	
	public void dem_click()
	{
		this.mouseExampleModel.dem_click();
		this.jl_click_mac_dinh.setText(this.mouseExampleModel.getDem()+"");
	}
	//enter
	public void divao() {
		this.mouseExampleModel.enter();
		this.jl_mouse_checkin_mac_dinh.setText(this.mouseExampleModel.getCheck());
	}
	//exit
	public void dira() {
		this.mouseExampleModel.exit();
		this.jl_mouse_checkin_mac_dinh.setText(this.mouseExampleModel.getCheck());
	}

	public void layToaDo(int x, int y) {
		this.mouseExampleModel.setX(x);
		this.mouseExampleModel.setY(y);
		this.jl_x.setText("x= " +this.mouseExampleModel.getX());
		this.jl_y.setText("y= " + this.mouseExampleModel.getY());

	}
}
