package com.arthur.spi;

import org.junit.Test;

import java.util.ServiceLoader;

public class JavaSPITest {

    @Test
    public void testJavaSPI() {
        ServiceLoader<Robot> sl = ServiceLoader.load(Robot.class);
        sl.forEach(Robot::sayHello);
    }
}
