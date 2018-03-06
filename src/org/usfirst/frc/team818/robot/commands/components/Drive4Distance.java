package org.usfirst.frc.team818.robot.commands.components;

import org.usfirst.frc.team818.robot.commands.CommandBase;
import org.usfirst.frc.team818.robot.utilities.MathUtil;

import edu.wpi.first.wpilibj.Timer;

public class Drive4Distance extends CommandBase {

	double distance, pLeft, pRight, leftDistance, rightDistance;
	Timer timer;

	public Drive4Distance(double distance) {
		requires(drive);
		timer = new Timer();
		this.distance = distance;
	}
	
	protected void initialize() {
		drive.setBoth(0);
		drive.resetBothEncoders();
		drive.resetGyro();
		timer.start();
		
		pLeft = 0;
		pRight = 0;

		drive.enablePID("driveDistance");
		drive.setRotatePoint(0);
		drive.setDistanceSetpoint(distance);
	}

	protected void execute() {
		pLeft = drive.getPIDOutputLeft();
		pRight = MathUtil.setLimits(drive.getPIDOutputRight() - drive.getPIDOutputGyro(), -1, 1);
		drive.setBoth(pLeft, pRight);
	}

	protected boolean isFinished() {
		return (timer.hasPeriodPassed(5) || drive.distanceOnTarget());

	}

	protected void end() {
		drive.setBoth(0);
		drive.disablePID();
	}

	protected void interrupted() {
		drive.setBoth(0);
		drive.disablePID();
	}
}
