package top.fanzhengke.librarysystemspringboot.domain;

import org.springframework.stereotype.Component;

@Component
public class College {
    private Integer id;
    private String college;

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
}
