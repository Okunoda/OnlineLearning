package demo;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import site.okunoda.service.mapper.EduTeacherMapper;

/**
 * @author Okunoda
 * @date 2023年01月17日16:12
 */
public class Demo {


    @Autowired
    EduTeacherMapper eduTeacherMapper;

    @Test
    public void getList(){
//        eduTeacherMapper.deleteById()
    }

}
