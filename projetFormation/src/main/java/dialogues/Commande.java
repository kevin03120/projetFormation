package dialogues;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;
import javax.swing.border.LineBorder;
import javax.swing.JTextField;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.JComboBox;
import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Commande extends JFrame {

	private JPanel contentPane;
	private JTextField txtCommande;
	private JTextField txtDate;
	private JTextField txtCode;
	private JTextField txtCategorie;
	private JTextField txtDesignation;
	private JTextField txtMontant;
	private JTable tblCommande;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Commande frame = new Commande();
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
	public Commande() {
		setTitle("Gestion des commandes");
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\images\\Moon-32.png"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 869, 620);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 235, 205));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 140, 0));
		panel.setBounds(0, 0, 250, 622);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblCommande = new JLabel("Commande");
		lblCommande.setHorizontalAlignment(SwingConstants.CENTER);
		lblCommande.setIcon(new ImageIcon("C:\\images\\gestion\\commande\\Shopping-Bag-64-actif.png"));
		lblCommande.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblCommande.setBounds(10, 5, 230, 64);
		panel.add(lblCommande);
		
		JLabel lblCommandeExistante = new JLabel("Commandes existantes");
		lblCommandeExistante.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setVisible(false);
				CommandeExistante fenetreCommEx = new CommandeExistante();
				fenetreCommEx.setVisible(true);
			}
		});
		lblCommandeExistante.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblCommandeExistante.setForeground(new Color(255, 255, 255));
		lblCommandeExistante.setIcon(new ImageIcon("C:\\images\\gestion\\commande\\Receipt-48.png"));
		lblCommandeExistante.setBounds(10, 80, 230, 48);
		panel.add(lblCommandeExistante);
		
		JLabel lblSupprime = new JLabel("Supprimer");
		lblSupprime.setForeground(new Color(255, 255, 255));
		lblSupprime.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblSupprime.setIcon(new ImageIcon("C:\\images\\gestion\\Cancel-48.png"));
		lblSupprime.setBounds(10, 139, 230, 41);
		panel.add(lblSupprime);
		
		JLabel lblSupprimeAll = new JLabel("Supprimer toutes les lignes");
		lblSupprimeAll.setIcon(new ImageIcon("C:\\images\\gestion\\Garbage-Open-48.png"));
		lblSupprimeAll.setForeground(Color.WHITE);
		lblSupprimeAll.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblSupprimeAll.setBounds(10, 191, 230, 41);
		panel.add(lblSupprimeAll);
		
		JLabel lblValider = new JLabel("Valider la commande");
		lblValider.setIcon(new ImageIcon("C:\\images\\gestion\\commande\\Shopping-Cart-05-48.png"));
		lblValider.setForeground(Color.WHITE);
		lblValider.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblValider.setBounds(10, 244, 230, 41);
		panel.add(lblValider);
		
		JLabel lblApercu = new JLabel("Aper\u00E7u");
		lblApercu.setIcon(new ImageIcon("C:\\images\\gestion\\Preview-48.png"));
		lblApercu.setForeground(Color.WHITE);
		lblApercu.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblApercu.setBounds(10, 324, 230, 41);
		panel.add(lblApercu);
		
		JLabel lblImprimer = new JLabel("Imprimer");
		lblImprimer.setIcon(new ImageIcon("C:\\images\\gestion\\Printer-48.png"));
		lblImprimer.setForeground(Color.WHITE);
		lblImprimer.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblImprimer.setBounds(10, 376, 230, 41);
		panel.add(lblImprimer);
		
		JLabel lblExport = new JLabel("Export");
		lblExport.setIcon(new ImageIcon("C:\\images\\gestion\\Data-Export-48.png"));
		lblExport.setForeground(Color.WHITE);
		lblExport.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblExport.setBounds(10, 428, 230, 41);
		panel.add(lblExport);
		
		JLabel lblAccueil = new JLabel("Accueil");
		lblAccueil.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setVisible(false);
				Accueil fenetreAccueil = new Accueil();
				fenetreAccueil.setVisible(true);
			}
		});
		lblAccueil.setIcon(new ImageIcon("C:\\images\\gestion\\Home-48.png"));
		lblAccueil.setForeground(Color.WHITE);
		lblAccueil.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblAccueil.setBounds(10, 523, 230, 48);
		panel.add(lblAccueil);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(new LineBorder(new Color(255, 140, 0)), "Informations g\u00E9n\u00E9rales", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_1.setBackground(new Color(255, 250, 205));
		panel_1.setBounds(262, 11, 580, 107);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblCommandeCours = new JLabel("Commande en cours");
		lblCommandeCours.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblCommandeCours.setBounds(10, 23, 124, 14);
		panel_1.add(lblCommandeCours);
		
		txtCommande = new JTextField();
		txtCommande.setEnabled(false);
		txtCommande.setBounds(144, 21, 241, 20);
		panel_1.add(txtCommande);
		txtCommande.setColumns(10);
		
		JLabel lblDate = new JLabel("Date");
		lblDate.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblDate.setBounds(418, 23, 29, 14);
		panel_1.add(lblDate);
		
		txtDate = new JTextField();
		txtDate.setEnabled(false);
		txtDate.setBounds(457, 21, 113, 20);
		panel_1.add(txtDate);
		txtDate.setColumns(10);
		
		JLabel lblNomDuClient = new JLabel("Nom du client");
		lblNomDuClient.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNomDuClient.setBounds(50, 66, 84, 14);
		panel_1.add(lblNomDuClient);
		
		JLabel txtNomDuClient = new JLabel("Selectionner le client");
		txtNomDuClient.setIcon(new ImageIcon("C:\\images\\gestion\\Search-48.png"));
		txtNomDuClient.setFont(new Font("Tahoma", Font.BOLD, 13));
		txtNomDuClient.setBackground(new Color(255, 140, 0));
		txtNomDuClient.setForeground(new Color(255, 255, 255));
		txtNomDuClient.setBounds(144, 52, 426, 44);
		txtNomDuClient.setOpaque(true);
		panel_1.add(txtNomDuClient);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new TitledBorder(new LineBorder(new Color(255, 140, 0)), "Valeurs de la commande", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_2.setBackground(new Color(255, 235, 205));
		panel_2.setBounds(260, 129, 582, 315);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblSelectionClient = new JLabel("Selectionner un article");
		lblSelectionClient.setOpaque(true);
		lblSelectionClient.setBackground(new Color(255, 140, 0));
		lblSelectionClient.setForeground(new Color(255, 255, 255));
		lblSelectionClient.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblSelectionClient.setIcon(new ImageIcon("C:\\images\\gestion\\Search-48.png"));
		lblSelectionClient.setBounds(10, 23, 236, 43);
		panel_2.add(lblSelectionClient);
		
		JLabel lblCode = new JLabel("Code");
		lblCode.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblCode.setBounds(275, 37, 31, 14);
		panel_2.add(lblCode);
		
		txtCode = new JTextField();
		txtCode.setEnabled(false);
		txtCode.setBounds(316, 35, 76, 20);
		panel_2.add(txtCode);
		txtCode.setColumns(10);
		
		JLabel lblCategorie = new JLabel("Cat\u00E9gorie");
		lblCategorie.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblCategorie.setBounds(402, 38, 59, 14);
		panel_2.add(lblCategorie);
		
		txtCategorie = new JTextField();
		txtCategorie.setEnabled(false);
		txtCategorie.setBounds(471, 35, 101, 20);
		panel_2.add(txtCategorie);
		txtCategorie.setColumns(10);
		
		JLabel lblDesignation = new JLabel("D\u00E9signation");
		lblDesignation.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblDesignation.setBounds(10, 77, 76, 14);
		panel_2.add(lblDesignation);
		
		txtDesignation = new JTextField();
		txtDesignation.setEnabled(false);
		txtDesignation.setBounds(96, 75, 150, 20);
		panel_2.add(txtDesignation);
		txtDesignation.setColumns(10);
		
		JLabel lblMontant = new JLabel("Montant");
		lblMontant.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblMontant.setBounds(256, 77, 59, 14);
		panel_2.add(lblMontant);
		
		txtMontant = new JTextField();
		txtMontant.setEnabled(false);
		txtMontant.setBounds(316, 75, 76, 20);
		panel_2.add(txtMontant);
		txtMontant.setColumns(10);
		
		JLabel lblQuantite = new JLabel("Quantit\u00E9");
		lblQuantite.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblQuantite.setBounds(402, 77, 59, 14);
		panel_2.add(lblQuantite);
		
		JSpinner spnQuantite = new JSpinner();
		spnQuantite.setBounds(471, 75, 101, 20);
		panel_2.add(spnQuantite);
		
		JLabel lblAjouter = new JLabel("Ajouter");
		lblAjouter.setIcon(new ImageIcon("C:\\images\\gestion\\Add-New-48.png"));
		lblAjouter.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblAjouter.setBounds(96, 106, 115, 54);
		panel_2.add(lblAjouter);
		
		JLabel lblModifier = new JLabel("Modifier");
		lblModifier.setIcon(new ImageIcon("C:\\images\\gestion\\Data-Edit-48.png"));
		lblModifier.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblModifier.setBounds(221, 106, 115, 54);
		panel_2.add(lblModifier);
		
		JLabel lblSupprimer = new JLabel("Supprimer");
		lblSupprimer.setIcon(new ImageIcon("C:\\images\\gestion\\Cancel-48.png"));
		lblSupprimer.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblSupprimer.setBounds(346, 106, 130, 54);
		panel_2.add(lblSupprimer);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 168, 562, 136);
		panel_2.add(scrollPane);
		
		tblCommande = new JTable();
		tblCommande.setEnabled(false);
		tblCommande.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Code", "Code Cat\u00E9gorie", "D\u00E9signation", "Quantit\u00E9", "Prix unitaire", "Total"
			}
		));
		scrollPane.setViewportView(tblCommande);
		
		JLabel lblModeDeReglement = new JLabel("Mode de r\u00E9glement");
		lblModeDeReglement.setIcon(new ImageIcon("C:\\images\\gestion\\commande\\ATM-32.png"));
		lblModeDeReglement.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblModeDeReglement.setBounds(365, 478, 166, 24);
		contentPane.add(lblModeDeReglement);
		
		JComboBox cbReglement = new JComboBox();
		cbReglement.setFont(new Font("Tahoma", Font.BOLD, 12));
		cbReglement.setModel(new DefaultComboBoxModel(new String[] {"Carte Bleue", "Cheque", "Especes"}));
		cbReglement.setBounds(541, 481, 100, 20);
		contentPane.add(cbReglement);
		
		JLabel lblTotal = new JLabel("0.00 \u20AC");
		lblTotal.setHorizontalAlignment(SwingConstants.CENTER);
		Border border = BorderFactory.createLineBorder(Color.ORANGE, 2);
		lblTotal.setBorder(border);
		lblTotal.setBackground(new Color(255, 140, 0));
		lblTotal.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblTotal.setBounds(747, 473, 75, 35);
		lblTotal.setOpaque(true);
		contentPane.add(lblTotal);
		
		JLabel lblValide = new JLabel("Valider la commande");
		lblValide.setIcon(new ImageIcon("C:\\images\\gestion\\commande\\Shopping-Cart-05-48.png"));
		lblValide.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblValide.setBounds(637, 536, 185, 35);
		contentPane.add(lblValide);
	}
}
