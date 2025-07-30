
public class Calculadora {

	private int n1, n2;
	
	public int getN1() {
		return n1;
	}

	public void setN1(int n1) {
		this.n1 = n1;
	}

	public int getN2() {
		return n2;
	}

	public void setN2(int n2) {
		this.n2 = n2;
	}
	
	int sumar(int s1, int s2) {
	return s1 + s2;	
	}
	
	int restar(int min, int sus) {
		return min-sus;
	}
	
	int multiplicar ( int m1, int m2) {
	return m1*m2;	
	}
	
	float dividir (int num, int den) {
	return (float) num/den;
	}
}
