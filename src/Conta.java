public class Conta {
    Cliente Dono = new Cliente();
    double saldo;
    int num;
    String agencia;
    double limite;
    Operacao[] operacoes= new Operacao[1000];
    int quantOP=0;
    boolean depositar(double valor) {
      if(this.quantOP<1000) {
          this.operacoes[quantOP]= new Operacao('d', valor);
          this.quantOP++;
          if (valor > 0.0) {
              this.saldo += valor;
              return true;
          } else {
              return false;
          }
      } else{
          System.out.println("Máximo de operações atingido");
          return false;
      }
    }


    boolean sacar(double valor) {
        if(this.quantOP<1000) {
            this.operacoes[quantOP]= new Operacao('s', valor);
            this.quantOP++;
            if(valor > 0.0 && valor <= this.saldo) {
                this.saldo -= valor;
                return true;
            } else {
                return false;
            }
        }else{
            System.out.println("Máximo de operações atingido");
            return false;
        }
    }


    boolean transferir(Conta contaDestino, double valor) {
        boolean saqueRealizado = this.sacar(valor);
        if(saqueRealizado) {
            boolean depositoRealizado = contaDestino.depositar(valor);
            return depositoRealizado;
        } else {
            return false;
        }
    }
    void imprimir (){
        System.out.println("Dono: "+Dono.Nome);
        System.out.println("CPF: "+Dono.CPF);
        System.out.println("Endereço: "+Dono.endereco);
        System.out.println("Idade: "+Dono.idade);
        System.out.println("Gênero: "+Dono.genero);
        System.out.println("Número da conta: "+num);
        System.out.println("Saldo: "+saldo);
        System.out.println("Limite: "+limite);
    }
}
