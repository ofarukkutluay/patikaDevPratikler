package com.company;

public class Calculate {
    public double topla(double a,double b){
        return a+b;
    }
    public double cikar(double a,double b){
        return a-b;
    }
    public double carp(double a,double b){
        return a*b;
    }
    public double bolme(double a,double b){
        return a/b;
    }
    public double usAlma(double a,int ussu){
        if(ussu==0){
            return a;
        }
        return a*usAlma(a,ussu-1);
    }
    public double karekokAlma(double a){
        double t;
        double sqrtroot=a/2;
        do
        {
            t=sqrtroot;
            sqrtroot=(t+(a/t))/2;
        }
        while((t-sqrtroot)!= 0);
        return sqrtroot;
    }

}
