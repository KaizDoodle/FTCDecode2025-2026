package org.firstinspires.ftc.teamcode.OpModes.TeleOp;

import org.firstinspires.ftc.teamcode.Config.Core.Util.Alliance;
import org.firstinspires.ftc.teamcode.Config.Core.RobotContainer;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.Gamepad;


@TeleOp
public class FieldCentricTest extends OpMode {


    RobotContainer robot;

    public void configureOperator() {

    }

    @Override
    public void init() {
        robot = new RobotContainer(hardwareMap, gamepad1, gamepad2, Alliance.BLUE);


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
