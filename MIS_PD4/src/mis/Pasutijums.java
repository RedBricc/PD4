package mis;

public class Pasutijums {
	public enum PIELIETOJUMS {IKDIENAI, VIDEOSPELEM, DARBAM};
	public enum MERKIS {ZEMAKA_CENA, VEIKTSPEJA};
	public enum FAILU_IZMERS {BELOW_512GB, ABOVE_512GB, ABOVE_1TB};
	
	private PIELIETOJUMS pielietojums = PIELIETOJUMS.IKDIENAI;
	private MERKIS merkis = MERKIS.ZEMAKA_CENA;
	private FAILU_IZMERS failuIzmers = FAILU_IZMERS.BELOW_512GB;
	
	private Dators dators;
	
	public Pasutijums(PIELIETOJUMS pielietojums, MERKIS merkis, FAILU_IZMERS failuIzmers) {
		this.pielietojums = pielietojums;
		this.merkis = merkis;
		this.failuIzmers = failuIzmers;
	}
	
	public Dators SanemtIeteikumu() {
		dators = new Dators();
		
		// Procesors
		if(merkis == MERKIS.VEIKTSPEJA) {
			dators.procesors = Dators.PROCESORS.RYZEN_5;
		}
		if(pielietojums == PIELIETOJUMS.DARBAM) {
			dators.procesors = Dators.PROCESORS.RYZEN_7;
		}
		if(merkis == MERKIS.ZEMAKA_CENA && pielietojums == PIELIETOJUMS.DARBAM) {
			dators.procesors = Dators.PROCESORS.RYZEN_5;
		}
		
		// Videokarte
		if(merkis == MERKIS.VEIKTSPEJA) {
			dators.videokarte = Dators.VIDEOKARTE.RTX_3060TI;
		}
		if(pielietojums == PIELIETOJUMS.DARBAM || pielietojums == PIELIETOJUMS.VIDEOSPELEM) {
			dators.videokarte = Dators.VIDEOKARTE.RTX_4080;
		}
		if(merkis == MERKIS.ZEMAKA_CENA && (pielietojums == PIELIETOJUMS.DARBAM || pielietojums == PIELIETOJUMS.VIDEOSPELEM)) {
			dators.videokarte = Dators.VIDEOKARTE.RTX_3060TI;
		}
		
		// SSD
		if(merkis == MERKIS.VEIKTSPEJA) {
			dators.ssd = Dators.SSD.M_1TB;
		}
		if(pielietojums == PIELIETOJUMS.DARBAM || pielietojums == PIELIETOJUMS.VIDEOSPELEM) {
			dators.ssd = Dators.SSD.M_2TB;
		}
		if(merkis == MERKIS.ZEMAKA_CENA && (pielietojums == PIELIETOJUMS.DARBAM || pielietojums == PIELIETOJUMS.VIDEOSPELEM)) {
			dators.ssd = Dators.SSD.M_1TB;
		}
		if(failuIzmers == FAILU_IZMERS.ABOVE_512GB && dators.ssd == Dators.SSD.M_512GB)
		{
			dators.ssd = Dators.SSD.M_1TB;
		}
		if(failuIzmers == FAILU_IZMERS.ABOVE_1TB)
		{
			dators.ssd = Dators.SSD.M_2TB;
		}
		
		// RAM
		if(merkis == MERKIS.VEIKTSPEJA || pielietojums == PIELIETOJUMS.VIDEOSPELEM) {
			dators.ram = Dators.RAM.M_16GB;
		}
		if(pielietojums == PIELIETOJUMS.DARBAM) {
			dators.ram = Dators.RAM.M_32GB;
		}
		if(merkis == MERKIS.ZEMAKA_CENA && pielietojums == PIELIETOJUMS.DARBAM) {
			dators.ram = Dators.RAM.M_16GB;
		}
		
		return dators;
	}
}
