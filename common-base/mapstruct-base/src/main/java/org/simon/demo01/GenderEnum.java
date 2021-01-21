package org.simon.demo01;

/**
 * 你搞忘写注释了
 *
 * @author zhang_zhang
 * @date 2020-11-11
 * @since 1.0.0
 */
public enum GenderEnum {
    Male("1", "男"),
    Female("0", "女");

    private String code;
    private String name;

    public String getCode() {
        return this.code;
    }

    public String getName() {
        return this.name;
    }

    GenderEnum(String code, String name) {
        this.code = code;
        this.name = name;
    }
}