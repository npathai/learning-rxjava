package com.github.npathai;


import rx.Observable;

public class HelloWorld {

    public static void main(String[] args) {

        // Create an observable with single value
        Observable.<String>create(subscriber -> {
            // Provides observer with new value to observe
            subscriber.onNext("Hello World!");

            // Notifies the observer that all push messages are completed
            subscriber.onCompleted();
        }).subscribe(System.out::println);

        // Create an observable with single value with helper method
        Observable.just("Hello World!")
                .subscribe(System.out::println);


        // Adding onError and completed listeners
        // Completed listener is invoked once the observable is completed sending all values
        Observable.just("Hello World!")
                .subscribe(System.out::println, System.err::println, () -> System.out.println("Done"));

        // Error propagation
        Observable.create(subscriber -> {
            try {
                subscriber.onNext("Hello world!");
                subscriber.onCompleted();
            } catch (Exception ex) {
                subscriber.onError(ex);
            }
        }).subscribe(System.out::println);



    }
}
