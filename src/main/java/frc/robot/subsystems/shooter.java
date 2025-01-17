// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.SparkBase.PersistMode;
import com.revrobotics.spark.SparkBase.ResetMode;
import com.revrobotics.spark.config.SparkMaxConfig;
import com.revrobotics.spark.config.SparkBaseConfig.IdleMode;
import com.revrobotics.spark.SparkLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class shooter extends SubsystemBase {
  /** Creates a new shooter. */
  SparkMax shooter; 
  SparkMaxConfig shoot_config;
  public shooter() {
    shooter = new SparkMax(Constants.shooter_id, MotorType.kBrushless);
    shoot_config = new SparkMaxConfig();

    shoot_config
      .idleMode(IdleMode.kBrake);
     // .inverted(false);
    shooter.configure(shoot_config,ResetMode.kResetSafeParameters,PersistMode.kPersistParameters);
        
  
  }
  public void shoot(){
    shooter.set(Constants.pivot_speed);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

}

