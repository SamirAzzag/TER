import java.util.ArrayList;
import java.util.List;


public class Inw1 {

	protected String word;
	protected String alphabet;
	protected List<ArcShape> matching; /* upper Arcs */

	Inw1(String word, List<ArcShape> matching) {
		this.matching = matching;
		this.word = word;
	}

	Inw1(){

	}

	public boolean isMatching() {
		if(matching == null || matching.isEmpty()) {  /* no error */
			System.out.println("No Arcs to check.");
			return true;
		}

		boolean flag = true;

		if(matching.size() != alphabet.length())   {  /* error */
			System.out.println("Matching relation not equal to alphabet length.");
			flag = false;
		}

		List<ArcShape> matchingClone = new ArrayList<ArcShape>(matching);

		for(ArcShape as : matching) {

			/* x < y order */
			if(as.getCallPosition() >= as.getReturnPosition()) {
				System.out.println("Arc Error : Unordered arc found.(" + as.getCallPosition() + "," + as.getReturnPosition() + ")");
				flag = false;
			}

			if (word != null && (as.getCallPosition() > word.length() || as.getReturnPosition() >  word.length() || as.getCallPosition() < 1 || as.getReturnPosition() < 1)) {
				System.out.println("Arc Error : Arc out of the word length found.(" + as.getCallPosition() + "," + as.getReturnPosition() + ")");
				flag = false;
			}

			System.out.println("as : (" + as.getCallPosition() + "," + as.getReturnPosition() + ")");

			matchingClone.remove(0);
			for(ArcShape as1 : matchingClone) {
				System.out.println("as1 : (" + as1.getCallPosition() + "," + as1.getReturnPosition() + ")");
				if(as1.getCallPosition() == as.getCallPosition() && as1.getReturnPosition() == as.getReturnPosition()) {
					System.out.println("Arc Error : Duplicate arc found. (" + as.getCallPosition() + "," + as.getReturnPosition() + ")");
					flag = false;
				} else if (as1.getCallPosition() == as.getCallPosition()){
					System.out.println("Vertex Error : Vertex \"" + as.getCallPosition() + "\" already used.");
					flag = false;
				} else if(as1.getReturnPosition() == as.getReturnPosition()){
					System.out.println("Vertex Error : Vertex \"" + as.getReturnPosition() + "\" already used.");
					flag = false;
				} else if (as.getCallPosition() < as1.getCallPosition() && as1.getCallPosition() < as.getReturnPosition() && as.getReturnPosition() < as1.getReturnPosition()) { /* x1 < x2 < y1 < y2 => intersection */
					System.out.println("Arc Error : Intersection between two arcs found. (" + as.getCallPosition() + "," + as.getReturnPosition() + "), (" + as1.getCallPosition() + "," + as1.getReturnPosition() + ")");
					flag = false;
				}
			}
		}

		return flag;
	}

	/*public List<ComponentShape> generateGraphicsComponent() {
		List<ComponentShape> l = new ArrayList<ComponentShape>();

		l.addAll(matching);

		for(int i = 0; i < word.length(); i++) {
			l.add(new CircleShape(i + 1, word.substring(i, i+1), Color.CYAN, Color.BLACK));
		}

		return l;
	}*/

	public String getWord() {
		return word;
	}

	public void setWord(String word) {
		this.word = word;
	}

	public String getAlphabet() {
		return alphabet;
	}

	public void setAlphabet(String alphabet) {
		this.alphabet = alphabet;
	}

	public List<ArcShape> getMatching() {
		return matching;
	}

	public void setMatching(List<ArcShape> matching) {
		this.matching = matching;
	}

}
