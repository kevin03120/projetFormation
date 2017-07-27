package src.main.java.dialogues;

import java.awt.SystemColor;

import javax.swing.JPanel;
import java.awt.FlowLayout;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.border.TitledBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import src.main.java.controle.ControleClient;
import src.main.java.controle.connexion.GlobalConnection;
import src.main.java.controle.modele.ModeleDynamiqueClient;
import src.main.java.entite.Client;
import src.main.java.entite.dao.ClientDaoMysql;

import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JCheckBox;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JComboBox;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle.Control;

public class ClientRecherche extends JPanel {
	private JTextField txtCode;
	private JTextField txtCreation;
	private JTextField txtPrenom;
	private JTextField txtNom;
	private JTextField txtAdresse;
	private JTextField txtFixe;
	private JTextField txtMobile;
	private JTextField txtEmail;
	private JTextField txtRemarque;
	private JTable tblClient;
	private ControleClient controleClient;
	private List<Client> mesClients;
	/**
	 * Create the panel.
	 */
	public ClientRecherche(ClientAccueil a) {
		controleClient = new ControleClient();
		setBackground(new Color(224, 255, 255));
		setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.textHighlight);
		panel.setBounds(0, 0, 184, 557);
		add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(ClientRecherche.class.getResource("/target/images/gestion/client/User-Find-64.png")));
		lblNewLabel.setBounds(10, 11, 64, 64);
		panel.add(lblNewLabel);
		
		JButton btnRecherche = new JButton("Rechercher");
		btnRecherche.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				mesClients = new ArrayList<>();
				if(!txtCode.getText().equals("")){
					mesClients = controleClient.getClientParCode(txtCode.getText());
				}else{
					if(!txtNom.getText().equals("")){
						mesClients = controleClient.getClientParNom(txtNom.getText());
					}else{
						if(!txtPrenom.getText().equals("")){
							mesClients = controleClient.getClientParPrenom(txtPrenom.getText());
						}
					}
				}
				tblClient.setModel(new ModeleDynamiqueClient(mesClients));
			}
		});
		btnRecherche.setBounds(10, 86, 164, 55);
		panel.add(btnRecherche);
		
		JButton btnApercu = new JButton("Aper\u00E7u");
		btnApercu.setBounds(10, 246, 164, 55);
		panel.add(btnApercu);
		
		JButton btnImprimer = new JButton("Imprimer");
		btnImprimer.setBounds(10, 312, 164, 23);
		panel.add(btnImprimer);
		
		JButton btnExport = new JButton("Export");
		btnExport.setBounds(10, 346, 164, 23);
		panel.add(btnExport);
		
		JButton btnAnnuler = new JButton("Annuler");
		btnAnnuler.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				a.setVisible(false);
				ClientAccueil clientA = new ClientAccueil(null);
				clientA.setVisible(true);
			}
		});
		btnAnnuler.setBounds(10, 491, 164, 55);
		panel.add(btnAnnuler);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)), "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(194, 11, 609, 249);
		add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblCode = new JLabel("Code");
		lblCode.setBounds(36, 11, 25, 14);
		panel_1.add(lblCode);
		
		txtCode = new JTextField();
		txtCode.setBounds(71, 8, 165, 20);
		panel_1.add(txtCode);
		txtCode.setColumns(10);
		
		JLabel lblCreation = new JLabel("Cr\u00E9\u00E9 le");
		lblCreation.setBounds(269, 11, 34, 14);
		panel_1.add(lblCreation);
		
		txtCreation = new JTextField();
		txtCreation.setEnabled(false);
		txtCreation.setBounds(313, 8, 149, 20);
		panel_1.add(txtCreation);
		txtCreation.setColumns(10);
		
		JCheckBox chkboxFidelite = new JCheckBox("Carte de fid\u00E9lit\u00E9");
		chkboxFidelite.setEnabled(false);
		chkboxFidelite.setBounds(489, 7, 114, 23);
		panel_1.add(chkboxFidelite);
		
		JLabel lblPrenom = new JLabel("Pr\u00E9nom");
		lblPrenom.setBounds(25, 36, 36, 14);
		panel_1.add(lblPrenom);
		
		txtPrenom = new JTextField();
		txtPrenom.setBounds(71, 33, 165, 20);
		panel_1.add(txtPrenom);
		txtPrenom.setColumns(10);
		
		JLabel lblNom = new JLabel("Nom");
		lblNom.setBounds(279, 36, 25, 14);
		panel_1.add(lblNom);
		
		txtNom = new JTextField();
		txtNom.setBounds(313, 33, 286, 20);
		panel_1.add(txtNom);
		txtNom.setColumns(10);
		
		JLabel lblAdresse = new JLabel("Adresse");
		lblAdresse.setBounds(22, 61, 39, 14);
		panel_1.add(lblAdresse);
		
		txtAdresse = new JTextField();
		txtAdresse.setEnabled(false);
		txtAdresse.setBounds(71, 58, 528, 20);
		panel_1.add(txtAdresse);
		txtAdresse.setColumns(10);
		
		JLabel lblFixe = new JLabel("Fixe");
		lblFixe.setBounds(41, 87, 20, 14);
		panel_1.add(lblFixe);
		
		txtFixe = new JTextField();
		txtFixe.setEnabled(false);
		txtFixe.setBounds(71, 84, 165, 20);
		panel_1.add(txtFixe);
		txtFixe.setColumns(10);
		
		JLabel lblMobile = new JLabel("Mobile");
		lblMobile.setBounds(269, 89, 34, 14);
		panel_1.add(lblMobile);
		
		txtMobile = new JTextField();
		txtMobile.setEnabled(false);
		txtMobile.setBounds(313, 84, 286, 20);
		panel_1.add(txtMobile);
		txtMobile.setColumns(10);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setBounds(36, 112, 25, 14);
		panel_1.add(lblEmail);
		
		txtEmail = new JTextField();
		txtEmail.setEnabled(false);
		txtEmail.setBounds(71, 109, 528, 20);
		panel_1.add(txtEmail);
		txtEmail.setColumns(10);
		
		JLabel lblRemarques = new JLabel("Remarques");
		lblRemarques.setBounds(7, 137, 54, 14);
		panel_1.add(lblRemarques);
		
		txtRemarque = new JTextField();
		txtRemarque.setEnabled(false);
		txtRemarque.setBounds(71, 134, 528, 104);
		panel_1.add(txtRemarque);
		txtRemarque.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(194, 271, 609, 249);
		add(scrollPane);
		
		tblClient = new JTable();
		scrollPane.setViewportView(tblClient);
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
				txtRemarque.setText(client.getRemarques());
			}
		});
		
		JLabel lblTri = new JLabel("Trier la liste par");
		lblTri.setIcon(new ImageIcon(ClientRecherche.class.getResource("/target/images/gestion/Sort-Ascending-32.png")));
		lblTri.setBounds(194, 531, 110, 14);
		add(lblTri);
		
		JComboBox comboTri = new JComboBox();
		comboTri.setBounds(314, 528, 96, 20);
		add(comboTri);
	}
}
