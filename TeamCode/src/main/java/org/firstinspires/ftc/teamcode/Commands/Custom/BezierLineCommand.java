package org.firstinspires.ftc.teamcode.Commands.Custom;
import com.arcrobotics.ftclib.command.InstantCommand;
import com.pedropathing.follower.Follower;
import com.pedropathing.localization.Pose;
import com.pedropathing.pathgen.BezierCurve;
import com.pedropathing.pathgen.BezierLine;
import com.pedropathing.pathgen.Path;
import com.pedropathing.pathgen.PathChain;
import com.pedropathing.pathgen.Point;
import com.pedropathing.util.Constants;
import com.pedropathing.util.Timer;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;

import org.firstinspires.ftc.teamcode.Subsystems.RobotSubsystem;
import org.firstinspires.ftc.teamcode.pedroPathing.constants.FConstants;
import org.firstinspires.ftc.teamcode.pedroPathing.constants.LConstants;

public class BezierLineCommand extends InstantCommand {

    Pose startingPose;
    Pose endingPose;
    Follower follower;
    Path scorePreload;


    public BezierLineCommand(Pose startingPose, Pose endingPose, Follower follower){

        this.startingPose = startingPose;
        this.endingPose = endingPose;
        this.follower = follower;
    }


    @Override
    public void initialize() {

        scorePreload = new Path(new BezierLine(new Point(startingPose), new Point(startingPose)));
        scorePreload.setLinearHeadingInterpolation(startingPose.getHeading(), endingPose.getHeading());
        follower.followPath(scorePreload);

    }

}