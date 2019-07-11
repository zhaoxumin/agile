package com.agile.go.dto;

/**
 * @ClassName PdfTransferWordDto
 * @Description TODO
 * @Author xumin zhao
 * @Date 2019/7/8 14:27
 * @Version 1.0
 **/
public class PdfTransferWordDto {


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
