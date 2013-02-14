/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.aisd.martin.frc2013;

import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.Servo;

/**
 *
 * @author Developer
 */
public class Cameras {
    private Servo yAxis;
    private Servo xAxis;
    private Relay lightController;
    private boolean pressed;
    private boolean light;
    
    public Cameras(int slot, int yAxis, int xAxis, int light){
        this.yAxis = new Servo(slot, yAxis);
        this.xAxis = new Servo(slot, xAxis);
        this.lightController = new Relay(slot, light);
        this.lightController.setDirection(Relay.Direction.kForward);
        pressed = false;
    }
    
    public void think(double up, double left, boolean lightOff){
        //Controls the movable camera
        if(up > .1  ||  up < -.1)
            yAxis.set((up / 2) + .52);
        else
            xAxis.set(.5);
        if(left < -.1 || left > .1)
            xAxis.set((left / 2) + .5);
        else{
            yAxis.set(.52);
        }
        
        //Conrols light
        //Allows you to hold button as long as needed
        if(lightOff){
            pressed = true;
        }
        if(!lightOff && pressed){
            if(light){
                light = !light;
                lightController.set(Relay.Value.kOff);
            } else {
                light = !light;
                lightController.set(Relay.Value.kOn);
            }
        }
    } 
}
