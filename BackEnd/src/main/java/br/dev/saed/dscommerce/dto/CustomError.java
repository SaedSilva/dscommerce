// YApi QuickType插件生成，具体参考文档:https://plugins.jetbrains.com/plugin/18847-yapi-quicktype/documentation

package br.dev.saed.dscommerce.dto;

import java.time.Instant;

public class CustomError {
    private String path;
    private String error;
    private Instant timestamp;
    private Integer status;

    public CustomError(String path, String error, Instant timestamp, Integer status) {
        this.path = path;
        this.error = error;
        this.timestamp = timestamp;
        this.status = status;
    }

    public String getPath() {
        return path;
    }

    public String getError() {
        return error;
    }

    public Instant getTimestamp() {
        return timestamp;
    }

    public Integer getStatus() {
        return status;
    }
}
