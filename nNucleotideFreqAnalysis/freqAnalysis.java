package nNucleotideFreqAnalysis;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * 
 * @author ejwilliams
 *
 */
public class freqAnalysis {
	private static ArrayList<String> genomeSegments = new ArrayList<String>();
	//Constant for the segment length
	private static final int SEGMENT_LENGTH = 1000;
	
	public static void main(String [] args) {
		TextInput input = new TextInput();
		String genome = input.getGenome();
		System.out.println("Genome successfully imported");
		partSegmenter(genome);
		System.out.println("Success in segmenting");
	}
	
	public static void partSegmenter(String genome) {
		int segmentNumber = genome.length()/SEGMENT_LENGTH;
		System.out.println("There will be " + segmentNumber + " segments to import");
		for (int i=0; i < segmentNumber; i++) {
			genomeSegments.add(genome.substring(i,(SEGMENT_LENGTH+i)));
			System.out.printf("Segmented region %d %n", i);
		}
	}
	
	
}

