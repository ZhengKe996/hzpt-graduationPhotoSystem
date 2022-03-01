package top.fanzhengke.librarysystemspringboot.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.stereotype.Service;
import top.fanzhengke.librarysystemspringboot.domain.Marjor;
import top.fanzhengke.librarysystemspringboot.entity.PageResult;
import top.fanzhengke.librarysystemspringboot.mapper.MarjorMapper;
import top.fanzhengke.librarysystemspringboot.service.MarjorService;

import javax.annotation.Resource;
import java.util.List;

@Service(value = "MarjorService")
public class MarjorServiceImpl implements MarjorService {
    @Resource
    private MarjorMapper marjorMapper;

    @Override
    public PageResult findAll(Integer currentPage, Integer pageSize, Integer query) {
        PageHelper.startPage(currentPage, pageSize);
        Page<Marjor> page = marjorMapper.findAll(query);
        return new PageResult(page.getTotal(), page.getResult());
    }

    @Override
    public Marjor findById(Integer id) {
        return marjorMapper.findById(id);
    }

    @Override
    public Boolean addMarjor(Marjor marjor) {
        return marjorMapper.addMarjor(marjor);
    }

    @Override
    public Boolean delete(Integer id) {
        return marjorMapper.delete(id);
    }

    @Override
    public Boolean update(Marjor marjor) {
        return marjorMapper.update(marjor);
    }

    @Override
    public List<Marjor> findByCid(Integer cid) {
        return marjorMapper.findByCid(cid);
    }
}
