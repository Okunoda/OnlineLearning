package site.okunoda.service.controller;


import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import site.okunoda.common_utils.R;
import site.okunoda.service.service.EduSubjectService;

/**
 * <p>
 * 课程科目 前端控制器
 * </p>
 *
 * @author testjava
 * @since 2023-02-13
 */
@RestController
@RequestMapping("/service/edu-subject")
@CrossOrigin
public class EduSubjectController {
    @Autowired
    private EduSubjectService subjectService;

    @PostMapping("uploadSubject")
    @ApiOperation("上传课程分类excel表")
    public R addCourse(MultipartFile file){
        subjectService.addSubject(file,subjectService);
        return R.success();
    }

}

