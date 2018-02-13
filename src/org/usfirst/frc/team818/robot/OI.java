package org.usfirst.frc.team818.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

public class OI {

	private Joystick leftStick, rightStick, gamepad;
	public JoystickButton left1, left2, left3, left4, left5, right1, right2, right3, right4, right5, 
		elevatorSwitch, elevatorBottom, gamepad3, elevatorScale, gamepad5, gamepad6, gamepad7, gamepad8;

	public OI() {

		// Instantiating Joysticks
		leftStick = new Joystick(Constants.leftJoystickPort);
		rightStick = new Joystick(Constants.rightJoystickPort);
		gamepad = new Joystick(Constants.gamepadPort);
		
		left1 = new JoystickButton(leftStick, 1);
		left2 = new JoystickButton(leftStick, 2);
		left3 = new JoystickButton(leftStick, 3);
		left4 = new JoystickButton(leftStick, 4);
		left5 = new JoystickButton(leftStick, 5);
		right1 = new JoystickButton(rightStick, 1);
		right2 = new JoystickButton(rightStick, 2);
		right3 = new JoystickButton(rightStick, 3);
		right4 = new JoystickButton(rightStick, 4);
		right5 = new JoystickButton(rightStick, 5);
		elevatorSwitch = new JoystickButton(gamepad, 1);
		elevatorBottom = new JoystickButton(gamepad, 2);
		gamepad3 = new JoystickButton(gamepad, 3);
		elevatorScale = new JoystickButton(gamepad, 4);
		gamepad5 = new JoystickButton(gamepad, 5);
		gamepad6 = new JoystickButton(gamepad, 6);
		gamepad7 = new JoystickButton(gamepad, 7);
		gamepad8 = new JoystickButton(gamepad, 8);
		
	}
	
	//Buttons
	
	
	// Joystick Axes
	public double getLeftY() {
		return (Math.abs(leftStick.getY()) > 0.1) ? -leftStick.getY() : 0;
	}

	public double getRightY() {
		return (Math.abs(rightStick.getY()) > 0.1) ? -rightStick.getY() : 0;
	}

	public double getLeftX() {
		return (Math.abs(leftStick.getX()) > 0.1) ? -leftStick.getX() : 0;
	}

	public double getRightX() {
		return (Math.abs(rightStick.getX()) > 0.1) ? -rightStick.getX() : 0;
	}
	
	public double getLeftZ() {
		return (Math.abs(leftStick.getZ()) > 0.1) ? -leftStick.getZ() : 0;
	}

	public double getRightZ() {
		return (Math.abs(rightStick.getZ()) > 0.1) ? -rightStick.getZ() : 0;
	}

	public double getGamepadLeftY() {
		return (Math.abs(gamepad.getRawAxis(1)) > 0.1) ? -gamepad.getRawAxis(1) : 0;
	}

	public double getGamepadRightY() {
		return (Math.abs(gamepad.getRawAxis(3)) > 0.1) ? -gamepad.getRawAxis(3) : 0;
	}

	public double getGamepadLeftX() {
		return (Math.abs(gamepad.getRawAxis(2)) > 0.1) ? -gamepad.getRawAxis(0) : 0;
	}

	public double getGamepadRightX() {
		return (Math.abs(gamepad.getRawAxis(4)) > 0.1) ? -gamepad.getRawAxis(2) : 0;
	}
	
	public boolean getElevatorBottom(){
		return elevatorBottom.get();
	}
	
	public boolean getElevatorSwitch(){
		return elevatorSwitch.get();
	}
	
	public boolean getElevatorScale(){
		return elevatorScale.get();
	}
	
}
