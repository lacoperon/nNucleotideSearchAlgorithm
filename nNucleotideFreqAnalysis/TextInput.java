package nNucleotideFreqAnalysis;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Scanner;

import javax.swing.JOptionPane;


/**
 * TextInput Class, for importing nucleotide data
 * @author Elliot Williams
 *
 */

public class TextInput {
	private String output;
	private long fileLength;
	private String filename;
	private File file;
	
	public TextInput(File file) {
		this.file = file;
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader(file));
			String result = "";
			boolean keepIterating = true;
			while (keepIterating) {
				String line = br.readLine();
				result+=line;
				if (line == null) {
					System.out.println("Finished importing!");
					keepIterating = false;
				}
			}
			System.out.println(result.length());
			br.close();
			output = result;
		}
		catch (FileNotFoundException e) {
			JOptionPane.showMessageDialog(null, "File not found");
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		catch (NullPointerException e) {
			JOptionPane.showMessageDialog(null, "Choose a file first!");
		}
		finally {
		}
	}

	String getGenome() {
		return output;
	}
	
}
