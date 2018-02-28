package org.usfirst.frc.team818.robot.subsystems;

import org.usfirst.frc.team818.robot.commands.ElevatorCommand;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.command.Subsystem;

public class ElevatorSubsystem extends Subsystem {

	TalonSRX elevatorMotor1, elevatorMotor2;
	DigitalInput limitBottom, limitTop, limitElevator, limitCarrage;

	private boolean elevatorEnabled;

	public ElevatorSubsystem(int elevatorMotorPort1, int elevatorMotorPort2, int limitSwitchPortTop, int limitSwitchPortBottom,int limitSwitchPortCarrage, int limitSwitchPortElevator, boolean elevatorEnabled) {

		this.elevatorEnabled = elevatorEnabled;
		if (elevatorEnabled) {
			elevatorMotor1 = new WPI_TalonSRX(elevatorMotorPort1);
			elevatorMotor2 = new WPI_TalonSRX(elevatorMotorPort2);
			
			limitBottom = new DigitalInput(limitSwitchPortBottom);
			limitTop = new DigitalInput(limitSwitchPortTop);
			limitElevator = new DigitalInput(limitSwitchPortElevator);
			limitCarrage = new DigitalInput(limitSwitchPortCarrage);
			
		}

	}

	public void initDefaultCommand() {
		setDefaultCommand(new ElevatorCommand());
	}

	public void set(double speed) {
		if (elevatorEnabled) {
			elevatorMotor1.set(ControlMode.PercentOutput,speed);
			elevatorMotor2.set(ControlMode.PercentOutput,speed);			
		}
	}
	
	public boolean triggerElevator() {
		return limitElevator.get();
	}
	
	public boolean triggerCarrage() {
		return limitCarrage.get();
	}
	
	public boolean reachedBottom(){
		return limitBottom.get();
	}
	
	public boolean reachedTop(){
		return limitTop.get();
	}

}
