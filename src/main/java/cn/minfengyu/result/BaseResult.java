package cn.minfengyu.result;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.util.StringUtils;

import java.util.Objects;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BaseResult<T> {
    private String code;
    private String message;
    private T data;
    public static BaseResult getResult(Object data) {
        if (Objects.isNull(data)){
            return getFail();
        }else {
            return getSuccess(data);
        }
    }
    public static BaseResult getSuccess() {
        return new BaseResult<>(ResultEnum.SUCCESS.getCode(), ResultEnum.SUCCESS.getMessage(), null);
    }
    public static BaseResult getSuccess(Object data) {
        return new BaseResult<>(ResultEnum.SUCCESS.getCode(), ResultEnum.SUCCESS.getMessage(), data);
    }

    public static BaseResult getSuccess(String code, String msg, Object obj) {
        BaseResult<Object> result = new BaseResult<>(ResultEnum.SUCCESS.getCode(), ResultEnum.SUCCESS.getMessage(), null);
        if (!StringUtils.isEmpty(code)) {
            result.setCode(code);
        }
        if (!StringUtils.isEmpty(msg)) {
            result.setMessage(msg);
        }
        if (obj != null) {
            result.setData(obj);
        }
        return result;
    }

    public static BaseResult getFail() {
        return new BaseResult<>(ResultEnum.FAIL.getCode(), ResultEnum.FAIL.getMessage(), null);
    }



    public static BaseResult getFail(String msg){
        return create(ResultEnum.FAIL.getCode() , msg ,null);
    }

    public static BaseResult getFail(ResultEnum resultEnum){
        return create(resultEnum.getCode() , resultEnum.getMessage() ,null);
    }

    public static BaseResult getFail(String code ,String msg){
        return create(code , msg ,null);
    }

    public static BaseResult getFail(String code, String msg, Object obj) {
        BaseResult<Object> result = new BaseResult<>(ResultEnum.FAIL.getCode(), ResultEnum.FAIL.getMessage(), null);
        if (!StringUtils.isEmpty(code)) {
            result.setCode(code);
        }
        if (!StringUtils.isEmpty(msg)) {
            result.setMessage(msg);
        }
        if (obj != null) {
            result.setData(obj);
        }
        return result;
    }



    public static BaseResult create(String code,String msg,String data){
        return new BaseResult<>(code, msg, data);
    }

    public void setCodeAndMessage(ResultEnum resultEnum, T data) {
        code = resultEnum.getCode();
        message = resultEnum.getMessage();
        this.data = data;
    }

    public BaseResult<T> setCodeAndMessage(String code, String message, T data) {
        BaseResult<T> result = new BaseResult<>();
        result.setCode(code);
        result.setMessage(message);
        result.setData(data);
        return result;
    }

}
