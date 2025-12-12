
/*
 * Diese Klasse zeigt die Startmenu des Programms und liest Eingabe ein.
 */

import javax.swing.JOptionPane;

public class Menu {
	
    private Risikoverwaltung verwaltung;
    private static final float LIMIT = 1000.0f;
    private static final double KOSTENLIMIT = 10000.0;
	
	public Menu() {
        verwaltung = new Risikoverwaltung();
	}
	
    public void start() {
        
    	boolean run=true;
    	while (run) {
    	int wahl = 0;
        String eingabe = JOptionPane.showInputDialog(
                "Risikoverwaltung\n" +
                "1. Risiko aufnehmen\n" +
                "2. Zeige alle Risiken\n" +
                "3. Zeige Risiko mit maximaler Rückstellung\n" +
                "4. Berechne Summe aller Rückstellungen\n" +
                "5. Beenden\n" +
                "Bitte Menüpunkt wählen:"
            );
        
        if (eingabe == null) {
        	return;
        }

        try {
        wahl = Integer.parseInt(eingabe);
        } catch(NumberFormatException e) {
    		JOptionPane.showMessageDialog(null, "Ungültige Eingabe. Bitte erneut versuchen.");
    		start();
        }
        
                
	        switch (wahl) {
	        case 1:
	        	risikoAufnehmen();
	        	break;
	        case 2: 
	        	verwaltung.zeigeRisiken();
	        	run=false;
	        	break;
	        case 3:
	        	verwaltung.sucheRisikoMitMaxRueckstellung();
	        	run=false;
	        	break;
	        case 4:
	        	System.out.printf("Gesamte Rückstellungen: %.2f%n", verwaltung.berechneSummeRueckstellungen());
	        	run=false;
	        	break;
	        case 5:
	        	System.out.println("Programm beendet.");
	        	run=false;
	        	break;
	        default:
	    		JOptionPane.showMessageDialog(null, "Ungültige Eingabe. Bitte erneut versuchen.");
	        	break;
	        }
	        
         
        }
    }
        
        
    
    
    private void risikoAufnehmen() {
    	
        String bez = null;
        while (true) {
            bez = JOptionPane.showInputDialog("Bezeichnung:");
            if (bez == null) return; 
            if (!bez.isEmpty()) break; 
            JOptionPane.showMessageDialog(null, "Bezeichnung darf nicht leer sein.");
        }
        
	    	
        float wkeit = 0;
        while (true) {
            String wkeitText = JOptionPane.showInputDialog("Eintrittswahrscheinlichkeit (z.B. 0.5):");
            if (wkeitText == null) return;
            try {
                wkeit = Float.parseFloat(wkeitText);
                if (wkeit > 0 && wkeit < 1) {
                    break;
                } else {
                    JOptionPane.showMessageDialog(null, "Wert muss zwischen 0 und 1 liegen.");
                }
                
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Ungültige Wahrscheinlichkeit. Bitte eine Zahl eingeben.");
            }
        }	
        
        float kosten = 0;
        while (true) {
            String kostenText = JOptionPane.showInputDialog("Kosten im Schadensfall:");
            if (kostenText == null) return;
            try {
                kosten = Float.parseFloat(kostenText);
                break;
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Ungültige Kostenangabe. Bitte eine Zahl eingeben.");
            }
        }
        
	        double risikoWert = wkeit * kosten;
	        Risiko risiko;
	        
	        if (risikoWert < LIMIT) {
	        	 risiko = new AkzeptablesRisiko(bez, wkeit, kosten); 
	        }
	        else  {
	            String massnahme = JOptionPane.showInputDialog("Maßnahme bei Risiko:");
	            if (massnahme == null) return;
	            if (kosten > KOSTENLIMIT) {
	                String beitragText = JOptionPane.showInputDialog("Versicherungsbeitrag:");
	                if (beitragText == null) return;
	                float beitrag = Float.parseFloat(beitragText);
	
	                risiko = new ExtremesRisiko(bez, wkeit, kosten, massnahme, beitrag);
	            } else {
	                risiko = new InakzeptablesRisiko(bez, wkeit, kosten, massnahme);
	            }
	        }
	        verwaltung.aufnehmen(risiko);
	        JOptionPane.showMessageDialog(null, "Risiko aufgenommen.");
	        start();
    	}
    	            }    

