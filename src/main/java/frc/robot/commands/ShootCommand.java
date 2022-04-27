// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import frc.robot.subsystems.ShooterSubsystem;

import java.util.function.Supplier;

import edu.wpi.first.wpilibj2.command.CommandBase;

/** An example command that uses an example subsystem. */
public class ShootCommand extends CommandBase {
  @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})
  private final ShooterSubsystem m_shooter;
  // private final Supplier<Double> m_variableSpeed;

  private final Supplier<Boolean> m_add1Speed;
  private final Supplier<Boolean> m_add5Speed;
  private final Supplier<Boolean> m_add10Speed;
  private final Supplier<Boolean> m_sub1Speed;
  private final Supplier<Boolean> m_sub5Speed;
  private final Supplier<Boolean> m_sub10Speed;

  /**
   * Creates a new ExampleCommand.
   *
   * @param shooter The shooter subsystem used by this command.
   */
  public ShootCommand(
    ShooterSubsystem shooter,
    Supplier<Boolean> add1Speed,
    Supplier<Boolean> add5Speed,
    Supplier<Boolean> add10Speed,
    Supplier<Boolean> sub1Speed,
    Supplier<Boolean> sub5Speed,
    Supplier<Boolean> sub10Speed
  ) {
    m_shooter = shooter;

    m_add1Speed = add1Speed;
    m_add5Speed = add5Speed;
    m_add10Speed = add10Speed;
    m_sub1Speed = sub1Speed;
    m_sub5Speed = sub5Speed;
    m_sub10Speed = sub10Speed;

    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(shooter);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    // m_shooter.shoot(m_speed.get());

    if(m_add1Speed.get()) m_shooter.shoot(0.01);
    if(m_add5Speed.get()) m_shooter.shoot(0.05);
    if(m_add10Speed.get()) m_shooter.shoot(0.1);
    if(m_sub1Speed.get()) m_shooter.shoot(-0.01);
    if(m_sub5Speed.get()) m_shooter.shoot(-0.05);
    if(m_sub10Speed.get()) m_shooter.shoot(-0.1);    

  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
