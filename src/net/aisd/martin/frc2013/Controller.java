/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.aisd.martin.frc2013;

import edu.wpi.first.wpilibj.Joystick;

/**
 * This system contains and relays all the data of one controller of the fake 
 * X-BOX type
 * @author Neil
 */
class Controller {
	private Joystick joystick1;
	
	public Controller(int channel){
		this.joystick1 = new Joystick(channel);
	}
	
	/**
	 * The rest of the methods are used basically wrappers that allow us to better
	 * understand what each button is
	 * EX(I am making something up): Instead of button3 we will have a getLeftBumper
	 * method that will return button3's value or if the controller is null 0 or
	 * false depending on the button
	 */
	
	/**
	 * These methods return either their raw value or a squared value which is
	 * useful in some cases
	 */
	public double getLeftYAxis(boolean squared){
		if(!squared)
			return joystick1.getRawAxis(2);
		
		if(joystick1.getRawAxis(2) < 0)
			return -(joystick1.getRawAxis(2) * joystick1.getRawAxis(2));
		else
			return joystick1.getRawAxis(2) * joystick1.getRawAxis(2);
	}
	
	public double getLeftXAxis(boolean squared){
		if(!squared)
			return joystick1.getRawAxis(1);
		
		if(joystick1.getRawAxis(1) < 0)
			return -(joystick1.getRawAxis(1) * joystick1.getRawAxis(1));
		else
			return joystick1.getRawAxis(1) * joystick1.getRawAxis(1);
	}
	
	public double getRightYAxis(boolean squared){
		if(!squared)
			return joystick1.getRawAxis(5);
		
		if(joystick1.getRawAxis(5) < 0)
			return -(joystick1.getRawAxis(5) * joystick1.getRawAxis(5));
		else
			return joystick1.getRawAxis(5) * joystick1.getRawAxis(5);
	}
	
	public double getRightXAxis(boolean squared){
		if(!squared)
			return joystick1.getRawAxis(4);
		
		if(joystick1.getRawAxis(4) < 0)
			return -(joystick1.getRawAxis(4) * joystick1.getRawAxis(4));
		else
			return joystick1.getRawAxis(4) * joystick1.getRawAxis(4);
	}
	
	/**
	 * These methods do not return a squared value since they cannot do this
	 * Helpful hint did some experimenting and multiplying a boolean by itself
	 * actually does a "bitwise operation". Completely useless for us
	 */
	public boolean getLeftAxisButton(){
		return joystick1.getRawButton(3);
	}
	
	public boolean getRightAxisButton(){
		return joystick1.getRawButton(6);
	}
	
}
