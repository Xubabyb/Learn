package platform.kata.academy.modul01;

public class Group {
    public static void main(String[] args) {
        Group group = new Group();
        System.out.println(group.determineGroup(77));
        printOddNumbers(new int[]{3,5,20,8,7,3,100});
    }

    public int determineGroup(int age) {
        return (age >= 7 && age <= 13) ? 1 : (age >= 14 && age <= 17) ? 2
                : (age >= 18 && age <= 65) ? 3 : -1;
    }

    public static void printOddNumbers(int[] arr) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int j : arr) {
            if (j % 2 != 0) {
                stringBuilder.append(j).append(",");
            }
        }
        if (!stringBuilder.isEmpty() && (stringBuilder.lastIndexOf(",") == stringBuilder.toString().length() - 1)) {
            stringBuilder.deleteCharAt(stringBuilder.toString().length() - 1);
        }
        System.out.println(stringBuilder);
    }
}
