// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.math.controller.PIDController;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants. This class should not be used for any other purpose. All constants should be declared
 * globally (i.e. public static). Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {

  // auto 
  public static final int auto_fd_drive = 40;

  // pid stuff 

  public static final int kp = 0;
  public static final int ki = 0;
  public static final int kd = 0;

  //angle
  public static final double angle_1 = 0;
  public static final double angle_2 = 30;

  // drive ids 
  public static final int drive_frL = 1;
  public static final int drive_bkL = 2;
  public static final int drive_frR = 3;
  public static final int drive_bkR = 4;

  // climb id
  public static final int climb_one = 5;
  public static final int climb_two = 6;
  
  // pivot di 
  public static final int pivot_id = 10;
  // pivot speed
  public static final  double pivot_speed = 1;
  // intake 
  public static final int intake_id = 7;
  public static final  double intake_speed = 1;
  // shooter id 
  public static final int shooter_id =9;
  // shooter speeds 
  public static final  double speed = 1;

  // joy ids
  public static final int left_conid = 1;
  public static final int right_conid = 2;

  // buttons 
  public static final int button1 = 1;
  public static final int button2 = 2;
  public static final int button3 = 3;
  public static final int button4 = 4;
  public static final int button5 = 5;
  //other 
  public static final  double stop_speed = 0;

  public static class OperatorConstants {
    public static final int kDriverControllerPort = 0;
  }
  public static class climber {
    // climb speed 
  public static final double climb_speed = 1;
  }
  
}
