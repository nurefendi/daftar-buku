package com.mazayaku.utility.helper;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonView;
import com.google.gson.GsonBuilder;
import io.micrometer.common.util.StringUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class RestResult<T> {
  public static final String STATUS_SUCCESS = "success".intern();
  public static final String STATUS_ERROR = "error".intern();
  @JsonView({Object.class})
  private String status;
  @JsonView({Object.class})
  private List<String> messages = new ArrayList();
  @JsonView({Object.class})
  private T data;
  @JsonView({Object.class})
  private Map<String, String> metaData;

  public RestResult() {
    this.status = STATUS_SUCCESS;
  }

  public static <T> RestResult<T> create(Class<T> genericType) {
    return new RestResult();
  }

  public static <T> RestResult<T> ok(Class<T> type) {
    RestResult<T> result = new RestResult();
    result.status = STATUS_SUCCESS;
    return result;
  }

  public static <T> RestResult<T> fail(Class<T> type) {
    RestResult<T> result = new RestResult();
    result.status = STATUS_ERROR;
    return result;
  }

  public <T> RestResult<T> ok(T data) {
    RestResult<T> result = new RestResult();
    result.setData(data);
    return result;
  }

  public static <T> T getRestResultData(Object object, Class<T> clazz) {
    return (new GsonBuilder()).create().fromJson((new GsonBuilder()).create().toJson(object), clazz);
  }


  public void ok(String message) {
    this.status = STATUS_SUCCESS;
    if (StringUtils.isNotEmpty(message)) {
      this.addMessage(message);
    }

  }

  public void fail(String message) {
    this.status = STATUS_ERROR;
    if (StringUtils.isNotEmpty(message)) {
      this.addMessage(message);
    }

  }

  public String getStatus() {
    return this.status;
  }

  public RestResult<T> setStatus(String status) {
    this.status = status;
    return this;
  }

  public List<String> getMessages() {
    return this.messages;
  }

  public RestResult<T> setMessages(List<String> messages) {
    Iterator var2 = messages.iterator();

    while(var2.hasNext()) {
      String message = (String)var2.next();
      this.messages.add(message);
    }

    return this;
  }

  public RestResult<T> addMessage(String message) {
    this.messages.add(message);
    return this;
  }

  public T getData() {
    return this.data;
  }

  public RestResult<T> setData(T data) {
    this.data = data;
    return this;
  }

  public RestResult<T> addError(String error) {
    this.status = STATUS_ERROR;
    this.addMessage(error);
    return this;
  }

  public Map<String, String> getMetaData() {
    return this.metaData;
  }

  public void setMetaData(Map<String, String> metaData) {
    this.metaData = metaData;
  }

  @JsonIgnore
  public boolean isError() {
    return !STATUS_SUCCESS.equals(this.status);
  }
}