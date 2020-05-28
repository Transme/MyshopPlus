package com.loven.myshop.plus.common.constant;

/**
 * @author loven.
 * @version 1.0.0
 * @date 2020/5/25.
 */


public  class CodeStatus {
    /**
     * 请求成功
     */
    public static final int OK = 20000;

    /**
     * 请求失败
     */
    public static final int FAIL = 40002;

    /**
     * 更新错误
     */
    public static final int UPDATE_ERROR = 40003;

    /**
     * 熔断请求
     */
    public static final int BREAKING = 40004;

    /**
     * 非法用户名
     */
    public static final int ILLEGAL_USERNAME = 40005;

    /**
     * 非法请求参数
     */
    public static final int ILLEGAL_PARAMS = 40006;

    /**
     * 非法请求
     */
    public static final int ILLEGAL_REQUEST = 50000;

    /**
     * 非法令牌
     */
    public static final int ILLEGAL_TOKEN = 50008;

    /**
     * 其他客户登录
     */
    public static final int OTHER_CLIENTS_LOGGED_IN = 50012;

    /**
     * 令牌已过期
     */
    public static final int TOKEN_EXPIRED = 50014;
}
