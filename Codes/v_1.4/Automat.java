import java.util.List;
import java.util.Stack;


public class Automat {
	private List<CircleShape> word;
	private Stack<ArcShape> stackM1;
	private Stack<ArcShape> stackM2;
	
	public Automat(List<CircleShape> word){
		this.word = word;
		stackM1 = new Stack<ArcShape>();
		stackM2 = new Stack<ArcShape>();
	}
}
