package top.fanzhengke.librarysystemspringboot.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.stereotype.Component;

@ApiModel("专业")
@Component
public class Marjor {
    @ApiModelProperty(value = "专业ID")
    private Integer id;
    @ApiModelProperty(value = "所属学院ID")
    private Integer cid;
    @ApiModelProperty(value = "专业名")
    private String marjor;
    @ApiModelProperty(value = "所属学院名")
    private String college;

    public String getCollege() {
        return college;
    }

    public void setCollege(String college) {
        this.college = college;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public String getMarjor() {
        return marjor;
    }

    public void setMarjor(String marjor) {
        this.marjor = marjor;
    }
}
