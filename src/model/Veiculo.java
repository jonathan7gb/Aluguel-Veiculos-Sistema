package model;
import java.util.*;

public class Veiculo {

    Scanner scStr = new Scanner(System.in);
    Scanner scNum = new Scanner(System.in);

    private String tipoVeiculo;
    private String modeloVeiculo;
    private String marcaVeiculo;
    private String placaVeiculo;
    private int anoFabricacaoVeiculo;
    
    public Veiculo(String tipo, String modelo, String marca, String placa, int ano_fabricacao){
        this.tipoVeiculo = tipo;
        this.modeloVeiculo = modelo;
        this.marcaVeiculo = marca;
        this.placaVeiculo = placa;
        this.anoFabricacaoVeiculo = ano_fabricacao;
    }
    
    public String getTipoVeiculo(){
        return this.tipoVeiculo;
    }
    public String getModeloVeiculo(){
        return this.modeloVeiculo;
    }
    public String getMarcaVeiculo(){
        return this.marcaVeiculo;
    }
    public String getPlacaVeiculo(){
        return this.placaVeiculo;
    }
    public int getAnoFabricacaoVeiculo(){
        return this.anoFabricacaoVeiculo;
    }


        
  }