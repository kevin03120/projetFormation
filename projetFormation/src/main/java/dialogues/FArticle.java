package src.main.java.dialogues;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JSlider;
import javax.swing.JToolBar;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JRadioButton;
import java.awt.event.ActionListener;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.function.ToDoubleFunction;
import java.awt.event.ActionEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import src.main.java.controle.ControleArticle;
import src.main.java.controle.connexion.GlobalConnection;
import src.main.java.controle.modele.ModeleDynamiqueArticle;
import src.main.java.controle.modele.ModeleDynamiqueClient;
import src.main.java.entite.Article;
import src.main.java.entite.dao.ArticleDaoMysql;
import src.main.java.entite.dao.ClientDaoMysql;
import src.main.java.entite.dao.UserDaoMysql;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JComboBox;
import java.awt.event.InputMethodListener;
import java.awt.event.InputMethodEvent;

public class FArticle extends JFrame {

	private JPanel contentPane;
	private JTextField txtCode;
	private JTextField txtDesignation;
	private JTextField txtPrixUnitaire;
	private JTextField txtQuantite;
	private JTable tableArticles;
	private JTextField txtRecherche;
	private List<Article> lesArticles;
	private List<String> lesCategories;
	boolean tri = false;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FArticle frame = new FArticle(null);
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
	public FArticle(List<Article> listArticles) {
		ArticleDaoMysql articleDao = new ArticleDaoMysql(GlobalConnection.getInstance());
		if (listArticles == null ) {	
			lesArticles = articleDao.getAllArticles(tri);
		} else {
			lesArticles = listArticles;
		}
		
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 968, 640);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel menuPanel = new JPanel();
		menuPanel.setBackground(new Color(51, 204, 0));
		menuPanel.setBounds(0, 0, 162, 602);
		contentPane.add(menuPanel);
		menuPanel.setLayout(null);
		
		JLabel lblArticles = new JLabel("Articles\r\n");
		lblArticles.setBounds(10, 11, 132, 69);
		lblArticles.setIcon(new ImageIcon("C:\\images\\gestion\\article\\Product-64-actif.png"));
		lblArticles.setFont(new Font("Dialog", Font.BOLD, 16));
		menuPanel.add(lblArticles);
		
