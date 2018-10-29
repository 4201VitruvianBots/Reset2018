
package frc.robot.subsystems;


import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * An example subsystem.  You can replace me with your own Subsystem.
 */
public class Wrist extends Subsystem {
	private double m_slewRateLimit = 0;
	private double m_accelerationLimit = 0;

	public Wrist(){
		super("Wrist");
	}
	// Put methods for controlling the subsystem here. Call these from Commands.


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

	/**
	 * Drive the wrist with a constant voltage. Call this every cycle
	 * @param voltage Volts to send to each motor
	 */
	public void driveOpenLoop(double voltage) {
		
	}

	/**
	 * Send a step command to the position PID loop
	 * @param position Height of the wrist from the base, in rads
	 */
	public void setClosedLoopPositionStep(double position) {
		
	}

	/**
	 * Set a step velocity command to the velocity PID loop
	 * @param velocity Speed to move the wrist upwards, in rads/second
	 */
	public void setClosedLoopVelocity(double velocity) {
		
	}

	/**
	 * Set a position command to the wrist with a maximum velocity. Run this every cycle
	 * 
	 * @param position Position setpoint from the base, in rads
	 */
	public void setClosedLoopPositionSlewRate(double position) {
		
	}

	/**
	 * Set a possition command to the wrist with a maximum velocity and maximum acceleration. Run this every cycle
	 * 
	 * @param position Position setpoint from the base, in rads
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
