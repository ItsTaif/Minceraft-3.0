package org.usfirst.frc.team818.robot.commands.components;

import org.usfirst.frc.team818.robot.commands.CommandBase;
import org.usfirst.frc.team818.robot.utilities.MathUtil;
import org.usfirst.frc.team818.robot.utilities.RobotLog;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class TurnAngle extends CommandBase {

	public double angle;
	private double speed;
	private Timer timer, tTimer;

	public TurnAngle(double angle, double speedTurn) {
		requires(drive);
		this.angle = angle;
		speed = speedTurn;
		timer = new Timer();
		tTimer = new Timer();
	}

	public TurnAngle(double angle) {
		requires(drive);
		this.angle = angle;
		timer = new Timer();
		tTimer = new Timer();
		this.speed = 0.3;

	}

	protected void initialize() {
		angle = (angle < 0 ) ? 360- Math.abs(angle % 360) : angle ;
		RobotLog.putMessage("Running TurnAngle: " + angle);
		drive.resetGyro();
		drive.enablePID("rotate");
//		drive.setRotatePID(SmartDashboard.getNumber("Left Scale", 0	), SmartDashboard.getNumber("delay", 0), SmartDashboard.getNumber("Right Scale", 0));
		drive.setRotatePoint(angle);
		
		timer.start();
		tTimer.start();
	}

	protected void execute() {

		speed = (drive.getPIDOutputGyro() > 0)? MathUtil.limitMin(drive.getPIDOutputGyro(), 0.23) : MathUtil.limitMax(drive.getPIDOutputGyro(), -0.23) ;
		drive.setBoth(speed, -speed);

	}

	protected boolean isFinished() {
		if (drive.rotateOnTarget(angle)) {
			return timer.hasPeriodPassed(0.25);
		} else {
			timer.reset();
			return false;//tTimer.hasPeriodPassed(1.5);
		}

	}

	protected void end() {

		RobotLog.putMessage("Finished TurnAngle: " + angle);
		timer.stop();
		drive.setRotatePoint(0);
		drive.disablePID();
		drive.setBoth(0, 0);

	}

	protected void interrupted() {

		RobotLog.putMessage("Interrupted TurnAngle: " + angle);
		timer.stop();
		drive.setRotatePoint(0);
		drive.disablePID();
		drive.setBoth(0, 0);
	}
}
