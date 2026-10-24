package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.teamcode.mechanisms.Motors;
import org.firstinspires.ftc.teamcode.mechanisms.Servo;

@TeleOp
public class TestTurrent extends OpMode {

    Servo spin = new Servo();
    Motors launch = new Motors();
    @Override
    public void init() {
        spin.init(hardwareMap);
        launch.init(hardwareMap);
    }

    @Override
    public void loop() {
        if (gamepad1.b) {
            spin.setServoRot(1.0);
        }
        else {
            spin.setServoRot(0);
        }
        if (gamepad1.a) {
            launch.setMotorSpeed(0.5);
        }
        else {
            launch.setMotorSpeed(0);
        }
    }
}


