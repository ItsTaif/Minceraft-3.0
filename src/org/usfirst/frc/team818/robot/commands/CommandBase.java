package org.usfirst.frc.team818.robot.commands;

import org.usfirst.frc.team818.robot.Constants;
import org.usfirst.frc.team818.robot.OI;
import org.usfirst.frc.team818.robot.subsystems.DriveSubsystem;
import org.usfirst.frc.team818.robot.subsystems.ElevatorSubsystem;

import edu.wpi.first.wpilibj.command.Command;


public abstract class CommandBase extends Command {

	public static OI oi;
	
	public static DriveSubsystem drive;
	
	public static ElevatorSubsystem elevator;
	
	public static void init() {
		
		drive = new DriveSubsystem(Constants.leftMotorPorts, Constants.rightMotorPorts, Constants.gyroDrivePort, 
				Constants.leftEncoderPorts, Constants.rightEncoderPorts, Constants.driveEnabled);
		
		elevator = new ElevatorSubsystem(Constants.elevatorMotorPort, Constants.ultrasonicOutPort, Constants.ultrasonicInPort, Constants.elevatorEnabled);
		
		oi = new OI();
	}
	
	public static void disable() {
		drive.setBoth(0);
	}
	
}