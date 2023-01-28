// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.XboxController;
import frc.robot.commands.ConstantSpeed;
import frc.robot.commands.ExampleCommand;
import frc.robot.subsystems.ExampleSubsystem;
import frc.robot.subsystems.MotorConstantSpeed;
import frc.robot.subsystems.OneMotorSubsystem;
import frc.robot.subsystems.TwoMotor;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.commands.MotorSpeedAdjust;
import frc.robot.commands.Shooter;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...
  private final ExampleSubsystem m_exampleSubsystem = new ExampleSubsystem();
  private final OneMotorSubsystem m_oneMotorSubsystem = new OneMotorSubsystem();
  private final MotorConstantSpeed m_motorConstantSpeed = new MotorConstantSpeed();
  private final TwoMotor m_twoMotor = new TwoMotor();
  public final XboxController RC = new XboxController(0);
  public final MotorSpeedAdjust m_motorSpeedAdjust = new MotorSpeedAdjust(m_oneMotorSubsystem, 0);
  public final ConstantSpeed m_constantSpeed = new ConstantSpeed(m_motorConstantSpeed, false);
  public final Shooter m_shooter = new Shooter(m_twoMotor, false);

  public final ExampleCommand m_autoCommand = new ExampleCommand(m_exampleSubsystem);
 
  public final JoystickButton m_joyA = new JoystickButton(RC, 1); // button A
  public final JoystickButton m_joyB = new JoystickButton(RC, 2); // button B
  public final JoystickButton m_joyX = new JoystickButton(RC, 3); // button X
  public final JoystickButton m_joyY = new JoystickButton(RC, 4); // button Y
  public final JoystickButton m_joyLB = new JoystickButton(RC, 5); // Left bumper
  public final JoystickButton m_joyRB = new JoystickButton(RC, 6); // Right bumper
  public final JoystickButton m_joyVB = new JoystickButton(RC, 7); // View Button
  public final JoystickButton m_joyMB = new JoystickButton(RC, 8); // Menu Button
  


  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
  m_oneMotorSubsystem.setDefaultCommand(m_motorSpeedAdjust);    
    // Configure the button bindings
    configureButtonBindings();
  }

  /**
   * Use this method to define your button->command mappings. Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a {@link
   * edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {
    m_joyA.whileTrue(m_constantSpeed);
    m_joyB.whileTrue(m_shooter);
  }

  public XboxController getController() {
    return RC;
  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // An ExampleCommand will run in autonomous
    return m_autoCommand;
  }
}
