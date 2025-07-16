package org.firstinspires.ftc.teamcode.Testing;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;

import org.firstinspires.ftc.teamcode.Subsystems.RobotSubsystem;

@Autonomous
public class MotorTest extends RobotSubsystem {

    DcMotor bob;

    @Override
    public void runOpMode() throws InterruptedException {

        waitForStart();
        initialize(hardwareMap);

            while (opModeIsActive()){

                drive.setMotorPower(0.2);
            }

    }
}
