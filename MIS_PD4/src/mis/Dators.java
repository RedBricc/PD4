package mis;

import java.util.HashMap;

public class Dators {
	public static enum PROCESORS {RYZEN_3, RYZEN_5, RYZEN_7};
	public static enum VIDEOKARTE {INTEGRETA, RTX_3060TI, RTX_4080};
	public static enum RAM {M_8GB, M_16GB, M_32GB};
	public static enum SSD {M_512GB, M_1TB, M_2TB};
	
	private static HashMap<Object, Double> cenas = new HashMap<Object, Double>();
	
	public static void uzstaditCenas() {
		cenas.put(PROCESORS.RYZEN_3, 84.90);
		cenas.put(PROCESORS.RYZEN_5, 256.99);
		cenas.put(PROCESORS.RYZEN_7, 349.00);
		
		cenas.put(VIDEOKARTE.INTEGRETA, 0.0);
		cenas.put(VIDEOKARTE.RTX_3060TI, 459.00);
		cenas.put(VIDEOKARTE.RTX_4080, 1462.79);
		
		cenas.put(RAM.M_8GB, 22.99);
		cenas.put(RAM.M_16GB, 47.18);
		cenas.put(RAM.M_32GB, 94.00);
		
		cenas.put(SSD.M_512GB, 38.09);
		cenas.put(SSD.M_1TB, 62.70);
		cenas.put(SSD.M_2TB, 192.01);
	}
	
	public PROCESORS procesors;
	public VIDEOKARTE videokarte;
	public RAM ram;
	public SSD ssd;
	
	public Dators() {
		procesors = PROCESORS.RYZEN_3;
		videokarte = VIDEOKARTE.INTEGRETA;
		ram = RAM.M_8GB;
		ssd = SSD.M_512GB;
	}
	
	public Double AprekinatCenu() {
		return 	300 + // Tiek pieņemts, ka pārējās datora komponentes maksā 300eur
				cenas.get(procesors) + 
				cenas.get(videokarte) + 
				cenas.get(ram) + 
				cenas.get(ssd);
	}
}
