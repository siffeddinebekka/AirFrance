package controleur;

import javax.swing.JPanel;

import modele.Modele;
import vue.VueConnexion;
import vue.VueGenerale;

public class AirFrance {
	private static VueConnexion uneConnexion ; 
	private static VueGenerale uneVueGenerale ; 
	
	public static void rendreVisibleVueConnexion (boolean action)
	{
		uneConnexion.setVisible(action);
	}
	public static void rendreVisibleVueGenerale (boolean action)
	{
		uneVueGenerale.setVisible(action);
	}
	
	public static void instancierVueGenerale ()
	{
		uneVueGenerale = new VueGenerale(); //construire la vue
	}
	
	public static void fermerVueGenerale ()
	{
		uneVueGenerale.dispose(); //detruire la vue
	}
	public static void main(String[] args) {
		uneConnexion = new VueConnexion(); 
	}
 
	/********** Gestion des Users ******************/
	public static User selectWhereUser (String email, String mdp)
	{
		// On reçoit email et mdp : et on réalise le controle 
		// de l'email et le cryptage du mdp 
		
		User unUser = Modele.selectWhereUser(email, mdp); 
		
		return unUser; 
	}
}












