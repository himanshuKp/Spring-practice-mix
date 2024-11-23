package com.luv2code.spring_core_demo.common;

import io.micrometer.observation.Observation;

import java.util.List;
import java.util.stream.Collectors;

public class Test {
    public static void main(String[] args) {
        List<Integer> objList = List.of(1,12,2,45,5,4,4,4,7,8,8,8,7,7);
        List<Integer> uniqList = objList.stream().distinct().filter(el->el>4).collect(Collectors.toList());
        System.out.println(uniqList);
    }
}