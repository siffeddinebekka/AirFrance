package modele;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import controleur.Avion;
import controleur.PAV;
import controleur.Pilote;
import controleur.User;
import controleur.Vol;

public class Modele {
	//MAC 
	private static Bdd uneBdd=new Bdd("localhost:8889","airfrance_22","root","root");
	//PC
	//private static Bdd uneBdd = new Bdd ("localhost", "airfrance_22", "root", "");
	
	public static int countPilotes() {
		int nbpilotes=0;
		String requete ="select count(*) as nb from pilote ; ";
		try {
			uneBdd.seConnecter();
			Statement unStat = uneBdd.getMaConnexion().createStatement(); 
			ResultSet unResultat= unStat.executeQuery(requete);
			if (unResultat.next())
			{
				nbpilotes = unResultat.getInt("nb");
			}
			unStat.close();
			uneBdd.seDeconnecter();
		}
		catch (SQLException exp) {
			System.out.println("Erreur de requete :"+requete);
		}
		
		return nbpilotes;
	}
	
	public static int countAvions() {
		int nbavions=0;
		String requete ="select count(*) as nb from avion ; ";
		try {
			uneBdd.seConnecter();
			Statement unStat = uneBdd.getMaConnexion().createStatement(); 
			ResultSet unResultat= unStat.executeQuery(requete);
			if (unResultat.next())
			{
				nbavions = unResultat.getInt("nb");
			}
			unStat.close();
			uneBdd.seDeconnecter();
		}
		catch (SQLException exp) {
			System.out.println("Erreur de requete :"+requete);
		}
		
		return nbavions;
	}
	
	public static int countVols() {
		int nbvols=0;
		String requete ="select count(*) as nb from vol ; ";
		try {
			uneBdd.seConnecter();
			Statement unStat = uneBdd.getMaConnexion().createStatement(); 
			ResultSet unResultat= unStat.executeQuery(requete);
			if (unResultat.next())
			{
				nbvols = unResultat.getInt("nb");
			}
			unStat.close();
			uneBdd.seDeconnecter();
		}
		catch (SQLException exp) {
			System.out.println("Erreur de requete :"+requete);
		}
		
		return nbvols;
	}
	
	public static void insertPilote (Pilote unPilote)
	{
		String requete ="insert into pilote values (null, '"
				+ unPilote.getNom()+"','" + unPilote.getPrenom()+"','"
				+ unPilote.getAdresse()+"','" + unPilote.getNbheuresvol()+"','"
				+ unPilote.getBip()+"');"; 
		try {
			uneBdd.seConnecter();
			Statement unStat = uneBdd.getMaConnexion().createStatement(); 
			unStat.execute(requete);
			unStat.close();
			uneBdd.seDeconnecter();
		}
		catch (SQLException exp) {
			System.out.println("Erreur de requete :"+requete);
		}
		
	}
	
	public static void updatePilote (Pilote unPilote)
	{
		String requete ="update pilote set nom = '"
				+ unPilote.getNom()+"', prenom='" + unPilote.getPrenom()+"',adresse='"
				+ unPilote.getAdresse()+"',nbheuresvol='" + unPilote.getNbheuresvol()+"',bip='"
				+ unPilote.getBip()+"'  where idpilote="+unPilote.getIdpilote()+";"; 
		try {
			uneBdd.seConnecter();
			Statement unStat = uneBdd.getMaConnexion().createStatement(); 
			unStat.execute(requete);
			unStat.close();
			uneBdd.seDeconnecter();
		}
		catch (SQLException exp) {
			System.out.println("Erreur de requete :"+requete);
		}
		
	}
	
