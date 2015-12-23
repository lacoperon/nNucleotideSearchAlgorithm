package nNucleotideFreqAnalysis;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JFileChooser;

public class FileChooserGUI extends JFrame implements ActionListener {

	private JPanel contentPane;
	private File fileToOpen;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FileChooserGUI frame = new FileChooserGUI();
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
	public FileChooserGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		JFileChooser fileChooser = new JFileChooser();
		contentPane.add(fileChooser, BorderLayout.CENTER);
		int returnVal = fileChooser.showOpenDialog(fileChooser.getParent());
		if (returnVal == JFileChooser.APPROVE_OPTION) {
			fileToOpen = fileChooser.getSelectedFile();
			MainGUI.setFile(fileToOpen.getName());
			dispose();
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		//EMPTY
	}

}
