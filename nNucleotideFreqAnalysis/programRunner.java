package nNucleotideFreqAnalysis;

import java.util.ArrayList;

public class programRunner {

	public static void main(String[] args) {
		TextInput input = new TextInput();
		String genome = input.getGenome();
		freqAnalysis freq = new freqAnalysis(genome);
		freq.doMonoFreqCalculations();
		freq.calculateAverageFreqs(freq.segmentedTypedFreqList.get(freq.MONO));
	}

}
