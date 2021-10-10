package com.js.effectivejava.item18.wrapper;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

import static org.assertj.core.api.Assertions.assertThat;

class WrapperTest {

    @Test
    @DisplayName("호출되는 콜백 메서드가 내부 클래스(wrapped class)의 메서드이다.")
    void test_callback() throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(1);
        TestWrappedObject testWrappedObject = new TestWrappedObject(new SomeService(), countDownLatch);
        Wrapper wrapper = new Wrapper(testWrappedObject);

        wrapper.doSomething();
        boolean done = countDownLatch.await(5, TimeUnit.SECONDS);

        assertThat(done).isTrue();
    }

    private static class TestWrappedObject implements SomethingWithCallback {

        final SomeService someService;
        final CountDownLatch countDownLatch;

        TestWrappedObject(SomeService someService, CountDownLatch countDownLatch) {
            this.someService = someService;
            this.countDownLatch = countDownLatch;
        }

        @Override
        public void doSomething() {
            someService.performAsync(this);
        }

        @Override
        public void call() {
            System.out.println("TestWrappedObject call.");
            countDownLatch.countDown();
        }
    }
}
