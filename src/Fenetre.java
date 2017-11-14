import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem; 
import javax.swing.JPanel;

public class Fenetre extends JFrame implements ActionListener{
	private JMenuBar menuBar;
	private JMenu menuConsult;
	private JMenu menuAjout;
	private JMenu menuSupp;
	private JMenuItem itemQuitter;
	private JMenuItem itemFilm;
	private JMenuItem itemActeur;
	private JMenuItem itemGenre;
	private JMenuItem itemFilmA;
	private JMenuItem itemActeurA;
	private JMenuItem itemGenreA;
	private JMenuItem itemFilmS;
	private JMenuItem itemActeurS;
	private JMenuItem itemGenreS;
	private JMenuItem itemListeA;
	private JMenuItem itemListeS;
	private JPanel monPanel;
	
	public Fenetre(){
		menuBar = new JMenuBar();
		monPanel = new JPanel();
		
		//Instanciation Menus
		 menuConsult = new JMenu("Consultation");
		 menuAjout = new JMenu("Ajouter");
		 menuSupp = new JMenu("Supprimer");
		
		//Instanciation Items
		 itemFilm = new JMenuItem("Film");
		 itemActeur = new JMenuItem("Acteur");
		 itemGenre = new JMenuItem("Genre");
		 
		 itemFilmA = new JMenuItem("Film");
		 itemActeurA = new JMenuItem("Acteur");
		 itemGenreA = new JMenuItem("Genre");
		 itemListeA=new JMenuItem("Les Acteurs");
		 
		 itemFilmS = new JMenuItem("Film");
		 itemActeurS = new JMenuItem("Acteur");
		 itemGenreS = new JMenuItem("Genre");
		 itemListeS=new JMenuItem("Les Acteurs");
		 itemQuitter = new JMenuItem("Quitter");
		
		this.setTitle("Cinema");
		this.setSize(800, 600);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null); 
		this.setLayout(new FlowLayout());
		this.setResizable(false);
		
		//Ajout des items dans les menus 
		this.menuConsult.add(itemFilm);
		this.menuConsult.add(itemActeur);
		this.menuConsult.add(itemGenre);
		
		this.menuAjout.add(itemFilmA);
		this.menuAjout.add(itemActeurA);
		this.menuAjout.add(itemGenreA);
		this.menuAjout.add(itemListeA);
		
		this.menuSupp.add(itemFilmS);
		this.menuSupp.add(itemActeurS);
		this.menuSupp.add(itemGenreS);
		this.menuSupp.add(itemListeS);
		
		//Ajout des menus dans le menuBar
		this.menuBar.add(menuConsult);
		this.menuBar.add(menuAjout);
		this.menuBar.add(menuSupp);
		this.menuBar.add(itemQuitter);
		
		itemQuitter.addActionListener(this);
		itemFilm.addActionListener(this);
		itemActeur.addActionListener(this);
		itemGenre.addActionListener(this);
		itemFilmA.addActionListener(this);
		itemActeurA.addActionListener(this);
		itemGenreA.addActionListener(this);
		itemFilmS.addActionListener(this);
		itemActeurS.addActionListener(this);
		itemGenreS.addActionListener(this);
		itemListeA.addActionListener(this);
		itemListeS.addActionListener(this);
		
		this.setJMenuBar(menuBar);
		PanelAccueil monPanelAccueil=new PanelAccueil();
		this.getContentPane().setBackground(Color.WHITE);
		this.getContentPane().add(monPanelAccueil);
		this.setVisible(true); 
	}
	public void actionPerformed(ActionEvent evenement) {
		if(evenement.getSource()==itemQuitter){
			System.exit(0);
		}
		else{
			if(evenement.getSource()==itemFilm){
				PanelConsultationFilm monPanelConsultationFilm = new PanelConsultationFilm();
				this.setContentPane(monPanelConsultationFilm);
				this.getContentPane().setBackground(Color.WHITE);
				this.getContentPane().revalidate();
			}
			else{
				if(evenement.getSource()==itemActeur){
					PanelConsultationActeur monPanelConsultationActeur = new PanelConsultationActeur();
					this.setContentPane(monPanelConsultationActeur);
					this.getContentPane().setBackground(Color.WHITE);
					this.getContentPane().revalidate();
				}
				else{
					if(evenement.getSource()==itemGenre){
						PanelConsultationGenre monPanelConsultationGenre = new PanelConsultationGenre();
						this.setContentPane(monPanelConsultationGenre);
						this.getContentPane().setBackground(Color.WHITE);
						this.getContentPane().revalidate();
					}
					else{
						if(evenement.getSource()==itemFilmA){
							PanelAjouterFilm monPanelAjouterFilm = new PanelAjouterFilm();
							this.setContentPane(monPanelAjouterFilm);
							this.getContentPane().revalidate();
						}
						else{
							if(evenement.getSource()==itemActeurA){
								PanelAjouterActeur monPanelAjouterActeur = new PanelAjouterActeur();
								this.setContentPane(monPanelAjouterActeur);
								this.getContentPane().revalidate();
							}
							else{
								if(evenement.getSource()==itemGenreA){
									PanelAjouterGenre monPanelAjouterGenre = new PanelAjouterGenre();
									this.setContentPane(monPanelAjouterGenre);
									this.getContentPane().revalidate();
								}
								else{
									if(evenement.getSource()==itemGenreS){
										PanelSupprimerGenre monPanelSupprimerGenre = new PanelSupprimerGenre();
										this.setContentPane(monPanelSupprimerGenre);
										this.getContentPane().revalidate();
									}
									else{
										if(evenement.getSource()==itemFilmS){
											PanelSupprimerFilm monPanelSupprimerFilm = new PanelSupprimerFilm();
											this.setContentPane(monPanelSupprimerFilm);
											this.getContentPane().revalidate();
										}
										else{
											if(evenement.getSource()==itemActeurS){
												PanelSupprimerActeur monPanelSupprimerActeur = new PanelSupprimerActeur();
												this.setContentPane(monPanelSupprimerActeur);
												this.getContentPane().revalidate();
											}
											else{
												if(evenement.getSource()==itemListeA){
													PanelListeActeur monPanelListeActeur = new PanelListeActeur();
													this.setContentPane(monPanelListeActeur);
													this.getContentPane().revalidate();
												}
												else{
													if(evenement.getSource()==itemListeS){
														PanelListeActeurS monPanelListeActeurS = new PanelListeActeurS();
														this.setContentPane(monPanelListeActeurS);
														this.getContentPane().revalidate();
													}
													
												}
											}
											
										}
										
									}
									
								}
								
							}
							
						}
						
					}
				}
			}
		}
	}
}
