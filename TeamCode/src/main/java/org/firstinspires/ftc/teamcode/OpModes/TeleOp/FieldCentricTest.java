package org.firstinspires.ftc.teamcode.OpModes.TeleOp;

import org.firstinspires.ftc.teamcode.Config.Core.Util.Alliance;
import org.firstinspires.ftc.teamcode.Config.Subsystems.RobotSubsystem;

import com.arcrobotics.ftclib.gamepad.GamepadEx;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;


@TeleOp
public class FieldCentricTest extends OpMode {

    protected GamepadEx driverPad = new GamepadEx(gamepad1);
    protected GamepadEx operatorPad = new GamepadEx(gamepad2);

    RobotSubsystem robot;

    public void configureOperator() {

    }

    @Override
    public void init() {
        robot = new RobotSubsystem(hardwareMap, driverPad, operatorPad, Alliance.BLUE);

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
