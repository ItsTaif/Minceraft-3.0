package org.usfirst.frc.team818.robot;

import org.usfirst.frc.team818.robot.commands.ArmadilloDrive;
import org.usfirst.frc.team818.robot.commands.ClimberDropCommand;
import org.usfirst.frc.team818.robot.commands.ClimberSpinCommand;
import org.usfirst.frc.team818.robot.commands.DynamicBraking;
import org.usfirst.frc.team818.robot.commands.IntakeDownCommand;
import org.usfirst.frc.team818.robot.commands.IntakeInCommand;
import org.usfirst.frc.team818.robot.commands.IntakeOutCommand;
import org.usfirst.frc.team818.robot.commands.IntakeUpCommand;
import org.usfirst.frc.team818.robot.commands.LimitedDriveCommand;
import org.usfirst.frc.team818.robot.commands.ShiftLowCommand;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

public class OI {

	private Joystick leftStick, rightStick, gamepad;
	public JoystickButton speedLimit, dynamicBraking, shiftGear, armadilloDrive, elevatorSwitch, elevatorBottom,
			gamepad3, elevatorScale, intakeIn, intakeOut, intakeUp, intakeDown, climberDrop, climberSpin;

	public OI() {

		// Instantiating Joysticks
		leftStick = new Joystick(Constants.leftJoystickPort);
		rightStick = new Joystick(Constants.rightJoystickPort);
		gamepad = new Joystick(Constants.gamepadPort);

		// Instantiating Buttons
		speedLimit = new JoystickButton(leftStick, 1); // will be speed limit override
		dynamicBraking = new JoystickButton(leftStick, 2);
		shiftGear = new JoystickButton(rightStick, 1);
		armadilloDrive = new JoystickButton(rightStick, 2);
		elevatorSwitch = new JoystickButton(gamepad, 1);
		elevatorBottom = new JoystickButton(gamepad, 2);
		gamepad3 = new JoystickButton(gamepad, 3); // currently unused, will be probably backDrive
		elevatorScale = new JoystickButton(gamepad, 4);
		intakeIn = new JoystickButton(gamepad, 5);
		intakeOut = new JoystickButton(gamepad, 6);
		intakeUp = new JoystickButton(gamepad, 7);
		intakeDown = new JoystickButton(gamepad, 8);
		climberDrop = new JoystickButton(gamepad, 9);
		climberSpin = new JoystickButton(gamepad, 10);

		// Buttons
		speedLimit.whenPressed(new LimitedDriveCommand());
		dynamicBraking.whileHeld(new DynamicBraking());
		shiftGear.toggleWhenPressed(new ShiftLowCommand());
		armadilloDrive.whenPressed(new ArmadilloDrive());
		intakeIn.whileHeld(new IntakeInCommand());
		intakeOut.whileHeld(new IntakeOutCommand());
		intakeUp.whenPressed(new IntakeUpCommand());
		intakeDown.whenPressed(new IntakeDownCommand());

		// Climber can only run in the last 30 seconds
		try {
			if (DriverStation.getInstance().getMatchTime() <= 30) {
				climberDrop.whenPressed(new ClimberDropCommand());
				climberSpin.whileHeld(new ClimberSpinCommand());
			}
		} catch (Exception e) {
			climberDrop.whenPressed(new ClimberDropCommand());
			climberSpin.whileHeld(new ClimberSpinCommand());
		}
	}

	// Elevator Configurations
	public boolean getElevatorBottom() {
		return elevatorBottom.get();
	}

	public boolean getElevatorSwitch() {
		return elevatorSwitch.get();
	}

	public boolean getElevatorScale() {
		return elevatorScale.get();
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

}
