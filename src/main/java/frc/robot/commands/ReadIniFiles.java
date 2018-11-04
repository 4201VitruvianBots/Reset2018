package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class ReadIniFiles extends Command {
    boolean finished = false, success = false;

    public ReadIniFiles() {
        // Use requires() here to declare subsystem dependencies
    }

    // Called just before this Command runs the first time
    @Override
    protected void initialize() {
        success = false;
        finished = false;
    }

    // Called repeatedly when this Command is scheduled to run
    @Override
    protected void execute() {
        try {

            success = true;
        } catch(Exception e) {
            success = false;
        }
        finished = true;
    }

    // Make this return true when this Command no longer needs to run execute()
    @Override
    protected boolean isFinished() {
        return finished;
    }

    // Called once after isFinished returns true
    @Override
    protected void end() {

    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    @Override
    protected void interrupted() {
        end();
    }

}
