package controleur;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import personnages.Chef;
import personnages.Gaulois;
import villagegaulois.*;

class ControlAfficherMarcheTest {

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
		
		
		village.installerVendeur(obelix, "sanglier", 5);
		village.installerVendeur(asterix, "seringues", 5);
		village.installerVendeur(unix, "programmes", 5);
		village.installerVendeur(bonemine, "poissons", 5);
		village.installerVendeur(lix, "cahiers", 5);
		
		
	}
	
	
	@Test
	void testControlAfficherMarche() {
		ControlAfficherMarche controlAfficherMarche = new ControlAfficherMarche(village);
		assertNotNull(controlAfficherMarche, "Constructeur ne renvoie pas null");
	}

	@Test
	void testDonnerInfosMarche() {
		
		ControlAfficherMarche controlAfficherMarche = new ControlAfficherMarche(village);
		String[] testInfosMarche = controlAfficherMarche.donnerInfosMarche();
		
		
	
//		//marche not null
		//assertNotNull(village.donnerEtatMarche()) --> c'est le controleur qu'on veut tester
		assertNotNull(testInfosMarche);
//		//taille tableau attendue
		assertEquals(5, village.donnerNbEtal());
		//5 car c'est le nombre d'étal donné dans le @BeforeEach
		
//		
//		// ensuite le test avec la boucle
		for (int i = 0; i < village.donnerNbEtal(); i++) {
			assertNotNull(testInfosMarche[i], "vendeur null");
		}
		
		
		
			
			
			
	}

}
