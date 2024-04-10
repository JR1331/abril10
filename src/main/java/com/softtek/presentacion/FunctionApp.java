package com.softtek.presentacion;

import com.softtek.modelo.Stats;

import java.util.ArrayList;
import java.util.function.Function;

public class FunctionApp {
    private void m1Apply() {
        Function<ArrayList<Integer>,ArrayList<Integer>> fx = x -> {
            ArrayList<Integer> resultado = new ArrayList<>();
            for (int i = 0; i < x.size(); i++) {
                if(x.get(i)%2==0){
                    resultado.add(x.get(i));
                }
            }
            return resultado;
        };
        ArrayList<Integer> numeros = new ArrayList<>();
        numeros.add(1);
        numeros.add(2);
        numeros.add(3);
        numeros.add(4);
        numeros.add(5);
        ArrayList<Integer> rpta = fx.apply(numeros);
        System.out.println(rpta);
    }

    public void m2Apply(){
        Function<ArrayList<Integer>, Stats> fx = x ->{
            int min=0;
            int max=0;
            double media=0;
            for (int i = 0; i < x.size(); i++) {
                if(i==0||x.get(i)<min){
                    min=x.get(i);
                }
                if(i==0||x.get(i)>max){
                    max=x.get(i);
                }
                media+=x.get(i);
            }
            return new Stats(min,max,media/x.size());
        };
        ArrayList<Integer> numeros = new ArrayList<>();
        numeros.add(1);
        numeros.add(2);
        numeros.add(3);
        numeros.add(4);
        numeros.add(5);
        Stats rpta = fx.apply(numeros);
        System.out.println(rpta);
    }

    public void comprobarContraseña(){
        Function<String, Boolean> lg = x->x.length()>8;
        Function<String, Boolean> mayus = x->x.chars().anyMatch(Character::isUpperCase);
        Function<String, Boolean> minus = x->x.chars().anyMatch(Character::isLowerCase);
        Function<String, Boolean> num = x->x.chars().anyMatch(Character::isDigit);
        Function<String, Boolean> esp = x->x.chars().anyMatch(c -> "!@#$%^&*()_-+=|<>?{}[]".indexOf(c) != -1);
        String contra=("Contraseña1.");
        boolean rpta = lg.apply(contra)&& mayus.apply(contra)&& minus.apply(contra)&& num.apply(contra)&& esp.apply(contra);
        System.out.println(rpta);
    }

    public static void main(String[] args) {
        FunctionApp fa = new FunctionApp();
        fa.m1Apply();
        fa.m2Apply();
    }
}
