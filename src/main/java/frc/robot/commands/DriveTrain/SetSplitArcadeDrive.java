package frc.robot.commands.DriveTrain;

import frc.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class SetSplitArcadeDrive extends Command{
	boolean limit = false;
	
	public SetSplitArcadeDrive() {
		// Use requires() here to declare subsystem dependencies
		requires(Robot.driveTrain);
	}

	// Called just before this Command runs the first time
	@Override
	protected void initialize() {
	}

	// Called repeatedly when this Command is scheduled to run
	@Override
	protected void execute() {
		double throttle = Robot.oi.getLeftY();
		double turn = Robot.oi.getRightX();
		
		//Robot.driveTrain.arcadeDrive(throttle, turn);
	}

	// Make this return true when this Command no longer needs to run execute()
	@Override
	protected boolean isFinished() {
		return false;
	}

	// Called once after isFinished returns true
	@Override
	protected void end() {
		//Robot.driveTrain.arcadeDrive(0, 0);
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	@Override
	protected void interrupted() {
		end();
	}
}
