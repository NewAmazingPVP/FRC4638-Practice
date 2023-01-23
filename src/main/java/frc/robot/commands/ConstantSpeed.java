// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.MotorConstantSpeed;

public class ConstantSpeed extends CommandBase {
  public boolean isOn = true;
  private MotorConstantSpeed m_motorConstantSpeed;
  public double speed = 0.2;
  /** Creates a new ConstantSpeed. */
  public ConstantSpeed(MotorConstantSpeed subsystem, boolean b) {
    addRequirements(subsystem);
    m_motorConstantSpeed = subsystem;
  }
  
  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    isOn = !isOn;
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    System.out.println(isOn);
    if (isOn)
      m_motorConstantSpeed.setPower(speed);
    else
      m_motorConstantSpeed.setPower(0);
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
