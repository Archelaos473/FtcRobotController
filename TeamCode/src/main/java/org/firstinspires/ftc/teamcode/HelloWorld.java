package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@TeleOp(name = "Hello World", group = "Test")
public class HelloWorld extends LinearOpMode {

    @Override
    public void runOpMode() {
        telemetry.addData("Status", "Hello World");
        telemetry.update();

        waitForStart();

        while (opModeIsActive()) {
            telemetry.addData("Message", "Hello World");
            telemetry.addData("Runtime (s)", getRuntime());
            telemetry.update();
        }
    }
}
