package src.main.java.dialogues;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import src.main.java.controle.ControleCommande;
import src.main.java.controle.connexion.GlobalConnection;
import src.main.java.controle.modele.ModeleDynamiqueClient;
import src.main.java.controle.modele.ModeleDynamiqueCommande;
import src.main.java.entite.dao.ClientDaoMysql;
import src.main.java.entite.dao.CommandeDaoMysql;

import javax.swing.JTextField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Toolkit;

public class FCommandeExistante extends JFrame {

	private JPanel contentPane;
	private JTable tblCommande;
	private JTextField txtRecherche;
	private ControleCommande controleCommande;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FCommandeExistante frame = new FCommandeExistante();
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
	public FCommandeExistante() {
		controleCommande = new ControleCommande();
		setIconImage(Toolkit.getDefaultToolkit().getImage(FCommandeExistante.class.getResource("/target/images/Moon-32.png")));
		setTitle("Gestion des commandes existantes");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 857, 575);
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
		
		JLabel lblCommande = new JLabel("Commandes");
		lblCommande.setIcon(new ImageIcon(FCommandeExistante.class.getResource("/target/images/gestion/commande/Shopping-Bag-64-actif.png")));
		lblCommande.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblCommande.setBounds(10, 11, 233, 64);
		panel.add(lblCommande);
		
		JLabel lblSupprimer = new JLabel("Supprimer");
		lblSupprimer.setForeground(new Color(255, 255, 255));
		lblSupprimer.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblSupprimer.setIcon(new ImageIcon(FCommandeExistante.class.getResource("/target/images/gestion/Garbage-Open-48.png")));
		lblSupprimer.setBounds(10, 100, 233, 48);
		panel.add(lblSupprimer);
		
		JLabel lblApercu = new JLabel("Aper\u00E7u");
		lblApercu.setIcon(new ImageIcon(FCommandeExistante.class.getResource("/target/images/gestion/Preview-48.png")));
		lblApercu.setForeground(Color.WHITE);
		lblApercu.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblApercu.setBounds(10, 241, 233, 48);
		panel.add(lblApercu);
		
		JLabel lblImprimer = new JLabel("Imprimer");
		lblImprimer.setIcon(new ImageIcon(FCommandeExistante.class.getResource("/target/images/gestion/Printer-48.png")));
		lblImprimer.setForeground(Color.WHITE);
		lblImprimer.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblImprimer.setBounds(10, 300, 233, 48);
		panel.add(lblImprimer);
		
		JLabel lblExport = new JLabel("Export");
		lblExport.setIcon(new ImageIcon(FCommandeExistante.class.getResource("/target/images/gestion/Data-Export-48.png")));
		lblExport.setForeground(Color.WHITE);
		lblExport.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblExport.setBounds(10, 359, 233, 48);
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
		lblAccueil.setIcon(new ImageIcon(FCommandeExistante.class.getResource("/target/images/gestion/Home-48.png")));
		lblAccueil.setForeground(Color.WHITE);
		lblAccueil.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblAccueil.setBounds(10, 483, 233, 48);
		panel.add(lblAccueil);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(260, 11, 571, 460);
		contentPane.add(scrollPane);
		
		tblCommande = new JTable();
		tblCommande.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Code", "Client", "Mode de paiement", "Total TTC", "Date"
			}
		));
		scrollPane.setViewportView(tblCommande);
		tblCommande.setModel(controleCommande.getModeleCommande());
		
		JLabel lblTotalCommande = new JLabel("Total des commandes");
		lblTotalCommande.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblTotalCommande.setBounds(291, 496, 137, 14);
		contentPane.add(lblTotalCommande);
		
		JLabel lblPrix = new JLabel("Prix " + controleCommande.getTotalPrixTTC() + "€");
		lblPrix.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblPrix.setBounds(452, 497, 94, 14);
		contentPane.add(lblPrix);
		
		JLabel lblRecherche = new JLabel("Recherche");
		lblRecherche.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblRecherche.setIcon(new ImageIcon(FCommandeExistante.class.getResource("/target/images/gestion/Search-32.png")));
		lblRecherche.setBounds(564, 482, 105, 44);
		contentPane.add(lblRecherche);
		
		txtRecherche = new JTextField();
		txtRecherche.setBounds(679, 482, 152, 44);
		contentPane.add(txtRecherche);
		txtRecherche.setColumns(10);
	}

}
