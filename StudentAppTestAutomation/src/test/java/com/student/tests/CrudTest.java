package com.student.tests;

import com.github.javafaker.Faker;
import com.student.requests.RequestFactory;
import com.student.tags.Regression;
import com.student.tags.Smoke;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import io.qameta.allure.junit4.DisplayName;
import io.qameta.allure.junit4.Tag;
import io.qameta.allure.junit4.Tags;
import io.restassured.RestAssured;
import org.junit.Test;
import org.junit.experimental.categories.Category;

import java.util.ArrayList;
import java.util.List;

import static com.student.specs.SpecificationFactory.getGenericResponseSpec;
import static io.restassured.RestAssured.*;

@Story("This is a CRUD testing story")
public class CrudTest extends TestBase{
    RequestFactory requests = new RequestFactory();

    @Category(Smoke.class)
    @Story("This is a CRUD testing story of getting all students")
    @DisplayName("This is a test to get all students from the database")
    @Feature("Getting all students from the database")
    @Test
    public void getAllStudents(){
        requests.getAllStudents().then()
                .spec(getGenericResponseSpec())
                .statusCode(200);
    }

    @Category({Regression.class,Smoke.class})
    @Story("This is a CRUD testing story of creating a new student")
    @DisplayName("This is a test to create a new student")
    @Feature("Creating a new student")
    @Tag("Regression,Smoke")
    @Test
    public void creatNewStudent(){
        Faker fakeData = new Faker();
        String firstName = fakeData.name().firstName();
        String lastName=fakeData.name().lastName();
        String email=fakeData.internet().emailAddress();
        String programme="Computer Science";
        List<String> courses = new ArrayList<String>();
        courses.add("Java"); courses.add("Python"); courses.add("C++");

        requests.createNewStudent("",firstName, lastName, email, programme, courses)
                    .then()
                    .spec(getGenericResponseSpec())
                    .statusCode(201);
    }
}
