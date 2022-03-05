package platform.kata.academy.task4;

public class SolutionRobot {
    public static void moveRobot(RobotConnectionManager robotConnectionManager, int toX, int toY) {
        RobotConnection robotConnection = null;

        for (int i = 0; i < 3; i++) {
            try {
                robotConnection = robotConnectionManager.getConnection();
                if (robotConnection != null) {
                    robotConnection.moveRobotTo(toX, toY);
                    break;
                }
                if (i == 2) {
                    throw new RobotConnectionException("number connection 3");
                }
            } catch (RobotConnectionException e) {
                System.out.println(e.getMessage());
            } catch (Exception e) {
                throw e;
            } finally {
                try {
                    robotConnection.close();
                } catch (Exception e) {

                }
            }
        }
    }
}
