package com.example.dzopdemotestfilters.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class ResponsePaging {
    private Long count;
    private Long pageNumber;
    private Long pageSize;
    private Long pageTotal;
}
