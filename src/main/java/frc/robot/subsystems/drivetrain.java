// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import java.io.ObjectInputFilter.Config;

import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.SparkLowLevel.MotorType;
import com.revrobotics.spark.config.SparkMaxConfig;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class drivetrain extends SubsystemBase {
  /** Creates a new drivetrain. */
  SparkMax left_back;
  SparkMax left_fr;
  SparkMax right_back;
  SparkMax right_fr;
  public drivetrain() {
    left_back = new SparkMax(Constants.drive_bkL, MotorType.kBrushless);
    left_fr = new SparkMax(Constants.drive_frL, MotorType.kBrushless);
   right_back = new SparkMax(Constants.drive_bkR, MotorType.kBrushless);
   right_fr = new SparkMax(Constants.drive_frR, MotorType.kBrushless);

    SparkMaxConfig left_confi = new SparkMaxConfig();
    SparkMaxConfig right_config = new SparkMaxConfig();

    left_confi 
        .idleMode(null)
        .follow(left_fr);
       //inverted(false);
    //right configuration 
    right_config
        .idleMode(null)
        .follow(right_fr);
       //inverted(false);
    
   left_back.configure(left_confi, null, null);
   right_back.configure(right_config, null, null);

  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
  public void arcade(double x,double y){
    left_fr.set(y - x);
    right_fr.set(y + x);
  }

  

  }
  







