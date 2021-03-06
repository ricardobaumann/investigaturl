package com.github.ricardobaumann.investigaturl.forms;

import com.github.ricardobaumann.investigaturl.models.UrlData;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Map;

/**
 * DTP to print the results on the results page
 * Created by ricardobaumann on 22/11/16.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResultForm {

    private InputForm inputForm;

    private UrlData urlData;

}
