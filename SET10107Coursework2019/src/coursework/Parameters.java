package coursework;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Random;
import model.LunarParameters;
import model.NeuralNetwork;
import model.LunarParameters.DataSet;

public class Parameters {
 
	/**
	 * These parameter values can be changed 
	 * You may add other Parameters as required to this class 
	 * 
	 */
	private static int numHidden = 3;	// X * 5 + X + X * 3 + 3 = 
	private static int numGenes = calculateNumGenes();
	public static int numInputs = 5;
	public static int numOutputs = 3;
	public static double minGene = -3; // specifies minimum and maximum weight values 
	public static double maxGene = +3;
		
	public static int popSize = 50; // Default 40 // 10 times of the solution
	public static int maxEvaluations = 20000; // Must be 20000
	
	// Selection
	public static int tournamentSize = 3;
	public static int numberOfParents = 2;
	
	// CrossOver - Don't change for now!
	public static int numberOfChildrenBorn = 1;
	public static int numberOfChildrenSurvive = 1;
	
	// Parameters for BFF mutation
	public static double bandWidthRange = 0.05;
	public static double mutateRateConst = 0.1;
	public static int lGenerations = 50;
	public static double mutationProbability = 0.1;
	public static double mutationStep = 0.1;
	public static ArrayList<Double> bffs = new ArrayList<Double>();
	public static double linkingCoefficient = 1.2;
	
	//
	public static int fitnesslastUpdateIndex = 0;
	
	// Rate = probability of changing a gene
	// Change = the maximum +/- adjustment to the gene value
	public static double mutateRate = 0.05; // mutation rate for mutation operator Default 0.01
	public static double mutateChange = 0.05; // delta change for mutation operator Default 0.05
	
	//Random number generator used throughout the application
	public static long seed = System.currentTimeMillis();
	// public static long seed = ;
	public static Random random = new Random(seed);

	//set the NeuralNetwork class here to use your code from the GUI
	public static Class neuralNetworkClass = MyEvolutionaryAlgorithm.class;
	
	/**
	 * Do not change any methods that appear below here.
	 * 
	 */
	
	public static int getNumGenes() {					
		return numGenes;
	}

	
	private static int calculateNumGenes() {
		int num = (NeuralNetwork.numInput * numHidden) + (numHidden * NeuralNetwork.numOutput) + numHidden + NeuralNetwork.numOutput;
		return num;
	}

	public static int getNumHidden() {
		return numHidden;
	}
	
	public static void setHidden(int nHidden) {
		numHidden = nHidden;
		numGenes = calculateNumGenes();		
	}

	public static String printParams() {
		String str = "";
		for(Field field : Parameters.class.getDeclaredFields()) {
			String name = field.getName();
			Object val = null;
			try {
				val = field.get(null);
			} catch (IllegalArgumentException | IllegalAccessException e) {
				e.printStackTrace();
			}
			str += name + " \t" + val + "\r\n";
			
		}
		return str;
	}
	
	public static void setDataSet(DataSet dataSet) {
		LunarParameters.setDataSet(dataSet);
	}
	
	public static DataSet getDataSet() {
		return LunarParameters.getDataSet();
	}
	
	public static void main(String[] args) {
		printParams();
	}
}
