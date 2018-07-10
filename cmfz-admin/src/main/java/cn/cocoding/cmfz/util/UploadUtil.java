package cn.cocoding.cmfz.util;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Created by huzi on 2018/7/6.
 */
public class UploadUtil {
    //单个文件上传
    public static String upload(MultipartFile myFile, HttpSession session) throws IOException {
        //获得服务端文件夹的路径
        String realPath = session.getServletContext().getRealPath("/main/image");
        //来个想要存储的文件名前缀，这里用uuid
        String uuidName = UUID.randomUUID().toString().replace("-", "");
        //拿到上传的文件的后缀名
        String oldName = myFile.getOriginalFilename();
        String suffix = oldName.substring(oldName.lastIndexOf("."));
        //文件全名
        String fileDetailName = uuidName + suffix;
        //上传到服务器
        myFile.transferTo(new File(realPath + "/" + fileDetailName));

        return fileDetailName;
    }
    //多文件上传
    public static List<String> uploads(@RequestParam("files") MultipartFile[] files, HttpSession session, HttpServletRequest request) throws IOException {
        //获得服务端文件夹的路径
        String realPath = session.getServletContext().getRealPath("/main/image");
        //创建List<REImageResult>用户储存图片的路径
        List<String> data = new ArrayList<>();
        //遍历
        for (MultipartFile file : files) {
            //来个想要存储的文件名前缀，这里用uuid
            String uuidName = UUID.randomUUID().toString().replace("-", "");
            //拿到上传的文件的后缀名
            String oldName = file.getOriginalFilename();
            String suffix = oldName.substring(oldName.lastIndexOf("."));
            //文件全名
            String fileDetailName = uuidName + suffix;
            //上传到服务器
            file.transferTo(new File(realPath + "/" + fileDetailName));
            //将文件访问路径存储到data
            data.add("http://localhost:8989/cmfz-admin/main/image" + "/" + fileDetailName);
        }
        return data;
    }
}
