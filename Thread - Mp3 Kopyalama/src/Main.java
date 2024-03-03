import java.io.*;
import java.util.ArrayList;

public class Main {
    private static ArrayList<Integer> icerik = new ArrayList<Integer>();

    public static void dosyaOku(){

        try {
            FileInputStream in = new FileInputStream("marş.mp3");//okuyacağımız dosya hazır

            int oku;

            while ((oku = in.read()) != -1){

                icerik.add(oku);

            }

        } catch (FileNotFoundException e) {

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
    public static void kopyala (String dosyaismi){

        try {
            FileOutputStream out = new FileOutputStream(dosyaismi);
            // yeni dosya oluşturup yazdık

            for (int deger : icerik){

                out.write(deger);

            }

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        //FileOutputStream yazmak içim kullanılır



    }


    public static void main(String[] args) {


        dosyaOku();



        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                kopyala("marş2.mp3");
            }
        });
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                kopyala("marş3.mp3");
            }
        });
        Thread thread3 = new Thread(new Runnable() {
            @Override
            public void run() {
                kopyala("marş4.mp3");
            }
        });

        Thread thread4 = new Thread(new Runnable() {
            @Override
            public void run() {
                kopyala("marş5.mp3");
            }
        });
        Thread thread5 = new Thread(new Runnable() {
            @Override
            public void run() {
                kopyala("marş6.mp3");
            }
        });
        Thread thread6 = new Thread(new Runnable() {
            @Override
            public void run() {
                kopyala("marş7.mp3");
            }
        });

        Thread thread7 = new Thread(new Runnable() {
            @Override
            public void run() {
                kopyala("marş8.mp3");
            }
        });
        Thread thread8 = new Thread(new Runnable() {
            @Override
            public void run() {
                kopyala("marş9.mp3");
            }
        });
        Thread thread9 = new Thread(new Runnable() {
            @Override
            public void run() {
                kopyala("marş10.mp3");
            }
        });
        Thread thread10 = new Thread(new Runnable() {
            @Override
            public void run() {
                kopyala("marş11.mp3");
            }
        });







        long baslangic = System.currentTimeMillis(); //şuanki zaman mili saniye
        thread1.start();
        thread2.start(); // threadleri biklgisayar kontrol ettiği process ler arası geçişler vs düşüyo tam 7 olmadı
        thread3.start();
        thread5.start();
        thread6.start();
        thread7.start();
        thread8.start();
        thread9.start();
        thread10.start();

        try {
            thread1.join(); // join metoduyla main threadimin threadlerimin bitmesini bekliyo
            thread2.join(); //
            thread3.join();
            thread5.start();
            thread6.start();
            thread7.start();
            thread8.start();
            thread9.start();
            thread10.start();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        long bitis = System.currentTimeMillis();


         // başlangıçla bitişi çıkartırsan kopyalama süresini verir
        //çünkü kodun yazıldığı yere kadar zamanı ölçüyor System.currentTimeMillis() kodu .
        //bize milisaniye verir bine bölersek saniyeyi buluruz

        System.out.println("Üç dosyanın kopyalanma süresi : " + ((bitis - baslangic)/1000) + " saniye sürmüştür.");


    }
}