package com.example.demo.controller;

import jdk.nashorn.internal.runtime.logging.Logger;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;

@RestController
public class HelloWorld {
    @GetMapping("/hello")
    public String Hello() {
        System.out.println("hello world!!");
        return "<h1>hello world!!<h1>";
    }

    public static void main(String[] args) {
        String str = "+1234+213";
        int i1 = str.indexOf("-");
        int i2 = str.indexOf("+");
        long sum = 0;
        if((i1!=str.length()-1||i1!=0)&&i1>0){
            String str1 = str.substring(i1 + 1, str.length() - 1);
            long num1 = num(str1);
            String str2 = str.substring(0,i1);
            long num2 = num(str2);
            sum = num2-num1;
        }
        if((i2!=str.length() - 1 || i2!=0)&&i2>=0){
            String str1 = str.substring(i2 + 1, str.length());
            for(int i = 0;i<str1.length();i++){
                if(str1.indexOf("+")!=-1){
                    int a = str1.indexOf("+");
                    String substring = str1.substring(0, a);
                    long num1 = num(substring);
                    String str2 = str1.substring(a+1,str1.length());
                    long num2 = num(str2);
                    sum = num1+num2;
                }else{
                    sum = num(str1);
                    break;
                }
            }

        }
        if (i1 == 0) {
            str = str.substring(i1 + 1);
            sum = num(str);
            sum = 0L+Integer.parseInt("-"+sum);
        }
        System.out.print(sum);
    }
    public static long num(String str){
        long num = 0;
        if (!StringUtils.isEmpty(str) && str.matches("[0-9]+")) {
            char[] chars = str.toCharArray();
            for (int i = 0; i < chars.length; i++) {
                int a = chars[i] - '0';
                double pow = Math.pow(10, chars.length - i - 1);
                    num += a * pow;
                if (num > Integer.MAX_VALUE || num < Integer.MIN_VALUE) {
                    num = 0;
                }
            }
        }
        return num;
    }
}