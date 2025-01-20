// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import java.io.ObjectInputFilter.Config;

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
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Drivetrain extends SubsystemBase {
  /** Creates a new drivetrain. */
  SparkMax left_back;
  SparkMax left_fr;
  SparkMax right_back;
  SparkMax right_fr;

  SparkMaxConfig left_config;
  SparkMaxConfig right_config;
  Encoder Encoder;
  double rn_drive;
  double drives;
  PIDController drive_pid;
  double clamp;
  RelativeEncoder encoder;
  boolean ender_drive;

  

  double x;
  double y;
  public Drivetrain() {
    left_back = new SparkMax(Constants.drive_bkL, MotorType.kBrushless);
    left_fr = new SparkMax(Constants.drive_frL, MotorType.kBrushless);
   right_back = new SparkMax(Constants.drive_bkR, MotorType.kBrushless);
   right_fr = new SparkMax(Constants.drive_frR, MotorType.kBrushless);
   PIDController drive_pid = new PIDController(Constants.kp,Constants.ki,Constants.kd);
   Encoder = new Encoder(null, null);

    SparkMaxConfig left_confi = new SparkMaxConfig();
    SparkMaxConfig right_config = new SparkMaxConfig();

    // left configuration 
    left_confi 
        .idleMode(IdleMode.kBrake)
        .follow(left_fr);
       //inverted(false);
    //right configuration 
    right_config
        .idleMode(IdleMode.kBrake)
        .follow(right_fr);
       //inverted(false);
    
   left_back.configure(left_confi,ResetMode.kResetSafeParameters,PersistMode.kPersistParameters);
   right_back.configure(right_config, ResetMode.kResetSafeParameters,PersistMode.kPersistParameters);
   left_fr.configure(left_config,ResetMode.kResetSafeParameters,PersistMode.kPersistParameters);
   right_fr.configure(right_config,ResetMode.kResetSafeParameters,PersistMode.kPersistParameters);


  }

  public void arcade(Joystick left_con, Joystick right_con){
    y = left_con.getY();
    x = right_con.getX();
    left_fr.set(y - x);
    right_fr.set(y + x);
  }
  public void auto_drive_forward(double drive_get){
    rn_drive = encoder.getPosition();
    drive_get = drive_pid.calculate(rn_drive,  drive_get);
    clamp = MathUtil.clamp(drive_get, -.6, 0.6);
    left_fr.set(clamp);
    right_fr.set(clamp);

  }

  public boolean encoder_lessThen (){
    drives = encoder.getPosition();
    return Math.abs(drives - 40)<0.5;
    
  }

  public void auto_drive_turn(double drive_get){
    rn_drive = encoder.getPosition();
    drive_get = drive_pid.calculate(rn_drive,  drive_get);
    clamp = MathUtil.clamp(drive_get, -.6, 0.6);
    left_fr.set(0);
    right_fr.set(clamp);

  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
  

  }
