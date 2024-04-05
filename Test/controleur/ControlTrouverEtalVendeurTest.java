package controleur;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import personnages.Chef;
import personnages.Gaulois;
import villagegaulois.*;

class ControlTrouverEtalVendeurTest {
	
	private Village village;
	private Chef abraracourcix;
	private Gaulois obelix;
	private Gaulois asterix;
	private Gaulois unix;
	private Gaulois bonemine;
	private Gaulois lix;
	
	@BeforeEach
	public void initialiserSituation() {
		System.out.println("Initialisation...");
		village = new Village("le village des irréductibles", 10, 5);
		abraracourcix = new Chef("Abraracourcix", 10, village);
		village.setChef(abraracourcix);
		
		obelix = new Gaulois ("obelix", 5);
		asterix = new Gaulois ("asterix", 4);
		unix = new Gaulois ("unix", 3);
		bonemine = new Gaulois ("bonemine", 2);
		lix = new Gaulois ("lix", 1);
		
		village.ajouterHabitant(obelix);
		
		village.installerVendeur(obelix, "sanglier", 5);
		
		
	}
	
	
	
	@Test
	void testControlTrouverEtalVendeur() {
		ControlTrouverEtalVendeur controlTrouverEtalVendeur = new ControlTrouverEtalVendeur(village);
		assertNotNull(controlTrouverEtalVendeur, "Constructeur ne renvoie pas null");
	}

	@Test
	void testTrouverEtalVendeur() {
		ControlTrouverEtalVendeur controlTrouverEtalVendeur = new ControlTrouverEtalVendeur(village);
		
		assertNull(controlTrouverEtalVendeur.trouverEtalVendeur("inconnu"));
		assertNotNull(controlTrouverEtalVendeur.trouverEtalVendeur("obelix"));
		assertEquals("sanglier", controlTrouverEtalVendeur.trouverEtalVendeur("obelix").getProduit());
		assertEquals(5, controlTrouverEtalVendeur.trouverEtalVendeur("obelix").getQuantite());
		
		
		// ajouterHabitant avant de faire Installer Vendeur sinon ça ne marche pas !!
		
		
	}

}
