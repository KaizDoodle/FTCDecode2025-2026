package org.firstinspires.ftc.teamcode.OpModes.TeleOp;

import org.firstinspires.ftc.teamcode.Config.Core.Util.Alliance;
import org.firstinspires.ftc.teamcode.Config.Subsystems.RobotSubsystem;

import com.arcrobotics.ftclib.gamepad.GamepadEx;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.Gamepad;


@TeleOp
public class FieldCentricTest extends OpMode {

    RobotSubsystem robot;

    public void configureOperator() {

    }

    @Override
    public void init() {
        robot = new RobotSubsystem(hardwareMap, gamepad1, gamepad2, Alliance.BLUE);

//        CommandScheduler.getInstance().setDefaultCommand(drive,
//                new DefaultDriveCommand(
//                        drive,
//                        () -> driverPad.getLeftY(),
//                        () -> driverPad.getLeftX(),
//                        () -> driverPad.getRightX()
//                )
//        );

//        configureOperator();

    }

    @Override
    public void loop() {
//        update();
//        CommandScheduler.getInstance().reset();
        robot.teleOpControl();
        robot.periodic();
    }
    @Override
    public void start(){
        robot.tStart();

    }
}
