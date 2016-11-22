package com.github.ricardobaumann.investigaturl.models;

import lombok.Data;

import java.util.Map;

/**
 * Created by ricardobaumann on 22/11/16.
 */
@Data
public class UrlData {

    private String htmlVersion;

    private String pageTitle;

    private Map<Integer, Integer> headingLevels;

    private Integer internalLinks;

    private Integer externalLinks;

    private Boolean containLoginForm;

}
