package top.fanzhengke.librarysystemspringboot.service;

import top.fanzhengke.librarysystemspringboot.domain.College;

import java.util.List;

public interface CollegeService {
    /**
     * 查询所有学院信息
     *
     * @return
     */
    public List<College> findAll();

    /**
     * 通过ID查询单个学院
     *
     * @param id
     * @return
     */
    public College findById(Integer id);

    /**
     * 新增学院信息
     *
     * @param college
     * @return
     */
    public Boolean save(College college);

    /**
     * 更新学院信息
     *
     * @param college
     * @return
     */
    public Boolean update(College college);

    /**
     * 删除学院信息
     *
     * @param id
     * @return
     */
    public Boolean delete(Integer id);
}
