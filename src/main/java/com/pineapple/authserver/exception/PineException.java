package com.pineapple.authserver.exception;

import com.pineapple.authserver.constant.MemberErrorCode;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PineException extends RuntimeException{

    private MemberErrorCode memberErrorCode;
}
