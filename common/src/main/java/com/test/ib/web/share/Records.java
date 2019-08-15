package com.test.ib.web.share;

/**
 * @author 费世程
 * @date 2019/8/14 14:23
 */
public final class Records {

  private static final ThreadLocal<SLog> S_LOG_THREAD_LOCAL = ThreadLocal.withInitial(SLog::new);

  /**
   * 获取本次会话信息
   *
   * @return 会话信息
   */
  public static SLog get() {
    return S_LOG_THREAD_LOCAL.get();
  }

  /**
   * 清除本次会话信息
   */
  private static void remove() {
    S_LOG_THREAD_LOCAL.remove();
  }

  /**
   * 清除并生成新的会话信息
   *
   * @return 会话信息
   */
  public static SLog removeAndGet() {
    remove();
    return get();
  }

  /**
   * 获取会话id
   *
   * @return 会话id
   */
  public static String getSid() {
    return get().getId();
  }

  /**
   * 向会话中记录异常栈信息
   *
   * @param t Throwable
   */
  public static void recordException(Throwable t) {
    get().setException(t);
  }

  /**
   * 记录分步耗时
   *
   * @param step   步名
   * @param detail 分步信息
   */
  public static void recordStep(String step, SLog.StepDetail detail) {
    get().putStepMsgs(step, detail);
  }

  /**
   * 记录失败信息
   *
   * @param failMsg 失败信息
   */
  public static void recordFailMsg(String failMsg) {
    get().addFailMsg(failMsg);
  }

  private Records() {
  }
}
