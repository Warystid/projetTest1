
public class Genre {
	private int idGenre;
	private String libelleG;
	
	public Genre(){
		
	}
	public Genre(String unLibelle){
		this.libelleG=unLibelle;
	}
	public Genre(int unId, String unLibelle){
		this.idGenre=unId;
		this.libelleG=unLibelle;
	}
	public int getIdGenre() {
		return idGenre;
	}
	public void setIdGenre(int idGenre) {
		this.idGenre = idGenre;
	}
	public String getLibelleG() {
		return libelleG;
	}
	public void setLibelleG(String libelleG) {
		this.libelleG = libelleG;
	}
	public String toString(){
		return "IDGenre : "+idGenre+" Genre : "+libelleG;
	}
	
}
