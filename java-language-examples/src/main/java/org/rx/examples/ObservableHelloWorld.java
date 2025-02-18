package org.rx.examples;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.schedulers.Schedulers;

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
        System.out.println("on next"+s);
        System.out.println(Thread.currentThread());

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
    Observable<String> observable = Observable.just("Hello", "RxJava");
    observable
        .subscribeOn(Schedulers.io())          // Runs on a background I/O thread
        .observeOn(Schedulers.computation())
        .subscribe(listener);

    Thread.sleep(2000);
  }
}
