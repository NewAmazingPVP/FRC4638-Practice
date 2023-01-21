// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class MotorConstantSpeed extends SubsystemBase {
  CANSparkMax m_flywheel = new CANSparkMax(12, MotorType.kBrushless);
  double m_power;
  /** Creates a new MotorConstantSpeed. */
  public MotorConstantSpeed() {
    m_power = 0.0;
  }

  @Override
  public void periodic() {
    m_flywheel.set(m_power);
    // This method will be called once per scheduler run
  }
  public void setPower(double power) {
    m_power = power;
  }

  public void setFlywheel_rpm(double d, double e) {
  }
}
