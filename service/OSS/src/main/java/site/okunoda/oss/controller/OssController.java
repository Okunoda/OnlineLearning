package site.okunoda.oss.controller;

import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import site.okunoda.common_utils.R;
import site.okunoda.oss.service.OssService;

/**
 * @author Okunoda
 * @date 2023年02月12日15:37
 */
@RestController
@RequestMapping("/eduoss/fileoss")
@CrossOrigin
public class OssController {

    @Autowired
    private OssService ossService;


    @ApiOperation(value="上传头像")
    @PostMapping("upload")
    public R uploadOssAvatar(MultipartFile file){
        //获取上传文件  MultipartFile
        //返回上传到oss的路径
        String url = ossService.uploadFileAvatar(file);

        return R.success().data("url",url);
    }


}
