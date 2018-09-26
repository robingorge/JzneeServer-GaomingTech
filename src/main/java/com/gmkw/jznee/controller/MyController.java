package com.gmkw.jznee.controller;

import com.gmkw.jznee.service.ValidateCodeService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.imageio.ImageIO;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

@Controller
public class MyController {
    @RequestMapping("/")
    String home() {
        return "login";
    }

    @RequestMapping("/dashboard")
    String product() {
        return "dashboard";
    }

    @RequestMapping("/component_tracing")
    String c_t() {
        return "component_tracing";
    }

    @RequestMapping("/alerts")
    String alert_function() {
        return "alerts";
    }

    @RequestMapping("/cutting_tool_mgmt")
    String cutting_function() {
        return "cutting_tool_mgmt/index.html";
    }





}