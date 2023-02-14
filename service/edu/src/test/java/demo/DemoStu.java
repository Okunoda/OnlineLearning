package demo;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

/**
 * @author Okunoda
 * @date 2023��02��13��16:07
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
