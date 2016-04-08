package lesson2;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TestString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String text = "qwqwe123wewerw2343dfdf56hh6";
		// System.out.println(text);
		// System.out.println(text.length());
		// System.out.println(text.charAt(6));
		// System.out.println(text.toUpperCase());
		// System.out.println(text.contains("World"));
		// System.out.println(text.substring(0, 5));
		// System.out.println(text.substring(5));
		// System.out.println(text.indexOf("o"));
		Pattern p = Pattern.compile("\\d+");
		Matcher m = p.matcher(text);
		while(m.find()) {
			System.out.print(m.group() + ",");
		}
		// System.out.println(text.indexOf("o", 5));
		// System.out.println(text.replace("World", "Java!"));
	}

}
