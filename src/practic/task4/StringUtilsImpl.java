package practic.task4;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import nedis.study.interfaces.t4.exceptions.CustomException;
import nedis.study.interfaces.t4.exceptions.StringUtils;

public class StringUtilsImpl implements StringUtils {

	@Override
	public double div(String number1, String number2)
			throws NullPointerException, NumberFormatException,
			ArithmeticException {

		ifNullThrowException(number1, number2);

		double a = 0;
		double b = 0;

		try {
			a = Double.parseDouble(number1);
			b = Double.parseDouble(number2);
		} catch (NumberFormatException e) {
			throw new NumberFormatException(
					"number1 или number2 не являеться числом!");
		}

		if (b == 0) {
			throw new ArithmeticException();
		}

		return a / b;
	}

	@Override
	public int[] findWord(String text, String word) throws NullPointerException {

		ifNullThrowException(text, word);
		

		int[] tmp = new int[text.length()];
		Pattern p = Pattern.compile(word);
		Matcher m = p.matcher(text);
		int k = 0;

		while (m.find()) {
			tmp[k++] = m.start();
		}

		return Arrays.copyOf(tmp, k);
	}

	@Override
	public double[] findNumbers(String text) throws CustomException {
		Pattern p = Pattern.compile("[.]{0,1}\\d+[.]{0,1}\\d*");
		Matcher m = p.matcher(text);
		double[] tmp = new double[text.length()];
		int k = 0;

		while (m.find()) {
			tmp[k++] = Double.parseDouble(m.group());
		}
		
		if (k == 0) {
			throw new CustomException("Not found");
		}

		return Arrays.copyOf(tmp, k);
	}

	private void ifNullThrowException(String first, String second) {
		if (first == null || second == null) {
			throw new NullPointerException();
		}
	}

}
