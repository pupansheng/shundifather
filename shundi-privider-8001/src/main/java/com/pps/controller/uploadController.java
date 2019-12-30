package com.pps.controller;

import com.pps.MyLog;
import com.pps.util.IdWorker;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @Classname uploadController
 * @Description
 * @@Author Pupansheng
 * @Date 2019/7/17 15:15
 * @Vestion 1.0
 **/
@RestController
@CrossOrigin
public class uploadController {

    @Value("${imagePath}")
    String imagePath;
    @ApiOperation(value="上传文件 文件名必须为file", notes="")
    @RequestMapping(value = "/upload",method = RequestMethod.POST)
    public Map upload2(MultipartFile file) throws IOException {

        Map map=new HashMap();
        if(file==null){

            MyLog.logger.info("文件上传：文件为空");
            map.put("status",false);
            return map;

        }

        MyLog.logger.info("文件上传："+file.getOriginalFilename());


        //1、取文件的扩展名
        try {
            String originalFilename = file.getOriginalFilename();
            String extName = originalFilename.substring(originalFilename.lastIndexOf(".") + 1);

            //创建一个文件名
            IdWorker idWorker=new IdWorker();
            String newName = idWorker.nextId() + "." + extName;

            //创建目录
            String currentDate = new SimpleDateFormat("yyyyMMdd").format(new Date(System.currentTimeMillis()));
            if (!Files.exists(Paths.get(imagePath + "//" + currentDate))) {
                Files.createDirectories(Paths.get(imagePath + "//" + currentDate));
            }

            Files.write(Paths.get(imagePath + "//" + currentDate + "//" + newName), file.getBytes());

             String url="uploadImages//"+currentDate + "//" + newName;
             map.put("status",true);
             map.put("url",url);

        }
        catch ( Exception e){

            e.printStackTrace();
            map.put("status",false);

        }

        return  map;


    }



}
