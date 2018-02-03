package com.yykj.mall.util;

import com.google.common.collect.Lists;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

/**
 * @author Lee
 * @date 2018/1/2
 */
public class FileUtil {



    public static class FileUtilHolder{
        private static final FileUtil INSTANCE = new FileUtil();
    }

    public static FileUtil getInstance(){
        return FileUtilHolder.INSTANCE;
    }

    private FileUtil(){}

    private Logger logger = LoggerFactory.getLogger(FileUtil.class);

    public String upload(MultipartFile file, String path){
        //path是暂时上传到tomcat服务器的路径，后面还要转移到ftp服务器
        String fileName = file.getOriginalFilename();
        String fileExtensionName = fileName.substring(fileName.lastIndexOf(".") + 1);
        String uploadFileName = UUID.randomUUID().toString() + "." + fileExtensionName;
        logger.info(fileName, path, uploadFileName);

        File fileDir = new File(path);
        if (!fileDir.exists()){
            fileDir.setWritable(true);
            fileDir.mkdirs();
        }
        File targetFile = new File(path, uploadFileName);
        try {
            file.transferTo(targetFile);

            FTPUtil.uploadFile(Lists.newArrayList(targetFile));

            targetFile.delete();
        } catch (IOException e) {
            logger.error("上传文件失败！", e);
            return null;
        }
        return targetFile.getName();
    }
}
