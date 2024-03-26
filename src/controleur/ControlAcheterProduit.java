package controleur;

import frontiere.Clavier;
import personnages.Gaulois;
import villagegaulois.Village;

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
	
	public void acheterProduit(String produit) {
		
		//if (ControlVerifierIdentite.verifierIdentite(nomVendeur))
		
		
		Gaulois vendeurs[] = village.rechercherVendeursProduit(produit);
		if (vendeurs == null) {
			System.out.println("Désolé, personne ne vend ce produit au marché.");
		} else {
			System.out.println("Chez quel commerçant voulez-vous acheter des "+ produit + " ?");
			int indice;
			//indice pour afficher "1 - Bonemmine" et non "0 - Bonemine"
			for (int i = 0; i < vendeurs.length; i++) {
				indice = i + 1;
				System.out.println(indice + " - " + vendeurs[i].getNom());
			}
			
			StringBuilder question = new StringBuilder();
			int choixUtilisateur = -1;
			do {
				choixUtilisateur = Clavier.entrerEntier(question.toString());
			} while (choixUtilisateur <= 0 && choixUtilisateur > vendeurs.length + 1);
			//
			
			System.out.println(" se déplace jusqu'à l'étal du vendeur " + vendeurs[choixUtilisateur].getNom());
			//comment mettre nom acheteur ??
			
			
			
		}
		
		
		
		
		
		
	}
}
