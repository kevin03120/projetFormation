package src.main.java.dialogues;

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
import javax.swing.JColorChooser;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;
import javax.swing.border.LineBorder;
import javax.swing.JTextField;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

import src.main.java.controle.ControleArticle;
import src.main.java.controle.ControleClient;
import src.main.java.controle.ControleCommande;
import src.main.java.controle.connexion.GlobalConnection;
import src.main.java.controle.modele.ModeleDynamiqueCommande;
import src.main.java.entite.Article;
import src.main.java.entite.Client;
import src.main.java.entite.Commande;
import src.main.java.entite.CommandeArticle;
import src.main.java.entite.dao.ArticleDaoMysql;
import src.main.java.entite.dao.ClientDaoMysql;
import src.main.java.entite.dao.CommandeDaoMysql;

import javax.swing.JComboBox;
import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class FCommande extends JFrame {

	private JPanel contentPane;
	private JLabel lblTotal;
	private JTextField txtCommande;
	private JTextField txtDate;
	private JTextField txtCode;
	private JTextField txtCategorie;
	private JTextField txtDesignation;
	private JTextField txtMontant;
	private JTable tblCommande;
	private ControleCommande controleCommande;
	private ControleClient controleClient;
	private ControleArticle articleDao;
	private JComboBox comboBoxArticle;
	private double total;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FCommande frame = new FCommande();
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
	public FCommande() {
		total = 0.00;
		List<CommandeArticle> listCommande = new ArrayList<>();
		articleDao = new ControleArticle();
		controleClient = new ControleClient();
		controleCommande = new ControleCommande();
		controleCommande = new ControleCommande();
		setTitle("Gestion des commandes");
		setIconImage(Toolkit.getDefaultToolkit().getImage(FCommande.class.getResource("/target/images/Moon-32.png")));
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
		lblCommande.setIcon(new ImageIcon(FCommande.class.getResource("/target/images/gestion/commande/Shopping-Bag-64-actif.png")));
		lblCommande.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblCommande.setBounds(10, 5, 230, 64);
		panel.add(lblCommande);
		
		JLabel lblCommandeExistante = new JLabel("Commandes existantes");
		lblCommandeExistante.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setVisible(false);
				FCommandeExistante fenetreCommEx = new FCommandeExistante();
				fenetreCommEx.setVisible(true);
			}
		});
		lblCommandeExistante.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblCommandeExistante.setForeground(new Color(255, 255, 255));
		lblCommandeExistante.setIcon(new ImageIcon(FCommande.class.getResource("/target/images/gestion/Receipt-48.png")));
		lblCommandeExistante.setBounds(10, 80, 230, 48);
		panel.add(lblCommandeExistante);
		
		JLabel lblSupprime = new JLabel("Supprimer");
		lblSupprime.setForeground(new Color(255, 255, 255));
		lblSupprime.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblSupprime.setIcon(new ImageIcon(FCommande.class.getResource("/target/images/gestion/Cancel-48.png")));
		lblSupprime.setBounds(10, 139, 230, 41);
		panel.add(lblSupprime);
		
		JLabel lblSupprimeAll = new JLabel("Supprimer toutes les lignes");
		lblSupprimeAll.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				List<CommandeArticle> ca = new ArrayList<>();
				tblCommande.setModel(new ModeleDynamiqueCommande(ca));
				total = 0.00;
				lblTotal.setText(""+total+"€");
				listCommande.clear();
			}
		});
		lblSupprimeAll.setIcon(new ImageIcon(FCommande.class.getResource("/target/images/gestion/Garbage-Open-48.png")));
		lblSupprimeAll.setForeground(Color.WHITE);
		lblSupprimeAll.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblSupprimeAll.setBounds(10, 191, 230, 41);
		panel.add(lblSupprimeAll);
		
		JLabel lblValider = new JLabel("Valider la commande");
		lblValider.setIcon(new ImageIcon(FCommande.class.getResource("/target/images/gestion/commande/Shopping-Cart-05-48.png")));
		lblValider.setForeground(Color.WHITE);
		lblValider.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblValider.setBounds(10, 244, 230, 41);
		panel.add(lblValider);
		
		JLabel lblApercu = new JLabel("Aper\u00E7u");
		lblApercu.setIcon(new ImageIcon(FCommande.class.getResource("/target/images/gestion/Preview-48.png")));
		lblApercu.setForeground(Color.WHITE);
		lblApercu.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblApercu.setBounds(10, 324, 230, 41);
		panel.add(lblApercu);
		
		JLabel lblImprimer = new JLabel("Imprimer");
		lblImprimer.setIcon(new ImageIcon(FCommande.class.getResource("/target/images/gestion/Printer-48.png")));
		lblImprimer.setForeground(Color.WHITE);
		lblImprimer.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblImprimer.setBounds(10, 376, 230, 41);
		panel.add(lblImprimer);
		
		JLabel lblExport = new JLabel("Export");
		lblExport.setIcon(new ImageIcon(FCommande.class.getResource("/target/images/gestion/Data-Export-48.png")));
		lblExport.setForeground(Color.WHITE);
		lblExport.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblExport.setBounds(10, 428, 230, 41);
		panel.add(lblExport);
		
		JLabel lblAccueil = new JLabel("Accueil");
		lblAccueil.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setVisible(false);
				FAccueil fenetreAccueil = new FAccueil();
				fenetreAccueil.setVisible(true);
			}
		});
		lblAccueil.setIcon(new ImageIcon(FCommande.class.getResource("/target/images/gestion/Home-48.png")));
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
		
		JComboBox comboBoxClient = new JComboBox();
		comboBoxClient.setBounds(144, 64, 241, 20);
		for(Client c :controleClient.getMesClients()){
			comboBoxClient.addItem(c);
		}
		panel_1.add(comboBoxClient);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new TitledBorder(new LineBorder(new Color(255, 140, 0)), "Valeurs de la commande", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_2.setBackground(new Color(255, 235, 205));
		panel_2.setBounds(260, 129, 582, 315);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
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
		
		JLabel lblMontant = new JLabel("Prix");
		lblMontant.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblMontant.setBounds(284, 77, 31, 14);
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
		lblAjouter.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				CommandeArticle ca = new CommandeArticle();
				Article a = articleDao.listerArticles().get(comboBoxArticle.getSelectedIndex());
				ca.setCodeArticle(a.getCode());
				ca.setCodeCategorie(a.getCategorie());
				ca.setDesignation(a.getDesignation());
				ca.setPrix(a.getPrixUnitaire());
				ca.setQuantite((int)spnQuantite.getValue());
				ca.setTotal();
				listCommande.add(ca);
				tblCommande.setModel(new ModeleDynamiqueCommande(listCommande));
				total = 0.00;
				for (CommandeArticle commandeArticle : listCommande) {
					total += commandeArticle.getTotal();
				}
				lblTotal.setText(""+((int)(total*100))/100. + "€");
			}
		});
		lblAjouter.setIcon(new ImageIcon(FCommande.class.getResource("/target/images/gestion/Add-New-48.png")));
		lblAjouter.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblAjouter.setBounds(96, 106, 115, 54);
		panel_2.add(lblAjouter);
		
		JLabel lblModifier = new JLabel("Modifier");
		lblModifier.setIcon(new ImageIcon(FCommande.class.getResource("/target/images/gestion/Data-Edit-48.png")));
		lblModifier.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblModifier.setBounds(221, 106, 115, 54);
		panel_2.add(lblModifier);
		
		JLabel lblSupprimer = new JLabel("Supprimer");
		lblSupprimer.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(listCommande.size()!=0){
					total -= ((int)(listCommande.get(listCommande.size()-1).getTotal()*100))/100.;
					lblTotal.setText(total + "€");
					listCommande.remove(listCommande.size()-1);
					tblCommande.setModel(new ModeleDynamiqueCommande(listCommande));
				}
			}
		});
		lblSupprimer.setIcon(new ImageIcon(FCommande.class.getResource("/target/images/gestion/Cancel-48.png")));
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
		
		comboBoxArticle = new JComboBox();
		comboBoxArticle.setBounds(10, 35, 239, 20);
		for(Article a :articleDao.listerArticles()){
			comboBoxArticle.addItem(a);
		}
		panel_2.add(comboBoxArticle);
		comboBoxArticle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				JComboBox comboBox = (JComboBox) event.getSource();
				Article a = articleDao.listerArticles().get(comboBox.getSelectedIndex());
				txtCode.setText(""+a.getCode());
				txtCategorie.setText(a.getCategorie());
				txtDesignation.setText(a.getDesignation());
				txtMontant.setText(""+ a.getPrixUnitaire());
			}
		});
		
		JLabel lblModeDeReglement = new JLabel("Mode de r\u00E9glement");
		lblModeDeReglement.setIcon(new ImageIcon(FCommande.class.getResource("/target/images/gestion/commande/ATM-32.png")));
		lblModeDeReglement.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblModeDeReglement.setBounds(365, 478, 166, 24);
		contentPane.add(lblModeDeReglement);
		
		JComboBox cbReglement = new JComboBox();
		cbReglement.setFont(new Font("Tahoma", Font.BOLD, 12));
		cbReglement.setModel(new DefaultComboBoxModel(new String[] {"Carte Bleue", "Cheque", "Especes"}));
		cbReglement.setBounds(541, 481, 100, 20);
		contentPane.add(cbReglement);
		
		lblTotal = new JLabel("0.00 \u20AC");
		lblTotal.setHorizontalAlignment(SwingConstants.CENTER);
		Border border = BorderFactory.createLineBorder(Color.ORANGE, 2);
		lblTotal.setBorder(border);
		lblTotal.setBackground(new Color(255, 140, 0));
		lblTotal.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblTotal.setBounds(747, 473, 75, 35);
		lblTotal.setOpaque(true);
		contentPane.add(lblTotal);
		
		JLabel lblValide = new JLabel("Valider la commande");
		lblValide.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Client c = controleClient.getMesClients().get(comboBoxClient.getSelectedIndex());
				Commande commande = new Commande();
				commande.setDate(LocalDate.now());
				commande.setClient(c);
				commande.setNom_client(c.getNom());
				commande.setMode_paiement(cbReglement.getSelectedItem().toString());
				controleCommande.addCommande(commande);
				for(CommandeArticle ca : listCommande){
					controleCommande.addLigneCommande(ca.getCodeArticle(), ca.getQuantite());
				}
				FCommandeExistante coe = new FCommandeExistante();
				coe.setVisible(true);
				setVisible(false);
			}
		});
		lblValide.setIcon(new ImageIcon(FCommande.class.getResource("/target/images/gestion/commande/Shopping-Cart-05-48.png")));
		lblValide.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblValide.setBounds(637, 536, 185, 35);
		contentPane.add(lblValide);
	}
}
