/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.aisd.martin.frc2013;

import edu.wpi.first.wpilibj.Victor;
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
	private Victor frontLeft;
	private Victor frontRight;
        private Victor backLeft;
        private Victor backRight;
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
	public DriveTrain(int slot, int frontLeft, int frontRight, int backLeft, int backRight, Controller controller){
		this.frontLeft = new Victor(slot, frontLeft);
		this.frontRight = new Victor(slot, frontRight);
                this.backLeft = new Victor(slot, backLeft);
                this.backRight = new Victor(slot, backRight);
		
		this.controller = controller;
	}
	
	/*
	 * Anything in this class that needs to be updated each by the main thread 
	 * will go in this method. Will be called in the Team3676Robot operator control
	 * loop
	 * @param none
	 */
	public void tick(boolean precision){
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
		double left = forwardValue + rotationValue;
                double right = forwardValue - rotationValue;
                left = Math.max(left, -1);
                right = Math.max(right, -1);
                left = Math.min(left, 1);
                right = Math.min(right, 1);
                if(precision){
                    left *= .5;
                    right *= .5;
                }
                left *= .9;
                frontLeft.set(left);
                backLeft.set(left);
                frontRight.set(right);
                backRight.set(right);
	}
        
        public void autoTick(double[] position){
		if(position[1] > .9){
			frontRight.set(.5);
                        backRight.set(.5);
		} else if(position[1] > .5){
			frontRight.set(.3);
                        backRight.set(.3);
		} else if(position[1] > .3){
			frontRight.set(.1);
                        backRight.set(.1);
		}

	}
}