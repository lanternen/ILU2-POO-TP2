package controleur;

import villagegaulois.Village;

public class ControlVerifierIdentite {
	private Village village;

	public ControlVerifierIdentite(Village village) {
		this.village = village;
	}

	public boolean verifierIdentite(String nomVendeur) {
		//TODO a completer, attention le retour ne dit pas etre false :-)
		
		//� moi-m�me
		//trouverHabitant retourne soit null, soit un gaulois
		//gaulois qu'elle a trouv� dans le tableau de villageois
		//donc si elle est pas null, c'est qu'elle a trouv� l'habitant "nomVendeur" dans le village
		return village.trouverHabitant(nomVendeur) != null;
	}
}
