// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.spark.SparkMax;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

/** Add your docs here. */
public class shooter extends SubsystemBase {

    SparkMax small;
    SparkMax mid;
    SparkMax big;

    public shooter(){
        small = new SparkMax(0, null);
        mid = new SparkMax(0, null);
        big = new SparkMax(0, null);


    }

}
    
