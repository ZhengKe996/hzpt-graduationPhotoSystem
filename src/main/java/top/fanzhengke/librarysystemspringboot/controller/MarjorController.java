package top.fanzhengke.librarysystemspringboot.controller;

import org.springframework.web.bind.annotation.*;
import top.fanzhengke.librarysystemspringboot.constant.MessageConstant;
import top.fanzhengke.librarysystemspringboot.domain.Marjor;
import top.fanzhengke.librarysystemspringboot.entity.PageResult;
import top.fanzhengke.librarysystemspringboot.entity.Result;
import top.fanzhengke.librarysystemspringboot.service.MarjorService;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping(value = "/marjor")
public class MarjorController {
    @Resource
    private MarjorService marjorService;

    @GetMapping
    public Result pageQuery(@RequestParam("page") Integer currentPage, @RequestParam("size") Integer pageSize, @RequestParam(value = "cid", required = false) Integer query) {
        try {
            PageResult list = marjorService.findAll(currentPage, pageSize, query);
            return new Result(true, MessageConstant.QUERY_MARJOR_SUCCESS, list);
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false, MessageConstant.QUERY_MARJOR_FAIL);
        }
    }

    @GetMapping(value = "/{id}")
    public Result findById(@PathVariable Integer id) {
        try {
            Marjor marjor = marjorService.findById(id);
            return new Result(true, MessageConstant.QUERY_MARJOR_SUCCESS, marjor);
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false, MessageConstant.QUERY_MARJOR_FAIL);
        }
    }

    @GetMapping("findByCollege/{cid}")
    public Result findByCid(@PathVariable Integer cid) {
        try {
            List<Marjor> list = marjorService.findByCid(cid);
            return new Result(true, MessageConstant.QUERY_MARJOR_SUCCESS, list);
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false, MessageConstant.QUERY_MARJOR_FAIL);
        }
    }

    @DeleteMapping(value = "/{id}")
    public Result delete(@PathVariable Integer id) {
        try {
            marjorService.delete(id);
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false, MessageConstant.DELETE_MARJOR_FAIL);
        }
        return new Result(true, MessageConstant.DELETE_MARJOR_SUCCESS);
    }

    @PostMapping
    public Result save(Marjor marjor) {
        try {
            marjorService.addMarjor(marjor);
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false, MessageConstant.ADD_MARJOR_FAIL);
        }
        return new Result(true, MessageConstant.ADD_MARJOR_SUCCESS);
    }

    @PutMapping
    public Result update(Marjor marjor) {
        try {
            marjorService.update(marjor);
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false, MessageConstant.EDIT_MARJOR_FAIL);
        }
        return new Result(true, MessageConstant.EDIT_MARJOR_SUCCESS);
    }
}
