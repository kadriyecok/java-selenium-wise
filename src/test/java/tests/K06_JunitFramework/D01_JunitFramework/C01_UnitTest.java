package tests.K06_JunitFramework.D01_JunitFramework;

import java.util.Random;

public class C01_UnitTest {

    public static void main(String[] args) {

        // verilen bir sayi 3 basamakli pozitif bir sayi ise true
        //                  3 basamakli pozitif bir sayi degilse false
        // donduren bir method olusturun

        System.out.println(ucBasamakliPozitifSayiKontolEt(100));
        System.out.println(ucBasamakliPozitifSayiKontolEt(765));
        System.out.println(ucBasamakliPozitifSayiKontolEt(-100));
        System.out.println(ucBasamakliPozitifSayiKontolEt(1145));

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

    public static void UygunDegerTesti(){
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


    }

