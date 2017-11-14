import javax.swing.*;

import java.awt.*;
import java.awt.event.*;

public class PanelConsultation extends JPanel{
	
	private JPanel monPanelFilm;
    private JLabel messageFilm;
    private JPanel monPanelActeur;
    private JLabel messageActeur;
    private JPanel monPanelGenre;
    private JLabel messageGenre;
    
	public  PanelConsultation() {
		
		this.monPanelFilm= new JPanel();
		this.messageFilm = new JLabel("Les Films :");
		this.monPanelFilm.add(messageFilm);
		
		this.monPanelActeur= new JPanel();
		this.messageActeur = new JLabel("Les Acteurs :");
		this.monPanelActeur.add(messageActeur);
		
		this.monPanelGenre= new JPanel();
		this.messageGenre = new JLabel("Les Genres :");
		this.monPanelGenre.add(messageGenre);
	}
}
