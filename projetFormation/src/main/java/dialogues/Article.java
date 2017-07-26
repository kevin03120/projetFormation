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
import java.awt.event.ActionEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;
import javax.swing.table.DefaultTableModel;

public class Article extends JFrame {

	private JPanel contentPane;
	private JTextField txtCode;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField txtQuantite;
	private JTable tableArticles;
	private JTextField txtRecherche;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Article frame = new Article();
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
	public Article() {
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
				Accueil fenetreAccueil = new Accueil();
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
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(130, 39, 626, 20);
		panel.add(textField);
		
		textField_1 = new JTextField();
		textField_1.setBounds(590, 11, 166, 20);
		panel.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(590, 67, 166, 20);
		panel.add(textField_2);
		textField_2.setColumns(10);
		
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
		
		JButton btnAjouter = new JButton("Ajouter");
		btnAjouter.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnAjouter.setIcon(new ImageIcon("C:\\images\\gestion\\Add-New-48.png"));
		btnAjouter.setBounds(10, 102, 150, 50);
		panel.add(btnAjouter);
		UI.deshabillerBouton(btnAjouter);
		
		JButton btnModifier = new JButton("Modifier");
		btnModifier.setEnabled(false);
		btnModifier.setIcon(new ImageIcon("C:\\images\\gestion\\Data-Edit-48.png"));
		btnModifier.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnModifier.setBounds(199, 101, 150, 50);
		panel.add(btnModifier);
		UI.deshabillerBouton(btnModifier);
		
		JButton btnSupprimer = new JButton("Supprimer");
		btnSupprimer.setEnabled(false);
		btnSupprimer.setIcon(new ImageIcon("C:\\images\\gestion\\Garbage-Open-48.png"));
		btnSupprimer.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnSupprimer.setBounds(410, 102, 150, 50);
		panel.add(btnSupprimer);
		UI.deshabillerBouton(btnSupprimer);
		
		JButton btnEffacer = new JButton("Effacer");
		btnEffacer.setIcon(new ImageIcon("C:\\images\\gestion\\Cancel-48.png"));
		btnEffacer.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnEffacer.setBounds(606, 102, 150, 50);
		panel.add(btnEffacer);
		UI.deshabillerBouton(btnEffacer);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 161, 790, 400);
		mainPanel.add(scrollPane);
		
		tableArticles = new JTable();
		tableArticles.setFillsViewportHeight(true);
		tableArticles.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Code"
			}
		));
		scrollPane.setColumnHeaderView(tableArticles);
		
		JLabel lblTrierPar = new JLabel("Trier par");
		lblTrierPar.setIcon(new ImageIcon("C:\\images\\gestion\\Sort-Ascending-32.png"));
		lblTrierPar.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblTrierPar.setBounds(10, 570, 100, 19);
		mainPanel.add(lblTrierPar);
		
		JRadioButton rdbtnCode = new JRadioButton("Code");
		rdbtnCode.setBackground(new Color(255, 255, 153));
		rdbtnCode.setFont(new Font("Tahoma", Font.BOLD, 12));
		rdbtnCode.setBounds(129, 568, 109, 23);
		mainPanel.add(rdbtnCode);
		
		JRadioButton rdbtnCategorie = new JRadioButton("Cat\u00E9gorie");
		rdbtnCategorie.setBackground(new Color(255, 255, 153));
		rdbtnCategorie.setFont(new Font("Tahoma", Font.BOLD, 12));
		rdbtnCategorie.setBounds(240, 568, 109, 23);
		mainPanel.add(rdbtnCategorie);
		
		ButtonGroup buttonGroup = new ButtonGroup();
		buttonGroup.add(rdbtnCode);
		buttonGroup.add(rdbtnCategorie);
		
		JLabel lblRecherche = new JLabel("Recherche");
		lblRecherche.setIcon(new ImageIcon("C:\\images\\gestion\\Preview-48.png"));
		lblRecherche.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblRecherche.setBounds(385, 567, 121, 25);
		mainPanel.add(lblRecherche);
		
		txtRecherche = new JTextField();
		txtRecherche.setBounds(534, 570, 227, 20);
		mainPanel.add(txtRecherche);
		txtRecherche.setColumns(10);
		
		
	}
}
