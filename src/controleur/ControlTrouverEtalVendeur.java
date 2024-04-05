package controleur;

import personnages.Gaulois;
import villagegaulois.Etal;
import villagegaulois.Village;

public class ControlTrouverEtalVendeur {
	private Village village;

	public ControlTrouverEtalVendeur(Village village) {
		this.village = village;
	}

	public Etal trouverEtalVendeur(String nomVendeur) {
		//TODO a completer
		Etal etal = null;
		Gaulois vendeur = village.trouverHabitant(nomVendeur);

		if (vendeur != null) {
			etal = village.rechercherEtal(vendeur);
		}
		// pas n�cessaire car rechercherEtal m�ne � Marche.trouverVendeur qui renvoie null si n'a pas trouv� le vendeur
		return etal;
	}
}
