package top.fanzhengke.librarysystemspringboot.controller;

import org.springframework.web.bind.annotation.*;
import top.fanzhengke.librarysystemspringboot.constant.MessageConstant;
import top.fanzhengke.librarysystemspringboot.domain.Infomation;
import top.fanzhengke.librarysystemspringboot.entity.PageResult;
import top.fanzhengke.librarysystemspringboot.entity.Result;
import top.fanzhengke.librarysystemspringboot.service.InfomationService;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/infomation")
public class InfomationController {
    @Resource
    private InfomationService infomationService;

    @GetMapping
    public Result findAll(@RequestParam("page") Integer currentPage, @RequestParam("size") Integer pageSize, @RequestParam(value = "year", required = false) String year, @RequestParam(value = "cid", required = false) Integer cid) {
        try {
            PageResult list = infomationService.findAll(currentPage, pageSize, year, cid);
            return new Result(true, MessageConstant.QUERY_INFO_SUCCESS, list);
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false, MessageConstant.QUERY_INFO_FAIL);
        }
    }

    @GetMapping("/{id}")
    public Result findById(@PathVariable Integer id) {
        try {
            Infomation infomation = infomationService.findById(id);
            return new Result(true, MessageConstant.QUERY_INFO_SUCCESS, infomation);
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false, MessageConstant.QUERY_INFO_FAIL);
        }
    }

    @GetMapping("/findYears")
    public Result findYears(@RequestParam("cid") Integer cid) {
        try {
            List<String> list = infomationService.findYears(cid);
            return new Result(true, MessageConstant.QUERY_YEARS_SUCCESS, list);
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false, MessageConstant.QUERY_YEARS_FAIL);
        }
    }

    @GetMapping("/findMarjor")
    public Result findMarjor(@RequestParam("cid") Integer cid, @RequestParam("years") String years) {
        try {
            List<String> list = infomationService.findMarjor(cid, years);
            return new Result(true, MessageConstant.QUERY_MARJOR_SUCCESS, list);
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false, MessageConstant.QUERY_MARJOR_FAIL);
        }

    }

    @GetMapping("/findClass")
    public Result findClassName(@RequestParam("cid") Integer cid, @RequestParam("years") String years, @RequestParam("mid") Integer mid) {
        try {
            List<String> list = infomationService.findClassName(cid, years, mid);
            return new Result(true, MessageConstant.QUERY_CLASSNAME_SUCCESS, list);
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false, MessageConstant.QUERY_CLASSNAME_FAIL);
        }
    }

    @DeleteMapping("/{id}")
    private Result delete(@PathVariable Integer id) {
        try {
            infomationService.delete(id);
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false, MessageConstant.DELETE_INFO_FAIL);
        }
        return new Result(true, MessageConstant.DELETE_INFO_SUCCESS);
    }

    @PostMapping
    public Result save(Infomation infomation) {
        try {
            infomationService.addInfomation(infomation);
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false, MessageConstant.ADD_INFO_FAIL);
        }
        return new Result(true, MessageConstant.ADD_INFO_SUCCESS);
    }

    @PutMapping
    public Result update(Infomation infomation) {
        try {
            infomationService.update(infomation);
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false, MessageConstant.EDIT_INFO_FAIL);
        }
        return new Result(true, MessageConstant.EDIT_INFO_SUCCESS);
    }
}
