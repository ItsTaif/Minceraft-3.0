package org.usfirst.frc.team818.robot.commands;

import org.usfirst.frc.team818.robot.Constants;
import org.usfirst.frc.team818.robot.OI;
import org.usfirst.frc.team818.robot.subsystems.CompressorSubsystem;
import org.usfirst.frc.team818.robot.subsystems.DriveSubsystem;
import org.usfirst.frc.team818.robot.subsystems.ElevatorSubsystem;
import org.usfirst.frc.team818.robot.subsystems.IntakeSubsystem;
import org.usfirst.frc.team818.robot.subsystems.ShifterSubsystem;
import org.usfirst.frc.team818.robot.subsystems.WristSubsystem;

import edu.wpi.first.wpilibj.command.Command;

public abstract class CommandBase extends Command {

	public static OI oi;
	public static CompressorSubsystem compressor;
	public static DriveSubsystem drive;
	public static ElevatorSubsystem elevator;
	public static IntakeSubsystem intake;
	public static ShifterSubsystem shifter;
	public static WristSubsystem wrist;


	public static void init() {

		compressor = new CompressorSubsystem(Constants.compressorEnabled);
		drive = new DriveSubsystem(Constants.leftMotorPorts, Constants.rightMotorPorts, Constants.gyroDrivePort,
				Constants.leftEncoderPorts, Constants.rightEncoderPorts, Constants.driveEnabled);

		elevator = new ElevatorSubsystem(Constants.elevatorMotorPorts,
				Constants.elevatorEncoderPorts, Constants.elevatorDistance, Constants.elevatorEnabled);
		intake = new IntakeSubsystem(Constants.intakeMotorPorts, Constants.limitSwitchPortIntakeCube,
				Constants.intakeEnabled);
		shifter = new ShifterSubsystem(Constants.shifterPistonPorts, Constants.shifterEnabled);
		wrist = new WristSubsystem(Constants.wristMotorPort, Constants.wristEncoderPorts, Constants.wristEnabled);
		oi = new OI();

		compressor.startCompressor();
		shifter.highGear();
		
	}

	public static void disable() {
		drive.setBoth(0);
	}

}