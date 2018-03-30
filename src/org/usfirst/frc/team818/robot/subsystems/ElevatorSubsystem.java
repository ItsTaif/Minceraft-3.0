package org.usfirst.frc.team818.robot.subsystems;

import org.usfirst.frc.team818.robot.commands.ElevatorCommand;
import org.usfirst.frc.team818.robot.utilities.RobotLog;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.command.Subsystem;

public class ElevatorSubsystem extends Subsystem {

	TalonSRX elevatorMotor1, elevatorMotor2;
	Encoder elevatorEncoder;
	double setpoint;

	private static final double[] ELEVATOR_PID_VALUES = { 0.1, 0, 0 };
	private static final double[] ELEVATOR_PID_RANGE = { -1, 1 };

	private boolean elevatorEnabled;

	public ElevatorSubsystem(int elevatorMotorPorts[], int[] elevatorEncoderPorts,
			double elevatorDistance, boolean elevatorEnabled) {

		this.elevatorEnabled = elevatorEnabled;
		if (elevatorEnabled) {
			elevatorMotor1 = new WPI_TalonSRX(elevatorMotorPorts[0]);
			elevatorMotor2 = new WPI_TalonSRX(elevatorMotorPorts[1]);

			// Second ElevatorMotor set to follow first and set to inverted
			elevatorMotor2.follow(elevatorMotor1);
			elevatorMotor2.setInverted(true);
			elevatorMotor1.setNeutralMode(NeutralMode.Coast);
			elevatorMotor2.setNeutralMode(NeutralMode.Coast);

			elevatorMotor1.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative, 0, 0);

			elevatorMotor1.configNominalOutputForward(0, 0);
			elevatorMotor1.configNominalOutputReverse(0, 0);
			elevatorMotor1.configPeakOutputForward(ELEVATOR_PID_RANGE[1], 0);
			elevatorMotor1.configPeakOutputReverse(ELEVATOR_PID_RANGE[0], 0);

			elevatorMotor1.config_kP(0, ELEVATOR_PID_VALUES[0], 0);
			elevatorMotor1.config_kI(0, ELEVATOR_PID_VALUES[1], 0);
			elevatorMotor1.config_kD(0, ELEVATOR_PID_VALUES[2], 0);

		}
	}

	public void initDefaultCommand() {
		if (elevatorEnabled)
			setDefaultCommand(new ElevatorCommand());
	}

	public double getPosition() {
		return (elevatorEnabled) ? elevatorMotor1.getSensorCollection().getQuadraturePosition() : 0;
	}

	public void set(double speed) {
		if (elevatorEnabled) {
			elevatorMotor1.set(ControlMode.PercentOutput, speed);
		}
	}

	public void hold() {
		if (elevatorEnabled) {
			elevatorMotor1.set(ControlMode.Position, setpoint);
		}
	}

	public void setSetpoint(double setpoint) {
		if (elevatorEnabled)
			this.setpoint = setpoint;
	}

	public void getCurrent() {
		RobotLog.putMessage("1 " + elevatorMotor1.getOutputCurrent() + "  2 " + elevatorMotor2.getOutputCurrent());
	}

}
