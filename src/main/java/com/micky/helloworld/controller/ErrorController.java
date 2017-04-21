package com.micky.helloworld.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Administrator on 2017/4/21.
 */
@Controller
public class ErrorController implements org.springframework.boot.autoconfigure.web.ErrorController {
    public static final String ERROR_PATH = "/error";

    @RequestMapping(ERROR_PATH)
    public String handleError() {
        return "pages/404.html";
    }

    @Override
    public String getErrorPath() {
        return ERROR_PATH;
    }
}
