package com.agile.go.service.impl;

import com.agile.go.base.util.*;
import com.agile.go.dao.PdfTransferWordMapper;
import com.agile.go.entity.PdfTransferWordEntity;
import com.agile.go.refer.FilesEnum;
import com.agile.go.service.AsyncService;
import com.agile.go.vo.TransferResultVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

/**
 * @ClassName AsyncServiceImpl
 * @Description TODO
 * @Author xumin zhao
 * @Date 2019/7/3 18:01
 * @Version 1.0
 **/
@Service
public class AsyncServiceImpl implements AsyncService {

    @Autowired
    private PdfTransferWordMapper pdfTransferWordMapper;

    @Override
    public TransferResultVo pdfTransferWordAndUpload(MultipartFile file, File filepdf, String path, PdfTransferWordEntity entity) {
        TransferResultVo transferResultVo = new TransferResultVo();
        try {
            String wordFileName =UuidUtils.createUUID();
            File fileWord =new File(wordFileName+FilesEnum.DOC.getDesc());
            fileWord = PdfTransformWordUtils.pdfTransferWordSpire(file, filepdf, fileWord, wordFileName+FilesEnum.DOC.getDesc());
            InputStream is = new FileInputStream(fileWord);
            String fileName = file.getOriginalFilename().substring(0, file.getOriginalFilename().lastIndexOf(".pdf"));
            String url = UploadUtils.uploadDoc(FilesEnum.DOC.getDesc(), is, fileName);
            transferResultVo.setUrl(url);
            entity.setWordUrl(url);
            pdfTransferWordMapper.updateWord(entity);
            if(fileWord.exists()) {
                PdfTransformWordUtils.deleteFile(fileWord);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return transferResultVo;
    }
}
