package com.lxl.store.exception;

/**
 * @author LiXianLei
 * @time 2022/01/15 10:48
 */
public class FileOverSizedException extends FileUploadException{
    public FileOverSizedException() {
        super();
    }

    public FileOverSizedException(String message) {
        super(message);
    }

    public FileOverSizedException(String message, Throwable cause) {
        super(message, cause);
    }

    public FileOverSizedException(Throwable cause) {
        super(cause);
    }

    protected FileOverSizedException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
