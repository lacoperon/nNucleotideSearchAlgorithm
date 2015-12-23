package nNucleotideFreqAnalysis;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Scanner;


/**
 * TextInput Class, for importing nucleotide data
 * @author Elliot Williams
 *
 */

public class TextInput {
	private String output;
	private long fileLength;
	private String filename;
	
	public TextInput() {
		File file = new File("ExampleForeignInsert.txt");
		System.out.println(file.length());
		
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader(filename));
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
			System.out.println("Had problem with file IO");
			System.out.println(e.getMessage());
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		finally {
		}
	}

	String getGenome() {
		return output;
	}
	
}
