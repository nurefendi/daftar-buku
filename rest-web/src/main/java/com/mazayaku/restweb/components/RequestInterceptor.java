package com.mazayaku.restweb.components;

import com.mazayaku.utility.HeaderRequest;
import com.mazayaku.utility.constant.HttpConstant;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.HandlerInterceptor;

public class RequestInterceptor implements HandlerInterceptor {

  @Override
  public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
      throws Exception {
    HeaderRequest headerRequest = HeaderRequest.builder()
        .requestId(request.getHeader(HttpConstant.REQUEST_ID))
        .channelId(request.getHeader(HttpConstant.CHANNEL_ID))
        .build();
    request.setAttribute("mandatory", headerRequest);
    return true;
  }
}
