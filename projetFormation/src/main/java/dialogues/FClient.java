package src.main.java.dialogues;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Panel;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import src.main.java.controle.ControleClient;
import src.main.java.controle.connexion.GlobalConnection;
import src.main.java.controle.modele.ModeleDynamiqueClient;
import src.main.java.entite.Client;
import src.main.java.entite.dao.ClientDaoMysql;
import src.main.java.entite.dao.UserDaoMysql;

import javax.swing.DefaultComboBoxModel;

public class FClient extends JFrame {
	private JTextField txtCode;
	private JTextField txtCreation;
	private JTextField txtPrenom;
	private JTextField txtNom;
	private JTextField txtAdresse;
	private JTextField txtFixe;
	private JTextField txtMobile;
	private JTextField txtEmail;
	private JTextField txtRemarques;
	private JTable tblClient;
	private List<Client> mesClients;
	private ControleClient controleClient;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FClient frame = new FClient(null);
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
	public FClient(List<Client> mesBasesClients) {
		controleClient = new ControleClient();
		setIconImage(
				Toolkit.getDefaultToolkit().getImage(FClient.class.getResource("/target/images/Moon-32.png")));
		FClient a = this;
		mesClients = controleClient.getMesClientsDynamique(mesBasesClients);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 770, 584);
		setTitle("Client");
		JPanel panelClient = new JPanel();
		panelClient.setBackground(SystemColor.textHighlight);
		panelClient.setBounds(0, 0, 162, 547);
		setContentPane(panelClient);
		panelClient.setLayout(null);

		JLabel lblClients = new JLabel("Clients");
		lblClients.setIcon(
				new ImageIcon(FClient.class.getResource("/target/images/gestion/client/User-Modify-64.png")));
		lblClients.setFont(new Font("Dialog", Font.BOLD, 15));
		lblClients.setBounds(10, 11, 132, 69);
		panelClient.add(lblClients);

