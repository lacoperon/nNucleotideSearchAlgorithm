package nNucleotideFreqAnalysis;

import java.util.ArrayList;

public class programRunner {
	public static void main(String[] args) {
		TextInput input = new TextInput();
		String genome = input.getGenome();
		freqAnalysis freq = new freqAnalysis(genome);
		//MonoFreq Calculation Block
		freq.doMonoFreqCalculations();
		ArrayList<Double> monoAverage = freq.calculateAverageFreqs(freq.segmentedTypedFreqList.get(freq.MONO));
		ArrayList<Double> monoStdDev = 
				freq.calculateStandardDeviationArray(freq.segmentedTypedFreqList.get(freq.MONO), monoAverage);
		
		//DiFreq Calculation Block
		freq.doDiFreqCalculations();
		ArrayList<Double> diAverage = freq.calculateAverageFreqs(freq.segmentedTypedFreqList.get(freq.DI));
		ArrayList<Double> diStdDev = 
				freq.calculateStandardDeviationArray(freq.segmentedTypedFreqList.get(freq.DI), diAverage);
		
		//TriFreq Calculation Block
		freq.doTriFreqCalculations();
		ArrayList<Double> triAverage = freq.calculateAverageFreqs(freq.segmentedTypedFreqList.get(freq.TRI));
		ArrayList<Double> triStdDev = 
				freq.calculateStandardDeviationArray(freq.segmentedTypedFreqList.get(freq.TRI), triAverage);
		
		//TetraFreq Calculation Block
		freq.doTetraFreqCalculations();
		ArrayList<Double> tetraAverage = freq.calculateAverageFreqs(freq.segmentedTypedFreqList.get(freq.TETRA));
		ArrayList<Double> tetraStdDev = 
				freq.calculateStandardDeviationArray(freq.segmentedTypedFreqList.get(freq.TETRA), tetraAverage);
	}
}
