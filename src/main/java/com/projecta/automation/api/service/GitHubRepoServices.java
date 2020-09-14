package com.projecta.automation.api.service;

import com.projecta.automation.api.util.RestHelper;
import io.restassured.response.Response;

/**
 * GitHubRepoServices Class contains all the Github webservices
 */
public class GitHubRepoServices {

    private final RestHelper restHelper = RestHelper.getInstance();

    public static GitHubRepoServices getInstance() {
        return new GitHubRepoServices();
    }

    public Response getGitHubRepo(String username) {
        return restHelper.getGitHubRepoList(username);
    }

    public int getGitHubRepoSize(String username) {
        Response gitRepoAPIResponse = restHelper.getGitHubRepoList(username);
        return gitRepoAPIResponse.then().extract().jsonPath().getList("id").size();
    }
}
