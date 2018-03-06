package org.usfirst.frc.team818.robot.commands.components;

import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.PIDSource;
import edu.wpi.first.wpilibj.PIDSourceType;

public class MotorCurrent implements PIDSource{
	
	double averageCurrent;
	
	public MotorCurrent(TalonSRX[] motors) {
		double val = 0.0;
		for (TalonSRX t : motors) {
			val += t.getOutputCurrent();
		}
		averageCurrent = val/motors.length;
	}

	@Override
	public void setPIDSourceType(PIDSourceType pidSource) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public PIDSourceType getPIDSourceType() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public double pidGet() {
		// TODO Auto-generated method stub
		return averageCurrent;
	}

}
