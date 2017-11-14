
import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import java.text.NumberFormat;
import java.time.LocalDate;
import java.util.ArrayList;

public class PanelAjouterFilm extends JPanel implements ActionListener{
	private JPanel monPanelHaut;
	private JPanel monPanelBas;
	private JLabel messageFilm;
	private JTextField titreField;
	private JFormattedTextField dureeField;
	private JTextField nationaliteField;
	private JFormattedTextField placeField;

	private JLabel titreLabel;
	private JLabel dureeLabel;
	private JLabel nationaliteLabel;
	private JLabel placeLabel;
	private JLabel genreLabel;
	private JLabel typeLabel;

	private JButton btnAjout;
	private JRadioButton btn2D;
	private JRadioButton btn3D;
	private ButtonGroup group;
	private JComboBox combo;
	
	private ArrayList<String> lesGenresSelectionner=new ArrayList<String>();
	int compteur=0;
	
	public PanelAjouterFilm(){
		monPanelHaut=new JPanel();
		monPanelBas=new JPanel();
		this.setLayout(new BorderLayout());
		messageFilm = new JLabel("Ajouter un Film :");
		messageFilm.setForeground(Color.magenta);
		messageFilm.setFont(new Font("Arial", Font.BOLD, 25));
		monPanelHaut.add(messageFilm);
		
		titreLabel=new JLabel("Titre : ");
		dureeLabel=new JLabel("Durée : ");
		nationaliteLabel=new JLabel("Nationalité : ");
		placeLabel=new JLabel("Nombre de places : ");
		genreLabel=new JLabel("Genre : ");

		typeLabel=new JLabel("Type : ");
		
		titreField=new JTextField();
		dureeField=new JFormattedTextField(NumberFormat.getNumberInstance());
		nationaliteField=new JTextField();
		placeField=new JFormattedTextField(NumberFormat.getNumberInstance());
		

		combo = new JComboBox();
		
		btn2D=new JRadioButton("2D");
		btn3D=new JRadioButton("3D");
		group = new ButtonGroup();
		group.add(btn2D);
		group.add(btn3D);
		
		btnAjout=new JButton("Ajouter");
		btn2D.addActionListener(this);
		btn3D.addActionListener(this);
		btnAjout.addActionListener(this);
		
		this.titreField.setPreferredSize(new Dimension(175, 30));
		this.dureeField.setPreferredSize(new Dimension(175, 30));
		this.nationaliteField.setPreferredSize(new Dimension(180, 30));
		this.placeField.setPreferredSize(new Dimension(200, 30));

		combo.setPreferredSize(new Dimension(210, 30));
		
		this.add(monPanelHaut, BorderLayout.NORTH);
		monPanelBas.add(titreLabel);
		monPanelBas.add(titreField);
		monPanelBas.add(dureeLabel);
		monPanelBas.add(dureeField);
		monPanelBas.add(nationaliteLabel);
		monPanelBas.add(nationaliteField);
		monPanelBas.add(placeLabel);
		monPanelBas.add(placeField);
		monPanelBas.add(genreLabel);
		monPanelBas.add(combo);
		lesGenresSelectionner=Modele.recupererGenre();
		while(compteur<lesGenresSelectionner.size()){
			combo.addItem(lesGenresSelectionner.get(compteur));
			compteur+=1;
		}
		monPanelBas.add(typeLabel);
		monPanelBas.add(btn2D);
		monPanelBas.add(btn3D);
		monPanelBas.add(btnAjout);
		
		this.add(monPanelBas);
		
	}

	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == btnAjout){
			int prix=0;
			String type="";
			if (btn2D.isSelected()){
				prix=5;
				type="2D";
			}
			if (btn3D.isSelected()){
				prix=7;
				type="3D";
			}
			String genre=combo.getSelectedItem().toString();
			Modele.ajouterFilm(titreField.getText(),Integer.parseInt(dureeField.getText()),nationaliteField.getText(),Integer.parseInt(placeField.getText()),Modele.convertirGenre(genre),type,prix);
			PanelListeActeur monPanelListeActeur = new PanelListeActeur();
		}
		
	}

}
