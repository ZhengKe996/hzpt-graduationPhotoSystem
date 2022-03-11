package top.fanzhengke.librarysystemspringboot.utils;

import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;

public class UploadUtil {

    public static Map upload(MultipartFile file) {
        if (file.isEmpty()) {
            return null;
        }
        //获取文件名
        String fileName = file.getOriginalFilename();

        //判断文件的大小
        long size = file.getSize();
        StringBuffer bytes = new StringBuffer();
        DecimalFormat format = new DecimalFormat("#####.0");
        if (size >= 1024 * 1024 * 1024) {
            double i = (size / (1024.0 * 1024.0 * 1024.0));
            bytes.append(format.format(i)).append("GB");
        } else if (size >= 1024 * 1024) {
            double i = (size / (1024.0 * 1024.0));
            bytes.append(format.format(i)).append("MB");
        } else if (size >= 1024) {
            double i = (size / (1024.0));
            bytes.append(format.format(i)).append("KB");
        } else if (size < 1024) {
            if (size <= 0) {
                bytes.append("0B");
            } else {
                bytes.append((int) size).append("B");
            }
        }

        //文件上传路径(根据情况修改)
        String path = "D:/images/";
//        String path = "/Users/coco/Downloads";

//        fileName = UUID.randomUUID().toString().replace("-", "") + suffixName;


        File dest = new File(path + "/" + fileName);

        if (!dest.getParentFile().exists()) {
            dest.getParentFile().mkdirs();
        }
        String url = null;
        try {
            file.transferTo(dest);
            //文件读取路径
            url = fileName;
            Map<String, String> map = new HashMap<>();
            map.put("fileName", fileName);
            map.put("url", url);
            map.put("size", String.valueOf(bytes));
            return map;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

}
