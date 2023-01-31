package site.okunoda.service.entity;

import java.util.EnumSet;
import java.util.HashMap;

/**
 * @author Okunoda
 * @date 2023年01月30日16:46
 */
public enum Courage {
    Electronics_and_Information_Engineering(1, "电子与信息工程学院"),
    Humanities(2, "人文学院"),
    Mechanical_and_Electrical_Engineering(3, "机电学院"),
    Life_Sciences(4, "生命科学学院");
    private Integer code;
    private String name;

    private Courage(Integer code, String name) {
        this.code = code;
        this.name = name;
    }

    private static HashMap<Integer, String> map = new HashMap<>();

    static {
        for (Courage t : EnumSet.allOf(Courage.class)) {
            map.put(t.code, t.name);
        }
    }


    public static String getName(int code) {
        try {
           return map.get(code);
        } catch (ArrayIndexOutOfBoundsException e) {
            throw new IllegalArgumentException("Unknown enum value" + code);
        }
    }

}
