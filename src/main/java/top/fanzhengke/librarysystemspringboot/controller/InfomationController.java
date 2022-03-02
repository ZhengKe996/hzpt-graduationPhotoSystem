package top.fanzhengke.librarysystemspringboot.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;
import top.fanzhengke.librarysystemspringboot.constant.MessageConstant;
import top.fanzhengke.librarysystemspringboot.domain.Infomation;
import top.fanzhengke.librarysystemspringboot.entity.PageResult;
import top.fanzhengke.librarysystemspringboot.entity.Result;
import top.fanzhengke.librarysystemspringboot.service.InfomationService;

import javax.annotation.Resource;
import java.util.List;

@Api(tags = "毕业照操作")
@CrossOrigin
@RestController
@RequestMapping("/infomation")
public class InfomationController {
    @Resource
    private InfomationService infomationService;

    @ApiOperation(value = "分页查询所有毕业照 可根据 年份 学院 查询")
    @GetMapping
    public Result findAll(@RequestParam("page") Integer currentPage,
                          @RequestParam("size") Integer pageSize,
                          @RequestParam(value = "year", required = false) String year,
                          @RequestParam(value = "cid", required = false) Integer cid) {
        try {
            PageResult list = infomationService.findAll(currentPage, pageSize, year, cid);
            return new Result(true, MessageConstant.QUERY_INFO_SUCCESS, list);
        } catch (RuntimeException e) {
            e.printStackTrace();
            return new Result(false, MessageConstant.QUERY_MARJOR_FAIL, e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false, MessageConstant.QUERY_INFO_FAIL);
        }
    }

    @ApiOperation(value = "根据 ID 查询毕业照信息")
    @GetMapping("/{id}")
    public Result findById(@PathVariable Integer id) {
        try {
            Infomation infomation = infomationService.findById(id);
            return new Result(true, MessageConstant.QUERY_INFO_SUCCESS, infomation);
        } catch (RuntimeException e) {
            e.printStackTrace();
            return new Result(false, MessageConstant.QUERY_MARJOR_FAIL, e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false, MessageConstant.QUERY_INFO_FAIL);
        }
    }

    @ApiOperation(value = "根据 学院I D查询年份列表")
    @GetMapping("/findYears")
    public Result findYears(@RequestParam("cid") Integer cid) {
        try {
            List<String> list = infomationService.findYears(cid);
            return new Result(true, MessageConstant.QUERY_YEARS_SUCCESS, list);
        } catch (RuntimeException e) {
            e.printStackTrace();
            return new Result(false, MessageConstant.QUERY_MARJOR_FAIL, e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false, MessageConstant.QUERY_YEARS_FAIL);
        }
    }

    @ApiOperation(value = "根据 学院ID 年份 查询专业信息")
    @GetMapping("/findMarjor")
    public Result findMarjor(@RequestParam("cid") Integer cid, @RequestParam("years") String years) {
        try {
            List<String> list = infomationService.findMarjor(cid, years);
            return new Result(true, MessageConstant.QUERY_MARJOR_SUCCESS, list);
        } catch (RuntimeException e) {
            e.printStackTrace();
            return new Result(false, MessageConstant.QUERY_MARJOR_FAIL, e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false, MessageConstant.QUERY_MARJOR_FAIL);
        }

    }

    @ApiOperation(value = "根据 学院id 年份 专业 查询班级信息")
    @GetMapping("/findClass")
    public Result findClassName(@RequestParam("cid") Integer cid,
                                @RequestParam("years") String years,
                                @RequestParam("mid") Integer mid) {
        try {
            List<String> list = infomationService.findClassName(cid, years, mid);
            return new Result(true, MessageConstant.QUERY_CLASSNAME_SUCCESS, list);
        } catch (RuntimeException e) {
            e.printStackTrace();
            return new Result(false, MessageConstant.QUERY_MARJOR_FAIL, e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false, MessageConstant.QUERY_CLASSNAME_FAIL);
        }
    }

    @ApiOperation(value = "根据 ID 删除毕业照信息")
    @DeleteMapping("/{id}")
    private Result delete(@PathVariable Integer id) {
        try {
            infomationService.delete(id);
        } catch (RuntimeException e) {
            e.printStackTrace();
            return new Result(false, MessageConstant.QUERY_MARJOR_FAIL, e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false, MessageConstant.DELETE_INFO_FAIL);
        }
        return new Result(true, MessageConstant.DELETE_INFO_SUCCESS);
    }

    @ApiOperation(value = "新增毕业照信息")
    @PostMapping
    public Result save(Infomation infomation) {
        try {
            infomationService.addInfomation(infomation);
        } catch (RuntimeException e) {
            e.printStackTrace();
            return new Result(false, MessageConstant.QUERY_MARJOR_FAIL, e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false, MessageConstant.ADD_INFO_FAIL);
        }
        return new Result(true, MessageConstant.ADD_INFO_SUCCESS);
    }

    @ApiOperation(value = "编辑毕业照信息")
    @PutMapping
    public Result update(Infomation infomation) {
        try {
            infomationService.update(infomation);
        } catch (RuntimeException e) {
            e.printStackTrace();
            return new Result(false, MessageConstant.QUERY_MARJOR_FAIL, e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false, MessageConstant.EDIT_INFO_FAIL);
        }
        return new Result(true, MessageConstant.EDIT_INFO_SUCCESS);
    }
}
