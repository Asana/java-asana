package com.asana.models;

public class ResultBody<T>
{
    public T data;

    public ResultBody(T data) {
        this.data = data;
    }
}
