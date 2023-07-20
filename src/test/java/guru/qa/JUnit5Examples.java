package guru.qa;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.*;

public class JUnit5Examples {

    @BeforeAll
    static void beforeAll() {
        System.out.println("beforeAll()");
        Configuration.browser = "Chrome";
    }

    @AfterAll
    static void afterAll() {
        System.out.println("afterAll()");
    }

    @BeforeEach
    void beforeEach() {
//        open("http://google.com");
        System.out.println("beforeEach()");
    }

    @AfterEach
    void afterEach() {
        System.out.println("afterEach()");
    }

    @Test
    void firstTest() {
        System.out.println("            First test");
        Assertions.assertTrue(3 > 2);
    }

    @Test
    void secondTest() {
        System.out.println("            Second test");
        Assertions.assertTrue(3 > 2);
    }

    @Test
    void thirdTest() {
        System.out.println("            Third test");
        Assertions.assertTrue(3 > 2);
    }
}
