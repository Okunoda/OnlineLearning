package site.okunoda.service.controller;





import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.util.StringUtils;
import site.okunoda.common_utils.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import site.okunoda.service.entity.EduTeacher;
import site.okunoda.service.entity.vo.TeacherQuery;
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

    //分页查询
    @ApiOperation(value = "分页查询")
    @GetMapping({"pageTeacher/{current}/{limit}","pageTeacher/{current}"})
    public R pageListTeacher(@ApiParam(name = "current",value = "当前页",required = true)@PathVariable Integer current,
                             @ApiParam(name = "limit",value = "每页显示多少条",required = false)@PathVariable Integer limit){
        Page<EduTeacher> eduTeacherPage;

        if(limit==null){
            eduTeacherPage = new Page<>(current,3);
        }else
            eduTeacherPage = new Page<>(current,limit);

        teacherService.page(eduTeacherPage,null);
        long total = eduTeacherPage.getTotal();//总条件数
        List<EduTeacher> records = eduTeacherPage.getRecords();//当前页的数据list


        return R.success().data("total",total).data("rows",records);
    }

    //条件查询带分页
    @ApiOperation(value="条件查询")
    @PostMapping("pageTeacherCondition/{current}/{limit}") //使用到@RequestBody注解就需要使用Post，如果使用Get则无法获取
    public R pageListCondition(@ApiParam(name = "current",value = "当前页",required = true)@PathVariable Integer current,
                               @ApiParam(name = "limit",value="每页多少数据",required = true)@PathVariable Integer limit,
                               @RequestBody(required = false) TeacherQuery teacherQuery){
        Page<EduTeacher> page = new Page<>(current, limit);
        QueryWrapper<EduTeacher> wrapper = new QueryWrapper<>();

        String name = teacherQuery.getName();
        Integer level = teacherQuery.getLevel();
        String begin = teacherQuery.getBegin();
        String end = teacherQuery.getEnd();


        //注意，wrapper中的参数是 字段名 ，并非实体类的属性名。注意与使用自动填充时this.setFieldValByName()方法中的参数是实体类的属性名相区分
        if(!StringUtils.isEmpty(teacherQuery.getName())){
            wrapper.like("name",name);
        }
        if(level!=0){
            wrapper.eq("level",level);
        }
        if(!StringUtils.isEmpty(begin)){
            wrapper.ge("gmt_create",begin);
        }
        if(!StringUtils.isEmpty(end)){
            wrapper.le("gmt_modified",end);
        }

        teacherService.page(page,wrapper);

        return R.success().data("total",page.getTotal()).data("rows",page.getRecords());
    }

    @ApiOperation(value="添加教师")
    @PostMapping("addTeacher")
    public R addTeacher(@RequestBody EduTeacher eduTeacher){
        boolean save = teacherService.save(eduTeacher);
        if(save)
            return R.success();
        else
            return R.error();
    }

    @ApiOperation(value = "根据id查询讲师")
    @GetMapping("getTeacher/{id}")
    public R getTeacherById(@PathVariable Integer id){
        EduTeacher teacher = teacherService.getById(id);
        return R.success().data("item",teacher);
    }

    @ApiOperation(value = "根据id修改讲师信息")
    @PostMapping("modify")
    public R modifyTeacher(@RequestBody EduTeacher eduTeacher){
        EduTeacher origin = teacherService.getById(eduTeacher.getId());
        //发现这里如果允许用户自己修改isDeleted字段会出大问题，课程中未提及，姑且这样打补丁
        Integer isDeleted = origin.getIsDeleted();
        eduTeacher.setIsDeleted(isDeleted);
        boolean flag = teacherService.updateById(eduTeacher);
        if(flag)
            return R.success();
        else
            return R.error();
    }





}

