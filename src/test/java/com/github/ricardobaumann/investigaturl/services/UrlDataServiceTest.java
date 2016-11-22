package com.github.ricardobaumann.investigaturl.services;

import com.github.ricardobaumann.investigaturl.models.UrlData;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;
import static org.hamcrest.core.Is.*;

/**
 * Created by ricardobaumann on 22/11/16.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UrlDataServiceTest {

    @Autowired
    private UrlDataService urlDataService;

    @Before
    public void setUp() throws Exception {

    }

    @Test
    public void extractFrom() throws Exception {
        UrlData urlData = urlDataService.extractFrom("http://github.com/login");
        assertThat(urlData.getPageTitle(),is("Sign in to GitHub · GitHub"));
    }

}