package practic;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FindNumbers {

	public static void main(String[] args) {
		String src1 = "qwqwe123wewerw2343dfdf56hh6";
		//123,2343,56,6
		System.out.println(findNumbers(src1));
		
		String src2 = "qwqwe12.3wewerw67;43dfdf5-6hh6";
		//12,3,67,43,5,6,6
		System.out.println(findNumbers(src2));
	}

	static String findNumbers(String text) {
		//TODO
		StringBuilder result = new StringBuilder();
		Pattern p = Pattern.compile("\\d+");
		Matcher m = p.matcher(text);
		while(m.find()) {
			result.append(m.group()).append(",");
		}
		return result.substring(0,result.length()-1);
	}
}
