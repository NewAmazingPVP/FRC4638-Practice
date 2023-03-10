// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.OneMotorSubsystem;
import frc.robot.subsystems.TwoMotor;

public class Shooter extends CommandBase {
  private  TwoMotor m_twoMotor;
  private OneMotorSubsystem m_oneMotorSubsystem;
  public double speed = 0.2;
  /** Creates a new ConstantSpeed. */
  public Shooter(TwoMotor subsystem, OneMotorSubsystem subsystem1) {
    addRequirements(subsystem);
    m_twoMotor = subsystem;
    m_oneMotorSubsystem = subsystem1;
  }
  
  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    m_oneMotorSubsystem.setPower(speed);
    m_twoMotor.setPower(speed);
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
