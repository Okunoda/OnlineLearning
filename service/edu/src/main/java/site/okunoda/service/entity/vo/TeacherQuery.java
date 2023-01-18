package site.okunoda.service.entity.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author Okunoda
 * @date 2023年01月18日20:14
 */
@Data
public class TeacherQuery {
    private static final long serialVersionUID = 1L;
    @ApiModelProperty(value = "教师名称,模糊查询")
    private String name;

    @ApiModelProperty(value = "头衔 1教授 2副教授 3讲师")
    private Integer level;

    @ApiModelProperty(value = "查询开始时间", example = "yyyy-MM-dd HH:mm:ss")
    private String begin;//注意，这里使用的是String类型，前端传过来的数据无需进行类型转换

    @ApiModelProperty(value = "查询结束时间", example = "yyyy-MM-dd HH:mm:ss")
    private String end;
}
