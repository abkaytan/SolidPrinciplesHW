package interfaceSegregetion;

public class Animals {
}
/**
 * Özet:
 * Interface segregation aslında Single Responsibily ile benzer mantıktadır. Single Responsibility sınıflar ile ilgiliyken
 * interface segregation interfacelerin gereksiz şekilde şişirilmesine karşıdır. Interfaceler ihtiyaç olan işe göre özelleşen
 * yapılarda olmalıdır. Bu sayede interfaceleri implemente eden sınıflar gereksiz implementasyonlardan kurtulmuş da olurlar.
 * */
// ---> Uygun olmayan bir interface ve implementasyon örnekleri
interface Animal {  // birbirinden farklı işlevlerdeki metotlar aynı interface' e eklenmiş. Bu sebeble animal interface' inden
                    // implemente edilen bird, cat , dog gibi sınıflar kullanmayacakları metotları gövdesiz olarak override etmek
                    // zorunda kaldılar.
    void fly();
    void run();
    void bark();
}
class Bird implements Animal {
    public void bark() {/* işlevsiz */}                             // --> gövdesiz metot override işlemi
    public void run() {System.out.println(/* işlevsiz */);}         // --> gövdesiz metot override işlemi
    public void fly() {
        System.out.println("uç minik kuş..");
    }
}
class Cat implements Animal {
    public void fly() {/* işlevsiz */}          // --> gövdesiz metot override işlemi
    public void bark() {/* işlevsiz */}          // --> gövdesiz metot override işlemi
    public void run() {
        System.out.println("kedi koş..");
    }
}
class Dog implements Animal {
    public void fly() {/* işlevsiz */}         // --> gövdesiz metot override işlemi
    public void bark() {
        System.out.println("hav hav..");
    }
    public void run() {
        System.out.println("köpek koş..");
    }
}

//******************************************************
// ---> Interface Segregation'a uygun olan bir interface ve implementasyon örneği
interface Flyable {                     // --> işlevlerine göre özelleşmiş interface'ler
    void fly();
}
interface Runnable {                   // --> işlevlerine göre özelleşmiş interface'ler
    void run();
}
interface Barkable {                   // --> işlevlerine göre özelleşmiş interface'ler
    void bark();
}
class Bird2 implements Flyable {          // --> ihtiyacı olan interfaceleri implemente eden sınıflar, gereksiz implementasyon yok
    public void fly() {
        System.out.println("uçan kuş.");
    }
}
class Dog2 implements Runnable, Barkable {     // --> ihtiyacı olan interfaceleri implemente eden sınıflar, gereksiz implementasyon yok
    public void bark() {
        System.out.println("hav hav.");
    }
    public void run() {
        System.out.println("köpek koş.");
    }
}