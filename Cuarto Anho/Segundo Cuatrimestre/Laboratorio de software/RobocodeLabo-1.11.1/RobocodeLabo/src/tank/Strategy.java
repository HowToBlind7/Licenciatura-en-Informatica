package laboratorio;
import robocode.*;

public sealed interface Strategy permits BasicStrategy {

    void run(JuniorRobot robot);
    void onScannedRobot(JuniorRobot robot);
    void onHitByBullet(JuniorRobot robot);
    void onHitWall(JuniorRobot robot);
}
