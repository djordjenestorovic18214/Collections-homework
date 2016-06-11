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
			throw new RuntimeException("Greska! Bigram mora imati tacno 2 slova!");
		}
		
		for (int i = 0; i < tekst.length() - 1; i++) {
			if (tekst.substring(i, i + 2).equals(bigram)) {
				brojac++;
			}
		}	
		return brojac;
	}

	public void ispisi(HashMap<String, Integer> hashMap) {	
		Iterator<?> itr = hashMap.entrySet().iterator();
		
		while (itr.hasNext()) {
			HashMap.Entry b = (HashMap.Entry) itr.next();
			System.out.println(b.getKey() + " " + b.getValue());
		}
	}
	
	public String predvidjanjeKaraktera(HashMap<String, Integer> hashMap, String tekst) {
		for (int i = 0; i < 3; i++) {
			int max = 0;
			String kraj = tekst.substring(tekst.length()-1);
			Iterator<?> itr = hashMap.entrySet().iterator();
			String bigram = null;
			
			while (itr.hasNext()) {
				HashMap.Entry h = (HashMap.Entry) itr.next();
				String key = (String)h.getKey();
				if (key.startsWith(kraj)) {
					if ((Integer) h.getValue() > max) {
						bigram = (String) h.getKey();
						max = (Integer) h.getValue();
					}
				}
			}
			tekst = tekst.concat(bigram.substring(1));
		}
		return tekst;
	}
}
