package org.usfirst.frc.team818.robot;

public class Constants {

	public static final boolean climberEnabled = false;
	public static final boolean compressorEnabled = true;
	public static final boolean driveEnabled = true;
	public static final boolean elevatorEnabled = false;
	public static final boolean intakeEnabled = false;
	public static final boolean shifterEnabled = true;
	public static final boolean climberTimeEnabled = false;

	// Robot Dimensions
	public static final double robotHalfWidth = 18 / 2;//needs to be corrected
	public static final double robotHalfLength = 18 / 2;//needs to be corrected
	public static final double midPositionShift = 18;//needs to be corrected
	
	// Joystick Ports
	public static final int leftJoystickPort = 0;
	public static final int rightJoystickPort = 1;
	public static final int gamepadPort = 2;

	// Used in Climber Subsystem
	public static final int climberMotorPort = 12;
	public static final int[] rClimberPistonPort = { 4, 5 };
	public static final int[] dClimberPistonPort = { 6, 7 };

	// Used in Drive Subsystem
	public static final int[] leftMotorPorts = { 1, 3, 5 }; // done
	public static final int[] rightMotorPorts = { 2, 4, 6 }; // done
	public static final int gyroDrivePort = 0;

	public static final int[] leftEncoderPorts = { 3, 4 };
	public static final int[] rightEncoderPorts = { 1, 2 };

	public static final int wheelRadius = 3;
	public static final int encoderGearRatioHigh = 6; // need to check between low gear and high gear
	public static final int encoderGearRatioLow = 23; // need to check between low gear and high gear
	public static final double cycleDistance = (2 * wheelRadius * Math.PI / 360);
	public static final int speedLimit = 156; // in inches
	public static final double slipVal = 111.1;

	// Used in Elevator Subsystem
	public static final int elevatorMotorPort1 = 8;
	public static final int elevatorMotorPort2 = 10;
	public static final int[] elevatorEncoderPorts = { 1, 2 };//needs to be corrected
	public static final int elevatorBottomPosition = 0;//needs to be corrected
	public static final int elevatorSwitchPosition = 0;//needs to be corrected
	public static final int elevatorScalePosition = 0;//needs to be corrected
	public static final int limitSwitchPortTop = 1;//needs to be corrected
	public static final int limitSwitchPortBottom = 2;//needs to be corrected
	public static final double elevatorDistance = 12/360;//needs to be corrected

	// Used in Intake SUbsystem
	public static final int intakeLeftMotorPort = 7;
	public static final int intakeRightMotorPort = 9;
	public static final int intakeArmMotorPort = 11;
	public static final int limitSwitchPortIntakeCube = 3;//needs to be corrected
	public static final int limitSwitchPortIntakeUp = 3;//needs to be corrected
	public static final int limitSwitchPortIntakeDown = 3;//needs to be corrected

	// Used in the Shifter Subsystem
	public static final int[] shifterPistonPorts = { 0, 1 };

}
