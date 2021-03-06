package src.main.java.dialogues;

import javax.swing.JPanel;
import java.awt.SystemColor;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Panel;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.border.TitledBorder;

import src.main.java.controle.ControleClient;
import src.main.java.controle.connexion.GlobalConnection;
import src.main.java.entite.Client;
import src.main.java.entite.dao.ClientDaoMysql;

import javax.swing.UIManager;
import java.awt.Color;
import javax.swing.border.LineBorder;
import javax.swing.JTextField;
import javax.swing.JCheckBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class FClientAjout extends JPanel {
	private JTextField txtCode;
	private JTextField txtPrenom;
	private JTextField txtNom;
	private JTextField txtAdresse;
	private JTextField txtCodePostal;
	private JTextField txtVille;
	private JTextField txtFixe;
	private JTextField txtMobile;
	private JTextField txtRemarques;
	private JTextField txtEmail;
	private JCheckBox chkCarteFidelite;
	private JFormattedTextField txtCreation;
	private FClientAjout cliAjout;
	private ControleClient controleClient;

	/**
	 * Create the panel.
	 */
	public FClientAjout(FClient a) {
		cliAjout = this;
		controleClient = new ControleClient();
		setBackground(new Color(175, 238, 238));
		setLayout(null);

		JPanel panelMenuAjout = new JPanel();
		panelMenuAjout.setBackground(SystemColor.textHighlight);
		panelMenuAjout.setBounds(0, 0, 184, 545);
		add(panelMenuAjout);
		panelMenuAjout.setLayout(null);

		JLabel lblAjout = new JLabel("Ajout");
		lblAjout.setIcon(new ImageIcon(FClientAjout.class.getResource("/target/images/gestion/client/User-Add-64.png")));
		lblAjout.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblAjout.setBounds(26, 11, 132, 64);
		panelMenuAjout.add(lblAjout);

		JButton btnSauvegarder = new JButton("Sauvegarder");
		btnSauvegarder.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				boolean isExist = false;
				if (!txtCode.getText().equals("")) {
					for (Client cli : controleClient.getMesClients()) {
						if (cli.getCode().equals(txtCode.getText())) {
							isExist = true;
						}
					}
					if (!isExist) {
						Client c = new Client();
						c.setCode(txtCode.getText());
						c.setNom(txtNom.getText());
						c.setPrenom(txtPrenom.getText());
						c.setAdresse(txtAdresse.getText());
						c.setEmail(txtEmail.getText());
						c.setFidelite(chkCarteFidelite.isSelected());
						c.setTel_fixe(txtFixe.getText());
						c.setTel_mobile(txtMobile.getText());
						c.setRemarques(txtRemarques.getText());
						controleClient.addClient(c);
						a.setVisible(false);
						FClient acc = new FClient(null);
						acc.setVisible(true);
					} else {
						JOptionPane erreur = new JOptionPane();
						erreur.showMessageDialog(null, "Impossible d'ajouter ce client, le code est d�ja existant.",
								"Code d�j� existant !", JOptionPane.ERROR_MESSAGE);
					}

				}
			}
		});
		btnSauvegarder.setIcon(new ImageIcon(FClientAjout.class.getResource("/target/images/gestion/Save-48.png")));
		btnSauvegarder.setBounds(10, 86, 164, 52);
		panelMenuAjout.add(btnSauvegarder);

		JButton btnApercu = new JButton("Aper\u00E7u");
		btnApercu.setIcon(new ImageIcon(FClientAjout.class.getResource("/target/images/gestion/Preview-48.png")));
		btnApercu.setBounds(10, 236, 164, 52);
		panelMenuAjout.add(btnApercu);

		JButton btnImprimer = new JButton("Imprimer");
		btnImprimer.setBounds(10, 299, 164, 23);
		panelMenuAjout.add(btnImprimer);

		JButton btnExport = new JButton("Export");
		btnExport.setBounds(10, 333, 164, 23);
		panelMenuAjout.add(btnExport);

		JButton btnAnnuler = new JButton("Annuler");
		btnAnnuler.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				a.setVisible(false);
				FClient acc = new FClient(null);
				acc.setVisible(true);
			}
		});
		btnAnnuler.setIcon(new ImageIcon(FClientAjout.class.getResource("/target/images/gestion/Cancel-48.png")));
		btnAnnuler.setBounds(10, 490, 164, 44);
		panelMenuAjout.add(btnAnnuler);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(175, 238, 238));
		panel_1.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)), "Client", TitledBorder.LEFT,
				TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_1.setBounds(194, 11, 596, 60);
		add(panel_1);
		panel_1.setLayout(null);

		JLabel lblCode = new JLabel("Code");
		lblCode.setBounds(23, 24, 25, 14);
		panel_1.add(lblCode);

		txtCode = new JTextField();
		txtCode.setBounds(58, 21, 150, 20);
		panel_1.add(txtCode);
		txtCode.setColumns(10);

		JLabel lblCreation = new JLabel("Cr\u00E9\u00E9 le");
		lblCreation.setBounds(256, 24, 34, 14);
		panel_1.add(lblCreation);

		chkCarteFidelite = new JCheckBox("Carte de fid\u00E9lit\u00E9");
		chkCarteFidelite.setBackground(new Color(175, 238, 238));
		chkCarteFidelite.setBounds(468, 20, 122, 23);
		panel_1.add(chkCarteFidelite);

		txtCreation = new JFormattedTextField();
		txtCreation.setEnabled(false);
		txtCreation.setBounds(300, 21, 162, 20);
		panel_1.add(txtCreation);

		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(175, 238, 238));
		panel_2.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)), "Etat Civil", TitledBorder.LEFT,
				TitledBorder.TOP, null, Color.BLACK));
		panel_2.setBounds(194, 82, 596, 99);
		add(panel_2);
		panel_2.setLayout(null);

		JLabel lblPrenom = new JLabel("Pr\u00E9nom");
		lblPrenom.setBounds(10, 23, 46, 14);
		panel_2.add(lblPrenom);

		txtPrenom = new JTextField();
		txtPrenom.setBounds(81, 20, 199, 20);
		panel_2.add(txtPrenom);
		txtPrenom.setColumns(10);

		JLabel lblNom = new JLabel("Nom");
		lblNom.setBounds(314, 23, 21, 14);
		panel_2.add(lblNom);

		txtNom = new JTextField();
		txtNom.setBounds(345, 20, 241, 20);
		panel_2.add(txtNom);
		txtNom.setColumns(10);

		JLabel lblAdresse = new JLabel("Adresse");
		lblAdresse.setBounds(10, 48, 46, 14);
		panel_2.add(lblAdresse);

		txtAdresse = new JTextField();
		txtAdresse.setBounds(81, 45, 505, 20);
		panel_2.add(txtAdresse);
		txtAdresse.setColumns(10);

		JLabel lblCodePostal = new JLabel("Code Postal");
		lblCodePostal.setBounds(10, 73, 57, 14);
		panel_2.add(lblCodePostal);

		txtCodePostal = new JTextField();
		txtCodePostal.setBounds(81, 70, 199, 20);
		panel_2.add(txtCodePostal);
		txtCodePostal.setColumns(10);

		JLabel lblVille = new JLabel("Ville");
		lblVille.setBounds(314, 73, 21, 14);
		panel_2.add(lblVille);

		txtVille = new JTextField();
		txtVille.setBounds(345, 70, 241, 20);
		panel_2.add(txtVille);
		txtVille.setColumns(10);

		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(175, 238, 238));
		panel_3.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)), "Coordonn\u00E9es", TitledBorder.LEADING,
				TitledBorder.TOP, null, Color.BLACK));
		panel_3.setBounds(194, 192, 596, 78);
		add(panel_3);
		panel_3.setLayout(null);

		JLabel lblFixe = new JLabel("Fixe");
		lblFixe.setBounds(10, 22, 29, 14);
		panel_3.add(lblFixe);

		txtFixe = new JTextField();
		txtFixe.setBounds(37, 19, 244, 20);
		panel_3.add(txtFixe);
		txtFixe.setColumns(10);

		JLabel lblMobile = new JLabel("Mobile");
		lblMobile.setBounds(301, 22, 30, 14);
		panel_3.add(lblMobile);

		txtMobile = new JTextField();
		txtMobile.setBounds(341, 19, 245, 20);
		panel_3.add(txtMobile);
		txtMobile.setColumns(10);

		JLabel lblEmail = new JLabel("Email");
		lblEmail.setBounds(10, 53, 29, 14);
		panel_3.add(lblEmail);

		txtEmail = new JTextField();
		txtEmail.setBounds(37, 47, 549, 20);
		panel_3.add(txtEmail);
		txtEmail.setColumns(10);

		JPanel panel_4 = new JPanel();
		panel_4.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)), "Remarques", TitledBorder.LEADING,
				TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_4.setBackground(new Color(175, 238, 238));
		panel_4.setBounds(194, 281, 596, 253);
		add(panel_4);
		panel_4.setLayout(null);

		txtRemarques = new JTextField();
		txtRemarques.setBounds(10, 22, 576, 220);
		panel_4.add(txtRemarques);
		txtRemarques.setColumns(10);

	}
}
