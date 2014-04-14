import java.util.List;


public class Generator {
	private Automat automat;
	private Inw1 inw1;
	private Inw1 inw2;
	private Parser parser;
	
	public Generator(){
		parser = new Parser();
	}
	
	public void generateWord(String w, String s1, String s2, String a){
		List<Symbol> alphabet  = parser.parseAlphabet(a);
		List<CircleShape> word = parser.parseCircles(w, alphabet);
		
		if (word == null) {
			System.out.println("DEBUG : word is null");
			return;
		}
			
		List<ArcShape> asAbove = parser.parseArcs(s1, false, word);
		
		if(!s2.isEmpty()) {
			List<ArcShape> asBelow = parser.parseArcs(s2, true, word);
			inw2 = new Inw2(w, asAbove, asBelow);
			if(inw2.isMatching()) {
				MainWindow.getDp().setComponentShape(parser.generateGraphicsComponent(asAbove, asBelow, word));
			} 
			else {
				System.out.println("Les conditions ne sont pas respectees par le matching propose.");
			}
		} 
		else {
			inw1 = new Inw1();
			inw1.setWord(w);
			inw1.setMatching(asAbove);
			inw1.setAlphabet(a);
			if (inw1.isMatching()){
				MainWindow.getDp().setComponentShape(parser.generateGraphicsComponent(asAbove, null, word));
			} else {
				System.out.println("Les conditions ne sont pas respectees par le matching propose.");
			}
		}
		MainWindow.getDp().repaint();
		  
	}
}
