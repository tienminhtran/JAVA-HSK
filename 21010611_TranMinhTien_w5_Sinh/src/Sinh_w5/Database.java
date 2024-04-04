package Sinh_w5;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import javax.swing.JOptionPane;

public class Database {
//	public Database() {
//		// TODO Auto-generated constructor stub
//	}
	//Ghi file
		public void saveFile(String fileName, Object o) {
			FileOutputStream fos = null;
			ObjectOutputStream oos = null;
			try {
				fos = new FileOutputStream(fileName);
				oos = new ObjectOutputStream(fos);
				oos.writeObject(o);
				oos.close();
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "Không có dữ liệu");
				return;
			}
		}
		
		//Đọc file
		public Object readFile(String fileName) {
			FileInputStream fis = null;
			ObjectInputStream ois = null;
			Object object = null;
			try {
				fis = new FileInputStream(fileName);
				ois = new ObjectInputStream(fis);
				object = ois.readObject();
				ois.close();
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "Không có dữ liệu");
			}
			return object;
		}
}

