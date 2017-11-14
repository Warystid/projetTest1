import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;


public class Modele {
	static Statement st;
	static ResultSet rs;
	static ResultSet rs2;
	static Connection connexion= null;
	
	public static void connect(){
		try {
			Class.forName("com.mysql.jdbc.Driver") ;
			connexion = DriverManager.getConnection("jdbc:mysql://localhost/cine", "root", "");
			st = connexion.createStatement();
		}
		catch(ClassNotFoundException erreur) {
			System.out.println("Driver non chargé !" + erreur);
			}
		catch(SQLException erreur) {
			System.out.println("La connexion à la base de données a échoué ou Erreur SQL…" + erreur);
		}
	}
	
	public static void deconnect(){
		try{
			connexion.close();
		}
		catch(SQLException erreur) {
			System.out.println("Erreur SQL…" + erreur);
		}
	}
	
	public static void ajouterGenre(String unLib){
		String sql = "INSERT INTO genre(libelle) VALUES ('"+unLib+"');";
		try {
			st.executeUpdate(sql);
		} 
		catch(SQLException erreur) {
			System.out.println("Erreur SQL…" + erreur);
		}
	}
	
	public static void ajouterActeur(String unNom, String unPrenom, LocalDate uneDate){
		String sql = "INSERT INTO acteur(nom, prenom, naissance) VALUES ('"+unNom+"','"+unPrenom+"','"+uneDate+"');";
		try {
			st.executeUpdate(sql);
		} 
		catch(SQLException erreur) {
			System.out.println("Erreur SQL…" + erreur);
		}
	}
	
	public static void ajouterFilm(String unTitre, int uneDuree, String uneNationalite, int unNbPlace, int unGenre, String unType, int unPrix){
		String sql = "INSERT INTO film(titre, duree, nationalite, nbPlace, idGenre, type, prix) VALUES ('"+unTitre+"',"+uneDuree+",'"+uneNationalite+"',"+unNbPlace+",'"+unGenre+"','"+unType+"',"+unPrix+");";
		try {
			st.executeUpdate(sql);
		} 
		catch(SQLException erreur) {
			System.out.println("Erreur SQL…" + erreur);
		}
	}
	public static void ajouterActeurDeFilm(int unIdActeur, int unIdFilm){
		String sql = "INSERT INTO jouer(idActeur, idFilm) VALUES ("+unIdActeur+","+unIdFilm+");";
		try {
			st.executeUpdate(sql);
		} 
		catch(SQLException erreur) {
			System.out.println("Erreur SQL…" + erreur);
		}
	}
	public static void supprimerActeurDeFilm(int unIdActeur, int unIdFilm){
		String sql = "Delete From jouer where idActeur="+unIdActeur+" and idFilm="+unIdFilm+";";
		try {
			st.executeUpdate(sql);
		} 
		catch(SQLException erreur) {
			System.out.println("Erreur SQL…" + erreur);
		}
	}
	public static int convertirGenre(String unGenre){
		String sql="Select idGenre from genre where libelle='"+unGenre+"'";
		int count=0;
		try{
			rs=st.executeQuery(sql);
			if(rs.next()){
				count=rs.getInt(1);
			}
			rs.close();
		}
		catch(SQLException erreur) {
			System.out.println("Erreur SQL…" + erreur);
		}
		return count;
	}
	public static String convertirIdGenre(int unId){
		String sql="Select libelle from genre where idGenre="+unId+"";
		String libelle=" ";
		try{
			rs=st.executeQuery(sql);
			if(rs.next()){
				libelle=rs.getString(1);
			}
			rs.close();
		}
		catch(SQLException erreur) {
			System.out.println("Erreur SQL…" + erreur);
		}
		return libelle;
	}
	public static int convertirActeur(String unNom, String unPrenom){
		String sql="Select idActeur from acteur where nom='"+unNom+"' And prenom='"+unPrenom+"'";
		int count=0;
		try{
			rs=st.executeQuery(sql);
			if(rs.next()){
				count=rs.getInt(1);
			}
			rs.close();
		}
		catch(SQLException erreur) {
			System.out.println("Erreur SQL…" + erreur);
		}
		return count;
	}
	public static int convertirFilm(String unTitre){
		String sql="Select idFilm from film where titre='"+unTitre+"'";
		int count=0;
		try{
			rs=st.executeQuery(sql);
			if(rs.next()){
				count=rs.getInt(1);
			}
			rs.close();
		}
		catch(SQLException erreur) {
			System.out.println("Erreur SQL…" + erreur);
		}
		return count;
	}
	public static ArrayList<String> recupererGenre(){
		String sql="Select libelle from genre";
		ArrayList<String> lesGenres= new ArrayList<String>();
		try{
			rs=st.executeQuery(sql);
			while(rs.next()){
				lesGenres.add(rs.getString(1));
			}
			rs.close();
		}
		catch(SQLException erreur) {
			System.out.println("Erreur SQL…" + erreur);
		}
		return lesGenres;
	}
	public static ArrayList<String> recupererActeur(){
		String sql="Select nom, prenom from acteur";
		ArrayList<String> lesActeurs= new ArrayList<String>();
		try{
			rs=st.executeQuery(sql);
			while(rs.next()){
				lesActeurs.add(rs.getString(1)+" "+rs.getString(2));	
			}
			rs.close();
		}
		catch(SQLException erreur) {
			System.out.println("Erreur SQL…" + erreur);
		}
		return lesActeurs;
	}
	public static ArrayList<String> recupererActeur2(int unId){
		String sql="Select nom, prenom from acteur, jouer where jouer.idActeur=acteur.idActeur and idFilm="+unId+"";
		ArrayList<String> lesActeurs=new ArrayList<String>();
		try{
			rs=st.executeQuery(sql);
			while(rs.next()){
				lesActeurs.add(rs.getString(1)+" "+rs.getString(2));	
			}
			rs.close();
		}
		catch(SQLException erreur) {
			System.out.println("Erreur SQL…" + erreur);
		}
		return lesActeurs;
	}
	
