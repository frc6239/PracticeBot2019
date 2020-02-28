package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

/**
 * An example command.  You can replace me with your own command.
 */
public class DriveCommand extends Command {
  public DriveCommand() {
    // Use requires() here to declare subsystem dependencies
    requires(Robot.drivesub);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
  
    //boolean DriveValue = Robot.oi.VisTargetCenter.get();
  
    boolean DriveValue = Robot.StartTracking;

    if(DriveValue == false)
    {
    Robot.drivesub.tank();
    }
    else
    {
    Robot.drivesub.ArcaceDrive();
    }

  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return false;
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
  }
}
