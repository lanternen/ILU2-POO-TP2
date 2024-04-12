package controleur;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import personnages.Chef;
import personnages.Gaulois;
import villagegaulois.Village;

class ControlLibererEtalTest {
	
	private Village village;
	private Chef abraracourcix;
	private ControlTrouverEtalVendeur controlTrouverEtalVendeur;
	private Gaulois obelix;

	@BeforeEach
	public void initialiserSituation() {
		System.out.println("Initialisation...");
		village = new Village("le village des irr�ductibles", 10, 5);
		abraracourcix = new Chef("Abraracourcix", 10, village);
		village.setChef(abraracourcix);
		
		obelix = new Gaulois ("obelix", 5);
		village.ajouterHabitant(obelix);
		village.installerVendeur(obelix, "sanglier", 5);
		
		this.controlTrouverEtalVendeur = new ControlTrouverEtalVendeur(village); // important pour passer dans les asserts
																				// des 2 dernières fonctions ici
	}
	
	@Test
	void testControlLibererEtal() {
		ControlLibererEtal controlLibererEtal = new ControlLibererEtal(controlTrouverEtalVendeur);
		assertNotNull(controlLibererEtal, "Constructeur ne renvoie pas null");
	}

	@Test
	void testIsVendeur() {
		ControlLibererEtal controlLibererEtal = new ControlLibererEtal(controlTrouverEtalVendeur);
		assertFalse(controlLibererEtal.isVendeur("inconnu"));
		assertFalse(controlLibererEtal.isVendeur("Bonemine"));
		assertTrue(controlLibererEtal.isVendeur("obelix"));
	}

	@Test
	void testLibererEtal() {
		ControlLibererEtal controlLibererEtal = new ControlLibererEtal(controlTrouverEtalVendeur);
		assertNull(controlLibererEtal.libererEtal("inconnu"));
		assertNotNull(controlLibererEtal.libererEtal("obelix"));	//assert que le tab retourné ne soit pas null
	}

}
