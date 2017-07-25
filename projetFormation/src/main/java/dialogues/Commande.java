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

public class Commande extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTable table;

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
		
		JLabel lblNewLabel = new JLabel("Commande");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setIcon(new ImageIcon("C:\\images\\gestion\\commande\\Shopping-Bag-64-actif.png"));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel.setBounds(10, 5, 230, 64);
		panel.add(lblNewLabel);
		
		JLabel lblCommandeExistante = new JLabel("Commandes existantes");
		lblCommandeExistante.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblCommandeExistante.setForeground(new Color(255, 255, 255));
		lblCommandeExistante.setIcon(new ImageIcon("C:\\images\\gestion\\commande\\Receipt-48.png"));
		lblCommandeExistante.setBounds(10, 80, 230, 48);
		panel.add(lblCommandeExistante);
		
		JLabel lblNewLabel_1 = new JLabel("Supprimer");
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_1.setIcon(new ImageIcon("C:\\images\\gestion\\Cancel-48.png"));
		lblNewLabel_1.setBounds(10, 139, 230, 41);
		panel.add(lblNewLabel_1);
		
		JLabel lblSupprimerToutesLes = new JLabel("Supprimer toutes les lignes");
		lblSupprimerToutesLes.setIcon(new ImageIcon("C:\\images\\gestion\\Garbage-Open-48.png"));
		lblSupprimerToutesLes.setForeground(Color.WHITE);
		lblSupprimerToutesLes.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblSupprimerToutesLes.setBounds(10, 191, 230, 41);
		panel.add(lblSupprimerToutesLes);
		
		JLabel lblValiderLaCommande = new JLabel("Valider la commande");
		lblValiderLaCommande.setIcon(new ImageIcon("C:\\images\\gestion\\commande\\Shopping-Cart-05-48.png"));
		lblValiderLaCommande.setForeground(Color.WHITE);
		lblValiderLaCommande.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblValiderLaCommande.setBounds(10, 244, 230, 41);
		panel.add(lblValiderLaCommande);
		
		JLabel lblAperu = new JLabel("Aper\u00E7u");
		lblAperu.setIcon(new ImageIcon("C:\\images\\gestion\\Preview-48.png"));
		lblAperu.setForeground(Color.WHITE);
		lblAperu.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblAperu.setBounds(10, 324, 230, 41);
		panel.add(lblAperu);
		
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
		
		JLabel lblNewLabel_2 = new JLabel("Commande en cours");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_2.setBounds(10, 23, 124, 14);
		panel_1.add(lblNewLabel_2);
		
		textField = new JTextField();
		textField.setEnabled(false);
		textField.setBounds(144, 21, 241, 20);
		panel_1.add(textField);
		textField.setColumns(10);
		
		JLabel lblDate = new JLabel("Date");
		lblDate.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblDate.setBounds(418, 23, 29, 14);
		panel_1.add(lblDate);
		
		textField_1 = new JTextField();
		textField_1.setEnabled(false);
		textField_1.setBounds(457, 21, 113, 20);
		panel_1.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNomDuClient = new JLabel("Nom du client");
		lblNomDuClient.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNomDuClient.setBounds(50, 66, 84, 14);
		panel_1.add(lblNomDuClient);
		
		JLabel lblNewLabel_3 = new JLabel("Selectionner le client");
		lblNewLabel_3.setIcon(new ImageIcon("C:\\images\\gestion\\Search-48.png"));
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_3.setBackground(new Color(255, 140, 0));
		lblNewLabel_3.setForeground(new Color(255, 255, 255));
		lblNewLabel_3.setBounds(144, 52, 426, 44);
		lblNewLabel_3.setOpaque(true);
		panel_1.add(lblNewLabel_3);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new TitledBorder(new LineBorder(new Color(255, 140, 0)), "Valeurs de la commande", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_2.setBackground(new Color(255, 235, 205));
		panel_2.setBounds(260, 129, 582, 315);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblNewLabel_4 = new JLabel("Selectionner un article");
		lblNewLabel_4.setOpaque(true);
		lblNewLabel_4.setBackground(new Color(255, 140, 0));
		lblNewLabel_4.setForeground(new Color(255, 255, 255));
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_4.setIcon(new ImageIcon("C:\\images\\gestion\\Search-48.png"));
		lblNewLabel_4.setBounds(10, 23, 236, 43);
		panel_2.add(lblNewLabel_4);
		
		JLabel lblCode = new JLabel("Code");
		lblCode.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblCode.setBounds(275, 37, 31, 14);
		panel_2.add(lblCode);
		
		textField_2 = new JTextField();
		textField_2.setEnabled(false);
		textField_2.setBounds(316, 35, 76, 20);
		panel_2.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblCatgorie = new JLabel("Cat\u00E9gorie");
		lblCatgorie.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblCatgorie.setBounds(402, 38, 59, 14);
		panel_2.add(lblCatgorie);
		
		textField_3 = new JTextField();
		textField_3.setEnabled(false);
		textField_3.setBounds(471, 35, 101, 20);
		panel_2.add(textField_3);
		textField_3.setColumns(10);
		
		JLabel lblDsignation = new JLabel("D\u00E9signation");
		lblDsignation.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblDsignation.setBounds(10, 77, 76, 14);
		panel_2.add(lblDsignation);
		
		textField_4 = new JTextField();
		textField_4.setEnabled(false);
		textField_4.setBounds(96, 75, 150, 20);
		panel_2.add(textField_4);
		textField_4.setColumns(10);
		
		JLabel lblMontant = new JLabel("Montant");
		lblMontant.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblMontant.setBounds(256, 77, 59, 14);
		panel_2.add(lblMontant);
		
		textField_5 = new JTextField();
		textField_5.setEnabled(false);
		textField_5.setBounds(316, 75, 76, 20);
		panel_2.add(textField_5);
		textField_5.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("Quantit\u00E9");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_5.setBounds(402, 77, 59, 14);
		panel_2.add(lblNewLabel_5);
		
		JSpinner spinner = new JSpinner();
		spinner.setBounds(471, 75, 101, 20);
		panel_2.add(spinner);
		
		JLabel lblNewLabel_6 = new JLabel("Ajouter");
		lblNewLabel_6.setIcon(new ImageIcon("C:\\images\\gestion\\Add-New-48.png"));
		lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_6.setBounds(96, 106, 115, 54);
		panel_2.add(lblNewLabel_6);
		
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
		
		table = new JTable();
		table.setEnabled(false);
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Code", "Code Cat\u00E9gorie", "D\u00E9signation", "Quantit\u00E9", "Prix unitaire", "Total"
			}
		));
		scrollPane.setViewportView(table);
		
		JLabel lblModeDeRglement = new JLabel("Mode de r\u00E9glement");
		lblModeDeRglement.setIcon(new ImageIcon("C:\\images\\gestion\\commande\\ATM-32.png"));
		lblModeDeRglement.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblModeDeRglement.setBounds(365, 478, 166, 24);
		contentPane.add(lblModeDeRglement);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setFont(new Font("Tahoma", Font.BOLD, 12));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Carte Bleue", "Cheque", "Especes"}));
		comboBox.setBounds(541, 481, 100, 20);
		contentPane.add(comboBox);
		
		JLabel lblNewLabel_7 = new JLabel("0.00 \u20AC");
		lblNewLabel_7.setHorizontalAlignment(SwingConstants.CENTER);
		Border border = BorderFactory.createLineBorder(Color.ORANGE, 2);
		lblNewLabel_7.setBorder(border);
		lblNewLabel_7.setBackground(new Color(255, 140, 0));
		lblNewLabel_7.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_7.setBounds(747, 473, 75, 35);
		lblNewLabel_7.setOpaque(true);
		contentPane.add(lblNewLabel_7);
		
		JLabel lblValiderLaCommande_1 = new JLabel("Valider la commande");
		lblValiderLaCommande_1.setIcon(new ImageIcon("C:\\images\\gestion\\commande\\Shopping-Cart-05-48.png"));
		lblValiderLaCommande_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblValiderLaCommande_1.setBounds(637, 536, 185, 35);
		contentPane.add(lblValiderLaCommande_1);
	}
}
