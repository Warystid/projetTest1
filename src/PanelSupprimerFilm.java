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

public class PanelSupprimerFilm extends JPanel implements ActionListener{
	private JPanel monPanelHaut;
	private JPanel monPanelBas;
	private JLabel messageFilm;
	private JLabel filmLabel;
	private JButton btnSupp;
	private JComboBox combo;
	private ArrayList<String> lesFilmSelectionner=new ArrayList<String>();
	int compteur=0;
	public PanelSupprimerFilm(){
		monPanelHaut=new JPanel();
		monPanelBas=new JPanel();
		this.setLayout(new BorderLayout());
		messageFilm = new JLabel("Supprimer un Film :");
		messageFilm.setForeground(Color.magenta);
		messageFilm.setFont(new Font("Arial", Font.BOLD, 25));
		monPanelHaut.add(messageFilm);
		
		filmLabel=new JLabel("Titre : ");
		combo = new JComboBox();
		lesFilmSelectionner=Modele.recupererFilm();
		while(compteur<lesFilmSelectionner.size()){
			combo.addItem(lesFilmSelectionner.get(compteur));
			compteur+=1;
		}
		btnSupp=new JButton("Supprimer");
		btnSupp.addActionListener(this);
		
		this.combo.setPreferredSize(new Dimension(150, 30));
		this.add(monPanelHaut, BorderLayout.NORTH);
		
		monPanelBas.add(filmLabel);
		monPanelBas.add(combo);
		monPanelBas.add(btnSupp);
		this.add(monPanelBas);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == btnSupp){
			String film=combo.getSelectedItem().toString();
			Modele.supprimerFilm(film);
		}
	}

}
