package com.gmkw.jznee.controller;

import com.gmkw.jznee.service.ValidateCodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Li Xuejun on 2016/8/22.
 */
@Controller
@RequestMapping(value = "/backstage/getValidateCode")
public class ValidateCodeController {

    @Autowired
    private ValidateCodeService validateCodeService;

    @RequestMapping(value = "")
    public void getValidateCode(HttpServletRequest request, HttpServletResponse response) throws IOException {
        validateCodeService.getValidateCode(request,response);
    }
}

