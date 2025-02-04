package org.firstinspires.ftc.teamcode.TeleOp;

import com.arcrobotics.ftclib.command.CommandOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.Subsystems.Arm;
import org.firstinspires.ftc.teamcode.Subsystems.Drivebase;

@TeleOp
public class TeleOpV2 extends CommandOpMode {
    public Drivebase drivebase;
    public Arm arm;

    @Override
    public void initialize() {
        drivebase = new Drivebase(hardwareMap);
        arm = new Arm(hardwareMap);
    }

    @Override
    public void run() {
        super.run();
        drivebase.drive(gamepad1.left_stick_x, gamepad1.left_stick_y, gamepad1.right_stick_x);
        arm.manualRotate(gamepad2.right_stick_y);
        arm.manualExtend(gamepad2.left_stick_y);
    }
}
