package org.firstinspires.ftc.teamcode.TeleOp;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.arcrobotics.ftclib.command.CommandOpMode;

import org.firstinspires.ftc.teamcode.Subsystems.Drivebase;

@TeleOp
public class TestTeleOp extends CommandOpMode {
    public Drivebase drivebase;

    @Override
    public void initialize() {
        drivebase = new Drivebase(hardwareMap);
    }

    @Override
    public void run() {
        super.run();
        drivebase.drive(gamepad1.left_stick_x, gamepad1.left_stick_y, gamepad1.right_stick_x);
    }
}
