package pract21;

import java.util.Arrays;
import java.util.List;

class AnyTypeArray<E> {
    private E[] internalArray;
    private List<E> internalList;

    public AnyTypeArray(E[] internalArray) {
        this.internalArray = internalArray;
    }

    public E[] getInternalArray() {
        return internalArray;
    }

    public void setInternalArray(E[] internalArray) {
        this.internalArray = internalArray;
    }

    public E get(int index) {
        if (index >= internalArray.length) throw new IndexOutOfBoundsException("Index out of range");
        return internalArray[index];
    }

    public List<E> saveAsList() {
        internalList = Arrays.asList(internalArray);
        int i = 0;
        for (E elem : internalList) {
            System.out.println(elem);
            if (i == 4) break;
            i++;
        }
        return internalList;
    }
}

public class ex2 {
    public static void main(String[] args) {
        String[] strs = {"hello", "how", "are", "you"};
        Integer[] ints = {1,2,3,4,5,6,7};

        AnyTypeArray<String> strsArray = new AnyTypeArray<>(strs);
        AnyTypeArray<Integer> intsArray = new AnyTypeArray<>(ints);

        System.out.println(strsArray.get(0));
        System.out.println(intsArray.get(0));

        strsArray.saveAsList();
        intsArray.saveAsList();
    }
}
