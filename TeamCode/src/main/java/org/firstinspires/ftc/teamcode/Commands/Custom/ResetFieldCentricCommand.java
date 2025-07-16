package org.firstinspires.ftc.teamcode.Commands.Custom;

import com.arcrobotics.ftclib.command.InstantCommand;

import org.firstinspires.ftc.teamcode.Subsystems.DriveSubsystem;
import org.firstinspires.ftc.teamcode.Subsystems.OdometrySubsystem;

public class ResetFieldCentricCommand extends InstantCommand {
    OdometrySubsystem odo;

    public ResetFieldCentricCommand (OdometrySubsystem odo){
        this.odo = odo;
        addRequirements(odo);
    }

    @Override
    public void initialize() {
        odo.resetHeading();
    }
}
