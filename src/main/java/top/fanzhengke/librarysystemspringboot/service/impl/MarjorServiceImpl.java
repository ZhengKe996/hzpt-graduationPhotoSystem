package top.fanzhengke.librarysystemspringboot.service.impl;

import org.springframework.stereotype.Service;
import top.fanzhengke.librarysystemspringboot.domain.Marjor;
import top.fanzhengke.librarysystemspringboot.mapper.MarjorMapper;
import top.fanzhengke.librarysystemspringboot.service.MarjorService;

import javax.annotation.Resource;
import java.util.List;

@Service(value = "MarjorService")
public class MarjorServiceImpl implements MarjorService {
    @Resource
    private MarjorMapper marjorMapper;

    @Override
    public List<Marjor> findAll() {
        return marjorMapper.findAll();
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
