package org.firstinspires.ftc.teamcode.Commands.Custom;

import com.arcrobotics.ftclib.command.InstantCommand;

import org.firstinspires.ftc.teamcode.Subsystems.DriveSubsystem;

public class ResetFieldCentricCommand extends InstantCommand {
    DriveSubsystem drive;

    public ResetFieldCentricCommand (DriveSubsystem drive){
        this.drive = drive;
        addRequirements(drive);
    }

    @Override
    public void initialize() {
        drive.reset();
    }
}
