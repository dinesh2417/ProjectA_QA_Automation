package com.projecta.automation.api.util;

import com.projecta.automation.common.config.ConfigPropertyLoader;
import io.restassured.response.Response;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import static io.restassured.RestAssured.given;

/**
 * Resthelper Class is a helper class to post the API requests using Rest Assured
 */
public class RestHelper {
    Specs specs = new Specs();
    ConfigPropertyLoader provider = specs.getConfigPropertyLoader();
    private String getGitHubUserRepoBasePath = provider.getApplicationPropertyValue("gitrepo.getuserrepo");
    private static Logger log = LogManager.getLogger(RestHelper.class);

    public static RestHelper getInstance() {
        return new RestHelper();
    }

    public Response getGitHubRepoList(String username) {
        log.info("Sending REST API request to get the Github repo list");
        return given().request().spec(specs.requestSpec(getGitHubUserRepoBasePath)).pathParam("user", username)
                .when().get()
                .then().log().all().extract().response();
    }

}
