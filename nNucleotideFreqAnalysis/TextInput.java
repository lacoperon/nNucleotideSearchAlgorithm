package nNucleotideFreqAnalysis;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;


public class TextInput {
	private String output;
	
	public TextInput() {
		Scanner sc = new Scanner(System.in);
		BufferedReader br = null;
		System.out.println("IMPORTING MAY TAKE A FEW MINUTES");
		System.out.print("Enter file: ");
		String file = sc.nextLine();
		System.out.println("Importing in progress...");
		sc.close();
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
