// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;



import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class OneStickDrive extends SubsystemBase {
  WPI_TalonSRX left1 = new WPI_TalonSRX(1);
  WPI_TalonSRX right1 = new WPI_TalonSRX(3);
  WPI_TalonSRX left2 = new WPI_TalonSRX(2);
  WPI_TalonSRX right2 = new WPI_TalonSRX(4);
  /** Creates a new OneStickDrive. */
  public OneStickDrive() {
    left1.follow(left2);
    right1.follow(right2);

    left1.setNeutralMode(NeutralMode.Brake);
    right1.setNeutralMode(NeutralMode.Brake);
  }

  public void joystickDrive(Joystick joystick){
    left1.set((joystick.getRawAxis(0)+joystick.getRawAxis(1))/2);
    right1.set((joystick.getRawAxis(0)-joystick.getRawAxis(1))/2);
  } 

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
