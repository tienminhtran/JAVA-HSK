package name;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;

public class Rutthamhashset {
	Set<String> thungphieu= new HashSet<String>();
	public Rutthamhashset() {
	}
	public boolean themphieu(String giatri)
	{
		return this.thungphieu.add(giatri);
	}
	public boolean xoaphieu(String giatri) 
	{
		return this.thungphieu.remove(giatri);
	}
	public boolean kiemtraphieutontai(String giatri) 
	{
		return this.thungphieu.contains(giatri);
	}
	public void xoatatcaphieuduthuong() 
	{
		 this.thungphieu.clear();
	}
	public int laysoluong() 
	{
		return this.thungphieu.size();
	}
	public String rut1phieu() 
	{
		String ketqua="";
		Random rd= new Random();
		int vitri= rd.nextInt(this.thungphieu.size());
		ketqua =(String)this.thungphieu.toArray()[vitri];
		return ketqua;
	}
	public void inratatcacacphieu() 
	{
//		for (String string : thungphieu) {
//			System.out.println(string);
//		}
		System.out.println(Arrays.toString(this.thungphieu.toArray()));
		
	}
	public static void main(String[] args) {	
		int luachon=0;
		Scanner sc= new Scanner(System.in);
		Rutthamhashset rt= new Rutthamhashset();
		do 
		{
			
			System.out.println("-------------------------------");
			System.out.println("MENU: ");
			System.out.println("0. Thoat khoi chuong trinh.");
			System.out.println("1. Them ma so du thuong.");
			System.out.println("2. Xoa 1 ma so du thuong.");
			System.out.println("3. Kiem tra ma so du thuong co tai tai hay khong?.");
			System.out.println("4. Xoa tat ca cac phieu du thuong.");
			System.out.println("5. So luong phieu du thuong.");
			System.out.println("6. Rut tham trung thuong.");
			System.out.println("7. In ra tat ca cac phieu.");
			luachon=sc.nextInt();
			sc.nextLine();
			if(luachon==1||luachon==2||luachon==3) 
			{
				System.out.println("Nhap vao ma phieu du thuong: ");
				String giatri= sc.nextLine();
				if(luachon==1) 
				{
					rt.themphieu(giatri);
				}
				else if(luachon==2) 
				{
					rt.xoaphieu(giatri);
				}
				else 
				{
					System.out.println("Ket qua kiem tra: "+rt.kiemtraphieutontai(giatri));
				}
			}
			else if(luachon==4) 
			{
				rt.xoatatcaphieuduthuong();
			}
			else if(luachon==5) 
			{
				System.out.println("So luong phieu la: "+rt.laysoluong());
			}
			else if(luachon==6) 
			{
				System.out.println("Ma so trung thuong la: "+rt.rut1phieu());
			}
			else if(luachon==7) 
			{
				System.out.println("Cac ma phieu du thuong la: ");
				rt.inratatcacacphieu();
			}
		}
		while(luachon!=0);
	}

	
}
