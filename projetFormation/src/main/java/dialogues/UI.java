package src.main.java.dialogues;

import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class UI {
	private static final String logo = "C:/images/Moon-32.png";
	
	public static Image getLogo() {
		return Toolkit.getDefaultToolkit().getImage(UI.class.getResource(logo));
	}
	private static ImageIcon getIcone(String chemin) {
		return new ImageIcon(UI.class.getResource(chemin));
	}
	public static void deshabillerBouton(JButton bouton) {
		bouton.setOpaque(false);
		bouton.setContentAreaFilled(false);
		bouton.setBorderPainted(false);
	}
}
