
package frc.robot.subsystems;


import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.Constants;
import frc.robot.RobotMap;
import frc.vitruvianlib.drivers.FactoryTalonSRX;

/**
 * An example subsystem.  You can replace me with your own Subsystem.
 */
public class Elevator extends Subsystem {
	private TalonSRX m_elevatorMaster, m_elevatorSlave1, m_elevatorSlave2, m_elevatorSlave3;
	private DigitalInput m_zeroHardStop, m_maxHardStop;

	private double m_slewRateLimit = Constants.elevatorSlewRateLimit;
	private double m_accelerationLimit = Constants.elevatorAccelerationLimit;




	public Elevator(){
		super("Elevator");

		m_elevatorMaster = FactoryTalonSRX.createDefaultTalon(RobotMap.elevatorMaster1);
		m_elevatorSlave1 = FactoryTalonSRX.createDefaultTalon(RobotMap.elevatorSlave1);
		m_elevatorSlave2 = FactoryTalonSRX.createDefaultTalon(RobotMap.elevatorSlave2);
		m_elevatorSlave3 = FactoryTalonSRX.createDefaultTalon(RobotMap.elevatorMaster2);

		/*
		sets all motors to brake and sets max and min outputs.
		Not needed with new methods

		for (int i = 0; i < elevatorMotors.length; i++){
			elevatorMotors[i].setNeutralMode(NeutralMode.Brake);
			elevatorMotors[i].configPeakOutputForward(1, 0);
			elevatorMotors[i].configPeakOutputReverse(-1, 0);
			elevatorMotors[i].setInverted(false);
			//elevatorMotors[i].setSafetyEnabled(true);
			/*elevatorMotors[i].configContinuousCurrentLimit(30, 0);
			elevatorMotors[i].configPeakCurrentLimit(80, 0);
			elevatorMotors[i].configPeakCurrentDuration(100, 0);
		}*/

		/*
		Set slaves to master.
		 */
		m_elevatorSlave1.set(ControlMode.Follower, m_elevatorMaster.getDeviceID());
        m_elevatorSlave2.set(ControlMode.Follower, m_elevatorMaster.getDeviceID());
        m_elevatorSlave3.set(ControlMode.Follower, m_elevatorMaster.getDeviceID());

		/*
		These motors are facing the opposite directions and are inverted to prevent
		the motors from fighting each other.
		 */
        m_elevatorMaster.setInverted(false);
        m_elevatorSlave1.setInverted(false);
        m_elevatorSlave2.setInverted(true);
        m_elevatorSlave3.setInverted(true);

		m_zeroHardStop = new DigitalInput(RobotMap.elevatorZero);
		m_maxHardStop = new DigitalInput(RobotMap.elevatorMax);

	}

	public double getPosition() {
		return 0;
	}

	public double getVelocity() {
		return 0;
	}


	public void setSlewRateLimit(double slewRate) {
		m_slewRateLimit = slewRate;
	}

	public double getSlewRateLimit() {
		return m_slewRateLimit;
	}

	public void setAccelerationLimit(double acceleration) {
		m_accelerationLimit = acceleration;
	}

	public double getAccelerationLimit() {
		return m_accelerationLimit;
	}

	// Put methods for controlling the subsystem here. Call these from Commands.
	public boolean getLowerLimitSensor() {
		return false;
	}

	public boolean getUpperLimitSensor() {
		return false;
	}

	/**
	 * Drive the elevator with a constant voltage. Call this every cycle
	 * @param voltage Volts to send to each motor
	 */
	public void driveOpenLoop(double voltage) {
		m_elevatorMaster.set(ControlMode.PercentOutput, voltage/12);
	}

	/**
	 * Send a step command to the position PID loop
	 * @param position Height of the elevator from the base, in meters
	 */
	public void setClosedLoopPositionStep(double position) {
		
	}

	/**
	 * Set a step velocity command to the velocity PID loop
	 * @param velocity Speed to move the elevator upwards, in meters/second
	 */
	public void setClosedLoopVelocity(double velocity) {
		
	}

	/**
	 * Set a position command to the elevator with a maximum velocity. Run this every cycle
	 * 
	 * @param position Position setpoint from the base, in meters
	 */
	public void setClosedLoopPositionSlewRate(double position) {
		
	}

	/**
	 * Set a possition command to the elevator with a maximum velocity and maximum acceleration. Run this every cycle
	 * 
	 * @param position Position setpoint from the base, in meters
	 */
	public void setClosedLoopPositionSmooth(double position) {
		
	}

	public void resetSensors() {
		
	}
	
	public void updateSmartDashboard(){
		
	}
	
	public void initDefaultCommand() {
		// Set the default command for a subsystem here.
		
	}
}
