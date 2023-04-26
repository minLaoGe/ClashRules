package cn.minfengyu.utils;

import freemarker.template.Configuration;
import freemarker.template.Template;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.Map;
import java.util.UUID;

@Component
@Slf4j
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class FreeMarkGenerater {
    private final Configuration freemarkerConfig;

    @Value("${freemarker.sava-path}")
    private String savePath="./";


    public String generateText(Map<String,Object> dataModel){
        try {
            Template template = freemarkerConfig.getTemplate("template.ftl");
            String content = FreeMarkerTemplateUtils.processTemplateIntoString(template, dataModel);
            String uuidName = UUID.randomUUID().toString().replace("-", "");
            try (FileWriter fileWriter = new FileWriter(Paths.get(savePath+uuidName+".yaml").toFile())) {
                fileWriter.write(content);
                fileWriter.flush();
            }
            return uuidName+".yaml";
        } catch (Exception e) {
            log.error("静态化文件出错:",e);
        }

        return null;
    }
}
