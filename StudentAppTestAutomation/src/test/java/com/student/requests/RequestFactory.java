package com.student.requests;

import com.student.pojo.StudentClass;
import com.student.tests.TestBase;
import io.qameta.allure.Step;
import io.restassured.response.Response;
import org.junit.Test;

import java.util.List;

import static io.restassured.RestAssured.given;

public class RequestFactory extends TestBase {
    RestClient restClient = new RestClient();

    @Step("Getting all students info from the database.")
    public Response getAllStudents(){
        Response respoonse = restClient.doGetRequest("/list");
        return respoonse;
    }

    @Step("Getting a student's info by Id: {0}")
    public Response getStudentById(int studentId){
        Response respoonse = restClient.doGetRequest("/"+studentId);
        return respoonse;
    }

    @Step("Creating a new student: {0},{1},{2},{3},{4},{5}")
    public Response createNewStudent(String uri,
                                     String firstName,
                                     String lastName,
                                     String email,
                                     String programme,
                                     List<String> courses){
        StudentClass student = new StudentClass();
        student.setFirstName(firstName);
        student.setLastName(lastName);
        student.setEmail(email);
        student.setProgramme(programme);
        student.setCourses(courses);
        Response response = restClient.doPostRequest(uri, student);
        return response;
    }

    @Step("Updating a student's info: {0},{1},{2},{3},{4},{5}")
    public Response updateStudent(   int studentId,
                                     String firstName,
                                     String lastName,
                                     String email,
                                     String programme,
                                     List<String> courses){
        StudentClass student = new StudentClass();
        student.setFirstName(firstName);
        student.setLastName(lastName);
        student.setEmail(email);
        student.setProgramme(programme);
        student.setCourses(courses);
        Response response = restClient.doPutRequest("/"+studentId, student);
        return response;
    }

    @Step("Deleting a student by Id: {0}")
    public Response deleteStudent(int studentId){
        return restClient.doDeleteRequest("/"+studentId);
    }

}
