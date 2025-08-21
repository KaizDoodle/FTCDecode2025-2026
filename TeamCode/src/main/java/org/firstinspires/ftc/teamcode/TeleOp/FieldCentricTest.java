package org.firstinspires.ftc.teamcode.TeleOp;

import org.firstinspires.ftc.teamcode.Commands.Custom.DefaultDriveCommand;
import org.firstinspires.ftc.teamcode.Subsystems.RobotSubsystem;

import com.arcrobotics.ftclib.command.CommandScheduler;
import com.arcrobotics.ftclib.gamepad.GamepadEx;
import com.pedropathing.localization.Pose;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;


@TeleOp
public class FieldCentricTest extends RobotSubsystem {

    protected GamepadEx driverPad;
    protected GamepadEx operatorPad;






    public void configureOperator() {

    }

    @Override
    public void init() {
        driverPad = new GamepadEx(gamepad1);
        operatorPad = new GamepadEx(gamepad2);
        initialize(hardwareMap, new Pose(0,0,0));

        CommandScheduler.getInstance().setDefaultCommand(drive,
                new DefaultDriveCommand(
                        drive,
                        () -> driverPad.getLeftY(),
                        () -> driverPad.getLeftX(),
                        () -> driverPad.getRightX()
                )
        );

        configureOperator();

    }

    @Override
    public void loop() {
        update();
        CommandScheduler.getInstance().reset();
    }
}
