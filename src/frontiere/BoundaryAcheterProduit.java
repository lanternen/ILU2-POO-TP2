package frontiere;

import java.util.Scanner;

import controleur.ControlAcheterProduit;
import personnages.Gaulois;
import villagegaulois.Etal;

public class BoundaryAcheterProduit {
	private Scanner scan = new Scanner(System.in);
	private ControlAcheterProduit controlAcheterProduit;

	public BoundaryAcheterProduit(ControlAcheterProduit controlAcheterProduit) {
		this.controlAcheterProduit = controlAcheterProduit;
	}

	public void acheterProduit(String nomAcheteur) {
		// TODO à completer
		
		///////////////// vérification de l'identité de l'acheteur
		
		if (! controlAcheterProduit.verifierIdentiteAcheteur(nomAcheteur)) {
			System.out.println("Je suis désolé " + nomAcheteur + ", mais il faut etre un habitant de notre village pour commercer ici");
		} else {
			
			////////////////// demander le produit désiré
			
			System.out.println("Quel produit voulez-vous acheter ?");
			String produit = scan.next();
			
			
			///////////////// trouver les vendeurs du produit		
			
			Gaulois vendeurs[] = controlAcheterProduit.trouverVendeurs(produit);
			if (vendeurs == null) {
				System.out.println("Désolé, personne ne vend ce produit au marché.");
			} else {
				
				////////////////////// sélection du commerçant
				
				System.out.println("Chez quel commerçant voulez-vous acheter des " + produit + " ?");
				int indice;
				//indice pour afficher "1 - Bonemmine" et non "0 - Bonemine"
				for (int i = 0; i < vendeurs.length; i++) {
					indice = i + 1;
					System.out.println(indice + " - " + vendeurs[i].getNom());
				}
				
				//StringBuilder question = new StringBuilder();
				int choixUtilisateur = -1;
				do {
					// Clavier.entrerEntier(question.toString()
					choixUtilisateur = scan.nextInt();
					choixUtilisateur -= 1;			// - 1 car j'ai rajouté + 1 à l'indice plus haut
				} while (choixUtilisateur < 0 || choixUtilisateur > vendeurs.length - 1);

				
				
				
				////////////////// déplacement à l'étal
								
				String nomVendeur = vendeurs[choixUtilisateur].getNom();
				System.out.println(nomAcheteur + " se déplace jusqu'à l'étal du vendeur " + nomVendeur);
				System.out.println("Bonjour " + nomAcheteur);
				
				
				
				////////////////// demander quantite
				
				Etal etalVendeur = controlAcheterProduit.allerEtal(nomVendeur);			
				
				if (etalVendeur == null) {
					System.out.println("cet étal n'existe pas");
				} else {
					String etatEtal[] = etalVendeur.etatEtal();
					int qteDispo = Integer.parseInt(etatEtal[3]);
					
					System.out.println("Combien de " + produit + " voulez-vous acheter ?");
					int quantite = scan.nextInt();
					
					
					controlAcheterProduit.acheterProduit(nomAcheteur, quantite);
					
					
					///////////////// possibilités selon quantité et quantité disponibl à la vente
					///////////////// + achat du produit
					int nbAchete;
					
					if (qteDispo == 0)
					{
						// encore problème nom acheteur
						System.out.println(nomAcheteur + " veut acheter " + quantite + " " + produit + ", malheureusement il n'y en a plus !");
					}
					else {
						if (quantite < qteDispo) {
							nbAchete = controlAcheterProduit.acheterProduit(nomVendeur, quantite);
							System.out.println(nomAcheteur + " achète " + nbAchete + " " + produit + " à " + nomVendeur);
						} else {
							nbAchete = controlAcheterProduit.acheterProduit(nomVendeur, quantite);
							System.out.println(nomAcheteur + " veut acheter " + quantite +  " " + produit + ", malheureusement " + nomVendeur +
									" n'en a plus que " + qteDispo + ". " + nomAcheteur + " achète tout le stock de " + nomVendeur);
						}
					}
					
					/////////////// achat du produit
					
					//int nbAchete = controlAcheterProduit.acheterProduit(nomVendeur, quantite);
					//System.out.println(nomAcheteur + " achète " + nbAchete + " " + produit + " à " + nomVendeur);
				}
				
				
	
				
			}
	
		}
		

	}
}
