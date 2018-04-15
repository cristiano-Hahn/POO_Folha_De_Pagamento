/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Folha_De_Pagamento;

import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Date;

/**
 *
 * @author Crist
 */
public class Utilizacao {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        SimpleDateFormat sdf1= new SimpleDateFormat("dd/MM/yyyy");
        
        Date dataAdmMuricio = new Date();
        Date dataAdmCristiano = new Date();
        Date dataNasctoMuricio = new Date();
        Date dataNasctoCristiano = new Date();
        
        try {
            dataAdmMuricio = sdf1.parse("01/01/2010");
            dataAdmCristiano = sdf1.parse("01/01/1990");
            dataNasctoCristiano = sdf1.parse("01/01/1980");
            dataNasctoMuricio = sdf1.parse("01/01/2000");
        } catch (Exception e) {
            e.printStackTrace();
        }
      
        Funcionario cristiano = new Funcionario("Cristiano", dataNasctoCristiano);
        Funcionario muricio = new Funcionario("Mauricio", dataNasctoMuricio);
           
        cristiano.contratar(Funcionario.tipoContrato.tcEfetivo, 10, 2, dataAdmCristiano);
        cristiano.calcularSalarioLiquido(100); 
        cristiano.mostrarFolhaPagamento();
        
        muricio.contratar(Funcionario.tipoContrato.tcHorista, 30, 1, dataAdmMuricio);
        muricio.calcularSalarioLiquido(200);    
        muricio.mostrarFolhaPagamento();
    }
    
}
