package com.github.ricardobaumann.investigaturl.forms;

import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;

/**
 * DTO to map the input form
 * Created by ricardobaumann on 22/11/16.
 */
@Data
public class InputForm {

    @NotEmpty
    private String url;

}
