package site.okunoda.oss.service.impl;

import com.aliyun.oss.ClientException;
import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import com.aliyun.oss.OSSException;
import com.aliyun.oss.model.PutObjectRequest;
import com.aliyun.oss.model.PutObjectResult;
import org.joda.time.DateTime;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import site.okunoda.oss.service.OssService;
import site.okunoda.oss.utils.ConstantPropertiesUtils;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.UUID;

/**
 * @author Okunoda
 * @date 2023年02月12日15:36
 */
@Service
public class OssServiceImplement implements OssService {

    @Override
    public String uploadFileAvatar(MultipartFile file) {

        String url = null;
        String endpoint = ConstantPropertiesUtils.END_POINT;
        String accessKeyId = ConstantPropertiesUtils.KEY_ID;
        String accessKeySecret = ConstantPropertiesUtils.KEY_SECRET;
        String bucketName = ConstantPropertiesUtils.BUCKET_NAME;

        OSS ossClient = new OSSClientBuilder().build(endpoint, accessKeyId, accessKeySecret);

        try {
            InputStream inputStream = file.getInputStream();
            String fileName=file.getOriginalFilename();
            //在文件名称里面添加随机 唯一的值
            //注意：随机生成的会出现 “-” ，需要替换掉
            String uuid = UUID.randomUUID().toString().replace("-","");
            fileName = uuid+fileName;

            //把文件按照日期进行分类
            //如：2023/2/13/1.jpg
            String path = new DateTime().toString("yyyy/MM/dd");
            fileName = path +"/"+ fileName;


            // 创建PutObjectRequest对象。
            //第一个参数：bucketName
            //第二个参数：上传到oss文件路径和文件名称   aa/bb/1.jpg
            //第三个参数：上传文件流
            PutObjectRequest putObjectRequest = new PutObjectRequest(bucketName, fileName, inputStream);
            ossClient.putObject(putObjectRequest);


            //类比如下规则将oss文件路径拼接出来
            //https://online-learning-0.oss-cn-hangzhou.aliyuncs.com/avatar/u%3D4006856264%2C584708577%26fm%3D253%26fmt%3Dauto%26app%3D120%26f%3DJPEG.jpg
            url = "https://"+ConstantPropertiesUtils.BUCKET_NAME+"."+ConstantPropertiesUtils.END_POINT+"/"+fileName;

        } catch (OSSException oe) {
            System.out.println("Caught an OSSException, which means your request made it to OSS, "
                    + "but was rejected with an error response for some reason.");
            System.out.println("Error Message:" + oe.getErrorMessage());
            System.out.println("Error Code:" + oe.getErrorCode());
            System.out.println("Request ID:" + oe.getRequestId());
            System.out.println("Host ID:" + oe.getHostId());
        } catch (ClientException ce) {
            System.out.println("Caught an ClientException, which means the client encountered "
                    + "a serious internal problem while trying to communicate with OSS, "
                    + "such as not being able to access the network.");
            System.out.println("Error Message:" + ce.getMessage());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (ossClient != null) {
                ossClient.shutdown();
            }
        }
        return url;
    }
}
