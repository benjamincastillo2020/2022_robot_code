package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;


@Autonomous
public class Auto extends LinearOpMode {

    private DcMotor Left_Drive;
    private DcMotor Right_Drive;



    @Override

    public void runOpMode() throws InterruptedException {
        
        Right_Drive = hardwareMap.get(DcMotor.class, "Right_Drive");
        Left_Drive = hardwareMap.get(DcMotor.class, "Left_Drive");
        Right_Drive.setDirection(DcMotor.Direction.REVERSE);
        telemetry.addData("Status", "Initialized");
        telemetry.addData("Color", "Null");
        telemetry.update();
        
        waitForStart();
        //place code under here
        moveForward(100, 5);
        turnLeft(100,3);
        turnRight(100,1);

        //end
    }
    
    private void moveForward(long power, double seconds ) {
        power /= 100;
        seconds *= 1000;
        long secondsI = (long)seconds;
        Right_Drive.setPower(power);
        Left_Drive.setPower(power);
        sleep(secondsI);
    }
    private void turnLeft (long power, double seconds ) {
        power /= 100;
        seconds *= 1000;
        long secondsI = (long)seconds;
        Right_Drive.setPower(power);
        Left_Drive.setPower(power * -1);
        sleep(secondsI);
    }

    private void turnRight (long power, double seconds ) {
        power /= 100;
        seconds *= 1000;
        long secondsI = (long)seconds;
        Right_Drive.setPower(power * -1);
        Left_Drive.setPower(power);
        sleep(secondsI);
    }
    
}
