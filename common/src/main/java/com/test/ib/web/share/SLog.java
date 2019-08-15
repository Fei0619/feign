package com.test.ib.web.share;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.*;

/**
 * @author 费世程
 * @date 2019/8/14 14:23
 */
@Data
public class SLog {
  /**
   * 请求id
   */
  private final String id = UUID.randomUUID().toString();
  /**
   * 会话ID,用于记录本次请求在哪个会话下
   */
  private String sessionId;
  /**
   * 类型 - 0:普通/1:exception
   */
  private int type;
  /**
   * 请求路径
   */
  private String uri;
  /**
   * 请求IP
   */
  private String ip;
  /**
   * 本机IP
   */
  private String localIp;
  /**
   * 请求参数列表
   */
  private Map<String, Object> args;
  /**
   * 响应参数
   */
  private Object response;
  /**
   * 响应状态码
   */
  private Integer rspStatus;
  /**
   * 接口总耗时
   */
  private long disposeTime;
  /**
   * 分步信息统计
   */
  private final Multimap<String, StepDetail> stepMsgs = ArrayListMultimap.create();
  /**
   * 接口调用失败信息
   */
  private final List<String> failMsgs = new ArrayList<>();
  /**
   * 创建时间,用于mongodbTTL索引
   */
  private final Date createDate = new Date();
  /**
   * 会话创建时间的时间戳
   */
  private final long createTimestamp = createDate.getTime();
  /**
   * 会话创建时间
   */
  private final String createTime = DateUtils.format(createDate, "yyyy-MM-dd HH:mm:ss:SSS");
  /**
   * 异常信息
   */
  private String exception;

  /**
   * 记录异常信息
   *
   * @param trace 异常栈
   */
  public void setException(String trace) {
    this.exception = trace;
    this.type = 1;
  }

  /**
   * 记录异常信息
   *
   * @param t Throwable
   */
  public void setException(Throwable t) {
    String trace = ExceptionUtils.getThrowableTrace(t);
    setException(trace);
  }

  /**
   * 记录分步信息
   *
   * @param step   步
   * @param detail 步详情
   */
  public void putStepMsgs(String step, SLog.StepDetail detail) {
    stepMsgs.put(step, detail);
  }

  /**
   * 记录错误信息
   *
   * @param failMsg 错误信息
   */
  public void addFailMsg(String failMsg) {
    failMsgs.add(failMsg);
  }


  @Override
  public String toString() {
    return JSON.toJSONString(this);
  }

  @Data
  @Builder
  @NoArgsConstructor
  @AllArgsConstructor
  public static class StepDetail {
    /**
     * 流水号
     */
    private String sid;
    /**
     * 处理结果
     */
    private Boolean success;
    /**
     * 耗时
     */
    private Long speed;
    /**
     * 请求参数列表
     */
    private Map<String, Object> reqArgs;
    /**
     * 响应参数
     */
    private Object response;

    @Override
    public String toString() {
      return JSON.toJSONString(this);
    }
  }
}
