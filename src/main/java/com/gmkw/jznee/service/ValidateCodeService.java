package com.gmkw.jznee.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public interface ValidateCodeService {

    public void getValidateCode(HttpServletRequest request, HttpServletResponse response) throws IOException;
}