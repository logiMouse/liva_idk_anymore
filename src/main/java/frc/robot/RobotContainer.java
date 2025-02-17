// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import frc.robot.Constants.OperatorConstants;
import frc.robot.commands.Autos;
import frc.robot.commands.ExampleCommand;
import frc.robot.commands.drive_command;
import frc.robot.commands.intake_command;
import frc.robot.commands.pivot_command;
import frc.robot.subsystems.ExampleSubsystem;
import frc.robot.subsystems.Drivetrain;
import frc.robot.subsystems.Shooter;
import frc.robot.subsystems.Intake;
import frc.robot.subsystems.Pivot;
import frc.robot.subsystems.Climber;
import frc.robot.subsystems.Climber;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import edu.wpi.first.wpilibj2.command.button.Trigger;
import frc.robot.commands.climb_command;
import frc.robot.commands.shooter_command;





/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and trigger mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...
  private final ExampleSubsystem m_exampleSubsystem = new ExampleSubsystem();
  private final Climber climb_sub = new Climber();
  private final Intake intake_sub = new Intake();
  private final Shooter shoot_sub = new Shooter();
  private final Pivot piv_sub = new Pivot();
  private final Drivetrain drive = new Drivetrain();
  public static Joystick left_con = new Joystick(Constants.left_conid);
  public static Joystick right_con = new Joystick(Constants.right_conid);  

  public static JoystickButton climbern = new JoystickButton(left_con, Constants.button1);
  public static JoystickButton intake = new JoystickButton(left_con, Constants.button2);
  public static JoystickButton pivButton = new JoystickButton(left_con, Constants.button3);
  public static JoystickButton pivButton_30 = new JoystickButton(left_con, Constants.button5);
  public static JoystickButton shooter_button = new JoystickButton(left_con, Constants.button4);

  // Replace with CommandPS4Controller or CommandJoystick if needed
  private final CommandXboxController m_driverController =
      new CommandXboxController(OperatorConstants.kDriverControllerPort);


  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
    // Configure the trigger bindings
    drive.setDefaultCommand(new drive_command(drive,left_con,right_con));
    configureBindings();
  }

  /**
   * Use this method to define your trigger->command mappings. Triggers can be created via the
   * {@link Trigger#Trigger(java.util.function.BooleanSupplier)} constructor with an arbitrary
   * predicate, or via the named factories in {@link
   * edu.wpi.first.wpilibj2.command.button.CommandGenericHID}'s subclasses for {@link
   * CommandXboxController Xbox}/{@link edu.wpi.first.wpilibj2.command.button.CommandPS4Controller
   * PS4} controllers or {@link edu.wpi.first.wpilibj2.command.button.CommandJoystick Flight
   * joysticks}.
   */
  private void configureBindings() {
    // Schedule `ExampleCommand` when `exampleCondition` changes to `true`
    new Trigger(m_exampleSubsystem::exampleCondition)
        .onTrue(new ExampleCommand(m_exampleSubsystem));
  
    climbern.whileTrue(new climb_command(climb_sub));
    intake.whileTrue(new intake_command(intake_sub));
    pivButton.whileTrue(new pivot_command(piv_sub, Constants.angle_1));
    pivButton_30.whileTrue(new pivot_command(piv_sub, Constants.angle_2));
    shooter_button.whileTrue(new shooter_command(shoot_sub));
    

    // Schedule `exampleMethodCommand` when the Xbox controller's B button is pressed,
    // cancelling on release.
    m_driverController.b().whileTrue(m_exampleSubsystem.exampleMethodCommand());
  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // An example command will be run in autonomous
    return Autos.exampleAuto(m_exampleSubsystem);
  }
}
