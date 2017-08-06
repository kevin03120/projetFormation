package src.main.java.dialogues;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.SystemColor;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.ImageIcon;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Panel;

import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Window;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FAccueil extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FAccueil frame = new FAccueil();
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
	public FAccueil() {
		setTitle("Accueil");
		setIconImage(Toolkit.getDefaultToolkit().getImage(FAccueil.class.getResource("/target/images/Moon-32.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 702, 525);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnFichiers = new JMenu("Fichiers");
		menuBar.add(mnFichiers);
		
		JMenu mnVues = new JMenu("Vues");
		menuBar.add(mnVues);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.controlShadow);
		panel.setBounds(0, 0, 126, 471);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNomSociete = new JLabel("SARL Luna");
		lblNomSociete.setBounds(29, 31, 69, 16);
		panel.add(lblNomSociete);
		lblNomSociete.setFont(new Font("Tahoma", Font.BOLD, 13));
		
		JLabel lblRetour = new JLabel("Retour");
		lblRetour.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setVisible(false);
				FConnexion fenetreConnexion = new FConnexion();
				fenetreConnexion.setVisible(true);
			}
		});
		lblRetour.setBackground(SystemColor.controlHighlight);
		lblRetour.setHorizontalAlignment(SwingConstants.CENTER);
		lblRetour.setOpaque(true);
		lblRetour.setIcon(new ImageIcon(FAccueil.class.getResource("/target/images/connection/Stop-48.png")));
		lblRetour.setBounds(0, 392, 126, 35);
		panel.add(lblRetour);
		
		JLabel lblInformation = new JLabel("Affichage option");
		lblInformation.setBounds(26, 87, 84, 14);
		panel.add(lblInformation);
		lblInformation.setForeground(SystemColor.text);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(null);
		panel_1.setBounds(160, 23, 493, 421);
		contentPane.add(panel_1);
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[]{0, 0, 0, 0};
		gbl_panel_1.rowHeights = new int[]{0, 0, 0, 0};
		gbl_panel_1.columnWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panel_1.rowWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel_1.setLayout(gbl_panel_1);
		
		JButton btnArticle = new JButton("");
		btnArticle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				FArticle fenetreArticle = new FArticle(null);
				fenetreArticle.setVisible(true);
			}
		});
		btnArticle.setIcon(new ImageIcon(FAccueil.class.getResource("/target/images/accueil/Product-128.png")));
		GridBagConstraints gbc_btnArticle = new GridBagConstraints();
		gbc_btnArticle.insets = new Insets(0, 0, 5, 5);
		gbc_btnArticle.gridx = 1;
		gbc_btnArticle.gridy = 0;
		panel_1.add(btnArticle, gbc_btnArticle);
		
		JButton btnClient = new JButton("");
		btnClient.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				FClient fenetreClient = new FClient(null);
				fenetreClient.setVisible(true);
			}
		});
		btnClient.setIcon(new ImageIcon(FAccueil.class.getResource("/target/images/accueil/People-128.png")));
		GridBagConstraints gbc_btnClient = new GridBagConstraints();
		gbc_btnClient.insets = new Insets(0, 0, 5, 5);
		gbc_btnClient.gridx = 0;
		gbc_btnClient.gridy = 1;
		panel_1.add(btnClient, gbc_btnClient);
		
		JButton btnStatistique = new JButton("");
		btnStatistique.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setVisible(false);
				FStatistiques fenetreStat = new FStatistiques("Statistiques","Statistiques des articles vendus");
				fenetreStat.setVisible(true);
			}
		});
		btnStatistique.setIcon(new ImageIcon(FAccueil.class.getResource("/target/images/accueil/Diagram-128.png")));
		GridBagConstraints gbc_btnStatistique = new GridBagConstraints();
		gbc_btnStatistique.insets = new Insets(0, 0, 5, 5);
		gbc_btnStatistique.gridx = 1;
		gbc_btnStatistique.gridy = 1;
		panel_1.add(btnStatistique, gbc_btnStatistique);
		
		JButton btnCommande = new JButton("");
		btnCommande.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				FCommande fenetreCommande = new FCommande();
				fenetreCommande.setVisible(true);
			}
		});
		btnCommande.setIcon(new ImageIcon(FAccueil.class.getResource("/target/images/accueil/Shopping-Bag-128.png")));
		GridBagConstraints gbc_btnCommande = new GridBagConstraints();
		gbc_btnCommande.insets = new Insets(0, 0, 5, 0);
		gbc_btnCommande.gridx = 2;
		gbc_btnCommande.gridy = 1;
		panel_1.add(btnCommande, gbc_btnCommande);
		
		JButton btnParametre = new JButton("");
		btnParametre.setIcon(new ImageIcon(FAccueil.class.getResource("/target/images/accueil/Settings-02-128.png")));
		GridBagConstraints gbc_btnParametre = new GridBagConstraints();
		gbc_btnParametre.insets = new Insets(0, 0, 0, 5);
		gbc_btnParametre.gridx = 1;
		gbc_btnParametre.gridy = 2;
		panel_1.add(btnParametre, gbc_btnParametre);
	}
}
