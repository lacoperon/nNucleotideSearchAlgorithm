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
	static final int MONO = 0;

	//Creates an ArrayList of segment-indexed ArrayLists that will contain ArrayLists of frequencies
	//associated with different nNucleotide Frequency Analyses (FreqType/Segment/FreqOfGivenThing)
	ArrayList<ArrayList<ArrayList<Double>>> segmentedTypedFreqList  = 
			new ArrayList<ArrayList<ArrayList<Double>>>(1);
	/**
	 * Constructor for freqAnalysis. Takes in a genome, and segments it into discrete parts.
	 * @param genome
	 */
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
			genomeSegments.add(genome.substring(i*1000,SEGMENT_LENGTH+1000*i));
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
		String[] option = { "A","C"};
		int atCount = 0;
		int gcCount = 0;
		segment = segment.replaceAll("T", "A");
		segment = segment.replaceAll("G", "C");

		//Iterates through each segment, and calculates both GC and AT count from that
		for (int i=0; i<SEGMENT_LENGTH; i++) {
			String letter = segment.substring(i, i+1);
			if(letter.equals(option[0])) {
				atCount++;
			}
			else if(letter.equals(option[1])) {
				gcCount++;
			}
		}
		//Sets the 0th element in the Mononucleotide Frequency ArrayList to be gcCount percentage
		double gcCountDecimal = ((double)gcCount)/SEGMENT_LENGTH;
		mono.add(0, gcCountDecimal);

		//Sets the 1st element in the Mononucleotide Frequency ArrayList to be atCount percentage
		double atCountPercentage = ((double) atCount) / SEGMENT_LENGTH;
		mono.add(1, atCountPercentage);
		return mono;
	}
	/**
	 * Does MonoFrequency calculations as in monoNucleoCounter(), and adds the result to the segmentedTypedFreqList
	 */
	public void doMonoFreqCalculations() {
		ArrayList<ArrayList<Double>> monoFreq = new ArrayList<ArrayList<Double>>();
		for(String segment : genomeSegments) {
			monoFreq.add(mononucleoCounter(segment));
		}
		segmentedTypedFreqList.add(MONO, monoFreq);
		System.out.println(segmentedTypedFreqList);
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
	/**
	 * Calculates average frequencies of nnucleotideFrequencies
	 * @param inputArrayofArray
	 * @return
	 */
	public ArrayList<Double> calculateAverageFreqs(ArrayList<ArrayList<Double>> inputArrayofArray) {
		ArrayList<Double> averageFreqs = new ArrayList<Double>();

		int length = inputArrayofArray.get(0).size();
		//Sets every initial value in the averageFreqs array to 0
		for (int i=0; i < length; i++) {
			averageFreqs.add((double) 0);
		}

		for (ArrayList<Double> segmentStat : inputArrayofArray) {
			for (int i=0; i < segmentStat.size(); i++) {
				averageFreqs.set(i, averageFreqs.get(i) + segmentStat.get(i));
			}
		}
		
		for (int i=0; i < averageFreqs.size(); i++) {
			double stat = averageFreqs.get(i);
			stat = stat / inputArrayofArray.size();
			averageFreqs.set(i, stat);
		}
		
		System.out.println(averageFreqs);
		return averageFreqs;


	}



}

