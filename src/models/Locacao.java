package models;

import java.time.LocalDate;
import java.util.ArrayList;
import java.time.Period;

public class Locacao {
    private int codigoLocacao;
    private int codigoCliente;
    private int codigoFuncionario;

    private Veiculo veiculo;
    private LocalDate dataLocacao;
    private LocalDate dataDevolucao;
    private float valorTotal;
    private String tipoPagamento;
    private ArrayList<Seguro> segurosContratados;
    private boolean finalizada;

    public Locacao(int codigoLocacao, int codigoCliente, int codigoFuncionario, Veiculo veiculo, LocalDate dataLocacao, LocalDate dataDevolucao, float valorTotal, String tipoPagamento) {
        this.codigoLocacao = codigoLocacao;
        this.codigoCliente = codigoCliente;
        this.codigoFuncionario = codigoFuncionario;
        this.veiculo = veiculo;
        this.dataLocacao = dataLocacao;
        this.dataDevolucao = dataDevolucao;
        this.tipoPagamento = tipoPagamento;
        this.segurosContratados = new ArrayList<Seguro>();
        this.finalizada = false;
    }

    public int getCodigoLocacao() {
        return codigoLocacao;
    }

    public void setCodigoLocacao(int codigoLocacao) {
        this.codigoLocacao = codigoLocacao;
    }

    public int getCodigoCliente() {
        return codigoCliente;
    }

    public void setCodigoCliente(int codigoCliente) {
        this.codigoCliente = codigoCliente;
    }

    public int getCodigoFuncionario() {
        return codigoFuncionario;
    }

    public void setCodigoFuncionario(int codigoFuncionario) {
        this.codigoFuncionario = codigoFuncionario;
    }

    public LocalDate getDataLocacao() {
        return dataLocacao;
    }

    public void setDataLocacao(LocalDate dataLocacao) {
        this.dataLocacao = dataLocacao;
    }

    public LocalDate getDataDevolucao() {
        return dataDevolucao;
    }

    public void setDataDevolucao(LocalDate dataDevolucao) {
        this.dataDevolucao = dataDevolucao;
    }

    public float getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(float valorTotal) {
        this.valorTotal = valorTotal;
    }

    public String getTipoPagamento() {
        return tipoPagamento;
    }

    public void setTipoPagamento(String tipoPagamento) {
        this.tipoPagamento = tipoPagamento;
    }

    public ArrayList<Seguro> getSegurosContratados() {
        return segurosContratados;
    }

    public void setSegurosContratados(ArrayList<Seguro> segurosContratados) {
        this.segurosContratados = segurosContratados;
    }

    public boolean isFinalizada() {
        return finalizada;
    }

    public void setFinalizada(boolean finalizada) {
        this.finalizada = finalizada;
    }

    public float calcularValorTotal(){
        long diferencaEmDias = Math.abs(this.dataLocacao.toEpochDay() - this.dataDevolucao.toEpochDay());
        float valorSeguros = 0;
        for (Seguro seguro : this.segurosContratados){
            valorSeguros = valorSeguros + seguro.getValor();
        }
        float valorFinal = diferencaEmDias * veiculo.getValorDiaria() + valorSeguros;
        this.valorTotal = valorFinal;
        return valorFinal;
    }

    public boolean possuiSeguro(){
        for (Seguro seguro : this.segurosContratados){
            // terminar depois
        }
    }
}
