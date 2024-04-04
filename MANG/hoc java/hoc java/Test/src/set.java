import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.TreeSet;

public class set {
	public static void main(String[] args) {
		Set<Integer> set= new Set<>();
		HashSet<Integer> set1= new HashSet<>();
		set.add(1);
		set.add(2);
		set.add(3);
		set.add(1);
		set.add(4);
		set.add(4);
		set1.add(1);
		set1.add(2);
		set1.add(3);
//		for(Integer i: set) 
//		{
//			System.out.println(i);
//		}
////		System.out.println(set.size());
////		System.out.println(set.contains(4));
//		set.retainAll(set1);
//		for(Integer i: set1) 
//		{
//			System.out.println(i);
//		}
		TreeSet<Integer> ds= new TreeSet<>();
		ds.add(4);
		ds.add(2);
		ds.add(1);
		ds.add(3);
		for (Integer integer : ds) {
			System.out.print(integer+" ");
		}
		
	}
}
