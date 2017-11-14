import javax.swing.*;

import java.awt.*;
import java.awt.event.*;

public class PanelAccueil extends JPanel{
    private JLabel messageAccueil;
    
	public PanelAccueil(){

		this.setLayout(new FlowLayout());
		this.messageAccueil = new JLabel("Bienvenue au Cinema Pichon !");
		this.messageAccueil.setForeground(Color.magenta);
		messageAccueil.setFont(new Font("Arial", Font.BOLD, 25));
		this.add(messageAccueil);
	}

}
