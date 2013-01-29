/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.aisd.martin.frc2013;

/**
 *
 * @author Neil
 *
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public final class RobotMap2013 {
    /**
     * Signals a value that needs changed
     * Used in code as a placeholder for hardware that hasn't
     * been assigned a slot/channel yet
     * to find usages that need to be replaced in netbeans right click the variable
     * and click "Find Usage"
     */
    
    public static final int INVALID = Integer.MIN_VALUE;
    
    /**
     * Signals a value that might need to be removed
     * Used when the hardware team can't make up their freakin' minds
     * and continuously remove and add a device
     */
    
    public static final int UNUSED = Integer.MIN_VALUE;
    
    /**
     * Contains input device mappings (joysticks and gamepads
     */
    public static final class Input{
        private Input(){}
        public static final int joystick1 = 1;
        public static final int joystick2 = UNUSED;
    }
    
    /*
     * Contains all the nessacery slots and channels for the drive train
     */
    public static final class DriveMotors{
        private DriveMotors(){}
        //Slot the motors are located in
        public static final int slot = 1;
        
        //Use front left and right if only two motors are used
        public static final int left_front = 1;
        public static final int right_front = 2;
        //Use these motors if we use more than two
        public static final int left_back = 3;
        public static final int right_back = 4;
    }
    
    /*
     * Contains the slot and channel of all the compressor pnuematic hardware
     */
    
    public static final class Pneumatics{
        private Pneumatics() {}
        //Slot that pnumatics are located in
        public static final int slot = INVALID;
        //Channels
        public static final int compressor = INVALID;
        public static final int pressure_switch = INVALID;
    }
    
    
}
