// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Shooter extends SubsystemBase {
  WPI_TalonSRX shooter1 = new WPI_TalonSRX(1);
  WPI_TalonSRX shooter2 = new WPI_TalonSRX(2);

  /** Creates a new Shooter. */
  public Shooter() {
    shooter1.setInverted(false);
    shooter2.setInverted(false);
  }
  public void shooterSetShooter(){
    shooter1.setInverted(false);
    shooter2.setInverted(false);
  }
  public void runShooter(){
    shooter1.set(1);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
