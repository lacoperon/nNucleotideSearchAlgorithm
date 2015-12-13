import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.Scanner;


public class TextInput {
	private static String output;
	public static void main(String [] args) {
		Scanner keyboard = new Scanner(System.in);
		System.out.print("Enter file: ");
		String file = keyboard.nextLine();
		try {
			Scanner in = new Scanner(new FileInputStream(file));
			String result = "";
			while (in.hasNextLine()) {
				result+=in.nextLine()+"\n";
			}
			result = result.trim().toUpperCase();
			in.close();
			output = result;
		}
		catch (FileNotFoundException e) {
			System.out.println("Had problem with file IO");
			System.out.println(e.getMessage());
		}
		finally {
			System.out.print(output);
		}
	}
	
}
