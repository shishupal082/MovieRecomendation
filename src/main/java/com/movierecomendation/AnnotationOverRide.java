package com.movierecomendation;

/**
 * Created by shishupal.kumar on 03/07/15.
 */
class MySuperClass {

    public void doTheThing() {
        System.out.println("Do the thing");
    }
}

class MySubClass extends MySuperClass{
    @Override
    public void doTheThing() {
        System.out.println("Do it differently");
    }
}

public class AnnotationOverRide {
    public static void main(String args[]){
        System.out.print("Override annotation");
        new MySubClass().doTheThing();
    }
}
