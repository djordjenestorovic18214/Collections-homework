package bigram;

import java.util.HashMap;
import java.util.Iterator;

public class Bigram {	
	public static void main(String[] args) {
		BigramImplementacija b = new BigramImplementacija();
		HashMap <String, Integer> hashMap = new HashMap<>();
		String tekst = "abbcceeeeeeabcc";
		b.ubaciBigrameUMapuIzStringa(tekst, hashMap);
		b.ispisi(hashMap);
	}	
}
