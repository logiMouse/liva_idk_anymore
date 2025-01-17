// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.drivetrain;
import frc.robot.RobotContainer;

/* You should consider using the more terse Command factories API instead https://docs.wpilib.org/en/stable/docs/software/commandbased/organizing-command-based.html#defining-commands */
public class drive_command extends Command {
  /** Creates a new drive_command. */
  drivetrain drive;
  Joystick left_con;
  Joystick right_con;

  public drive_command(drivetrain drive, Joystick left_con, Joystick right_con){
    // Use addRequirements() here to declare subsystem dependencies.
    this.drive = drive;
    this.right_con = right_con;
    this.left_con = left_con;
    

    addRequirements(this.drive);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
this.drive.arcade(left_con,right_con);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
