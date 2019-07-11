package com.agile.go.service.impl;

import com.agile.go.base.util.*;
import com.agile.go.dao.PdfTransferWordMapper;
import com.agile.go.entity.PdfTransferWordEntity;
import com.agile.go.refer.FilesEnum;
import com.agile.go.service.AsyncService;
import com.agile.go.service.TransferService;
import com.agile.go.vo.TransferQueryVo;
import com.agile.go.vo.TransferResultVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;


import java.io.File;
import java.io.InputStream;

/**
 * @ClassName TransferServiceImpl
 * @Description TODO
 * @Author xumin zhao
 * @Date 2019/6/24 16:33
 * @Version 1.0
 **/
@Service
public class TransferServiceImpl implements TransferService {

    @Autowired
    private AsyncService asyncService;
    @Autowired
    private PdfTransferWordMapper pdfTransferWordMapper;

    @Override
    public TransferResultVo pdfTransferWord(MultipartFile file, String path) {
        TransferResultVo transferResultVo = new TransferResultVo();
        try {
            MultipartFile pdfFile=file;
            String fileName = file.getOriginalFilename().substring(0, file.getOriginalFilename().lastIndexOf(".pdf"));
            InputStream is = file.getInputStream();
            String url = UploadUtils.uploadPdf(FilesEnum.PDF.getDesc(), is, fileName);
            transferResultVo.setId(UuidUtils.createUUID());
            PdfTransferWordEntity entity = new PdfTransferWordEntity();
            entity.setId(transferResultVo.getId());
            entity.setPdfUrl(url);
            pdfTransferWordMapper.insertPdf(entity);
            File filePdf =File.createTempFile(UuidUtils.createUUID(),FilesEnum.PDF.getDesc());
            pdfFile.transferTo(filePdf);
            asyncService.pdfTransferWordAndUpload(file, filePdf, path, entity);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return transferResultVo;
    }

    @Override
    public String downLoadWord(String id) {
        TransferQueryVo transferQueryVo = new TransferQueryVo();
        transferQueryVo.setId(id);
        PdfTransferWordEntity entity = pdfTransferWordMapper.findUrl(transferQueryVo);
        if (entity != null && !StringUtils.isEmpty(entity.getWordUrl())) {
            return entity.getWordUrl();
        }
        return null;
    }

    @Override
    public String wordUrl(String id) {
        TransferQueryVo transferQueryVo = new TransferQueryVo();
        transferQueryVo.setId(id);
        PdfTransferWordEntity entity = pdfTransferWordMapper.findUrl(transferQueryVo);
        if (entity != null && !StringUtils.isEmpty(entity.getWordUrl())) {
            return entity.getWordUrl();
        }
        return null;
    }

    @Override
    public String pdfUrl(String id) {
        TransferQueryVo queryVo = new TransferQueryVo();
        queryVo.setId(id);
        PdfTransferWordEntity entity = pdfTransferWordMapper.findUrl(queryVo);
        if (entity != null && !StringUtils.isEmpty(entity.getPdfUrl())) {
            return entity.getPdfUrl();
        }
        return null;


    }
}
