package site.okunoda.common_utils;




public enum StatusCode {
     SUCCESS("成功",2000),
     ERROR("失败",20001);

     private String name;
     private Integer code;
     StatusCode(String name,int code) {
         this.name = name;
         this.code = code;
     }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}
