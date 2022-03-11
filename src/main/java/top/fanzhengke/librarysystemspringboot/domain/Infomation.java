package top.fanzhengke.librarysystemspringboot.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.stereotype.Component;

@ApiModel(value = "毕业照信息")
@Component
public class Infomation {
    @ApiModelProperty(value = "毕业照ID")
    private Integer id;
    @ApiModelProperty(value = "毕业年份")
    private String years;
    @ApiModelProperty(value = "所属学院ID")
    private Integer cid;
    @ApiModelProperty(value = "所属专业ID")
    private Integer mid;
    @ApiModelProperty(value = "班级名")
    private String cname;
    @ApiModelProperty(value = "图片")
    private String img;

    @ApiModelProperty(value = "所属学院名")
    private String college;
    @ApiModelProperty(value = "所属专业名")
    private String marjor;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCollege() {
        return college;
    }

    public void setCollege(String college) {
        this.college = college;
    }

    public String getMarjor() {
        return marjor;
    }

    public void setMarjor(String marjor) {
        this.marjor = marjor;
    }

    public String getYears() {
        return years;
    }

    public void setYears(String years) {
        this.years = years;
    }

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public Integer getMid() {
        return mid;
    }

    public void setMid(Integer mid) {
        this.mid = mid;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }
}
