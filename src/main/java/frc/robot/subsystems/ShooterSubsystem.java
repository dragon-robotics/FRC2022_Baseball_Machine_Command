// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;


import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMax.IdleMode;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import static edu.wpi.first.wpilibj.DoubleSolenoid.Value.*;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class ShooterSubsystem extends SubsystemBase {
  /** Creates a new ShooterSubsystem. */

  CANSparkMax leftFollowMotor = new CANSparkMax(9, MotorType.kBrushless);
  CANSparkMax rightLeadMotor = new CANSparkMax(11, MotorType.kBrushless);

  CANSparkMax leftFollowNeo550Motor = new CANSparkMax(5, MotorType.kBrushless);
  CANSparkMax rightLeadNeo550Motor = new CANSparkMax(4, MotorType.kBrushless);

  Compressor pcmCompressor = new Compressor(0, PneumaticsModuleType.CTREPCM);
  DoubleSolenoid m_doublePCM1 = new DoubleSolenoid(PneumaticsModuleType.CTREPCM, 0, 1);

  private double m_speed;

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
  
    // Display Speed
    SmartDashboard.putNumber("Shooter Speed", m_speed);
  }

  public void shoot(double speed) {

    m_speed += speed;

    if(m_speed > 1.0) m_speed = 1.0;
    if(m_speed < -1.0) m_speed = -1.0;

    rightLeadMotor.set(m_speed);
    rightLeadNeo550Motor.set(m_speed);
  }

  public void motorOff() {
    rightLeadMotor.set(0);
    rightLeadNeo550Motor.set(0);

    m_speed = 0;
  }

  public void pneumaticsExtend() {
    m_doublePCM1.set(kForward);
  }

  public void pneumaticsRetract() {
    m_doublePCM1.set(kReverse);
  }

  public void pneumaticsNeutral(){
    m_doublePCM1.set(kOff);
  }
}
