package controleur;

import villagegaulois.*;
import personnages.*;

public class ControlLibererEtal {
	private ControlTrouverEtalVendeur controlTrouverEtalVendeur;

	public ControlLibererEtal(
			ControlTrouverEtalVendeur controlTrouverEtalVendeur) {
		this.controlTrouverEtalVendeur = controlTrouverEtalVendeur;
	}

	//TODO a completer
	
	
	public boolean isVendeur(String nomVendeur) {
		return controlTrouverEtalVendeur.trouverEtalVendeur(nomVendeur) != null;
	}

	/**
	 * 
	 * @param produit
	 * @return donneesVente est un tableau de chaine contenant [0] : un boolean
	 *         indiquant si l'étal est occupé [1] : nom du vendeur [2] : produit
	 *         vendu [3] : quantité de produit Ã  vendre au début du marché [4] :
	 *         quantité de produit vendu
	 */
	public String[] libererEtal(String nomVendeur) {
		//TODO a completer
		String[] donneesEtal = null; 
		
				
		Etal etal = controlTrouverEtalVendeur.trouverEtalVendeur(nomVendeur);
		if (etal != null) {
			donneesEtal = etal.etatEtal();
			etal.libererEtal();
		}
				
//		etatEtal dans Etal -> donne l'état de l'étal et la case à 0 est déjà pour le booléen
//		donneesEtal = Etal.etatEtal();
//		màj : j'ai écrit ça 30 min avant de comprendre que c'était la solution
//		
//		
		
		
		return donneesEtal;
	}

}
