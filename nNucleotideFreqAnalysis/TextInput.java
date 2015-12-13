package nNucleotideFreqAnalysis;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;


public class TextInput {
	private String output;
	
	public void parseString() {
		Scanner sc = new Scanner(System.in);
		BufferedReader br = null;
		System.out.print("Enter file: ");
		String file = sc.nextLine();
		sc.close();
		try {
			br = new BufferedReader(new FileReader(file));
			String result = "";
			while (br.readLine() != null) {
				result+=br.readLine();
			}
			result = result.trim().toUpperCase();
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
	
}
