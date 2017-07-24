package dialogues;

import javax.swing.JPanel;
import java.awt.SystemColor;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JCheckBox;
import java.awt.Color;
import javax.swing.UIManager;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.JComboBox;

public class Client extends JPanel {
	private JTextField txtCode;
	private JTextField txtCreation;
	private JTextField txtPrenom;
	private JTextField txtNom;
	private JTextField txtAdresse;
	private JTextField txtFixe;
	private JTextField txtMobile;
	private JTextField txtEmail;
	private JTextField txtRemarques;
	private JTable comboBoxChoix;

	/**
	 * Create the panel.
	 */
	public Client() {
		setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.textHighlight);
		panel.setBounds(0, 0, 162, 607);
		add(panel);
		panel.setLayout(null);
		
		JLabel lblClients = new JLabel("Clients");
		lblClients.setIcon(new ImageIcon("C:\\images\\gestion\\client\\People-64-actif.png"));
		lblClients.setFont(new Font("Dialog", Font.BOLD, 15));
		lblClients.setBounds(10, 11, 132, 69);
		panel.add(lblClients);
		
		JButton btnRechercher = new JButton("Rechercher");
		btnRechercher.setIcon(new ImageIcon("C:\\images\\gestion\\Search-48.png"));
		btnRechercher.setBounds(10, 153, 141, 51);
		panel.add(btnRechercher);
		
		JButton btnAjouter = new JButton("      Ajouter");
		btnAjouter.setBounds(10, 91, 141, 51);
		panel.add(btnAjouter);
		btnAjouter.setIcon(new ImageIcon("C:\\images\\gestion\\Add-New-48.png"));
		
		JButton btnModifier = new JButton("Modifier");
		btnModifier.setIcon(new ImageIcon("C:\\images\\gestion\\Data-Edit-48.png"));
		btnModifier.setBounds(10, 215, 142, 51);
		panel.add(btnModifier);
		
		JButton btnSupprimer = new JButton("Supprimer");
		btnSupprimer.setIcon(new ImageIcon("C:\\images\\gestion\\Garbage-Open-48.png"));
		btnSupprimer.setBounds(10, 277, 142, 51);
		panel.add(btnSupprimer);
		
		JButton btnApercu = new JButton("Aper\u00E7u");
		btnApercu.setIcon(new ImageIcon("C:\\images\\gestion\\Preview-48.png"));
		btnApercu.setBounds(10, 361, 141, 51);
		panel.add(btnApercu);
		
		JButton btnImprimer = new JButton("Imprimer");
		btnImprimer.setBounds(10, 423, 141, 23);
		panel.add(btnImprimer);
		
		JButton btnExport = new JButton("Export");
		btnExport.setBounds(10, 457, 141, 23);
		panel.add(btnExport);
		
		JButton btnAccueil = new JButton("Accueil");
		btnAccueil.setBounds(10, 519, 142, 23);
		panel.add(btnAccueil);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(175, 238, 238));
		panel_1.setBounds(160, 0, 600, 270);
		add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblCode = new JLabel("Code");
		lblCode.setBounds(37, 11, 25, 14);
		panel_1.add(lblCode);
		
		txtCode = new JTextField();
		txtCode.setBounds(72, 8, 175, 20);
		panel_1.add(txtCode);
		txtCode.setColumns(10);
		
		JLabel lblCreation = new JLabel("Cr\u00E9\u00E9 le");
		lblCreation.setBounds(259, 11, 34, 14);
		panel_1.add(lblCreation);
		
		txtCreation = new JTextField();
		txtCreation.setBounds(303, 8, 175, 20);
		panel_1.add(txtCreation);
		txtCreation.setColumns(10);
		
		JCheckBox chkboxFidelite = new JCheckBox("Carte de fid\u00E9lit\u00E9");
		chkboxFidelite.setBackground(new Color(175, 238, 238));
		chkboxFidelite.setBounds(485, 7, 109, 23);
		panel_1.add(chkboxFidelite);
		
		JLabel lblPrenom = new JLabel("Pr\u00E9nom");
		lblPrenom.setBounds(25, 36, 46, 14);
		panel_1.add(lblPrenom);
		
		txtPrenom = new JTextField();
		txtPrenom.setBounds(72, 33, 175, 20);
		panel_1.add(txtPrenom);
		txtPrenom.setColumns(10);
		
		JLabel lblNom = new JLabel("Nom");
		lblNom.setBounds(269, 36, 25, 14);
		panel_1.add(lblNom);
		
		txtNom = new JTextField();
		txtNom.setBounds(303, 33, 287, 20);
		panel_1.add(txtNom);
		txtNom.setColumns(10);
		
		JLabel lblAdresse = new JLabel("Adresse");
		lblAdresse.setBounds(23, 61, 39, 14);
		panel_1.add(lblAdresse);
		
		txtAdresse = new JTextField();
		txtAdresse.setBounds(72, 58, 518, 20);
		panel_1.add(txtAdresse);
		txtAdresse.setColumns(10);
		
		JLabel lblFixe = new JLabel("Fixe");
		lblFixe.setBounds(42, 88, 20, 14);
		panel_1.add(lblFixe);
		
		txtFixe = new JTextField();
		txtFixe.setBounds(72, 85, 175, 20);
		panel_1.add(txtFixe);
		txtFixe.setColumns(10);
		
		JLabel lblMobile = new JLabel("Mobile");
		lblMobile.setBounds(259, 88, 34, 14);
		panel_1.add(lblMobile);
		
		txtMobile = new JTextField();
		txtMobile.setBounds(303, 85, 287, 20);
		panel_1.add(txtMobile);
		txtMobile.setColumns(10);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setBounds(37, 113, 25, 14);
		panel_1.add(lblEmail);
		
		txtEmail = new JTextField();
		txtEmail.setBounds(72, 110, 518, 20);
		panel_1.add(txtEmail);
		txtEmail.setColumns(10);
		
		JLabel lblRemarques = new JLabel("Remarques");
		lblRemarques.setBounds(7, 138, 55, 14);
		panel_1.add(lblRemarques);
		
		txtRemarques = new JTextField();
		txtRemarques.setBounds(72, 135, 518, 124);
		panel_1.add(txtRemarques);
		txtRemarques.setColumns(10);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(175, 238, 238));
		panel_2.setBounds(160, 270, 600, 277);
		add(panel_2);
		panel_2.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 600, 245);
		panel_2.add(scrollPane);
		
		comboBoxChoix = new JTable();
		scrollPane.setViewportView(comboBoxChoix);
		
		JLabel lblTrierLaListe = new JLabel("Trier la liste par");
		lblTrierLaListe.setIcon(new ImageIcon("C:\\Users\\SDJ05\\git\\projetFormation\\projetFormation\\target\\images\\gestion\\Sort-Ascending-32.png"));
		lblTrierLaListe.setBounds(23, 256, 110, 14);
		panel_2.add(lblTrierLaListe);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(143, 253, 71, 20);
		panel_2.add(comboBox);

	}
}
