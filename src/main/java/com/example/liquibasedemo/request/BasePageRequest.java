package com.example.liquibasedemo.request;

import lombok.Data;

@Data
public class BasePageRequest {
    private int pageNum = 1;
    private int pageSize = 10;
}
