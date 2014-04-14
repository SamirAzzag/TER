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
	
	public void parseTransitions(Automat automat, String t, 
			List<Symbol> s, List<Symbol> stack1, List<Symbol> stack2, List<Symbol> alphabet){
		/*Symbol[] sym1 = new Symbol[1];
		sym1[0] = returnSymbol('0', stack1);
		Symbol state = returnSymbol('0', s);
		Symbol nextState = state;
		Symbol ch = returnSymbol('a', alphabet);
		if (state == null || nextState == null || ch == null){
			System.out.println("non trouve test 1");
			return;
		}
		if (!automat.addTransition(TransitionType.CALL, state, nextState, ch, sym1)){
			System.out.println("ajout de la transition 1 echoue");
			return;
		}
		//sym1[0] = returnSymbol('0', stack);
		state = returnSymbol('2', s);
		nextState = returnSymbol('3', s);
		ch = returnSymbol('d', alphabet);
		if (state == null || nextState == null || ch == null){
			System.out.println("non trouve test 2");
			return;
		}
		if (!automat.addTransition(TransitionType.RETURN, state, nextState, ch, sym1)){
			System.out.println("ajout de la transition 2 echoue");
			return;
		}
		state = returnSymbol('3', s);
		nextState = state;
		ch = returnSymbol('d', alphabet);
		if (state == null || nextState == null || ch == null){
			System.out.println("non trouve test 3");
			return;
		}
		if (!automat.addTransition(TransitionType.RETURN, state, nextState, ch, sym1)){
			System.out.println("ajout de la transition 3 echoue");
			return;
		}
		state = returnSymbol('0', s);
		nextState = returnSymbol('1', s);
		ch = returnSymbol('b', alphabet);
		if (state == null || nextState == null || ch == null){
			System.out.println("non trouve test 4");
			return;
		}
		if (!automat.addTransition(TransitionType.RETURN, state, nextState, ch, sym1)){
			System.out.println("ajout de la transition 4 echoue");
			return;
		}
		state = returnSymbol('1', s);
		nextState = state;
		ch = returnSymbol('b', alphabet);
		if (state == null || nextState == null || ch == null){
			System.out.println("non trouve test 5");
			return;
		}
		if (!automat.addTransition(TransitionType.RETURN, state, nextState, ch, sym1)){
			System.out.println("ajout de la transition 5 echoue");
			return;
		}
		state = returnSymbol('1', s);
		nextState = returnSymbol('2', s);
		ch = returnSymbol('c', alphabet);
		if (state == null || nextState == null || ch == null){
			System.out.println("non trouve test 6");
			return;
		}
		if (!automat.addTransition(TransitionType.CALL, state, nextState, ch, sym1)){
			System.out.println("ajout de la transition 6 echoue");
			return;
		}
		state = returnSymbol('2', s);
		nextState = state;
		ch = returnSymbol('c', alphabet);
		if (state == null || nextState == null || ch == null){
			System.out.println("non trouve test 7");
			return;
		}
		if (!automat.addTransition(TransitionType.CALL, state, nextState, ch, sym1)){
			System.out.println("ajout de la transition 7 echoue");
			return;
		}*/
	}
	
	public List<Symbol> parseStates(String s){
		if (s == null || s.isEmpty()) return null;
		List<Symbol> states = new ArrayList<Symbol>();
		/*states.add(new Symbol('0', 0));
		states.add(new Symbol('1', 1));
		states.add(new Symbol('2', 2));
		states.add(new Symbol('3', 3));*/
		return states;
	}
	
	public List<Symbol> parseFinalStates(String fs, List<Symbol> s){
		if (s == null || s.isEmpty()) return null;
		List<Symbol> states = new ArrayList<Symbol>();
		for (int i = 0; i < fs.length(); i++){
			Symbol sym = returnSymbol(fs.charAt(i), s);
			if (sym == null) {
				System.out.println("Symbol error:  \"" + fs.charAt(i) + "\" is not present in the states list.");
				return null;
			}
			states.add(sym);
		}
		/*states.add(new Symbol('0', 0));
		states.add(new Symbol('3', 3));*/
		return states;
	}
	
	public List<Symbol> parseStackL1States(String s){
		if (s == null || s.isEmpty()) return null;		//on pourra plut™t faire la difference entre une cha”ne null (non indiquee) et une cha”ne vide qui represente un matching sans arc
		List<Symbol> states = new ArrayList<Symbol>();
		//states.add(new Symbol('0', 0));
		return states;
	}
	
	public List<Symbol> parseStackL2States(String s){
		if (s == null || s.isEmpty()) return null;		//on pourra plut™t faire la difference entre une cha”ne null (non indiquee) et une cha”ne vide qui represente un matching sans arc
		List<Symbol> states = new ArrayList<Symbol>();
		return states;
	}

	public List<ComponentShape> generateGraphicsComponent(List<ArcShape> as1, List<ArcShape> as2, List<CircleShape> cs) {
		List<ComponentShape> l = new ArrayList<ComponentShape>();

		l.addAll(as1);
		if (as2 != null) l.addAll(as2);
		l.addAll(cs);

		return l;
	}
}
