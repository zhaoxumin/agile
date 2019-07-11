package com.agile.go.entity;

import java.io.Serializable;

/**
 * @ClassName PdfTransferWordEntity
 * @Description TODO
 * @Author xumin zhao
 * @Date 2019/7/8 14:24
 * @Version 1.0
 **/
public class PdfTransferWordEntity implements Serializable {

    private static final long serialVersionUID = -460160636524267757L;

    private String id;

    private String pdfUrl;

    private String wordUrl;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPdfUrl() {
        return pdfUrl;
    }

    public void setPdfUrl(String pdfUrl) {
        this.pdfUrl = pdfUrl;
    }

    public String getWordUrl() {
        return wordUrl;
    }

    public void setWordUrl(String wordUrl) {
        this.wordUrl = wordUrl;
    }
}
