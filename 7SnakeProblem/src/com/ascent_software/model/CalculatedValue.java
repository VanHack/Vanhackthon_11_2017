package com.ascent_software.model;

public class CalculatedValue {

	private int fromRow;
	private int fromColum;
	private int valFrom;
	private int toRow;
	private int toColumn;
	private int valTo;
	private int valAdded;

	public CalculatedValue(int fromRow, int fromColum, int valFrom, int toRow, int toColumn, int valTo) {
		this.fromRow = fromRow;
		this.fromColum = fromColum;
		this.valFrom = valFrom;
		this.toRow = toRow;
		this.toColumn = toColumn;
		this.valTo = valTo;
		this.valAdded = valFrom + valTo;
	}

	// getters
	public int getFromRow() {
		return fromRow;
	}

	public int getFromColum() {
		return fromColum;
	}

	public String getFromRowColum(){
		return String.valueOf(getFromRow()).concat(String.valueOf(getFromColum()));
	}
	
	public String getToRowColum(){
		return String.valueOf(getToRow()).concat(String.valueOf(getToColumn()));
	}
	
	public int getToRow() {
		return toRow;
	}

	public int getToColumn() {
		return toColumn;
	}

	public int getAddedValue() {
		return valAdded;
	}

	public int getValFrom() {
		return valFrom;
	}

	public int getValTo() {
		return valTo;
	}

	@Override
	public String toString() {
		return "ValorCalculado [fromRow=" + fromRow + ", fromColum=" + fromColum + ", valFrom=" + valFrom + ", toRow="
				+ toRow + ", toColumn=" + toColumn + ", valTo=" + valTo + ", value=" + valAdded + "]";
	}

	public String display() {
		return "{R:" + fromRow + " && C:" + fromColum + "=["+ valFrom +"] + " +
			   "R:" + toRow + " && C:" + toRow + "=["+ valTo +"] = " +
			   "(" + valAdded + ")}";
	}
	
}
