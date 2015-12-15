package nNucleotideFreqAnalysis;

import java.util.ArrayList;

public class programRunner {
	public static void main(String[] args) {
		TextInput input = new TextInput();
		String genome = input.getGenome();
		freqAnalysis freq = new freqAnalysis(genome);
		//MonoFreq Calculation Block
		freq.doMonoFreqCalculations();
		ArrayList<Double> monoAverage = freq.calculateAverageFreqs(freq.segmentedTypedFreqList.get(freqAnalysis.MONO));
		ArrayList<Double> monoStdDev = 
				freq.calculateStandardDeviationArray(freq.segmentedTypedFreqList.get(freqAnalysis.MONO), monoAverage);
		System.out.println("Mononucleotide Averages and Standard Deviations Done!");
		ArrayList<ArrayList<Double>> monoZScores = 
				freqAnalysis.makeZScoreArray(monoAverage, monoStdDev, freq.segmentedTypedFreqList.get(freqAnalysis.MONO));
		ArrayList<Double> monoScores = freqAnalysis.segmentScoreNFreq(monoZScores);
		System.out.println("Mononucleotide scoring done!");

		//DiFreq Calculation Block
		freq.doDiFreqCalculations();
		ArrayList<Double> diAverage = freq.calculateAverageFreqs(freq.segmentedTypedFreqList.get(freqAnalysis.DI));
		ArrayList<Double> diStdDev = 
				freq.calculateStandardDeviationArray(freq.segmentedTypedFreqList.get(freqAnalysis.DI), diAverage);
		System.out.println("Dinucleotide Averages and Standard Deviations Done!");
		ArrayList<ArrayList<Double>> diZScores = 
				freqAnalysis.makeZScoreArray(diAverage, diStdDev, freq.segmentedTypedFreqList.get(freqAnalysis.DI));
		ArrayList<Double> diScores = freqAnalysis.segmentScoreNFreq(diZScores);
		System.out.println("Dinucleotide scoring done!");

		//TriFreq Calculation Block
		freq.doTriFreqCalculations();
		ArrayList<Double> triAverage = freq.calculateAverageFreqs(freq.segmentedTypedFreqList.get(freqAnalysis.TRI));
		ArrayList<Double> triStdDev = 
				freq.calculateStandardDeviationArray(freq.segmentedTypedFreqList.get(freqAnalysis.TRI), triAverage);
		System.out.println("Trinucleotide Averages and Standard Deviations Done!");
		ArrayList<ArrayList<Double>> triZScores = 
				freqAnalysis.makeZScoreArray(triAverage, triStdDev, freq.segmentedTypedFreqList.get(freqAnalysis.TRI));
		ArrayList<Double> triScores = freqAnalysis.segmentScoreNFreq(triZScores);
		System.out.println("Trinucleotide scoring done!");

		//TetraFreq Calculation Block
		freq.doTetraFreqCalculations();
		ArrayList<Double> tetraAverage = freq.calculateAverageFreqs(freq.segmentedTypedFreqList.get(freqAnalysis.TETRA));
		ArrayList<Double> tetraStdDev = 
				freq.calculateStandardDeviationArray(freq.segmentedTypedFreqList.get(freqAnalysis.TETRA), tetraAverage);
		System.out.println("Tetranucleotide Averages and Standard Deviations Done!");
		ArrayList<ArrayList<Double>> tetraZScores = 
				freqAnalysis.makeZScoreArray(tetraAverage, tetraStdDev, freq.segmentedTypedFreqList.get(freqAnalysis.TETRA));
		ArrayList<Double> tetraScores = freqAnalysis.segmentScoreNFreq(tetraZScores);
		System.out.println("Tetranucleotide scoring done!");

		//Now to save a segment you want to a text file
		TextOutput out = new TextOutput();
		
		//PUT THE SEGMENT NUMBER YOU WANT TO PRINT IN HERE,
		int segmentNumberToPrint = 0;
		String segment = freq.getGenomeSegments().get(segmentNumberToPrint);
		System.out.printf("Segment Number %d%n", segmentNumberToPrint);
		System.out.println(segment);
		



	}
}
