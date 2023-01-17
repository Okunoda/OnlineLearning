package site.okunoda.service.controller;




import site.okunoda.common_utils.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import site.okunoda.service.entity.EduTeacher;
import site.okunoda.service.service.EduTeacherService;

import java.util.List;

/**
 * <p>
 * 讲师 前端控制器
 * </p>
 *
 * @author testjava
 * @since 2023-01-17
 */
@RestController
@RequestMapping("/service/edu-teacher")
@Api("讲师管理")
public class EduTeacherController {

    @Autowired
    private EduTeacherService teacherService;

    //1. 查询讲师表所有数据
    @GetMapping("findAll") //这里加不加 “ / ”都行
    @ApiOperation(value = "返回所有讲师")
    public R findAllTeacher(){
        List<EduTeacher> list = teacherService.list(null);
        return R.success().data("items",list);
    }


    //逻辑删除
    @DeleteMapping("{id}") //通过路径传递id值，需要通过@PathVariable
    @ApiOperation(value = "逻辑删除讲师")
    public R removeTeacher(@ApiParam (name = "id", value = "讲师ID", required = true) @PathVariable String id){
        boolean flag = teacherService.removeById(id);
        if(flag){
            return R.success();
        }else
            return R.error();
    }
}

