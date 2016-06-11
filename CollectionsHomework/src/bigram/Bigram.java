package bigram;

import java.util.HashMap;

public class Bigram {	
	
	public static void main(String[] args) {
		
		BigramImplementacija b = new BigramImplementacija();
		
		HashMap <String, Integer> hashMap = new HashMap<>();
		
		String ulaz = "abbcceeeeeeabcc";
		
		b.ubaciBigrameUMapuIzStringa(ulaz, hashMap);
		
		b.ispisi(hashMap);
		
		System.out.println("\nRezultat: " +b.predvidjanjeKaraktera(hashMap, "ja"));
	}	
	
}
