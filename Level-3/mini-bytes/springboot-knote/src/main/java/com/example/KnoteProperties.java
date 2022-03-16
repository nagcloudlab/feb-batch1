package com.example;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "knote")
public class KnoteProperties {
    @Value("${uploadDir:c:\\uploads\\}")
    private String uploadDir;
    public String getUploadDir() {
        return uploadDir;
    }
}
