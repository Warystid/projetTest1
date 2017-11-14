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

public class PanelSupprimerGenre extends JPanel implements ActionListener{
	private JPanel monPanelHaut;
	private JPanel monPanelBas;
	private JLabel messageFilm;
	private JComboBox combo;
	private ArrayList<String> lesGenresSelectionner=new ArrayList<String>();
	int compteur=0;
	private JLabel genreLabel;
	private JButton btnSupp;
	public PanelSupprimerGenre(){
		monPanelHaut=new JPanel();
		monPanelBas=new JPanel();
		this.setLayout(new BorderLayout());
		messageFilm = new JLabel("Supprimer un Genre :");
		messageFilm.setForeground(Color.magenta);
		messageFilm.setFont(new Font("Arial", Font.BOLD, 25));
		monPanelHaut.add(messageFilm);
		combo = new JComboBox();
		genreLabel=new JLabel("Genre : ");
		
		btnSupp=new JButton("Supprimer");
		btnSupp.addActionListener(this);
		lesGenresSelectionner=Modele.recupererGenre();
		while(compteur<lesGenresSelectionner.size()){
			combo.addItem(lesGenresSelectionner.get(compteur));
			compteur+=1;
		}
		this.combo.setPreferredSize(new Dimension(150, 30));
		this.add(monPanelHaut, BorderLayout.NORTH);
		
		monPanelBas.add(genreLabel);
		monPanelBas.add(combo);
		monPanelBas.add(btnSupp);
		this.add(monPanelBas);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == btnSupp){
			String genre=combo.getSelectedItem().toString();
			Modele.supprimerGenre(genre);
		}
	}

}
