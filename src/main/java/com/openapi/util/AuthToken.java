package com.openapi.util;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class AuthToken {

    private String token;

    private String module;

    private long traderId;
    
    private String userName;


    public AuthToken( String module, long traderId, String userName) {
        this.module = module;
        this.traderId = traderId;
        this.userName = userName;
    }

}
