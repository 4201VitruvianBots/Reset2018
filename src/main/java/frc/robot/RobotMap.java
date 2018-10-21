/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 * 
 * Team 4201 RobotMap Standards
 * We have a standard mapping scheme as a baseline to make our basic code 
 * poratable to new robots every year. This also allows us to ensure our
 * basic wiring is correct. 
 * 
 * For each address value, the left/positive value should always be an even
 * number if it is a paired value. For non-paired values, skip the next odd
 * number.
 * 
 * CAN ADDRESSES
 * 0-19: Major Modules
 * -> 0: PDP
 * -> 1-9: VRMs
 * -> 11-19: PCMs
 * 20-59: Motor Controllers
 * -> 20-29: DriveTrain Motors
 * -> 30-39: MechanismA
 * -> 40-49: MechanismB
 * -> 50-59: MechanismC
 * 
 */
public class RobotMap {
  // GLOBAL VARIABLES
  public static final int leftJoystick = 0;
	public static final int rightJoystick = 1;
  public static final int xBoxController = 2;
  
	// Joystick Constants
	public static final int leftTrigger = 2;
	public static final int rightTrigger = 3;

	// RoboRIO DIO Ports

  // RoboRIO Analog Ports

  // CAN ADDRESSES
  // Electrical Modules
  public static final int PDP = 0;
  public static final int VRMOne = 1;

  // Pneumatic Modules & their devices
  public static final int PCMOne = 11;
    public static final int driveTrainShifterForward = 0;
    public static final int driveTrainShifterReverse = 1;

  // Motor Controllers
	public static final int driveTrainLeftFront = 20;
	public static final int driveTrainLeftRear = 21;
	public static final int driveTrainRightFront = 22;
	public static final int driveTrainRightRear = 23;

  public void getIniValues() {

  }
}
