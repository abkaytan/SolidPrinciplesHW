package liskovSubstitution;

public class PlayingFootball {
}
/**
 * Özet:
 * Striker ve GoalKeeper Player sınıfından türetilmiştir. Player sınıfında iki tip çıktı alınır. KickBall , KeepBall . Ancak
 * Striker KeepBall durumu için hata fırlatmalı kısacası Player ' a göre farklı tipte bir sonuç oluşturacak.
 *
 * Ancak Player2 sınıfı için sadece KickBall metodu tanımladık ve Striker ile GoalKeeper sadece bu metodu override etti. GoalKeeper
 * kendine has özellik olan KeepBall 'ı farklı bir interfaceden edindi. Bu yeni durumda GoalKeeper da Striker da Player2 sınıfı yerine
 * kullanıldıkları zaman KickBall ile topa vuracaklar ve Player2 sınıfı ile aynı tipte çıktı verecekler.
* */
// --> Liskov Substitution prensibine uygun olmayan durum
abstract class Player{
    public void KickTheBall(){}
    public void KeepTheBall(){}
}

class Striker extends Player{
    @Override
    public void KickTheBall(){throw new RuntimeException();}   // Striker ihtiyacı olmayan bu metodu içinde bulundurmaktadır.
                                                               // Player üst sınıfı içinde anlamlı olan metot burada
                                                               // anlamsız olmaktadır. Hatta Striker bu metodu kullanırsa hata fırlatmak gerekecek.
                                                               // Yani üst sınıfından farklı tipte bir sonuç verecek. LSP ' e ters bir durum.

    @Override
    public void KeepTheBall(){}
}

class GoalKeeper extends Player{
    @Override
    public void KickTheBall(){}
    @Override
    public void KeepTheBall(){}
}


// --> Liskov Substitution prensibi uygulanmış hal
abstract class Player2{
    public void KickTheBall(){}
}

class Striker2 extends Player2{
    @Override
    public void KickTheBall(){}      // Striker2 üst sınıfınyla aynı tipte bir çıktı verir
}
interface IKeepBall{
    public void KeepTheBall2();
}
class GoalKeeper2 extends Player2 implements IKeepBall{
    @Override
    public void KickTheBall(){}            // GoalKeeper üst sınıfınyla aynı tipte bir çıktı verir.
    @Override
    public void KeepTheBall2(){}           // Ekstra özellik için IKeepBall interface'ini implement etti. Üst sınıfın Player2
                                           // yerine kullanıldığı zaman bu metot zaten üst sınıfının metodu değil ve çıktı vermez
                                           // KickTheBall() metoduda üst sınıfına paralel bir çıktı vereceği için GoalKeeper2 üst sınıfı
                                           // Player2 ' den farklı sonuca çıkacak bir çıktı vermeyecek.
}


