package org.firstinspires.ftc.teamcode.Config.Core;


import static org.firstinspires.ftc.teamcode.Config.Core.Util.Opmode.AUTONOMOUS;
import static org.firstinspires.ftc.teamcode.Config.Core.Util.Opmode.TELEOP;

import com.arcrobotics.ftclib.command.CommandScheduler;
import com.arcrobotics.ftclib.gamepad.GamepadEx;
import com.arcrobotics.ftclib.gamepad.GamepadKeys;
import com.pedropathing.follower.Follower;
import com.pedropathing.localization.Pose;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.teamcode.Config.Commands.Custom.LMECControl;
import org.firstinspires.ftc.teamcode.Config.Core.Util.Alliance;
import org.firstinspires.ftc.teamcode.Config.Core.Util.Opmode;
import org.firstinspires.ftc.teamcode.Config.Subsystems.DriveSubsystem;
import org.firstinspires.ftc.teamcode.Config.Subsystems.LMECSubsystem;
import org.firstinspires.ftc.teamcode.Config.Subsystems.SlideSubsystem;
import org.firstinspires.ftc.teamcode.Config.pedroPathing.constants.Constants;
import org.firstinspires.ftc.teamcode.Config.pedroPathing.constants.FConstants;
import org.firstinspires.ftc.teamcode.Config.pedroPathing.constants.LConstants;


public class RobotContainer {

    public SlideSubsystem slides;

    public DriveSubsystem drive;
    public Follower follower;
    public LMECSubsystem lmec;
    protected GamepadEx driverPad;
    protected GamepadEx operatorPad;

    private Alliance alliance;
    private Opmode opmode;
    public CommandScheduler cs = CommandScheduler.getInstance();

    public enum FSMStates {
        INTAKE,
        HANG,
        OUTTAKE,
        SPECIMEN,
        FOLD,
        NONE
    }
    //CONSTRUCTOR FOR AUTO TEST
    public RobotContainer(HardwareMap hardwareMap, Pose startPose, Alliance alliance){
        this.opmode = AUTONOMOUS;
        this.alliance = alliance;

        follower = new Follower(hardwareMap, FConstants.class, LConstants.class);
        drive = new DriveSubsystem(hardwareMap, follower);

//        intake = new IntakeSubsystem(hardwareMap, telemetry);
//        wrist = new WristSubsystem(hardwareMap, telemetry);
//        slides = new SlideSubsystem(hardwareMap);
        lmec = new LMECSubsystem(hardwareMap);

        follower.setStartingPose(Constants.startpose);
        CommandScheduler.getInstance().registerSubsystem(drive, lmec);

    }
    public RobotContainer(HardwareMap hardwareMap, Gamepad driver, Gamepad operator, Alliance alliance){
        this.opmode = TELEOP;
        this.alliance = alliance;
        this.driverPad = new GamepadEx(driver);
        this.operatorPad = new GamepadEx(operator);

        follower = new Follower(hardwareMap, FConstants.class, LConstants.class);
        drive = new DriveSubsystem(hardwareMap, follower);

//        intake = new IntakeSubsystem(hardwareMap, telemetry);
//        wrist = new WristSubsystem(hardwareMap, telemetry);
//        slides = new SlideSubsystem(hardwareMap);
        lmec = new LMECSubsystem(hardwareMap);

        follower.setStartingPose(Constants.startpose);
        CommandScheduler.getInstance().registerSubsystem(drive);

    }

    public void periodic() {
//        t.addData("path", f.getCurrentPath());

//        e.periodic();
//        l.periodic();
//        i.periodic();
//        o.periodic();
        follower.update();
//        t.update();
    }
    public void tStart(){
        follower.startTeleopDrive();
    }

    public void teleOpControl(){

        follower.setTeleOpMovementVectors(driverPad.getLeftY(), -driverPad.getLeftX(), -driverPad.getRightX() * 0.5 , false);

        driverPad.getGamepadButton(GamepadKeys.Button.RIGHT_BUMPER).toggleWhenPressed(
                new LMECControl(lmec, false),
                new LMECControl(lmec, true)
        );

    }
    public FSMStates robotState = FSMStates.NONE;





    public void update() {
        CommandScheduler.getInstance().run();


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

    public Follower getFollower() {
        return follower;
    }

}