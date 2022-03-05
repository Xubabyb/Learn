package platform.kata.academy.task4;

public class Solution {
    public static class Car implements AutoCloseable {
        @Override
        public void close() {
            System.out.println("Машина закрывается...");
        }

        public void drive() {
            System.out.println("Машина поехала.");
        }
    }

    public static void main(String[] args) {
        try (Car car = new Car()) {
            car.drive();
        } 
    }
}
