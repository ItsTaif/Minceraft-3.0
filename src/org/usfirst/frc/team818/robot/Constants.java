package org.usfirst.frc.team818.robot;

public class Constants {
	
	public static final boolean climberEnabled = true;
	public static final boolean compressorEnabled = true;
	public static final boolean driveEnabled = true;
	public static final boolean elevatorEnabled = true;
	public static final boolean intakeEnabled = true;
	public static final boolean shifterEnabled = true;
	public static final boolean exampleEnabled = false;
	
	//Joystick Ports
	public static final int leftJoystickPort = 0;
	public static final int rightJoystickPort = 1;
	public static final int gamepadPort = 2;
	
	//Used in Climber Subsystem
	public static final int climberMotorPort = 11;
	public static final int[] climberPistonPort = { 6, 7 };
	
	//Used in Drive Subsystem
	public static final int[] leftMotorPorts = { 1, 3, 5 }; //done
	public static final int[] rightMotorPorts = { 2, 4, 6 }; //done
	public static final int gyroDrivePort = 0;

	public static final int[] leftEncoderPorts = { 3, 4 };
	public static final int[] rightEncoderPorts = { 1, 2 };

	public static final int wheelRadius = 3;
	public static final int encoderGearRatio = 3;
	public static final double cycleDistance = 2 * wheelRadius * Math.PI / 360 / encoderGearRatio;
	public static final int speedLimit = 13;
	
	//Used in Elevator Subsystem
	public static final int elevatorMotorPort = 12;
	public static final int ultrasonicOutPort = 0;
	public static final int ultrasonicInPort = 0;
	public static final int elevatorBottomPosition = 0;
	public static final int elevatorSwitchPosition = 0;
	public static final int elevatorScalePosition = 0;
	
	//Used in Intake SUbsystem
	public static final int intakeLeftMotorPort = 7;
	public static final int intakeRightMotorPort = 8;
	public static final int[] intakePistonPorts = { 4, 5 };
	
	//Used in the Shifter Subsystem
	public static final int[] shifterLeftPistonPorts = { 2, 3 };
	public static final int[] shifterRightPistonPorts = { 0, 1 };
	
}