	public static ArrayList<Pilote> selectAllPilotes ()
	{
		ArrayList<Pilote> lesPilotes = new ArrayList<Pilote>(); 
		String requete = "select * from pilote ; ";
		try {
			uneBdd.seConnecter();
			Statement unStat = uneBdd.getMaConnexion().createStatement(); 
			ResultSet desResultats = unStat.executeQuery(requete);
			//extraction des pilotes : fetchAll en PHP 
			while (desResultats.next()) //tant qu'il un resultat suivant
			{
				Pilote unPilote = new Pilote (
						desResultats.getInt("idpilote"), 
						desResultats.getString("nom"), 
						desResultats.getString("prenom"),
						desResultats.getString("adresse"), 
						desResultats.getInt("nbheuresvol"), 
						desResultats.getString("bip")
						);
				//on ajoute le pilote dans la liste des pilotes 
				lesPilotes.add(unPilote); 
			}
			
			unStat.close();
			uneBdd.seDeconnecter();
		}
		catch (SQLException exp) {
			System.out.println("Erreur de requete :"+requete);
		}
		return lesPilotes; 
	}
	
	public static <Pilote> Pilote selectWherePilote (int idpilote)
	{
		Pilote unPilote = null;  
		String requete = "select * from pilote where idpilote =" +idpilote+";";
		try {
			uneBdd.seConnecter();
			Statement unStat = uneBdd.getMaConnexion().createStatement(); 
			ResultSet unResultat = unStat.executeQuery(requete);
			//extraction d'un pilote : fetch en PHP 
			if (unResultat.next()) //s'il y a un resultat 
			{
				 unPilote = new Pilote (
						 unResultat.getInt("idpilote"), 
						 unResultat.getString("nom"), 
						 unResultat.getString("prenom"),
						 unResultat.getString("adresse"), 
						 unResultat.getInt("nbheuresvol"), 
						 unResultat.getString("bip")
						);
			}
			unStat.close();
			uneBdd.seDeconnecter();
		}
		catch (SQLException exp) {
			System.out.println("Erreur de requete :"+requete);
		}
		return unPilote; 
	}
	
	public static void insertAvion (Avion unAvion)
	{
		String requete ="insert into avion values (null, '"
				+ unAvion.getDesignation()+"','" + unAvion.getConstructeur()+"','"
				+ unAvion.getNbplaces()+"');";
		try {
			uneBdd.seConnecter();
			Statement unStat = uneBdd.getMaConnexion().createStatement(); 
			unStat.execute(requete);
			unStat.close();
			uneBdd.seDeconnecter();
		}
		catch (SQLException exp) {
			System.out.println("Erreur de requete :"+requete);
		}
		
	}
	public static ArrayList<Avion> selectAllAvions ()
	{
		ArrayList<Avion> lesAvions = new ArrayList<Avion>(); 
		String requete = "select * from avion ; ";
		try {
			uneBdd.seConnecter();
			Statement unStat = uneBdd.getMaConnexion().createStatement(); 
			ResultSet desResultats = unStat.executeQuery(requete);
			//extraction des pilotes : fetchAll en PHP 
			while (desResultats.next()) //tant qu'il un resultat suivant
			{
				Avion unAvion = new Avion (
						desResultats.getInt("idavion"), 
						desResultats.getString("designation"), 
						desResultats.getString("constructeur"),
						desResultats.getInt("nbplaces")
						);
				//on ajoute le pilote dans la liste des pilotes 
				lesAvions.add(unAvion); 
			}
			
			unStat.close();
			uneBdd.seDeconnecter();
		}
		catch (SQLException exp) {
			System.out.println("Erreur de requete :"+requete);
		}
		return lesAvions; 
	}
	
