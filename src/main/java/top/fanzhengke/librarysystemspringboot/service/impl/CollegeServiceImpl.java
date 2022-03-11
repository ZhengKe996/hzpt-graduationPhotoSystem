package top.fanzhengke.librarysystemspringboot.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.fanzhengke.librarysystemspringboot.domain.College;
import top.fanzhengke.librarysystemspringboot.domain.Marjor;
import top.fanzhengke.librarysystemspringboot.mapper.CollegeMapper;
import top.fanzhengke.librarysystemspringboot.mapper.MarjorMapper;
import top.fanzhengke.librarysystemspringboot.service.CollegeService;

import javax.annotation.Resource;
import java.util.List;

@Service(value = "CollegeService")
public class CollegeServiceImpl implements CollegeService {
    @Resource
    private CollegeMapper collegeMapper;
    @Resource
    private MarjorMapper marjorMapper;

    @Override
    public List<College> findAll() {
        return collegeMapper.findAll();
    }

    @Override
    public College findById(Integer id) {
        return collegeMapper.findById(id);
    }

    @Override
    public Boolean save(College college) {
        College collegeMapperByCollege = collegeMapper.findByCollege(college.getCollege());
        if (collegeMapperByCollege != null){
            throw new RuntimeException("新增学院失败,学院已存在");
        }
        return collegeMapper.addCollege(college);
    }

    @Override
    public Boolean update(College college) {
        College collegeMapperById = collegeMapper.findById(college.getId());
        if (collegeMapperById == null) {
            throw new RuntimeException("编辑学院失败,请检查学院ID是否正确");
        }
        return collegeMapper.updateCollege(college);
    }

    @Override
    public Boolean delete(Integer id) {
        College college = collegeMapper.findById(id);
        if (college == null) {
            throw new RuntimeException("删除学院失败,请检查学院ID是否正确");
        }
        List<Marjor> marjors = marjorMapper.findByCid(id);
        if (marjors.size() > 0) {
            throw new RuntimeException("请先删除旗下专业");
        }
        return collegeMapper.delete(id);
    }
}
