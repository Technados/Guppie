// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide
 * numerical or boolean
 * constants. This class should not be used for any other purpose. All constants
 * should be declared
 * globally (i.e. public static). Do not put anything functional in this class.
 *
 * <p>
 * It is advised to statically import this class (or one of its inner classes)
 * wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {
  public static final class DriveConstants {
    public static final int kLeftLeaderCANId = 9;
    public static final int kLeftFollowerCANId = 11;
    public static final int kRightLeaderCANId = 10;
    public static final int kRightFollowerCANId= 12;

    public static final double SLOW_MODE_MOVE = 0.5;
    public static final double SLOW_MODE_TURN = 0.6;
  }

  public static final class RollerConstants {
    public static final int kRollerMotorCANID = 13;
    public static final double ROLLER_CORAL_OUT = -0.8;
    public static final double ROLLER_ALGAE_IN = -0.8;
    public static final double ROLLER_ALGAE_OUT = -0.4;
    public static final double ROLLER_CORAL_STACK = -1;
    public static final double intakespeed = 5;
  }

  public static final class ArmConstants {
    public static final int kArmMotorCANId = 14;
    public static final double ARM_SPEED_DOWN = 0.3;
    public static final double ARM_SPEED_UP = -0.3;
    public static final double ARM_HOLD_DOWN = 0.1;
    public static final double ARM_HOLD_UP = -0.15;
  }

  public static final class ClimberConstants {
    public static final int kClimberCANId = 7;
    public static final double CLIMBER_SPEED_DOWN = -0.5;
    public static final double CLIMBER_SPEED_UP = 0.5;
  }

  public static final class OperatorConstants {
    public static final int kDriverControllerPort = 0;
    public static final int kOperatorControllerPort = 1;
  }
}