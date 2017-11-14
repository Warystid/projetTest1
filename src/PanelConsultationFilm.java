import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import java.time.LocalDate;
import java.util.ArrayList;


public class PanelConsultationFilm extends JPanel implements ActionListener{
	private JLabel messageFilm;
	private JLabel messageVide;
	private JLabel messageVide2;
	private JLabel messageVide3;
	private JPanel monPanelHaut;
	private JPanel monPanelBas;
	private JPanel monPanelBas2;
	private JTextArea xmlLabel;
	private JButton btnAfficher;
	private JComboBox combo;
	private String xml;
	private int leDureeSelectionner;
	private String laNatioSelectionner;
	private int lePlaceSelectionner;
	private String leTypeSelectionner;
	private int lePrixSelectionner;;
	private ArrayList<String> leFilmSelectionner=new ArrayList<String>();
	int compteur;
	private ArrayList<String> lesActeurs=new ArrayList<String>();
	String titre;
	int duree;
	String nationalite;
	int place;
	String type;
	int prix;
	String genre;
	String unGenre;
	Genre leGenre;

	public PanelConsultationFilm(){
		compteur=0;
		btnAfficher=new JButton("Afficher XML");
		btnAfficher.addActionListener(this);
		combo = new JComboBox();
		monPanelBas=new JPanel();
		monPanelHaut=new JPanel();
		monPanelBas2=new JPanel();
		monPanelHaut.setLayout(new BoxLayout(monPanelHaut, BoxLayout.LINE_AXIS));
		monPanelBas.setLayout(new BoxLayout(monPanelBas, BoxLayout.LINE_AXIS));
		monPanelBas2.setLayout(new BoxLayout(monPanelBas2, BoxLayout.LINE_AXIS));
		messageVide = new JLabel("                                                     ");
		messageVide2 = new JLabel("                                               ");
		messageVide3 = new JLabel("                                                                          ");
		messageFilm = new JLabel("                                  Les Films :");
		messageFilm.setForeground(Color.magenta);
		messageFilm.setFont(new Font("Arial", Font.BOLD, 25));
		monPanelHaut.add(messageFilm);
		monPanelHaut.add(messageVide);
		
		leFilmSelectionner=Modele.recupererFilm();
		while(compteur<leFilmSelectionner.size()){
			combo.addItem(leFilmSelectionner.get(compteur));
			compteur+=1;
		}
		this.combo.setPreferredSize(new Dimension(200, 30));
		
		xml="";
		xmlLabel=new JTextArea(xml);
		monPanelBas.add(messageVide3);
		monPanelBas.add(combo);
		monPanelBas.add(btnAfficher);
		monPanelBas.add(messageVide2);
		monPanelBas2.add(xmlLabel);
		this.add(monPanelHaut, BorderLayout.NORTH);
		this.add(monPanelBas);
		this.add(monPanelBas2, BorderLayout.SOUTH);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==btnAfficher){
			String filmS=combo.getSelectedItem().toString();
			
			int unIdF=Modele.convertirFilm(filmS);
			
			leDureeSelectionner=Modele.recupererDuree(unIdF);
			laNatioSelectionner=Modele.recupererNationalite(unIdF);
			lePlaceSelectionner=Modele.recupererPlace(unIdF);
			leTypeSelectionner=Modele.recupererType(unIdF);
			lePrixSelectionner=Modele.recupererPrix(unIdF);
			lesActeurs=Modele.recupererActeur2(unIdF);

			xml=Modele.xmlFilm(filmS,leDureeSelectionner,laNatioSelectionner,lePlaceSelectionner,leTypeSelectionner,lePrixSelectionner,lesActeurs);
			xmlLabel.setText(xml);
		}
		
	}
}
