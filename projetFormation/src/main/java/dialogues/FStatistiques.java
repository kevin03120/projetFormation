package src.main.java.dialogues;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.HashMap;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PiePlot3D;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;
import org.jfree.util.Rotation;

import src.main.java.controle.ControleCommande;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class FStatistiques extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FStatistiques frame = new FStatistiques("Statistiques", "Statistiques");
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	private static final long serialVersionUID = 1L;

    public FStatistiques(String applicationTitle, String chartTitle) {
        super(applicationTitle);
		setBounds(100, 100, 702, 525);
        
        // This will create the dataset
        PieDataset dataset = createDataset();
        // based on the dataset we create the chart
        JFreeChart chart = createChart(dataset, chartTitle);
        // we put the chart into a panel
        ChartPanel chartPanel = new ChartPanel(chart);
        // default size
        chartPanel.setPreferredSize(new java.awt.Dimension(500, 270));
        // add it to our application
        setContentPane(chartPanel);
        chartPanel.setLayout(null);
        
        JButton btnNewButton = new JButton("Retour");
        btnNewButton.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent e) {
        		setVisible(false);
				FAccueil fenetreAccueil = new FAccueil();
				fenetreAccueil.setVisible(true);        	}
        });
        btnNewButton.setBounds(10, 0, 89, 23);
        chartPanel.add(btnNewButton);

    }

    /**
     * Creates a sample dataset
     */
    private  PieDataset createDataset() {
    	ControleCommande cc = new ControleCommande();
    	int total = cc.getTotal();
    	HashMap<String, Integer> mesStats = cc.statCommandes();
        DefaultPieDataset result = new DefaultPieDataset();
    	for (String designation : mesStats.keySet()) {
    		 result.setValue(designation, mesStats.get(designation));
		}
        return result;

    }
    
    /**
     * Creates a chart
     */
    private JFreeChart createChart(PieDataset dataset, String title) {

        JFreeChart chart = ChartFactory.createPieChart3D(
            title,                  // chart title
            dataset,                // data
            true,                   // include legend
            true,
            false
        );

        PiePlot3D plot = (PiePlot3D) chart.getPlot();
        plot.setStartAngle(290);
        plot.setDirection(Rotation.CLOCKWISE);
        plot.setForegroundAlpha(0.5f);
        return chart;

    }
}
