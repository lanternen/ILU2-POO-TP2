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
	 *         indiquant si l'�tal est occup� [1] : nom du vendeur [2] : produit
	 *         vendu [3] : quantit� de produit à vendre au d�but du march� [4] :
	 *         quantit� de produit vendu
	 */
	public String[] libererEtal(String nomVendeur) {
		//TODO a completer
		String[] donneesEtal = null; 
		
				
		Etal etal = controlTrouverEtalVendeur.trouverEtalVendeur(nomVendeur);
		if (etal != null) {
			donneesEtal = etal.etatEtal();
			etal.libererEtal();
		}
				
//		etatEtal dans Etal -> donne l'�tat de l'�tal et la case � 0 est d�j� pour le bool�en
//		donneesEtal = Etal.etatEtal();
//		maj : j'ai ecrit  ca 30 min avant de comprendre que c'�tait la solution
//		
//		
		
		return donneesEtal;
	}

}