		JButton btnRechercher = new JButton("Rechercher");
		btnRechercher.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FClientRecherche clientR = new FClientRecherche(a);
				setSize(820, 585);
				panelClient.setVisible(false);
				setContentPane(clientR);
			}
		});
		btnRechercher.setHorizontalAlignment(SwingConstants.LEFT);
		btnRechercher.setIcon(new ImageIcon(FClient.class.getResource("/target/images/gestion/Search-48.png")));
		btnRechercher.setBounds(10, 153, 141, 51);
		panelClient.add(btnRechercher);

		JButton btnAjouter = new JButton(" Ajouter");
		btnAjouter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FClientAjout clientA = new FClientAjout(a);
				setSize(820, 585);
				panelClient.setVisible(false);
				setContentPane(clientA);
			}
		});
		btnAjouter.setHorizontalAlignment(SwingConstants.LEFT);
		btnAjouter.setBounds(10, 91, 141, 51);
		panelClient.add(btnAjouter);
		btnAjouter.setIcon(new ImageIcon(FClient.class.getResource("/target/images/gestion/Add-New-48.png")));

		JButton btnModifier = new JButton("Modifier");
		btnModifier.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(tblClient.getSelectedRow()!=-1){
					Client client = new Client();
					client.setCode(txtCode.getText());
					client.setNom(txtNom.getText());
					client.setPrenom(txtPrenom.getText());
					client.setAdresse(txtAdresse.getText());
					client.setEmail(txtEmail.getText());
					client.setDate_creation(LocalDate.now());
					client.setTel_fixe(client.getTel_fixe());
					client.setTel_mobile(txtMobile.getText());
					client.setRemarques(txtRemarques.getText());
					controleClient.updateClient(client);
					setVisible(false);
					FClient fenetreClient = new FClient(null);
					fenetreClient.setVisible(true);
				}else{
					JOptionPane erreur = new JOptionPane();
					erreur.showMessageDialog(null, "Veuillez tout d'abord saisir un client.",
							"Impossible de modifier", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnModifier.setHorizontalAlignment(SwingConstants.LEFT);
		btnModifier.setIcon(new ImageIcon(FClient.class.getResource("/target/images/gestion/Data-Edit-48.png")));
		btnModifier.setBounds(10, 215, 142, 51);
		panelClient.add(btnModifier);

		JButton btnSupprimer = new JButton("Supprimer");
		btnSupprimer.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JOptionPane jop = new JOptionPane();

				int option = jop.showConfirmDialog(null, "Voulez-vous vraiment supprimer le client selectionné ?",
						"Demande de validation", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
				if (option == JOptionPane.OK_OPTION) {
					if (tblClient.getSelectedRow() != -1) {
						controleClient.deleteClient(tblClient.getSelectedRow(), mesClients);
						setVisible(false);
						FClient clientA = new FClient(null);
						clientA.setVisible(true);
					}
				} else {
					jop.setVisible(false);
				}
			}
		});
		btnSupprimer.setHorizontalAlignment(SwingConstants.LEFT);
		btnSupprimer
				.setIcon(new ImageIcon(FClient.class.getResource("/target/images/gestion/Garbage-Open-48.png")));
		btnSupprimer.setBounds(10, 277, 142, 51);
		panelClient.add(btnSupprimer);

		JButton btnApercu = new JButton("Aper\u00E7u");
		btnApercu.setIcon(new ImageIcon(FClient.class.getResource("/target/images/gestion/Preview-48.png")));
		btnApercu.setBounds(10, 361, 141, 51);
		panelClient.add(btnApercu);

		JButton btnImprimer = new JButton("Imprimer");
		btnImprimer.setBounds(10, 423, 141, 23);
		panelClient.add(btnImprimer);

		JButton btnExport = new JButton("Export");
		btnExport.setBounds(10, 457, 141, 23);
		panelClient.add(btnExport);

		JButton btnAccueil = new JButton("Accueil");
		btnAccueil.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setVisible(false);
				FAccueil fenetreAccueil = new FAccueil();
				fenetreAccueil.setVisible(true);
			}
		});
		btnAccueil.setBounds(10, 519, 142, 23);
		panelClient.add(btnAccueil);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(175, 238, 238));
		panel_1.setBounds(160, 0, 600, 270);
		getContentPane().add(panel_1);
		panel_1.setLayout(null);

		JLabel lblCode = new JLabel("Code");
		lblCode.setBounds(7, 11, 55, 14);
		panel_1.add(lblCode);

		txtCode = new JTextField();
		txtCode.setEnabled(false);
		txtCode.setBounds(72, 8, 175, 20);
		panel_1.add(txtCode);
		txtCode.setColumns(10);

		JLabel lblCreation = new JLabel("Cr\u00E9\u00E9 le");
		lblCreation.setBounds(257, 11, 48, 14);
		panel_1.add(lblCreation);

		txtCreation = new JTextField();
		txtCreation.setEnabled(false);
		txtCreation.setBounds(303, 8, 175, 20);
		panel_1.add(txtCreation);
		txtCreation.setColumns(10);

		JCheckBox chkboxFidelite = new JCheckBox("Carte de fid\u00E9lit\u00E9");
		chkboxFidelite.setBackground(new Color(175, 238, 238));
		chkboxFidelite.setBounds(479, 7, 115, 23);
		panel_1.add(chkboxFidelite);

		JLabel lblPrenom = new JLabel("Pr\u00E9nom");
		lblPrenom.setBounds(7, 36, 64, 14);
		panel_1.add(lblPrenom);

		txtPrenom = new JTextField();
		txtPrenom.setBounds(72, 33, 175, 20);
		panel_1.add(txtPrenom);
		txtPrenom.setColumns(10);

		JLabel lblNom = new JLabel("Nom");
		lblNom.setBounds(257, 36, 37, 14);
		panel_1.add(lblNom);

		txtNom = new JTextField();
		txtNom.setBounds(303, 33, 287, 20);
		panel_1.add(txtNom);
		txtNom.setColumns(10);

		JLabel lblAdresse = new JLabel("Adresse");
		lblAdresse.setBounds(7, 61, 55, 14);
		panel_1.add(lblAdresse);

		txtAdresse = new JTextField();
		txtAdresse.setBounds(72, 58, 518, 20);
		panel_1.add(txtAdresse);
		txtAdresse.setColumns(10);

		JLabel lblFixe = new JLabel("Fixe");
		lblFixe.setBounds(7, 88, 55, 14);
		panel_1.add(lblFixe);

		txtFixe = new JTextField();
		txtFixe.setBounds(72, 85, 175, 20);
		panel_1.add(txtFixe);
		txtFixe.setColumns(10);

		JLabel lblMobile = new JLabel("Mobile");
		lblMobile.setBounds(259, 88, 46, 14);
		panel_1.add(lblMobile);

		txtMobile = new JTextField();
		txtMobile.setBounds(303, 85, 287, 20);
		panel_1.add(txtMobile);
		txtMobile.setColumns(10);

		JLabel lblEmail = new JLabel("Email");
		lblEmail.setBounds(7, 113, 55, 14);
		panel_1.add(lblEmail);

		txtEmail = new JTextField();
		txtEmail.setBounds(72, 110, 518, 20);
		panel_1.add(txtEmail);
		txtEmail.setColumns(10);

		JLabel lblRemarques = new JLabel("Remarques");
		lblRemarques.setBounds(7, 138, 64, 14);
		panel_1.add(lblRemarques);

		txtRemarques = new JTextField();
		txtRemarques.setBounds(72, 135, 518, 124);
		panel_1.add(txtRemarques);
		txtRemarques.setColumns(10);

		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(175, 238, 238));
		panel_2.setBounds(160, 270, 600, 277);
		getContentPane().add(panel_2);
		panel_2.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 600, 245);
		panel_2.add(scrollPane);

		tblClient = new JTable();
		tblClient.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "Code", "Nom", "Pr\u00E9nom", "Carte de fid\u00E9lit\u00E9", "Date de cr\u00E9ation" }));
		scrollPane.setViewportView(tblClient);

		JLabel lblTrierLaListe = new JLabel("Trier la liste par");
		lblTrierLaListe.setIcon(
				new ImageIcon(FClient.class.getResource("/target/images/gestion/Sort-Ascending-32.png")));
		lblTrierLaListe.setBounds(23, 256, 196, 14);
		panel_2.add(lblTrierLaListe);

		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(
				new String[] { "Ordre alphabetique des noms", "Ordre alphabetique des prenoms" }));
		comboBox.setBounds(229, 253, 224, 20);
		panel_2.add(comboBox);

		tblClient.setModel(new ModeleDynamiqueClient(mesClients));
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				JComboBox comboBox = (JComboBox) event.getSource();

				if (comboBox.getSelectedIndex() == 0) {
					FClient clientA = new FClient(controleClient.TriOrdreAlphabetiqueNom(mesClients));
					setVisible(false);
					clientA.setVisible(true);

				} else {
					FClient clientA = new FClient(controleClient.TriOrdreAlphabetiquePrenom(mesClients));
					setVisible(false);
					clientA.setVisible(true);
				}
			}
		});
		tblClient.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent event) {
				Client client = mesClients.get(tblClient.getSelectedRow());
				txtCode.setText(client.getCode());
				txtNom.setText(client.getNom());
				txtPrenom.setText(client.getPrenom());
				txtAdresse.setText(client.getAdresse());
				txtEmail.setText(client.getEmail());
				txtCreation.setText(client.getDate_creation().toString());
				txtFixe.setText(client.getTel_fixe());
				txtMobile.setText(client.getTel_mobile());
				txtRemarques.setText(client.getRemarques());
			}
		});
	}

}
