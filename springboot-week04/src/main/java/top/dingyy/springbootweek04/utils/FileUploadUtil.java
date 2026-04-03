package top.dingyy.springbootweek04.utils;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.multipart.MultipartFile;
import top.dingyy.springbootweek04.exception.BusinessException;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Slf4j
public class FileUploadUtil {

    // 允许上传的文件类型
    private static final Set<String> ALLOWED_EXTENSIONS = new HashSet<>(Arrays.asList(
            ".jpg", ".jpeg", ".png", ".gif", ".bmp", ".webp",
            ".pdf", ".doc", ".docx", ".xls", ".xlsx", ".txt", ".json", ".xml"
    ));

    // 上传目录：项目根目录下的 uploads 文件夹
    private static final String UPLOAD_DIR = System.getProperty("user.dir") + File.separator + "uploads" + File.separator;

    // 静态初始化块，确保上传目录存在
    static {
        try {
            File dir = new File(UPLOAD_DIR);
            if (!dir.exists()) {
                boolean created = dir.mkdirs();
                if (created) {
                    log.info("创建上传目录成功: {}", UPLOAD_DIR);
                } else {
                    log.error("创建上传目录失败: {}", UPLOAD_DIR);
                    throw new RuntimeException("创建上传目录失败: " + UPLOAD_DIR);
                }
            }
            log.info("上传目录已就绪: {}", UPLOAD_DIR);
        } catch (Exception e) {
            log.error("初始化上传目录失败", e);
            throw new RuntimeException("初始化上传目录失败", e);
        }
    }

    /**
     * 上传文件
     * @param file 要上传的文件
     * @return 生成的文件名
     * @throws IOException IO异常
     */
    public static String upload(MultipartFile file) throws IOException {
        // 验证文件是否为空
        if (file == null || file.isEmpty()) {
            throw new BusinessException(400, "文件不能为空");
        }

        // 获取原始文件名
        String originalFilename = file.getOriginalFilename();
        if (originalFilename == null || originalFilename.isEmpty()) {
            throw new BusinessException(400, "文件名不能为空");
        }

        // 获取文件扩展名
        int lastDotIndex = originalFilename.lastIndexOf(".");
        if (lastDotIndex == -1) {
            throw new BusinessException(400, "文件缺少扩展名");
        }

        String suffix = originalFilename.substring(lastDotIndex).toLowerCase();

        // 验证文件类型
        if (!ALLOWED_EXTENSIONS.contains(suffix)) {
            throw new BusinessException(400, "不支持的文件类型：" + suffix + "，支持的格式：" + ALLOWED_EXTENSIONS);
        }

        // 生成唯一文件名
        String fileName = UUID.randomUUID().toString() + suffix;

        // 保存文件
        File dest = new File(UPLOAD_DIR + fileName);
        file.transferTo(dest);

        log.info("文件上传成功: {} -> {}", originalFilename, fileName);
        return fileName;
    }
}