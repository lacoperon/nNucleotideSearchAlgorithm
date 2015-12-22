package nNucleotideFreqAnalysis;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JScrollBar;
import javax.swing.JFileChooser;
import javax.swing.JButton;

public class GUI extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI frame = new GUI();
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
	public GUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 150);
		setTitle("nNFoGe Analysis Browser");
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout());
		setContentPane(contentPane);
		
		//Creates lblHello, the welcome text for the GUI
		JLabel lblProgramName = new JLabel("nNucleotide Foreign Gene Search Algorithm");
		Font largeFont = new Font("Times New Roman", Font.BOLD,18);
		lblProgramName.setFont(largeFont);
		//Centers lblHello
		lblProgramName.setHorizontalAlignment(JLabel.CENTER);
		//Adds lblHello to contentPane
		contentPane.add(lblProgramName, BorderLayout.NORTH);
		
		//Creates settingsPane, the JPanel with all of the settings for the nNFoGe Algorithm to use
		JPanel settingsPane = new JPanel();
		settingsPane.setLayout(new GridLayout(3,1));
		JLabel programDescription = new JLabel("Choose a nucleotide sequence (.txt) to analyse");
		settingsPane.add(programDescription);
		contentPane.add(settingsPane, BorderLayout.CENTER);
		//Creates fileChooser, the JPanel for browsing files for the txt file to analyse
		JPanel fileChooser = new JPanel();
		settingsPane.add(fileChooser);
		fileChooser.setLayout(new GridLayout(1,3));
		textField = new JTextField("");
		fileChooser.add(new JLabel("Choose FASTA file:"));
		textField.setColumns(4);
		textField.setEditable(false);
		
		fileChooser.add(textField);
		fileChooser.add(new JButton("Browse"));
		JButton analyseButton = new JButton("Search");
		contentPane.add(analyseButton, BorderLayout.SOUTH);	
		
		
	}

}
