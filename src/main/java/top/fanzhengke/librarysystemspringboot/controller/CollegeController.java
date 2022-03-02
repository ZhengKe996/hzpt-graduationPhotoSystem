package top.fanzhengke.librarysystemspringboot.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;
import top.fanzhengke.librarysystemspringboot.constant.MessageConstant;
import top.fanzhengke.librarysystemspringboot.domain.College;
import top.fanzhengke.librarysystemspringboot.entity.Result;
import top.fanzhengke.librarysystemspringboot.service.CollegeService;

import javax.annotation.Resource;
import java.util.List;

@Api(tags = "学院操作")
@CrossOrigin
@RestController
@RequestMapping("/college")
public class CollegeController {
    @Resource
    private CollegeService collegeService;

    @ApiOperation(value = "查询所有学院")
    @GetMapping
    public Result findAll() {
        try {
            List<College> list = collegeService.findAll();
            return new Result(true, MessageConstant.QUERY_COLLEGE_SUCCESS, list);
        } catch (RuntimeException e) {
            e.printStackTrace();
            return new Result(false, MessageConstant.QUERY_COLLEGE_FAIL, e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false, MessageConstant.QUERY_COLLEGE_FAIL);
        }
    }

    @ApiOperation(value = "根据ID查询学院信息")
    @GetMapping(value = "/{id}")
    public Result getById(@PathVariable Integer id) {
        try {
            College college = collegeService.findById(id);
            return new Result(true, MessageConstant.QUERY_COLLEGE_SUCCESS, college);
        } catch (RuntimeException e) {
            e.printStackTrace();
            return new Result(false, MessageConstant.QUERY_COLLEGE_FAIL, e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false, MessageConstant.QUERY_COLLEGE_FAIL);
        }
    }

    @ApiOperation(value = "根据ID删除学院信息")
    @DeleteMapping(value = "/{id}")
    public Result deleteById(@PathVariable Integer id) {
        try {
            collegeService.delete(id);
        } catch (RuntimeException e) {
            e.printStackTrace();
            return new Result(false, MessageConstant.DELETE_COLLEGE_FAIL, e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false, MessageConstant.DELETE_COLLEGE_FAIL);
        }
        return new Result(true, MessageConstant.DELETE_COLLEGE_SUCCESS);
    }

    @ApiOperation(value = "新增学院信息")
    @PostMapping
    public Result save(College college) {
        try {
            collegeService.save(college);
        } catch (RuntimeException e) {
            e.printStackTrace();
            return new Result(false, MessageConstant.ADD_COLLEGE_FAIL, e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false, MessageConstant.ADD_COLLEGE_FAIL);
        }
        return new Result(true, MessageConstant.ADD_COLLEGE_SUCCESS);
    }

    @ApiOperation(value = "编辑学院信息")
    @PutMapping
    public Result update(College college) {
        try {
            collegeService.update(college);
        } catch (RuntimeException e) {
            e.printStackTrace();
            return new Result(false, MessageConstant.EDIT_COLLEGE_FAIL, e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false, MessageConstant.EDIT_COLLEGE_FAIL);
        }
        return new Result(true, MessageConstant.EDIT_COLLEGE_SUCCESS);
    }
}
