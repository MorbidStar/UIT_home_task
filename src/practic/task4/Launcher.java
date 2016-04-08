package practic.task4;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import nedis.study.interfaces.t4.exceptions.CustomException;
import nedis.study.interfaces.t4.exceptions.StringUtils;

public class Launcher {

	public static void main(String[] args) {
		StringUtils su = new StringUtilsImpl();
//		System.out.println(su.div("54", "2"));
		String var1 = "re0s Hello 8 Java hei0a0";
		String word = "e";
		
		int[] res = su.findWord(var1, word);
		
		for (int re : res) {
			System.out.print(re + " ");
		}
		System.out.println();
		String test = "kaj..4km.234;kja23aoi9..9al0ook0lll1";
		try {
			double[] tet = su.findNumbers(test);
			for (double d : tet) {
				System.out.print(d + " ");
			}
		} catch (CustomException e) {
			System.out.println(e.getMessage());
		}
		
	}

}
