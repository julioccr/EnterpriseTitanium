/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.global.general;

import global.general.VarSystem;
import java.util.Date;

/**
 *
 * @author JCortorreal
 */
public abstract class  GlobalMetods extends VarSystem{
    
    
    
    public java.util.Date fecha_system (){
        DateNative = new Date();
         return  DateNative;
    }
    
    
    
}
