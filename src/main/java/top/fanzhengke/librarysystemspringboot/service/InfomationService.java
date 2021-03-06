package top.fanzhengke.librarysystemspringboot.service;

import top.fanzhengke.librarysystemspringboot.domain.College;
import top.fanzhengke.librarysystemspringboot.domain.Infomation;
import top.fanzhengke.librarysystemspringboot.domain.Marjor;
import top.fanzhengke.librarysystemspringboot.entity.PageResult;

import java.util.HashMap;
import java.util.List;

public interface InfomationService {
    /**
     * 查询所有毕业照信息
     *
     * @return
     */
    public PageResult findAll(Integer currentPage, Integer pageSize, String year, Integer cid);

    /**
     * 根据id查询
     *
     * @param id
     * @return
     */
    public Infomation findById(Integer id);

    /**
     * 查询所有年份
     *
     * @param cid
     * @return
     */
    public List<String> findYears(Integer cid);

    /**
     * 查询该学院xxx年的专业信息
     *
     * @param cid
     * @param years
     * @return
     */
    public List<Marjor> findMarjor(Integer cid, String years);

    /**
     * @param cid
     * @param years
     * @param mid
     * @return
     */
    public List<Infomation> findClassName(Integer cid, String years, Integer mid);

    /**
     * 根据id删除
     *
     * @param id
     * @return
     */
    public Boolean delete(Integer id);

    /**
     * 新增 毕业照信息
     *
     * @param infomation
     * @return
     */
    public Boolean addInfomation(Infomation infomation);

    /**
     * 根据id 修改毕业照信息
     *
     * @param infomation
     * @return
     */
    public Boolean update(Infomation infomation);

    public List<College> findCidYears();
}
