package platform.kata.academy.modul01;

public class Palindrom {
    public static void main(String[] args) {

        String[] strMass = new String[] { " Sum   mussum Mus"/* Латынь */, "Madam  i'm Adam", "Could you help me" };

        for (String str : strMass) {

            String result = checkPalindrom(str) ? " - палиндром" : " - не палиндром";

            System.out.println(str + result);
        }

    }

    public static boolean checkPalindrom(String s) {

        boolean bool = true;

        s = deleteCharacter(s);

        for (int i = 0; i < s.length() / 2; i++) {

            String a = String.valueOf(s.charAt(i));

            String b = String.valueOf(s.charAt(s.length() - 1 - i));

            if (!a.equalsIgnoreCase(b)) {

                bool = false;

                //System.out.println(i);

                break;
            }
        }

        return bool;
    }

    public static String deleteCharacter(String s) {

        StringBuilder x = new StringBuilder();

//		char[] massCh = s.toCharArray();

        for (int i = 0; i < s.length(); i++) {

            if (s.charAt(i) != ' ' && s.charAt(i) != '\'') {

                x.append(s.charAt(i));
            }
        }
        s = x.toString();

        return s.trim();
    }
}
