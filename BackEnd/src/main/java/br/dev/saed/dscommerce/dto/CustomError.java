// YApi QuickType插件生成，具体参考文档:https://plugins.jetbrains.com/plugin/18847-yapi-quicktype/documentation

package br.dev.saed.dscommerce.dto;

import java.time.Instant;

public class CustomError {
    private Instant timestamp;
    private Integer status;
    private String error;
    private String path;

    public CustomError(Instant timestamp, Integer status, String error, String path) {
        this.timestamp = timestamp;
        this.status = status;
        this.error = error;
        this.path = path;
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
