package top.fanzhengke.librarysystemspringboot.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.stereotype.Component;

import java.util.List;

@ApiModel(value = "学院")
@Component
public class College {
    @ApiModelProperty(value = "学院ID")
    private Integer id;
    @ApiModelProperty(value = "学院名称")
    private String college;

    @ApiModelProperty(value = "毕业年份信息")
    private List<String> years;

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

    public List<String> getYears() {
        return years;
    }

    public void setYears(List<String> years) {
        this.years = years;
    }
}
