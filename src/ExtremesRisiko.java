import java.util.Objects;

class ExtremesRisiko extends InakzeptablesRisiko {
	
	protected float versicherungsbeitrag;
	
	ExtremesRisiko(String Bezeichnung,float eintrittswahrscheinlichkeit, float kosten_im_schadenfall, String massnahme, float versicherungsbeitrag) {
		super(Bezeichnung, eintrittswahrscheinlichkeit, kosten_im_schadenfall, massnahme);
		this.versicherungsbeitrag = versicherungsbeitrag;
	}
	
	@Override
	
	public float ermittleRueckstellung() {
		return this.versicherungsbeitrag;
	}
	
	public void druckeDaten() {
		System.out.printf("ID %d Extremes Risiko \"%s\" aus %s;\n"
				+"Risikowerk %.2f; Ruckstellung %.2f; Maßnahme \"%s\"\n", id, Bezeichnung, erstellungsdatum, berechneRisikowert(), ermittleRueckstellung(), massnahme);
	}
	

	public boolean equals(Object obj) {
		
		if (this == obj) return true;
		if (obj == null || this.getClass() != obj.getClass()) return false;
		if (!super.equals(obj)) return false;
		
		ExtremesRisiko other = (ExtremesRisiko) obj;
		return this.versicherungsbeitrag == other.versicherungsbeitrag;
			
		}
	
	public int hashCode() {
	    return Objects.hash(super.hashCode(), versicherungsbeitrag);
	}


	
	
}
