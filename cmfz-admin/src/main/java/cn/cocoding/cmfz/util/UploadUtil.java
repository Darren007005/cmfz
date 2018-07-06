package cn.cocoding.cmfz.util;

import cn.cocoding.cmfz.entity.Carousel;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.UUID;

/**
 * Created by huzi on 2018/7/6.
 */
public class UploadUtil {
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
}
