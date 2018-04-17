package com.ysk.addressbook.config;


import com.google.common.base.Strings;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by lei on 24/08/2017.
 * Yes, you can.
 */
public class RetCode {

    private static final Map<Integer, String> MSG_MAP;
    private static final String DEFAULT_MSG = "服务器开小差";

    public static final int OK = 200;

    //通用错误
    public static final int INVALID_PARAM = 3000;
    public static final int UNKNOWN_ERR = 3001;
    public static final int IP_ILLEGAL = 3002;
    public static final int CONFIG_ERROR = 3004;
    public static final int FREQUENT_OPERATION = 3005;
    public static final int WX_INNER_WORONG = 3006;

    //用户相关
    public static final int USER_NOT_FOUND = 4000;
    public static final int USER_INFO_NOT_FOUND = 4000;
    public static final int NOT_LOGIN = 4004;
    public static final int WITHDRAW_FAILED = 4005;
    public static final int WRONG_INVITECODE = 4006;
    public static final int WRONG_OPENID_OR_TOKEN = 4007;
    public static final int NO_WX_USER = 4008;
    public static final int ITEM_NOT_ENOUGH = 4009;
    public static final int LIMIT_OWNER = 40010;
    public static final int HAS_BEEN_INVITED = 40011;
    public static final int POWER_NOT_ENOUGH = 40012;
    public static final int USE_ITEM_WRONG = 40013;

    // Admin相关
    public static final int AUTH_COMMAND_INVALID = 11000;

    //红包相关
    public static final int LIMIT_WITHDRAW_TIME = 5000;
    public static final int LIMIT_BONUS_MAX = 5001;
    public static final int ACCESS_TOKEN_ERROR = 5002;
    public static final int PER_DAR_WITHDRAW_LIMIT = 5003;


    //游戏相关
    public static final int ITEM_NOT_FOUND = 60000;
    public static final int LEVEL_NOT_FOUND = 60001;
    public static final int OPPONENT_NOT_FOUND = 60002;
    public static final int ILLEGAL_GAME = 60003;
    public static final int GAME_TIME_LIMIT = 60004;
    public static final int GAME_RECORD_NOT_FOUND = 60005;
    public static final int SIGN_ERROR = 60006;
    public static final int PARAM_ERROR = 60007;
    public static final int WRONG_BONUS_STATUS = 60008;
    public static final int RESTART_REEOR= 60009;

    //微信相关
    public static final int NOT_LINK_WX = 7000;

    static {
        MSG_MAP = new HashMap<>();
        MSG_MAP.put(OK, "ok");
        MSG_MAP.put(INVALID_PARAM, "参数无效");
        MSG_MAP.put(UNKNOWN_ERR, "未知错误");
        MSG_MAP.put(IP_ILLEGAL, "非法ip");
        MSG_MAP.put(NOT_LOGIN, "用户未登录");
        MSG_MAP.put(AUTH_COMMAND_INVALID, "口令不正确");
        MSG_MAP.put(WITHDRAW_FAILED, "提现失败");
        MSG_MAP.put(CONFIG_ERROR, "配置错误");
        MSG_MAP.put(USER_NOT_FOUND, "用户未找到");
        MSG_MAP.put(FREQUENT_OPERATION, "操作频繁");
        MSG_MAP.put(WRONG_INVITECODE, "邀请码错误");
        MSG_MAP.put(WRONG_OPENID_OR_TOKEN, "用户openid或token错误");
        MSG_MAP.put(NO_WX_USER, "微信用户不存在");
        MSG_MAP.put(ITEM_NOT_ENOUGH, "道具不足");
        MSG_MAP.put(LIMIT_OWNER, "不能使用自己的邀请码");
        MSG_MAP.put(HAS_BEEN_INVITED, "已经填写过邀请码");
        MSG_MAP.put(POWER_NOT_ENOUGH, "体力不足");
        MSG_MAP.put(LIMIT_WITHDRAW_TIME, "提现次数已达上限");
        MSG_MAP.put(WX_INNER_WORONG, "微信配置错误");
        MSG_MAP.put(ITEM_NOT_FOUND, "道具不存在");
        MSG_MAP.put(LIMIT_BONUS_MAX, "当日奖金已达上限");
        MSG_MAP.put(LEVEL_NOT_FOUND, "没有关卡信息");
        MSG_MAP.put(OPPONENT_NOT_FOUND, "没匹配到对手");
        MSG_MAP.put(ACCESS_TOKEN_ERROR, "没有access_token");
        MSG_MAP.put(NOT_LINK_WX, "未关注订阅号不能提现");
        MSG_MAP.put(ILLEGAL_GAME, "非法游戏过程");
        MSG_MAP.put(USER_INFO_NOT_FOUND, "用户信息不存在");
        MSG_MAP.put(GAME_TIME_LIMIT, "当日游戏次数达上限");
        MSG_MAP.put(SIGN_ERROR, "签名错误");
        MSG_MAP.put(PARAM_ERROR, "参数错误");
        MSG_MAP.put(WRONG_BONUS_STATUS, "红包为暂不能领取状态");
        MSG_MAP.put(RESTART_REEOR, "重新开始游戏错误");
        MSG_MAP.put(PER_DAR_WITHDRAW_LIMIT, "今天已经提现过了");
    }

    public static String getMsg(int error) {
        String msg = MSG_MAP.get(error);
        return Strings.isNullOrEmpty(msg) ? DEFAULT_MSG : msg;
    }
}
