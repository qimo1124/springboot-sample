package top.dingyy.springbootweek04.controller;


import com.sun.source.tree.BreakTree;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import top.dingyy.springbootweek04.common.Result;
import top.dingyy.springbootweek04.exception.BusinessException;
import top.dingyy.springbootweek04.utils.FileUploadUtil;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.springframework.util.ResourceUtils.FILE_URL_PREFIX;

@RestController
@RequestMapping("/api/upload")
@Slf4j
public class UploadController {

    private static final String FILE_URL_PREFIX = "http://localhost:8080/upload/";

    @PostMapping("/upload")
    public Result<String> upload(@RequestParam("file") MultipartFile file) {  // 改成 @RequestParam
        if (file == null || file.isEmpty()) {
            throw new BusinessException(400, "文件不能为空");
        }

        String fileName;
        try {
            fileName = FileUploadUtil.upload(file);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        String url = FILE_URL_PREFIX + fileName;
        return Result.success(url);
    }

    @PostMapping("/upload/batch")
    public Result<List<String>> uploadBatch(@RequestParam("files") MultipartFile[] files) {  // 改成 @RequestParam
        if (files == null || files.length == 0) {
            throw new BusinessException(400, "文件不能为空");
        }

        List<String> urls = new ArrayList<>();
        for (MultipartFile file : files) {
            if (file.isEmpty()) {
                continue;
            }
            try {
                String fileName = FileUploadUtil.upload(file);
                urls.add(FILE_URL_PREFIX + fileName);
            } catch (IOException e) {
                throw new RuntimeException("文件上传失败: " + file.getOriginalFilename(), e);
            }
        }
        return Result.success(urls);
    }
}
