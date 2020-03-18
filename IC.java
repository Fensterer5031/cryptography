import java.io.*;

public class IC extends AES{
//Aaron Fensterer
//HW2 Q1
//Index of Coincidence

  public static void main(String args[])throws Exception{
  // IC = 1/(N(N-1))*(SUM i=0-25 Fi(Fi-1))
  FileReader fr = new FileReader("C:\\426\\text0.txt");
  char[] destination = new char[2000];
  int [] freq = new int[26];
  int charsRead = fr.read(destination, 0, destination.length);
  for(int i = 0; i < destination.length; i ++){
    //System.out.println(destination[i]);
    if(destination[i] == 'a' || destination[i] == 'A') freq[0]++;
    if(destination[i] == 'b' || destination[i] == 'B') freq[1]++;
    if(destination[i] == 'c' || destination[i] == 'C') freq[2]++;
    if(destination[i] == 'd' || destination[i] == 'D') freq[3]++;
    if(destination[i] == 'e' || destination[i] == 'E') freq[4]++;
    if(destination[i] == 'f' || destination[i] == 'F') freq[5]++;
    if(destination[i] == 'g' || destination[i] == 'G') freq[6]++;
    if(destination[i] == 'h' || destination[i] == 'H') freq[7]++;
    if(destination[i] == 'i' || destination[i] == 'I') freq[8]++;
    if(destination[i] == 'j' || destination[i] == 'J') freq[9]++;
    if(destination[i] == 'k' || destination[i] == 'K') freq[10]++;
    if(destination[i] == 'l' || destination[i] == 'L') freq[11]++;
    if(destination[i] == 'm' || destination[i] == 'M') freq[12]++;
    if(destination[i] == 'n' || destination[i] == 'N') freq[13]++;
    if(destination[i] == 'o' || destination[i] == 'O') freq[14]++;
    if(destination[i] == 'p' || destination[i] == 'P') freq[15]++;
    if(destination[i] == 'q' || destination[i] == 'Q') freq[16]++;
    if(destination[i] == 'r' || destination[i] == 'R') freq[17]++;
    if(destination[i] == 's' || destination[i] == 'S') freq[18]++;
    if(destination[i] == 't' || destination[i] == 'T') freq[19]++;
    if(destination[i] == 'u' || destination[i] == 'U') freq[20]++;
    if(destination[i] == 'v' || destination[i] == 'V') freq[21]++;
    if(destination[i] == 'w' || destination[i] == 'W') freq[22]++;
    if(destination[i] == 'x' || destination[i] == 'X') freq[23]++;
    if(destination[i] == 'y' || destination[i] == 'Y') freq[24]++;
    if(destination[i] == 'z' || destination[i] == 'Z') freq[25]++;
  }
  double[] n = new double [26];
  for(int i = 0; i <= 25; i++){
  n[i] = (freq[i] * (freq[i]-1));
  n[i] = (freq[i]/(26*25));
  //System.out.println(n[i]);
}
double N = 0.0;

for(int i = 0; i < 25; i++){
  N += freq[i];

}
int T = 26 * 25;
double IC = N/T;
System.out.println(IC);
}
    }
