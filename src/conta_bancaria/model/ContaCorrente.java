package conta_bancaria.model;

public class ContaCorrente extends Conta {

	private float limite;

	public ContaCorrente(int numero, int agencia, int tipo, String titular, float saldo, float limite) {
		super(numero, agencia, tipo, titular, saldo);
		this.limite = limite;
	}

	public float getLimite() {
		
		// Atualiza o limite caso o saldo seja negativo
		
		if(this.getSaldo() < 0)
			return this.limite - Math.abs(this.getSaldo());
		
		return limite;
		
	}

	public void setLimite(float limite) {
		this.limite = limite;
	}

	@Override
	public boolean sacar(float valor) {

		if (this.getSaldo() + this.getLimite() < valor) {
			System.out.println("\nSaldo Insuficiente");
			return false;
		}

		this.setSaldo(this.getSaldo() - valor);
		
		return true;
	}

	@Override
	public void visualizar() {
		super.visualizar();
		System.out.println("Limite da conta: " + this.getLimite()); // Chama o Método get
	}
}
