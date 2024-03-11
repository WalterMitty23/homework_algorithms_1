package Integer;

import main.StringListImpl;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        StringListImpl stringList = new StringListImpl();
        stringList.add("Str0");
        stringList.add("Str1");
        stringList.add("Str2");
        stringList.add("Str3");
        stringList.add("Str4");
        stringList.add("Str5");
        stringList.add("Str6");
        stringList.add("Str7");
        stringList.add(5, "STR");
        String[] array = stringList.toArray();
        System.out.println(Arrays.toString(array));
        IntegerListImpl integerList = new IntegerListImpl();
        Integer[] arrayInteger = new Integer[100000];
        SortedMethodAnalise.createArray(arrayInteger);

        integerList.toArray(arrayInteger);

        long start1 = System.currentTimeMillis();
        SortedMethodAnalise.sortBubble(integerList.toArray(arrayInteger));
        System.out.println("sortBubble = " + (System.currentTimeMillis() - start1));
        long start2 = System.currentTimeMillis();
        SortedMethodAnalise.sortSelection(integerList.toArray(arrayInteger));
        System.out.println("sortSelection = " + (System.currentTimeMillis() - start2));
        long start3 = System.currentTimeMillis();
        SortedMethodAnalise.sortInsertion(integerList.toArray(arrayInteger));
        System.out.println("sortInsertion = " + (System.currentTimeMillis() - start3));
    }
}