package org.firstinspires.ftc.teamcode.TeleOp;

import com.arcrobotics.ftclib.command.CommandOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.Subsystems.Arm;
import org.firstinspires.ftc.teamcode.Subsystems.Drivebase;
import org.firstinspires.ftc.teamcode.Subsystems.RollerIntake;

@TeleOp
public class TeleOpV2 extends CommandOpMode {
    public Drivebase drivebase;
    public Arm arm;
    public RollerIntake intake;

    @Override
    public void initialize() {
        drivebase = new Drivebase(hardwareMap);
        arm = new Arm(hardwareMap);
        intake = new RollerIntake(hardwareMap);
    }

    @Override
    public void run() {
        super.run();
        drivebase.drive(gamepad1.left_stick_x, gamepad1.left_stick_y, gamepad1.right_stick_x);
        arm.manualRotate(gamepad2.right_stick_y);
        arm.manualExtend(gamepad2.left_stick_y);
        if (gamepad2.right_trigger-gamepad2.left_trigger>=.3) {
            intake.intake(1);
        } else if (gamepad2.left_trigger-gamepad2.right_trigger>=.3) {
            intake.intake(-1);
        }

        if (gamepad2.dpad_up) {
            intake.manualPivot(-1);
        } else if (gamepad2.dpad_down) {
            intake.manualPivot(1);
        }

        if (gamepad2.left_bumper || gamepad2.right_bumper) {
            intake.toggleLock();
        }
    }
}
