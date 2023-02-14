package demo;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.write.metadata.WriteSheet;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import site.okunoda.service.entity.Courage;
import site.okunoda.service.mapper.EduTeacherMapper;

import java.util.ArrayList;
import java.util.List;

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

    @Test
    public void getEnumName(){
        System.out.println(Courage.getName(2));
    }

    @Test
    public void excelTest(){

        String filePath = "D://write.xlsx";

        EasyExcel.write(filePath,DemoStu.class).sheet("学生列表").doWrite(generatorList());


    }

    private List<DemoStu> generatorList(){
        List<DemoStu> list = new ArrayList<>();
        for(int i = 0 ; i < 10 ; i++){
            list.add(new DemoStu(i,"asdf"+i));
        }
        return list;
    }
}
