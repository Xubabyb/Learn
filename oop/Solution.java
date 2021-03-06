package platform.kata.academy.oop;

/**
 * Создайте 3 конструктора в классе Human, 1-ый - пустой, 2-ой, который конструирует Human’a
 * от всех полей и третий, который конструирует Human’a, от всех полей, кроме любимого вида спорта.
 * Для успешного тестирования решения важно объявлять аргументы в конструкторах именно в том порядке,
 * в котором они написаны в данном описании (возраст (age), имя (name), фамилия (secondName) и любимый
 * вид спорта (favoriteSport)) В методе main создайте 3 экземпляра человека используя 3 этих разных
 * конструктора. поля класса должны иметь размерность, не превышающую необходимую.
 * Класс должен быть объявлен статическим, метод main не должен находиться в классе,
 * поля класса должны иметь доступ только внутри класса
 */
public class Solution {

    public static void main(String[] args) {

        Human one = new Human();
        Human two = new Human((byte) 35, "Robin", "Bobin", "Box");
        Human three = new Human((byte) 25, "Batman", "Forever");
    }

    public static class Human {

        private byte age;
        private String name;
        private String secondName;
        private String favoriteSport;

        public Human() {
        }

        public Human(byte age, String name, String secondName, String favoriteSport) {
           this(age, name, secondName);
            /* this.age = age;
            this.name = name;
            this.secondName = secondName;*/
            this.favoriteSport = favoriteSport;
        }

        public Human(byte age, String name, String secondName) {
            this.age = age;
            this.name = name;
            this.secondName = secondName;
        }
    }
}
