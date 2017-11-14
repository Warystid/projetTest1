import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import java.time.LocalDate;
import java.util.ArrayList;

public class PanelAjouterGenre extends JPanel implements ActionListener{
	private JPanel monPanelHaut;
	private JPanel monPanelBas;
	private JLabel messageFilm;
	private JTextField genreField;
	private JLabel genreLabel;
	private JButton btnAjout;
	public PanelAjouterGenre(){
		monPanelHaut=new JPanel();
		monPanelBas=new JPanel();
		this.setLayout(new BorderLayout());
		messageFilm = new JLabel("Ajouter un Genre :");
		messageFilm.setForeground(Color.magenta);
		messageFilm.setFont(new Font("Arial", Font.BOLD, 25));
		monPanelHaut.add(messageFilm);
		
		genreLabel=new JLabel("Genre : ");
		genreField=new JTextField();
		btnAjout=new JButton("Ajouter");
		btnAjout.addActionListener(this);
		
		this.genreField.setPreferredSize(new Dimension(150, 30));
		this.add(monPanelHaut, BorderLayout.NORTH);
		
		monPanelBas.add(genreLabel);
		monPanelBas.add(genreField);
		monPanelBas.add(btnAjout);
		this.add(monPanelBas);
	}

	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == btnAjout){
			Modele.ajouterGenre(genreField.getText());
		}
		
	}
}
