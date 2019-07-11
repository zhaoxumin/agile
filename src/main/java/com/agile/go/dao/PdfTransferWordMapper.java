package com.agile.go.dao;

import com.agile.go.entity.PdfTransferWordEntity;
import com.agile.go.vo.TransferQueryVo;
import org.apache.ibatis.annotations.Mapper;

/**
 * @ClassName PdfTransferWordMapper
 * @Description TODO
 * @Author xumin zhao
 * @Date 2019/7/8 14:28
 * @Version 1.0
 **/
@Mapper
public interface PdfTransferWordMapper {

    void insertPdf(PdfTransferWordEntity pdfTransferWordEntity);

    void updateWord(PdfTransferWordEntity pdfTransferWordEntity);

    PdfTransferWordEntity findUrl(TransferQueryVo transferQueryVo);
}
