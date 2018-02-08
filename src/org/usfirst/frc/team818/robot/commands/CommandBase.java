package org.usfirst.frc.team818.robot.commands;

import org.usfirst.frc.team818.robot.Constants;
import org.usfirst.frc.team818.robot.OI;
import org.usfirst.frc.team818.robot.subsystems.ClimberSubsystem;
import org.usfirst.frc.team818.robot.subsystems.DriveSubsystem;
import org.usfirst.frc.team818.robot.subsystems.ElevatorSubsystem;
import org.usfirst.frc.team818.robot.subsystems.IntakeSubsystem;

import edu.wpi.first.wpilibj.command.Command;


public abstract class CommandBase extends Command {

	public static OI oi;
	
	public static DriveSubsystem drive;
	
	public static ElevatorSubsystem elevator;
	
	public static ClimberSubsystem climb;
	
	public static IntakeSubsystem intake;
	
	public static void init() {
		
		drive = new DriveSubsystem(Constants.leftMotorPorts, Constants.rightMotorPorts, Constants.gyroDrivePort, 
				Constants.leftEncoderPorts, Constants.rightEncoderPorts, Constants.driveEnabled);
		
		elevator = new ElevatorSubsystem(Constants.elevatorMotorPort, Constants.ultrasonicOutPort, Constants.ultrasonicInPort, Constants.elevatorEnabled);
		climb = new ClimberSubsystem(Constants.climberMotorPort, Constants.climberPistonPorts, Constants.climberEnabled);
		intake = new IntakeSubsystem(Constants.intakeLeftMotorPort, Constants.intakeRightMotorPort, Constants.intakeEnabled);
		
		oi = new OI();
	}
	
	public static void disable() {
		drive.setBoth(0);
	}
	
}