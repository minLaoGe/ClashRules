package cn.minfengyu.utils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FileUtils{

    public static String fileGet(String path, boolean scopeLimit) {
        String content = "";

        if (scopeLimit && !ProxyUtils.isInScope(path)) {
            return "";
        }

        try {
            byte[] fileContent = Files.readAllBytes(Paths.get(path));
            content = new String(fileContent);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return content;
    }
}
