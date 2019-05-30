package com.qp.ribbonconsumer;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import rx.Observable;
import rx.Subscriber;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RibbonConsumerApplicationTests {

    @Test
    public void contextLoads() {
        //创建事件源
        Observable<String> observable =
                Observable.create(new Observable.OnSubscribe<String>() {
                    @Override
                    public void call(Subscriber<? super String> subscriber) {
                        subscriber.onNext("Hello RxJava");
                        subscriber.onNext("I'm XX");
                        subscriber.onCompleted();
                    }
                });
//创建订阅者
        Subscriber<String> subscriber = new Subscriber<String>() {
            @Override
            public void onCompleted() {
            }

            @Override
            public void onError(Throwable throwable) {
            }

            @Override
            public void onNext(String s) {
                System.out.println("Subscriber : " + s);
            }
        };
        // 订阅
        observable.subscribe(subscriber);

    }

}
