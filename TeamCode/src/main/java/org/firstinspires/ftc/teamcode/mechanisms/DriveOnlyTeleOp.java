package org.firstinspires.ftc.teamcode.mechanisms;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

/**
 * STUDENT ENTRY POINT -- 01 Drive Only.
 * Copy the entire starter package, then select this name on the Driver Station.
 * This class owns WHEN the program runs; the helper classes own HOW it works.
 * Author: Connor Hubble | Tennessee Robotics Center
 */
@TeleOp(name = "01 Drive Only", group = "TRC Starter")
public class DriveOnlyTeleOp extends OpMode {
    private final MecanumDrive drive = new MecanumDrive();
    private long previousLoopNanos;

    @Override
    public void init() {
        // SDK calls init() ONCE after INIT. It does not repeat like loop().
        // Only the subsystems used by this lesson are looked up in hardwareMap.
        try {
            drive.init();
        } catch (RuntimeException failure) {
            // Clean up devices that were already initialized, then keep the
            // real error visible so the team can correct its configuration.
            stopOutputs();
            throw failure;
        }
        telemetry.addLine("Ready. Read README controls before pressing START.");
        telemetry.addLine("Gamepad 1 = driver; Gamepad 2 = mechanism operator.");
        telemetry.addLine("BACK on either controller ends this OpMode.");
        telemetry.update();
    }

    @Override
    public void start() {
        // SDK calls start() ONCE when START is pressed.
        previousLoopNanos = System.nanoTime();
    }

    @Override
    public void loop() {
        // SDK calls loop() REPEATEDLY. Never add your own infinite loop here.
        // Each update does a little work and returns so all systems stay responsive.
        if (gamepad1.back || gamepad2.back) {
            stopOutputs();
            requestOpModeStop(); // Ends the program; release cannot restart it.
            return;
        }
        long now = System.nanoTime();
        double dt = ControlMath.clip((now - previousLoopNanos) / 1_000_000_000.0,
                0.0, 0.05);
        previousLoopNanos = now;
        // Limit dt to 50 ms: a delayed loop must not produce a large servo jump.
        drive.update(gamepad1, telemetry);
        telemetry.update(); // Helpers add data; publish one combined update here.
    }

    @Override
    public void stop() {
        // SDK calls stop() when the OpMode ends. Always send explicit zero power.
        stopOutputs();
    }

    private void stopOutputs() {
        drive.stop();
    }
}
