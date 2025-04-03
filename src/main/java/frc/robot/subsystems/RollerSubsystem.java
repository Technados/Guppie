// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.RollerConstants;
import java.util.function.DoubleSupplier;

import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.SparkBase.PersistMode;
import com.revrobotics.spark.SparkBase.ResetMode;
import com.revrobotics.spark.SparkLowLevel.MotorType;
import com.revrobotics.spark.config.SparkMaxConfig;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;


/** Class to run the rollers over CAN */
public class RollerSubsystem extends SubsystemBase {
  private final VictorSPX rollerMotor;

  public RollerSubsystem() {
    // Set up the roller motor as a brushed motor
    rollerMotor = new VictorSPX(13);
            // Configure basic settings
            rollerMotor.configFactoryDefault(); // Reset to factory defaults
            rollerMotor.setInverted(false); // Change to true if motor runs in the wrong direction

    // Set can timeout. Because this project only sets parameters once on
    // construction, the timeout can be long without blocking robot operation. Code
    // which sets or gets parameters during operation may need a shorter timeout.
    //rollerMotor.setCANTimeout(250);

    // Create and apply configuration for roller motor. Voltage compensation helps
    // the roller behave the same as the battery
    // voltage dips. The current limit helps prevent breaker trips or burning out
    // the motor in the event the roller stalls.
    //SparkMaxConfig rollerConfig = new SparkMaxConfig();
    //rollerConfig.voltageCompensation(10);
    //rollerConfig.smartCurrentLimit(60);
    //rollerMotor.configure(rollerConfig, ResetMode.kResetSafeParameters, PersistMode.kPersistParameters);
  }

  @Override
  public void periodic() {
  }

  public void runRoller(double speed){
    rollerMotor.set(ControlMode.PercentOutput, 1);
  }

  public void reverseRoller(double speed){
  rollerMotor.set(ControlMode.PercentOutput, (-0.4));
  }

  public void stopRoller(){
  rollerMotor.set(ControlMode.PercentOutput, 0.0);
  }

  public Command runRoller(RollerSubsystem rollerSubsystem, DoubleSupplier forward, DoubleSupplier reverse) {
    return Commands.run(
        () -> {
            // Get the current values from the forward and reverse inputs
            double forwardSpeed = forward.getAsDouble();
            double reverseSpeed = reverse.getAsDouble();

            // Calculate the motor speed based on the input values.
            // If forward and reverse are both zero, stop the motor.
            double speed = forwardSpeed - reverseSpeed;
            
            // Only set the motor if the speed is non-zero, otherwise stop the motor
            if (speed != 0) {
                rollerMotor.set(ControlMode.PercentOutput, speed);
            } else {
                rollerMotor.set(ControlMode.PercentOutput, 0); // Stop the motor if no input
            }
        }, 
        rollerSubsystem
    );
  }
}  
