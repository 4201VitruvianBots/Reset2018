
package frc.robot.subsystems;


import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import frc.robot.RobotMap;
import frc.vitruvianlib.drivers.FactoryTalonSRX;

/**
 * An example subsystem.  You can replace me with your own Subsystem.
 */
public class DriveTrain extends Subsystem {
	public static class DriveCommand {
		public double leftVoltage, rightVoltage;

		public DriveCommand(double leftVoltage, double rightVoltage) {
			this.leftVoltage = leftVoltage;
			this.rightVoltage = rightVoltage;
		}
	}

	public WPI_TalonSRX m_leftMaster = new WPI_TalonSRX(RobotMap.driveTrainLeftMaster);
	public WPI_TalonSRX m_leftSlave = new WPI_TalonSRX(RobotMap.driveTrainLeftSlave);
	public WPI_TalonSRX m_rightMaster = new WPI_TalonSRX(RobotMap.driveTrainRightMaster);
	public WPI_TalonSRX m_rightSlave = new WPI_TalonSRX(RobotMap.driveTrainRightSlave);
	DoubleSolenoid m_driveTrainShifters;
	
	DifferentialDrive robotDrive = new DifferentialDrive(m_leftMaster, m_rightMaster);

	public DriveTrain(){
		super("Drive Train");

		m_leftSlave.set(ControlMode.Follower, m_leftMaster.getDeviceID());
		m_rightSlave.set(ControlMode.Follower, m_rightMaster.getDeviceID());

		m_driveTrainShifters = new DoubleSolenoid(RobotMap.PCMOne, 
			RobotMap.driveTrainShifterForward, RobotMap.driveTrainShifterReverse);
		m_driveTrainShifters.setName("Shifters");
		m_driveTrainShifters.setSubsystem("Drive Train");
		LiveWindow.add(m_driveTrainShifters);
	}
	// Put methods for controlling the subsystem here. Call these from Commands.

	public int getLeftEncoderValue() {
		return m_leftMaster.getSelectedSensorPosition(0);
	}

	public int getRightEncoderValue() {
		return m_rightMaster.getSelectedSensorPosition(0);
	}

	public void setOpenLoopDriveCommand(DriveCommand dc) {
		robotDrive.tankDrive(dc.leftVoltage / 12.0, dc.rightVoltage / 12.0);
	}

	public static DriveCommand tankCommand(double left, double right) {
		return new DriveCommand(left*12, right*-12);
	}

	public static DriveCommand arcadeCommand(double turn, double forward) {
		double left = forward + turn;
		double right = forward - turn;
		if(left > 1) { left = 1; }
		else if(left < -1) { left = -1; }
		else if(right > 1) { right = 1; }
		else if(right < -1) { right = -1; }
		return new DriveCommand(left*-12, right*12);
	}

	public void driveTank(double left, double right) {
		this.setOpenLoopDriveCommand(DriveTrain.tankCommand(left, right));
	}

	public void driveArcade(double forward, double turn) {
		this.setOpenLoopDriveCommand(DriveTrain.arcadeCommand(forward, turn));
	}


	public void setDriveShiftHigh(){
		m_driveTrainShifters.set(Value.kForward);
	}
	
	public void setDriveShiftLow(){
		m_driveTrainShifters.set(Value.kReverse);
	}
	
	public boolean getHighGear(){
		return m_driveTrainShifters.get() == Value.kForward ? true : false;
	}

	public void resetSensors() {
		
	}
	
	public void updateSmartDashboard(){
		
	}
	
	public void initDefaultCommand() {
		// Set the default command for a subsystem here.
		
	}
}
