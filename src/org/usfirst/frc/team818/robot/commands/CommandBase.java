package org.usfirst.frc.team818.robot.commands;

import org.usfirst.frc.team818.robot.Constants;
import org.usfirst.frc.team818.robot.OI;
import org.usfirst.frc.team818.robot.subsystems.ClimberSubsystem;
<<<<<<< HEAD
import org.usfirst.frc.team818.robot.subsystems.DriveSubsystem;
import org.usfirst.frc.team818.robot.subsystems.ElevatorSubsystem;
import org.usfirst.frc.team818.robot.subsystems.IntakeSubsystem;
=======
import org.usfirst.frc.team818.robot.subsystems.CompressorSubsystem;
import org.usfirst.frc.team818.robot.subsystems.DriveSubsystem;
import org.usfirst.frc.team818.robot.subsystems.ElevatorSubsystem;
import org.usfirst.frc.team818.robot.subsystems.IntakeSubsystem;
import org.usfirst.frc.team818.robot.subsystems.ShifterSubsystem;
>>>>>>> 6741f18bf254973e605257675392466ecc3a0414

import edu.wpi.first.wpilibj.command.Command;


public abstract class CommandBase extends Command {

	public static OI oi;
	public static ClimberSubsystem climber;
	public static CompressorSubsystem compressor;
	public static DriveSubsystem drive;
	public static ElevatorSubsystem elevator;
	public static IntakeSubsystem intake;
	public static ShifterSubsystem shifter;
	
	public static ClimberSubsystem climb;
	
	public static IntakeSubsystem intake;
	
	public static void init() {
		
		climber = new ClimberSubsystem(Constants.climberMotorPort, Constants.climberPistonPort, Constants.climberEnabled);
		compressor = new CompressorSubsystem(Constants.compressorEnabled);
		drive = new DriveSubsystem(Constants.leftMotorPorts, Constants.rightMotorPorts, Constants.gyroDrivePort, 
				Constants.leftEncoderPorts, Constants.rightEncoderPorts, Constants.driveEnabled);
<<<<<<< HEAD
		
		elevator = new ElevatorSubsystem(Constants.elevatorMotorPort, Constants.ultrasonicOutPort, Constants.ultrasonicInPort, Constants.elevatorEnabled);
		climb = new ClimberSubsystem(Constants.climberMotorPort, Constants.climberPistonPorts, Constants.climberEnabled);
		intake = new IntakeSubsystem(Constants.intakeLeftMotorPort, Constants.intakeRightMotorPort, Constants.intakeEnabled);
		
=======
		elevator = new ElevatorSubsystem(Constants.elevatorMotorPort, Constants.ultrasonicOutPort, Constants.ultrasonicInPort, Constants.limitSwitchPortTop, Constants.limitSwitchPortBottom, Constants.elevatorEnabled);
		intake = new IntakeSubsystem(Constants.intakeLeftMotorPort, Constants.intakeRightMotorPort, Constants.intakePistonPorts, Constants.limitSwitchPortIntake, Constants.intakeEnabled);
		shifter = new ShifterSubsystem(Constants.shifterLeftPistonPorts, Constants.shifterRightPistonPorts, Constants.shifterEnabled);
	
>>>>>>> 6741f18bf254973e605257675392466ecc3a0414
		oi = new OI();
		
		compressor.startCompressor();
		shifter.highGear();
	}
	
	public static void disable() {
		drive.setBoth(0);
	}
	
}