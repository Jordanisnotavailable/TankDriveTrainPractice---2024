// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.ArcadeDrive;

public class Commando extends Command {
private final ArcadeDrive autospin;
Timer timer = new Timer();
  /** Creates a new Commando. */
  public Commando(ArcadeDrive autospin) {
    // Use addRequirements() here to declare subsystem dependencies.4
    this.autospin = autospin;
    addRequirements(autospin);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    timer.reset();
    timer.start();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    autospin.autospin();
    System.out.println(timer.get());
    System.out.println(timer.get());
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    timer.stop();
    autospin.stopMotor();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return timer.get()>5;
  }
}
