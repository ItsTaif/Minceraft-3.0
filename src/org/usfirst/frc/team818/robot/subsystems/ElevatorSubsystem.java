package org.usfirst.frc.team818.robot.subsystems;

import org.usfirst.frc.team818.robot.commands.ElevatorCommand;
import org.usfirst.frc.team818.robot.utilities.DoublePIDOutput;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.PIDSourceType;
import edu.wpi.first.wpilibj.command.Subsystem;

public class ElevatorSubsystem extends Subsystem {

	TalonSRX elevatorMotor1, elevatorMotor2;
	Encoder elevatorEncoder;
	DigitalInput limitBottom, limitTop;

	private static final double[] ELEVATOR_PID_VALUES = { 0.01, 0.001, 0 };
	private static final double[] ELEVATOR_PID_RANGE = { -1, 1 };

	private PIDController elevatorController;
	private DoublePIDOutput pidOutputElevator;

	private boolean elevatorEnabled;

	public ElevatorSubsystem(int elevatorMotorPort1, int elevatorMotorPort2, int[] elevatorEncoderPorts, int limitSwitchPortTop, int limitSwitchPortBottom, double elevatorDistance, boolean elevatorEnabled) {

		this.elevatorEnabled = elevatorEnabled;
		if (elevatorEnabled) {
			elevatorMotor1 = new WPI_TalonSRX(elevatorMotorPort1);
			elevatorMotor2 = new WPI_TalonSRX(elevatorMotorPort2);
			
			//As of the time of writing, there are no limit switches
			//limitBottom = new DigitalInput(limitSwitchPortBottom);
			//limitTop = new DigitalInput(limitSwitchPortTop);
					
			elevatorMotor1.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative, 0, 0);
			
			
			elevatorEncoder = new Encoder(elevatorEncoderPorts[0], elevatorEncoderPorts[1]);
			elevatorEncoder.setDistancePerPulse(elevatorDistance);
				elevatorEncoder.setPIDSourceType(PIDSourceType.kDisplacement);
	
			pidOutputElevator = new DoublePIDOutput();
	
			elevatorController = new PIDController(ELEVATOR_PID_VALUES[0], ELEVATOR_PID_VALUES[1],
					ELEVATOR_PID_VALUES[2], elevatorEncoder, pidOutputElevator);
			elevatorController.setOutputRange(ELEVATOR_PID_RANGE[0], ELEVATOR_PID_RANGE[1]);
			elevatorController.setInputRange(Double.MAX_VALUE, Double.MIN_VALUE);
			elevatorController.setSetpoint(0);
			elevatorController.setContinuous(false);
		}
	}

	public void initDefaultCommand() {
		if(elevatorEnabled)
		setDefaultCommand(new ElevatorCommand());
	}

	public void set(double speed) {
		if (elevatorEnabled) {
			elevatorMotor1.set(ControlMode.PercentOutput,speed);
			elevatorMotor2.set(ControlMode.PercentOutput,speed);			
		}
	}
	
	public double getDistance(){
		return elevatorEncoder.getDistance();
	}
	
	public boolean reachedBottom(){
		return false;
		//return limitBottom.get();
	}
	
	public boolean reachedTop(){
		return false;
		//return limitTop.get();
	}
	
	public void setSetpoint(double setpoint){
		if (elevatorEnabled) 	
			elevatorController.setSetpoint(setpoint);
	}
	
	public boolean isPIDEnabled(){
		return elevatorController.isEnabled();
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
