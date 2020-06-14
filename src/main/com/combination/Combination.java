package com.combination;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Combination {

    public static void main(String[] args) throws CloneNotSupportedException {
        List<String> values = Arrays.asList("A","B","C","D","E");
        List<Ennupla<String>> finalList = new ArrayList<>();
        int k = 2;
        Ennupla<String> ennupla = new Ennupla<>(new ArrayList<>(k));

        Ennupla.calculateEnnuple(ennupla, values, finalList, k, 0);
        finalList.stream().forEach(System.out::println);
    }
}
