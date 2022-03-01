package top.fanzhengke.librarysystemspringboot.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.stereotype.Service;
import top.fanzhengke.librarysystemspringboot.domain.Infomation;
import top.fanzhengke.librarysystemspringboot.entity.PageResult;
import top.fanzhengke.librarysystemspringboot.mapper.InfomationMapper;
import top.fanzhengke.librarysystemspringboot.service.InfomationService;

import javax.annotation.Resource;
import java.util.List;

@Service(value = "InfomationService")
public class InfomationServiceImpl implements InfomationService {
    @Resource
    private InfomationMapper infomationMapper;

    @Override
    public PageResult findAll(Integer currentPage, Integer pageSize, String year, Integer cid) {
        PageHelper.startPage(currentPage, pageSize);
        Page<Infomation> page = infomationMapper.findAll(year, cid);

        return new PageResult(page.getTotal(), page.getResult());
    }

    @Override
    public Infomation findById(Integer id) {
        return infomationMapper.findById(id);
    }

    @Override
    public List<String> findYears(Integer cid) {
        return infomationMapper.findYears(cid);
    }

    @Override
    public List<String> findMarjor(Integer cid, String years) {
        return infomationMapper.findMarjor(cid, years);
    }

    @Override
    public List<String> findClassName(Integer cid, String years, Integer mid) {
        return infomationMapper.findClassName(cid, years, mid);
    }

    @Override
    public Boolean delete(Integer id) {
        return infomationMapper.delete(id);
    }

    @Override
    public Boolean addInfomation(Infomation infomation) {
        return infomationMapper.addInfomation(infomation);
    }

    @Override
    public Boolean update(Infomation infomation) {
        return infomationMapper.update(infomation);
    }
}
