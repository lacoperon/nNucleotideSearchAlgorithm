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
	private ArrayList<String> genomeSegments = new ArrayList<String>();
	//Constant for the segment length
	private static final int SEGMENT_LENGTH = 1000;
	private static final int MONO = 0;
	
	//Creates an ArrayList of segment-indexed ArrayLists that will contain ArrayLists of frequencies
	//associated with different nNucleotide Frequency Analyses (Segment/FreqType/FreqOfGivenThing)
	ArrayList<ArrayList<ArrayList<Double>>> segmentedTypedFreqList  = 
			new ArrayList<ArrayList<ArrayList<Double>>>(1);
	
	public freqAnalysis(String genome) {
		this.partSegmenter(genome);
		System.out.println("Success in segmenting");
	}

	/**
	 * Method which segments the genome string into segments, of length SEGMENT_LENGTH
	 * @param genome
	 */
	public void partSegmenter(String genome) {
		int segmentNumber = genome.length()/SEGMENT_LENGTH;
		System.out.println("There will be " + segmentNumber + " segments to import");
		for (int i=0; i < segmentNumber; i++) {
			genomeSegments.add(genome.substring(i,(SEGMENT_LENGTH+i)));
			System.out.printf("Segmented region %d %n", i);
		}
	}
	/**
	 * Regular GC Counter; returns an array of length 2
	 * The first entry is the GC-content, the second entry is the AT-content
	 * @param segment
	 * @return
	 */
	public ArrayList<Double> mononucleoCounter(String segment) {
		ArrayList<Double> mono = new ArrayList<Double>();
		String[] option = { "A", "T", "C", "G" };
		int atCount = 0;
		int gcCount = 0;
		
		//Iterates through each segment, and calculates both GC and AT count from that
		for (int i=0; i<SEGMENT_LENGTH; i++) {
			String letter = segment.substring(i, i+1);
			if(letter.equals(option[0])) {
				atCount++;
			}
			else if(letter.equals(option[1])) {
				atCount++;
			}
			else if(letter.equals(option[2])) {
				gcCount++;
			}
			else if(letter.equals(option[3])) {
				gcCount++;
			}
		}
		//Sets the 0th element in the Mononucleotide Frequency ArrayList to be gcCount percentage
		double gcCountDecimal = ((double)gcCount)/SEGMENT_LENGTH;
		mono.add(0, gcCountDecimal);

		//Sets the 1st element in the Mononucleotide Frequency ArrayList to be atCount percentage
		double atCountPercentage = ((double)atCount/SEGMENT_LENGTH);
		mono.add(1, atCountPercentage);
		System.out.println(mono);
		return mono;
	}
	
	public void doMonoFreqCalculations() {
		for (int i=0; i < genomeSegments.size(); i++) {
			System.out.println(genomeSegments.get(i));
			this.setFreqList(this.mononucleoCounter(genomeSegments.get(i)), i, MONO);
			System.out.println(this.mononucleoCounter(genomeSegments.get(i)));
		}
	}
	
	public ArrayList<String> getGenomeSegments() {
		return genomeSegments;
	}
	
	/**
	 * Puts the ArrayList of Frequencies associated with a given Nucleotide Frequency Function into the
	 * overarching segmentedTypedFreqList ArrayList (of ArrayList of ArrayList of Double) 
	 * @param frequencies
	 * @param segmentNumber
	 * @param testType
	 */
	public void setFreqList(ArrayList<Double> frequencies, int segmentNumber, int testType) {
		ArrayList<ArrayList<Double>> FreqListGivenSegment = segmentedTypedFreqList.get(segmentNumber);
		FreqListGivenSegment.set(testType, frequencies);
		segmentedTypedFreqList.set(segmentNumber, FreqListGivenSegment);
	}
}

