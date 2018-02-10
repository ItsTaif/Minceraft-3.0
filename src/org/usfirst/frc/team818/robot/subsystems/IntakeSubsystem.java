/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team818.robot.subsystems;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;

public class IntakeSubsystem extends Subsystem {

	private Talon intakeL, intakeR;
	private DoubleSolenoid intakePiston;
	private boolean intakeEnabled;

	public IntakeSubsystem(int intakeLMotorPort, int intakeRMotorPort, int[] intakePistonPorts, boolean intakeEnabled) {
	
		this.intakeEnabled = intakeEnabled;

		if (intakeEnabled) {
			intakeL = new Talon(intakeLMotorPort);
			intakeR = new Talon(intakeRMotorPort);
			intakePiston = new DoubleSolenoid(intakePistonPorts[0], intakePistonPorts[1]);
		}
	}

	public void initDefaultCommand() {
		// Set the default command for a subsystem here.
		// setDefaultCommand(new MySpecialCommand());
	}
	
	public void intakeIn() {
		if (intakeEnabled) {
			intakeL.set(0.5);
			intakeR.set(-0.5);
		}
	}
	
	public void intakeOut() {
		if (intakeEnabled) {
			intakeL.set(-0.5);
			intakeR.set(0.5);
		}
	}
	
	public void intakeOff() {
		if (intakeEnabled) {
			intakeL.set(0);
			intakeR.set(0);
		}
	}
	
	public void intakeSetSpeed(double speed) {
		if (intakeEnabled) {
			intakeL.set(speed);
			intakeR.set(-speed);
		}
	}
	
	public void intakeDown() {
    	if(intakeEnabled) {
    		intakePiston.set(DoubleSolenoid.Value.kForward);	
    	}
    }
    
    public void intakeUp() {
    	if(intakeEnabled) {
    		intakePiston.set(DoubleSolenoid.Value.kReverse);
    	}
    }
    
    public void intakeVertOff() {
    	if(intakeEnabled) {
    		intakePiston.set(DoubleSolenoid.Value.kOff);
    	}
    }

}
