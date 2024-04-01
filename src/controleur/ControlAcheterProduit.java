package controleur;

import frontiere.Clavier;
import personnages.Gaulois;
import villagegaulois.*;

public class ControlAcheterProduit {
	private Village village;
	private ControlTrouverEtalVendeur controlTrouverEtalVendeur;
	private ControlVerifierIdentite controlVerifierIdentite;

	public ControlAcheterProduit(ControlVerifierIdentite controlVerifierIdentite,
			ControlTrouverEtalVendeur controlTrouverEtalVendeur,
			Village village) {
		this.village = village;
		this.controlVerifierIdentite = controlVerifierIdentite;
		this.controlTrouverEtalVendeur = controlTrouverEtalVendeur;
	}

	//TODO a completer
	public boolean verifierIdentiteAcheteur(String nomAcheteur) {
		return controlVerifierIdentite.verifierIdentite(nomAcheteur);
	}
	// très très moyen... mais je n'ai pas accès à controlVerifierIdentite dans le Boundary Acheter
	
	
	
	public Gaulois[] trouverVendeurs(String produit) {
		return this.village.rechercherVendeursProduit(produit);
	}
	
	public Etal allerEtal(String nomVendeur) {
		return controlTrouverEtalVendeur.trouverEtalVendeur(nomVendeur);
	}
	
	
	public int acheterProduit(String nomVendeur, int quantite) {
		
		//if (ControlVerifierIdentite.verifierIdentite(nomVendeur))

			
			Etal etalVendeur = controlTrouverEtalVendeur.trouverEtalVendeur(nomVendeur);			
			//String etatEtal[] = etalVendeur.etatEtal();
			if (etalVendeur == null) {
				return -1;
			} else {
				return etalVendeur.acheterProduit(quantite);
			}

	}
}
