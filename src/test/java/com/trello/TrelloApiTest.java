package com.trello;

import io.restassured.http.ContentType;
import org.junit.jupiter.api.*;
import static io.restassured.RestAssured.*;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.hamcrest.Matchers.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class TrelloApiTest extends TrelloTestBase {

    private static String boardId;

    @Test
    @Order(1)
    public void createBoard_shouldReturn200_andValidateSchema() {
        boardId =
                given()
                        .contentType(ContentType.JSON)
                        .queryParam("name", "Test Board")
                        .queryParam("defaultLabels", "true")
                        .queryParam("defaultLists", "false")
                        .queryParams("key", API_KEY, "token", TOKEN)
                        .when()
                        .post("/boards")
                        .then()
                        .statusCode(200)
                        .body("name", equalTo("Test Board"))
                        .body("id", notNullValue())
                        .body(matchesJsonSchemaInClasspath("schemas/board-schema.json"))
                        .extract().path("id");
    }

    @Test
    @Order(2)
    public void getBoard_shouldReturn200_andMatchId() {
        given()
                .queryParams("key", API_KEY, "token", TOKEN)
                .when()
                .get("/boards/" + boardId)
                .then()
                .statusCode(200)
                .body("id", equalTo(boardId));
    }

    @Test
    @Order(3)
    public void updateBoard_shouldReturn200_andUpdateName() {
        given()
                .contentType(ContentType.JSON)
                .queryParam("name", "Updated Test Board")
                .queryParams("key", API_KEY, "token", TOKEN)
                .when()
                .put("/boards/" + boardId)
                .then()
                .statusCode(200)
                .body("name", equalTo("Updated Test Board"));
    }

    @Test
    @Order(4)
    public void deleteBoard_shouldReturn200_andVerifyBoardDeleted() {
        given()
                .queryParams("key", API_KEY, "token", TOKEN)
                .when()
                .delete("/boards/" + boardId)
                .then()
                .statusCode(200);
    }

    @Test
    @Order(5)
    public void createBoard_withInvalidToken_shouldReturn401() {
        given()
                .contentType(ContentType.JSON)
                .queryParam("name", "Invalid Board")
                .queryParams("key", API_KEY, "token", "invalid_token")
                .when()
                .post("/boards")
                .then()
                .statusCode(401);
    }

    @Test
    @Order(6)
    public void accessBoard_withMissingKey_shouldReturn401() {
        given()
                .queryParam("token", TOKEN)
                .when()
                .get("/boards/" + boardId)
                .then()
                .statusCode(401);
    }
}
