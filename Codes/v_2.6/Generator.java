import java.util.List;


public class Generator {
	private Automat automat;
	private Inw1 inw1;
	private Inw2 inw2;
	private Parser parser;
	private List<Symbol> alphabet;
	private List<CircleShape> word;
	private List<Symbol> states;
	private List<Symbol> finalStates;
	private List<Symbol> stackL1States;
	private List<Symbol> stackL2States;
	
	public Generator(){
		parser = new Parser();
		inw1 = new Inw1();
		inw2 = new Inw2();
		alphabet = null;
		word = null;
		automat = null;
		states = null;
		finalStates = null;
		stackL1States = null;
		stackL2States = null;
	}
	
	public void generateWord(String w, String s1, String s2, String a){
		alphabet  = parser.parseAlphabet(a);
		word = parser.parseCircles(w, alphabet);
		
		if (word == null) {
			System.out.println("DEBUG : word is null");
			return;
		}
			
		List<ArcShape> asAbove = parser.parseArcs(s1, false, word);
		
		if(!s2.isEmpty()) {
			List<ArcShape> asBelow = parser.parseArcs(s2, true, word);
			inw2.setWord(w);
			inw2.setMatching1(asAbove);
			inw2.setMatching2(asBelow);
			if(inw2.isMatching()) {
				MainWindow.getDp().setComponentShape(parser.generateGraphicsComponent(asAbove, asBelow, word));
			} 
			else {
				System.out.println("Proposed matching does'nt correspond to the definition.");
			}
		} 
		else {
			inw1.setWord(w);
			inw1.setMatching1(asAbove);
			if (inw1.isMatching()){
				MainWindow.getDp().setComponentShape(parser.generateGraphicsComponent(asAbove, null, word));
			} else {
				System.out.println("Proposed matching does'nt correspond to the definition.");
			}
		}
		MainWindow.getDp().repaint();
	}
	
	public void generateAutomat(String t, String s, String sL1, String sL2, String fs){
		if (alphabet == null || word == null) {
			System.out.println("The word was not created");
			return;
		}
		
		//setAutomatParameters(s, sL1, sL2);
		states = parser.parseStates(s);
		finalStates = parser.parseFinalStates(fs, states);
		stackL1States = parser.parseStackL1States(sL1);
		stackL2States = parser.parseStackL2States(sL2);
		
		if (stackL1States != null && stackL2States == null){
			automat = new AutomatLevel1(alphabet, word, states, stackL1States, finalStates);
			parser.parseTransitions(automat, t, states, stackL1States, stackL2States, alphabet);
			System.out.println("niveau 1");
			return;
		}
		if (stackL1States != null && stackL2States != null){
			automat = new AutomatLevel2(alphabet, word, states, stackL1States, stackL2States, finalStates);
			parser.parseTransitions(automat, t, states, stackL1States, stackL2States, alphabet);
			return;
		}
		
		System.out.println("Generation failed");
	}
	
	/*private void setAutomatParameters(String sstates, String sstackL1States, String sstackL2States){
		states = parser.parseStates(sstates);
		finalStates = parser.parseFinalStates(fs, states);
		stackL1States = parser.parseStackL1States(sstackL1States);
		stackL2States = parser.parseStackL2States(sstackL2States);
	}*/
	
	public void startAutomat(){
		if (automat == null) {
			System.out.println("The automat was not initialisated");
			return;
		}
		
		if (automat.start()){
			System.out.println("Accepted");
		} else {
			System.out.println("Rejected");
		}
	}
	
	public List<Symbol> getAlphabet(){
		return alphabet;
	}
	
	public List<CircleShape> getWord(){
		return word;
	}
	
	public List<Symbol> getStates(){
		return states;
	}
	
	public List<Symbol> getFinalStates(){
		return states;
	}
	
	public List<Symbol> getStackL1States(){
		return stackL1States;
	}
	
	public List<Symbol> getStackL2States(){
		return stackL2States;
	}
}
