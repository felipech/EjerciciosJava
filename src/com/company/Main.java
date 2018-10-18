//**************************************//
//Autor Felipe Choque
//Distintas soluciones de ejercicios hechas por mi
//de la pagina www.codeabbey.com
//**************************************//

package com.company;
import javafx.util.Pair;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Array;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.DecimalFormat;
import java.util.*;
import java.util.regex.Pattern;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {
        /*
        try (Scanner scanner = new Scanner(new File(nombre))) {
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
     */
        //sumar(14122, 4495);
        //suma_loop();
	    //minimo();
        //minimo_tres();
        //minimo_tres();
        //maximun_array();
        //redondear();
        //fahrenheit_celsius();
        //contar_vocales();
        //sumar_digitos();
        //MedioTres();
        //BMI();
        //ArithmeticProgression();
        //Triangles();
        //WeightedSumDigit();
        //DiceRolling();
        //AverageArray();
        //CheckSum();
        //ReverseString();
        //ArrayCounters();
        //CollatzSequence();
        //LinearFunction();
        //ModuloTimeDifference();
        //ModularCalculator();
        //BubbleArray();
        //BubbleSort();
        //GreatestCommonDivisor();
        //SortwithIndexes();
        //SquareRootApproximation();
        //Palindromes();
        //NeumannRanGen();
        //RotateString();
        //Fibonacci();
        //SmoothingWeather();
        //PythagoreanTheorem();
        //BicycleRace();
        //JosephusProblem();
        //SavingsCalculator();
        //LinearCongruentialGenerator();
        //DoubleDiceRoll();
        //MatchingBrackets();
        //BitCount();
        //CaesarShiftCipher();
        //TriangleArea();
        //MatchingWords();
        //RockPaperScissors();
        //CardNames();
        //PrimeNumbersGeneration();
        //FoolsDay2014();
        //BullsandCows();
        //CombinationsCounting();
        //BlackjackCounting();
        //ParityControlSolution();
        QuadraticEquation();
    }
    /*
    C(N, K) = N/1 * (N-1)/2 * ...
            ... * (N-K+2)/(K-1) * (N-K+1)/K
     */
    public static void QuadraticEquation(){

    }
    public static void ParityControlSolution(){
        String nombre = "ParityControl.txt";
        String valor;
        char [] valor2;
        int letter;
        ArrayList<Integer> arrayList = new ArrayList<>();
        try (Scanner scanner = new Scanner(new File(nombre))) {

            while (scanner.hasNextLine()){
                arrayList.add(scanner.nextInt());
            }
            for (int a: arrayList) {
                if (Integer.toBinaryString(a).length() == 8 && Integer.bitCount(a)%2 == 0){
                    valor2 = Integer.toBinaryString(a).toCharArray();
                    valor2[0] = '0';
                    valor = String.valueOf(valor2);
                    letter = Integer.parseInt(valor,2);
                    System.out.print((char)letter);

                }else if(Integer.bitCount(a)%2 == 0) {
                    letter = Integer.parseInt(Integer.toBinaryString(a),2);
                    System.out.print((char)letter);
                }
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }

    public static void BlackjackCounting(){
        String nombre = "BlackjackCounting.txt";
        ArrayList<String> test= new ArrayList<>();
        int max = 21;
        int resto;
        int result = 0;
        int result2 = 0;
        
        try (Scanner scanner = new Scanner(new File(nombre))) {

            //contar las A al final
            //reordenar el arreglo y dejar las A al final
            scanner.nextLine();
            while (scanner.hasNextLine()){
                test.addAll(Arrays.asList(scanner.nextLine().split(" ")));
                //calcularBlackJack(scanner.nextLine().split(" "));
                //falta ver si en el arreglo quedan numeros en especial A
                int As = 11;
                int As2 = 1;
                for (int i = 0; i < test.size(); i++) {
                    if (test.get(i).equals("K") || test.get(i).equals("Q") || test.get(i).equals("T") || test.get(i).equals("J")) {
                        result = 10 + result;
                        result2 = 10 + result2;

                    }
                    //else if(As > resto){
                        //As = 1;
                        else if (test.get(i).equals("A") /*&& resto >= 11*/ ) {
                            result = As + result;
                            result2 = As2 + result2;
                        //}
                    }/*else if (test.get(i).equals("A") && resto < 11) {
                        result = 1 + result;

                    }*/ else {
                        result =  Integer.parseInt(test.get(i)) + result;
                        result2 = Integer.parseInt(test.get(i)) + result2;
                    }
                    resto = max - result;
                    if (As > resto)As = 1;
                    if (As2 > resto) As2 = 11;
                }
                if(result <= 21 && result2 <= 21){
                    if (result2 > result) result = result2;
                }
                else if(result > result2 ){
                    result = result2;
                }
                if (result > max){
                    System.out.println("Bust");
                }
                if (result <= max){
                    System.out.println(result);
                }
                max = 21;
                result = 0;
                result2 = 0;

                test.clear();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }

    public static void calcularBlackJack(String[] lista){
        System.out.println("Aca");
    }

    public static void CombinationsCounting(){
        String nombre = "CombinationsCounting.txt";
        BigInteger res;
        long n;
        long k;
        try (Scanner scanner = new Scanner(new File(nombre))) {
            scanner.nextLine();
            while (scanner.hasNext()){
                n = scanner.nextInt();
                k = scanner.nextInt();
                res = factorialBig(n).divide(factorialBig(k).multiply(factorialBig((n-k))));
                System.out.println(res);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static BigInteger factorialBig(long n){
        BigInteger r0 = new BigInteger("0");
        BigInteger r1 = new BigInteger("1");
        BigInteger r2 = new BigInteger("1");
        //if (n == 1)return r0;
        if (n == 1)return r1;
        for (int i = 1; i < n+1; i++) {
            r2 = r2.multiply(BigInteger.valueOf(i));
            //System.out.println(r2);
        }
        return r2;
    }
    public static Stream<String> Cargar(String nombre){
        String archivoLeido = nombre;
        try {
            Stream<String> stream1 = Files.lines(Paths.get(archivoLeido));
            return stream1;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    //--------------------------------------------
    public static void DiceRolling(){
        String nombre = "DiceRolling.txt", linea;
        double diceNum;
        try (Scanner scanner = new Scanner(new File(nombre))) {
            while(scanner.hasNext()){
                linea = scanner.nextLine();
                if(Double.parseDouble(linea) < 1) {
                    diceNum = Double.parseDouble(linea) * 6;
                    System.out.println((int)Math.floor(diceNum) + 1);
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    //--------------------------------------------------------
    public static void DoubleDiceRoll(){
        String nombre = "DoubleDiceRoll.txt";
        int R = 0, R1 = 0, N = 6, result = 0;
        try (Scanner scanner = new Scanner(new File(nombre))) {
            scanner.nextLine();
            while (scanner.hasNext()){
                R = scanner.nextInt();
                R1 = scanner.nextInt();
                result = ((R%6) + 1) + ((R1%6) + 1);
                System.out.println(result);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    //--------------------------------------------------------


    //--------------------------------------------------------
    public static void BullsandCows(){
        String nombre = "BullsandCows.txt", line, secret1;
        int secret;
        List<String> list;
        try (Scanner scanner = new Scanner(new File(nombre))) {
            secret = scanner.nextInt();
            secret1 = Integer.toString(secret);
            scanner.nextLine();
            line = scanner.nextLine();
            list = Arrays.asList(line.split(" "));
            hint1(secret1, list);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    public static void hint1(String secret, List<String> list){
        int h1 = 0, h2 = 0;
        for (int i = 0; i < list.size(); i++) {
            for (int j = 0; j < 4; j++) {
                if (secret.toCharArray()[j] == list.get(i).toCharArray()[j]){
                    h1++;
                }
                if (secret.contains(Character.toString(list.get(i).toCharArray()[j]))){
                    h2++;
                }
            }
            System.out.println(h1+"-"+(h2-h1));
            h1 = 0;
            h2 = 0;
        }
    }
    //--------------------------------------------------------
    public static void FoolsDay2014(){
        String nombre = "FoolsDay2014.txt";
        int result;
        try (Scanner scanner = new Scanner(new File(nombre))) {
            scanner.nextLine();
            while (scanner.hasNext()){
                result = FoolsSum(scanner.nextLine());
                System.out.println(result);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    public static int FoolsSum(String line){
        int result = 0, n;
        List<String> arrayList;
        //arrayList = Integer.parseInt(line.split(" "));
        arrayList = Arrays.asList(line.split(" "));
        for (int i = 0; i < arrayList.size(); i++){
            n = Integer.parseInt(arrayList.get(i));
            n = n*n;
            result = result + n;
        }
        return result;
    }
    //--------------------------------------------------------

    public static void PrimeNumbersGeneration(){
        String nombre = "PrimeNumbersGeneration.txt";
        int n = 30;
        ArrayList<Integer> arrayList = new ArrayList<>();
        ArrayList<Integer> arrayList1 = new ArrayList<>();
        int [] test;
        try (Scanner scanner = new Scanner(new File(nombre))) {
            System.out.println(2);
            for (int i = 1; i < n; i++){
                if (i %2 != 0){
                    //System.out.println(i);
                    arrayList.add(i);
                }
            }
            test = new int[arrayList.size()];
            for (int a = 0; a < arrayList.size(); a++)test[a] = arrayList.get(a);
            //System.out.println(arrayList);
            System.out.println("  ->  "+test.length);
            for (int h = 1; h < arrayList.size(); h++){
                for (int j = 0; j < arrayList.size(); j++){
                    if(arrayList.get(j) % arrayList.get(h) != 0 ){
                        System.out.println(arrayList.get(j));
                        test[j] = 0;

                    }else arrayList1.add(arrayList.indexOf(arrayList.get(j)));
                    //else arrayList.remove(arrayList.get(j));
                }
                arrayList.removeAll(arrayList1);
                break;



            }
            System.out.println(arrayList);
            System.out.println(arrayList1);
            for (int aTest : test) {
                System.out.println(aTest);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    //--------------------------------------------------------
    public static void CardNames(){
        String nombre = "CardNames.txt";
        String[] suits =new String[] {"Clubs", "Spades", "Diamonds", "Hearts"};
        String[] ranks = new String[] {"2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace"};
        double result, remainder,number;
        try (Scanner scanner = new Scanner(new File(nombre))) {
            scanner.nextLine();
            while (scanner.hasNext()){
                number = scanner.nextInt();
                //System.out.println(number);
                result = Math.floor(number / 13);
                //System.out.println(result);
                remainder = number % 13;
                //System.out.println(remainder);
                System.out.println(ranks[(int)remainder ] + "-" + "of" + "-" +  suits[(int)result] );
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    //--------------------------------------------------------
    public static void RockPaperScissors(){
        String nombre = "RockPaperScissors.txt", line;
        int wins;
        List<String> list = new ArrayList<>();
        try (Scanner scanner = new Scanner(new File(nombre))) {
            scanner.nextLine();
            while (scanner.hasNext()){
                line = scanner.nextLine();
                list = Arrays.asList(line.split(" "));
                wins = whoWins(list);
                System.out.println(wins);
            }


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    public static int whoWins(List<String> list){
        int first = 0, second = 0;
        char f,s;
        for (int i = 0; i < list.size(); i++){

            if (list.get(i).toCharArray()[0] == 'R' && list.get(i).toCharArray()[1] == 'S' ){
                //System.out.println("wins 1");
                first++;
            }else if (list.get(i).toCharArray()[0] == 'S' && list.get(i).toCharArray()[1] == 'R' ){
                //System.out.println("wins 2");
                second++;
            }else if (list.get(i).toCharArray()[0] == 'S' && list.get(i).toCharArray()[1] == 'P' ){
                //System.out.println("wins 1");
                first++;
            }else if (list.get(i).toCharArray()[0] == 'P' && list.get(i).toCharArray()[1] == 'S' ){
                //System.out.println("wins 2");
                second++;
            }else if (list.get(i).toCharArray()[0] == 'P' && list.get(i).toCharArray()[1] == 'R' ){
                //System.out.println("wins 1");
                first++;
            }else if (list.get(i).toCharArray()[0] == 'R' && list.get(i).toCharArray()[1] == 'P' ) {
                //System.out.println("wins 2");
                second++;
            }


        }
        if (first > second)return 1;
        else return 2;
    }
    //--------------------------------------------------------
    public static void MatchingWords(){
        String nombre = "MatchingWords.txt", line;
        List<String> list;
        Set<String> set = new LinkedHashSet<>();
        try (Scanner scanner = new Scanner(new File(nombre))) {
            line = scanner.nextLine();
            list = Arrays.asList(line.split(" "));
            Collections.sort(list);
            for (int i = 0; i < list.size();i++){
                if( i > 0 && list.get(i-1).equals(list.get(i))) {
                    set.add(list.get(i));
                }
            }
            //System.out.println(set);
            for (String a: set) System.out.println(a);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }
    //--------------------------------------------------------

    public static void TriangleArea(){
        String nombre = "TriangleArea.txt";
        int x1,y1,x2,y2,x3,y3;
        double sideA, sideB,sideC, s, A;
        try (Scanner scanner = new Scanner(new File(nombre))) {
            scanner.nextLine();
            while (scanner.hasNext()){
                x1 = scanner.nextInt();
                y1 = scanner.nextInt();
                x2 = scanner.nextInt();
                y2 = scanner.nextInt();
                x3 = scanner.nextInt();
                y3 = scanner.nextInt();
                sideA = Math.sqrt((y2 - y1)*(y2 - y1) + (x2 - x1)*(x2 - x1));
                sideB = Math.sqrt((y3 - y2)*(y3 - y2) + (x3 - x2)*(x3 - x2));
                sideC = Math.sqrt((y3 - y1)*(y3 - y1) + (x3 - x1)*(x3 - x1));
                s = (sideA + sideB + sideC)/2;
                A = Math.sqrt(s*(s-sideA)*(s-sideB)*(s-sideC));
                System.out.println(A);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    //--------------------------------------------------------
    public static void CaesarShiftCipher(){
        String nombre = "CaesarShiftCipher.txt", line;
        int K = 0, N = 0;
        char [] alf = new char[]{'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q',
                'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};
        //int [] alfNum = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26};
        List<Character> list = new LinkedList<>();
        //HashMap<Integer, Character> test = new LinkedHashMap<>();
        char[] aux ;
        for (int i = 0; i < alf.length;i++ ){
            list.add(alf[i]);
        }
        //System.out.println(list);

        try (Scanner scanner = new Scanner(new File(nombre))) {
            N = scanner.nextInt();
            K = scanner.nextInt();
            scanner.nextLine();
            while (scanner.hasNext()){
                line = scanner.nextLine();

                //aux = new char[line.length()];
                aux = line.toCharArray();
                //System.out.println(aux);
                deco(aux, K, list);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    public static void deco(char [] aux, int K, List<Character>aux1){
        int value = 0;
        //System.out.println(K);

        // asi se hace con indexOf
        //buscas el indice correspondiente a la letra y a eso le puedes restar la K
        //si sale un numero negativo se lo sumas(restar) a 26 y sabes que letra corresponde
        // despues con get value abtienes la letra encripatada
        //System.out.println(aux1.indexOf('S'));
        for (int i = 0;i< aux.length;i++) {
            if (aux[i] != ' ' && aux[i] != '.'){
                value = aux1.indexOf(aux[i]) - K;
                if (value < 0) {
                    value = 26 + value;
                }
                System.out.print(aux1.get(value));
            }
            //System.out.print(aux1.get(value));
            else if (aux[i] == ' ') System.out.print(' ');
            else if (aux[i] == '.') System.out.print('.');
            /*if (aux[i] != ' ' && aux[i] != '.') {
                if (aux[i] == 'A'){
                    System.out.print('X');
                }else if (aux[i] == 'B'){
                    System.out.print('Y');

                }else if (aux[i] == 'C'){
                    System.out.print('Z');
                }else {
                    System.out.print((char) (aux[i] - 3));
                }
            }else if (aux[i] == ' ') System.out.print(' ');
            else if (aux[i] == '.') System.out.print('.');*/

        }
        System.out.println();

    }
    //--------------------------------------------------------
    public static void BitCount(){
        String nombre = "BitCount.txt";
        int number, result;
        try (Scanner scanner = new Scanner(new File(nombre))) {

            scanner.nextLine();
            while (scanner.hasNext()){
                number = scanner.nextInt();
                result = countOne(number);
                System.out.println(result);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }
    public static int countOne(int N){
        int negative = N, count = 0, rest;
        int[] test = new int[]{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
        int m = 31;
        while(N != 0){
            if (N<0)N=N*-1;
            rest = N%2;
            N = N/2;
            test[m] = rest;
            m--;
        }
        for (int f = 0; f < test.length; f++){
            if (test[f] == 1)count++;
        }
        if (negative < 0){
            for (int i = 0; i < test.length;i++){
                if (test[i] == 0){
                    test[i] = 1;
                }else test[i] = 0;
            }
            for(int x = test.length -1; x > 0;x--){
                if ((test[x]  + 1 ) == 2 ){
                    test[x] = 0;
                }else if ((test[x]  + 1 ) == 1){
                    test[x] = 1;
                    break;
                }
            }
            count = 0;
            for (int f = 0; f < test.length; f++){
                if (test[f] == 1)count++;
            }
        }
        return count;
    }

    //--------------------------------------------------------
    public static void MatchingBrackets(){
        String nombre = "MatchingBrackets.txt", line;
        List<Character> list = new ArrayList<>();
        List<String> list1 = new ArrayList<>();
        try (Scanner scanner = new Scanner(new File(nombre))) {
            scanner.nextLine();
            while (scanner.hasNext()){
                line = scanner.nextLine();
                //System.out.println(line.toCharArray());
                for (int i = 0; i < line.toCharArray().length;i++){
                    if (line.toCharArray()[i] == '('){
                        //list.add('(');
                        list1.add("(A");
                    }
                    if (line.toCharArray()[i] == ')'){
                        //list.add(')');
                        list1.add(")A");
                    }
                    if (line.toCharArray()[i] == '['){
                        //list.add('[');
                        list1.add("[B");
                    }
                    if (line.toCharArray()[i] == ']'){
                        //list.add(']');
                        list1.add("]B");
                    }
                    if (line.toCharArray()[i] == '{'){
                        //list.add('{');
                        list1.add("{C");
                    }
                    if (line.toCharArray()[i] == '}'){
                        //list.add('}');
                        list1.add("}C");
                    }
                    if (line.toCharArray()[i] == '<'){
                        //list.add('<');
                        list1.add("<D");
                    }
                    if (line.toCharArray()[i] == '>'){
                        //list.add('>');
                        list1.add(">D");
                    }
                }
                //System.out.println(list);

                for (int i = 0; i<list1.size();i++){
                    //System.out.println(list1.get(i));
                    if (i > 0 && list1.get(i).toCharArray()[0] == ')' || list1.get(i).toCharArray()[0] == ']' ||
                            list1.get(i).toCharArray()[0] == '}'  || list1.get(i).toCharArray()[0] == '>' ){
                        if (list1.get(i).toCharArray()[1] == list1.get(i-1).toCharArray()[1]){
                            //list1.removeAll();
                            //System.out.println(list1.get(i).toCharArray()[1] + " - " + list1.get(i-1).toCharArray()[1]);
                            list1.remove(i);
                            list1.remove(i-1);
                            i=0;
                        }
                    }
                }
                //System.out.println(list1 + " size " + list1.size());
                if (list1.size() == 0) System.out.println("1");
                else System.out.println("0");
                list1.clear();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }

    //--------------------------------------------------------
    public static void LinearCongruentialGenerator(){
        String nombre = "LinearCongruentialGenerator.txt";
        int A = 0, C = 0, M = 0, X0 = 0, N = 0;

        try (Scanner scanner = new Scanner(new File(nombre))) {
            scanner.nextLine();
            while (scanner.hasNext()){
                A = scanner.nextInt();
                C = scanner.nextInt();
                M = scanner.nextInt();
                X0 = scanner.nextInt();
                N = scanner.nextInt();
                for (int i = 0; i < N;i++ ){
                    X0 = (A * X0 + C) % M;
                }
                System.out.println(X0);

            }


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }


    }

    //--------------------------------------------------------
    public static void SavingsCalculator(){
        /*double S = 1000.0 ,R= 10000.0 ,P;
        while (S < R){
            S = S*0.08 + S;
        }

        System.out.println(S);
        System.out.println(S);*/
        double S = 0.0, R = 0.0, P = 0.0;
        int Y = 0;
        String nombre = "SavingsCalculator.txt";
        BigDecimal bigDecimal;
        try (Scanner scanner = new Scanner(new File(nombre))) {
            scanner.nextLine();
            while (scanner.hasNext()){

                S = scanner.nextDouble();
                R = scanner.nextDouble();
                P = scanner.nextDouble();

                while (S < R){
                    S = (long)S*(P/100) + S;
                    Y++;
                }
                /*bigDecimal = new BigDecimal(S);
                bigDecimal.setScale(2,RoundingMode.HALF_DOWN);*/
                System.out.println(Y);
                //System.out.println(" S " + S + " Y " + Y);
                Y = 0;
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    //--------------------------------------------------------

    public static void JosephusProblem(){
        String nombre = "JosephusProblem.txt";
        int N = 0, K = 0, count, h=1, iter = 0;
        ArrayList<Integer> arrayList = new ArrayList<>();
        ArrayList<Integer> arrayList1 = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        ArrayList<Integer> respaldo = new ArrayList<>();
        ArrayList<Integer> original = new ArrayList<>();
        ArrayList<Integer> result = new ArrayList<>();



        try (Scanner scanner = new Scanner(new File(nombre))) {
            while (scanner.hasNext()){
                N = scanner.nextInt();
                K = scanner.nextInt();
            }
            for (int i = 0; i < N; i++){
                arrayList.add(i+1);
                original.add(i+1);
                result.add(i+1);
            }
            //System.out.println(arrayList);
            count = K;
            while(/*arrayList.size() != 2*/iter != (K+2)*2){
                System.out.println("C " + (count - h));
                System.out.println(arrayList);
                if ((count-h)>=arrayList.size()){
                    result.addAll(addNumbers(original,respaldo));
                    //arrayList1.removeAll(arrayList);

                    arrayList1.addAll(arrayList);
                    //break;
                    arrayList.addAll(arrayList1);
                    respaldo.clear();
                    //break;

                }
                System.out.println("C " + (count - h));

                respaldo.add(arrayList.get((count-h)));
                arrayList.remove((count-h));

                count = count + K;
                System.out.println("C " + (count - h));
                h++;
                //System.out.println(arrayList);

                /*if (K > arrayList.size()){
                    //funcion que agrega array original y array aux
                    arrayList1.addAll(arrayList);
                    arrayList2 = addNumbers(arrayList, arrayList1);
                    System.out.println(" add " + arrayList2);
                }*/
                iter++;
            }
            //arrayList1.addAll(arrayList);

            System.out.println(arrayList1);
            System.out.println(arrayList);
            System.out.println(" respaldo " + respaldo);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static ArrayList<Integer> addNumbers(ArrayList<Integer> original, ArrayList<Integer> aux){
        original.removeAll(aux);
        //original.removeAll(aux);
        return original;
    }

    //--------------------------------------------------------
    public static void BicycleRace(){
        String nombre = "BicycleRace.txt";
        double a,b,c, D, T;
        try (Scanner scanner = new Scanner(new File(nombre))) {
            scanner.nextLine();
            while (scanner.hasNext()){
                a = scanner.nextInt();
                b = scanner.nextInt();
                c = scanner.nextInt();
                //System.out.println((a/(b+c)));
                T = a/(b+c);
                D = b*T;
                System.out.println(D);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }

    //--------------------------------------------------------
    public static void PythagoreanTheorem(){
        String nombre = "PythagoreanTheorem.txt";
        int a,b,c;
        try (Scanner scanner = new Scanner(new File(nombre))) {

            scanner.nextLine();
            while (scanner.hasNext()){
                a = scanner.nextInt();
                b = scanner.nextInt();
                c = scanner.nextInt();
                if(((a*a) + (b*b)) == (c*c)){
                    System.out.println("R");
                }else if(((a*a) + (b*b)) > (c*c)){
                    System.out.println("A");
                }else System.out.println("O");

            }


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }

    //--------------------------------------------------------
    public static void SmoothingWeather(){
        String nombre = "SmoothingWeather.txt";
        int number;
        double result = 0.0;
        String number2 = "";
        ArrayList<Double> arrayList = new ArrayList<>();
        ArrayList<Double> arrayList1 = new ArrayList<>();
        DecimalFormat format = new DecimalFormat(".##########");
        try (Scanner scanner = new Scanner(new File(nombre))) {

            scanner.nextLine();
            while (scanner.hasNext()){
                number2 = scanner.nextLine();
            }
            //String[] temp = new String[number2.split(" ").length];
            for (int i = 0;i < number2.split(" ").length;i++){
                //temp[i] = number2.split(" ")[i];
                arrayList.add(Double.parseDouble(number2.split(" ")[i]));
            }

            arrayList1 = smothing(arrayList);
            for (double a:arrayList1) {
                System.out.println(a);
            }
            //System.out.println(format.format(arrayList1));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    public static ArrayList<Double> smothing(ArrayList<Double> arrayList){
        double result;
        ArrayList<Double> arrayList1 = new ArrayList<>();

        for (int i = 0; i < arrayList.size() - 1;i++){
            //System.out.println(arrayList.get(i));
            if (i == 0) arrayList1.add(arrayList.get(i));
            if (i != 0){
                result = (arrayList.get(i-1) + arrayList.get(i) + arrayList.get(i+1))/3;
                arrayList1.add(result);
            }
            if(i == arrayList.size()-2) arrayList1.add(arrayList.get(arrayList.size()-1));
        }
        return arrayList1;
    }

    //--------------------------------------------------------

    public static void Fibonacci(){
        String nombre = "Fibonacci.txt";
        //int a = 0 , b = 1, r;

        BigInteger secretNumber;
        try (Scanner scanner = new Scanner(new File(nombre))) {
            scanner.nextLine();
            while (scanner.hasNext()){
                secretNumber = scanner.nextBigInteger();
                //System.out.println(secretNumber);
                searchNum(secretNumber);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }
    public static void searchNum(BigInteger number){
        BigInteger a = new BigInteger("0");
        BigInteger b = new BigInteger("1");
        BigInteger r = new BigInteger("0");
        BigInteger zero = new BigInteger("0");
        int i = 1;
        while (true){
            r = a;
            b = a.add(b);
            //System.out.println(b);
            if (number.equals(zero)){
                System.out.println(0);
                break;
            }
            if(b.equals(number)){
                System.out.println(i);
                break;
            }
            i++;
            a = b;
            b = r;
        }

    }

    //--------------------------------------------------------
    public static void RotateString(){
        String nombre = "RotateString.txt", example = "aaasssddd", exa = "aaasssddd", s, result;
        int k;
        try (Scanner scanner = new Scanner(new File(nombre))) {
            example = example.substring(6,9);
            scanner.nextLine();
            while (scanner.hasNext()){
                k = scanner.nextInt();
                s = scanner.nextLine();
                result = rotate(k,s);
                System.out.println(result);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static String rotate(int k, String s){
        StringBuilder stringBuilder = new StringBuilder();
        String original = s, modified = "";
        char [] a1;

        if(k < 0){
            k = k*-1;
            modified = s.substring(s.length()-k);
            stringBuilder.append(s);
            a1 = stringBuilder.delete(s.length()-k,s.length()).toString().toCharArray();
            original = fusion(modified.toCharArray(),a1,(-1*k));
            return original;
        }
        if (k > 0){
            modified = s.substring(0,k+1);
            stringBuilder.append(s);
            a1 = stringBuilder.delete(0,k+1).toString().toCharArray();
            original = fusion(a1,modified.toCharArray(),k);
            return original;
        }
        return modified;
    }
    public static String fusion(char[] a1, char[] a2, int k){
        String result = "";
        int l = a1.length+a2.length, j = 0;
        char[] result1 = new char[l];
        if(k > 0){
            for(int i = 0; i < result1.length;i++) {
                if (i < a1.length) {
                    result1[i] = a1[i];
                }
                if (i > a1.length - 1){
                    result1[i] = a2[j];
                    j++;
                }
            }
            return String.valueOf(result1).replace(" ","");
        }
        if (k < 0){
            //k = k*-1;
            for(int i = 0; i < result1.length;i++) {
                if (i < a1.length){
                    result1[i] = a1[i];
                }
                if (i > a1.length - 1){

                    result1[i] = a2[j];
                    j++;
                }
            }
            return String.valueOf(result1).replace(" ","");
        }
        return result;
    }
    //--------------------------------------------------------
    public static void NeumannRanGen(){
        String nombre = "NeumannRanGen.txt";
        int val;
        try (Scanner scanner = new Scanner(new File(nombre))) {
            scanner.nextLine();
            while (scanner.hasNext()){
                val = scanner.nextInt();
                nRG(val);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }
    public static void nRG(int value){
        int result = value, length;
        String number;
        boolean flag = false;
        int contador = 0;
        Set<Integer> set = new HashSet<>();
        while(true){
            set.add(result);
            if (set.size() == contador){
                //System.out.println(" size set " + set.size() + " cont " + contador );
                System.out.println(contador);
                break;
            }
            result = result*result;
            length = Integer.toString(result).length();
            number = Integer.toString(result);
            if(length < 8){
                flag = true;
                number = zeros(length,result);
            }
            if (flag){
                length = number.length();
                flag = false;
            }
            if (length == 8){
                if(flag == false && number.toCharArray()[0] != '0') {
                    number = Integer.toString(result);
                    flag = true;
                }
                result = Integer.parseInt(number.substring(2,6));
                contador++;
            }
        }
    }
    public static String zeros(int n, int r){
        int difference;
        StringBuilder moreZeros = new StringBuilder();
        difference = 8 - n;
        /*for (int i = 0; i < difference;i++){
            moreZeros = moreZeros + "0";
        }*/

        for (int i = 0; i < difference;i++){
            moreZeros.append("0");
        }
        moreZeros.append(String.valueOf(r));
        return moreZeros.toString();
    }

    //--------------------------------------------------------
    public static void Palindromes(){
        String nombre = "Palindromes.txt",line;
        boolean answer;
        ArrayList<Character> list;
        try (Scanner scanner = new Scanner(new File(nombre))) {
            scanner.nextLine();
            while (scanner.hasNext()){
                line = scanner.nextLine().replaceAll("[^a-zA-Z]+","").toLowerCase();
                //System.out.println(line);
                list = new ArrayList<>();
                for(int i = 0; i < line.toCharArray().length;i++){
                    list.add(line.toCharArray()[i]);
                }
                answer = Pal(list);
                if (answer)System.out.println("Y");
                else System.out.println("N");

            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    public static boolean Pal(ArrayList<Character> list){
        boolean palindrome;
        ArrayList<Character>list1 = new ArrayList<>();
        for (int i = list.size()-1; i >= 0; i--){
            list1.add(list.get(i));
        }
        palindrome = list.equals(list1);
        //System.out.println( " L1 " + list1);
        return palindrome;
    }
    //--------------------------------------------------------
    public static void SquareRootApproximation(){
        String nombre = "SquareRootApproximation.txt";
        int r = 1, x, nIter;

        try (Scanner scanner = new Scanner(new File(nombre))) {
            scanner.nextLine();
            while (scanner.hasNext()){
                x = scanner.nextInt();
                nIter = scanner.nextInt();
                //System.out.println(x + " " + nIter + " rsq " + rSq(x,nIter));
                System.out.println(rSq(x,nIter));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }
    public static double rSq(int x, int nIter){
        double r = 1.0;
        if(nIter == 0)return 1;
        for (int i = 0; i < nIter; i++){
            r = (r + (x/r))/2;
        }
        return r;
    }

    //--------------------------------------------------------

    public static void SortwithIndexes(){
        String nombre = "SortwithIndexes.txt";
        ArrayList<Integer> arrayList = new ArrayList<>();
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        try (Scanner scanner = new Scanner(new File(nombre))) {
            scanner.nextLine();
            while (scanner.hasNext()){
                arrayList.add(scanner.nextInt());
            }
            //System.out.println(arrayList);
            for (int i = 0; i < arrayList.size(); i++){
                hashMap.put(arrayList.indexOf(arrayList.get(i)) + 1, arrayList.get(i));
            }
            Map<Integer, Integer> sortedMap = sortIndex(hashMap);
            printMap(sortedMap);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    private static Map<Integer, Integer> sortIndex(Map<Integer, Integer> unsortMap) {

        // 1. Convert Map to List of Map
        List<Map.Entry<Integer, Integer>> list = new LinkedList<>(unsortMap.entrySet());

        // 2. Sort list with Collections.sort(), provide a custom Comparator
        //    Try switch the o1 o2 position for a different order
        Collections.sort(list, new Comparator<Map.Entry<Integer, Integer>>() {
            public int compare(Map.Entry<Integer, Integer> o1,
                               Map.Entry<Integer, Integer> o2) {
                return (o1.getValue()).compareTo(o2.getValue());
            }
        });

        // 3. Loop the sorted list and put it into a new insertion order Map LinkedHashMap
        Map<Integer, Integer> sortedMap = new LinkedHashMap<>();
        for (Map.Entry<Integer, Integer> entry : list) {
            sortedMap.put(entry.getKey(), entry.getValue());
        }

        /*
        //classic iterator example
        for (Iterator<Map.Entry<String, Integer>> it = list.iterator(); it.hasNext(); ) {
            Map.Entry<String, Integer> entry = it.next();
            sortedMap.put(entry.getKey(), entry.getValue());
        }*/
        return sortedMap;
    }

    public static <K, V> void printMap(Map<K, V> map) {
        for (Map.Entry<K, V> entry : map.entrySet()) {
            System.out.println(entry.getKey());
        }
    }
    //--------------------------------------------
    public static void GreatestCommonDivisor(){
        String nombre = "GreatestCommonDivisor.txt";
        int GCD, LCM, a, b, result1 =0;
        try (Scanner scanner = new Scanner(new File(nombre))) {
            scanner.nextLine();
            while (scanner.hasNext()){
                a = scanner.nextInt();
                b = scanner.nextInt();
                GCD = gcd(a, b, result1);
                LCM = (a * b)/GCD;
                System.out.println("(" + GCD + " " + LCM + ") ");

            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }
    public static int gcd(int num, int num2, int result1){
        int result;
        if(num == 0 )return result1;
        result = num2 % num;
        result1 = num;
        return gcd(result,num,result1);
    }
    //--------------------------------------------
    public static void BubbleArray(){
        String nombre = "BubbleArray.txt";
        int val, aux, countSwap = 0, j = 1, iter = 0;
        long result = 0;
        long limit = 10000007;
        int seed = 113;
        boolean swap = false;
        File file = new File(nombre);
        ArrayList<Integer> arrayList = new ArrayList<>();
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNext()){
                val = scanner.nextInt();
                if (val != -1){
                    arrayList.add(val);
                }

            }
            int [] array = new int[arrayList.size()];

            for (int a = 0; a < array.length; a++){
                array[a] = arrayList.get(a);
            }
            for (int i = 0; i < array.length -1;i++ ){
                if (array[i] > array[j])  {
                    aux = array[i];
                    array[i] = array[j];
                    array[j] = aux;
                    countSwap++;

                }
                j++;
            }
            for (long num : array) {
                result = (result + num) * seed;
                if (result > limit) {
                    result = result % limit;
                }
            }
            System.out.println(countSwap + " " + result);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    //--------------------------------------------
    public static void BubbleSort(){
        String nombre = "BubbleSort.txt";
        int[]bubble;
        ArrayList<Integer> arrayList = new ArrayList<>();
        try (Scanner scanner = new Scanner(new File(nombre))) {
            scanner.nextLine();
            while (scanner.hasNext()){
                arrayList.add(scanner.nextInt());
            }
            bubble = new int[arrayList.size()];
            for (int i = 0; i < bubble.length; i++){
                bubble[i] = arrayList.get(i);
            }
            bSort(bubble);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    public static void bSort(int [] array){
        int countSwap = 0, aux, swap2 = 0, countS = 0, pass =0;
        for (int i = 1; i < array.length ; i++){
            pass++;
            for(int j = 0; j<array.length - i;j++){
                if (array[j] > array[j+1]){
                    aux = array[j];
                    array[j] = array[j+1];
                    array[j+1] = aux;
                    countSwap++;
                    swap2++;
                }
            }
            countS++;
            if (swap2 == 0)break;
            swap2 = 0;
        }
        System.out.println(pass + " " + (countSwap));
    }
    public static int[] sort(int[]array){
        int j = 1, aux, countSwap = 0, pass = 0;
        boolean swap = false;
        for (int i = 0; i < array.length-1; i++) {
            if (swap) {
                i = 0;
                j = 1;
                swap = false;
                pass++;
            }

            if (array[i] > array[j]) {
                aux = array[i];
                array[i] = array[j];
                array[j] = aux;
                System.out.println(" i " + i + " j " + j);
                swap = true;
                countSwap++;
            }else if(array[i] < array[j]){
                pass++;
            }
            j++;
        }
        System.out.println(countSwap + " " + pass);
        return array;
    }
    //--------------------------------------------
    public static void ModularCalculator(){
        String nombre = "ModularCalculator.txt", signNum, sign;
        BigInteger reslt;
        BigInteger numbe;

        try (Scanner scanner = new Scanner(new File(nombre))) {
            //result = scanner.nextLong();
            reslt =scanner.nextBigInteger();
            scanner.nextLine();
            while (scanner.hasNext()){
                signNum = scanner.nextLine();
                System.out.println(signNum);

                sign = signNum.split(" ")[0];
                //num = Long.parseLong(signNum.split(" ")[1]);
                numbe = BigInteger.valueOf(Integer.parseInt(signNum.split(" ")[1]));
                if (sign.charAt(0) == '+'){
                    //result = num + result;
                    reslt = reslt.add(numbe);
                    System.out.println(reslt);
                }
                if (sign.charAt(0) == '*'){
                    //result = num * result;
                    reslt = reslt.multiply(numbe);
                    System.out.println(reslt);
                }
                if (sign.charAt(0) == '%'){
                    //result = result % num;
                    reslt = reslt.mod(numbe);
                }
            }
            //System.out.println(result);
            System.out.println(reslt);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    //--------------------------------------------

    public static void ModuloTimeDifference(){
        String nombre = "ModuloTimeDifference.txt";
        int result0 = 0, result1 = 0, result2 = 0,result3 = 0, date1 = 0, date2,
                contador = 0, contador1 = 0, sec, min, hour, days;
        try (Scanner scanner = new Scanner(new File(nombre))) {
            scanner.nextInt();
            while (scanner.hasNext()){
                if (contador == 0){
                    result0 = scanner.nextInt();
                    result0 = result0 * 24 * 60 * 60;

                }
                if(contador == 1){
                    result1 = scanner.nextInt();
                    result1 = result1 * 60 * 60;
                    result1 = result1 + result0;
                }
                if(contador == 2){
                    result2 = scanner.nextInt();
                    result2 = result2 * 60;
                    result2 = result1 + result2;
                }
                if(contador == 3){
                    result3 = scanner.nextInt();
                    result3 = result2 + result3;
                }
                if (contador == 3){
                    contador = 0;
                    if (contador1 == 0){
                        //System.out.println("contador1 " + contador1 + " resul3 " + result3);
                        date1 = result3;
                        contador1++;
                    }else if (contador1 == 1){
                        date2 = result3-date1;
                        //System.out.println("diff " + date2);
                        days = date2 / (60 * 60 * 24);
                        System.out.print("(" + days);
                        days = date2 % (60 * 60 * 24);
                        //System.out.println("Date : " + days);
                        hour = days / (60 * 60);
                        System.out.print(" " + hour);
                        hour = days % (60 * 60);
                        //System.out.println("Date : " + hour);
                        min = hour / (60);
                        System.out.print(" " + min);
                        sec = hour % (60);
                        System.out.println(" " + sec + ")");
                        contador1 = 0;
                    }


                    //System.out.println(result3);
                }
                else contador++;


            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }
    //--------------------------------------------
    public static void LinearFunction(){
        String nombre = "LinearFunction.txt";
        int x1, y1, x2, y2, contador = 0, a, b;
        try (Scanner scanner = new Scanner(new File(nombre))) {

            while (scanner.hasNext()){
                if (contador == 0)scanner.nextInt();
                if (contador > 1){
                    x1 = scanner.nextInt();
                    y1 = scanner.nextInt();
                    x2 = scanner.nextInt();
                    y2 = scanner.nextInt();
                    a = (y2 - y1) / (x2 - x1);
                    b = ((x2 * y1) - (x1 * y2)) / (x2 - x1);
                    System.out.println("(" + a + " " + b + ")");
                }
                contador++;
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    //--------------------------------------------
    public static void CollatzSequence(){
        String nombre = "CollatzSequence.txt";
        int contador = 0, xnext, nsteps = 0;
        List<Integer> list = new ArrayList<>();
        try (Scanner scanner = new Scanner(new File(nombre))) {
            while(scanner.hasNext()){
                if (contador == 0)scanner.nextInt();
                if (contador > 1 ){
                    list.add(scanner.nextInt());
                }
                contador++;
            }
            for (Integer num: list) {
                //System.out.println(num);
                nsteps = Sequence(num);
                System.out.println(nsteps);
            }
            //System.out.println("list : " + list);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    public static int Sequence(int number){
        int result = 0, xnext = number, nsteps = 0;
        while (xnext != 1){
            if (xnext % 2 == 0){
                xnext = xnext / 2;
                //System.out.println("Xnext par: " + xnext);
                if(xnext != 1)nsteps++;
                else return nsteps + 1;
            }else {
                xnext = 3 * xnext + 1;
                //System.out.println("Xnext impar: " + xnext);
                if(xnext != 1)nsteps++;
                else return nsteps + 1;
            }
        }
        return nsteps + 1;
    }
    //--------------------------------------------
    public static void ArrayCounters(){
        String nombre = "arraycounters.txt";
        int contador = 0;
        List<Integer> list = new ArrayList<>();
        HashMap<Integer, Integer> hashMap = new HashMap<>();

        try (Scanner scanner = new Scanner(new File(nombre))) {
            while(scanner.hasNext()){
                //just for skip the first line
                if (contador <= 1)scanner.next();
                if(contador > 1)list.add(scanner.nextInt());
                contador++;
            }
            for (Integer num: list) {
                hashMap.put(num, Collections.frequency(list,num));
                //System.out.println("Num " + num  + " " + Collections.frequency(list,num));
            }
            //System.out.println(hashMap.values());
            hashMap.forEach((k,v) -> System.out.println(v));
            //System.out.println(list);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }
    //--------------------------------------------
    public static void ReverseString(){
        String nombre = "ReverseString.txt";
        StringBuilder line = new StringBuilder();
        try (Scanner scanner = new Scanner(new File(nombre))) {
            System.out.println(line.append(scanner.nextLine()).reverse());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    //--------------------------------------------
    public static void CheckSum(){
        String nombre = "CheckSum.txt";
        long result = 0, num = 0;
        long limit = 10000007;
        int seed = 113;
        boolean flag = false;
        try(Scanner scanner = new Scanner(new File(nombre))){
            while (scanner.hasNext()) {
                num = scanner.nextLong();
                if(flag){
                    result = (result + num) * seed;
                    if (result > limit) {
                        result = result % limit;
                        //System.out.println(result);
                    }
                }
                flag = true;
            }
            System.out.println(result);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    //--------------------------------------------
    public static void AverageArray(){
        String nombre = "AverageArray.txt", linea;
        double sum, sum2 = 0.0, result;
        //List<Integer> list1 = new ArrayList<Integer>();
        try(Scanner scanner = new Scanner(new File(nombre))){
            while (scanner.hasNext()){
                linea = scanner.nextLine();
                if(linea.split(" ").length > 1){
                    //System.out.println(linea.split("")[0]);
                    //System.out.println(linea.split(" ").length-1);
                    for (int i = 0; i < linea.split(" ").length; i++){
                        sum = Double.parseDouble(linea.split(" ")[i]);
                        //System.out.println(" sum " + sum + " i " + i);
                        sum2 = sum + sum2;
                        //System.out.println(" sum2 " + sum2);
                    }
                    result = sum2/(linea.split(" ").length - 1.0);
                    sum2 = 0.0;
                    System.out.println(Math.round(result));
                    //BigDecimal bd = new BigDecimal(result).setScale(0, RoundingMode.HALF_EVEN);
                    //System.out.println(bd.intValue());
                    //System.out.println((int)Math.floor(result));

                }
            }

        }catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }
    //--------------------------------------------
    public static void WeightedSumDigit(){
        String nombre = "WeightedSumDigits.txt", linea;
        int contador, sum, sum2 = 0, j = 0;
        try (Scanner scanner = new Scanner(new File(nombre))) {

            while(scanner.hasNext()){
                linea = scanner.nextLine();

                if(linea.split(" ").length > 1) {
                    for (int i = 0; i < linea.split(" ").length; i++) {
                        contador = linea.split(" ")[i].toCharArray().length;
                        //System.out.println(Integer.toString(linea.split(" ")[i].toCharArray()[0]));
                        //convierto el numero del arreglo de estring obtenido con split y ese numero lo convierto
                        //a un array de caracteres donde cada posicion es un digito del numero grande
                        char [] NumAsArray = linea.split(" ")[i].toCharArray();
                        System.out.println(sum = sumD(contador, NumAsArray));

                    }
                }

            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    public static int sumD(int contador, char [] numero){
        int sum, sum2 = 0, toNum;
        for(int i = 0; i < contador; i++){
            //le resto al numero en codigo ascii el 'o' en condigo ascii para obtener el numero decimal real

            toNum = numero[i] -'0';
            sum = toNum * (i+1);
            sum2 = sum + sum2;
        }
        return sum2;
    }
    //--------------------------------------------
    public static void Triangles(){
        String nombre = "Triangles.txt", linea;
        int A = 0, B = 0, C = 0, sum1 = 0;

        try (Scanner scanner = new Scanner(new File(nombre))) {
            while (scanner.hasNext()){
                linea = scanner.nextLine();

                if(linea.split(" ").length > 1){
                    //System.out.println(linea.split(" ").length);
                    A = Integer.parseInt(linea.split(" ")[0]);

                    B = Integer.parseInt(linea.split(" ")[1]);
                    C = Integer.parseInt(linea.split(" ")[2]);
                    //System.out.println(" A " + A + " B " + B + " C " + C);
                    //System.out.println(sum1);
                    if (A > B - C && A < B + C && B > A - C && B < A + C && C > A - B && C < A + B){
                        System.out.println("1");
                    }
                    else System.out.println("0");
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    //--------------------------------------------
    public static void ArithmeticProgression(){
        String nombre = "ArithmeticProgression.txt", linea;
        int A = 0, B = 0, N = 0, result = 0, result2 = 0;

        try (Scanner scanner = new Scanner(new File(nombre))) {

            while(scanner.hasNext()){
                linea = scanner.nextLine();
                //System.out.println(linea.split(" ").length);
                if(linea.split(" ").length > 1 ){
                    A = Integer.parseInt(linea.split(" ")[0]);
                    B = Integer.parseInt(linea.split(" ")[1]);
                    N = Integer.parseInt(linea.split(" ")[2]);

                    for(int i = 0; i < N;i++){

                        result = (A + B*i);
                        result2 = result + result2;
                        //System.out.println(result);
                    }
                    System.out.println(result2);
                    result2 = 0;
                }
            }
        } catch (FileNotFoundException e) {

            e.printStackTrace();
        }

    }
    //--------------------------------------------
    public static void BMI(){
        String nombre = "BodyMass.txt", linea, result = "";
        int n0 = 0;
        double n1, bmi;
        try (Scanner scanner = new Scanner(new File(nombre))) {
            while (scanner.hasNext()){
                linea = scanner.nextLine();

                if (linea.split(" ").length > 1) {

                    n0 = Integer.parseInt(linea.split(" ")[0]);

                    n1 = Double.parseDouble(linea.split(" ")[1]);

                    bmi = n0 / (n1 * n1);

                    if(bmi < 18.5)result = "under";
                    if(bmi >= 18.5 && bmi < 25.0)result = "normal";
                    if(bmi >= 25.0 && bmi < 30.0)result = "over";
                    if(bmi >= 30.0)result = "obese";
                    System.out.println(result);
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    //--------------------------------------------
    public static void MedioTres(){
        String nombre = "MediadeTres.txt", linea;
        int n0 = 0, n1 = 0, n2 = 0, media = 0,  contador = 0;
        try (Scanner scanner = new Scanner(new File(nombre))) {
            while (scanner.hasNext()){
                linea = scanner.nextLine();

                if( contador >= 0 && contador <= 4) {
                    //System.out.println("Linea--> " + linea);
                    if (linea.split(" ").length > 1) {
                        n0 = Integer.parseInt(linea.split(" ")[0]);
                        //System.out.println(linea.split(" ").length);
                        n1 = Integer.parseInt(linea.split(" ")[1]);
                        //System.out.println(n1);
                        n2 = Integer.parseInt(linea.split(" ")[2]);
                        //System.out.println("n0: "+ n0 + " n1: "+ n1 + " n2 " + n2);

                        if(n0 > n1 && n0 > n2){
                            if (n1 > n2)media = n1;
                            else media = n2;
                        }
                        if(n0 < n1 && n0 < n2){
                            if(n1 > n2)media = n2;
                            else media = n1;
                        }
                        if(n0 > n1 && n0 < n2)media = n0;
                        if(n0 < n1 && n0 > n2)media = n0;

                        System.out.println(media);

                    }

                }
                contador++;
                if (contador == 3)contador = 0;
                //System.out.println(Integer.parseInt(linea.split(" ")[0]));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }
    //--------------------------------------------
    public static void sumar_digitos(){
        String nombre = "sumarDigitos.txt";
        List<String> lista1 = new ArrayList<>();
        lista1 = Cargar(nombre).collect(Collectors.toList());
        System.out.println(lista1);
        int cantidadLineas = 0, resultadoSuma = 0, largo = 0, resultadoNumeros = 0;

        for(String linea: lista1){
            try {
                cantidadLineas = Integer.parseInt(linea);
            }catch (NumberFormatException e){
                resultadoSuma = Integer.parseInt(linea.split(" ")[0]) * Integer.parseInt(linea.split(" ")[1]) + Integer.parseInt(linea.split(" ")[2]);
                char [] asd = Integer.toString(resultadoSuma).toCharArray();
                largo = Integer.toString(resultadoSuma).length();
                //System.out.println(asd);
                for(int i = 0; i < largo; i++){
                    int numer = asd[i] - '0';
                    resultadoNumeros = resultadoNumeros + numer;
                }
                System.out.println(resultadoNumeros);
                resultadoNumeros = 0;
            }

        }

    }

    //--------------------------------------------
    public static void contar_vocales(){
        String nombre = "ContarVocales.txt";
        List<String> lista1 = new ArrayList<String>();
        lista1 = Cargar(nombre).collect(Collectors.toList());

        //System.out.println(lista1);
        int contador = 0, saltar = 0;
        for (String linea: lista1) {
            if(saltar != 0) {
                for (int i = 0; i < linea.length(); i++) {
                    if (linea.toLowerCase().toCharArray()[i] == 'a'
                            || linea.toLowerCase().toCharArray()[i] == 'e'
                            || linea.toLowerCase().toCharArray()[i] == 'i'
                            || linea.toLowerCase().toCharArray()[i] == 'o'
                            || linea.toLowerCase().toCharArray()[i] == 'u'
                            || linea.toLowerCase().toCharArray()[i] == 'y') {
                        contador = contador + 1;
                    }
                }
                System.out.println(contador);
            }
            saltar = 1;
            contador = 0;

        }
    }
    //--------------------------------------------
    public static void fahrenheit_celsius(){
        String nombre = "grados.txt";
        //cargar los datos de un archivo con Stream string
        List<String> lista1 = new ArrayList<String>();
        lista1 = Cargar(nombre).collect(Collectors.toList());


        double celcius = 0.0;
        String convertir_int = lista1.toString();
        String strGrados = convertir_int.replaceAll("[]|\\[]","");
        String[] arregloGrados = strGrados.split(" ");
        for (int i = 1; i < arregloGrados.length;i++){
            //BigDecimal bd = new BigDecimal(resultado).setScale(0, RoundingMode.HALF_UP);
            //System.out.println(bd.intValue());
            //System.out.println("°F "+arregloGrados[i]);
            celcius = (Double.parseDouble(arregloGrados[i]) - 32)/1.8;
            BigDecimal bd = new BigDecimal(celcius).setScale(0, RoundingMode.HALF_UP);
            System.out.println(bd.intValue());
        }
    }
    //--------------------------------------------
    public static void redondear(){
        String archivoLeido = "redondear.txt";
        List<String> lista1 = new ArrayList<String>();
        double resultado = 0.0;
        try (Stream<String> stream1 = Files.lines(Paths.get(archivoLeido))) {
            lista1 = stream1.collect(Collectors.toList());

            for (String linea:lista1) {
                String [] convertir_int = linea.split(" ");
                //System.out.println(convertir_int.length);
                //System.out.println(convertir_int[0]);
                if(convertir_int.length > 1){
                    resultado = (double) Integer.parseInt(convertir_int[0])/(double) Integer.parseInt(convertir_int[1]);
                    //System.out.println(resultado);
                    BigDecimal bd = new BigDecimal(resultado).setScale(0, RoundingMode.HALF_UP);
                    System.out.println(bd.intValue());
                }

            }


        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    //--------------------------------------------
    public static void maximun_array(){
        String archivoLeido = "lista_numero.txt";
        List<String> lista1 = new ArrayList<String>();
        int resultado = 0, maximo = 0;
        try (Stream<String> stream1 = Files.lines(Paths.get(archivoLeido))) {
            lista1 = stream1.collect(Collectors.toList());

            for (String linea:lista1) {
                String [] convertir_int = linea.split(" ");
                System.out.println(convertir_int.length);
                resultado = Integer.parseInt(convertir_int[0]);
                maximo = Integer.parseInt(convertir_int[0]);
                for(int i = 0; i < convertir_int.length;i++){

                    if(resultado > Integer.parseInt(convertir_int[i])){

                        resultado = Integer.parseInt(convertir_int[i]);
                    }
                    if(maximo < Integer.parseInt(convertir_int[i])){
                        maximo = Integer.parseInt(convertir_int[i]);
                    }
                }

            }
            System.out.println(maximo + " " + resultado);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //--------------------------------------------
    public static void minimo_tres(){
        String nombre = "test_stream3.txt";
        int a, b, c;
        try (Scanner scanner = new Scanner(new File(nombre))) {
            scanner.nextLine();
            while (scanner.hasNext()){
                a = scanner.nextInt();
                b = scanner.nextInt();
                c = scanner.nextInt();
                if (a < b){
                    b = a;
                }
                if(b < c){
                    c = b;
                }
                System.out.println(c);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    //--------------------------------------------
    public static void minimo(){
        String archivoLeido = "test_stream.txt";
        List<String> lista1 = new ArrayList<String>();

        try (Stream<String> stream1 = Files.lines(Paths.get(archivoLeido))) {
            lista1 = stream1.collect(Collectors.toList());
            //Iterator<String> iterador = lista1.iterator();
            //lista1 = stream1.collect(Collectors.toList());
            //prueba1 = stream1.toArray(String[]::new);
            //System.out.println(stream1.toArray());
            //System.out.println(Arrays.toString(prueba1));
            //System.out.println(lista1.get(1));
            for (String linea:lista1) {

                String [] convertir_int = linea.split(" ");

                if(convertir_int.length == 1){
                    System.out.println("cantidad de lineas a comparar: "+linea);

                }else{

                    if(Integer.parseInt(convertir_int[0]) > Integer.parseInt(convertir_int[1])){

                        System.out.println(Integer.parseInt(convertir_int[1]));
                    }else{
                        System.out.println(Integer.parseInt(convertir_int[0]));
                    }
                    //System.out.println(lista1.iterator());
                    //" ".split(linea.replace(" ", ","));
                    //prueba2 = Arrays.toString(linea.split(" "));

                    //System.out.println(Arrays.toString(linea.split(" ")));
                    //System.out.println(linea);
                    //prueba2 = linea.split(" ");
                    //System.out.println(prueba2);
                    //System.out.println(linea.replace(" ",","));
                }
            }
            //System.out.println(prueba2[1]);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    //--------------------------------------------
    public static void suma_loop(){
        //sumas en loop
        String nombre = "SumsLoop.txt";
        int result, a = 0, b;

        try (Scanner scanner = new Scanner(new File(nombre))) {
            scanner.nextLine();
            while (scanner.hasNext()){

                a = scanner.nextInt() + scanner.nextInt();
                System.out.println(a);
                //scanner.nextLine();
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    //--------------------------------------------
    public static void sumas_loop(){
        //suma loop
        int result = 0, n;
        String nombre = "SumLoop.txt";
        try (Scanner scanner = new Scanner(new File(nombre))) {
            scanner.nextLine();
            while (scanner.hasNext()){
                n = scanner.nextInt();
                result = result + n;
            }
            System.out.println(result);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    //--------------------------------------------
    public static void sumar(int a,int b){
        //sumar
        System.out.println(a + b);
    }

}
