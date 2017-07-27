package src.main.java.dialogues;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class FErreur extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FErreur frame = new FErreur();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public FErreur() {
		setBounds(100, 100, 362, 154);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JLabel lblErreurDeConnexion = new JLabel("Erreur de connexion. Veuillez contacter le responsable informatique.");
		lblErreurDeConnexion.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblErreurDeConnexion, BorderLayout.CENTER);
	}

}
