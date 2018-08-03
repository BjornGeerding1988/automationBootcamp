package APITesting;

import org.testng.annotations.Test;

import io.restassured.RestAssured;

import static io.restassured.RestAssured.given;
import static org.hamcrest.core.StringContains.containsString;

public class API_Testing {

    private String season = "2016";
    private String driver = "max_verstappen";

    @Test
    public void restAssured() {
        given().pathParam("season", season).pathParam("driver", driver).when().get("http://ergast.com/api/f1/{season}/drivers/{driver}/results.json").then()
                .body("MRData.RaceTable.driverId", containsString("max_verstappen"));
    }

    @Test
    public void pathParamTest() {
        given().pathParam("season", season).pathParam("driver", driver).when().get("http://ergast.com/api/f1/{season}/drivers/{driver}/results.json").then()
        .statusCode(200);
    }
}
