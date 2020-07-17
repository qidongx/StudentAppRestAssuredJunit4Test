package com.student.tests;

import com.student.util.PropertyReader;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.rules.TestRule;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.port;

public class TestBase {
    public static PropertyReader prop;

    @Rule
    public TestRule listner = new TestWatcher() {
        @Override
        protected void succeeded(Description description) {
            super.succeeded(description);
            System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
            System.out.println("Test succeded: "+description.getMethodName().toUpperCase());
            System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        }
        @Override
        protected void failed(Throwable e, Description description) {
            super.failed(e, description);
            System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
            System.out.println("Test failed: "+description.getMethodName().toUpperCase());
            System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        }
        @Override
        protected void starting(Description description) {
            super.starting(description);
            System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
            System.out.println("Test started: "+description.getMethodName().toUpperCase());
            System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        }
        @Override
        protected void finished(Description description) {
            super.finished(description);
            System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
            System.out.println("Test ended: "+description.getMethodName().toUpperCase());
            System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        }
    };

    @BeforeClass
    public static void initUrl(){
        prop = PropertyReader.getInstance();
        baseURI = prop.getProperty("baseUrl");
        port=Integer.valueOf(prop.getProperty("port"));
    }
}
