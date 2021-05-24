package com.github.npathai;


import rx.Observable;

public class Application {

    public static void main(String[] args) {

        Observable.just(1)
                .forEach(System.out::println);


    }
}
