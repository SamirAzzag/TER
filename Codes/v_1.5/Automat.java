import java.util.List;
import java.util.Stack;


public class Automat {
    private List<Character> alphabet;
	private List<CircleShape> word;
	private Stack<ArcShape> stackM1;
	private Stack<ArcShape> stackM2;

	public Automat(List<Character> alphabet, List<CircleShape> word){
		this.alphabet = alphabet;
		this.word = word;
		stackM1 = new Stack<ArcShape>();
		stackM2 = new Stack<ArcShape>();
	}
}
