package site.okunoda.service.entity.excel;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

/**
 * @author Okunoda
 * @date 2023年02月13日20:51
 */
@Data
public class SubjectData {
    @ExcelProperty(index = 0,value = "一级学科")
    private String oneSubjectName;
    @ExcelProperty(index = 1,value = "二级学科")
    private String twoSubjectName;
}
