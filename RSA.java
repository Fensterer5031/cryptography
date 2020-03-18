import java.math.*;

public class RSA {

//RSA Decryption
//HW2 Q3
//Aaron Fensterer ID: 001310079
static BigInteger phi(BigInteger p, BigInteger q){
  BigInteger one = BigInteger.ONE;
   p = p.subtract(one);
   q = q.subtract(one);
   p = p.multiply(q);
  return p;
}
static BigInteger d(BigInteger e, BigInteger phi){
  e = e.modInverse(phi);
  return e;
}
static BigInteger decrypt(BigInteger C, BigInteger D, BigInteger N){
  C = C.modPow(D, N);
  return C;
}

  public static void main(String args[]){
    BigInteger P = new BigInteger("9701777");
    BigInteger Q = new BigInteger("15431693");
    BigInteger E = new BigInteger("15738515");
    BigInteger N = P;
    N = N.multiply(Q);
    BigInteger C = new BigInteger("11027797412524");

    BigInteger PHI = phi(P, Q);
    BigInteger D = d(E, PHI);
    BigInteger M = decrypt(C, D, N);

    //System.out.println("Phi is: " + PHI);
    System.out.println("D is: " + D);
    System.out.println("N is: " + N);
    System.out.println("Message is: " + M);

  }
}
