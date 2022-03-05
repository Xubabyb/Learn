package platform.kata.academy.oop;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution2 {
    List<ArrayList> alist = new ArrayList<ArrayList>();
    ArrayList <List> list = new ArrayList<>();
    public static void main(String[] args) {

        AsciiCharSequence asciiCharSequence = new AsciiCharSequence("abcdefghij".getBytes());
        System.out.println(asciiCharSequence);
        System.out.println(asciiCharSequence.length());
        System.out.println(asciiCharSequence.charAt(3));
        // System.out.println(asciiCharSequence.charAt(25));
        System.out.println((char) 25);
    }

    public static class AsciiCharSequence implements CharSequence {
        private final byte[] sequence;

        public AsciiCharSequence(byte[] sequence) {
            this.sequence = sequence;
        }

        @Override
        public String toString() {
            char[] ch = new char[sequence.length];

            for (int i = 0; i < sequence.length; i++) {

                ch[i] = charAt(i);
            }
            //.forEach(x-> System.out.print((char) x));
            //this.chars().mapToObj(x->charAt(x)).forEach(System.out::print);
            return new String(new StringBuilder(this));//new String(new char[]{i->Array.getChar(sequence,i)});//.toString();//Arrays.toString(ch);
        }

        /**
         * Returns the length of this character sequence.  The length is the number
         * of 16-bit {@code char}s in the sequence.
         *
         * @return the number of {@code char}s in this sequence
         */
        @Override
        public int length() {

            return sequence.length;
        }

        /**
         * Returns the {@code char} value at the specified index.  An index ranges from zero
         * to {@code length() - 1}.  The first {@code char} value of the sequence is at
         * index zero, the next at index one, and so on, as for array
         * indexing.
         *
         * <p>If the {@code char} value specified by the index is a
         * <a href="{@docRoot}/java.base/java/lang/Character.html#unicode">surrogate</a>, the surrogate
         * value is returned.
         *
         * @param index the index of the {@code char} value to be returned
         * @return the specified {@code char} value
         * @throws IndexOutOfBoundsException if the {@code index} argument is negative or not less than
         *                                   {@code length()}
         */
        @Override
        public char charAt(int index) {

            return (char) sequence[index];
        }

        /**
         * Returns a {@code CharSequence} that is a subsequence of this sequence.
         * The subsequence starts with the {@code char} value at the specified index and
         * ends with the {@code char} value at index {@code end - 1}.  The length
         * (in {@code char}s) of the
         * returned sequence is {@code end - start}, so if {@code start == end}
         * then an empty sequence is returned.
         *
         * @param start the start index, inclusive
         * @param end   the end index, exclusive
         * @return the specified subsequence
         * @throws IndexOutOfBoundsException if {@code start} or {@code end} are negative,
         *                                   if {@code end} is greater than {@code length()},
         *                                   or if {@code start} is greater than {@code end}
         */
        @NotNull
        @Override
        public CharSequence subSequence(int start, int end) {
            if (start == end) {
                return new AsciiCharSequence(new byte[0]);
            }
            AsciiCharSequence asciiCharSequence = new AsciiCharSequence(new byte[end - start]);
            System.arraycopy(sequence, --start, asciiCharSequence.sequence, 0, asciiCharSequence.length());
            return new AsciiCharSequence(Arrays.copyOfRange(sequence, start, end));
        }
    }

}
