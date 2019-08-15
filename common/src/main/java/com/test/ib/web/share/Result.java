package com.test.ib.web.share;

import com.alibaba.fastjson.JSON;
import lombok.Data;

import org.jetbrains.annotations.NotNull;
import java.beans.Transient;
import java.io.Serializable;

/**
 * @author 费世程
 * @date 2019/8/14 14:21
 */
@Data
public class Result<T> implements Serializable {
  private static final int SUCCESS_CODE = 200;
  private static final int DEFAULT_ERR_CODE = 400;
  private static final int EXCEPTION_CODE = 500;
  /**
   * 会话id,方便进行问题定位
   */
  private String sid;
  /**
   * 响应状态码
   */
  private int code;
  /**
   * 错误描述
   */
  private String errorDesc;
  /**
   * 附加对象信息
   */
  private T data;

  protected Result(String sid, int code, String errorDesc, T data) {
    this.sid = sid;
    this.code = code;
    this.errorDesc = errorDesc;
    this.data = data;
  }

  protected Result() {
  }

  @Transient
  public boolean isSuccess() {
    return this.code == SUCCESS_CODE;
  }

  public static <T> Result<T> okAndCustomSid(String sid, T data) {
    return new Result<>(sid, SUCCESS_CODE, null, data);
  }

  public static <T> Result<T> okAndCustomSid(String sid) {
    return new Result<>(sid, SUCCESS_CODE, null, null);
  }

  public static <T> Result<T> ok(T data) {
    return new Result<>(Records.getSid(), SUCCESS_CODE, null, data);
  }

  public static <T> Result<T> ok(T data, ErrMsg msg) {
    return new Result<>(Records.getSid(), msg.code(), msg.desc(), data);
  }

  public static Result<String> ok(ErrMsg msg) {
    return new Result<>(Records.getSid(), msg.code(), msg.desc(), null);
  }

  public static <T> Result<T> ok() {
    return new Result<>(Records.getSid(), SUCCESS_CODE, null, null);
  }

  public static <T> Result<T> errAndCustomSid(String sid, int errorCode, String msg) {
    return new Result<>(sid, errorCode, msg, null);
  }


  public static <T> Result<T> errAndCustomSid(String sid, String msg) {
    return new Result<>(sid, DEFAULT_ERR_CODE, msg, null);
  }

  public static <T> Result<T> err(int errorCode, String msg) {
    return new Result<>(Records.getSid(), errorCode, msg, null);
  }

  /**
   * 返回错误信息,用于不需要规范化错误码的场合
   *
   * @param msg 错误描述
   * @return Result Object
   */
  public static <T> Result<T> err(String msg) {
    return new Result<>(Records.getSid(), DEFAULT_ERR_CODE, msg, null);
  }


  public static <T> Result<T> err(@NotNull ErrMsg errMsg) {
    return new Result<>(Records.getSid(), errMsg.code(), errMsg.desc(), null);
  }


  /**
   * 返回异常信息
   *
   * @param t Throwable
   * @return Result Object
   */
  public static <T> Result<T> exception(Throwable t) {
    return new Result<>(Records.getSid(), EXCEPTION_CODE, t.getMessage(), null);
  }

  public Result<T> setSid(String sid) {
    this.sid = sid;
    return this;
  }

  public Result<T> setCode(int code) {
    this.code = code;
    return this;
  }

  public Result<T> setErrorDesc(String errorDesc) {
    this.errorDesc = errorDesc;
    return this;
  }

  public Result<T> setData(T data) {
    this.data = data;
    return this;
  }

  @Override
  public String toString() {
    return JSON.toJSONString(this);
  }

  public static void main(String[] args) {
    Result<Object> ok = Result.ok();
    System.out.println(JSON.toJSONString(ok));
  }
}
