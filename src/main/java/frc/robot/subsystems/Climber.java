// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.SparkBase.ResetMode;
import com.revrobotics.spark.SparkBase.PersistMode;
import com.revrobotics.spark.SparkBase.ResetMode;
import com.revrobotics.spark.SparkLowLevel.MotorType;
import com.revrobotics.spark.config.SparkMaxConfig;
import com.revrobotics.spark.config.SparkBaseConfig.IdleMode;

import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Climber extends SubsystemBase{ 
  /** Creates a new climb. */
  SparkMax climb_left;
  SparkMax climb_right;
  SparkMaxConfig climber;
  PIDController pid;
  public Climber() {

    climb_left = new SparkMax(Constants.climb_one, MotorType.kBrushless);
    climb_right = new SparkMax(Constants.climb_two,MotorType.kBrushless);
    SparkMaxConfig climber = new SparkMaxConfig();
    PIDController pid = new PIDController(Constants.kp,Constants.ki,Constants.kd);

    climber 
      .idleMode(IdleMode.kBrake)
      .inverted(false);

   climb_left.configure(climber,ResetMode.kResetSafeParameters,PersistMode.kPersistParameters);
   climb_right.configure(climber,ResetMode.kResetSafeParameters,PersistMode.kPersistParameters);

  }

  public void climbing(double c_speed){
    climb_left.set(c_speed);
    climb_right.set(c_speed);
  }


  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
  

}