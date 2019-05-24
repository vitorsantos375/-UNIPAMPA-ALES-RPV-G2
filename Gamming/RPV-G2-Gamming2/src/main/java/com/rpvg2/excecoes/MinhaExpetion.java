/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rpvg2.excecoes;

/**
 *
 * @author Guilherm Bolfe
 */
public class MinhaExpetion extends Exception{
    private String msg;
    public MinhaExpetion(String msg){
      super(msg);
      this.msg = msg;
    }
    public String getMessage(){
      return msg;
    }
  }
