package io.infinite.carburetor.tests

import org.testng.annotations.Test
import org.springframework.util.ClassUtils

//@RunWith(SpringRunner.class)
class SpringBootAppTest {

    @Test
    void test() {
        GroovyClassLoader groovyClassLoader = new GroovyClassLoader(ClassUtils.getClassLoader())
        Class appClass = groovyClassLoader.parseClass("""
package io.infinite.carburetor.tests

import io.infinite.carburetor.CarburetorLevel
import io.infinite.carburetor.TestCarburetor
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.context.ApplicationContext
import org.springframework.beans.factory.annotation.Autowired
import groovy.util.logging.Slf4j

@SpringBootApplication
@Slf4j
class SpringBootApp implements CommandLineRunner {
    
    void run(String... args) throws Exception {
        thisInstance.bar()    
        runWithLogging()
    }

    @TestCarburetor(level = CarburetorLevel.EXPRESSION)
    void runWithLogging() {
        def foo = bar()
    }
    
    void bar() {
        log.info("SpringBootAppTest OK" + this.toString())
    }
    
    static void main(String[] args) {
        SpringApplication.run(SpringBootApp.class, [] as String)
    }
    
}
""")
        groovyClassLoader.loadClass("io.infinite.carburetor.tests.SpringBootApp")
        Thread.currentThread().setContextClassLoader(groovyClassLoader)
        appClass.main()
    }

}