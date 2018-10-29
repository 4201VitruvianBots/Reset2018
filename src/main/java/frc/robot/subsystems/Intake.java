
package frc.robot.subsystems;


import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * An example subsystem.  You can replace me with your own Subsystem.
 */
public class Intake extends Subsystem {
	public Intake(){
		super("Intake");
	}
	// Put methods for controlling the subsystem here. Call these from Commands.
	public void driveRollers(double voltage) {

	}

	public boolean getClamped() {
		return false;
	}

	public void setClamp(boolean clamped) {
		
	}

	public void resetSensors() {

	}

	public void updateSmartDashboard(){

	}

	public void initDefaultCommand() {
		// Set the default command for a subsystem here.

	}
}
