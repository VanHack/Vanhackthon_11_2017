package com.ascent_software.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;

public class Value{

	protected int row;
	protected int column;
	protected int value;

	public Value(int row, int column, int value) {
		this.row = row;
		this.column = column;
		this.value = value;
	}

	public int getValue() {
		return value;
	}
	
	public int getRow() {
		return row;
	}

	public int getColumn() {
		return column;
	}

	public String getPostion(){
		return String.valueOf(getRow()).concat(String.valueOf(getColumn()));
	}

	@Override
	public String toString() {
		return "Value [row: " + row + ", column: " + column + ", value: " + value + ", position: " + getPostion() + "]";
	}

}
