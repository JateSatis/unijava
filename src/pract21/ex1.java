package pract21;

import java.util.Arrays;
import java.util.List;

class StringNumberToList {
    public static <E> List<E> convertStringNumberToList(E[] array) {
        return Arrays.asList(array);
    }
}

public class ex1 {
    public static void main(String[] args) {
        String[] strs = {"hello", "how", "are", "you"};
        List<String> strsList = StringNumberToList.convertStringNumberToList(strs);
    }
}
