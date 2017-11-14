import java.util.ArrayList;


public abstract class Film {
	private int idFilm;
	private String titreFilm;
	private int dureeFilm;
	private String nationaliteFilm;
	private int nbPlace;
	ArrayList<Acteur> lesActeurs;
	private Genre leGenre;
	

	public Film(){
		lesActeurs=new ArrayList<Acteur>();
	}
	public Film(int unIdF, String unTitreF, int uneDuree, String uneNationalite, int unNbPlace, Genre unGenre){
		this.idFilm=unIdF;
		this.titreFilm=unTitreF;
		this.dureeFilm=uneDuree;
		this.nationaliteFilm=uneNationalite;
		this.nbPlace=unNbPlace;
		this.leGenre=unGenre;
		lesActeurs=new ArrayList<Acteur>();
	}
	public Film(String unTitreF, int uneDuree, String uneNationalite, int unNbPlace, Genre unGenre){
		this.titreFilm=unTitreF;
		this.dureeFilm=uneDuree;
		this.nationaliteFilm=uneNationalite;
		this.nbPlace=unNbPlace;
		this.leGenre=unGenre;
		lesActeurs=new ArrayList<Acteur>();
	}
	public int getIdFilm() {
		return idFilm;
	}

	public void setIdFilm(int idFilm) {
		this.idFilm = idFilm;
	}

	public int getDureeFilm() {
		return dureeFilm;
	}

	public void setDureeFilm(int dureeFilm) {
		this.dureeFilm = dureeFilm;
	}

	public String getNationaliteFilm() {
		return nationaliteFilm;
	}

	public void setNationaliteFilm(String nationaliteFilm) {
		this.nationaliteFilm = nationaliteFilm;
	}

	public Genre getLeGenre() {
		return leGenre;
	}
	public int getNbPlace() {
		return nbPlace;
	}

	public void setNbPlace(int nbPlace) {
		this.nbPlace = nbPlace;
	}

	public String getTitreFilm() {
		return titreFilm;
	}

	public void setTitreFilm(String titreFilm) {
		this.titreFilm = titreFilm;
	}
	public String toString(){
		return "IdFilm : "+idFilm+" Titre : "+titreFilm+" Durée du Film : "+dureeFilm+"Nationalité : "+nationaliteFilm+" Nombre de Place : "+nbPlace+" Genre : "+leGenre;
	}
}
