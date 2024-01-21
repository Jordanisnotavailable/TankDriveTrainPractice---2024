// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.ArcadeDrive;


public class Drive extends Command {
  Joystick rightStick;
  Joystick leftStick;

private final ArcadeDrive s_ArcadeDrive;
  /** Creates a new Drive. */
  public Drive(ArcadeDrive s_ArcadeDrive, Joystick leftStick, Joystick rightStick) {
   this.s_ArcadeDrive=s_ArcadeDrive;
   this.leftStick = leftStick;
   this.rightStick =rightStick;
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(s_ArcadeDrive);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    s_ArcadeDrive.arcadeDrive();
    s_ArcadeDrive.getEncoderValue();
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
      s_ArcadeDrive.ReleaseBrake();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
