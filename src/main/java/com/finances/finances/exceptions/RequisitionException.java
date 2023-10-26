package com.finances.finances.exceptions;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RequisitionException extends RuntimeException{
    
    private String message;
    private Integer id;

    public RequisitionException(String message, Integer id){
        super(message + id);
    }


}
