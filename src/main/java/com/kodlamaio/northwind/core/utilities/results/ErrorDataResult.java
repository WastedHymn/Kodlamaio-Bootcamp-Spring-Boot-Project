package com.kodlamaio.northwind.core.utilities.results;

import javax.xml.crypto.Data;

public class ErrorDataResult<T> extends DataResult {

    public ErrorDataResult(T data, String message) {
        super(data, true, message);
    }

    public ErrorDataResult(T data) {
        super(data, true);
    }

    public ErrorDataResult(String message) {
        super(null, true, message);
    }

    public ErrorDataResult() {
        super(null, true);
    }
}
