package controleur;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import personnages.*;
import villagegaulois.Etal;
import villagegaulois.Village;

class ControlAcheterProduitTest {

	private Village village;
	private Chef abraracourcix;
	private Gaulois obelix;
	private ControlVerifierIdentite controlVerifierIdentite;
	private ControlTrouverEtalVendeur controlTrouverEtalVendeur;
	
	@BeforeEach
	public void initialiserSituation() {
		System.out.println("Initialisation...");
		village = new Village("le village des irr�ductibles", 10, 5);
		abraracourcix = new Chef("Abraracourcix", 10, village);
		village.setChef(abraracourcix);
		
		obelix = new Gaulois ("obelix", 5);
		village.ajouterHabitant(obelix);
		village.installerVendeur(obelix, "sanglier", 5);
		
		controlVerifierIdentite = new ControlVerifierIdentite(village);
		controlTrouverEtalVendeur = new ControlTrouverEtalVendeur(village);
	}

	@Test
	void testControlAcheterProduit() {
		ControlAcheterProduit controlAcheterProduit = new ControlAcheterProduit(controlVerifierIdentite, controlTrouverEtalVendeur,
				village);
		assertNotNull(controlAcheterProduit, "Constructeur ne renvoie pas null");
	}

	@Test
	void testVerifierIdentiteAcheteur() {
		ControlAcheterProduit controlAcheterProduit = new ControlAcheterProduit(controlVerifierIdentite, controlTrouverEtalVendeur,
				village);
		assertFalse(controlAcheterProduit.verifierIdentiteAcheteur("inconnu"));
		assertTrue(controlAcheterProduit.verifierIdentiteAcheteur("obelix"));
	}

	@Test
	void testTrouverVendeurs() {
		ControlAcheterProduit controlAcheterProduit = new ControlAcheterProduit(controlVerifierIdentite, controlTrouverEtalVendeur,
				village);
		assertNull(controlAcheterProduit.trouverVendeurs("non-produit"));
		assertNotNull(controlAcheterProduit.trouverVendeurs("sanglier"));
		Gaulois vendeursSanglier[] = controlAcheterProduit.trouverVendeurs("sanglier");
		assertEquals(obelix, vendeursSanglier[0]);		//ça marche, je suis très fier
											// blague à part, pas possible de comparer le résultat de la fonction à obelix seul
									// car c'est évidemment une comparaison avec un tableau, même s'il n'a qu'une case
	}

	@Test
	void testAllerEtal() {
		ControlAcheterProduit controlAcheterProduit = new ControlAcheterProduit(controlVerifierIdentite, controlTrouverEtalVendeur,
				village);
		Etal etal = controlTrouverEtalVendeur.trouverEtalVendeur("obelix");
		assertEquals(etal, controlAcheterProduit.allerEtal("obelix"));
				// bizarre que ça marche du 1er coup, il va m'arriver un truc grave pour compenser...
		assertNull(controlAcheterProduit.allerEtal("marco"));
		
	}

	@Test
	void testAcheterProduit() {
		ControlAcheterProduit controlAcheterProduit = new ControlAcheterProduit(controlVerifierIdentite, controlTrouverEtalVendeur,
				village);
		
		assertEquals(-1, controlAcheterProduit.acheterProduit("inconnu", 5));
		assertEquals(5, controlAcheterProduit.acheterProduit("obelix", 6));
						// 5 attendu, 6 de désiré car obelix en vend que 5, cas dégradé (je crois)
		
	}

}
