package practic;

public class CapitalizeLetter {

	public static void main(String[] args) {
		String source1 = "as gtet E rt w wi ywe Aa try";
		//As gtEt E rt w wI YwE AA trY
		System.out.println(capitalize(source1));
		
		String source2 = "ay yY ttt ghthnh ";
		//AY YY ttt ghthnh 
		String res = capitalize(source2);
		System.out.println(res);
		
		char ch = 'r';
		if(Character.isUpperCase(ch)){
			
		}
	}

	static String capitalize(String src) {
		//TODO
		return src.replaceAll("a", "A").replaceAll("e", "E").replaceAll("o", "O").replaceAll("i", "I").replaceAll("y", "Y").replaceAll("u", "U");
	}
	
}
