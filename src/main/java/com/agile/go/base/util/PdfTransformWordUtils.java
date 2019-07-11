package com.agile.go.base.util;

import com.agile.go.refer.FilesEnum;
import com.spire.pdf.*;
import org.apache.pdfbox.cos.COSName;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageTree;
import org.apache.pdfbox.pdmodel.graphics.image.PDImageXObject;
import org.apache.pdfbox.text.PDFTextStripper;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @ClassName PdfTransformWordUtils
 * @Description pdf转成Word
 * @Author xumin zhao
 * @Date 2019/6/24 14:56
 * @Version 1.0
 **/
public class PdfTransformWordUtils {

    /**
     * 从pdf文档中读取所有的图片信息
     *
     * @return
     * @throws Exception
     */
    public static List<PDImageXObject> getImageListFromPDF(PDDocument document, Integer startPage) throws Exception {
        List<PDImageXObject> imageList = new ArrayList<PDImageXObject>();
        if (null != document) {
            PDPageTree pages = document.getPages();
            startPage = startPage == null ? 0 : startPage;
            int len = pages.getCount();
            System.out.println("页数 " + len);
            if (startPage < len) {
                for (int i = startPage; i < len; i++) {
                    PDPage page = pages.get(i);
                    if (page != null) {
                        if (page.getResources() != null) {
                            Iterable<COSName> objectNames = page.getResources().getXObjectNames();

                            for (COSName imageObjectName : objectNames) {
                                if (page.getResources().isImageXObject(imageObjectName)) {
                                    imageList.add((PDImageXObject) page.getResources().getXObject(imageObjectName));
                                }
                            }
                        } else {
                            System.out.println("当前页面没有图片 page.getResources() is null ");
                        }
                    } else {
                        System.out.println("page is null ");
                    }

                }
            }
        }
        return imageList;
    }

    /**
     * 读取图片文件流信息
     *
     * @param image
     * @return
     * @throws Exception
     */
    public static InputStream getImageInputStream(PDImageXObject image) throws Exception {
        if (null != image && null != image.getImage()) {
            BufferedImage bufferImage = image.getImage();
            ByteArrayOutputStream os = new ByteArrayOutputStream();
            ImageIO.write(bufferImage, image.getSuffix(), os);
            return new ByteArrayInputStream(os.toByteArray());
        }
        return null;
    }

    /**
     * 写入文件系统
     *
     * @param image
     * @throws Exception
     */
    public static void writeImageInputStream(PDImageXObject image) throws Exception {
        if (null != image && null != image.getImage()) {
            //粗略写入到文件系统
            Date date = new Date();
            String name = date.getTime() + "_image";
            File imgFile = new File("E:/images/" + name + "." + image.getSuffix());//写入的地址
            FileOutputStream fout = new FileOutputStream(imgFile);
            ByteArrayOutputStream os = new ByteArrayOutputStream();

            BufferedImage imageb = image.getImage();
            ImageIO.write(imageb, image.getSuffix(), os);
            InputStream is = new ByteArrayInputStream(os.toByteArray());
            int byteCount = 0;
            byte[] bytes = new byte[1024];
            while ((byteCount = is.read(bytes)) > 0) {
                fout.write(bytes, 0, byteCount);
            }
            fout.close();
            is.close();
        }
    }

    /**
     * 写入文件系统
     *
     * @param multipartFile
     * @throws Exception
     */
    public static File pdfTransferWordSpire(MultipartFile multipartFile, File filepdf, File fileWord, String wordFileName) {

        String fileName = multipartFile.getOriginalFilename();
        // 获取文件后缀
        String prefix = fileName.substring(fileName.lastIndexOf("."));
        if (StringUtils.isEmpty(prefix)) {
            return null;
        }
        // 用uuid作为文件名，防止生成的临时文件重复
        try {
            PdfDocument pdf = new PdfDocument();
            pdf.loadFromFile(filepdf.getPath());
            //添加新页面
//            PdfPageBase page = pdf.getPages().insert(0);
//            //创建TrueType字体对象
//            PdfTrueTypeFont font = new PdfTrueTypeFont(new Font("Arial Unicode MS", Font.PLAIN, 15), true);
//            //设置字体格式、大小
//            PdfRGBColor blue = new PdfRGBColor();
//            blue.setB((byte) 255);
//            PdfSolidBrush brush = new PdfSolidBrush(blue);
//            Rectangle2D.Float rctg = new Rectangle2D.Float();
//            rctg.setRect(200, 70, page.getCanvas().getClientSize().getWidth() / 2, 100);
//            //绘制文字
//            page.getCanvas().drawString("Word预览", font, brush, rctg);
            System.out.println(filepdf.getPath()+"--------------------");
            System.out.println(pdf.getPages().getCount()+"--------------------");
            System.out.println(fileWord.getPath()+"===================");
            //保存为Word格式
            pdf.saveToFile(wordFileName, FileFormat.DOCX);
            return fileWord;
        }  catch (Exception e) {
            e.printStackTrace();
        } finally {
            if(filepdf.exists()) {
                deleteFile(filepdf);
            }
        }
        return null;
    }

    public static File multChangeFile(MultipartFile multipartFile, File filePdf) {
        int n;
        try (InputStream in = multipartFile.getInputStream();
             OutputStream os = new FileOutputStream(filePdf)) {
            // 得到文件流。以文件流的方式输出到新文件
            // 可以使用byte[] ss = multipartFile.getBytes();代替while
            byte[] buffer = new byte[4096];
            while ((n = in.read(buffer, 0, 4096)) != -1) {
                os.write(buffer, 0, n);
            }
            // 读取文件第一行
            BufferedReader bufferedReader = new BufferedReader(new FileReader(filePdf));
            // 输出路径
            bufferedReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return filePdf;
    }


    /**
     * 写入文件系统
     *
     * @param multipartFile
     * @throws Exception
     */
    public static File pdfTransferWord(MultipartFile multipartFile) {
        String fileName = multipartFile.getOriginalFilename();
        // 获取文件后缀
        String prefix = fileName.substring(fileName.lastIndexOf("."));
        // 用uuid作为文件名，防止生成的临时文件重复
        final File filePdf;
        PDDocument doc = null;
        FileOutputStream fos = null;
        try {
            filePdf = File.createTempFile(UuidUtils.createUUID(), prefix);
            // MultipartFile to File
            multipartFile.transferTo(filePdf);
            doc = PDDocument.load(filePdf);
            int pagenumber = doc.getNumberOfPages();
            StringBuffer wordFileName = new StringBuffer();
            wordFileName.append(fileName.substring(0, fileName.lastIndexOf(".")))
                    .append(UuidUtils.createUUID())
                    .append(FilesEnum.DOC.getDesc());
            File fileWord = new File(wordFileName.toString());
            if (!fileWord.exists()) {
                fileWord.createNewFile();
            }
            fos = new FileOutputStream(fileWord);
            Writer writer = new OutputStreamWriter(fos, "UTF-8");
            PDFTextStripper stripper = new PDFTextStripper();
            // 排序
            stripper.setSortByPosition(true);
            // 设置转换的开始页
            stripper.setStartPage(1);
            // 设置转换的结束页
            stripper.setEndPage(pagenumber);
            stripper.writeText(doc, writer);
            System.out.println("pdf转换word成功！");
            return fileWord;
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fos.close();
                doc.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    /**
     * 删除
     *
     * @param files
     */
    public static void deleteFile(File... files) {
        for (File file : files) {
            if (file.exists()) {
                file.delete();
            }
        }
    }

}

