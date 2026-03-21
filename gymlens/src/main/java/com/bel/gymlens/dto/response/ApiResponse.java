package com.bel.gymlens.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ApiResponse<T> {
    private String status;
    private T payload;
    private String errors;

    public static <T> ApiResponse<T> success(T payload){
        ApiResponse<T> response = new ApiResponse<>();
//        response();
        return null;
    }

    public static <T> ApiResponse<T> error(String message) {
        return  null;
    }

}
