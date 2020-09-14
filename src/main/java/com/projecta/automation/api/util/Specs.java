package com.projecta.automation.api.util;

import com.projecta.automation.common.config.ConfigPropertyLoader;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

/**
 * Spec Class contains all the default specifications for the Resthleper class
 */
public class Specs {

    private ConfigPropertyLoader provider = ConfigPropertyLoader.getInstance();
    private String githubRepoBaseURI = provider.getApplicationPropertyValue("gitrepo.baseURI");

    RequestSpecification requestSpec(String basePath) {
        RestAssured.useRelaxedHTTPSValidation();
        RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
        return new RequestSpecBuilder()
                .setContentType(ContentType.JSON)
                .setBaseUri(githubRepoBaseURI)
                .setBasePath(basePath)
                .log(LogDetail.ALL)
                .build();
    }

    public ConfigPropertyLoader getConfigPropertyLoader() {
        return provider;
    }
}
