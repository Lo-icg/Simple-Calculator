package source;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;

public class Program {

	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//		Expression exp = new ExpressionBuilder("56+1+1−5").build();
//		int x = (int) exp.evaluate();
//		System.out.println(x);
		
//		Pattern pattern = Pattern.compile("[\\−\\×\\÷]");
//		Matcher match = pattern.matcher("56+1+1−5");
//		
//		String ss = "56+1+1−5";
//		
////		while (match.find()) {
////			ss = matc
//		}
//		
		String text = "9";
		String[] a = text.split("[-+*/]");
		for (String i : a) {
			System.out.println(i + ":");
			
		}
	}

}
