package entities;

public class ContaBancaria {

    private double saldo;
    private double limiteChequeEspecial;
    private static final double TAXA = 0.2;
    private String nomeTitular;

    public ContaBancaria(String nomeTitular, double depositoInicial) {
        if (depositoInicial <= 0) {
            throw new IllegalArgumentException("Depósito inicial deve ser maior que zero");
        }
        this.nomeTitular = nomeTitular;
        this.limiteChequeEspecial = (depositoInicial <= 500.0) ? 50.0 : depositoInicial * 0.5;
        this.saldo = depositoInicial;

    }

    public String getNomeTitular() {
        return nomeTitular;
    }

    public double getSaldoTotal() {
        return saldo + limiteChequeEspecial;
    }

    public double getLimiteChequeEspecial() {
        return limiteChequeEspecial;
    }

    public double getSaldo() {
        return saldo;
    }

    public double getTaxa() {
        return TAXA;
    }

    public boolean isChequeEspecialAtivo() {
        return saldo < 0;
    }

    public void depositar(double valor) {
        if (valor <= 0) return;

        if (saldo < 0) { // Está usando cheque especial
            double divida = -saldo;
            double quitado = Math.min(valor, divida);
            saldo -= quitado * TAXA; // TAXA só sobre a parte quitada
        }

        saldo += valor;
    }

    public boolean sacar(double valor) {
        if (valor <= 0 || valor > saldo + limiteChequeEspecial) return false;
        saldo -= valor;
        return true;
    }

    public boolean pagarBoleto(double valor) {
        return sacar(valor);
    }

    public double chequeEspecialDisponivel() {

        if (saldo < 0) {
            // Se o saldo for negativo, o limite disponível diminui
            // Exemplo: 50.0 + (-20.0) = 30.0 disponíveis
            return limiteChequeEspecial + saldo;
        }

        // Se o saldo for positivo ou zero, o limite está 100% disponível
        return limiteChequeEspecial;

    }
}
