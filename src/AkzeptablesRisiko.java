

class AkzeptablesRisiko extends Risiko {
	
	 AkzeptablesRisiko(String Bezeichnung,float eintrittswahrscheinlichkeit, float kosten_im_schadenfall) {
		super(Bezeichnung, eintrittswahrscheinlichkeit, kosten_im_schadenfall);
	}
	 
	@Override 
	
	public float ermittleRueckstellung() {
		return 0;
	}
	
	public void druckeDaten() {
		System.out.printf("ID %d Akzeptables Risiko \"%s\" aus %s;\n"
				+"Risikowerk %.2f; Ruckstellung %.2f\n", id, Bezeichnung, erstellungsdatum, berechneRisikowert(), ermittleRueckstellung());
		
		}
	
	public boolean equals(Object obj) {
		
		if (this == obj) return true;
		if (obj == null || this.getClass() != obj.getClass()) return false;
		return super.equals(obj);
		
		}
	
	public int hashCode() {
		return super.hashCode();
	}
	
	
	
	
	
}
