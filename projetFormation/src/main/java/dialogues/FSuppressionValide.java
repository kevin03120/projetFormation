package src.main.java.dialogues;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class FSuppressionValide extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FSuppressionValide frame = new FSuppressionValide();
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
	public FSuppressionValide() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 561, 233);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblVoulezVousVraiment = new JLabel("Voulez vous vraiment supprimer ce client ?");
		lblVoulezVousVraiment.setHorizontalAlignment(SwingConstants.CENTER);
		lblVoulezVousVraiment.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblVoulezVousVraiment.setBounds(10, 34, 525, 43);
		contentPane.add(lblVoulezVousVraiment);
		
		JButton btnOui = new JButton("Oui");
		btnOui.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setVisible(false);
			}
		});
		btnOui.setBounds(72, 109, 107, 45);
		contentPane.add(btnOui);
		
		JButton btnNon = new JButton("Non");
		btnNon.setBounds(340, 109, 117, 45);
		contentPane.add(btnNon);
	}
}
