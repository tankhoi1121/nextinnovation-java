/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.knt.nextinnovation.controller;

/**
 *
 * @author bruce_
 */
public class ResponseTransfer {

    /**
     * @return the text
     */
    public String getText() {
        return text;
    }

    /**
     * @param text the text to set
     */
    public void setText(String text) {
        this.text = text;
    }
    
    private String text;
    
    public ResponseTransfer(String x) {
        this.setText(x);
    }
}
