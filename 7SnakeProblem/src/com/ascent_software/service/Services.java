package com.ascent_software.service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

import com.ascent_software.model.CalculatedValue;
import com.ascent_software.model.Value;

public class Services {

	// private static final String FILENAME = "E:\\test\\filename.txt"; // full
	// path in case
	private static final String FILENAME = "grid_B.csv";
	BufferedReader br = null;
	Value matrixA[][];
	List<CalculatedValue> valueList = new ArrayList<CalculatedValue>();

	/**
	 * Method responsible for loading data from file and setting matrix
	 * dimensions.
	 */
	public void loadFileDataAndSetMatrixDimensions() {
		int numberOfRows = 0;
		int numberOfColumns = 0;
		try {
			this.br = new BufferedReader(new FileReader(FILENAME));

			// get number of rows and columns
			String line;
			while ((line = this.br.readLine()) != null) {
				String[] values = line.split(";");
				if (numberOfColumns > 0) {
					if (numberOfColumns != values.length) {
						throw new Exception("ERROR: number of values on line " + (numberOfRows + 1) + " on the file "
								+ FILENAME + " is diferent from the previous line(s)");
					} else {
						numberOfColumns = values.length;
						numberOfRows++;
					}
				} else {
					numberOfColumns = values.length;
					numberOfRows++;
				}
			}

			// Set matrixA dimentions
			matrixA = new Value[numberOfRows][numberOfColumns];

			// load matrixA values
			this.br = new BufferedReader(new FileReader(FILENAME));

			// get number of rows and columns
			String lineValue;

			// Temporary row count
			int tmpRow = 0;
			while ((lineValue = this.br.readLine()) != null) {
				String[] values = lineValue.split(";");
				for (int cColumn = 0; cColumn < values.length; cColumn++) {
					matrixA[tmpRow][cColumn] = new Value(tmpRow, cColumn, Integer.parseInt(values[cColumn]));
				}
				tmpRow++;
			}

			// close Buffer
			if (this.br != null) {
				this.br.close();
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Method responsible for display the matrix
	 */
	void displayMatrix() {
		// print title
		System.out.println("Matrix [" + this.matrixA.length + "X" + this.matrixA[0].length + "]:");

		// print matrix header with columns index
		// Need JAVA 8
		IntStream.range(0, (this.matrixA[0].length)).forEach(nbr -> System.out.print("\tC" + nbr + ":"));

		for (int i = 0; i < this.matrixA.length; i++) {
			// print row index
			System.out.print("\nrow" + i + ":");
			for (int j = 0; j < this.matrixA[0].length; j++) {
				// print every element
				System.out.print("\t" + matrixA[i][j].getValue());
			}

		}
		System.out.println("\n--------------------------------------------------------------------------");
		System.out.println("\n");
	}

	/**
	 * Method responsible for loading the list of adjacent values
	 */
	private void loadListOfAdjacentValues() {
		// get number of rows in the matrix
		int numberOfRows = this.matrixA.length; // number of rows

		// get number of columns in the matrix
		int numberOfColumns = this.matrixA[0].length; // number of columns

		for (int cRow = 0; cRow < numberOfRows; cRow++) {
			for (int cColumn = 0; cColumn < numberOfColumns; cColumn++) {

				// from left to right
				if (cRow < (numberOfRows - 1) && cColumn < (numberOfColumns - 1)) {
					// set current + right value
					valueList.add(new CalculatedValue(cRow, cColumn, matrixA[cRow][cColumn].getValue(), cRow,
							cColumn + 1, matrixA[cRow][cColumn + 1].getValue()));

					// set current value + on row down value
					valueList.add(new CalculatedValue(cRow, cColumn, matrixA[cRow][cColumn].getValue(), cRow + 1,
							cColumn, matrixA[cRow + 1][cColumn].getValue()));
				}

				// last right colum
				if (cRow < (numberOfRows - 1) && cColumn == (numberOfColumns - 1)) {
					// set current value + on row down value
					valueList.add(new CalculatedValue(cRow, cColumn, matrixA[cRow][cColumn].getValue(), cRow + 1,
							cColumn, matrixA[cRow + 1][cColumn].getValue()));
				}

			}
		}

	}

	/**
	 * Method responsible for identifying whether there is equivalence between
	 * two or more snakes
	 * 
	 * @param qtd
	 */
	public void compareSnakes(int qtd) {
		// list of equivalence snakes
		List<CalculatedValue> tmpValueList = new ArrayList<CalculatedValue>();
		Random ran = new Random();

		// Index to get a randomic snake
		CalculatedValue snakeA = valueList.get(ran.nextInt(valueList.size()));

		// print snake A
		System.out.print("Snake A: " + snakeA.display());

		// compare between snake A and all the snakes in the list
		for (CalculatedValue values : valueList) {
			// compares if values are equal but with different positions
			if ((values.getAddedValue() == snakeA.getAddedValue())
					&& !snakeA.getFromRowColum().equals(values.getFromRowColum())
					&& !snakeA.getFromRowColum().equals(values.getToRowColum())
					&& !snakeA.getToRowColum().equals(values.getFromRowColum())
					&& !snakeA.getToRowColum().equals(values.getToRowColum())) {
				tmpValueList.add(values);
			}
		}

		// if returns one or more equivalence
		if (tmpValueList.size() > 0) {
			// print the snakes that are adjacent based on the amount passed as
			// a parameter
			for (int i = 0; i < qtd; i++) {
				System.out
						.println("\t===> Snake" + fromNumberToAlphabetic(i + 1) + " " + tmpValueList.get(i).display());
			}

		} else {
			// OR, print FAIL massage if the snake A had not equivalent
			System.out.print("\t===> FAIL.....\n");
			// Start comparing again until find one equivalence between a random
			// snake and its equivalents
			compareSnakes(qtd);
		}

	}

	/**
	 * Method responsible to transform an integer into letter
	 * 
	 * @param number
	 * @return String
	 */
	public static String fromNumberToAlphabetic(int number) {
		if (number < 0) {
			return "-" + fromNumberToAlphabetic(-number - 1);
		}

		int quot = number / 26;
		int rem = number % 26;
		char letter = (char) ((int) 'A' + rem);
		if (quot == 0) {
			return "" + letter;
		} else {
			return fromNumberToAlphabetic(quot - 1) + letter;
		}
	}

	/**
	 * Main method
	 */
	public void run() {
		loadFileDataAndSetMatrixDimensions();

		displayMatrix();

		loadListOfAdjacentValues();

		compareSnakes(1);

	}

}
