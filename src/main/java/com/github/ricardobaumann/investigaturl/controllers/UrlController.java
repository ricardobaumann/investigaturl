package com.github.ricardobaumann.investigaturl.controllers;

import com.github.ricardobaumann.investigaturl.forms.InputForm;
import com.github.ricardobaumann.investigaturl.forms.ResultForm;
import com.github.ricardobaumann.investigaturl.services.UrlDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import javax.validation.Valid;
import java.io.IOException;
import java.util.Arrays;

/**
 * Created by ricardobaumann on 22/11/16.
 */
@Controller
public class UrlController extends WebMvcConfigurerAdapter {

    @Autowired
    private UrlDataService urlDataService;

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/results").setViewName("results");
    }

    @GetMapping("/")
    public String showInputForm(InputForm inputForm) {
        return "input";
    }

    @PostMapping("/")
    public String processInput(@Valid InputForm inputForm, BindingResult bindingResult, ResultForm resultForm) throws IOException {

        if (bindingResult.hasErrors()) {
            return "input";
        }

        resultForm.setEntries(Arrays.asList("jey","ho"));
        resultForm.setInputForm(inputForm);
        resultForm.setUrlData(urlDataService.extractFrom(inputForm.getUrl()));

        return "results";
    }

}
