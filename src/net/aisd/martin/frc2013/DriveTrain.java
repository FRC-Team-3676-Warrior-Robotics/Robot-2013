/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.aisd.martin.frc2013;

import edu.wpi.first.wpilibj.Jaguar;

/**
 * This class controls all the systems related to moving the robot. This includes
 * ALL mobility devices from arms, to wheels, to drive motors, to a jet rocket.
 * 
 * Right now we just have a two wheel drive but it is easy to change this. Just
 * add or remove any controllers you need and update tick accordingly.
 * 
 * WE MAY NEED TO INVERSE MOTORS CONTROL, DEPENDING ON HOW THE TEAM WIRES THEM, RUN WITH
 * EXTREME CAUTION AND DO NOT BURN OUT THE MOTORS!!!!
 * 
 * @author Neil
 */
public class DriveTrain {
	//These are our speed controllers. Will change what they equal when we need to move
	private Jaguar left;
	private Jaguar right;
	private Controller contoller;
	
	/**
	 * Creates a two wheel drive train
	 * @param slot the slot for the motors
	 * @param left the left motor's channel
	 * @param right the right motor's channel
	 * @param controller the controller class that will control the drivetrain
	 * 
	 * This class and its constructor will be updated frequently! Please label 
	 * what you change and why!!!
	 */
	public DriveTrain(int slot, int left, int right, Controller controller){
		this.left = new Jaguar(slot, left);
		this.right = new Jaguar(slot, right);
		
		this.contoller = controller;
	}
	
	/*
	 * Anything in this class that needs to be updated each by the main thread 
	 * will go in this method. Will be called in the Team3676Robot operator control
	 * loop
	 * @param none
	 */
	public void tick(){
		/**
		* TODO: Set all of the motor values to their corresponding input or what
		* have you. We do not need to worry about null's since our input class
		* will handle that for us
		*/
	}
}
