package top.fanzhengke.librarysystemspringboot.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;
import top.fanzhengke.librarysystemspringboot.constant.MessageConstant;
import top.fanzhengke.librarysystemspringboot.domain.Marjor;
import top.fanzhengke.librarysystemspringboot.entity.PageResult;
import top.fanzhengke.librarysystemspringboot.entity.Result;
import top.fanzhengke.librarysystemspringboot.service.MarjorService;

import javax.annotation.Resource;
import java.util.List;

@Api(tags = "专业操作")
@CrossOrigin
@RestController
@RequestMapping(value = "/marjor")
public class MarjorController {
    @Resource
    private MarjorService marjorService;

    @ApiOperation(value = "分页查询 可根据 学院ID 查询")
    @GetMapping
    public Result pageQuery(@RequestParam("page") Integer currentPage,
                            @RequestParam("size") Integer pageSize,
                            @RequestParam(value = "cid", required = false) Integer query) {
        try {
            PageResult list = marjorService.findAll(currentPage, pageSize, query);
            return new Result(true, MessageConstant.QUERY_MARJOR_SUCCESS, list);
        } catch (RuntimeException e) {
            e.printStackTrace();
            return new Result(false, MessageConstant.QUERY_MARJOR_FAIL, e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false, MessageConstant.QUERY_MARJOR_FAIL);
        }
    }

    @ApiOperation(value = "根据 ID 查询专业信息")
    @GetMapping(value = "/{id}")
    public Result findById(@PathVariable Integer id) {
        try {
            Marjor marjor = marjorService.findById(id);
            return new Result(true, MessageConstant.QUERY_MARJOR_SUCCESS, marjor);
        } catch (RuntimeException e) {
            e.printStackTrace();
            return new Result(false, MessageConstant.QUERY_MARJOR_FAIL, e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false, MessageConstant.QUERY_MARJOR_FAIL);
        }
    }

    @ApiOperation(value = "根据 学院ID 查询所有专业")
    @GetMapping("findByCollege/{cid}")
    public Result findByCid(@PathVariable Integer cid) {
        try {
            List<Marjor> list = marjorService.findByCid(cid);
            return new Result(true, MessageConstant.QUERY_MARJOR_SUCCESS, list);
        } catch (RuntimeException e) {
            e.printStackTrace();
            return new Result(false, MessageConstant.QUERY_MARJOR_FAIL, e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false, MessageConstant.QUERY_MARJOR_FAIL);
        }
    }

    @ApiOperation(value = "根据 ID 删除专业信息")
    @DeleteMapping(value = "/{id}")
    public Result delete(@PathVariable Integer id) {
        try {
            marjorService.delete(id);
        } catch (RuntimeException e) {
            e.printStackTrace();
            return new Result(false, MessageConstant.DELETE_MARJOR_FAIL, e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false, MessageConstant.DELETE_MARJOR_FAIL);
        }
        return new Result(true, MessageConstant.DELETE_MARJOR_SUCCESS);
    }

    @ApiOperation(value = "新增专业信息")
    @PostMapping
    public Result save(@RequestBody Marjor marjor) {
        try {
            marjorService.addMarjor(marjor);
        } catch (RuntimeException e) {
            e.printStackTrace();
            return new Result(false, MessageConstant.ADD_MARJOR_FAIL, e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false, MessageConstant.ADD_MARJOR_FAIL);
        }
        return new Result(true, MessageConstant.ADD_MARJOR_SUCCESS);
    }

    @ApiOperation(value = "编辑专业信息")
    @PutMapping
    public Result update(@RequestBody Marjor marjor) {
        try {
            marjorService.update(marjor);
        } catch (RuntimeException e) {
            e.printStackTrace();
            return new Result(false, MessageConstant.EDIT_MARJOR_FAIL, e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false, MessageConstant.EDIT_MARJOR_FAIL);
        }
        return new Result(true, MessageConstant.EDIT_MARJOR_SUCCESS);
    }
}
