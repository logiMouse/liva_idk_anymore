// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.spark.SparkMax;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.spark.SparkBase.PersistMode;
import com.revrobotics.spark.SparkBase.ResetMode;
import com.revrobotics.spark.SparkLowLevel.MotorType;
import com.revrobotics.spark.config.SparkMaxConfig;
import com.revrobotics.spark.config.SparkBaseConfig.IdleMode;

import edu.wpi.first.math.MathUtil;
import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Pivot extends SubsystemBase {
  SparkMax pivot_motor;
  /** Creates a new pivot. */
  double piv_ang;
  double piv_output; 
  PIDController pid;
  RelativeEncoder encoder;
  public Pivot() {
    pivot_motor = new SparkMax(Constants.pivot_id, MotorType.kBrushless);
    SparkMaxConfig pivot_config = new SparkMaxConfig();
    PIDController pid = new PIDController(Constants.kp,Constants.ki,Constants.kd);
    
    pivot_config
      .idleMode(IdleMode.kBrake)
      .inverted(false);
   pivot_motor.configure(pivot_config,ResetMode.kResetSafeParameters,PersistMode.kPersistParameters); 

  }
  public void pivot_thing(double want_ang){
    piv_ang = encoder.getPosition();
    piv_output = pid.calculate(piv_ang, want_ang);
    pivot_motor.set(MathUtil.clamp(want_ang, -.6, 0.6));
  }

 

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }


}