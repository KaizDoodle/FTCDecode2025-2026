package org.firstinspires.ftc.teamcode.Subsystems;

import com.arcrobotics.ftclib.command.SubsystemBase;
import com.pedropathing.follower.Follower;
import com.qualcomm.hardware.lynx.LynxModule;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.IMU;

import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;

import org.firstinspires.ftc.teamcode.Drivers.GoBildaPinpointDriver;
import org.firstinspires.ftc.teamcode.pedroPathing.constants.FConstants;
import org.firstinspires.ftc.teamcode.pedroPathing.constants.LConstants;

public class DriveSubsystem extends SubsystemBase {
    GoBildaPinpointDriver odo;
    Follower follower;


    public DriveSubsystem(final HardwareMap hardwareMap, Follower follower) {
        this.follower = follower;
    }

    public void driveFieldCentric(double left_stick_x, double left_stick_y , double gamepadRX) {
        follower.setTeleOpMovementVectors(-left_stick_y, -left_stick_x, -gamepadRX, false);
        follower.update();
    }

    public double getHeadingRads() {
        return odo.getHeading(AngleUnit.RADIANS);
    }

    public double getHeadingDeg() {
        return odo.getHeading(AngleUnit.DEGREES);
    }

    public void resetHeading(){
        odo.recalibrateIMU();
    }

    public void odoUpdate() {
        odo.update();

    }


}

