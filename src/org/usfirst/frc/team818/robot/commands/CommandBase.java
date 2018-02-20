package org.usfirst.frc.team818.robot.commands;

import org.usfirst.frc.team818.robot.Constants;
import org.usfirst.frc.team818.robot.OI;
import org.usfirst.frc.team818.robot.subsystems.ClimberSubsystem;
import org.usfirst.frc.team818.robot.subsystems.CompressorSubsystem;
import org.usfirst.frc.team818.robot.subsystems.DriveSubsystem;
import org.usfirst.frc.team818.robot.subsystems.ElevatorSubsystem;
import org.usfirst.frc.team818.robot.subsystems.IntakeSubsystem;
import org.usfirst.frc.team818.robot.subsystems.ShifterSubsystem;

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
	
	public static void init() {
		
		climber = new ClimberSubsystem(Constants.climberMotorPort, Constants.rClimberPistonPort, Constants.dClimberPistonPort, Constants.climberEnabled);
		compressor = new CompressorSubsystem(Constants.compressorEnabled);
		drive = new DriveSubsystem(Constants.leftMotorPorts, Constants.rightMotorPorts, Constants.gyroDrivePort, 
				Constants.leftEncoderPorts, Constants.rightEncoderPorts, Constants.driveEnabled);
		
		elevator = new ElevatorSubsystem(Constants.elevatorMotorPort1, Constants.elevatorMotorPort2, Constants.ultrasonicOutPort, Constants.ultrasonicInPort, Constants.limitSwitchPortTop, Constants.limitSwitchPortBottom, Constants.elevatorEnabled);
		intake = new IntakeSubsystem(Constants.intakeLeftMotorPort, Constants.intakeRightMotorPort, Constants.intakeArmMotorPort, Constants.limitSwitchPortIntakeUp, Constants.limitSwitchPortIntakeDown, Constants.limitSwitchPortIntakeCube, Constants.intakeEnabled);
		shifter = new ShifterSubsystem(Constants.shifterLeftPistonPorts, Constants.shifterRightPistonPorts, Constants.shifterEnabled);
	
		oi = new OI();
		
		compressor.startCompressor();
		shifter.highGear();
	}
	
	public static void disable() {
		drive.setBoth(0);
	}
	
}