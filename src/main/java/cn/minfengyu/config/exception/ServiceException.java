package cn.minfengyu.config.exception;


import cn.minfengyu.result.ResultCode;
import cn.minfengyu.result.ResultEnum;
import lombok.Getter;

/**
 * @author pb
 * @ClassName ServiceException
 * @date 2020/3/7 0007 08:54
 **/
@Getter
public class ServiceException extends RuntimeException {
    private static final long serialVersionUID = 9163022146279472627L;
    private String  code;
    private static final String SUCCESSCODE= ResultEnum.SUCCESS.getCode();
    private static final String SUCCESSMSG = ResultEnum.SUCCESS.getMessage();

    private static final String FAILDCODE= ResultEnum.FAIL.getCode();
    private static final String FAILDMSG = ResultEnum.FAIL.getMessage();
    public ServiceException() {
        super();
    }

    public ServiceException(String msg) {
        super(msg);
        this.code = FAILDCODE;
    }

    public ServiceException(String code, String msg) {
        super(msg);
        this.code = code;
    }

    public ServiceException(ResultEnum resultEnum) {
        super(resultEnum.getMessage());
        this.code = resultEnum.getCode();
    }
    public ServiceException(ResultCode resultEnum) {
        super(resultEnum.getMsg());
        this.code = resultEnum.getCode();
    }

    @Override
    public String toString() {
        return "ServiceException{" +
                "code='" + code + '\'' +
                '}';
    }
}
