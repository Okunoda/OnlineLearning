package site.okunoda.service.service.impl;

import com.alibaba.excel.EasyExcel;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.web.multipart.MultipartFile;
import site.okunoda.service.entity.EduSubject;
import site.okunoda.service.entity.excel.SubjectData;
import site.okunoda.service.listener.SubjectListener;
import site.okunoda.service.mapper.EduSubjectMapper;
import site.okunoda.service.service.EduSubjectService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;

/**
 * <p>
 * 课程科目 服务实现类
 * </p>
 *
 * @author testjava
 * @since 2023-02-13
 */
@Service
public class EduSubjectServiceImpl extends ServiceImpl<EduSubjectMapper, EduSubject> implements EduSubjectService {

    @Override
    public void addSubject(MultipartFile file,EduSubjectService eduSubjectService) {
        try {
            InputStream inputStream = file.getInputStream();
            //这里调用的Listener的构造方法似乎不能传入”this"，似乎设计“spring事物失效”，没太明白
            /* TODO------整明白这里是否能用传入this的方式调用构造方法*/
//            EasyExcel.read(inputStream, SubjectData.class,new SubjectListener(this)).sheet().doRead();

            EasyExcel.read(inputStream,SubjectData.class,new SubjectListener(eduSubjectService)).sheet().doRead();


        } catch (IOException e) {
            e.printStackTrace();
        }
    }




}
