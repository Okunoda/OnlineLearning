package site.okunoda.service.listener;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import site.okunoda.service.entity.EduSubject;
import site.okunoda.service.entity.excel.SubjectData;
import site.okunoda.service.service.EduSubjectService;
import site.okunoda.service_base.exceptionHandler.OLException;

import java.util.Map;

/**
 * @author Okunoda
 * @date 2023年02月13日20:56
 */
public class SubjectListener extends AnalysisEventListener<SubjectData> {

    //因为SubjectListener不能交给Spring进行管理,所以不能使用类似@Autowrite等注解
    //因为无法使用mapper等方式进行数据库操作，可以使用jdbc方式，但较为麻烦，不如直接使用有参构造将需要的对象传入

    private EduSubjectService subjectService;
    public SubjectListener(){
    }

    //读取表头中的内容
    @Override
    public void invokeHeadMap(Map<Integer, String> headMap, AnalysisContext context) {
        super.invokeHeadMap(headMap, context);
    }



    /*      TODO————明早起来看一下假如excel表中的第一行的标题不一样，会是个什么情况*/



    public SubjectListener(EduSubjectService eduSubjectService){
        this.subjectService = eduSubjectService;
    }

    //读取excel的内容，按行读取
    @Override
    public void invoke(SubjectData subjectData, AnalysisContext analysisContext) {
        if(subjectData==null){
             throw new OLException(200001,"文件数据为空");
        }
        EduSubject subjectOne = this.exitOneSubject(subjectData.getOneSubjectName(), subjectService);

        if(subjectOne==null){
            subjectOne = new EduSubject();
            subjectOne.setParentId("0");
            subjectOne.setTitle(subjectData.getOneSubjectName());
            subjectService.save(subjectOne);
        }

        String pid = subjectOne.getId();

        EduSubject subjectTwo = this.exitTwoSubject(subjectData.getTwoSubjectName(), subjectService, pid);
        if(subjectTwo == null){
            subjectTwo = new EduSubject();
            subjectTwo.setParentId(pid);
            subjectTwo.setTitle(subjectData.getTwoSubjectName());
            subjectService.save(subjectTwo);
        }

    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext analysisContext) {

    }

    //检查一级学科是否重复
    private EduSubject exitOneSubject(String subjectName, EduSubjectService service){
        QueryWrapper<EduSubject> wrapper = new QueryWrapper<>();
        wrapper.eq("parent_id",0);
        wrapper.eq("title",subjectName);
        EduSubject one = service.getOne(wrapper);
        return one;
    }

    //检查二级学科标题是否重复
    private EduSubject exitTwoSubject(String subjectName,EduSubjectService service,String pid){
        QueryWrapper<EduSubject> wrapper = new QueryWrapper<>();
        wrapper.eq("parent_id",pid);
        wrapper.eq("title",subjectName);
        EduSubject one = service.getOne(wrapper);
        return one;
    }
}
