package com.example.demo;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
class Carro {

    private @Id @GeneratedValue Long id;
    private String marca;
    private String modelo;
    private String cor;
    private int ano;

    Carro() {
    }

    Carro(String marca, String modelo , String cor, int ano) {

        this.marca = marca;
        this.modelo = modelo;
        this.cor = cor;
        this.ano = ano;
    }

    public Long getId() {
        return this.id;
    }

    public String getMarca() {
        return this.marca;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }


    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    @Override
    public boolean equals(Object o) {

        if (this == o)
            return true;
        if (!(o instanceof Carro))
            return false;
        Carro carro = (Carro) o;
        return Objects.equals(this.id, carro.id) && Objects.equals(this.marca, carro.marca)
                && Objects.equals(this.modelo, carro.modelo) && Objects.equals(this.cor, carro.cor) && Objects.equals(this.ano, carro.ano);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id, this.marca, this.modelo, this.cor , this.ano);
    }

    @Override
    public String toString() {
        return "Carro {" + "id=" + this.id + ", Marca='" + this.marca + '\'' + ", Modelo='" + this.modelo + '\'' +  ", Cor='" + this.cor + '\'' +  '}';
    }
}