package com.erste.acme.xlsconverter.domain.exception;

public class XlsConverterException extends RuntimeException {

    private static final long serialVersionUID = 5644107933265651736L;

    public XlsConverterException(String message, Throwable cause) {
        super(message, cause);
    }

    public XlsConverterException(String message) {
        super(message);
    }
}
