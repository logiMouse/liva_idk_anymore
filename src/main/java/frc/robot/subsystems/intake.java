// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.config.SparkMaxConfig;
import com.revrobotics.spark.config.SparkBaseConfig.IdleMode;
import com.revrobotics.spark.SparkBase.ResetMode;
import com.revrobotics.spark.SparkBase.PersistMode;
import com.revrobotics.spark.SparkLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class intake extends SubsystemBase {
  /** Creates a new intake. */
  SparkMax intake_motor; 
  SparkMaxConfig intake_confi;

  public intake() {
    intake_motor = new SparkMax(Constants.intake_id, MotorType.kBrushless);
    intake_confi = new SparkMaxConfig();

    intake_confi
      //.inverted(false)
      .idleMode(IdleMode.kBrake);
    intake_motor.configure(intake_confi,ResetMode.kResetSafeParameters, PersistMode.kPersistParameters);

  }
  public void intaker (){
    intake_motor.set(Constants.intake_speed);
  }

  @Override  
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
