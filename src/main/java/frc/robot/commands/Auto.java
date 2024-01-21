// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.DriveTrain;
import frc.robot.subsystems.Drivertrain;

public class Auto extends Command {
  private final Drivertrain s_autonomous;
  Timer timer = new Timer();
  /** Creates a new Auto. */
  public Auto(Drivertrain s_Drivertrain) {
    this.s_autonomous = s_Drivertrain;
    addRequirements(s_Drivertrain);
    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    timer.start();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    s_autonomous.autonoumous(0.5, 0.5);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    s_autonomous.autonoumous(0,0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return timer.get() >2;
  }
}
