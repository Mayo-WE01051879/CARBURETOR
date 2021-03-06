package io.infinite.carburetor.others

import groovy.util.logging.Slf4j
import io.infinite.carburetor.TestCarburetor
import io.infinite.carburetor.CarburetorLevel

@Slf4j
class Static {

    @TestCarburetor(level = CarburetorLevel.EXPRESSION)
    static void test3() {
        System.out.println("Test")
    }

    @TestCarburetor(level = CarburetorLevel.EXPRESSION)
    static void testBlackBox(Object iThis) {
        Closure c = {
            assert delegate == this
            assert owner == this
            assert thisObject == this
            assert delegate == iThis
            assert owner == iThis
            assert thisObject == iThis
            assert iThis == this
            assert iThis == this
            assert iThis == this
        }
        c()
        test3()
    }

    static void test() {
        testBlackBox(this)
    }

}
