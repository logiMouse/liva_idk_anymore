// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.SparkLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

/** Add your docs here. */
public class pivot extends SubsystemBase {

    SparkMax pivot_motor;

    public pivot (){
        pivot_motor = new SparkMax(1,MotorType.kBrushless);

    }

    public void pivot_forward(){
        pivot_motor.set(0);

    }

    public void pivot_back(){
        pivot_motor.set(0);
    }

    public void pivot_stop(){
        pivot_motor.set(0);
    }

}
    

