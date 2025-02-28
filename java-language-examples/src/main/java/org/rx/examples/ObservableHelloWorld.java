package org.rx.examples;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.schedulers.Schedulers;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ObservableHelloWorld {
  public static void main(String[] args) throws InterruptedException {

    Observer<String> listener = new Observer<String>() {
      @Override
      public void onSubscribe(@NonNull Disposable d) {
        System.out.println("subscribed");
        System.out.println(Thread.currentThread());
      }

      @Override
      public void onNext(@NonNull String s) {
        System.out.println("on next: "+s);
        System.out.println(Thread.currentThread());
        try {
          Thread.sleep(2000);
        } catch (InterruptedException e) {
          throw new RuntimeException(e);
        }

      }

      @Override
      public void onError(@NonNull Throwable e) {
        System.out.println("error occurred");
        System.out.println(Thread.currentThread());

      }

      @Override
      public void onComplete() {
        System.out.println("complete");
        System.out.println(Thread.currentThread());
      }
    };

    ExecutorService executorService = Executors.newFixedThreadPool(5);


    Observable.just("Hello", "World", "India")
        .flatMap(item -> Observable.just(item)
            .subscribeOn(Schedulers.from(executorService))  // Assign different items to different threads
            .map(str -> {
              System.out.println("Processing: " + str + " on " + Thread.currentThread().getName());
              return str;
            })
        )
        .subscribe(result -> System.out.println("Received: " + result + " on " + Thread.currentThread().getName()));

    Thread.sleep(5000000);
  }
}
