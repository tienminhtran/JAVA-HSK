package GK2023;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class DocGhiFile implements Serializable{
	public Object docFile(String file) throws Exception {
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
		Object list = ois.readObject();
		ois.close();
		return list;
	}
	
	public static void ghiFile(String file, QuanLy_Phong ds) throws Exception  {
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file));
		oos.writeObject(ds);
		oos.close();
	}
}
