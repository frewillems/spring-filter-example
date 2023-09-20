package com.example.dzopdemotestfilters.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class ListResponse<T> {
    private List<T> data;
    private ResponsePaging paging;
}
