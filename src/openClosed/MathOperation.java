package openClosed;

import java.util.List;
/**
 * Özet:
 * Örnekte iki farklı MathOperation sınıfı var. Uygulamayı ilk yazdığımızda sadece toplama ihtiyacı olduğu için
 * MathOperation sınıfı işlemlerimizi yapıyordu ancak çıkartma işleme eklemek istediğimizde MathOperation sınıfını
 * modifiye etmemiz gerekiyor. Ancak bu openClosed prensibine ters bir durum. MathOperationExtended sınıfında
 * sadece operate methodu kullanılıyor. Bu metod NumbersI interface' in den türeyen çeşitli işlemler için hangi işlemse
 * o işlemin olduğu alt sınıfın içinde metot tanımlandı. Yani alt sınıflardan oluşturulan nesneler için metodun işleyişi
 * de sınıfına göre olacak. Bölme işlemi de eklmek istersek MathOperationExtended sınıfını modifiye etmemize gerek yok.
 * Sınıflarımızı modifiye etmek yerine genişleterek yani Bölmeİşlem sınıfını ekleyerek istediğimiz ek fonksiyonu da
 * kazandırabiliriz.
* */

//****************************************************
// Open-Closed ' a uygun olmayan mimari buradan başlıyor.
public class MathOperation {
    public double calculateAddition(List<Numbers> numbers) {
        double total = 0;
        for (Numbers numb : numbers) {
            total += (numb.getFirstNumber() + numb.getSecondNumber()); // toplama işlemi direkt olarak tanımlanmış çıkarma işlemi için
                                                                       // modifiye etmemiz gerekiyor. openClosed ' a ters.
        }
        return total;
    }
}

class Numbers {
    private double firstNumber;
    private double secondNumber;

    public Numbers(double firstNumber, double secondNumber) {
        this.firstNumber = firstNumber;
        this.secondNumber = secondNumber;
    }
    public double getFirstNumber() {
        return firstNumber;
    }
    public double getSecondNumber() {
        return secondNumber;
    }
}
//****************************************************
/// Open - Closed ' a uygun mimari buradan başlıyor...
class MathOperationExtended {
    public double calculateArea(List<NumbersI> numbersList) {
        double result = 0;
        for (NumbersI numbers : numbersList) {
            result += numbers.operate();           // Addition ve Substraction için aynı metodun iki farklı işleyişi var.
                                                   // 3. bir işlem eklemek istersek burayı modifiye etmeyiz, NumbersI interface' inden
                                                   // yeni bir bölme işlem sınıfı oluşturmamız yeterli. Projede şu haliyle yeni bir fonksiyon
                                                   // kazandırmak için modifiye etmeye ihtiyaç yok.
        }
        return result;
    }
}

interface NumbersI {
    double operate();    // ortak metot adı sınıfların içinde kendi fonksiyonuna uygun işlerlik kazanacak
}

class Addition implements NumbersI {   // Addition sınıfı ile operate metodunu override ederek toplama fonksiyonu kazandırdık.
    private double firstNumber;
    private double secondNumber;

    public Addition(double firstNumber, double secondNumber) {
        this.firstNumber = firstNumber;
        this.secondNumber = secondNumber;
    }

    public double getFirstNumber() {
        return firstNumber;
    }

    public double getSecondNumber() {
        return secondNumber;
    }

    @Override
    public double operate() {
        return (firstNumber + secondNumber);
    }
}

class Subsraction implements NumbersI { // Substraction sınıfı ile operate metodunu override ederek çıkarma fonksiyonu kazandırdık.
    private double firstNumber;
    private double secondNumber;

    public Subsraction(double firstNumber, double secondNumber) {
        this.firstNumber = firstNumber;
        this.secondNumber = secondNumber;
    }

    public double getFirstNumber() {
        return firstNumber;
    }

    public double getSecondNumber() {
        return secondNumber;
    }

    @Override
    public double operate() {
        return (firstNumber - secondNumber);
    }
}
