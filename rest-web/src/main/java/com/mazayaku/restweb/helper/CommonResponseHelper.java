package com.mazayaku.restweb.helper;

import com.mazayaku.entity.dto.PaginationParam;
import com.mazayaku.utility.helper.RestResult;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.data.domain.Page;

public class CommonResponseHelper {
  private CommonResponseHelper() {
  }

  public static <T> RestResult<T> constructSuccessPost(T data) {
    return constructSuccessResponse(data, "Post data success");
  }

  public static <T> RestResult<T> constructSuccessGet(T data) {
    return constructSuccessResponse(data, "Get data success");
  }

  public static <T> RestResult<T> constructSuccessPut(T data) {
    return constructSuccessResponse(data, "Successfully update the data");
  }

  public static <T> RestResult<T> constructSuccessDelete() {
    return constructDeleteResponse();
  }

  public static <T> RestResult<List<T>> constructSuccessGetPageable(Page<T> data,
      PaginationParam paginationParam) {
    Map<String, String> map = new HashMap<>();
    map.put("total", String.valueOf(data.getTotalElements()));
    map.put("limit", String.valueOf(paginationParam.getLimit()));
    map.put("offset", String.valueOf(paginationParam.getOffset()));
    map.put("pages", String.valueOf(data.getTotalPages()));
    RestResult<List<T>> result = new RestResult<>();
    result.ok("Get data success");
    result.setData(data.getContent());
    result.setMetaData(map);
    return result;
  }

  private static <T> RestResult<T> constructSuccessResponse(T data, String messageKey) {
    RestResult<T> result = new RestResult<>();
    result.ok(messageKey);
    result.setData(data);
    return result;
  }
  private static <T> RestResult<T> constructDeleteResponse() {
    RestResult<T> result = new RestResult<>();
    result.ok("Successfully delete the data");
    return result;
  }
}
