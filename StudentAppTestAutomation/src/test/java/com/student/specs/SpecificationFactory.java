package com.student.specs;

import com.student.tests.TestBase;
import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import java.util.concurrent.TimeUnit;

import static org.hamcrest.Matchers.lessThan;

public class SpecificationFactory extends TestBase {

    public static synchronized ResponseSpecification getGenericResponseSpec(){
        ResponseSpecBuilder responseSpecBuilder;
        ResponseSpecification responseSpec;

        responseSpecBuilder = new ResponseSpecBuilder();
        responseSpecBuilder.expectHeader("Content-Type","application/json;charset=UTF-8");
        responseSpecBuilder.expectHeader("Transfer-Encoding", "chunked");
        responseSpecBuilder.expectResponseTime(lessThan(5L), TimeUnit.SECONDS);

        responseSpec = responseSpecBuilder.build();
        return responseSpec;
    }

    public static synchronized RequestSpecification logPayloadResponseInfo(){
        RequestSpecBuilder logBuilder;
        RequestSpecification logSpecification;

        logBuilder = new RequestSpecBuilder();
        if (prop.getProperty("log").equals("ENABLE")) {
            logBuilder.addFilter(new AllureRestAssured());
        }
        logSpecification = logBuilder.build();

        return logSpecification;
    }

}
