// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import frc.robot.commands.ShootCommand;
import frc.robot.subsystems.ShooterSubsystem;
import edu.wpi.first.wpilibj2.command.Command;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...
  private final ShooterSubsystem m_shooterSubsystem = new ShooterSubsystem();

  private final Joystick m_driverController = new Joystick(Constants.DRIVER);

  // private final ShootCommand m_autoCommand = new ShootCommand(
  //   m_shooterSubsystem,
  //   () -> -m_driverController.getRawAxis(Constants.STICK_LEFT_Y)
  // );

  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
    // Configure the button bindings
    configureButtonBindings();

    // Set default command to arcade drive when in teleop
    m_shooterSubsystem.setDefaultCommand(
      new ShootCommand(
        m_shooterSubsystem,
        // () -> -m_driverController.getRawAxis(Constants.STICK_LEFT_Y), // speed
        () -> m_driverController.getRawButton(Constants.BTN_A), // +1 speed
        () -> m_driverController.getRawButton(Constants.BTN_B), // +5 speed
        () -> m_driverController.getRawButton(Constants.BUMPER_RIGHT), // +10 speed
        () -> m_driverController.getRawButton(Constants.BTN_X), // -1 speed
        () -> m_driverController.getRawButton(Constants.BTN_Y), // -5 speed
        () -> m_driverController.getRawButton(Constants.BUMPER_LEFT)  // -10 speed
      )
    );
  }

  /**
   * Use this method to define your button->command mappings. Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a {@link
   * edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {}

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // An ExampleCommand will run in autonomous
    return null;
  }
}
