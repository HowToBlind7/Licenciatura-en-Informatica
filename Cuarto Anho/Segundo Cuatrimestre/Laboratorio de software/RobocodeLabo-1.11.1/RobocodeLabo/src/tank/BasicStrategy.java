package laboratorio;

import robocode.JuniorRobot;

import static robocode.JuniorRobot.*;

public final class BasicStrategy implements Strategy {

    @Override
    public void run(JuniorRobot robot) {
        robot.setColors(orange, blue, white, yellow, black);
        robot.ahead(100);
        robot.turnGunRight(360);
        robot.back(100);
        robot.turnGunRight(360);
    }

    @Override
    public void onScannedRobot(JuniorRobot robot) {
        robot.fire(1);
    }

    @Override
    public void onHitByBullet(JuniorRobot robot) {
        robot.back(10);
    }

    @Override
    public void onHitWall(JuniorRobot robot) {
        robot.back(20);
    }
}
