// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Drivertrain extends SubsystemBase {
  WPI_TalonSRX frontleftJordan= new WPI_TalonSRX(1);
  WPI_TalonSRX backleftJordan= new WPI_TalonSRX(2);
  WPI_TalonSRX frontrightBigWhiteHairJordan= new WPI_TalonSRX(3);
  WPI_TalonSRX backrightBigWhiteHairJordan= new WPI_TalonSRX(4);
  

  /** Creates a new Drivertrain. */

  public Drivertrain() {

 frontleftJordan.follow(backleftJordan);
 frontrightBigWhiteHairJordan.follow(backrightBigWhiteHairJordan);

 frontleftJordan.setNeutralMode(NeutralMode.Brake);
 frontrightBigWhiteHairJordan.setNeutralMode(NeutralMode.Brake);

  }

  public void JordanControl (Joystick left, Joystick right) {
    double leftSpeed = left.getRawAxis(1);
    double rightSpeed = right.getRawAxis(1);

    frontleftJordan.set(leftSpeed);
    frontrightBigWhiteHairJordan.set(rightSpeed);

  }

  public void autonoumous (double leftSpeed, double rightSpeed) {
    frontleftJordan.set(leftSpeed);
    frontrightBigWhiteHairJordan.set(rightSpeed);
 
  }
  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}

