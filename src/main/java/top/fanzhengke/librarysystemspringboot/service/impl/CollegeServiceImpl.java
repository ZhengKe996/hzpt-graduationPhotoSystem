package top.fanzhengke.librarysystemspringboot.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.fanzhengke.librarysystemspringboot.domain.College;
import top.fanzhengke.librarysystemspringboot.mapper.CollegeMapper;
import top.fanzhengke.librarysystemspringboot.service.CollegeService;

import javax.annotation.Resource;
import java.util.List;

@Service(value = "CollegeService")
public class CollegeServiceImpl implements CollegeService {
    @Resource
    private CollegeMapper collegeMapper;

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
        return collegeMapper.addCollege(college);
    }

    @Override
    public Boolean update(College college) {
        return collegeMapper.updateCollege(college);
    }

    @Override
    public Boolean delete(Integer id) {
        return collegeMapper.delete(id);
    }
}
