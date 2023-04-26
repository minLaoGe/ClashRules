package cn.minfengyu.result;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author wjl
 * @date 2020/10/12 11:11
 */
@AllArgsConstructor
public enum ResultCode {


    /**
     * 错误码 = 系统码 + 错误编号
     */

    ID_NOT_EXIST("1000", "id不存在"),
    EXCEL_IS_NULL("1001", "未解析到数据"),
    PHONE_NOT_REPEAT("1002", "手机号不能重复"),
    ERROT_IMAGE_CODE("1003", "图片验证码不正确"),
    SMS_PARAM_ERROR("1004", "accessKeyId,accessKeySecret,templateCode,regionId,signName不能为空"),
    USER_NOT_EXISTS("1005", "用户不存在"),
    PASSWORD_ERROR("1006", "密码错误"),
    SYSTEM_ERROR("1007", "后台错误"),
    WAITING("1008", "发送频繁,请稍后..."),
    PASSWORD_NOT_AGREE("1009", "两次输入密码不一致"),
    PHONE_HAS_EXIST("1010", "手机号已经注册"),
    NOT_LOGIN("1011", "用户未登录"),
    NOT_AUTH_ACCESS("1012", "未授权访问"),
    PASSWORD_NOT_REPEAT("1013", "新密码与重复密码不一致"),
    NOT_EXISTS_IMAGE_CODE("1014", "图片验证码失效"),
    REGISTERED_CANNOT_BE_RE_REGISTERED("1015", "已报名不能再次报名"),
    ENROLMENT_FOR_THE_COURSE_IS_NOT_AVAILABLE("1016", "您已报名"),
    YOU_HAVE_CLASS("1017", "你已退班"),
    NO_ROLES("1018", "请联系管理员分配角色"),
    USER_HAS_ERROR("1019", "用户已存在"),
    ROLE_HAS_ERROR("1020", "角色已存在"),
    PLEASE_BUY_COURSE_GROUP("1021", "请先购买课程"),
    MAX_FILE_UPLOAD("1022", "文件最大支持5M上传"),
    MENU_HAS_EXIT("1023", "请先清理该模块下的菜单"),
    SECOND_MENU_HAS_EXIT("1024", "请先清理该菜单下的子菜单"),
    USER_HAS_NO_MENU("1025", "请联系管理员分配菜单"),
    OLD_PASSWORD_ERROR("1026", "旧密码错误"),
    ADMIN_PASSWORD_NOT_CHANGED("1027", "admin不允许修改"),
    TYPE_NOT_EXISTS("1028", "类型不存在"),
    ORDER_NOT_PAY("1029", "订单未支付"),
    WECHAT_PAY_ERROR("1030", "订单重复，请联系客服：400-0160-999"),
    NO_BAND_PHONE("1031", "未绑定手机号"),
    HAVING_BING_ACCOUNT("1032", "已绑定账号，请重新绑定"),

    ;
    private static final String SYS_CODE = "101";

    private final String code;

    @Getter
    private final String msg;

    public String getCode() {
        return SYS_CODE + code;
    }

    @Override
    public String toString() {
        return "ResultCode{" +
                "code='" + SYS_CODE + code + '\'' +
                ", msg='" + msg + '\'' +
                '}';
    }
}
