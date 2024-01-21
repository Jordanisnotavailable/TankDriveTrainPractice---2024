// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class ArcadeDrive extends SubsystemBase {
  WPI_TalonSRX left1 = new WPI_TalonSRX(1);
  WPI_TalonSRX left2 = new WPI_TalonSRX(2);
  WPI_TalonSRX right1 = new WPI_TalonSRX(3);
  WPI_TalonSRX right2 = new WPI_TalonSRX(4);


  Joystick joystick = new Joystick(0);

  DifferentialDrive m_DifferentialDrive;

  /** Creates a new ArcadeDrive. */
  public ArcadeDrive() {
    left2.follow(left1);
    right2.follow(right1);

    left1.setInverted(true);
    left2.setInverted(true);

    left1.configSelectedFeedbackSensor(FeedbackDevice.IntegratedSensor);
    right1.configSelectedFeedbackSensor(FeedbackDevice.IntegratedSensor);

    left1.setNeutralMode(NeutralMode.Brake);
    right1.setNeutralMode(NeutralMode.Brake);

    m_DifferentialDrive = new DifferentialDrive(left1, right1);


    
  }

  public void arcadeDrive(){
    m_DifferentialDrive.arcadeDrive((joystick.getRawAxis(1)/2), (joystick.getRawAxis(0))/2);
  }

  public void getEncoderValue(){
    SmartDashboard.putNumber("Distance", left1.getSelectedSensorPosition());
    SmartDashboard.putNumber("MotorOutputPercent", left1.getMotorOutputPercent());
  }
  public void ReleaseBrake(){
    left1.setNeutralMode(NeutralMode.Coast);
    right1.setNeutralMode(NeutralMode.Coast);
  }


  @Override
  public void periodic() {
    // This method will be called once per scheduler run

  }
}
