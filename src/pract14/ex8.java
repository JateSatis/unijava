package pract14;

import java.util.ArrayList;
import java.util.List;

interface Filter<T> {
    boolean apply(T t, String regex);
}

public class ex8 {
    public static <T> T[] filter(T[] array, Filter<T> filter, String regex) {
        List<T> filteredList = new ArrayList<>();

        for (T item : array) {
            if (filter.apply(item, regex)) {
                filteredList.add(item);
            }
        }

        T[] filteredArray = (T[]) java.lang.reflect.Array.newInstance(array.getClass().getComponentType(), filteredList.size());
        return filteredList.toArray(filteredArray);
    }

    public static void main(String[] args) {
        String[] stringArray = {"apple", "banana", "cherry", "date", "fig"};
        Filter<String> stringFilter = new Filter<String>() {
            @Override
            public boolean apply(String s, String regex) {
                return s.matches(regex);
            }
        };
        String regex = ".*a.*";
        String[] filteredStrings = filter(stringArray, stringFilter, regex);
        for (String s : filteredStrings) {
            System.out.println(s);
        }
    }
}
