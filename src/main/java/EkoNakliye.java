import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class EkoNakliye {

    public static void main(String[] args) {
        int isMiktari = 50;
        int minTonaj = 30;
        int maxTonaj = 35;

        int toplamTonaj = girisAlToplamTonaj();

        List<Integer> tonajListesi = rastgeleDagit(toplamTonaj, isMiktari, minTonaj, maxTonaj);

        int toplamDagitilanTonaj = 0;
        for (int i = 0; i < tonajListesi.size(); i++) {
            int tonaj = tonajListesi.get(i);
            toplamDagitilanTonaj += tonaj;

            int aracNumarasi = i + 1;
            if (tonaj == 0) {
                System.out.println("Araç " + aracNumarasi + ": İş verilmedi");
            } else {
                System.out.println("Araç " + aracNumarasi + " - Tonajı: " + tonaj + " Ton");
            }
        }

        int eksikTonaj = toplamTonaj - toplamDagitilanTonaj;
        if (eksikTonaj > 0) {
            int sonrakiArac = tonajListesi.size() + 1;
            System.out.println("Toplam tonajı karşılamayan " + eksikTonaj + " Ton iş sıradaki araçlara dağıtılamadı");
            System.out.println("Sıradaki araç: " + sonrakiArac);
        }
    }

    public static int girisAlToplamTonaj() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Toplam tonajı girin: ");
        int toplamTonaj = scanner.nextInt();
        scanner.close();
        return toplamTonaj;
    }

    public static List<Integer> rastgeleDagit(int toplamTonaj, int isMiktari, int minTonaj, int maxTonaj) {
        List<Integer> tonajListesi = new ArrayList<>();
        Random random = new Random();

        int kalanTonaj = toplamTonaj;
        for (int i = 0; i < isMiktari; i++) {
            int tonaj = 0;
            if (kalanTonaj >= minTonaj) {
                tonaj = random.nextInt(Math.min(kalanTonaj - (isMiktari - i - 1) * minTonaj, maxTonaj - minTonaj + 1)) + minTonaj;
                kalanTonaj -= tonaj;
            }
            tonajListesi.add(tonaj);
        }



        return tonajListesi;
    }
}
