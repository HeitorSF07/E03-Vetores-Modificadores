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
    void extrato(){
        for(int i=0; i<quantOP; i++) {
            System.out.println(operacoes[i].tipo+" "+operacoes[i].valor+" "+ operacoes[i].data);
        }
    }
}
