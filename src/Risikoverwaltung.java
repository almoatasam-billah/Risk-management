import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class Risikoverwaltung {
	
	private List<Risiko> risiken = new ArrayList<Risiko>();
	
	public void aufnehmen(Risiko obj) {
		risiken.add(obj);
	}
	
	public void zeigeRisiken() {
		
		if (risiken.isEmpty()) {
		    System.out.println("Keine Risiken vorhanden.");
		    return;
		}
		
		Collections.sort(risiken);
		
		Iterator<Risiko> it = risiken.iterator();
		
		while(it.hasNext()) {
			it.next().druckeDaten();
			System.out.println();
		}
	}
	
	public void sucheRisikoMitMaxRueckstellung() {
		
		if (risiken.isEmpty()) {
		    System.out.println("Keine Risiken vorhanden.");
		    return;
		}
		
		
		Iterator<Risiko> it = risiken.iterator();
		
		Risiko maxRisiko = risiken.get(0);
		
		while(it.hasNext()) {
			Risiko aktuellRisiko = it.next();
			if (aktuellRisiko.ermittleRueckstellung() > maxRisiko.ermittleRueckstellung()) 
				maxRisiko = aktuellRisiko;
		}
		
		maxRisiko.druckeDaten();
		
	}
	
	public float berechneSummeRueckstellungen() {
		if (risiken.isEmpty()) {
			return 0;
		}
		
		float gesamt = 0;
		
		for (Risiko r : risiken) {
			gesamt+= r.ermittleRueckstellung();
		}
		return gesamt;
	}
}
