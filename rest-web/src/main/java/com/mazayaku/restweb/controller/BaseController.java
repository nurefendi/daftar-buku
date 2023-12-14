package com.mazayaku.restweb.controller;

import com.mazayaku.utility.HeaderRequest;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.ModelAttribute;

public class BaseController {

  @ModelAttribute
  public HeaderRequest getMandatoryParameter(HttpServletRequest request) {
    return (HeaderRequest) request.getAttribute("mandatory");
  }

}
