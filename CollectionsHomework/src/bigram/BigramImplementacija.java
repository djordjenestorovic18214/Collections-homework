package bigram;

import java.util.HashMap;
import java.util.Iterator;

public class BigramImplementacija {
	
	public void ubaciBigrameUMapuIzStringa(String tekst, HashMap<String, Integer> hashMap) {
		for (int i = 0; i < tekst.length() - 1; i++) {
			String bigram = tekst.substring(i, i + 2);
			if (!hashMap.containsKey(bigram)) {
				hashMap.put(bigram, frekvencijaBigrama(bigram, tekst));
			}
		}
	}
	
	public int frekvencijaBigrama(String bigram, String tekst) {
		int brojac = 0;
		
		if (bigram.length() != 2) {
			throw new RuntimeException("Greska!Bigram mora imati 2 slova!");
		}
		
		for (int i = 0; i < tekst.length() - 1; i++) {
			if (tekst.substring(i, i + 2).equals(bigram)) {
				brojac++;
			}
		}	
		return brojac;
	}

	@SuppressWarnings("rawtypes")
	public void ispisi(HashMap<String, Integer> hashMap) {	
		Iterator<?> i = hashMap.entrySet().iterator();
		
		while (i.hasNext()) {
			HashMap.Entry b = (HashMap.Entry) i.next();
			System.out.println(b.getKey() + " " + b.getValue());
		}
	}
}
