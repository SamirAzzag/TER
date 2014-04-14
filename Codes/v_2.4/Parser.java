import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Parser {

	Parser(){

	}

	public List<CircleShape> parseCircles(String s, List<Symbol> a){
		List<CircleShape> listCircles = new ArrayList<CircleShape>();
		for (int i = 0; i < s.length(); i++){
			Symbol sym = returnSymbol(s.charAt(i), a);
			if (sym == null) {
				System.out.println("Symbol error:  \"" + s.charAt(i) + "\" is not present in the alphabet list.");
				return null;
			}
			listCircles.add(new CircleShape(i + 1, sym, Color.CYAN, Color.BLACK));
		}
		return listCircles;
	}
	
	public Symbol returnSymbol(Character c, List<Symbol> a){
		for (int i = 0; i < a.size(); i++){
			if (a.get(i).getCharacter().compareTo(c) == 0) return a.get(i);
		}
		return null;
	}

	public List<Symbol> parseAlphabet(String a){
		int c = 0;
		List<Symbol> listAlphabet = new ArrayList<Symbol>();
		for (int i = 0; i < a.length(); i++){
			//checking for duplicates characters
			if(returnSymbol(a.charAt(i), listAlphabet) != null){
				System.out.println("duplicate " + a.charAt(i) + " .");
				continue;
			} else {
				listAlphabet.add(new Symbol(a.charAt(i), c));
				c++;
			}
		}
		
		return listAlphabet;
	}
	
	/*public boolean checkSymbols(String w, List<Symbol> listAlphabet){
		for (int i = 0; i < w.length(); i++){
			if(!listAlphabet.contains(w.charAt(i))){
				System.out.println("Symbol error:  \"" + w.charAt(i) + "\" is not present in the alphabet list.");
				return false;
			}
		}
		return true;
	}*/

	public List<ArcShape> parseArcs(String s, boolean reverse, List<CircleShape> listCircles){
		List<ArcShape> listArcs = new ArrayList<ArcShape>();

		//verifying the input text
		String inputPattern = "^(\\(\\d,\\d\\),)+(\\(\\d,\\d\\))$";

	    if(!Pattern.compile(inputPattern).matcher(s).find() && !s.isEmpty()){
	    	System.out.println("Syntax error.");
	    }
	    System.out.println("Syntax is ok.");
	    

		//extracting values from the text
		Pattern compile1 = Pattern.compile("(?<=\\()\\d+(?=,)");
		Pattern compile2 = Pattern.compile("(?<=,)\\d+(?=\\))");
		Matcher matcher1 = compile1.matcher(s);
		Matcher matcher2 = compile2.matcher(s);

		while (matcher1.find() && matcher2.find()) {
			String group1 = matcher1.group();
			String group2 = matcher2.group();
			int p1 = Integer.parseInt(group1);
			int p2 = Integer.parseInt(group2);
			ArcShape as = new ArcShape(p1, p2, reverse);
			listArcs.add(as);
			if (reverse){
				listCircles.get(p1 - 1).setArc2(as);
				listCircles.get(p2 - 1).setArc2(as);
			} else {
				listCircles.get(p1 - 1).setArc1(as);
				listCircles.get(p2 - 1).setArc1(as);
			}
		}

		return listArcs;
	}

	public List<ComponentShape> generateGraphicsComponent(List<ArcShape> as1, List<ArcShape> as2, List<CircleShape> cs) {
		List<ComponentShape> l = new ArrayList<ComponentShape>();

		l.addAll(as1);
		if (as2 != null) l.addAll(as2);
		l.addAll(cs);

		return l;
	}
}
