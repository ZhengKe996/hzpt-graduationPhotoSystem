package top.fanzhengke.librarysystemspringboot.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import top.fanzhengke.librarysystemspringboot.constant.MessageConstant;
import top.fanzhengke.librarysystemspringboot.entity.Result;
import top.fanzhengke.librarysystemspringboot.utils.UploadUtil;

import java.util.ArrayList;
import java.util.Map;

@Api(tags = "图片上传")
@CrossOrigin
@RestController
@RequestMapping("/upload")
public class UploadController {
    @ApiOperation(value = "图片上传功能")
    @PostMapping
    public Result FileUpload(MultipartFile files[]) {
        try {
            ArrayList<Map> result = new ArrayList<>();
            for (int i = 0; i < files.length; i++) {
                Map upload = UploadUtil.upload(files[i]);
                result.add(upload);
            }
            return new Result(true, MessageConstant.ADD_PHOTO_SUCCESS, result);
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false, MessageConstant.ADD_PHOTO_FAIL);
        }
    }
}
