import java.math.*;
import java.util.Random;

//DIFFIE-HELLMAN KEY EXCHANGE
//HW2 Q2
public class DH{
/*
* prime: 293040877
* primitive root: 11
* Ya: 204397779
*/
static int privateKey(){
  //Random rand = new Random();
  //int Xb = rand.nextInt(293040877);
  int Xb = 300;
  return Xb;
}

static BigInteger publicKey(BigInteger Xb, BigInteger p){
  BigInteger Yb = new BigInteger("11");
  Yb = Yb.modPow(Xb, p);
  return Yb;
}

static BigInteger secretKey(BigInteger Xb, BigInteger p){
  BigInteger K = new BigInteger("204397779");
  K = K.modPow(Xb, p);
  return K;
}
  public static void main(String args[]){
    int pubKey = privateKey();
    BigInteger Xb =  BigInteger.valueOf(pubKey);
    BigInteger prime = new BigInteger("293040877");
    System.out.println("My Public Key is: " + publicKey(Xb, prime));
    System.out.println("The Shared Secret Key is: " + secretKey(Xb, prime));
  }
}
