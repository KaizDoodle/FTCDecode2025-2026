package org.firstinspires.ftc.teamcode.TeleOp;

import org.firstinspires.ftc.teamcode.Commands.Custom.DefaultDriveCommand;
import org.firstinspires.ftc.teamcode.Commands.Custom.LMECControl;
import org.firstinspires.ftc.teamcode.Subsystems.LMECSubsystem;
import org.firstinspires.ftc.teamcode.Subsystems.RobotSubsystem;

import com.arcrobotics.ftclib.command.CommandScheduler;
import com.arcrobotics.ftclib.gamepad.GamepadEx;
import com.arcrobotics.ftclib.gamepad.GamepadKeys;
import com.pedropathing.localization.Pose;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;


@TeleOp
public class FieldCentricTest extends RobotSubsystem {

    protected GamepadEx driverPad;
    protected GamepadEx operatorPad;


    public void configureOperator() {

        driverPad.getGamepadButton(GamepadKeys.Button.RIGHT_BUMPER).toggleWhenPressed(
                new LMECControl(lmec,false),
                new LMECControl(lmec, true)
        );

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
    public void start() {

        follower.startTeleopDrive();
    }

    @Override
    public void loop() {
        update();
        CommandScheduler.getInstance().reset();
    }
}
