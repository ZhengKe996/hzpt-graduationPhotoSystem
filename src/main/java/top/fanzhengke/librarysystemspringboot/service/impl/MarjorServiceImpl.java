package top.fanzhengke.librarysystemspringboot.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.stereotype.Service;
import top.fanzhengke.librarysystemspringboot.domain.Marjor;
import top.fanzhengke.librarysystemspringboot.entity.PageResult;
import top.fanzhengke.librarysystemspringboot.mapper.CollegeMapper;
import top.fanzhengke.librarysystemspringboot.mapper.InfomationMapper;
import top.fanzhengke.librarysystemspringboot.mapper.MarjorMapper;
import top.fanzhengke.librarysystemspringboot.service.MarjorService;

import javax.annotation.Resource;
import java.util.List;

@Service(value = "MarjorService")
public class MarjorServiceImpl implements MarjorService {
    @Resource
    private MarjorMapper marjorMapper;
    @Resource
    private CollegeMapper collegeMapper;

    @Resource
    private InfomationMapper infomationMapper;

    @Override
    public PageResult findAll(Integer currentPage, Integer pageSize, Integer query) {
        PageHelper.startPage(currentPage, pageSize);
        Page<Marjor> page = marjorMapper.findAll(query);
        for (Marjor marjor : page) {
            marjor.setCollege(collegeMapper.findById(marjor.getCid()).getCollege());
        }
        return new PageResult(page.getTotal(), page.getResult());
    }

    @Override
    public Marjor findById(Integer id) {
        Marjor marjor = marjorMapper.findById(id);
        marjor.setCollege(collegeMapper.findById(marjor.getCid()).getCollege());
        return marjor;
    }

    @Override
    public Boolean addMarjor(Marjor marjor) {
        return marjorMapper.addMarjor(marjor);
    }

    @Override
    public Boolean delete(Integer id) {
        Marjor marjor = marjorMapper.findById(id);
        if (marjor == null) {
            throw new RuntimeException("删除专业失败,请检查专业ID是否正确");
        }
        String mid = infomationMapper.findByMid(id);
        if (mid != null) {
            throw new RuntimeException("删除专业失败,请先删除旗下班级");
        }
        return marjorMapper.delete(id);
    }

    @Override
    public Boolean update(Marjor marjor) {
        Marjor marjorMapperById = marjorMapper.findById(marjor.getId());
        if (marjorMapperById == null) {
            throw new RuntimeException("编辑专业失败,请检查专业ID是否正确");
        }
        return marjorMapper.update(marjor);
    }

    @Override
    public List<Marjor> findByCid(Integer cid) {
        return marjorMapper.findByCid(cid);
    }
}
