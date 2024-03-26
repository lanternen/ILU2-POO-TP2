package frontiere;

import java.util.Scanner;

import controleur.ControlAcheterProduit;

public class BoundaryAcheterProduit {
	private Scanner scan = new Scanner(System.in);
	private ControlAcheterProduit controlAcheterProduit;

	public BoundaryAcheterProduit(ControlAcheterProduit controlAcheterProduit) {
		this.controlAcheterProduit = controlAcheterProduit;
	}

	public void acheterProduit(String nomAcheteur) {
		// TODO à completer
		
		if (! controlAcheterProduit.verifierIdentiteAcheteur(nomAcheteur)) {
			System.out.println("Je suis désolé " + nomAcheteur + ", mais il faut etre un habitant de notre village pour commercer ici");
		} else {
			System.out.println("Quel produit voulez-vous acheter ?");
			String produit = scan.next();
			
			controlAcheterProduit.acheterProduit(produit);
		}
		
		
		
	}
}
