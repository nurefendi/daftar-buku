package com.mazayaku.restweb.configuration;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import org.apache.http.config.SocketConfig;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;

public class WebConfig {
  @Autowired
  private Environment environment;

  @Bean
  LocaleChangeInterceptor localeChangeInterceptor() {
    LocaleChangeInterceptor interceptor = new LocaleChangeInterceptor();
    interceptor.setParamName("language");
    return interceptor;
  }

  @Bean
  PoolingHttpClientConnectionManager httpClientConnectionManager() {
    PoolingHttpClientConnectionManager httpClientPool = new PoolingHttpClientConnectionManager();
    httpClientPool.setDefaultMaxPerRoute(10);
    httpClientPool.setMaxTotal(100);
    httpClientPool.setDefaultSocketConfig(SocketConfig.custom().setSoTimeout(5000).build());
    httpClientPool.closeIdleConnections(5, TimeUnit.SECONDS);
    return httpClientPool;
  }

  @Bean
  ExecutorService executorService() {
    return new ThreadPoolExecutor(10, 100, 10, TimeUnit.SECONDS, new LinkedBlockingQueue<>(1000));
  }
}
