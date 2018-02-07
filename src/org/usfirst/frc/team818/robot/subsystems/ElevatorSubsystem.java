package org.usfirst.frc.team818.robot.subsystems;

import org.usfirst.frc.team818.robot.commands.DriveCommand;
import org.usfirst.frc.team818.robot.utilities.DoublePIDOutput;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.Ultrasonic;
import edu.wpi.first.wpilibj.command.Subsystem;

public class ElevatorSubsystem extends Subsystem {

	TalonSRX elevatorMotor;
	Ultrasonic ultra;

	private static final double[] ELEVATOR_PID_VALUES = { 0.01, 0.001, 0 };
	private static final double[] ELEVATOR_PID_RANGE = { -1, 1 };

	private PIDController elevatorController;
	private DoublePIDOutput pidOutputElevator;

	private boolean elevatorEnabled;

	public ElevatorSubsystem(int elevatorMotorPort, int ultraSonicSensorPortOut, int ultraSonicSensorPortIn, boolean elevatorEnabled) {

		this.elevatorEnabled = elevatorEnabled;

		if (elevatorEnabled) {
			elevatorMotor = new WPI_TalonSRX(elevatorMotorPort);
			
			ultra = new Ultrasonic(ultraSonicSensorPortOut, ultraSonicSensorPortIn);
		}

		pidOutputElevator = new DoublePIDOutput();

		elevatorController = new PIDController(ELEVATOR_PID_VALUES[0], ELEVATOR_PID_VALUES[1],
				ELEVATOR_PID_VALUES[2], ultra, pidOutputElevator);
		elevatorController.setOutputRange(ELEVATOR_PID_RANGE[0], ELEVATOR_PID_RANGE[1]);
		elevatorController.setInputRange(Double.MAX_VALUE, Double.MIN_VALUE);
		elevatorController.setSetpoint(0);
		elevatorController.setContinuous(false);
	}

	public void initDefaultCommand() {
		setDefaultCommand(new DriveCommand());
	}

	public void set(double speed) {
		if (elevatorEnabled) 
			elevatorMotor.set(ControlMode.PercentOutput,speed);
	}
	
	public void setSetpoint(double setpoint){
		if (elevatorEnabled) 	
			elevatorController.setSetpoint(setpoint);
	}
	
	public void enablePID() {
		if (elevatorEnabled) 
			if (!elevatorController.isEnabled())
				elevatorController.enable();
	}

	public void disablePID() {
		if (elevatorEnabled)
			if (elevatorController.isEnabled())
				elevatorController.disable();
	}

	public double getPIDOutputElevator() {
		return (elevatorEnabled) ? pidOutputElevator.get() : 0;
	}

}
