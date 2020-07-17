package com.student.requests;

import com.student.tests.TestBase;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static com.student.specs.SpecificationFactory.logPayloadResponseInfo;
import static io.restassured.RestAssured.given;

public class RestClient extends TestBase {
    /**
     *
     * @param requestPath
     * @return
     */
    public Response doGetRequest(String requestPath){
        return   given()
                .when()
                .get(requestPath);
    }

    /**
     *
     * @param uri
     * @param body
     * @return
     */
    public Response doPostRequest(String uri, Object body){
        return given()
                .contentType(ContentType.JSON)
                .spec(logPayloadResponseInfo())
                .when()
                .body(body)
                .post(uri);
    }

    /**
     *
     * @param res
     * @param body
     * @return
     */
    public Response doPutRequest(String res, Object body){
        Response response = given()
                            .when()
                            .body(body)
                            .put(res);
        return response;
    }

    /**
     *
     * @param res
     * @param body
     * @return
     */
    public Response doPatchRequest(String res, Object body){
        Response response = given()
                            .when()
                            .body(body)
                            .patch(res);
        return response;
    }

    /**
     *
     * @param res
     * @return
     */
    public Response doDeleteRequest(String res){
        Response response = given().when().delete(res);
        return response;
    }

}
