/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.aisd.martin.frc2013;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * Empty Class till we know what to do with it
 * @author Neil
 */
public class Shooter {
	private Talon front;
        private Talon back;
        private DoubleSolenoid loader;
        private long readyTime= 0;
        private final static long reload_time = 2 * 1000;
        
        public Shooter(int slot, int front, int back, 
                int pneumaticsSlot, int pistonF, int pistonB) {
            this.front = new Talon(slot, front);
            this.back = new Talon(slot, back);
            this.loader = new DoubleSolenoid(pneumaticsSlot, pistonB, pistonF);
            readyTime = 0;
        }
        
        private void shoot(){
            if(System.currentTimeMillis() < readyTime)
                return;
            readyTime = System.currentTimeMillis() + reload_time;
            loader.set(DoubleSolenoid.Value.kForward);
        }
        
        public void think(boolean spinUp, boolean fire){
            if(System.currentTimeMillis() > readyTime - 1 * 1000)
                loader.set(DoubleSolenoid.Value.kReverse);
            
            if(spinUp){
                front.set(-1);
                back.set(-1);
            } else {
                front.set(0);
                back.set(0);
            }
       
            if(fire)
                shoot();
            
            if(readyTime - System.currentTimeMillis() < 0){
                SmartDashboard.putBoolean("Ready to Fire", true);
                SmartDashboard.putNumber("Time till fire", 0);
            } else{
                SmartDashboard.putBoolean("Ready to Fire", false);
                SmartDashboard.putNumber("Time till fire", (double)(readyTime - System.currentTimeMillis()) / 1000);
            }
            
        }
}
