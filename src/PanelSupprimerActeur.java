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
import javax.swing.JTextField;

public class PanelSupprimerActeur extends JPanel implements ActionListener{
	private JPanel monPanelHaut;
	private JPanel monPanelBas;
	private JLabel messageActeur;
	private JLabel nomLabel;

	private JButton btnSupp;
	private JComboBox combo;
	private ArrayList<String> lesActeurSelectionner=new ArrayList<String>();
	int compteur=0;
	public PanelSupprimerActeur(){
		monPanelHaut=new JPanel();
		monPanelBas=new JPanel();
		this.setLayout(new BorderLayout());
		messageActeur = new JLabel("Supprimer un Acteur :");
		messageActeur.setForeground(Color.magenta);
		messageActeur.setFont(new Font("Arial", Font.BOLD, 25));
		monPanelHaut.add(messageActeur);
		combo = new JComboBox();
		nomLabel=new JLabel("Acteur : ");
		lesActeurSelectionner=Modele.recupererActeur();
		while(compteur<lesActeurSelectionner.size()){
			combo.addItem(lesActeurSelectionner.get(compteur));
			compteur+=1;
		}
		this.combo.setPreferredSize(new Dimension(150, 30));
		btnSupp=new JButton("Supprimer");
		btnSupp.addActionListener(this);
		this.add(monPanelHaut, BorderLayout.NORTH);
		monPanelBas.add(nomLabel);
		monPanelBas.add(combo);
		monPanelBas.add(btnSupp);
		this.add(monPanelBas);
	}
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == btnSupp){
			String acteur=combo.getSelectedItem().toString();
			String[] parts = acteur.split(" ");
			String nom = parts[0];
			String prenom = parts[1];
			Modele.supprimerActeur(nom,prenom);
		}
	}

}
