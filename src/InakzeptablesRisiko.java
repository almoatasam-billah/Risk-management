import java.util.Objects;

public class InakzeptablesRisiko extends Risiko {
	
	protected String massnahme; 
	
	InakzeptablesRisiko(String Bezeichnung,float eintrittswahrscheinlichkeit, float kosten_im_schadenfall, String massnahme) {
		super(Bezeichnung, eintrittswahrscheinlichkeit, kosten_im_schadenfall);
		this.massnahme = massnahme;
	}
	
	@Override
	public float ermittleRueckstellung() {
		return berechneRisikowert();
	}
	
	public void druckeDaten() {
		System.out.printf("ID %d Inakzeptables Risiko \"%s\" aus %s; \n"
				+ "Risikowert %.2f; Ruckstellung %.2f; Maßnahme \"%s\"\n", id, Bezeichnung, erstellungsdatum, berechneRisikowert(), ermittleRueckstellung(), massnahme);
	}
	
	

	public boolean equals(Object obj) {
		
		if (this == obj) return true;
		if (obj == null || this.getClass() != obj.getClass()) return false;
		if (!super.equals(obj)) return false;
		
		InakzeptablesRisiko other = (InakzeptablesRisiko) obj;
		return this.massnahme.equals(other.massnahme);
			
		}
	
	public int hashCode() {
	    return Objects.hash(super.hashCode(), massnahme);
	}


	
	
	
}
