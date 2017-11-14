import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import java.time.LocalDate;
import java.util.ArrayList;

public class PanelAjouterActeur extends JPanel implements ActionListener{
	private JPanel monPanelHaut;
	private JPanel monPanelBas;
	private JLabel messageFilm;
	private JTextField nomField;
	private JLabel nomLabel;
	private JTextField prenomField;
	private JLabel prenomLabel;
	private JFormattedTextField dateField;
	private JLabel dateLabel;
	private JButton btnAjout;
	public PanelAjouterActeur(){
		monPanelHaut=new JPanel();
		monPanelBas=new JPanel();
		this.setLayout(new BorderLayout());
		messageFilm = new JLabel("Ajouter un Acteur :");
		messageFilm.setForeground(Color.magenta);
		messageFilm.setFont(new Font("Arial", Font.BOLD, 25));
		monPanelHaut.add(messageFilm);
		
		nomLabel=new JLabel("Nom : ");
		nomField=new JTextField();
		prenomLabel=new JLabel("Prenom : ");
		prenomField=new JTextField();
		dateLabel=new JLabel("Date (aaaa-mm-jj) : ");
		dateField=new JFormattedTextField();
		btnAjout=new JButton("Ajouter");
		btnAjout.addActionListener(this);
		
		this.nomField.setPreferredSize(new Dimension(170, 30));
		this.prenomField.setPreferredSize(new Dimension(170, 30));
		this.dateField.setPreferredSize(new Dimension(170, 30));
		this.add(monPanelHaut, BorderLayout.NORTH);
		
		monPanelBas.add(nomLabel);
		monPanelBas.add(nomField);
		monPanelBas.add(prenomLabel);
		monPanelBas.add(prenomField);
		monPanelBas.add(dateLabel);
		monPanelBas.add(dateField);
		monPanelBas.add(btnAjout);
		this.add(monPanelBas);
	}

	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == btnAjout){
			Modele.ajouterActeur(nomField.getText(),prenomField.getText(),LocalDate.parse(dateField.getText()));
		}
		
	}
}
