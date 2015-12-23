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
import java.io.File;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JScrollBar;
import javax.swing.JFileChooser;
import javax.swing.JButton;

public class MainGUI extends JFrame implements ActionListener {

	private JPanel contentPane;
	private static JTextField textField;
	private static MainGUI frame;
	private static File file;
	private static int segmentNumber;

	/**
	 * The startup GUI of the nNFoGe algorithm
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new MainGUI();
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
	public MainGUI() {
		//TextInput hi = new TextInput();
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
		textField = new JTextField("");
		fileChooser.add(new JLabel("Choose txt file:"));
		textField.setEditable(false);
		fileChooser.add(textField);
		//Adds Browse Button
		JButton browseButton = new JButton("Browse");
		fileChooser.add(browseButton);
		//Adds ActionListener for Browse Button
		browseButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ev) {
				new FileChooserGUI();
			}
		});
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
		//Adds ActionListener for the interface, around the analyseButton
		analyseButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ev) {
				String segmentInput = segmentField.getText();
				try {
					segmentNumber = Integer.parseInt(segmentInput);
					if (segmentNumber < 1) {
						throw new NumberFormatException();
					}
					//TODO: Pass segmentNumber into the program		
					new programRunner(file, segmentNumber);
				}
				//If there is a NumberFormatException, the 
				catch(NumberFormatException e) {
					//Popup for non-numerical input
					JOptionPane.showMessageDialog(null, "You entered an invalid segment length" ,
							"Invalid Input", JOptionPane.PLAIN_MESSAGE);
				}
			}
		});
		//Adds the analyseButton to the contentPane
		contentPane.add(analyseButton, BorderLayout.SOUTH);	
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}
	
	class FileNotFoundException extends Exception
	{
	      //Parameterless Constructor
	      public FileNotFoundException() {}

	      //Constructor that accepts a message
	      public FileNotFoundException(String message)
	      {
	         super(message);
	      }
	 }

	public static void setFile(File file) {
		textField.setText(file.getName());
		MainGUI.file = file;
		}

}
