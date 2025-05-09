package com.test.oauth2.dto;

public interface OAuth2Response {

    //제공자(naver, google)
    String getProvider();

    String getProviderId();

    String getEmail();

    String getName();
}
