package cn.minfengyu.result;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public enum ResultEnum {

    /**
     * 10000 成功
     * 10001 失败
     */
    SUCCESS("10000", "成功"),
    FAIL("10001", "失败"),
    FAIL_USER_INFO("10002", "获取用户信息出错"),
    FAIL_USER_LOGIN_TIMEOUT("10003", "请重新登录"),
    FAIL_USER_LOGIN("10004", "请先登录"),
    LEFT_COUNT_IS_NOT_ENOUGHT("10005", "剩余使用次数不足");

    private String code;
    private String message;


    @Override
    public String toString() {
        return "ResultEnum{" +
                "code='" + code + '\'' +
                ", message='" + message + '\'' +
                '}';
    }
}
