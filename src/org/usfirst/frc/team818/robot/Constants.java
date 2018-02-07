package org.usfirst.frc.team818.robot;

public class Constants {
	
	public static final boolean driveEnabled = true;
	public static final boolean elevatorEnabled = true;
	public static final boolean exampleEnabled = false;
	
	public static final int leftJoystickPort = 0;
	public static final int rightJoystickPort = 1;
	public static final int gamepadPort = 2;

	public static final int[] leftMotorPorts = { 1, 3, 5 };
	public static final int[] rightMotorPorts = { 2, 4, 6 };
	public static final int gyroDrivePort = 0;

	public static final int[] leftEncoderPorts = { 2, 3 };
	public static final int[] rightEncoderPorts = { 0, 1 };

	public static final int wheelRadius = 3;
	public static final int encoderGearRatio = 3;
	public static final double cycleDistance = 2 * wheelRadius * Math.PI / 360 / encoderGearRatio;
	
	public static final int intakeLeftMotorPort = 7;
	public static final int intakeRMotorPort = 8;
	
	public static final int climberMotorPort = 11;

	public static final int elevatorMotorPort = 12;
	public static final int ultrasonicOutPort = 0;
	public static final int ultrasonicInPort = 0;
	public static final int elevatorVoltagePosition1 = 0;
	public static final int elevatorVoltagePosition2 = 0;
	public static final int elevatorVoltagePosition3 = 0;
	public static final int elevatorVoltagePosition4 = 0;
	
	public static final int exampleMotorPort = 818; // Example number
	
	public static final int speedLimit = 13;
	
}
