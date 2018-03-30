package org.usfirst.frc.team818.robot.commands.components;

import org.usfirst.frc.team818.robot.Constants;
import org.usfirst.frc.team818.robot.commands.CommandBase;
import org.usfirst.frc.team818.robot.utilities.MathUtil;
import org.usfirst.frc.team818.robot.utilities.RobotLog;

import edu.wpi.first.wpilibj.Timer;

public class Drive4Distance extends CommandBase {

	double distance, distanceToTravel, pLeft, pRight, leftDistance, rightDistance;
	Timer timer;
	Timer tarTimer;
	
	public Drive4Distance(double distanceToTravel) {
		requires(drive);
		timer = new Timer();
		tarTimer = new Timer();
		this.distanceToTravel = distanceToTravel;
	}
	
	protected void initialize() {
		
		RobotLog.putMessage("Running Drive4Distance: " + distanceToTravel);
		
		distance = distanceToTravel * Constants.distanceToTickRatio / Constants.gearRatioHigh;
		drive.setBoth(0);
		drive.resetBothEncoders();
		drive.resetGyro();
		timer.start();
		tarTimer.start();
		
		pLeft = 0;
		pRight = 0;

		drive.enablePID("driveDistance");
		drive.setRotatePoint(0);
		drive.setDistanceSetpoint(distance);
	}

	protected void execute() {
		pLeft = drive.getPIDOutputLeft();
		pRight = MathUtil.setLimits(drive.getPIDOutputRight() - drive.getPIDOutputGyro(), -1, 1);
		drive.setBoth(pLeft * 0.4, pRight * 0.4);
	}

	protected boolean isFinished() {
		if (drive.distanceOnTarget()) {
			return tarTimer.hasPeriodPassed(0.5);
		} else {
			tarTimer.reset();
			return timer.hasPeriodPassed(3);
		}
		//return (timer.hasPeriodPassed(5) || Math.abs((drive.getLeftRotation() + drive.getRightRotation())/2) > (distance/Constants.cycleDistance)/Constants.encoderGearRatioHigh);

	}

	protected void end() {
		RobotLog.putMessage("Finished Drive4Distance: " + distanceToTravel);
		RobotLog.putMessage("Distance traveled: " + ( (drive.getLeftRotation() + drive.getRightRotation()) / 2) * Constants.gearRatioHigh/Constants.distanceToTickRatio);
		drive.setBoth(0);
		drive.disablePID();
	}

	protected void interrupted() {
		RobotLog.putMessage("Interrupted Drive4Distance: " + distanceToTravel);
		drive.setBoth(0);
		drive.disablePID();
	}
}
