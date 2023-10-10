package org.firstinspires.ftc.teamcode.botconfigs;

import com.arcrobotics.ftclib.hardware.ServoEx;
import com.arcrobotics.ftclib.hardware.SimpleServo;
import com.arcrobotics.ftclib.hardware.motors.Motor;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.teamcode.hardware.GyroWrap;

public class PPBot extends HolonomicBot {

    public double slowSpeed = 0.4;
    public double midSpeed = 0.7;
    public double fastSpeed = 1;
    public double slideSpeed = 1;

    public ServoEx claw;
    public Motor slide;
    public GyroWrap gyro;

    public PPBot(Telemetry tele, HardwareMap map) {

        super(tele, map);
        claw = new SimpleServo(map, "leftClaw", 0, 90);
        slide = new Motor(map, "motorLS");
        gyro = new GyroWrap(null, tele, map, "gyro", 0, false);
        speedFactor = fastSpeed;
    }

    public void updateSpeed(Gamepad gamepad1) {

        if (gamepad1.a) speedFactor = midSpeed;
        if (gamepad1.b) speedFactor = slowSpeed;
        if (gamepad1.x) speedFactor = fastSpeed;
        tele.addData("speedFactor", speedFactor);
    }

    public void openClaw() {

        claw.setPosition(0.75);
    }

    public void closeClaw() {

        claw.setPosition(0.6);
    }

    public void raiseSlide(double speed) {

        slide.set(-speed * slideSpeed);
    }
}
