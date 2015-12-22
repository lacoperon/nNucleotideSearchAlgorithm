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
		Scanner sc = new Scanner(System.in);
		BufferedReader br = null;
		System.out.println("IMPORTING MAY TAKE A FEW MINUTES");
		System.out.print("Enter file: ");
		filename = sc.nextLine();
		try {
			fileLength = Files.size(new File(filename).toPath());
			System.out.println(fileLength);
		} catch (IOException e1) {
			// Catches IOException, prints stack trace, and sets fileLength as 0 to avoid
			// A compilation error
			e1.printStackTrace();
			fileLength = 0;
		}
		System.out.println("Importing in progress...");
		sc.close();
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
