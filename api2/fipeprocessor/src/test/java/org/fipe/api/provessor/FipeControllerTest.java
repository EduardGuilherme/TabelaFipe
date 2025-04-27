package org.fipe.api.provessor;

@QuarkusTest
public class FipeControllerTest {

    @Test
    public void testTriggerInitialLoad() {
        given()
                .when().post("/api/fipe/load-initial")
                .then()
                .statusCode(202);
    }

    @Test
    public void testGetMarcas() {
        given()
                .when().get("/api/fipe/marcas")
                .then()
                .statusCode(200)
                .body(is(not(empty())));
    }
}
