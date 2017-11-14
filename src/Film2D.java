
public class Film2D extends Film {
	static private int prix2D;
	static private String libelle2D;
	
	public Film2D(){
		super();
	}
	
	public Film2D(int unIdF, String unTitreF, int uneDuree, String uneNationalite, int unNbPlace, Genre unGenre, String unLibelle, int unPrix){
		super(unIdF, unTitreF, uneDuree, uneNationalite, unNbPlace, unGenre);
		this.libelle2D=unLibelle;
		this.prix2D=unPrix;
	}
	public Film2D(String unTitreF, int uneDuree, String uneNationalite, int unNbPlace, Genre unGenre, String unLibelle, int unPrix){
		super(unTitreF, uneDuree, uneNationalite, unNbPlace, unGenre);
		this.libelle2D=unLibelle;
		this.prix2D=unPrix;
	}
	static String getLibelle2D() {
		return libelle2D;
	}

	public void setLibelle2D(String libelle2d) {
		libelle2D = libelle2d;
	}

	static float getPrix2D() {
		return prix2D;
	}

	public void setPrix2D(int prix2d) {
		prix2D = prix2d;
	}
}
