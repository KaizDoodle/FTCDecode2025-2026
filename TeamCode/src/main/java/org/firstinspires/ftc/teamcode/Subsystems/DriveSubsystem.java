package org.firstinspires.ftc.teamcode.Subsystems;

import com.arcrobotics.ftclib.command.SubsystemBase;
import com.qualcomm.hardware.lynx.LynxModule;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.IMU;

import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;

import org.firstinspires.ftc.teamcode.Drivers.GoBildaPinpointDriver;

public class DriveSubsystem extends SubsystemBase {

    DcMotor leftFront;
    DcMotor leftBack;
    DcMotor rightBack;
    DcMotor rightFront;
    

    public DriveSubsystem(final HardwareMap hardwareMap) {
        for (LynxModule module : hardwareMap.getAll(LynxModule.class)) {
            module.setBulkCachingMode(LynxModule.BulkCachingMode.AUTO);
        }
        leftFront = hardwareMap.get(DcMotorEx.class, "frontLeft");
        leftBack = hardwareMap.get(DcMotorEx.class, "backLeft");
        rightBack = hardwareMap.get(DcMotorEx.class, "backRight");
        rightFront = hardwareMap.get(DcMotorEx.class, "frontRight");


        leftFront.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        leftBack.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        rightBack.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        rightFront.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

        rightFront.setDirection(DcMotorSimple.Direction.REVERSE);
        rightBack.setDirection(DcMotorSimple.Direction.REVERSE);


    }



    public void driveFieldCentric(double gamepadX, double gamepadY, double gamepadRX, double heading) {
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

    public void setMotorPower (double power){
        leftFront.setPower(power);
        leftBack.setPower(power);
        rightFront.setPower(power);
        rightBack.setPower(power);
    }


}

