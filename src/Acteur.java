import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;


public class Acteur {
	private int idActeur;
	private String nomA;
	private String prenomA;
	private LocalDate dateNaiss;
	private ArrayList<Film> lesFilms;
	
	public Acteur(){
		lesFilms=new ArrayList<Film>();
	}
	public Acteur(String unNom, String unPrenom){
		this.nomA=unNom;
		this.prenomA=unPrenom;
		lesFilms=new ArrayList<Film>();
	}
	
	public Acteur(int unId, String unNom, String unPrenom, LocalDate uneDate){
		this.idActeur=unId;
		this.nomA=unNom;
		this.prenomA=unPrenom;
		this.dateNaiss=uneDate;
		lesFilms=new ArrayList<Film>();
	}
	public int getIdActeur() {
		return idActeur;
	}
	public void setIdActeur(int idActeur) {
		this.idActeur = idActeur;
	}
	public String getNomA() {
		return nomA;
	}
	public void setNomA(String nomA) {
		this.nomA = nomA;
	}
	public String getPrenomA() {
		return prenomA;
	}
	public void setPrenomA(String prenomA) {
		this.prenomA = prenomA;
	}
	public LocalDate getDateNaiss() {
		return dateNaiss;
	}
	public void setDateNaiss(LocalDate dateNaiss) {
		this.dateNaiss = dateNaiss;
	}
	public ArrayList<Film> getLesFilms(){
		return this.lesFilms;
	}
	public void ajouterFilm(Film unFilm){
		this.lesFilms.add(unFilm);
	}
	public void supprimerFilm(Film unFilm){
		this.lesFilms.remove(unFilm);
	}
	public String afficherFilms(){
		String chaine="";
		for(Film f:this.lesFilms){
			chaine+=f.getTitreFilm();
		}
		return chaine;
	}
	public String toString(){
		return "IDActeur : "+idActeur+" Acteur : "+nomA+" "+prenomA+" Date de Naissance : "+dateNaiss+this.afficherFilms();
	}
}
