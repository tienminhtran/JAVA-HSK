package main;

import java.util.LinkedList;
import java.util.Queue;

public class ViduQuere {
	public static void main(String[] args) {
		Queue<String> danhsachsv= new LinkedList<String>();
		danhsachsv.offer("TITV 1");
		danhsachsv.offer("Nguyen Van A");
		danhsachsv.offer("Nguyen Van B");
		danhsachsv.offer("TITV 2");
		while(true) {
			String ten= danhsachsv.poll();//lay ra nhung ko xoa
			if(ten==null) break;
				
			System.out.println(ten);
		}
	}
}
