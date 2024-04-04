package test;

import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.concurrent.TimeUnit;

public class test {
	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		//ham lay thoi gian hien tai
		long t1= System.currentTimeMillis();
		for(int i=0;i<10;i++) 
		{
			System.out.println("TEST");
		}
		long t2=System.currentTimeMillis();
		System.out.println("Truoc khi chay for: "+t1);
		System.out.println("Sau khi chay for: "+t2);
		System.out.println("Thoi gian: "+(t2-t1)+"s");
		
		//timeUnit
//		System.out.println("3000 nam = "+TimeUnit.DAYS.toSeconds(3000*365));
//		System.out.println("3h = "+TimeUnit.HOURS.toSeconds(3));
//		System.out.println("10h= "+TimeUnit.HOURS.toDays(24));
		
		//Date
		Date f= new Date(System.currentTimeMillis());
		System.out.println(f.getDate()+"/"+(f.getMonth()+1)+"/"+ (f.getYear()+1900));
		//Calendar

		Calendar c = Calendar.getInstance();
		System.out.println(c.get(Calendar.DATE)+"-"+(c.get(Calendar.MONTH)+1)+"-"+c.get(Calendar.YEAR));
		c.add(Calendar.HOUR, 10); 
		System.out.println(c.get(Calendar.DATE)+"-"+(c.get(Calendar.MONTH)+1)+"-"+c.get(Calendar.YEAR));
		c.add(Calendar.DATE, 14);
		System.out.println(c.get(Calendar.DATE)+"-"+(c.get(Calendar.MONTH)+1)+"-"+c.get(Calendar.YEAR));
		//DateFormat
		DateFormat df= new SimpleDateFormat();
		System.out.println(df.format(f));
		df= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	//	System.out.println(df.format(f));
		
	
	
	
	}
		
}
