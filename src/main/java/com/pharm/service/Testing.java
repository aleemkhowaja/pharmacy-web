package com.pharm.service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class Testing {
    public static void main(String[] args) {

        List<String> list = Arrays.asList("1","2", "3", null);
        for(String i : list)
        {
          //  System.out.println(Optional.of(i)..toString());
        }
    }

    public static  void show() {
        try {
            System.out.println("try");
            throw new RuntimeException("");
        }catch (Exception ex) {
            System.out.println("catch ----");
        }
        finally {
            System.out.println("finally");
        }
    }
}
