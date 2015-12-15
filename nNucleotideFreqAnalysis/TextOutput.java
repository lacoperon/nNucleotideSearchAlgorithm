/**
 * @author ejwilliams
 */
package nNucleotideFreqAnalysis;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * @author Elliot
 *
 */
public class TextOutput {
	private int segmentNumber;

	public void printToFile(String segment, String filename) {
		try {
			System.out.println(segment);
			File file = new File (filename + ".txt");
			PrintWriter out = new PrintWriter(new FileOutputStream(filename + ".txt"));
			out.println(segment);
			out.close();
		}
		catch (FileNotFoundException e) {
			System.out.println("file could not be created");
		}
	}

}

