package frontiere;

import java.util.Scanner;

import controleur.ControlPrendreEtal;
import personnages.Gaulois;


public class BoundaryPrendreEtal {
	private ControlPrendreEtal controlPrendreEtal;
	private Scanner scan = new Scanner(System.in);

	public BoundaryPrendreEtal(ControlPrendreEtal controlChercherEtal) {
		this.controlPrendreEtal = controlChercherEtal;
	}

	public void prendreEtal(String nomVendeur) {
		//TODO a completer

		if (! controlPrendreEtal.verifierIdentite(nomVendeur)) {
			System.out.println("Désolé " + nomVendeur + " mais il faut être habitant de notre village pour commercer ici.");
		} else {
			System.out.println("Bonjour " + nomVendeur + ", je vais regarder si je peux vous trouver un étal.");
			
			if (controlPrendreEtal.resteEtals()) {
				System.out.println("C'est parfait, il me reste un étal pour vous !");
				installerVendeur(nomVendeur);
				
			}
			else {
				System.out.println("Malheureusement, plus aucun étal n'est disponible.");
			}
		}
	}

	private void installerVendeur(String nomVendeur) {
		//TODO a completer
		System.out.println("Il me faudrait quelques renseignements :");
		System.out.println("Quel produit souhaitez-vous vendre ?");
		String produit = scan.next();
		System.out.println("Combien souhaitez-vous en vendre ?");
		int qte = scan.nextInt();
		int nbEtal = controlPrendreEtal.prendreEtal(nomVendeur, produit, qte);
		System.out.println("Le vendeur " + nomVendeur + " s'est installé à l'étal n° " + nbEtal);
	}
}
