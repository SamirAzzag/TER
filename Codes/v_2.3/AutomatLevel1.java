import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class AutomatLevel1 implements Automat {
    private List<Symbol> alphabet;
	private List<CircleShape> word;
	private List<Symbol> states;
	private Stack<ArcShape> stackL1;
	private List<Symbol> stackL1States;
	private List<Transition>[][] internTransitions;
	private List<Transition>[][] callTransitions;
	private List<Transition>[][] returnTransitions;
	
	private class Transition {
		TransitionType type;
		Symbol currentState;
		Symbol nextState;
		Symbol character;
		Symbol stackL1State;
		
		Transition(TransitionType type, Symbol currentState, Symbol nextState, 
				Symbol character, Symbol stackL1State){
			this.type = type;
			this.currentState = currentState;
			this.nextState = nextState;
			this.character = character;
			this.stackL1State = stackL1State;
		}
	}

	public AutomatLevel1(List<Symbol> alphabet, List<CircleShape> word, 
			List<Symbol> states, List<Symbol> stackL1States){
		this.alphabet = alphabet;
		this.word = word;
		this.states = states;
		this.stackL1States = stackL1States;
		stackL1 = new Stack<ArcShape>();
		internTransitions = new ArrayList[alphabet.size()][states.size()];
		callTransitions = new ArrayList[alphabet.size()][states.size()];
		returnTransitions = new ArrayList[alphabet.size()][states.size()];
	}
	
	@Override
	public boolean addTransition(TransitionType type, Symbol currentState, Symbol nextState, 
			Symbol character, Symbol[] stackStates){
		if (stackStates.length != 1) return false;
		
		if (!stackL1States.contains(stackStates[0])) return false; //useless if test already made in class Parser
		if (!alphabet.contains(character)) return false; //useless if test already made in class Parser
		if (!states.contains(currentState) || !states.contains(nextState)) return false; //useless if test already made in class Parser
		
		if (type == TransitionType.INTERN && stackStates[0] == null) {
			if (internTransitions[character.getNumber()][currentState.getNumber()] == null){
				internTransitions[character.getNumber()][currentState.getNumber()] = new ArrayList<Transition>();
			}
			internTransitions[character.getNumber()][currentState.getNumber()].add(
					new Transition(type, currentState, nextState, character, null));
			return true;
		}
		if (type == TransitionType.CALL && stackStates[0] != null) {
			if (callTransitions[character.getNumber()][currentState.getNumber()] == null){
				callTransitions[character.getNumber()][currentState.getNumber()] = new ArrayList<Transition>();
			}
			callTransitions[character.getNumber()][currentState.getNumber()].add(
					new Transition(type, currentState, nextState, character, stackStates[0]));
			return true;
		}
		if (type == TransitionType.RETURN && stackStates[0] != null) {
			if (returnTransitions[character.getNumber()][currentState.getNumber()] == null){
				returnTransitions[character.getNumber()][currentState.getNumber()] = new ArrayList<Transition>();
			}
			returnTransitions[character.getNumber()][currentState.getNumber()].add(
					new Transition(type, currentState, nextState, character, stackStates[0]));
			return true;
		}
		return false;
	}
}
