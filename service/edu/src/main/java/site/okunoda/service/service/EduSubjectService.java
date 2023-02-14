package site.okunoda.service.service;

import org.springframework.web.multipart.MultipartFile;
import site.okunoda.service.entity.EduSubject;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 课程科目 服务类
 * </p>
 *
 * @author testjava
 * @since 2023-02-13
 */
public interface EduSubjectService extends IService<EduSubject> {

    //添加课程分类
    void addSubject(MultipartFile file,EduSubjectService eduSubjectService);
}
