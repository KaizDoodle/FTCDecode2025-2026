package org.firstinspires.ftc.teamcode.Subsystems;


import com.arcrobotics.ftclib.command.CommandScheduler;
import com.pedropathing.follower.Follower;
import com.pedropathing.localization.Pose;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.teamcode.pedroPathing.constants.FConstants;
import org.firstinspires.ftc.teamcode.pedroPathing.constants.LConstants;


public abstract class RobotSubsystem extends OpMode {

    public SlideSubsystem slides;

    public DriveSubsystem drive;
    public Follower follower;


    public CommandScheduler cs = CommandScheduler.getInstance();

    public enum FSMStates {
        INTAKE,
        HANG,
        OUTTAKE,
        SPECIMEN,
        FOLD,
        NONE
    }
    public FSMStates robotState = FSMStates.NONE;

    public void initialize(HardwareMap hardwareMap, Pose startPose) {
        follower = new Follower(hardwareMap, FConstants.class, LConstants.class);
        drive = new DriveSubsystem(hardwareMap, follower);

//        intake = new IntakeSubsystem(hardwareMap, telemetry);
//        wrist = new WristSubsystem(hardwareMap, telemetry);
//        slides = new SlideSubsystem(hardwareMap);
//        lmec = new LMECSubsystem(hardwareMap);

        follower.setStartingPose(startPose);
        CommandScheduler.getInstance().registerSubsystem(drive);

    }


    //TODO we probably dont need to but we could add in pos commands to get the pose of stuff just in case its used later
//    public Command intakePos() {
//        return new IntakePosCommand(slides, wrist, intake).alongWith(new InstantCommand(() -> setState(FSMStates.INTAKE)));
//    }

    public void update() {
        CommandScheduler.getInstance().run();
        telemetry.update();

    }
    public void end() {
        cs.reset();
    }


    public void setState(FSMStates state) {
        robotState = state;
    }

    public FSMStates getState() {
        return robotState;
    }



}