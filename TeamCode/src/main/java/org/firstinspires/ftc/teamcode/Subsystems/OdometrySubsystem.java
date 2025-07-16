package org.firstinspires.ftc.teamcode.Subsystems;

import com.arcrobotics.ftclib.command.SubsystemBase;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;
import org.firstinspires.ftc.teamcode.Drivers.GoBildaPinpointDriver;

public class OdometrySubsystem extends SubsystemBase {

    GoBildaPinpointDriver odo;


    public OdometrySubsystem(final HardwareMap hardwareMap) {

        odo = hardwareMap.get(GoBildaPinpointDriver.class, "odo");

        odo.setEncoderResolution(GoBildaPinpointDriver.GoBildaOdometryPods.goBILDA_4_BAR_POD);

        odo.setEncoderDirections(GoBildaPinpointDriver.EncoderDirection.FORWARD, GoBildaPinpointDriver.EncoderDirection.FORWARD);

        odo.resetPosAndIMU();

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
