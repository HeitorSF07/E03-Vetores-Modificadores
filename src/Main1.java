public class Main1 {
    public static void main(String[] args) {
        Conta conta1 = new Conta();
        conta1.agencia = "agencia";
        conta1.num = 1234;
        conta1.saldo = 12000;
        conta1.limite = 15000;
        conta1.depositar(1000);
        conta1.sacar(500);
        conta1.extrato();
    }
}
