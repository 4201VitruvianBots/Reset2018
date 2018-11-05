
package frc.robot.subsystems;


import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

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

	TalonSRX m_leftMaster, m_leftSlave;
	TalonSRX m_rightMaster, m_rightSlave;
	DoubleSolenoid m_driveTrainShifters;
	
	public DriveTrain(){
		super("Drive Train");
		m_leftMaster = FactoryTalonSRX.createDefaultTalon(RobotMap.driveTrainLeftMaster);

		m_driveTrainShifters = new DoubleSolenoid(RobotMap.PCMOne, 
			RobotMap.driveTrainShifterForward, RobotMap.driveTrainShifterReverse);
		m_driveTrainShifters.setName("Shifters");
		m_driveTrainShifters.setSubsystem("Drive Train");
		LiveWindow.add(m_driveTrainShifters);
	}
	// Put methods for controlling the subsystem here. Call these from Commands.
	
	public int getLeftEncoderValue() {
		return 0;
	}
	
	public int getRightEncoderValue() {
		return 0;
	}

	public void setOpenLoopDriveCommand(DriveCommand dc) {
		m_leftMaster.set(ControlMode.PercentOutput, dc.leftVoltage / 12.0);
		m_rightMaster.set(ControlMode.PercentOutput, dc.rightVoltage / 12.0);
	}

	public static DriveCommand tankCommand(double left, double right) {
		return null;
	}

	public static DriveCommand arcadeCommand(double forward, double turn) {
		return null;
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
