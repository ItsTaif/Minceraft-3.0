/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team818.robot;

import org.usfirst.frc.team818.robot.autonomi.Baseline;
import org.usfirst.frc.team818.robot.commands.CommandBase;
import org.usfirst.frc.team818.robot.utilities.RobotLog;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Robot extends TimedRobot {

	Command m_autonomousCommand;
	SendableChooser<Command> m_chooser = new SendableChooser<>();

	public void robotInit() {
		
		CommandBase.init();
		RobotLog.init();
//		chooser.addObject("My Auto", new MyAutoCommand());
//		SmartDashboard.putData("Auto mode", m_chooser);
		
	}

	public void disabledInit() {

	}

	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}

	public void autonomousInit() {
		//m_autonomousCommand = AutonomousSelector.getSelectedAutonomous();
		m_autonomousCommand = new Baseline();
		/*
		 * String autoSelected = SmartDashboard.getString("Auto Selector",
		 * "Default"); switch(autoSelected) { case "My Auto": autonomousCommand
		 * = new MyAutoCommand(); break; case "Default Auto": default:
		 * autonomousCommand = new ExampleCommand(); break; }
		 */

		// schedule the autonomous command (example)
		if (m_autonomousCommand != null) {
			m_autonomousCommand.start();
		}
	}

	public void autonomousPeriodic() {
		SmartDashboard.putNumber("Gyro", CommandBase.drive.getAngle());
		SmartDashboard.putString("RobotLog", "L:" + CommandBase.drive.getLeftRotation()+" R:"+CommandBase.drive.getRightRotation());
		System.out.println("Gyro: " +  CommandBase.drive.getAngle());
		System.out.println("L: " + CommandBase.drive.getLeftRotation()+" R: "+CommandBase.drive.getRightRotation());
		Scheduler.getInstance().run();
	}

	public void teleopInit() {
		if (m_autonomousCommand != null) {
			m_autonomousCommand.cancel();
		}
		RobotLog.putMessage("Delay is " + SmartDashboard.getNumber("Delay", 0.0));
		System.out.println("Delay is " + SmartDashboard.getNumber("Delay", 0.0));
	}

	public void teleopPeriodic() {
		SmartDashboard.putNumber("Gyro", CommandBase.drive.getAngle());
		SmartDashboard.putString("RobotLog", "L:" + CommandBase.drive.getLeftRotation()+" R:"+CommandBase.drive.getRightRotation());
		Scheduler.getInstance().run();
	}

	public void testPeriodic() {
	}
}
