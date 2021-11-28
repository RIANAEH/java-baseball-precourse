package baseball;

import java.util.HashSet;

public class ResultCalculator {

	private static final int BALL_NUMBERS_LENGTH = 3;
	private final char[] inputBallNumbers;
	private final char[] randomBallNumbers;
	private HashSet<Character> numberSet;
	private int ball;
	private int strike;

	ResultCalculator(String inputBallNumbers, String randomBallNumbers) {
		this.inputBallNumbers = inputBallNumbers.toCharArray();
		this.randomBallNumbers = randomBallNumbers.toCharArray();
		ball = 0;
		strike = 0;

		setNumberSet();

		for (int i = 0; i < BALL_NUMBERS_LENGTH; i++) {
			calculateResult(this.inputBallNumbers[i], this.randomBallNumbers[i]);
		}
	}

	public void calculateResult(char inputNumber, char randomNumber) {
		if (isInNumberSet(inputNumber)) {
			if (isSamePlace(inputNumber, randomNumber)) {
				strike++;
			} else {
				ball++;
			}
		}
	}

	public boolean isInNumberSet(char inputNumber) {
		return numberSet.contains(inputNumber);
	}

	public boolean isSamePlace(char inputNumber, char randomNumber) {
		return inputNumber == randomNumber;
	}

	public void setNumberSet() {
		numberSet = new HashSet<>();
		for (char number : randomBallNumbers) {
			numberSet.add(number);
		}
	}

	public int getBall() {
		return ball;
	}

	public int getStrike() {
		return strike;
	}
}