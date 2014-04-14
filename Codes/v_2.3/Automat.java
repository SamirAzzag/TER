
public interface Automat {
	public boolean addTransition(TransitionType type, Symbol currentState, Symbol nextState, 
			Symbol character, Symbol[] stackStates);
}
