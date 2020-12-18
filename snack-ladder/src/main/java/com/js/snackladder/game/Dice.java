package com.js.snackladder.game;

import lombok.Getter;

@Getter
public class Dice {

	private int minValue;
	private int maxValue;
	private int currentValue;

	public int rollDice() {
		return currentValue;
	};

}
