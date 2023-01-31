package site.okunoda.service.entity;

import java.util.EnumSet;
import java.util.HashMap;

/**
 * @author Okunoda
 * @date 2023��01��30��16:46
 */
public enum Courage {
    Electronics_and_Information_Engineering(1, "��������Ϣ����ѧԺ"),
    Humanities(2, "����ѧԺ"),
    Mechanical_and_Electrical_Engineering(3, "����ѧԺ"),
    Life_Sciences(4, "������ѧѧԺ");
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
