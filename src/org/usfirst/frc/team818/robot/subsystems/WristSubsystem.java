/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team818.robot.subsystems;

import org.usfirst.frc.team818.robot.commands.WristRotateCommand;
import org.usfirst.frc.team818.robot.utilities.DoublePIDOutput;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.command.Subsystem;

public class WristSubsystem extends Subsystem {

	private TalonSRX intakeWrist;
	private Encoder wristEncoder;
	private boolean wristEnabled;
	
	private static final double[] WRIST_PID_VALUES = { 0.01, 0, 0.0 };
	private static final double[] WRIST_PID_RANGE = { -0.4, 0.4 };
	
	private PIDController wristController;
	private DoublePIDOutput wristOutput;

	public WristSubsystem(int intakeWristMotorPort, int[] encoderPorts, boolean wristEnabled) {

		this.wristEnabled = wristEnabled;

		if (wristEnabled) {
			intakeWrist = new WPI_TalonSRX(intakeWristMotorPort);
			wristEncoder = new Encoder(encoderPorts[0], encoderPorts[1]);
			wristOutput = new DoublePIDOutput();
			
			intakeWrist.setNeutralMode(NeutralMode.Brake);

			wristController = new PIDController(WRIST_PID_VALUES[0],
					WRIST_PID_VALUES[1], WRIST_PID_VALUES[2], wristEncoder, wristOutput);
			wristController.setOutputRange(WRIST_PID_RANGE[0], WRIST_PID_RANGE[1]);
			wristController.setInputRange(-Double.MAX_VALUE, Double.MAX_VALUE);
			wristController.setAbsoluteTolerance(1);
			wristController.setSetpoint(0);
			wristController.setContinuous(false);

		}
	}
	
	public void resetEncoder() {
		wristEncoder.reset();
	}
	
	public double getEncoderVal() {
		return wristEncoder.get();
	}
	
	public void disablePID() {
		wristController.disable();
	}
	
	public void enablePID() {
		wristController.enable();
	}
	
	public void setSetPoint(double d) {
		wristController.setSetpoint(d);
	}
	
	public double getPIDOutput() {
		return wristOutput.get();
	}
	
	public boolean isOnTarget() {
		return wristController.onTarget();
	}

	public void initDefaultCommand() {
		setDefaultCommand(new WristRotateCommand());
	}

	public void stopWrist() {
		if (wristEnabled) {
			intakeWrist.set(ControlMode.PercentOutput, 0);
		}
	}

	public void setWrist(double speed) {
		if (wristEnabled) {
			intakeWrist.set(ControlMode.PercentOutput, speed);

		}
	}

	public double getWristCurrent() {
		if (wristEnabled)
			return intakeWrist.getOutputCurrent();
		else
			return 0;
	}

}
