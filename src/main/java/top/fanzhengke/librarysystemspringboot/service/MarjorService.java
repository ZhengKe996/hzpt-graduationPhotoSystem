package top.fanzhengke.librarysystemspringboot.service;

import top.fanzhengke.librarysystemspringboot.domain.Marjor;

import java.util.List;

public interface MarjorService {
    /**
     * 查询所有专业信息
     *
     * @return
     */
    public List<Marjor> findAll();

    /**
     * 根据id查询专业
     *
     * @param id
     * @return
     */
    public Marjor findById(Integer id);

    /**
     * 新增专业信息
     *
     * @param marjor
     * @return
     */
    public Boolean addMarjor(Marjor marjor);

    /**
     * 根据id删除专业信息
     *
     * @param id
     * @return
     */
    public Boolean delete(Integer id);

    /**
     * 根据id 编辑用户信息
     *
     * @param marjor
     * @return
     */
    public Boolean update(Marjor marjor);

    /**
     * 根据学院id 查询所有专业
     *
     * @param cid
     * @return
     */
    public List<Marjor> findByCid(Integer cid);
}
