package ru.otus.sort;

import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
import java.util.Random;

public class Sort {
    public static void main(String[] args){
        List<Integer> numbers1 = new ArrayList<>();
        List<Integer> numbers2 = new ArrayList<>();
        for(int i = 0; i<100; i++){
            int n = new Random().nextInt(100)+1;
            numbers1.add(n);
            numbers2.add(n);
        }

        System.out.println("Сортировка \"пузырьком\"");
        System.out.println("До: "+numbers1);

        long time1 = System.currentTimeMillis();
        // Сортировка "пузырьком"
        sortBobble(numbers1);

        System.out.println("Время: "+(System.currentTimeMillis()-time1));
        System.out.println("После: "+numbers1);
        System.out.println();

        System.out.println("Сортировка Collections.sort");
        System.out.println("До: "+numbers2);

        time1 = System.currentTimeMillis();
        // Сортировка через Collections.sort
        Collections.sort(numbers2);

        System.out.println("Время: "+(System.currentTimeMillis()-time1));
        System.out.println("После: "+numbers2);
    }

    //bobble-sort
    private static void sortBobble(List<Integer> items){
        if (items.size() <= 1){
            return;
        }
        boolean sorted;
        do {
            sorted = true;
            for (int i = 0; i < items.size()-1; i++){
                if (items.get(i) > items.get(i+1)){
                    Collections.swap(items,i,i+1);
                    sorted = false;
                }
            }
        } while(! sorted);
    }
}
