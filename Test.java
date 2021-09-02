package org.firstinspires.ftc.teamcode;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

@TeleOp(name="Simple Robot Code", group="Linear Opmode")
public class PushBot extends LinearOpMode {
    
    // Declare devices
    DcMotor Left_Drive;
    DcMotor Right_Drive;

    @Override
    public void runOpMode() {
        
        //Connects devices to configuration on phone
        hardwareMap.logDevices();
        Left_Drive = hardwareMap.get(DcMotor.class, "Left_Drive");
        Right_Drive = hardwareMap.get(DcMotor.class, "right_Drive");
        Right_Drive.setDirection(DcMotor.Direction.REVERSE);
        
        //Adds telemetry to robot. Not important
        telemetry.addData("Status", "Initialized");
        telemetry.addData("Extender Position", "null");
        telemetry.update();
        
        //wait for start
        waitForStart();
        
        //Run while robot is active
        while (opModeIsActive()) {
            //sets drive variables
            int RightY = (int) gamepad1.right_stick_y;
            int LeftY = (int) gamepad1.left_stick_x;
            //sets motor to game-pad input
            Right_Drive.setPower(RightY);
            Left_Drive.setPower(LeftY);
        }
    }
}
