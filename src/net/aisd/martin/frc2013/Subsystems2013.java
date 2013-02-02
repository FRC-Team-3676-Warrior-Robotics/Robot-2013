package net.aisd.martin.frc2013;

import net.aisd.martin.frc.imageprocessing.ImageProcessing;


/**
 * This class will allow us to store "Subsystems" which are segments of our robot
 * These are similar to the built in subsystems but are coded and designed by us
 * making the code simpler, cleaner, and more efficient. Specifically it allows
 * subsystems to be used in many different situations, but with this power comes 
 * great responsablity. DON'T TELL A SUBSYSTEM TO DO 2 THINGS AT ONCE.
 * @author Neil
 */
//For more info compare the subsystem class provided by FRC with ours
public class Subsystems2013 {
    //Variables that holds all of our subsystems
    //None beyond the basics because we don't have a robot
	public static Pneumatics pneumatics;
	public static DriveTrain driveTrain;
	public static Controller controller1;
	public static ImageProcessing imageProcessor;
        public static Shooter shooter;
	
    /*
     * This instantiates all the robots subsystems. Will probably be called in the
     * robot main's constuctor
     */
    public static void init() {
		pneumatics = new Pneumatics();
		controller1 = new Controller(RobotMap2013.Input.joystick1);
		driveTrain = new DriveTrain(RobotMap2013.DriveMotors.slot,
									RobotMap2013.DriveMotors.left_front,
									RobotMap2013.DriveMotors.right_front,
                                                                        RobotMap2013.DriveMotors.left_back,
                                                                        RobotMap2013.DriveMotors.right_back,
									controller1);
		imageProcessor = new ImageProcessing();
                shooter = new Shooter(RobotMap2013.Shooter.motor_slot, RobotMap2013.Shooter.front, RobotMap2013.Shooter.back,
                        RobotMap2013.Shooter.pnuematics_slot, RobotMap2013.Shooter.piston_forward, RobotMap2013.Shooter.piston_backwards);
    }
}
