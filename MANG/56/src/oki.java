import java.util.Arrays;

public class oki {
	public static void main(String[] args) {
		String s="Xin chao cac ban,tui la peter!";
		String[] a=s.split("\\chao|\\la");
		for(String word:a) 
		{
			System.out.println(word);
		}
		

	}
}
