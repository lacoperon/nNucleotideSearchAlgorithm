package nNucleotideFreqAnalysis;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.border.EmptyBorder;
import javafx.scene.control.ProgressBar;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class ProgramLoadingGUI extends JFrame {

	private JPanel contentPane;
	private static JProgressBar progressBar;
	private static int ticker = 0;
	public static final int WINDOW_HEIGHT = 100;
	public static final int WINDOW_WIDTH = 400;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		ProgramLoadingGUI loader = new ProgramLoadingGUI(100);
		loader.setVisible(true);
		tickerTimer();
	}
	/**
	 * Create the frame.
	 */
	public ProgramLoadingGUI(int taskLength) {



		setResizable(false);
		setTitle("Genome Parsing...");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0,0,WINDOW_WIDTH, WINDOW_HEIGHT);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(Color.PINK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		progressBar = new JProgressBar(0, taskLength);
		progressBar.setBackground(Color.DARK_GRAY);
		contentPane.add(progressBar, BorderLayout.CENTER);

		JLabel lblProgressBar = new JLabel("Progress Bar");
		lblProgressBar.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblProgressBar, BorderLayout.NORTH);
	}

	public static void setBar(int tickValue) {
		progressBar.setValue(tickValue);
	}

	public static void tickerTimer() {
		class barTickTest extends TimerTask {
			public void run() {
				System.out.println(ticker);
				setBar(ticker);
				if (ticker < 100) { 
					ticker = ticker + 10;
				}
			}
		}

		Timer timer = new Timer();
		timer.schedule(new barTickTest(), 1000, 1000);
	}

}
