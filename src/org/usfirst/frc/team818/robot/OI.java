package org.usfirst.frc.team818.robot;

import org.usfirst.frc.team818.robot.commands.ArmadilloDrive;
import org.usfirst.frc.team818.robot.commands.DynamicBraking;
import org.usfirst.frc.team818.robot.commands.IntakeInCommand;
import org.usfirst.frc.team818.robot.commands.IntakeInCommand2;
import org.usfirst.frc.team818.robot.commands.IntakeOutCommand;
import org.usfirst.frc.team818.robot.commands.IntakeOutCommand2;
import org.usfirst.frc.team818.robot.commands.ShiftLowCommand;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.buttons.Trigger;

public class OI {

	private Joystick leftStick, rightStick, gamepad;
	public JoystickButton shiftGear, dynamicBraking, armadilloDrive, elevatorSwitch, elevatorBottom, gamepad3,
			elevatorScale, intakeIn, intakeOut, intakeOutSlow, intakeInSlow, climberRelease, climberDetatch, wristUp,
			wristMid, wristFlat, leftStick2;
	public Trigger up, mid, flat, allPressed;

	public OI() {

		// Instantiating Joysticks
		leftStick = new Joystick(0);
		rightStick = new Joystick(1);
		gamepad = new Joystick(2);

		// Instantiating Buttons
		dynamicBraking = new JoystickButton(leftStick, 1); // will be speed limit override
		leftStick2 = new JoystickButton(leftStick, 2);
		shiftGear = new JoystickButton(rightStick, 1);
		armadilloDrive = new JoystickButton(rightStick, 2);
		wristMid = new JoystickButton(gamepad, 1);
		wristFlat = new JoystickButton(gamepad, 2);
		gamepad3 = new JoystickButton(gamepad, 3); // currently unused, will be probably backDrive
		wristUp = new JoystickButton(gamepad, 4);
		intakeOut = new JoystickButton(gamepad, 5);
		intakeIn = new JoystickButton(gamepad, 6);
		intakeOutSlow = new JoystickButton(gamepad, 7);
		intakeInSlow = new JoystickButton(gamepad, 8);
		climberRelease = new JoystickButton(gamepad, 9);
		climberDetatch = new JoystickButton(gamepad, 10);

		up = new Trigger() {
			public boolean get() {
				return wristUp.get();
			}
		};

		mid = new Trigger() {
			public boolean get() {
				return wristMid.get();
			}
		};

		flat = new Trigger() {
			public boolean get() {
				return wristFlat.get();
			}
		};

		allPressed = new Trigger() {
			public boolean get() {
				return wristMid.get() || wristUp.get() || wristFlat.get();
			}
		};
		// Buttons
		shiftGear.toggleWhenPressed(new ShiftLowCommand());
		dynamicBraking.whileHeld(new DynamicBraking());
		armadilloDrive.whileHeld(new ArmadilloDrive());
		intakeIn.whileHeld(new IntakeInCommand());
		intakeOut.whileHeld(new IntakeOutCommand());
		intakeInSlow.whileHeld(new IntakeInCommand2());
		intakeOutSlow.whileHeld(new IntakeOutCommand2());

		// Triggers
		// up.whenActive(new IntakeUpCommand());
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
		return (Math.abs(leftStick.getX()) > 0.1) ? leftStick.getX() : 0;
	}

	public double getRightX() {
		return (Math.abs(rightStick.getX()) > 0.1) ? rightStick.getX() : 0;
	}

	public double getLeftZ() {
		return (Math.abs(leftStick.getZ()) > 0.1) ? leftStick.getZ() : 0;
	}

	public double getRightZ() {
		return (Math.abs(rightStick.getZ()) > 0.1) ? rightStick.getZ() : 0;
	}

	public double getGamepadLeftY() { // used for climber
		return (Math.abs(gamepad.getRawAxis(1)) > 0.1) ? -gamepad.getRawAxis(1) : 0;
	}

	public double getGamepadRightY() {
		return (Math.abs(gamepad.getRawAxis(3)) > 0.1) ? -gamepad.getRawAxis(3) : 0;
	}

	public double getGamepadLeftX() { // used for elevator
		return (Math.abs(gamepad.getRawAxis(0)) > 0.1) ? gamepad.getRawAxis(0) : 0;
	}

	public double getGamepadRightX() {
		return (Math.abs(gamepad.getRawAxis(2)) > 0.1) ? gamepad.getRawAxis(2) : 0;
	}

}
