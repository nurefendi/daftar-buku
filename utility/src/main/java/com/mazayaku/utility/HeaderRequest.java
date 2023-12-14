package com.mazayaku.utility;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class HeaderRequest {

  private String requestId;

  private String channelId;

  @Override
  public String toString() {
    return "HeaderRequest{" +
        "requestId='" + requestId + '\'' +
        ", channelId='" + channelId + '\'' +
        '}';
  }
}