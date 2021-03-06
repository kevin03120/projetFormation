package src.main.java.dialogues;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.border.LineBorder;

import src.main.java.controle.connexion.GlobalConnection;
import src.main.java.entite.User;
import src.main.java.entite.dao.UserDaoMysql;

import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

import java.awt.SystemColor;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.Toolkit;
import java.util.List;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JPasswordField;

public class FConnexion extends JFrame {

	private JPanel contentPane;
	private JTextField txtNomUtilisateur;
	private List<User> users;
	private JPasswordField txtMotDePasse;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FConnexion frame = new FConnexion();
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
	public FConnexion() {
		String db = "jdbc:mysql://localhost:3306/luna";
		UserDaoMysql userDao = new UserDaoMysql(GlobalConnection.getInstance());
		users = userDao.getAllUser();
		
		
		setTitle("SARL LUNA");
		setIconImage(Toolkit.getDefaultToolkit().getImage(FConnexion.class.getResource("/target/images/Moon-32.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 327);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblConnexion = new JLabel("Connexion au programme");
		lblConnexion.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblConnexion.setBounds(152, 24, 189, 19);
		contentPane.add(lblConnexion);
		
		JLabel lblIconConnexion = new JLabel("New label");
		lblIconConnexion.setIcon(new ImageIcon(FConnexion.class.getResource("/target/images/connection/Shopping-Cart-05-48.png")));
		lblIconConnexion.setBounds(96, 11, 46, 48);
		contentPane.add(lblIconConnexion);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(51, 153, 255), 3));
		panel.setBackground(Color.WHITE);
		panel.setBounds(10, 78, 414, 152);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNomUtilisateur = new JLabel("Nom d'utilisateur");
		lblNomUtilisateur.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNomUtilisateur.setBounds(13, 11, 109, 21);
		panel.add(lblNomUtilisateur);
		
		JLabel lblIconNomUtilisateur = new JLabel("");
		lblIconNomUtilisateur.setIcon(new ImageIcon(FConnexion.class.getResource("/target/images/connection/Windows-8-Login-16.png")));
		lblIconNomUtilisateur.setBounds(126, 11, 16, 21);
		panel.add(lblIconNomUtilisateur);
		
		txtNomUtilisateur = new JTextField();
		txtNomUtilisateur.setBounds(152, 12, 252, 20);
		panel.add(txtNomUtilisateur);
		txtNomUtilisateur.setColumns(10);
		
		JLabel lblMotDePasse = new JLabel("Mot de passe");
		lblMotDePasse.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblMotDePasse.setBounds(35, 42, 87, 14);
		panel.add(lblMotDePasse);
		
		JLabel lblIconMotDePasse = new JLabel("");
		lblIconMotDePasse.setIcon(new ImageIcon(FConnexion.class.getResource("/target/images/connection/Key-16.png")));
		lblIconMotDePasse.setBounds(126, 43, 16, 14);
		panel.add(lblIconMotDePasse);
		
		JLabel lblConseilPart1 = new JLabel("Veuillez saisir");
		lblConseilPart1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblConseilPart1.setForeground(SystemColor.controlShadow);
		lblConseilPart1.setBounds(13, 87, 87, 20);
		panel.add(lblConseilPart1);
		
		JLabel lblConseilPart2 = new JLabel("le nom de l'utilisateur et le mot de passe");
		lblConseilPart2.setForeground(SystemColor.controlShadow);
		lblConseilPart2.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblConseilPart2.setBounds(13, 109, 276, 14);
		panel.add(lblConseilPart2);
		
		JLabel lblConseilPart3 = new JLabel("pour acc\u00E9der \u00E0 l'application.");
		lblConseilPart3.setForeground(SystemColor.controlShadow);
		lblConseilPart3.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblConseilPart3.setBounds(13, 127, 258, 14);
		panel.add(lblConseilPart3);
		
		txtMotDePasse = new JPasswordField();
		txtMotDePasse.setBounds(152, 40, 252, 20);
		panel.add(txtMotDePasse);
		
		JLabel lblParametres = new JLabel("Param\u00E8tres");
		lblParametres.setIcon(new ImageIcon(FConnexion.class.getResource("/target/images/connection/Customize-01-48.png")));
		lblParametres.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblParametres.setBounds(10, 247, 121, 25);
		contentPane.add(lblParametres);
		
		JLabel lblQuitter = new JLabel("Quitter");
		lblQuitter.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}
		});
		lblQuitter.setIcon(new ImageIcon(FConnexion.class.getResource("/target/images/connection/Stop-48.png")));
		lblQuitter.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblQuitter.setBounds(180, 246, 104, 27);
		contentPane.add(lblQuitter);
		
		JLabel lblValider = new JLabel("Valider");
		lblValider.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(testConnexion()){
					setVisible(false);
					FAccueil accueil = new FAccueil();
					accueil.setVisible(true);
				}
				else{
					FErreur erreur = new FErreur();
					erreur.setVisible(true);
				}
			}
		});
		lblValider.setForeground(SystemColor.text);
		lblValider.setBackground(SystemColor.textHighlight);
		lblValider.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblValider.setIcon(new ImageIcon(FConnexion.class.getResource("/target/images/connection/Power-48.png")));
		lblValider.setOpaque(true);
		lblValider.setBounds(326, 247, 98, 26);
		contentPane.add(lblValider);
		
		
	}
	public boolean testConnexion(){
		for (User user : users) {
			if(txtNomUtilisateur.getText().equals(user.getNom())&&txtMotDePasse.getText().equals(user.getMdp())){
				return true;
			}
		}
		return false;
	}
}
