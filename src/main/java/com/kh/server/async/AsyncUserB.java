package com.kh.server.async;

import lombok.Data;

@Data
public class AsyncUserB {

    private String nickName;
    private String birth;

    public AsyncUserB(String nickName, String birth){
        this.nickName = nickName;
        this.birth = birth;
    }
}