		JButton btnAccueil = new JButton("Accueil\r\n");
		btnAccueil.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				FAccueil fenetreAccueil = new FAccueil();
				fenetreAccueil.setVisible(true);		
			}
		});
		btnAccueil.setBounds(10, 536, 140, 55);
		btnAccueil.setBackground(new Color(51, 204, 0));
		btnAccueil.setForeground(new Color(255, 255, 255));
		btnAccueil.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnAccueil.setIcon(new ImageIcon("C:\\images\\gestion\\Home-48.png"));
		menuPanel.add(btnAccueil);
		UI.deshabillerBouton(btnAccueil);
		
		JButton btnApercu = new JButton("Aper\u00E7u");
		btnApercu.setForeground(new Color(255, 255, 255));
		btnApercu.setBackground(new Color(51, 204, 0));
		btnApercu.setIcon(new ImageIcon("C:\\images\\gestion\\Preview-48.png"));
		btnApercu.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnApercu.setBounds(10, 218, 140, 30);
		menuPanel.add(btnApercu);
		UI.deshabillerBouton(btnApercu);
		
		JButton btnImprimer = new JButton("Imprimer");
		btnImprimer.setForeground(new Color(255, 255, 255));
		btnImprimer.setBackground(new Color(51, 204, 0));
		btnImprimer.setIcon(new ImageIcon("C:\\images\\gestion\\Printer-48.png"));
		btnImprimer.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnImprimer.setBounds(10, 265, 140, 30);
		menuPanel.add(btnImprimer);
		UI.deshabillerBouton(btnImprimer);
		
		JButton btnExporter = new JButton("Export");
		btnExporter.setForeground(new Color(255, 255, 255));
		btnExporter.setBackground(new Color(51, 204, 0));
		btnExporter.setIcon(new ImageIcon("C:\\images\\gestion\\Data-Export-48.png"));
		btnExporter.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnExporter.setBounds(10, 311, 140, 30);
		menuPanel.add(btnExporter);
		UI.deshabillerBouton(btnExporter);
		
		JPanel mainPanel = new JPanel();
		mainPanel.setBackground(new Color(255, 255, 153));
		mainPanel.setBounds(164, 0, 788, 602);
		contentPane.add(mainPanel);
		mainPanel.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 790, 163);
		mainPanel.add(panel);
		panel.setLayout(null);
		
		JLabel lblCode = new JLabel("Code");
		lblCode.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCode.setBounds(10, 11, 110, 17);
		lblCode.setFont(new Font("Tahoma", Font.BOLD, 14));
		panel.add(lblCode);
		
		JLabel lblDesignation = new JLabel("D\u00E9signation");
		lblDesignation.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDesignation.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblDesignation.setBounds(10, 39, 110, 17);
		panel.add(lblDesignation);
		
		JLabel lblQuantite = new JLabel("Quantit\u00E9");
		lblQuantite.setHorizontalAlignment(SwingConstants.RIGHT);
		lblQuantite.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblQuantite.setBounds(10, 67, 110, 17);
		panel.add(lblQuantite);
		
		JLabel lblCategorie = new JLabel("Cat\u00E9gorie");
		lblCategorie.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCategorie.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblCategorie.setBounds(470, 11, 110, 17);
		panel.add(lblCategorie);
		
		JLabel lblPrixUnitaire = new JLabel("Prix Unitaire");
		lblPrixUnitaire.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPrixUnitaire.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblPrixUnitaire.setBounds(470, 67, 110, 17);
		panel.add(lblPrixUnitaire);
		
		txtCode = new JTextField();
		txtCode.setBounds(130, 11, 330, 20);
		panel.add(txtCode);
		txtCode.setColumns(10);
		
		txtDesignation = new JTextField();
		txtDesignation.setColumns(10);
		txtDesignation.setBounds(130, 39, 626, 20);
		panel.add(txtDesignation);
		
		txtPrixUnitaire = new JTextField();
		txtPrixUnitaire.setBounds(590, 67, 166, 20);
		panel.add(txtPrixUnitaire);
		txtPrixUnitaire.setColumns(10);
		
		JSlider sliderQuantite = new JSlider();
		sliderQuantite.setPaintTicks(true);
		sliderQuantite.setValue(0);
		sliderQuantite.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				String valeur = Integer.toString(sliderQuantite.getValue());
				txtQuantite.setText(valeur);
			}
		});
		sliderQuantite.setBounds(130, 67, 260, 31);
		panel.add(sliderQuantite);
		
		
		txtQuantite = new JTextField();
		txtQuantite.setText("0");
		txtQuantite.setBounds(400, 67, 60, 20);
		panel.add(txtQuantite);
		txtQuantite.setColumns(10);
		JComboBox cBoxCategorie = new JComboBox();
		cBoxCategorie.setBounds(590, 11, 166, 20);
		panel.add(cBoxCategorie);
		
		ArticleDaoMysql categoriesDao = new ArticleDaoMysql(GlobalConnection.getInstance());
		lesCategories = articleDao.lireCategories();
		for(String categories : lesCategories) {
			cBoxCategorie.addItem(categories);
		}
		JButton btnAjouter = new JButton("Ajouter");
		btnAjouter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ControleArticle objArticle = new ControleArticle();
				objArticle.ajouterArticle(tableArticles, txtCode, cBoxCategorie, txtDesignation, txtQuantite, txtPrixUnitaire, lesArticles);
			}
		});
		btnAjouter.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnAjouter.setIcon(new ImageIcon("C:\\images\\gestion\\Add-New-48.png"));
		btnAjouter.setBounds(10, 102, 150, 50);
		panel.add(btnAjouter);
		UI.deshabillerBouton(btnAjouter);
		
		JButton btnModifier = new JButton("Modifier");
		btnModifier.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ControleArticle objArticle = new ControleArticle();
				objArticle.modifierArticle(tableArticles, txtCode, cBoxCategorie, txtDesignation, txtQuantite, txtPrixUnitaire, lesArticles);
			}
		});
		btnModifier.setEnabled(false);
		btnModifier.setIcon(new ImageIcon("C:\\images\\gestion\\Data-Edit-48.png"));
		btnModifier.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnModifier.setBounds(199, 101, 150, 50);
		panel.add(btnModifier);
		UI.deshabillerBouton(btnModifier);
		
		JButton btnSupprimer = new JButton("Supprimer");
		btnSupprimer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ControleArticle objArticle = new ControleArticle();
				objArticle.supprimer(tableArticles, lesArticles);
			}
		});
		btnSupprimer.setEnabled(false);
		btnSupprimer.setIcon(new ImageIcon("C:\\images\\gestion\\Garbage-Open-48.png"));
		btnSupprimer.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnSupprimer.setBounds(410, 102, 150, 50);
		panel.add(btnSupprimer);
		UI.deshabillerBouton(btnSupprimer);
		
		JButton btnEffacer = new JButton("Effacer");
		btnEffacer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtCode.setText("");
				txtDesignation.setText("");
				txtPrixUnitaire.setText("");
				txtQuantite.setText("");
			}
		});
		btnEffacer.setIcon(new ImageIcon("C:\\images\\gestion\\Cancel-48.png"));
		btnEffacer.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnEffacer.setBounds(606, 102, 150, 50);
		panel.add(btnEffacer);
		UI.deshabillerBouton(btnEffacer);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 161, 790, 400);
		mainPanel.add(scrollPane);
		
		tableArticles = new JTable();
		tableArticles.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ControleArticle objArticle = new ControleArticle();
				objArticle.majTextBox(tableArticles, txtCode, cBoxCategorie, txtDesignation, sliderQuantite, txtQuantite, txtPrixUnitaire, lesArticles);
				btnModifier.setEnabled(true);
				btnSupprimer.setEnabled(true);
			}
		});
		tableArticles.setBackground(Color.WHITE);
		tableArticles.setForeground(Color.BLACK);
		tableArticles.setFillsViewportHeight(true);
		tableArticles.getTableHeader().setFont(new Font("Tahoma", Font.BOLD, 13));
		tableArticles.getTableHeader().setBackground(Color.LIGHT_GRAY);
		tableArticles.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Code", "Code cat\u00E9gorie", "D\u00E9signation", "Quantit\u00E9", "Prix unitaire"
			}
		));
		tableArticles.setModel(new ModeleDynamiqueArticle(lesArticles));
		
		scrollPane.setColumnHeaderView(tableArticles);
		scrollPane.setViewportView(tableArticles);
		
		JLabel lblTrierPar = new JLabel("Trier par");
		lblTrierPar.setBounds(10, 570, 100, 19);
		lblTrierPar.setIcon(new ImageIcon("C:\\images\\gestion\\Sort-Ascending-32.png"));
		lblTrierPar.setFont(new Font("Tahoma", Font.BOLD, 13));
		mainPanel.add(lblTrierPar);
		
		JRadioButton rdbtnCode = new JRadioButton("Code");
		rdbtnCode.isSelected();
		rdbtnCode.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ControleArticle objArticle = new ControleArticle();
				objArticle.trier(lesArticles, false, tableArticles);
			}
		});
		rdbtnCode.setBounds(129, 568, 109, 23);
		rdbtnCode.setBackground(new Color(255, 255, 153));
		rdbtnCode.setFont(new Font("Tahoma", Font.BOLD, 12));
		mainPanel.add(rdbtnCode);
		
		JRadioButton rdbtnCategorie = new JRadioButton("Cat\u00E9gorie");
		rdbtnCategorie.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {	
				ControleArticle objArticle = new ControleArticle();
				objArticle.trier(lesArticles, true, tableArticles);
			}
		});
		rdbtnCategorie.setBounds(240, 568, 109, 23);
		rdbtnCategorie.setBackground(new Color(255, 255, 153));
		rdbtnCategorie.setFont(new Font("Tahoma", Font.BOLD, 12));
		mainPanel.add(rdbtnCategorie);
		
		ButtonGroup buttonGroup = new ButtonGroup();
		buttonGroup.add(rdbtnCode);
		buttonGroup.add(rdbtnCategorie);
		
		JLabel lblRecherche = new JLabel("Recherche");
		lblRecherche.setBounds(385, 567, 121, 25);
		lblRecherche.setIcon(new ImageIcon("C:\\images\\gestion\\Preview-48.png"));
		lblRecherche.setFont(new Font("Tahoma", Font.BOLD, 13));
		mainPanel.add(lblRecherche);
		
		txtRecherche = new JTextField();
		txtRecherche.setBounds(534, 570, 227, 20);
		mainPanel.add(txtRecherche);
		txtRecherche.setColumns(10);
	
		
		
	}
}