	public static ArrayList<String> recupererFilm(){
		String sql="Select titre from film";
		ArrayList<String> lesFilms= new ArrayList<String>();
		try{
			rs=st.executeQuery(sql);
			while(rs.next()){
				lesFilms.add(rs.getString(1));	
			}
			rs.close();
		}
		catch(SQLException erreur) {
			System.out.println("Erreur SQL…" + erreur);
		}
		return lesFilms;
	}
	public static ArrayList<String> recupererFilm2(int unId){
		String sql="Select titre from film, jouer where jouer.idFilm=film.idFilm and idActeur="+unId+"";
		ArrayList<String> lesFilms= new ArrayList<String>();
		try{
			rs=st.executeQuery(sql);
			while(rs.next()){
				lesFilms.add(rs.getString(1));	
			}
			rs.close();
		}
		catch(SQLException erreur) {
			System.out.println("Erreur SQL…" + erreur);
		}
		return lesFilms;
	}
	/*public static ArrayList<String> recupererFilms(){
		String sql="Select titre, duree, nationalite, nbPlace, type, prix from film";
		String sql2="Select idGenre from film";
		ArrayList<String> lesFilms= new ArrayList<String>();
		int idGenre;
		String libelleGenre;
		try{
			rs2=st.executeQuery(sql2);
			rs=st.executeQuery(sql);
			String duree="";
			String place="";
			String prix="";

			while(rs.next()){
				idGenre=rs2.getInt(1);
				duree=Integer.toString(rs.getInt(2));
				place=Integer.toString(rs.getInt(4));
				prix=Integer.toString(rs.getInt(6));
				libelleGenre=Modele.convertirIdGenre(idGenre);
				lesFilms.add(rs.getString(1)+"-"+duree+"-"+rs.getString(3)+"-"+place+"-"+rs.getString(5)+"-"+prix+" "+libelleGenre);	
			}
			rs.close();
			rs2.close();

		}
		catch(SQLException erreur) {
			System.out.println("Erreur SQL…" + erreur);
		}
		return lesFilms;
	}*/
	public static void supprimerFilm(String unTitre){
		int unId=Modele.convertirFilm(unTitre);
		String sql2 = "Delete From jouer Where idFilm="+unId+"";
		String sql = "Delete From film Where titre='"+unTitre+"'";
		try {
			st.executeUpdate(sql2);
			st.executeUpdate(sql);
		} 
		catch(SQLException erreur) {
			System.out.println("Erreur SQL…" + erreur);
		}
	}
	public static void supprimerGenre(String unLibelle){
		String sql = "Delete From genre Where libelle='"+unLibelle+"'";
		try {
			st.executeUpdate(sql);
		} 
		catch(SQLException erreur) {
			System.out.println("Erreur SQL…" + erreur);
		}
	}
	public static void supprimerActeur(String unNom, String unPrenom){
		int unId=Modele.convertirActeur(unNom, unPrenom);
		String sql2 = "Delete From jouer Where idActeur="+unId+"";
		String sql = "Delete From acteur Where nom='"+unNom+"' And prenom='"+unPrenom+"'";
		try {
			st.executeUpdate(sql2);
			st.executeUpdate(sql);
		} 
		catch(SQLException erreur) {
			System.out.println("Erreur SQL…" + erreur);
		}
	}
	public static int recupererDuree(int unId){
		String sql="Select duree from film where idFilm="+unId+"";
		int leFilm=0;
		try{
			rs=st.executeQuery(sql);
			if(rs.next()){
				leFilm=rs.getInt(1);	
			}
			rs.close();
		}
		catch(SQLException erreur) {
			System.out.println("Erreur SQL…" + erreur);
		}
		return leFilm;
	}
	public static int recupererPlace(int unId){
		String sql="Select nbPlace from film where idFilm="+unId+"";
		int leFilm=0;
		try{
			rs=st.executeQuery(sql);
			if(rs.next()){
				leFilm=rs.getInt(1);
			}
			rs.close();
		}
		catch(SQLException erreur) {
			System.out.println("Erreur SQL…" + erreur);
		}
		return leFilm;
	}
	public static int recupererPrix(int unId){
		String sql="Select prix from film where idFilm="+unId+"";
		int leFilm=0;
		try{
			rs=st.executeQuery(sql);
			if(rs.next()){
				leFilm=rs.getInt(1);
			}
			rs.close();
		}
		catch(SQLException erreur) {
			System.out.println("Erreur SQL…" + erreur);
		}
		return leFilm;
	}
	public static String recupererNationalite(int unId){
		String sql="Select nationalite from film where idFilm="+unId+"";
		String leFilm= "";
		try{
			rs=st.executeQuery(sql);
			if(rs.next()){
				leFilm=rs.getString(1);	
			}
			rs.close();
		}
		catch(SQLException erreur) {
			System.out.println("Erreur SQL…" + erreur);
		}
		return leFilm;
	}
	public static String recupererType(int unId){
		String sql="Select type from film where idFilm="+unId+"";
		String leFilm="";
		try{
			rs=st.executeQuery(sql);
			if(rs.next()){
				leFilm=rs.getString(1);	
			}
			rs.close();
		}
		catch(SQLException erreur) {
			System.out.println("Erreur SQL…" + erreur);
		}
		return leFilm;
	}
	public static int RecupererIdG(String unTitre){
		int unId=Modele.convertirFilm(unTitre);
		int idG=0;
		String sql = "Select idGenre From film Where idFilm="+unId+"";
		try {
			rs=st.executeQuery(sql);
			if(rs.next()){
				idG=rs.getInt(1);
			}
			rs.close();
		} 
		catch(SQLException erreur) {
			System.out.println("Erreur SQL…" + erreur);
		}
		return idG;
	}
	public static String recupererNomA(int unId){
		String sql = "Select nom From acteur where idActeur="+unId+"";
		String leNom="";
		try {
			rs=st.executeQuery(sql);
			while(rs.next()){
				leNom=rs.getString(1);
			}
			rs.close();
		} 
		catch(SQLException erreur) {
			System.out.println("Erreur SQL…" + erreur);
		}
		return leNom;
	}
	public static String recupererPrenomA(int unId){
		String sql = "Select prenom From acteur where idActeur="+unId+"";
		String lePrenom="";
		try {
			rs=st.executeQuery(sql);
			while(rs.next()){
				lePrenom=rs.getString(1);
			}
			rs.close();
		} 
		catch(SQLException erreur) {
			System.out.println("Erreur SQL…" + erreur);
		}
		return lePrenom;
	}
	public static ArrayList<LocalDate> recupererDateA(int unId){
		String sql = "Select naissance From acteur where idActeur="+unId+"";
		ArrayList<LocalDate> lesDates= new ArrayList<LocalDate>();
		try {
			rs=st.executeQuery(sql);
			if(rs.next()){
				lesDates.add(rs.getDate(1).toLocalDate());
			}
			rs.close();
		} 
		catch(SQLException erreur) {
			System.out.println("Erreur SQL…" + erreur);
		}
		return lesDates;
	}
	public static String xmlActeur(String nom, String prenom, LocalDate date, ArrayList<String> lesFilms){
		String chaine="";
		String film="";
		int compteur=0;
		chaine+="\t<acteur>\n";
		chaine+="\t\t<nom>"+nom+"</nom>\n";
		chaine+="\t\t<prenom>"+prenom+"</prenom>\n";
		chaine+="\t\t<naissance>"+date+"</naissance>\n";
		if(lesFilms.size()!=0){
			chaine+="\t\t<films>\n";
			while(compteur<lesFilms.size()){
				film=lesFilms.get(compteur);
				chaine+="\t\t\t<film>"+film+"</film>\n";
				compteur+=1;
			}
			chaine+="\t\t</films>\n";
		}
		chaine+="\t</acteur>\n";
		return chaine;
	}
	public static String xmlFilm(String unTitre, int uneDuree, String uneNationalite, int unePlace, String unType, int unPrix,ArrayList<String> lesActeurs){
		String chaine="";
		String acteurs="";
		int compteur=0;
		chaine+="\t<film>\n";
		chaine+="\t\t<titre>"+unTitre+"</titre>\n";
		chaine+="\t\t<durée>"+uneDuree+"</durée>\n";
		chaine+="\t\t<nationalité>"+uneNationalite+"</nationalité>\n";
		chaine+="\t\t<place>"+unePlace+"</place>\n";
		chaine+="\t\t<type>"+unType+"</type>\n";
		chaine+="\t\t<prix>"+unPrix+"</prix>\n";
		if(lesActeurs.size()!=0){
			chaine+="\t\t<acteurs>\n";
			while(compteur<lesActeurs.size()){
				acteurs=lesActeurs.get(compteur);
				chaine+="\t\t\t<acteur>"+acteurs+"</acteur>\n";
				compteur+=1;
			}
			chaine+="\t\t</acteurs>\n";
		}
		chaine+="\t</film>\n";
		return chaine;
	}
}
