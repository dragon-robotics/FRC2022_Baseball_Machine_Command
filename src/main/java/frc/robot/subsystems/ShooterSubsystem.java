// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.InvertType;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.TalonFXInvertType;
import com.ctre.phoenix.motorcontrol.can.TalonFX;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class ShooterSubsystem extends SubsystemBase {
  /** Creates a new ShooterSubsystem. */

  WPI_TalonFX leftFollowMotor = new WPI_TalonFX(5);
  WPI_TalonFX rightLeadMotor = new WPI_TalonFX(6);

  public ShooterSubsystem() {
    // Default factory settings //
    leftFollowMotor.configFactoryDefault();
    rightLeadMotor.configFactoryDefault();

    // Disable all motors //
    leftFollowMotor.set(ControlMode.PercentOutput, 0);
    rightLeadMotor.set(ControlMode.PercentOutput, 0);

    // Set neutral mode //(
    leftFollowMotor.setNeutralMode(NeutralMode.Coast);
    rightLeadMotor.setNeutralMode(NeutralMode.Coast);

    // set followeers //
    leftFollowMotor.follow(rightLeadMotor);

    // set followers to opposite //
    leftFollowMotor.setInverted(InvertType.FollowMaster);

    //sett right motor //
    rightLeadMotor.setInverted(TalonFXInvertType.Clockwise);

  }

  

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  public void shoot(double speed) {
    rightLeadMotor.set(speed);
  }

  public void motorOff() {

  }
}