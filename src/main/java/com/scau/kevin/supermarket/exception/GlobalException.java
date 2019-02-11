package com.scau.kevin.supermarket.exception;

import com.scau.kevin.supermarket.result.CodeMessage;

/**
 * @Author: kevin
 * @Date: 2018/12/29 15:39
 * @Version 1.0
 */
public class GlobalException extends RuntimeException{
    private static long serialVersionUID = 1L;

    private CodeMessage codeMessage;
    public GlobalException(CodeMessage codeMessage){
        super(codeMessage.toString());
        this.codeMessage = codeMessage;
    }

    public CodeMessage getCodeMessage() {
        return codeMessage;
    }

    public void setCodeMessage(CodeMessage codeMessage) {
        this.codeMessage = codeMessage;
    }
}
