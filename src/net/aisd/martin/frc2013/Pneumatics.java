/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.aisd.martin.frc2013;

import net.aisd.martin.frc.AISDCompressor;

/**
 * This is the class for all the hardware relating to pneumatics 
 * @author Neil
 */
public class Pneumatics {
	private AISDCompressor compressor;
	
	/**
	 * This constructor uses the built in constants to find the slots and channels
	 * I dont see us using another one but just right it if you need it
	 */
	public Pneumatics(){
		this.compressor = new AISDCompressor(RobotMap2013.Pnumatics.slot, RobotMap2013.Pnumatics.pressure_switch,
											 RobotMap2013.Pnumatics.slot, RobotMap2013.Pnumatics.compressor);
		//Put any other hardware here
	}
}
