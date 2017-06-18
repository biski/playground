package scenarios;

import io.qameta.allure.restassured.AllureRestAssured;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.get;
import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.*;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;


/**
 * Created by wojciech on 16.06.17.
 */
public class Zikit {

    @Test
    public void searchStacjaById() {
        System.setProperty("allure.results.directory", "target/allure-results");
        given()
                .filter(new AllureRestAssured())
                .body("")
                .when()
                .get("https://zikit.carto.com/api/v2/sql?q=select%20*%20from%20public.wszystkie_stojaki%20where%20cartodb_id=534")
                .then()
                .assertThat()
                .body("coord.lon", equalTo("-0.13"))
                .body("coord.lat", equalTo(51.51));

    }
}
