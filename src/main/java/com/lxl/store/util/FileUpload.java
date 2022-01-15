package com.lxl.store.util;

import org.apache.tika.Tika;
import org.apache.tika.exception.TikaException;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.UUID;

import com.lxl.store.exception.*;

import javax.servlet.http.HttpSession;

/**
 * 文件上传的工具处理类
 * @author LiXianLei
 * @time 2022/01/15 11:10
 */
public class FileUpload {

    private static final FileUpload instance = new FileUpload();

    public static FileUpload getInstance(){
        return instance;
    }

    //上传图片的根目录
    private static final String ROOT = "upload";

    // 头像最大尺寸，是按照字节为最小单位表示的
    private static final int AVATAR_MAX_SIZE = 10 * 1024 * 1024;

    // 上传图像文件的类型
    private static final List<String> AVATAR_TYPE = new LinkedList<>();

    // 使用静态块来完成AVATAR_TYPE的类型添加
    static{
        AVATAR_TYPE.add("image/jpg");
        AVATAR_TYPE.add("image/jpeg");
        AVATAR_TYPE.add("image/png");
        AVATAR_TYPE.add("image/bmp");
        AVATAR_TYPE.add("image/gif");
    }

    /**
     * @author LiXianLei
     * @describtion //TODO
     * @return {@link String}
     * @param file MultipartFile文件，将文件转存并返回存储路径
     * @time 2022/1/15 11:29
     **/
    public String fileUpload(HttpSession session, MultipartFile file){
        // 判断文件是否为空
        if(file.isEmpty()){
            throw new FileEmptyException("文件为空");
        }
        // 判断文件大小是否超出限制
        if(file.getSize() > AVATAR_MAX_SIZE){
            throw new FileOverSizedException("文件大小超出限制");
        }
        // 判断文件类型是否为我们规定的文件类型
        // getContentType()返回的就是"text/html"或者"images/png"
        String type = file.getContentType();
        if(!AVATAR_TYPE.contains(type)){
            throw new FileTypeException("文件类型不支持");
        }

        // 上传的文件路径  “.../upload/文件.png”
        String path = session.getServletContext().getRealPath(ROOT);
        // 判断路径是否存在
        File dic = new File(path);
        if(!dic.exists()){
            dic.mkdirs();
        }
        // 获取源文件名称包含后缀名
        String originalFilename = file.getOriginalFilename();
        // 获取源文件后缀名
        assert originalFilename != null;
        String suffix = originalFilename.substring(originalFilename.lastIndexOf('.'));
        // 为避免重复，使用UUID重新获取新的文件名称
        String filename = UUID.randomUUID().toString().toUpperCase() + suffix;
        File des = new File(path, filename);
        try {
            file.transferTo(des);
        } catch (IOException e) {
            throw new FileUploadIOException("文件读写异常");
        }
        // 判断文件是否损坏
        try{
            Tika tika = new Tika();
            tika.parseToString(des);
        }catch (TikaException | IOException e){
            throw new FileStateException("文件状态异常");
        }
        return "/" + ROOT + "/" + filename;
    }
}
