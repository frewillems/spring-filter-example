package com.example.dzopdemotestfilters.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class DetailResponse<T> {
    private T data;
}
