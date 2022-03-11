package top.fanzhengke.librarysystemspringboot.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import io.swagger.models.auth.In;
import org.springframework.stereotype.Service;
import top.fanzhengke.librarysystemspringboot.domain.College;
import top.fanzhengke.librarysystemspringboot.domain.Infomation;
import top.fanzhengke.librarysystemspringboot.domain.Marjor;
import top.fanzhengke.librarysystemspringboot.entity.PageResult;
import top.fanzhengke.librarysystemspringboot.mapper.CollegeMapper;
import top.fanzhengke.librarysystemspringboot.mapper.InfomationMapper;
import top.fanzhengke.librarysystemspringboot.mapper.MarjorMapper;
import top.fanzhengke.librarysystemspringboot.service.InfomationService;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service(value = "InfomationService")
public class InfomationServiceImpl implements InfomationService {
    @Resource
    private InfomationMapper infomationMapper;

    @Resource
    private CollegeMapper collegeMapper;

    @Resource
    private MarjorMapper marjorMapper;

    @Override
    public PageResult findAll(Integer currentPage, Integer pageSize, String year, Integer cid) {
        PageHelper.startPage(currentPage, pageSize);
        Page<Infomation> page = infomationMapper.findAll(year, cid);
        for (Infomation infomation : page) {
            infomation.setCollege(collegeMapper.findById(infomation.getCid()).getCollege());
            infomation.setMarjor(marjorMapper.findById(infomation.getMid()).getMarjor());
        }

        return new PageResult(page.getTotal(), page.getResult());
    }

    @Override
    public Infomation findById(Integer id) {
        Infomation infomation = infomationMapper.findById(id);

        infomation.setCollege(collegeMapper.findById(infomation.getCid()).getCollege());
        infomation.setMarjor(marjorMapper.findById(infomation.getMid()).getMarjor());
        return infomation;
    }

    @Override
    public List<String> findYears(Integer cid) {
        return infomationMapper.findYears(cid);
    }

    @Override
    public List<Marjor> findMarjor(Integer cid, String years) {
        List<String> mid = infomationMapper.findMarjor(cid, years);
        ArrayList<Marjor> marjors = new ArrayList<>();
        for (String s : mid) {
            Marjor mapper = marjorMapper.findById(Integer.valueOf(s));
            marjors.add(mapper);
        }
        return marjors;
    }

    @Override
    public List<Infomation> findClassName(Integer cid, String years, Integer mid) {
        List<Infomation> name = infomationMapper.findClassName(cid, years, mid);
        for (Infomation infomation : name) {
            System.out.println(infomation.getCname()+infomation.getId());
        }
        return name;
    }

    @Override
    public Boolean delete(Integer id) {
        Infomation infomation = infomationMapper.findById(id);
        if (infomation == null) {
            throw new RuntimeException("删除失败,请检查ID是否正确");
        }
        return infomationMapper.delete(id);
    }

    @Override
    public Boolean addInfomation(Infomation infomation) {
        return infomationMapper.addInfomation(infomation);
    }

    @Override
    public Boolean update(Infomation infomation) {
        Infomation infomationMapperById = infomationMapper.findById(infomation.getId());
        if (infomationMapperById == null) {
            throw new RuntimeException("编辑失败,请检查ID是否正确");
        }
        return infomationMapper.update(infomation);
    }

    @Override
    public  List<College>  findCidYears() {
        List<College> colleges = collegeMapper.findAll();
        for (College college : colleges) {
            college.setYears(infomationMapper.findYears(college.getId()));
        }
        return colleges;
    }


}
