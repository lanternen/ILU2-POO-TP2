package controleur;

import personnages.Gaulois;
import villagegaulois.Village;

public class ControlPrendreEtal {
	private Village village;
	private ControlVerifierIdentite controlVerifierIdentite;

	public ControlPrendreEtal(ControlVerifierIdentite controlVerifierIdentite,
			Village village) {
		this.controlVerifierIdentite = controlVerifierIdentite;
		this.village = village;
	}

	public boolean resteEtals() {
		//TODO a completer, attention le retour ne dit pas etre false :-)
		
		return village.rechercherEtalVide();
	}

	public int prendreEtal(String nomVendeur, String produit, int nbProduit) {
		//TODO a completer
		int numeroEtal = -1;
		
		Gaulois nouveauVendeur = village.trouverHabitant(nomVendeur);
		
		if (resteEtals()) {
			numeroEtal = village.installerVendeur(nouveauVendeur, produit, nbProduit);
		}
		
		return numeroEtal + 1;
		//c'est l'indice qui est retourné donc j'incrémente de 1 en attente d'une meilleur solution
	}

	public boolean verifierIdentite(String nomVendeur) {
		//TODO a completer, attention le retour ne dit pas etre false :-)
		
		return controlVerifierIdentite.verifierIdentite(nomVendeur);
	}
}
