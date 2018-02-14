package org.usfirst.frc.team818.robot.autonomi;

import java.util.LinkedList;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class PriorityList {

	private static LinkedList<Target> priority = new LinkedList<>();

	private static String[] targets = { "Left Scale", "Right Scale", "Left Switch", "Right Switch" };

	public PriorityList() {

		for (int i = 0; i < 4; i++) {

			if ((int) SmartDashboard.getNumber(targets[i], 0) > 0) {

				try {

					priority.add((int) SmartDashboard.getNumber(targets[i], 0) - 1, new Target(targets[i], i + 1));

				} catch (Exception e) {

					priority.addLast(new Target(targets[i], 1));
				}

			}

		}

	}

	public LinkedList<Target> getPriority() {
		return priority;
	}

}
