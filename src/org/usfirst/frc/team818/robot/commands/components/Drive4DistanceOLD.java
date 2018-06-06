package org.usfirst.frc.team818.robot.commands.components;

import org.usfirst.frc.team818.robot.Constants;
import org.usfirst.frc.team818.robot.commands.CommandBase;
import org.usfirst.frc.team818.robot.utilities.RobotLog;

import edu.wpi.first.wpilibj.Timer;

public class Drive4DistanceOLD extends CommandBase {

	double d, speed, targetSpeed;
	int leftTicks, rightTicks;
	double pLeft, pRight;
	Timer timee;

	
	public Drive4DistanceOLD(double speed, double distance) {
		requires(drive);
		timee = new Timer();
		d = distance;
		this.speed = speed;
		// speed = 0;
		if (d < 0) {
			this.speed = -speed;
		}
	}

	public Drive4DistanceOLD(double distance) {
		requires(drive);
		timee = new Timer();
		d = distance;
		speed = 0.4;
		// speed = 0;
		if (d < 0) {
			speed = -0.4;
		}
	}
	
	protected void initialize() {
		RobotLog.putMessage("Running Drive4Distance.");
		drive.setBoth(0);
		drive.resetBothEncoders();
		drive.resetGyro();
		timee.start();
		
		pLeft = 0;
		pRight = 0;

		drive.enablePID("rotate");
		drive.setRotatePoint(0);
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
	
		leftTicks = Math.abs(drive.getLeftRotation())/3;
		rightTicks = Math.abs(drive.getRightRotation())/3;
	
		pLeft = speed;
		pRight = speed;
		pLeft += drive.getPIDOutputGyro();
		drive.setBoth(pLeft, pRight);
	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		if (timee.hasPeriodPassed(2)
				|| (Math.abs(Constants.cycleDistance * ((leftTicks + rightTicks / 2) / 360)) >= Math.abs(d))) {
			return true;
		} else
			return false;
	}

	// Called once after isFinished returns true
	protected void end() {
		RobotLog.putMessage("Stopped driving.");
		drive.setBoth(0);
		drive.disablePID();
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted() {
		RobotLog.putMessage("Interrupted driving.");
		drive.setBoth(0);
		drive.disablePID();
	}
}
