import java.awt.Color;
import java.util.ArrayList;
import java.util.List;


public class Inw1 {

	private String word;
	private List<ArcShape> matching;

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

		List<ArcShape> matchingClone = new ArrayList<ArcShape>(matching);

		boolean error = false;
		
		for(ArcShape as : matching) {

			/* x < y order */
			if(as.getX() >= as.getY()) {
				System.out.println("Arc Error : Unordered arc found.(" + as.getX() + "," + as.getY() + ")");
				error = true;
			}

			//matchingClone.remove(0);
			System.out.println("as : (" + as.getX() + "," + as.getY() + ")");
			matchingClone.remove(0); 
			for(ArcShape as1 : matchingClone) {
				System.out.println("as1 : (" + as1.getX() + "," + as1.getY() + ")");
				if(as1.getX() == as.getX() && as1.getY() == as.getY()) {
					System.out.println("Arc Error : Duplicate arc found. (" + as.getX() + "," + as.getY() + ")");
					error = true;
				} else if (as.getX() < as1.getX() && as1.getX() < as.getY() && as.getY() < as1.getY()) { /* x1 < x2 < y1 < y2 => intersection */
					System.out.println("Arc Error : Intersection between two arcs found. (" + as.getX() + "," + as.getY() + "), (" + as1.getX() + "," + as1.getY() + ")");
					error = true;
				}
			}
		}

		return error;
	}

	public List<ComponentShape> generateGraphicsComponent() {
		List<ComponentShape> l = new ArrayList<ComponentShape>();

		l.addAll(matching);

		for(int i = 0; i < word.length(); i++) {
			l.add(new CircleShape(i + 1, word.substring(i, i+1), Color.CYAN, Color.BLACK));
		}

		return l;
	}

	public String getWord() {
		return word;
	}

	public void setWord(String word) {
		this.word = word;
	}

	public List<ArcShape> getMatching() {
		return matching;
	}

	public void setMatching(List<ArcShape> matching) {
		this.matching = matching;
	}

}
