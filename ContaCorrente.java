public class ContaCorrente extends Conta {
    public ContaCorrente(int agencia, int numero, Cliente titular) {
        super(agencia, numero, titular);
    }

    @Override
    public boolean transferir(double valor, Conta destino) {
        if(getSaldo() >= valor) {
            sacar(valor);
            destino.depositar(valor);
            System.out.println("Operação realizada com sucesso!");
            return true;
        } else {
            System.out.println("Operação não realizada!");
            return false;
        }
    }
}
