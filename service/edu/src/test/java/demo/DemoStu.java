package demo;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

/**
 * @author Okunoda
 * @date 2023Äê02ÔÂ13ÈÕ16:07
 */
@Data
public class DemoStu {
    @ExcelProperty("123")
   private String name;

    @ExcelProperty("333")
    private int age;

    public DemoStu(int age, String name) {
        this.age = age;
        this.name = name;
    }
}
