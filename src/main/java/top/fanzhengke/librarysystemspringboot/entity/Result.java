package top.fanzhengke.librarysystemspringboot.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * 封装返回结果
 */
@ApiModel(value = "返回结果")
public class Result implements Serializable {
    @ApiModelProperty(value = "执行结果,True为执行成功,False为执行失败")
    private boolean flag;

    @ApiModelProperty(value = "页面提示信息")
    private String message;

    @ApiModelProperty(value = "返回数据")
    private Object data;

    public Result(boolean flag, String message) {
        super();
        this.flag = flag;
        this.message = message;
    }

    public Result(boolean flag, String message, Object data) {
        this.flag = flag;
        this.message = message;
        this.data = data;
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
