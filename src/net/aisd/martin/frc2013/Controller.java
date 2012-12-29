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
		this.joystick1 = new Joystick(RobotMap2013.Input.joystick1);
	}
	
	/**
	 * The rest of the methods are used basically wrappers that allow us to better
	 * understand what each button is
	 * EX(I am making something up): Instead of button3 we will have a getLeftBumper
	 * method that will return button3's value or if the controller is null 0 or
	 * false depending on the button
	 */
	
}
