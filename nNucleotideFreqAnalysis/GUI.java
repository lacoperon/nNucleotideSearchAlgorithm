package nNucleotideFreqAnalysis;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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

public class GUI extends JFrame implements ActionListener {

	private JPanel contentPane;

	/**
	 * The startup GUI of the nNFoGe algorithm
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
		contentPane.add(settingsPane, BorderLayout.CENTER);
		settingsPane.setLayout(new GridLayout(3,1));
		
		//Adds Program Description to 1st row of settingsPane
		JLabel programDescription = new JLabel("Choose a nucleotide sequence (.txt) to analyse");
		settingsPane.add(programDescription);
		//Creates fileChooser, a JPanel within settingsPane for browsing files for the txt file to analyse. 
		//Adds it to 2nd line of settingsPane
		JPanel fileChooser = new JPanel();
		settingsPane.add(fileChooser);
		fileChooser.setLayout(new GridLayout(1,3));
		JTextField textField = new JTextField("");
		fileChooser.add(new JLabel("Choose FASTA file:"));
		textField.setEditable(false);
		fileChooser.add(textField);
		fileChooser.add(new JButton("Browse"));
		
		//Creates segmentPane, a JPanel within settingsPane for choosing what length you want the segments
		//analysed to have
		JPanel segmentPane = new JPanel();
		settingsPane.add(segmentPane);
		segmentPane.setLayout(new GridLayout(1,3));
		segmentPane.add(new JLabel("Segment length:"));
		JTextField segmentField = new JTextField("");
		segmentPane.add(segmentField);
		segmentPane.add(new JLabel(""));
		JButton analyseButton = new JButton("Search");
		
		//Adds ActionListener for analyseButton
		analyseButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ev) {
				boolean parsable = true;
				String segmentInput = segmentField.getText();
				try {
					int segmentNumber = Integer.parseInt(segmentInput);
					//TODO: Pass segmentNumber into the program
					System.out.println(segmentNumber + "is a number");
				}
				catch(NumberFormatException e) {
					//TODO: Popup for invalid input
					System.out.println(segmentInput + "is invalid");
				}
			}
		});
		contentPane.add(analyseButton, BorderLayout.SOUTH);	
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	public void tryAnalysis() {
	}
}
