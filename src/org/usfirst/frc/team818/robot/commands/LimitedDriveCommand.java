package org.usfirst.frc.team818.robot.commands;

import org.usfirst.frc.team818.robot.Constants;

public class LimitedDriveCommand extends CommandBase {

	public LimitedDriveCommand() {
		requires(drive);
	}

	protected void initialize() {

		drive.setBoth(0);
		drive.resetBothEncoders();
		drive.enablePID("speedLimit");
	}

	protected void execute() {

		drive.setVelocity(oi.getLeftY() * Constants.speedLimit, oi.getRightY() * Constants.speedLimit);
		drive.setBoth(drive.getPIDOutputSpeedLimitLeft(), drive.getPIDOutputSpeedLimitRight());
	}

	protected boolean isFinished() {
		return false;
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
