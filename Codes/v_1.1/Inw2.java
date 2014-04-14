import java.util.ArrayList;
import java.util.List;


public class Inw2 extends Inw1 {
	
	List<ArcShape> matching2; /* bottom Arcs */
	
	Inw2(String word, List<ArcShape> matching, List<ArcShape> matching2) {
		super(word, matching);
		this.matching2 = matching2;
	}

	Inw2(){
		super();
	}
	
	public boolean isMatching() {
		/* TODO TODO TODO TODO TODO */
		return super.isMatching();
	}
	
	public List<ComponentShape> generateGraphicsComponent() {
		List<ComponentShape> l = new ArrayList<ComponentShape>();
		
		l.addAll(super.generateGraphicsComponent());
		l.addAll(matching2);
		
		return l;
	}
}
