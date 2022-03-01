package top.fanzhengke.librarysystemspringboot.controller;

import org.springframework.web.bind.annotation.*;
import top.fanzhengke.librarysystemspringboot.constant.MessageConstant;
import top.fanzhengke.librarysystemspringboot.domain.College;
import top.fanzhengke.librarysystemspringboot.entity.Result;
import top.fanzhengke.librarysystemspringboot.service.CollegeService;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/college")
public class CollegeController {
    @Resource
    private CollegeService collegeService;

    @GetMapping
    public Result findAll() {
        try {
            List<College> list = collegeService.findAll();
            return new Result(true, MessageConstant.QUERY_COLLEGE_SUCCESS, list);
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false, MessageConstant.QUERY_COLLEGE_FAIL);
        }
    }

    @GetMapping(value = "/{id}")
    public Result getById(@PathVariable Integer id) {
        try {
            College college = collegeService.findById(id);
            return new Result(true, MessageConstant.QUERY_COLLEGE_SUCCESS, college);
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false, MessageConstant.QUERY_COLLEGE_FAIL);
        }
    }

    @DeleteMapping(value = "/{id}")
    public Result deleteById(@PathVariable Integer id) {
        try {
            collegeService.delete(id);
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false, MessageConstant.DELETE_COLLEGE_FAIL);
        }
        return new Result(true, MessageConstant.DELETE_COLLEGE_SUCCESS);
    }

    @PostMapping
    public Result save(College college) {
        System.out.println(college);
        try {
            collegeService.save(college);
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false, MessageConstant.ADD_COLLEGE_FAIL);
        }
        return new Result(true, MessageConstant.ADD_COLLEGE_SUCCESS);
    }

    @PutMapping
    public Result update(College college) {
        try {
            collegeService.update(college);
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false, MessageConstant.EDIT_COLLEGE_FAIL);
        }
        return new Result(true, MessageConstant.EDIT_COLLEGE_SUCCESS);
    }
}
