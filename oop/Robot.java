package platform.kata.academy.oop;

public class Robot {
    private int x = 0;
    private int y = 0;
    Direction direction = Direction.UP;

    public static void main(String[] args) {
        moveRobot(new Robot(), 60, -21);

    }

    public static void moveRobot(Robot robot, int toX, int toY) {
        Direction currentValue;
        Direction requiredValueX = robot.getX() - toX < 0 ? Direction.RIGHT : Direction.LEFT;
        Direction requiredValueY = robot.getY() - toY < 0 ? Direction.UP : Direction.DOWN;
        if (robot.getX() != toX) {
            while ((currentValue = robot.getDirection()) != requiredValueX) {
                if ((requiredValueX == Direction.RIGHT && currentValue == Direction.UP) ||
                        (requiredValueX == Direction.LEFT && currentValue == Direction.DOWN)) {
                    robot.turnRight();
                } else {
                    robot.turnLeft();
                }
            }
            while (robot.getX() != Math.abs(toX)) {
                robot.stepForward();
            }
        }
        if (robot.getY() != toY) {
            while ((currentValue = robot.getDirection()) != requiredValueY) {
                if ((requiredValueY == Direction.UP && currentValue == Direction.LEFT) ||
                        (requiredValueY == Direction.DOWN && currentValue == Direction.RIGHT)) {
                    robot.turnRight();
                } else {
                    robot.turnLeft();
                }
            }
            while (robot.getY() != toY) {
                robot.stepForward();
            }
        }
    }

    public Direction getDirection() {
        // текущее направление взгляда
        return direction;
    }

    public int getX() {
        // текущая координата X
        return x;
    }

    public int getY() {
        // текущая координата Y
        return y;
    }

    public void turnLeft() {
        switch (direction) {
            case UP -> direction = Direction.LEFT;
            case RIGHT -> direction = Direction.UP;
            case DOWN -> direction = Direction.RIGHT;
            case LEFT -> direction = Direction.DOWN;
            default -> {
            }
        }

        System.out.println("turn left");
        // повернуться на 90 градусов против часовой стрелки
    }

    public void turnRight() {
        if (direction == Direction.UP) {
            direction = Direction.RIGHT;
        } else if (direction == Direction.RIGHT) {
            direction = Direction.DOWN;
        } else if (direction == Direction.DOWN) {
            direction = Direction.LEFT;
        } else if (direction == Direction.LEFT) {
            direction = Direction.UP;
        }
        System.out.println("turn right");
        // повернуться на 90 градусов по часовой стрелке
    }

    public void stepForward() {
        if (direction == Direction.UP || direction == Direction.DOWN) {
            this.y++;
        } else {
            this.x++;
        }
        System.out.println("делаю шаг вперед");
        // шаг в направлении взгляда
        // за один шаг робот изменяет одну свою координату на единицу
    }
}

