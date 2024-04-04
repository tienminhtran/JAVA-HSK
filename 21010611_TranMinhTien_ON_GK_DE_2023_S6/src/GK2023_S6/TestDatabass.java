package GK2023_S6;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Writer;

import javax.swing.JOptionPane;

public class TestDatabass {

	public TestDatabass() {
		// TODO Auto-generated constructor stub
	}
//	public void savefile (String name, Object o) {
//		FileOutputStream fos = null;
//		ObjectOutputStream oos = null;
//		try {
//			fos = new FileOutputStream(name);
//			oos = new ObjectOutputStream(fos);
//			oos.writeObject(o);
//			oos.close();
//		} catch (Exception e) {
//			// TODO: handle
//			exception
//			JOptionPane.showMessageDialog(null, "Lỗi");
//			return;
//		}
//	}
//	public Object readfile(String name) {
//		FileInputStream fis = null;
//		ObjectInputStream ois = null;
//		Object o = null;
//		try {
//			fis = new FileInputStream(name);
//			ois = new ObjectInputStream(fis);
//			o = ois.readObject();
//			ois.close();
//			
//			
//		} catch (Exception e) {
//			// TODO: handle exception
//			JOptionPane.showMessageDialog(null, "Lỗi");
//
//		}
//		return o;
//	}
	
//	public void ghi(String name, Object o) {
//		FileOutputStream fos = null;
//		ObjectOutputStream ois = null;
//		
//		try {
//			fos = new FileOutputStream(name);
//			ois = new ObjectOutputStream(fos);
//			ois.writeObject(o);
//			ois.close();
//		} catch (Exception e) {
//			// TODO: handle exception
//			JOptionPane.showMessageDialog(null, "Loi");
//			return;
//		}
//	}
//	
//	public Object doc(String name) {
//		FileInputStream fis = null;
//		ObjectInputStream ios = null;
//		Object o = null;
//		try {
//			fis = new FileInputStream(name);
//			ios = new ObjectInputStream(fis);
//			o = ios.readObject();
//			ios.close();
//		} catch (Exception e) {
//			// TODO: handle exception
//			JOptionPane.showMessageDialog(null, "Loi");
//
//		}
//		return o;
//	}
	
	//save
	public void saveFile (String name, Object o) {
		FileOutputStream fis = null;
		ObjectOutputStream ois = null;
		try {
			fis = new FileOutputStream(name);
			ois = new ObjectOutputStream(fis);
			ois.writeObject(ois);
			ois.close();
		} catch (Exception e) {
			// TODO: handle exception
			JOptionPane.showMessageDialog(null, "Loi");
			return;
		}
		
	}
	
	public Object readFile(String name) {
		FileInputStream fis = null;
		ObjectInputStream ois = null;
		Object o = null;
		try {
			fis = new FileInputStream(name);
			ois = new ObjectInputStream(fis);
			o = ois.readObject();
			ois.close();
		} catch (Exception e) {
			// TODO: handle exception
			JOptionPane.showMessageDialog(null, "Loi");

		}
		return o;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
