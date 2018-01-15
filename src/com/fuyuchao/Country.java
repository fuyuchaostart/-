package com.fuyuchao;

/**
 * @author fycstart 邮箱: fycstart@126.com
 * @version 2017年12月22
 *          天变不足畏，祖宗不足法，人言不足恤
 */
public enum Country {
    ONE(1, "燕"),
    TWO(2, "赵"),
    FOUR(5, "韩"),
    FIVE(4, "围"),
    THREE(3, "齐"),
    SIX(6, "魏");
    private int code;
    private String name;

    private Country(int code, String name) {
        this.code = code;
        this.name = name;
    }

    private int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static Country getCountry(Integer index) {
        for (Country country : values()) {
            if (country.getCode() == index) {
                return country;

            }
        }
        System.out.println("aaaaaaaaaaaaaaa");
        return null;
    }
}
