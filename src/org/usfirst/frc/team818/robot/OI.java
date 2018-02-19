package org.usfirst.frc.team818.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

public class OI {

	private Joystick leftStick, rightStick, gamepad;
	public JoystickButton elevatorBottom, elevatorSwitch, elevatorScale;

	public OI() {

		// Instantiating Joysticks
		leftStick = new Joystick(Constants.leftJoystickPort);
		rightStick = new Joystick(Constants.rightJoystickPort);
		gamepad = new Joystick(Constants.gamepadPort);
		
		elevatorBottom = new JoystickButton(gamepad, 0);
		elevatorSwitch = new JoystickButton(gamepad, 0);
		elevatorScale = new JoystickButton(gamepad, 0);
		
	}

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
