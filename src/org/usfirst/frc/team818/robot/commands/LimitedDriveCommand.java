package org.usfirst.frc.team818.robot.commands;

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
		drive.setBoth(oi.getLeftY() * (12/17), oi.getRightY() * (12/17));
		//drive.setVelocity(oi.getLeftY() * Constants.speedLimit, oi.getRightY() * Constants.speedLimit);
		//drive.setBoth(drive.getPIDOutputSpeedLimitLeft(), drive.getPIDOutputSpeedLimitRight());
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
