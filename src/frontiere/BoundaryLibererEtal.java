package frontiere;

import controleur.ControlLibererEtal;

public class BoundaryLibererEtal {
	private ControlLibererEtal controlLibererEtal;

	public BoundaryLibererEtal(ControlLibererEtal controlLibererEtal) {
		this.controlLibererEtal = controlLibererEtal;
	}

	public void libererEtal(String nomVendeur) {
		//TODO a completer
		
		if (! controlLibererEtal.isVendeur(nomVendeur)) {
			System.out.println("Mais vous n'�tes pas inscrit sur notre march� aujourd'hui !");
		}
		else {
			controlLibererEtal.libererEtal(nomVendeur);
		}
		
	}

}
