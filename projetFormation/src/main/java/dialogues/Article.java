package dialogues;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JButton;

public class Article extends JFrame {

	private JPanel contentPane;

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
		setBounds(100, 100, 944, 628);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(153, 204, 0));
		panel.setBounds(0, 0, 162, 607);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblArticles = new JLabel("Articles\r\n");
		lblArticles.setIcon(new ImageIcon("C:\\images\\gestion\\article\\Product-64-actif.png"));
		lblArticles.setBounds(10, 11, 132, 69);
		lblArticles.setFont(new Font("Dialog", Font.BOLD, 16));
		panel.add(lblArticles);
		
		JButton btnNewButton = new JButton("Accueil\r\n");
		btnNewButton.setBackground(new Color(102, 204, 0));
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnNewButton.setIcon(new ImageIcon("C:\\images\\gestion\\Home-48.png"));
		btnNewButton.setBounds(10, 514, 132, 57);
		panel.add(btnNewButton);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(217, 0, 627, 92);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(217, 92, 627, 393);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
	}
}
