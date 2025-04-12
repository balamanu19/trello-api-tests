package com.trello;

import io.github.cdimascio.dotenv.Dotenv;
import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeAll;

public abstract class TrelloTestBase {

    protected static final String API_KEY;
    protected static final String TOKEN;

    static {
        Dotenv dotenv = Dotenv.configure()
                .ignoreIfMissing()
                .load();

        API_KEY = dotenv.get("TRELLO_API_KEY");
        TOKEN = dotenv.get("TRELLO_TOKEN");
    }

    @BeforeAll
    public static void setupRestAssured() {
        RestAssured.baseURI = "https://api.trello.com/1";
    }
}
