package tests.K06_JunitFramework.D01_JunitFramework;

import java.util.Random;

public class C01_UnitTest {

    public static void main(String[] args) {

        // verilen bir sayi 3 basamakli pozitif bir sayi ise true
        //                  3 basamakli pozitif bir sayi degilse false
        // donduren bir method olusturun

        uygunDegerTesti();
        uygunOlmayanDegerTesti1();
        uygunOlmayanDegerTesti2();
        uygunOlmayanDegerTesti3();

    }

    public static boolean ucBasamakliPozitifSayiKontolEt(int sayi){

            if (sayi>= 100 && sayi<= 999) return true;
            else return false;
        }
        /*
            bu method'u test etmek icin true veya false dondurmesi gereken
            sayi araliklarindan farkli testler yapmaliyiz

            ornegin
            - verilen sayi pozitif 3 basamakli sayi ise expectedSonuc = true
            - verilen sayi pozitif 100'den kucuk bir sayi ise expectedSonuc = false
            - verilen sayi pozitif 999'dan buyuk bir sayi ise expectedSonuc = false
            - verilen sayi negatif bir sayi ise expectedSonuc = false

         */

    public static void uygunDegerTesti(){
        // - verilen sayi pozitif 3 basamakli sayi ise expectedSonuc = true
        // 100 ile 999 arasi

        Random random = new Random();
        int sayi = random.nextInt(899) + 100;

        boolean expectedSonuc = true;
        boolean actualSonuc =ucBasamakliPozitifSayiKontolEt(sayi);

        if (expectedSonuc == actualSonuc){
            System.out.println("Uygun deger testi PASSED");
        } else System.out.println("Uygun deger testi FAILED");
    }

    public static void uygunOlmayanDegerTesti1(){
        //- verilen sayi pozitif 100'den kucuk bir sayi ise expectedSonuc = false
        // 1 - 99

        Random random = new Random();
        int sayi = random.nextInt(98) + 1;

        boolean expectedSonuc = false;
        boolean actualSonuc = ucBasamakliPozitifSayiKontolEt(sayi);

        if (expectedSonuc == actualSonuc){
            System.out.println("Uygun olmayan deger testi1 PASSED ");
        } else System.out.println("Uygun olmayan deger testi1 FAILED");
    }


    public static void uygunOlmayanDegerTesti2(){
        //- verilen sayi pozitif 999'dan buyuk bir sayi ise expectedSonuc = false            // 1 - 99
        // 1000 - ...
            Random random = new Random();
            int sayi = random.nextInt(100000000) + 1000;

            boolean expectedSonuc = false;
            boolean actualSonuc = ucBasamakliPozitifSayiKontolEt(sayi);

            if (expectedSonuc == actualSonuc){
                System.out.println("Uygun olmayan deger testi2 PASSED ");
            } else System.out.println("Uygun olmayan deger testi2 FAILED");
        }

    public static void uygunOlmayanDegerTesti3(){
        //- verilen sayi negatif bir sayi ise expectedSonuc = false
        // ... - 0
        Random random = new Random();
        int sayi = -1 * random.nextInt(100000000) ;

        boolean expectedSonuc = false;
        boolean actualSonuc = ucBasamakliPozitifSayiKontolEt(sayi);

        if (expectedSonuc == actualSonuc){
            System.out.println("Uygun olmayan deger testi3 PASSED ");
        } else System.out.println("Uygun olmayan deger testi3 FAILED");
    }


}

