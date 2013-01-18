/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.aisd.martin.frc2013;

import edu.wpi.first.wpilibj.Talon;

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
	private Talon left;
	private Talon right;
	private Controller controller;
	
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
		this.left = new Talon(slot, left);
		this.right = new Talon(slot, right);
		
		this.controller = controller;
	}
	
	/*
	 * Anything in this class that needs to be updated each by the main thread 
	 * will go in this method. Will be called in the Team3676Robot operator control
	 * loop
	 * @param none
	 */
	public void tick(){
		double forwardValue = controller.getLeftYAxis(false);
		double rotationValue = controller.getLeftXAxis(false);
		
		/**
		* TODO: Decide whether we want arcade or tank drive and erase the other 
		* code. Committing both so we can go back if we need to
		* 
		*/
		
		//Implementing a tank drive
		//left.set(controller.getLeftYAxis(true));
		//right.set(controller.getRightYAxis(true));
		
		//Implementing a Arcade drive
		/**
		 * This one gets more complex we need to find the "Rotation value" and also
		 * the speed value and set them accordingly. Will take fine tuning
		 * Borrowed this code from FRC. We don't need to customize it yet or 
		 * hopefully ever cause I'm pretty sure it works with black magic
		 */
		
		if (rotationValue > 0.0) {
                left.set(-Math.max(-forwardValue, rotationValue));
                right.set(forwardValue + rotationValue);
            } else {
                left.set(forwardValue + rotationValue);
                right.set(-Math.max(-forwardValue, -rotationValue));
            }
	}
}
