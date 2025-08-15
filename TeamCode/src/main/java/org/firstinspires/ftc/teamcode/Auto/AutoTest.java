package org.firstinspires.ftc.teamcode.Auto;
import com.pedropathing.follower.Follower;
import com.pedropathing.localization.Pose;
import com.pedropathing.pathgen.BezierCurve;
import com.pedropathing.pathgen.BezierLine;
import com.pedropathing.pathgen.Path;
import com.pedropathing.pathgen.PathChain;
import com.pedropathing.pathgen.Point;
import com.pedropathing.util.Timer;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;

import org.firstinspires.ftc.teamcode.Commands.Custom.BezierLineCommand;
import org.firstinspires.ftc.teamcode.Subsystems.RobotSubsystem;
import org.firstinspires.ftc.teamcode.pedroPathing.constants.Constants;
import org.firstinspires.ftc.teamcode.pedroPathing.constants.FConstants;
import org.firstinspires.ftc.teamcode.pedroPathing.constants.LConstants;

@Autonomous
public class AutoTest extends RobotSubsystem {


    Path scorePreload;
    public void buildPaths() {
        scorePreload = new Path(new BezierLine(new Point(Constants.startpose), new Point(Constants.startpose)));
        scorePreload.setLinearHeadingInterpolation(Constants.endingPose.getHeading(), Constants.endingPose.getHeading());
    }


    @Override
    public void init() {
        initialize(hardwareMap);

        buildPaths();
    }

    @Override
    public void loop() {
        if (!follower.isBusy())
            follower.followPath(scorePreload);
        follower.update();


    }
}