	public static void insertVol (Vol unVol)
	{
		String requete ="insert into vol values (null, '"
				+ unVol.getDesignation()+"','" + unVol.getDatevol()+"','"
				+ unVol.getHeurevol()+"','" + unVol.getIdpilote1()+"','"
				+ unVol.getIdpilote2()+"','" + unVol.getIdavion()+"');";
		try {
			uneBdd.seConnecter();
			Statement unStat = uneBdd.getMaConnexion().createStatement(); 
			unStat.execute(requete);
			unStat.close();
			uneBdd.seDeconnecter();
		}
		catch (SQLException exp) {
			System.out.println("Erreur de requete :"+requete);
		}
		
	}
	public static ArrayList<Vol> selectAllVols ()
	{
		ArrayList<Vol> lesVols = new ArrayList<Vol>(); 
		String requete = "select * from vol ; ";
		try {
			uneBdd.seConnecter();
			Statement unStat = uneBdd.getMaConnexion().createStatement(); 
			ResultSet desResultats = unStat.executeQuery(requete);
			//extraction des pilotes : fetchAll en PHP 
			while (desResultats.next()) //tant qu'il un resultat suivant
			{
				Vol unVol = new Vol (
						desResultats.getInt("idvol"), 
						desResultats.getString("designation"), 
						desResultats.getString("datevol"),
						desResultats.getString("heurevol"),
						desResultats.getInt("idpilote1"), 
						desResultats.getInt("idpilote2"), 
						desResultats.getInt("idavion") 
						);
				//on ajoute le pilote dans la liste des pilotes 
				lesVols.add(unVol); 
			}
			
			unStat.close();
			uneBdd.seDeconnecter();
		}
		catch (SQLException exp) {
			System.out.println("Erreur de requete :"+requete);
		}
		return lesVols; 
	}
	public static void deletePilote (int idpilote)
	{
		String requete ="delete from pilote where idpilote = " + idpilote; 
		try {
			uneBdd.seConnecter();
			Statement unStat = uneBdd.getMaConnexion().createStatement(); 
			unStat.execute(requete);
			unStat.close();
			uneBdd.seDeconnecter();
		}
		catch (SQLException exp) {
			System.out.println("Erreur de requete :"+requete);
		}
	}
	public static void deleteAvion (int idavion)
	{
		String requete ="delete from avion where idavion = " + idavion; 
		try {
			uneBdd.seConnecter();
			Statement unStat = uneBdd.getMaConnexion().createStatement(); 
			unStat.execute(requete);
			unStat.close();
			uneBdd.seDeconnecter();
		}
		catch (SQLException exp) {
			System.out.println("Erreur de requete :"+requete);
		}
	}
	public static void deleteVol (int idvol)
	{
		String requete ="delete from vol where idvol = " + idvol; 
		try {
			uneBdd.seConnecter();
			Statement unStat = uneBdd.getMaConnexion().createStatement(); 
			unStat.execute(requete);
			unStat.close();
			uneBdd.seDeconnecter();
		}
		catch (SQLException exp) {
			System.out.println("Erreur de requete :"+requete);
		}
	}

	public static ArrayList<PAV> selectAllPAV ()
	{
		ArrayList<PAV> lesPAVs = new ArrayList<PAV>(); 
		String requete = "select * from pav ; "; //la sélection se fait sur la vue.
		try {
			uneBdd.seConnecter();
			Statement unStat = uneBdd.getMaConnexion().createStatement(); 
			ResultSet desResultats = unStat.executeQuery(requete);
			//extraction des pilotes : fetchAll en PHP 
			while (desResultats.next()) //tant qu'il un resultat suivant
			{
				PAV unPAV = new PAV (
						desResultats.getString("nom"),
						desResultats.getString("prenom"),
						desResultats.getString("avion"),
						desResultats.getString("vol"),
						desResultats.getString("datevol"), 
						desResultats.getString("heurevol") 
						);
				//on ajoute le PAV dans la liste des PAV 
				lesPAVs.add(unPAV); 
			}
			unStat.close();
			uneBdd.seDeconnecter();
		}
		catch (SQLException exp) {
			System.out.println("Erreur de requete :"+requete);
		}
		return lesPAVs; 
	}
	
	/******************** Gestion des users **************/
	public static User selectWhereUser (String email, String mdp)  {
		User unUser = null;  
		String requete = "select * from user where email='"+email
				+"'   and  mdp ='" + mdp + "' ; ";
		try {
			uneBdd.seConnecter();
			Statement unStat = uneBdd.getMaConnexion().createStatement(); 
			ResultSet unResultat = unStat.executeQuery(requete);
			//extraction d'un user : fetch en PHP 
			if (unResultat.next()) //s'il y a un resultat 
			{
				 unUser = new User (
					unResultat.getInt("iduser"), unResultat.getString("nom"), 
					unResultat.getString("prenom"),unResultat.getString("email"), 
					unResultat.getString("mdp"), unResultat.getString("role")
						);
			}
			unStat.close();
			uneBdd.seDeconnecter();
		}
		catch (SQLException exp) {
			System.out.println("Erreur de requete :"+requete);
		}
		return unUser; 
	}
	
}//fin de la classe












