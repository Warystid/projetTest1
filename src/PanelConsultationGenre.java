import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;


public class PanelConsultationGenre extends JPanel{
	private JLabel messageGenre;
	private JPanel monPanelHaut;
	private JTable tableau;
	JScrollPane scrollPane;
	private ArrayList<String> lesGenresSelectionner=new ArrayList<String>();
	private ArrayList<Genre> lesGenres=new ArrayList<Genre>();
	int compteur=0;
	public PanelConsultationGenre(){
		monPanelHaut=new JPanel();
		this.setLayout(new FlowLayout());
		messageGenre = new JLabel("                                     Les Genres :                                    ");
		messageGenre.setForeground(Color.magenta);
		messageGenre.setFont(new Font("Arial", Font.BOLD, 25));
		monPanelHaut.add(messageGenre);
		
		
		lesGenresSelectionner=Modele.recupererGenre();
		while(compteur<lesGenresSelectionner.size()){
			lesGenres.add(new Genre(lesGenresSelectionner.get(compteur)));
			compteur+=1;
		}
		Object[][]data = new Object[compteur][1];
				int i = 0;
				for (Genre gnr : lesGenres){
					data[i][0]= gnr.getLibelleG();
					i++;
				}
		String [] title ={"Libellé"};
		this.tableau = new JTable(data,title);
		this.tableau.setPreferredScrollableViewportSize(new Dimension(200, 64));
		this.scrollPane = new JScrollPane(this.tableau);
		this.add(monPanelHaut, BorderLayout.NORTH);
		this.add(this.scrollPane);
	}
}
