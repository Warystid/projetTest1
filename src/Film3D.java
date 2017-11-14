
public class Film3D extends Film{
	static private float prix3D;
	static private String libelle3D;
	
	public Film3D(){
		super();
	}
	
	public Film3D(int unIdF, String unTitreF, int uneDuree, String uneNationalite, int unNbPlace, Genre unGenre, String unLibelle, float unPrix){
		super(unIdF, unTitreF, uneDuree, uneNationalite, unNbPlace, unGenre);
		this.libelle3D=unLibelle;
		this.prix3D=unPrix;
	}
	public Film3D(String unTitreF, int uneDuree, String uneNationalite, int unNbPlace, Genre unGenre, String unLibelle, int unPrix){
		super(unTitreF, uneDuree, uneNationalite, unNbPlace, unGenre);
		this.libelle3D=unLibelle;
		this.prix3D=unPrix;
	}
	static String getLibelle3D() {
		return libelle3D;
	}

	public void setLibelle3D(String libelle3d) {
		this.libelle3D = libelle3d;
	}

	static float getPrix3D() {
		return prix3D;
	}

	public void setPrix3D(float prix3d) {
		this.prix3D = prix3d;
	}
}
