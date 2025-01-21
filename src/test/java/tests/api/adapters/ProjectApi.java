package tests.api.adapters;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import static io.restassured.RestAssured.given;

import lombok.extern.log4j.Log4j2;
import tests.api.models.CreateProjectQase;
import tests.api.models.CreateProjectResponse;
import tests.api.models.DeleteProjectResponse;


@Log4j2
public class ProjectApi {

    private static final Gson gson = new GsonBuilder()
            .excludeFieldsWithoutExposeAnnotation()
            .create();

    private static final RequestSpecification spec = given()
            .baseUri("https://api.qase.io/v1")
            .log().all()
            .contentType(ContentType.JSON)
            .header("Token", "2d19f481ff84a5fd929915d144d43419a7a7561cc7caa0993451e7439fdac0b7");

    public static CreateProjectResponse createProject(CreateProjectQase createProjectQase) {
        log.info("Send API request for creating new project");
        return given()
                .spec(spec)
                .body(gson.toJson(createProjectQase))
                .when()
                .post("/project")
                .then()
                .log().all()
                .statusCode(200)
                .extract()
                .as(CreateProjectResponse.class);
    }
    public static DeleteProjectResponse deleteProject(String code) {
        log.info("Send API request for deleting new project");
        return given()
                .spec(spec)
                .when()
                .delete("/project/" + code)
                .then()
                .log().all()
                .statusCode(200)
                .extract()
                .as(DeleteProjectResponse.class);
    }
}
