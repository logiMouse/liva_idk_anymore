// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.SparkLowLevel.MotorType;
import com.revrobotics.spark.config.SparkMaxConfig;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class climb extends SubsystemBase {
  /** Creates a new climb. */
  SparkMax climb_left;
  SparkMax climb_right;
  public climb() {

    climb_left = new SparkMax(Constants.climb_one,MotorType.kBrushless);
    climb_right = new SparkMax(Constants.climb_two,MotorType.kBrushless);
    SparkMaxConfig climber = new SparkMaxConfig();

    climber 
      .idleMode(null)
      .inverted(false);

   climb_left.configure(climber, null, null);
   climb_right.configure(climber, null, null);

  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
  public void climbing (){
    climb_left.set(Constants.climb_speed);
    climb_right.set(Constants.climb_speed);
  }

}
