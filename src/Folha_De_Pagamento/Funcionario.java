/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Folha_De_Pagamento;

import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author Crist
 */
public class Funcionario {
    public enum tipoContrato{
        tcEfetivo, tcHorista;
    }
    
    private String nome;
    private Date dataNascimento;
    private Date dataAdmissao;
    private float valorSalarioHora;
    private tipoContrato tpContrato; 
    private Integer numeroFilhosMenores;
    private float salarioBruto;
    private float salarioLiquido;

    public Funcionario(String nome, Date dataNascimento) {
        this.nome = nome;
        this.dataNascimento = dataNascimento;
    }
    
    public void contratar(tipoContrato tpContrato, float salarioHora, 
            int numeroFilhos, Date dataAdmissao){
        this.tpContrato = tpContrato;
        this.valorSalarioHora = salarioHora;
        this.numeroFilhosMenores = numeroFilhos;
        this.dataAdmissao = dataAdmissao;
    }

    public void setDataAdmissao(Date dataAdmissao) {
        this.dataAdmissao = dataAdmissao;
    }

    public void setValorSalario(float valorSalario) {
        this.valorSalarioHora = valorSalario;
    }

    public void setTpContrato(tipoContrato tpContrato) {
        this.tpContrato = tpContrato;
    }

    public void setNumeroFilhosMenores(Integer numeroFilhosMenores) {
        this.numeroFilhosMenores = numeroFilhosMenores;
    }

    public String getNome() {
        return nome;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public Date getDataAdmissao() {
        return dataAdmissao;
    }

    public float getValorSalario() {
        return valorSalarioHora;
    }

    public tipoContrato getTpContrato() {
        return tpContrato;
    }

    public Integer getNumeroFilhosMenores() {
        return numeroFilhosMenores;
    }
    
    public float calcularSalarioBruto(float numeroHoras){
        return numeroHoras * valorSalarioHora;
    }
    
    public float calcularSalarioLiquido(float numeroHoras){
        this.salarioBruto = this.calcularSalarioBruto(numeroHoras);
        
        this.salarioLiquido = salarioBruto - calcularDescontoInss() - 
                calcularImpostoRenda() + calcularValoresAdicionais();;
        return salarioLiquido;
    }
    
    public String mostrarFolhaPagamento(){
        String resultado;
        
        resultado =  "FOLHA DE PAGAMENTO: " + this.nome + "\n" +
        "O salário bruto é: " + this.salarioBruto + "\n"+
        "O desconto de INSS é: " + this.calcularDescontoInss() + "\n"+
        "O desconto de IR é: " + this.calcularImpostoRenda() + "\n"+
        "Os adicionais são: " + this.calcularValoresAdicionais() + "\n"+
        "O valor líquido é: " + this.salarioLiquido + "\n"+
        "-------------------------------------------" + "\n";
        return resultado;
    }
    
    private float calcularDescontoInss(){
        if (salarioBruto <= 1693.72){
            return salarioBruto * 0.08f;
        } else if ((salarioBruto > 1693.72) && (salarioBruto <= 2822.90f)){
            return salarioBruto * 0.09f;
        } else{
           return salarioBruto * 0.11f; 
        }   
    }
    
    private float calcularImpostoRenda(){
        if(salarioBruto < 1903.98){
            return 0;
        }else if ((salarioBruto > 1903.98) && (salarioBruto <= 2826.65)){
            return salarioBruto * 0.075f;
        }else if ((salarioBruto > 2826.65) && (salarioBruto <= 3751.05)){
            return salarioBruto * 0.15f;
        }else if ((salarioBruto > 3751.05) && (salarioBruto <= 4664.68)){
            return salarioBruto * 0.225f;
        } else {
            return salarioBruto * 0.275f;
        }
    }
    
    private float calcularValoresAdicionais(){
        Calendar c = Calendar.getInstance();
        c.setTime(dataNascimento);
        int anoNascimento = c.get(Calendar.YEAR);
        c.setTime(new Date());
        int anoAtual = c.get(Calendar.YEAR);
        c.setTime(dataAdmissao);
        int anoAdmissao = c.get(Calendar.YEAR);
        
        int idade = anoAtual - anoNascimento;
        int anosTrabalhando = anoAtual - anoAdmissao;
        
        if (idade > 40){
            return salarioBruto * 0.02f;
        };
        
        if(anosTrabalhando > 15){
            return salarioBruto * 0.035f;   
        } else if ((anosTrabalhando < 15)&& (anosTrabalhando > 5) && (idade > 30) ){  
            return salarioBruto * 0.015f;   
        } else{
            return 0;
        }
    }
            
            
     
    
}
