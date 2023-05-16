package mis;

import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.stream.Stream;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import mis.Dators.PROCESORS;
import mis.Dators.RAM;
import mis.Dators.SSD;
import mis.Dators.VIDEOKARTE;
import mis.Pasutijums.FAILU_IZMERS;
import mis.Pasutijums.MERKIS;
import mis.Pasutijums.PIELIETOJUMS;

public class UI {
    private static HashMap<Object, String> nosaukumi = new HashMap<Object, String>();
    private static HashMap<String, Object> opcijas = new HashMap<String, Object>();
	
	public static void uzstadit() {
		opcijas.put("Ikdienai", PIELIETOJUMS.IKDIENAI);
		opcijas.put("Videospēlēm", PIELIETOJUMS.VIDEOSPELEM);
		opcijas.put("Darbam", PIELIETOJUMS.DARBAM);
		
		opcijas.put("Zemākā cena", MERKIS.ZEMAKA_CENA);
		opcijas.put("Veiktspēja", MERKIS.VEIKTSPEJA);
		
		opcijas.put("Zem 512Gb", FAILU_IZMERS.BELOW_512GB);
		opcijas.put("Virs 512Gb", FAILU_IZMERS.ABOVE_512GB);
		opcijas.put("Virs 1Tb", FAILU_IZMERS.ABOVE_1TB);
		
		nosaukumi.put(PIELIETOJUMS.IKDIENAI, "Ikdienai");
		nosaukumi.put(PIELIETOJUMS.VIDEOSPELEM, "Videospēlēm");
		nosaukumi.put(PIELIETOJUMS.DARBAM, "Darbam");
		
		nosaukumi.put(MERKIS.ZEMAKA_CENA, "Zemākā cena");
		nosaukumi.put(MERKIS.VEIKTSPEJA, "Veiktspēja");
		
		nosaukumi.put(FAILU_IZMERS.BELOW_512GB, "Zem 512Gb");
		nosaukumi.put(FAILU_IZMERS.ABOVE_512GB, "Virs 512Gb");
		nosaukumi.put(FAILU_IZMERS.ABOVE_1TB, "Virs 1Tb");
		
		nosaukumi.put(PROCESORS.RYZEN_3, "Ryzen 3");
		nosaukumi.put(PROCESORS.RYZEN_5, "Ryzen 5");
		nosaukumi.put(PROCESORS.RYZEN_7, "Ryzen 7");
		
		nosaukumi.put(VIDEOKARTE.INTEGRETA, "Integrētā videokarte");
		nosaukumi.put(VIDEOKARTE.RTX_3060TI, "RTX 3060TI");
		nosaukumi.put(VIDEOKARTE.RTX_4080, "RTX 4080");
		
		nosaukumi.put(RAM.M_8GB, "8GB RAM");
		nosaukumi.put(RAM.M_16GB, "16GB RAM");
		nosaukumi.put(RAM.M_32GB, "32GB RAM");
		
		nosaukumi.put(SSD.M_512GB, "512GB SSD");
		nosaukumi.put(SSD.M_1TB, "1TB SSD");
		nosaukumi.put(SSD.M_2TB, "2TB SSD");
	}

    public UI() {
    	JFrame jFrame = new JFrame("Datora komplektētājs");
    	
    	JLabel t1Label = new JLabel("Pielietojums");
    	t1Label.setBounds(10, 10, 160, 20);
    	Stream<Object> pielietojumi = Stream.of(PIELIETOJUMS.values()).map(val -> nosaukumi.get(val));
    	JComboBox<String> pComboBox = new JComboBox<>(pielietojumi.toArray(String[]::new));
    	pComboBox.setBounds(10, 30, 160, 20);
    	jFrame.add(t1Label);
        jFrame.add(pComboBox);
        
        JLabel t2Label = new JLabel("Mērķis");
        t2Label.setBounds(10, 60, 160, 20);
        Stream<Object> merki = Stream.of(MERKIS.values()).map(val -> nosaukumi.get(val));
        JComboBox<String> mComboBox = new JComboBox<>(merki.toArray(String[]::new));
        mComboBox.setBounds(10, 80, 160, 20);
        jFrame.add(t2Label);
        jFrame.add(mComboBox);
        
        JLabel t3Label = new JLabel("Esošo failu izmērs");
        t3Label.setBounds(10, 110, 160, 20);
        Stream<Object> failuIzmeri = Stream.of(FAILU_IZMERS.values()).map(val -> nosaukumi.get(val));
        JComboBox<String> fComboBox = new JComboBox<>(failuIzmeri.toArray(String[]::new));
        fComboBox.setBounds(10, 130, 160, 20);
        jFrame.add(t3Label);
        jFrame.add(fComboBox);
        

        JButton jButton = new JButton("Komplektēt datoru");
        jButton.setBounds(10, 160, 160, 20);
        jFrame.add(jButton);
        
        
        JLabel pLabel = new JLabel("Procesors: ");
        pLabel.setBounds(10, 190, 200, 20);
        jFrame.add(pLabel);
        
        JLabel vLabel = new JLabel("Videokarte: ");
        vLabel.setBounds(10, 220, 200, 20);
        jFrame.add(vLabel);
        
        JLabel rLabel = new JLabel("RAM: ");
        rLabel.setBounds(10, 250, 200, 20);
        jFrame.add(rLabel);
        
        JLabel sLabel = new JLabel("SSD: ");
        sLabel.setBounds(10, 280, 200, 20);
        jFrame.add(sLabel);
        
        JLabel cLabel = new JLabel("Cena: ");
        cLabel.setBounds(10, 310, 200, 20);
        jFrame.add(cLabel);
        
        jFrame.setLayout(null);
        jFrame.setSize(350, 400);
        jFrame.setVisible(true);

        jButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Pasutijums pasutijums = new Pasutijums(
                		(PIELIETOJUMS) opcijas.get(pComboBox.getItemAt(pComboBox.getSelectedIndex())),
                		(MERKIS) opcijas.get(mComboBox.getItemAt(mComboBox.getSelectedIndex())),
                		(FAILU_IZMERS) opcijas.get(fComboBox.getItemAt(fComboBox.getSelectedIndex()))
            		);
                
                Dators dators = pasutijums.SanemtIeteikumu();
                
                pLabel.setText("Procesors: " + nosaukumi.get(dators.procesors));
                vLabel.setText("Videokarte: " + nosaukumi.get(dators.videokarte));
                rLabel.setText("RAM: " + nosaukumi.get(dators.ram));
                sLabel.setText("SSD: " + nosaukumi.get(dators.ssd));
                cLabel.setText(String.format("Cena: %.2f€", dators.AprekinatCenu()));
            }
        });	
    }
}
