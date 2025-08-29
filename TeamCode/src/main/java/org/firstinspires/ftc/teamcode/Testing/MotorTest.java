package org.firstinspires.ftc.teamcode.Testing;

import com.arcrobotics.ftclib.hardware.ServoEx;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.hardware.ServoImplEx;

import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;
import org.firstinspires.ftc.teamcode.Drivers.GoBildaPinpointDriver;
import org.firstinspires.ftc.teamcode.Subsystems.RobotSubsystem;

@TeleOp
public class MotorTest extends LinearOpMode {


    DcMotor leftFront;
    DcMotor leftBack;
    DcMotor rightBack;
    DcMotor rightFront;

    Servo LMECFront;
    Servo LMECBack;

    GoBildaPinpointDriver odo;


    @Override
    public void runOpMode() throws InterruptedException {
        leftFront = hardwareMap.get(DcMotorEx .class, "frontLeft");
        leftBack = hardwareMap.get(DcMotorEx.class, "backLeft");
        rightBack = hardwareMap.get(DcMotorEx.class, "backRight");
        rightFront = hardwareMap.get(DcMotorEx.class, "frontRight");

        LMECBack = hardwareMap.get(Servo.class, "LMECBack");
        LMECFront = hardwareMap.get(Servo.class, "LMECFront");

        leftFront.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        leftBack.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        rightBack.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        rightFront.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

        rightFront.setDirection(DcMotorSimple.Direction.REVERSE);
        rightBack.setDirection(DcMotorSimple.Direction.REVERSE);



        waitForStart();
        double heading;
        while (opModeIsActive()){

                LMECBack.setPosition(0);
                LMECFront.setPosition(0);


            }

    }
}
