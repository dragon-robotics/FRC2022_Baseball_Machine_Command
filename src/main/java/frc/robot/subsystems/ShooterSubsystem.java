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
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMax.IdleMode;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class ShooterSubsystem extends SubsystemBase {
  /** Creates a new ShooterSubsystem. */

  CANSparkMax leftFollowMotor = new CANSparkMax(9, MotorType.kBrushless);
  CANSparkMax rightLeadMotor = new CANSparkMax(11, MotorType.kBrushless);

  CANSparkMax leftFollowNeo550Motor = new CANSparkMax(5, MotorType.kBrushless);
  CANSparkMax rightLeadNeo550Motor = new CANSparkMax(4, MotorType.kBrushless);


  public ShooterSubsystem() {

    // Disable all motors //
    leftFollowMotor.set(0.0);
    rightLeadMotor.set(0.0);

    // Set neutral mode //(
    leftFollowMotor.setIdleMode(IdleMode.kCoast);
    rightLeadMotor.setIdleMode(IdleMode.kCoast);

    // set followeers //
    leftFollowMotor.follow(rightLeadMotor, true);

    // Neo550 Initialization
    leftFollowNeo550Motor.set(0);
    rightLeadNeo550Motor.set(0);

    leftFollowNeo550Motor.setIdleMode(IdleMode.kCoast);
    rightLeadNeo550Motor.setIdleMode(IdleMode.kCoast);

    leftFollowNeo550Motor.follow(rightLeadNeo550Motor, true);

  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  public void shoot(double speed) {
    rightLeadMotor.set(speed);
    rightLeadNeo550Motor.set(speed);

    // Display Speed
    SmartDashboard.putNumber("Joystick X value",speed);
  }

  public void motorOff() {

  }
}
