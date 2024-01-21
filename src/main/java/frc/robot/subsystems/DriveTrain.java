// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class DriveTrain extends SubsystemBase {
  WPI_TalonSRX leftOne = new WPI_TalonSRX(1);
  WPI_TalonSRX leftTwo = new WPI_TalonSRX(2);
  WPI_TalonSRX rightOne = new WPI_TalonSRX(3);
  WPI_TalonSRX rightTwo = new WPI_TalonSRX(4);
  /** Creates a new DriveTrain. */
  public DriveTrain() {

  leftOne.follow(leftTwo);
  rightOne.follow(rightTwo);

  leftOne.setNeutralMode(NeutralMode.Brake);
  rightOne.setNeutralMode(NeutralMode.Brake);
  
  }

  public void joystickDrive(Joystick left, Joystick right) {
  double leftSpeed = left.getRawAxis(1);
  double rightSpeed = right.getRawAxis(1);

  leftOne.set(leftSpeed);
  rightOne.set(rightSpeed);
  
  }

  public void atonoumous(double leftSpeed, double rightSpeed){

    leftOne.set(leftSpeed);
    rightOne.set(rightSpeed);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
