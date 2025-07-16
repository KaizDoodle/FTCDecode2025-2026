package org.firstinspires.ftc.teamcode.Testing;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;
import org.firstinspires.ftc.teamcode.Drivers.GoBildaPinpointDriver;
import org.firstinspires.ftc.teamcode.Subsystems.RobotSubsystem;

@TeleOp
public class MotorTest extends LinearOpMode {


    DcMotor leftFront;
    DcMotor leftBack;
    DcMotor rightBack;
    DcMotor rightFront;
    GoBildaPinpointDriver odo;


    @Override
    public void runOpMode() throws InterruptedException {
        leftFront = hardwareMap.get(DcMotorEx .class, "frontLeft");
        leftBack = hardwareMap.get(DcMotorEx.class, "backLeft");
        rightBack = hardwareMap.get(DcMotorEx.class, "backRight");
        rightFront = hardwareMap.get(DcMotorEx.class, "frontRight");
        odo = hardwareMap.get(GoBildaPinpointDriver.class, "odo");

        leftFront.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        leftBack.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        rightBack.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        rightFront.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

        rightFront.setDirection(DcMotorSimple.Direction.REVERSE);
        rightBack.setDirection(DcMotorSimple.Direction.REVERSE);

        odo.setEncoderResolution(GoBildaPinpointDriver.GoBildaOdometryPods.goBILDA_4_BAR_POD);
        odo.setEncoderDirections(GoBildaPinpointDriver.EncoderDirection.FORWARD, GoBildaPinpointDriver.EncoderDirection.FORWARD);
        odo.resetPosAndIMU();

        waitForStart();
        double heading;
        while (opModeIsActive()){

            odo.update();

            double gamepadX = -gamepad1.left_stick_x;
            double gamepadY = gamepad1.left_stick_y;
            double gamepadRX = gamepad1.right_stick_x;


            heading =  odo.getHeading(AngleUnit.RADIANS);
                double rotX = gamepadX * Math.cos(-heading) - gamepadY * Math.sin(-heading);
                double rotY = gamepadX * Math.sin(-heading) + gamepadY * Math.cos(-heading);

                double denominator = Math.max(Math.abs(rotY) + Math.abs(rotX) + Math.abs(gamepadRX), 1);
                double frontLeftPower = (rotY + rotX + gamepadRX) / denominator;
                double backLeftPower = (rotY - rotX + gamepadRX) / denominator;
                double frontRightPower = (rotY - rotX - gamepadRX) / denominator;
                double backRightPower = (rotY + rotX - gamepadRX) / denominator;
                if (!(Double.valueOf(frontLeftPower).isNaN() ||
                        Double.valueOf(backLeftPower).isNaN() ||
                        Double.valueOf(frontRightPower).isNaN() ||
                        Double.valueOf(backRightPower).isNaN())) {

                    leftFront.setPower(frontLeftPower);
                    leftBack.setPower(backLeftPower);
                    rightFront.setPower(frontRightPower);
                    rightBack.setPower(backRightPower);
                }
            }

    }
}
