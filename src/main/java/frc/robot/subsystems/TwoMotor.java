// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class TwoMotor extends SubsystemBase {
  CANSparkMax m_flywheel = new CANSparkMax(13, MotorType.kBrushless);
  CANSparkMax m_flywheel1 = new CANSparkMax(14, MotorType.kBrushless);

  double m_power;

  /** Creates a new OneMotorSubsystem. */
  public TwoMotor() {
    m_power = 0.0;
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    m_flywheel.set(m_power);
    m_flywheel1.set(m_power);
  }

  public void setPower(double power) {
    m_power = power;
  }

  public void setFlywheel_rpm(double d, double e) {
  }
}
