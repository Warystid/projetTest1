import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PanelListeActeurS extends JPanel implements ActionListener{
	private JPanel monPanelHaut;
	private JPanel monPanelBas;
	private JLabel messageFilm;
	private JComboBox combo;
	private JComboBox combo2;
	private JButton btnSupp;
	private ArrayList<String> lesFilmsSelectionner=new ArrayList<String>();
	private ArrayList<String> lesActeursSelectionner=new ArrayList<String>();
	int compteur=0;
	int compteur2=0;

	public PanelListeActeurS(){
		monPanelHaut=new JPanel();
		monPanelBas=new JPanel();
		this.setLayout(new BorderLayout());
		messageFilm = new JLabel("Ajouter Les Acteurs :");
		messageFilm.setForeground(Color.magenta);
		messageFilm.setFont(new Font("Arial", Font.BOLD, 25));
		monPanelHaut.add(messageFilm);
		
		combo = new JComboBox();
		combo2 = new JComboBox();
		
		combo.setPreferredSize(new Dimension(210, 30));
		combo2.setPreferredSize(new Dimension(210, 30));
		
		this.add(monPanelHaut, BorderLayout.NORTH);
		monPanelBas.add(combo);
		lesFilmsSelectionner=Modele.recupererFilm();
		while(compteur<lesFilmsSelectionner.size()){
			combo.addItem(lesFilmsSelectionner.get(compteur));
			compteur+=1;
		}
		monPanelBas.add(combo2);
		lesActeursSelectionner=Modele.recupererActeur();
		while(compteur2<lesActeursSelectionner.size()){
			combo2.addItem(lesActeursSelectionner.get(compteur2));
			compteur2+=1;
		}
		btnSupp=new JButton("Supprimer");
		btnSupp.addActionListener(this);
		monPanelBas.add(btnSupp);
		this.add(monPanelBas);
	}
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == btnSupp){
			String titre=combo.getSelectedItem().toString();
			String acteur=combo2.getSelectedItem().toString();
			String[] parts = acteur.split(" ");
			String nom = parts[0];
			String prenom = parts[1];
			int idActeur=Modele.convertirActeur(nom,prenom);
			int idFilm=Modele.convertirFilm(titre);
			Modele.supprimerActeurDeFilm(idActeur,idFilm);
		}
		
	}
}
