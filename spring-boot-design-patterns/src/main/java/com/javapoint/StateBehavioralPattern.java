package com.javapoint;

/**
 *                          1 (once)
 *    |-----------------------------------------------|
 *    |                                               |                                                      
 *    ---------------                       ---------------
 *    StateA                                  StateB  -------------------|
 *                                                                       |   
 *    ---------------                       ---------------              |
 *                                                   ^                   |
 *                                                   |                   |
 *                                                   |-------------------|
 *                                                         2 (twice)
 */

import java.util.Locale;

interface State {
	public void writeName(String string);
}

class StateA implements State{
	public void writeName(String string) {
		System.out.println("in State A !!! transforming to UpperCase:" + string.toUpperCase());
		StateContext.setStateContext(new StateB());
	}
}

class StateB implements State{
	
	public static int count;
	
	StateB(){
		count = 0;
	}
	
	public void writeName(String string) {
		
		//upon 2 counts it will change state from StateB to StateA
		if (count > 1) {
			StateContext.setStateContext(new StateA());
		}
		else {
			Locale locale = new Locale("zh", "CN");
			System.out.println("in State B !!! transforming to lowerCase:" + string.toLowerCase());
		}
		++count;
	}	
}
	

class StateContext {
	
	private static State state;
	
	public StateContext() {
		setStateContext(new StateA());
	}
	
	public static void setStateContext(State state1) {
		state = state1;
	}
	
	public void writeName(String string) {
		state.writeName(string);
	}
}

public class StateBehavioralPattern {

	public static void main(String args[]) {
		
		StateContext stateContext = new StateContext();
		stateContext.writeName("gopal");
		stateContext.writeName("gopal");
		stateContext.writeName("gopal");
		stateContext.writeName("gopal");
		stateContext.writeName("gopal");
		stateContext.writeName("gopal");
		stateContext.writeName("gopal");
		stateContext.writeName("gopal");
		stateContext.writeName("gopal");
		
	}
}


/************************* OUTPUT *********************



in State A !!! transforming to UpperCase:GOPAL
in State B !!! transforming to lowerCase:gopal
in State B !!! transforming to lowerCase:gopal
in State A !!! transforming to UpperCase:GOPAL
in State B !!! transforming to lowerCase:gopal
in State B !!! transforming to lowerCase:gopal
in State A !!! transforming to UpperCase:GOPAL


*********************************************************/