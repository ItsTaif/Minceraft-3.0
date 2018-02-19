package org.usfirst.frc.team818.robot.autonomi;

public class Target {
	
	String targetLocation;
	int targetNumber;
	
	Target(){
		targetLocation = "none";
		targetNumber = -1;
	}
	
	Target(String targetLocation, int targetNumber){
		this.targetLocation = targetLocation;
		this.targetNumber = targetNumber;
	}

}
