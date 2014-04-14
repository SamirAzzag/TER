import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class AutomatLevel2 implements Automat {
	private List<Symbol> alphabet;
	private List<CircleShape> word;
	private List<Symbol> states;
	private Stack<ArcShape> stackL1;
	private Stack<ArcShape> stackL2;
	private List<Symbol> stackL1States;
	private List<Symbol> stackL2States;
	private List<Transition>[][] internTransitions;
	private List<Transition>[][] callCallTransitions;
	private List<Transition>[][] returnCallTransitions;
	private List<Transition>[][] returnReturnTransitions;
	private List<Transition>[][] callReturnTransitions;
	
	private class Transition {
		TransitionType type;
		Symbol currentState;
		Symbol nextState;
		Symbol character;
		Symbol stackL1State;
		Symbol stackL2State;
		
		Transition(TransitionType type, Symbol currentState, Symbol nextState, Symbol character, 
				Symbol stackL1State, Symbol stackL2State){
			this.type = type;
			this.currentState = currentState;
			this.nextState = nextState;
			this.character = character;
			this.stackL1State = stackL1State;
			this.stackL2State = stackL2State;
		}
	}

	public AutomatLevel2(List<Symbol> alphabet, List<CircleShape> word, 
			List<Symbol> states, List<Symbol> stackL1States, List<Symbol> stackL2States){
		this.alphabet = alphabet;
		this.word = word;
		this.states = states;
		this.stackL1States = stackL1States;
		this.stackL2States = stackL2States;
		stackL1 = new Stack<ArcShape>();
		stackL2 = new Stack<ArcShape>();
		internTransitions = new ArrayList[alphabet.size()][states.size()];
		callCallTransitions = new ArrayList[alphabet.size()][states.size()];
		returnCallTransitions = new ArrayList[alphabet.size()][states.size()];
		returnReturnTransitions = new ArrayList[alphabet.size()][states.size()];
		callReturnTransitions = new ArrayList[alphabet.size()][states.size()];
	}

	@Override
	public boolean addTransition(TransitionType type, Symbol currentState, Symbol nextState, 
			Symbol character, Symbol[] stackStates) {
		if (stackStates.length != 2) return false;
		
		if (!stackL1States.contains(stackStates[0])) return false; //useless if test already made in class Parser
		if (!stackL2States.contains(stackStates[1])) return false; //useless if test already made in class Parser
		if (!alphabet.contains(character)) return false; //useless if test already made in class Parser
		if (!states.contains(currentState) || !states.contains(nextState)) return false; //useless if test already made in class Parser
		
		if (type == TransitionType.INTERN && stackStates[0] == null && stackStates[1] == null) {
			if (internTransitions[character.getNumber()][currentState.getNumber()] == null){
				internTransitions[character.getNumber()][currentState.getNumber()] = new ArrayList<Transition>();
			}
			internTransitions[character.getNumber()][currentState.getNumber()].add(
					new Transition(type, currentState, nextState, character, null, null));
			return true;
		}
		if (type == TransitionType.CALL_CALL && stackStates[0] != null && stackStates[1] != null) {
			if (callCallTransitions[character.getNumber()][currentState.getNumber()] == null){
				callCallTransitions[character.getNumber()][currentState.getNumber()] = new ArrayList<Transition>();
			}
			callCallTransitions[character.getNumber()][currentState.getNumber()].add(
					new Transition(type, currentState, nextState, character, stackStates[0], stackStates[1]));
			return true;
		}
		if (type == TransitionType.CALL_RETURN && stackStates[0] != null && stackStates[1] != null) {
			if (callReturnTransitions[character.getNumber()][currentState.getNumber()] == null){
				callReturnTransitions[character.getNumber()][currentState.getNumber()] = new ArrayList<Transition>();
			}
			callReturnTransitions[character.getNumber()][currentState.getNumber()].add(
					new Transition(type, currentState, nextState, character, stackStates[0], stackStates[1]));
			return true;
		}
		if (type == TransitionType.RETURN_CALL && stackStates[0] != null && stackStates[1] != null) {
			if (returnCallTransitions[character.getNumber()][currentState.getNumber()] == null){
				returnCallTransitions[character.getNumber()][currentState.getNumber()] = new ArrayList<Transition>();
			}
			returnCallTransitions[character.getNumber()][currentState.getNumber()].add(
					new Transition(type, currentState, nextState, character, stackStates[0], stackStates[1]));
			return true;
		}
		if (type == TransitionType.RETURN_RETURN && stackStates[0] != null && stackStates[1] != null) {
			if (returnReturnTransitions[character.getNumber()][currentState.getNumber()] == null){
				returnReturnTransitions[character.getNumber()][currentState.getNumber()] = new ArrayList<Transition>();
			}
			returnReturnTransitions[character.getNumber()][currentState.getNumber()].add(
					new Transition(type, currentState, nextState, character, stackStates[0], stackStates[1]));
			return true;
		}
		return false;
	}
}
