package com.agile.go.refer;

/**
 * @ClassName FilesEnum
 * @Description TODO
 * @Author xumin zhao
 * @Date 2019/6/24 18:03
 * @Version 1.0
 **/
public enum FilesEnum {

    DOC(0, ".doc"),
    PDF(1, ".pdf"),
    JPEG(2, ".jpeg"),
    GIF(3, ".gif"),
    BMP(4, ".bmp");


    // 业务码
    private Integer code;
    // 描述
    private String  desc;

    FilesEnum(Integer code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public Integer getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }
}
