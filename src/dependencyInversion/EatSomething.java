package dependencyInversion;

import java.util.List;

public class EatSomething {
}
/**
 * Özet:
 * Akşam yemeği yeme fonksiyonumuzu DinnerTime sınıfı yönetsin. Salad ve Meat sınıflarından nesneler üretir ve tüketir.
 * Ancak DinnerTime bu durumda alt sınıflarına çok bağımlıdır. DinnerTime sınıfı eatDinner() metodu içinde sadece iki
 * alt sınıfın ürünlerini tüketmeye uygun bir durum var. Başka şeyleri de bazı akşam yemeklerinde yemek istersek yemek çeşidi
 * sınıflarına olan bağımlılıktan DinnerTime ı kurtarmamız gerekir, bunun için de EatEverything arayüzünü sınıflar ve DinnerTime
 * arasına ekleyecez. EatEverything interface'i altında eatThem() metodunu yemek sınıflarımızda override edecez. Ve DinnerTime
 * Extended sınıfında bu yeni sınıfları List<EatEverything> dinnerList içerisinde alarak tüketebileceğiz. Dikkat edilmesi gereken
 * nokta dinnerList' e farklı bir yemek eklemek istersek EatEverything interaface'ini implemente ederek Bread sınıfı üretiriz ve
 * bu sınıftan bir objeyi rahatlıkla dinnerList'e ekleyebiliriz. Yani üst sınıf(DinnerTimeExtended) a müdahale etmeden alt sınıfların
 * arasına yeni bir yemek ekledik. Bu sayede üst sınıf alt seviye sınıflardan bir ara interface yardımı ile bağımlılıklarından
 * kurtuldu yani dependency inversion prensibine göre bu bağımlılığı bir soyut katman üzerine devretti.
 * */
//-->
class Salad {
    public void eatSalad() {
        //prepare salad
    }
}
class Meat {
    public void eatMeat() {
        //prepare meat
    }
}
class DinnerTime {

    private Salad salad = new Salad();
    private Meat meat = new Meat();

    public void eatDinner() {    // Meat ve Salad sınıflarına bağımlı bir DinnerTime sınıfı metodu. Farklı bir yemek çeşidi
                                 // mesela ekmek eklemek istersek buraya bread.eatBread() gibi bir ekleme yapmamız gerekir.
        salad.eatSalad();        // Ancak alt sınıflarda yapılacak bir değişikliğe bu üst sınıf bağımlı olmamalı ve bu bağımlılığı devretmeli .
        meat.eatMeat();
    }
}
//*****************************
//--> Dependency Inversion uygulanmış yol
interface EatEverything {       // bağımlılığın devredileceği interface
    void eatThem();
}

class Salad1 implements EatEverything {    // eatThem metodu içerisine Salad ekler
    @Override
    public void eatThem() {
        eatSalad();
    }
    private void eatSalad() {
        //prepare Salad
    }
}
class Meat2 implements EatEverything {  // eatThem metodu içerisine Meat ekler
    @Override
    public void eatThem() {
        eatMeat();
    }
    private void eatMeat() {
        //prepare Meat
    }
}
class DinnerTimeExtended {
    private List<EatEverything> dinnerList;   // dinnerList önüne geleni yer. Bu akşam meat ve salad
                                              // yarın akşam meat ve bread(EatEverything interface'ini implemente
                                              // eden bir Bread sınıfı yeterli. DinnerTimeExtended'a müdahale etmeye gerek yok geleni artık yer.)

    public DinnerTimeExtended(List<EatEverything> dinnerList) {
        this.dinnerList = dinnerList;
    }
    public void eater() {
        for (EatEverything eatIt : dinnerList) {
            eatIt.eatThem();
        }
    }
}