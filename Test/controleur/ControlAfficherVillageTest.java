package controleur;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import personnages.*;
import villagegaulois.Village;

class ControlAfficherVillageTest {
	
	private Village village;
	private Chef abraracourcix;
	private Gaulois obelix;
	private Gaulois asterix;

	@BeforeEach
	public void initialiserSituation() {
		System.out.println("Initialisation...");
		village = new Village("le village des irréductibles", 10, 5);
		abraracourcix = new Chef("Abraracourcix", 10, village);
		village.setChef(abraracourcix);
		
		obelix = new Gaulois ("obelix", 5);
		asterix = new Gaulois ("asterix", 4);
		
		village.ajouterHabitant(obelix);
		village.ajouterHabitant(asterix);
	}
	
	
	
	@Test
	void testControlAfficherVillage() {
		ControlAfficherVillage controlAfficherVillage = new ControlAfficherVillage(village);
		assertNotNull(controlAfficherVillage, "Constructeur ne renvoie pas null");
	}

	@Test
	void testDonnerNomsVillageois() {
		ControlAfficherVillage controlAfficherVillage = new ControlAfficherVillage(village);
		
		String[] habitants = controlAfficherVillage.donnerNomsVillageois();
		
		assertNotNull(habitants);
		
		//le nombre d'habitants (le chef compris)
		assertEquals(3, habitants.length);
		
		for (int i = 0; i < habitants.length; i++) {
			assertNotNull(habitants[i]);
		}
		
	}

	@Test
	void testDonnerNomVillage() {
ControlAfficherVillage controlAfficherVillage = new ControlAfficherVillage(village);
		
		assertEquals(village.getNom(), controlAfficherVillage.donnerNomVillage());
	}

	@Test
	void testDonnerNbEtals() {
		ControlAfficherVillage controlAfficherVillage = new ControlAfficherVillage(village);

		assertEquals(village.donnerNbEtal(), controlAfficherVillage.donnerNbEtals());
		
	}

}
