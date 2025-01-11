// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.SparkLowLevel.MotorType;
import com.revrobotics.spark.config.SparkMaxConfig;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

/** Add your docs here. */
public class climber extends SubsystemBase{

    SparkMax climber_left;
    SparkMax climber_right; 
    SparkMaxConfig climb_config;

    public climber (){
        climber_left = new SparkMax(1, MotorType.kBrushless);
        climber_right = new SparkMax(2, MotorType.kBrushless);
        climb_config = new SparkMaxConfig();

        climb_config
            .idleMode(null);
            


    }

    public void climb_up (){
        climber_left.set(1);
        climber_right.set(1);

    }

    public void climb_down (){
        climber_left.set(0);
        climber_right.set(0);
    }

    public void climb_stop(){
        climber_left.set(0);
        climber_right.set(0);
    }
}
