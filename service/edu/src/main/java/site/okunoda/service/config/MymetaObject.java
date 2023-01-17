package site.okunoda.service.config;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

/**
 * @author Okunoda
 * @date 2023年01月17日16:24
 */

@Component
public class MymetaObject implements MetaObjectHandler {
    @Override
    public void insertFill(MetaObject metaObject) {
        this.setFieldValByName("isDeleted",0,metaObject);

    }

    @Override
    public void updateFill(MetaObject metaObject) {

    }
}
