package io.infinite.carburetor.tests

import org.testng.annotations.Test

import java.util.concurrent.atomic.AtomicInteger

class CaburetorTestCase {

    private static final AtomicInteger counter = new AtomicInteger(0)

    public static final String TEST_SCRIPT_NAME_PREFIX = "TestScript"

    protected static String genericScriptName() {
        return TEST_SCRIPT_NAME_PREFIX + (counter.getAndIncrement()) + ".groovy"
    }

    static void assertScript(final String script) throws Exception {
        GroovyShell shell = new GroovyShell()
        shell.evaluate(script, genericScriptName())
    }

    @Test
    void test() {}

}
