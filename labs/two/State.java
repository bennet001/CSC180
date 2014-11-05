package lab.two;

public interface State {
	/**
	 * prints a message to the screen indicating what the user should do
	 */
	void show();
	/**
	 * takes in the user’s next request and decides what state the user is now in
	 * @return DefaultState 
	 * UserHomeState 
	 * SearchResultState
	 */
	State next();
}
