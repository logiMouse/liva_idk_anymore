// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.config.SparkMaxConfig;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class pivot extends SubsystemBase {
  SparkMax pivot_motor;
  /** Creates a new pivot. */
  public pivot() {
    pivot_motor = new SparkMax(0, null);
    SparkMaxConfig pivot_config = new SparkMaxConfig();

    pivot_config
      .idleMode(null )
      .inverted(false);
   pivot_motor.configure(pivot_config, null, null);

  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
  public void pivot_thing(){



  }


}
