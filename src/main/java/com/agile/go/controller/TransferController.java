package com.agile.go.controller;

import com.agile.go.base.result.BaseConstant;
import com.agile.go.base.result.BaseResponse;
import com.agile.go.service.TransferService;
import com.agile.go.vo.TransferResultVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

/**
 * @ClassName TransferController
 * @Description PDF与WORD相互转换
 * @Author xumin zhao
 * @Date 2019/6/24 16:32
 * @Version 1.0
 **/
@RestController
@RequestMapping("/transfer")
public class TransferController {

    @Autowired
    private TransferService transferService;


    /**
     * 将pdf转成word文件
     *
     * @return
     * @throws Exception
     */
    @PostMapping("/upload/pdf")
    public BaseResponse<TransferResultVo> uploadPdf(@RequestParam(value = "file") MultipartFile file,
                                                    @RequestParam(value = "path", required = false) String path) {
        TransferResultVo transferResultVo = transferService.pdfTransferWord(file, path);
        return new BaseResponse<>(BaseConstant.HttpRequestMsg.successCode,
                BaseConstant.HttpRequestMsg.okMsg, BaseConstant.HttpRequestMsg.success, transferResultVo);
    }

    /**
     * 根据id获取pdf文件
     *
     * @return
     * @throws Exception
     */
    @GetMapping("/pdf")
    public String pdfUrl(@RequestParam(value = "id", required = false) String id) {
        String url = transferService.pdfUrl(id);
        return url;
    }

    /**
     * 根据id获取pdf文件
     *
     * @return
     * @throws Exception
     */
    @GetMapping("/word")
    public String wordUrl(@RequestParam(value = "id", required = false) String id) {
        String url = transferService.wordUrl(id);
        return url;
    }
}
