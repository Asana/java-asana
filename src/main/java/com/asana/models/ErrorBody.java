package com.asana.models;

import java.util.List;

public class ErrorBody
{
    public class Error
    {
        public String message;

        public String toString()
        {
            return message;
        }
    }

    public List<Error> errors;
}
