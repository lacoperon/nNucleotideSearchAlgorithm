package nNucleotideFreqAnalysis;
import java.util.ArrayList;

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
	static final int DI = 1;
	static final int TRI = 2;
	static final int TETRA = 3;
	static String[] baseNucleotideOptions = {"A","T","C","G"};
	static String[] diNucleotideOptions = addPowerNucleotide(baseNucleotideOptions);
	static String[] triNucleotideOptions = addPowerNucleotide(diNucleotideOptions);
	static String[] tetraNucleotideOptions = addPowerNucleotide(triNucleotideOptions);

	//instance variable for number of segments in a genome
	private int segmentNumber;

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
		segmentNumber = genome.length()/SEGMENT_LENGTH;
		System.out.println("There will be " + segmentNumber + " segments to import");
		for (int i=0; i < segmentNumber; i++) {
			genomeSegments.add(genome.substring(i*SEGMENT_LENGTH,SEGMENT_LENGTH+SEGMENT_LENGTH*i));
			System.out.printf("Segmented region %d %n", i+1);
		}
	}
	/**
	 * ATCG Counter; returns an array of length 4
	 * The first entry is the A-content, the second entry is the T-content, 
	 * the third entry is the C-content, the fourth entry is the G-content
	 * @param segment
	 * @return prevalence of given nucleotide sequences for a given segment
	 */
	public ArrayList<Double> mononucleoCounter(String segment) {
		ArrayList<Double> mono = new ArrayList<Double>();
		String[] option = { "A","T","C","G"};
		double[] optionCount = { 0, 0, 0, 0};

		//Iterates through each segment, and calculates the A,T,C,G count from that
		for (int i=0; i<SEGMENT_LENGTH; i++) {
			String letter = segment.substring(i, i+1);
			for(int j=0; j < option.length; j++) {
				if(letter.equals(option[j])) {
					optionCount[j]++;
				}
			}	
		}
		//Sets the jth element in the Mononucleotide Frequency ArrayList to be the option[j] percentage
		for (int j=0; j<option.length; j++) {
			double countDecimal = (optionCount[j])/SEGMENT_LENGTH;
			mono.add(j, countDecimal);
		}
		return mono;
	}
	/**
	 * Dinucleotide Counter; returns an array of length 16
	 * @param segment
	 * @return prevalence of given nucleotide sequences for a given segment
	 */
	public ArrayList<Double> dinucleoCounter(String segment) {
		ArrayList<Double> di = new ArrayList<Double>();
		String[] option = diNucleotideOptions;
		double[] optionCount = new double[option.length];
		for (double number : optionCount) {
			number = 0;
		}
		//Iterates through each segment, and calculates the count for each option from that
		for (int i=0; i<(SEGMENT_LENGTH - DI); i++) {
			String letter = segment.substring(i, i+2);
			for(int j=0; j < option.length; j++) {
				if(letter.equals(option[j])) {
					optionCount[j]++;
				}
			}	
		}
		//Sets the jth element in the Dinucleotide Frequency ArrayList to be the option[j] percentage
		for (int j=0; j<option.length; j++) {
			double countDecimal = (optionCount[j])/(SEGMENT_LENGTH-DI);
			di.add(j, countDecimal);
		}
		return di;

	}
	/**
	 * Trinucleotide Counter; returns an array of length 64
	 * @param segment
	 * @return prevalence of given nucleotide sequences for a given segment
	 */
	public ArrayList<Double> trinucleoCounter(String segment) {
		ArrayList<Double> tri = new ArrayList<Double>();
		String[] option = triNucleotideOptions;
		double[] optionCount = new double[option.length];
		for (double number : optionCount) {
			number = 0;
		}
		//Iterates through each segment, and calculates the count for each option from that
		for (int i=0; i<(SEGMENT_LENGTH - TRI); i++) {
			String letter = segment.substring(i, i+3);
			for(int j=0; j < option.length; j++) {
				if(letter.equals(option[j])) {
					optionCount[j]++;
				}
			}	
		}
		//Sets the jth element in the Trinucleotide Frequency ArrayList to be the option[j] percentage
		for (int j=0; j<option.length; j++) {
			double countDecimal = (optionCount[j])/(SEGMENT_LENGTH-TRI);
			tri.add(j, countDecimal);
		}
		return tri;

	}
	/**
	 * Tetranucleotide Counter; returns an array of length 256
	 * @param segment
	 * @return prevalence of given nucleotide sequences for a given segment
	 */
	public ArrayList<Double> tetranucleoCounter(String segment) {
		ArrayList<Double> tetra = new ArrayList<Double>();
		String[] option = tetraNucleotideOptions;
		double[] optionCount = new double[option.length];
		for (double number : optionCount) {
			number = 0;
		}
		//Iterates through each segment, and calculates the count for each option from that
		for (int i=0; i<(SEGMENT_LENGTH - TETRA); i++) {
			String letter = segment.substring(i, i+4);
			for(int j=0; j < option.length; j++) {
				if(letter.equals(option[j])) {
					optionCount[j]++;
				}
			}	
		}
		//Sets the jth element in the tetranucleotide Frequency ArrayList to be the option[j] percentage
		for (int j=0; j<option.length; j++) {
			double countDecimal = (optionCount[j])/(SEGMENT_LENGTH-TETRA);
			tetra.add(j, countDecimal);
		}
		return tetra;
	}
	/**
	 * Does MonoFrequency calculations as in mononucleoCounter(), and adds the result to the segmentedTypedFreqList
	 */
	public void doMonoFreqCalculations() {
		ArrayList<ArrayList<Double>> monoFreq = new ArrayList<ArrayList<Double>>();
		for(String segment : genomeSegments) {
			monoFreq.add(mononucleoCounter(segment));
		}
		segmentedTypedFreqList.add(MONO, monoFreq);
		System.out.println("Mononucleotide Frequencies Calculated!");
	}

	/**
	 * Does DiFrequency calculations as in dinucleoCounter(), and adds the result to the segmentedTypedFreqList
	 */
	public void doDiFreqCalculations() {
		ArrayList<ArrayList<Double>> diFreq = new ArrayList<ArrayList<Double>>();
		for(String segment : genomeSegments) {
			diFreq.add(dinucleoCounter(segment));
		}
		segmentedTypedFreqList.add(DI, diFreq);
		System.out.println("Dinucleotide Frequencies Calculated!");

	}
	/**
	 * Does TriFrequency calculations as in trinucleoCounter(), and adds the result to the segmentedTypedFreqList
	 */
	public void doTriFreqCalculations() {
		ArrayList<ArrayList<Double>> triFreq = new ArrayList<ArrayList<Double>>();
		for(String segment : genomeSegments) {
			triFreq.add(trinucleoCounter(segment));
		}
		segmentedTypedFreqList.add(TRI, triFreq);
		System.out.println("Trinucleotide Frequencies Calculated!");

	}
	/**
	 * Does TetraFrequency calculations as in tetranucleoCounter(), and adds the result to the segmentedTypedFreqList
	 */
	public void doTetraFreqCalculations() {
		ArrayList<ArrayList<Double>> tetraFreq = new ArrayList<ArrayList<Double>>();
		for(String segment : genomeSegments) {
			tetraFreq.add(tetranucleoCounter(segment));
		}
		segmentedTypedFreqList.add(TETRA, tetraFreq);
		System.out.println("Tetranucleotide Frequencies Calculated!");
	}

	/**
	 * Getter for the segmented genome
	 * @return
	 */
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
	 * @return averageFreqs array
	 */
	public ArrayList<Double> calculateAverageFreqs(ArrayList<ArrayList<Double>> inputArrayofArray) {
		ArrayList<Double> averageFreqs = new ArrayList<Double>();

		int length = inputArrayofArray.get(0).size();
		//Sets every initial value in the averageFreqs array to 0
		for (int i=0; i < length; i++) {
			averageFreqs.add((double) 0);
		}
		//Sums up the segment values for a statistic across all segments
		for (ArrayList<Double> segmentStat : inputArrayofArray) {
			for (int i=0; i < segmentStat.size(); i++) {
				averageFreqs.set(i, averageFreqs.get(i) + segmentStat.get(i));
			}
		}

		//Divides the sum of the segment values for a given statistic by the number of segments
		// >>> IE getting the averageFreqs
		for (int i=0; i < averageFreqs.size(); i++) {
			double stat = averageFreqs.get(i);
			stat = stat / inputArrayofArray.size();
			averageFreqs.set(i, stat);
		}
		return averageFreqs;
	}


	/**
	 * Calculates the standard deviations 
	 * @param arrayofArrays
	 * @return standardDevsArray
	 */
	public ArrayList<Double> calculateStandardDeviationArray(ArrayList<ArrayList<Double>> inputArrayofArray,
			ArrayList<Double> averageFreqs) {
		ArrayList<Double> stdDevFreqs = new ArrayList<Double>();
		//Gets the number of statistics in an array for a given segment
		int length = inputArrayofArray.get(0).size();
		//Loops through each statistic, adding an initial value of 0 for the Standard Deviation
		for (int i=0; i<length; i++) {
			stdDevFreqs.add((double) 0);
		}
		//For each segment, calculated the individual variance of statistics
		for (ArrayList<Double> segmentStat : inputArrayofArray) {
			for(int i=0; i < segmentStat.size(); i++) {
				//adds the variance of a given statistic in a given segment to the stdDevFreq array,
				//which at this point is the sum of the variances
				stdDevFreqs.set(i, stdDevFreqs.get(i)+variance(averageFreqs.get(i), segmentStat.get(i)));
			}
		}

		//Divides each entry in stdDevFreqs by the number of segments in the currently accessed genome
		//And then takes the square root of that variance, yielding the true array of Standard Deviations
		for (int i=0; i<stdDevFreqs.size(); i++) {
			stdDevFreqs.set(i, stdDevFreqs.get(i)/segmentNumber);
			stdDevFreqs.set(i, Math.sqrt(stdDevFreqs.get(i)));
		}

		return stdDevFreqs;
	}
	/**
	 * Takes the average and the value at a point, and yields the variance
	 * IE (average - pointValue)^2
	 * @param average
	 * @param pointValue
	 * @return
	 */
	public static double variance(double average, double pointValue) {
		double output = Math.pow((average - pointValue),2);
		return output;
	}
	/**
	 * Returns an array of all possible nucleotide combinations of a
	 * nucleotides string of length nucleoNumber
	 * @param nucleoNumber
	 * @return nucleotidePermutations[]
	 * 
	 */
	public static String[] addPowerNucleotide(String[] previousIteration) {
		String[] baseNucleotideOptions = {"A","T","C","G"};
		int previousLength = previousIteration.length;
		int currentLength = previousLength*4;
		String[] output = new String[currentLength];

		for (int i=0; i<previousLength; i++) {
			for (int j=0; j<4; j++) {
				output[4*i+j] = previousIteration[i] + baseNucleotideOptions[j];
			}
		}
		System.out.println(output);
		return output;
	}
}






