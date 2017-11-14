import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import java.time.LocalDate;
import java.util.ArrayList;


public class PanelConsultationActeur extends JPanel implements ActionListener{
	private JLabel messageActeur;
	private JLabel messageVide;
	private JLabel messageVide2;
	private JLabel messageVide3;
	private JPanel monPanelHaut;
	private JPanel monPanelBas;
	private JPanel monPanelBas2;
	private JTextArea xmlLabel;
	String nom;
	String prenom;
	LocalDate date;
	private JButton btnAfficher;
	private JComboBox combo;
	private String xml;
	private ArrayList<String> lesActeurSelectionner=new ArrayList<String>();
	private ArrayList<String> lesFilms=new ArrayList<String>();
	private String leNomASelectionner;
	private String lePrenomASelectionner;
	private ArrayList<LocalDate> laDateASelectionner=new ArrayList<LocalDate>();
	int compteur;
	public PanelConsultationActeur(){
		compteur=0;
		btnAfficher=new JButton("Afficher XML");
		btnAfficher.addActionListener(this);
		combo = new JComboBox();
		monPanelBas=new JPanel();
		monPanelHaut=new JPanel();
		monPanelBas2=new JPanel();
		monPanelBas.setBackground(Color.WHITE);
		monPanelBas2.setBackground(Color.WHITE);
		monPanelHaut.setBackground(Color.WHITE);
		monPanelHaut.setLayout(new BoxLayout(monPanelHaut, BoxLayout.LINE_AXIS));
		monPanelBas.setLayout(new BoxLayout(monPanelBas, BoxLayout.LINE_AXIS));
		monPanelBas2.setLayout(new BoxLayout(monPanelBas2, BoxLayout.LINE_AXIS));
		messageActeur = new JLabel("                                Les Acteurs :");
		messageVide = new JLabel("                                                     ");
		messageVide2 = new JLabel("                                               ");
		messageVide3 = new JLabel("                                                                          ");
		messageActeur.setForeground(Color.magenta);
		messageActeur.setFont(new Font("Arial", Font.BOLD, 25));
		monPanelHaut.add(messageActeur);
		monPanelHaut.add(messageVide);

		
		lesActeurSelectionner=Modele.recupererActeur();
		while(compteur<lesActeurSelectionner.size()){
			combo.addItem(lesActeurSelectionner.get(compteur));
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
			String acteur=combo.getSelectedItem().toString();
			String[] parts = acteur.split(" ");
			String nom = parts[0];
			String prenom = parts[1];
			
			int unIdA=Modele.convertirActeur(nom,prenom);
					
			leNomASelectionner=Modele.recupererNomA(unIdA);
			lePrenomASelectionner=Modele.recupererPrenomA(unIdA);
			laDateASelectionner=Modele.recupererDateA(unIdA);
			lesFilms=Modele.recupererFilm2(unIdA);
			
			LocalDate date=laDateASelectionner.get(0);
			xml=Modele.xmlActeur(nom, prenom, date, lesFilms);
			xmlLabel.setText(xml);
		}

		
	}

}
