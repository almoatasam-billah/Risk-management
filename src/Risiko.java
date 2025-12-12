
import java.time.LocalDate;
import java.util.Objects;

abstract class Risiko implements Comparable<Risiko> {
	protected final int id;
	protected String Bezeichnung;
	protected float eintrittswahrscheinlichkeit;
	protected float kosten_im_schadenfall;
	protected LocalDate erstellungsdatum;
	protected int year;
	private static int nextID = 0;
	
	public Risiko(String Bezeichnung,float eintrittswahrscheinlichkeit, float kosten_im_schadenfall) {
		this.id = nextID;
		nextID++;
		this.erstellungsdatum = LocalDate.now();
		this.year = erstellungsdatum.getYear();
		this.Bezeichnung = Bezeichnung;
		this.eintrittswahrscheinlichkeit = eintrittswahrscheinlichkeit;
		this.kosten_im_schadenfall = kosten_im_schadenfall;
	}
	
	public float berechneRisikowert() {
		return eintrittswahrscheinlichkeit * kosten_im_schadenfall;
	}
	
	public boolean equals(Object obj) {
		
	    if (this == obj) return true;
		if (obj == null || this.getClass() != obj.getClass()) return false;
		Risiko other = (Risiko) obj;
		if (this.Bezeichnung.equals(other.Bezeichnung) && this.eintrittswahrscheinlichkeit == other.eintrittswahrscheinlichkeit
				&& this.erstellungsdatum.equals(other.erstellungsdatum) && this.kosten_im_schadenfall == other.kosten_im_schadenfall)
		{
			return true;
		} else {
			return false;
		}
		
		}
	
	public int hashCode() {
        return Objects.hash(Bezeichnung, eintrittswahrscheinlichkeit, erstellungsdatum, kosten_im_schadenfall);
    }
	
	
	public abstract float ermittleRueckstellung();
	public abstract void druckeDaten(); 
	
	public int getID() {
		return this.id;
	}
	
	public String getBezeichnung() {
		return this.Bezeichnung;
	}
	
	@Override
    public int compareTo(Risiko other) {
        return Double.compare(this.ermittleRueckstellung(), other.ermittleRueckstellung());
    }

	
	
}
 











