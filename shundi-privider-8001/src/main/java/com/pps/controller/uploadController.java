package com.pps.controller;

import com.alibaba.druid.util.StringUtils;
import com.pps.MyLog;
import com.pps.pojo.exception.UnknowException;
import com.pps.pojo.group.Result;
import com.pps.util.FastDFSClient;
import com.pps.util.IdWorker;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
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
    @Value("${FILE_SERVER_URL}")
    private String FILE_SERVER_URL;//文件服务器地址
    @ApiOperation(value="上传文件 文件名必须为file", notes="")
    @RequestMapping(value = "/upload",method = RequestMethod.POST)
    public Map upload2(MultipartFile file) throws IOException {

    /*    Map map=new HashMap();
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

        return  map;*/

        Map map=new HashMap();
        //1、取文件的扩展名
        String originalFilename = file.getOriginalFilename();
        String extName = originalFilename.substring(originalFilename.lastIndexOf(".") + 1);
        try {
         //2、创建一个 FastDFS 的客户端
            FastDFSClient fastDFSClient
                    = new FastDFSClient("classpath:fdfs_client.conf");
            //3、执行上传处理


            String path = fastDFSClient.uploadFile(file.getBytes(), extName);


            //4、拼接返回的 url 和 ip 地址，拼装成完整的 url
            String url = FILE_SERVER_URL + path;
             MyLog.logger.info("返回地址："+url);
             map.put("status",true);
             map.put("url",url);
        } catch (Exception e) {
            e.printStackTrace();
             map.put("status",false);


        }


            return  map;

    }


    @RequestMapping("/download/{name}")
    public  void  downloadApp(@PathVariable String name, HttpServletResponse response) throws IOException {

        if(!StringUtils.isEmpty(name)){

            String path="/user/local/filedownload/"+name;
            Path path1 = Paths.get(path);
            if(Files.exists(path1)){

              byte [] a=  Files.readAllBytes(path1);
                response.reset();
                // 设置response的Header
                response.addHeader("Content-Disposition", "attachment;filename=" + name);
                response.addHeader("Content-Length", "" + a.length);
                OutputStream toClient = new BufferedOutputStream(response.getOutputStream());
                response.setContentType("application/octet-stream");
                toClient.write(a);
                toClient.flush();
                toClient.close();

            }else{

                throw  new UnknowException("该文件不存在");
            }

        }else{

            throw  new UnknowException("文件名为空");

        }





    }



}
