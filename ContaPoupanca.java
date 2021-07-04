public class ContaPoupanca extends Conta {
    public ContaPoupanca(int agencia, int numero, Cliente titular) {
        super(agencia, numero, titular);
    }

    @Override
    public void depositar(double valor) {
        super.depositar(valor + (0.01 * valor));
    }

    @Override
    public boolean sacar(double valor) {
        double valorComTaxa = valor + (0.01 * valor);
        if (getSaldo() >= valorComTaxa) {
            super.sacar(valorComTaxa);
            System.out.println("Operação realizada com sucesso!");
            return true;
        } else {
            System.out.println("Operação não realizada!");
            System.out.println("Saldo insuficiente.");
            return false;
        }
    }

    @Override
    public boolean transferir(double valor, Conta destino) {
        double valorComTaxa = valor - (0.01 * valor);
        if (getSaldo() >= valorComTaxa) {
            super.saldo -= valorComTaxa;
            destino.depositar(valor);
            System.out.println("Operação realizada com sucesso!");
            return true;
        } else {
            System.out.println("Operação não realizada!");
            return false;
        }
    }
}