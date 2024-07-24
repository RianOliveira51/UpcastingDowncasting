package com.example.aprendendoupcastingdowncasting;

import com.example.aprendendoupcastingdowncasting.entities.Account;
import com.example.aprendendoupcastingdowncasting.entities.BusinessAccount;
import com.example.aprendendoupcastingdowncasting.entities.SavingsAccount;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class UpcastingDowncasting {

    public static void main(String[] args) {
        Account acc = new Account(1001, "Alex", 0.0);
        BusinessAccount bacc = new BusinessAccount(1002,"Maria",0.0,500.0);

        //UPCASTING - Converter uma subclasse para uma superclasse.
        //Não gerou erro pois, a relação de herança é de "é-um", ou seja uma BusinessAccoun é uma Account.
        Account acc1 = bacc;
        //Atribuindo um objeto da subclasse, para uma superclasse
        Account acc2 = new BusinessAccount(1003,"Boby", 0.0, 200.0);
        Account acc3 = new SavingsAccount(1004,"Ana",0.0,0.01);


        //DOWNCASTING - Converter um objeto da superclasse para a subclasse.
        /*Não posso realizar essa conversão, pois mesmo tendo instanciado a variavel acc2, com o objeto BusinessAccount,
        a variavel ainda continua sendo do tipo Account, como o compilador não sabe se essa conversáo é segura,
        ele não sabe se a variavel acc2 é do tipo BusinessAccoun,
        Jeito errado: BusinessAccount acc4 = acc2; */

        /* Se quiser forçar uma casting dessa conversão, terei que fazer um casting manual:
        Fazendo isso, podemos usar os metodos da subclasse*/
        BusinessAccount acc4 = (BusinessAccount)acc2;
        acc4.loan(100.0);

        /*Outro exemplo de erro, é se tertarmos fazer o DownCasting da variveal acc3, pois mesmo ela sendo do tipo Account
         ela foi instaciada com o objeto SabingAccount, o compilador só entende que está errado, em tempo de execução o programa
         Codigo do erro:class com.example.aprendendoupcastingdowncasting.entities.SavingsAccount cannot be cast to class com.example.aprendendoupcastingdowncasting.entities.BusinessAccount
         Jeito errado: BusinessAccount acc5 = (BusinessAccount)acc3;*/

        /*Para evitar isso, iremos testar se a variavel acc3 foi instanciado pelo objeto BussinAccount,
        Para isso usarmos a dunção instanceOf*/
        if(acc3 instanceof BusinessAccount){//falhou
            BusinessAccount acc5 = (BusinessAccount)acc3;
            acc5.loan(200.0);
            System.out.println("Loan!");
        }

        if(acc3 instanceof SavingsAccount){//entrou no if, pois o acc3 é uma instancia do objeto SavingsAccount
            SavingsAccount acc5 = (SavingsAccount)acc3;
            acc5.updateBalance();
            System.out.println("Update!");
        }



    }

}
