<h2 align="center">SOLID PRINCIPLES</h2>
***
* S - Single Responsibility Principle  
* O - Open/Closed Principle  
* L - Liskov Substitution Principle  
* I - Interface Segregation Principle  
* D - Dependency Inversion  
***

```
1 - Single Responsibility Principle
Oluşturduğumuz sınıflara tekil sorumluklar yüklemek gerekir. Tüm yapıyı tek
bir sınıf içerisine sıkıştırmak yerine sınıflarımızı sorumluluklarına göre 
alt sınıflara bölmek gerekir. Bunun iki temel faydası var;
* Bir sınıf yalnızca bir amaç uğruna değiştirilebilmeli, bu sayede uygulamada
yapacağımız bir değişiklikte işi belli olan sınıfa daha rahat müdahale sağlar.
* Bir takım olarak çalışılan projelerde herkesin sorumluluk alanı farklı 
olacaktır. Developerların yaptığı değişiklikler ile birbirinin kısımlarına 
yanlışlıkla olabilecek müdahaleler ya da etkilemeler azaltılmış olur. 
```

```
2 - Open/Closed Principle
Entitiler genişletilebilmeli ancak modifikasyona kapalı olmalı. Yani bir sınıf
kendinde var olan özellikleri koruyabilmeli, değişikliklere izin vermemeli ancak 
yeni özellikler kazanabiliyor olmalı.
* Sürdürülebilir ve tekrar kullanılabilir yapıda kod yazmanın temelini oluşturur. 
```

```
3 - Liskov Substitution Principle
Sub classlar kullanıldıkları zaman super class' ından farklı tipte bir sonuç
vermemeli. Yani kodlarında bir değişiklik yapmadan alt sınıflar türedikleri 
üst sınıfların yerlerine kullanılabilmeli.
```

```
4 - Interface Segregation Principle
Çok farklı işlevler yani metot imzaları aynı interface' e yüklenmemeli çünkü
bu interface' i implemente eden classlar gereksiz metot implementasyonları 
yapmak zorunda kalırlar. Kod karmaşası oluşturubilir. Özetle sorumluklar tek 
bir arayüz yerine işlevlerine ayrılmış farklı arayüzlere ayrılmalı.
```

```
5 - Dependency Inversion Principle
Bir sınıf concrete sınıflara değilde daha çok abstract classlara işaret etmeli
yani abstract classlara depend olmalı. Concrete sınıflar memoryde doğrudan alan
işgal eden standart sınıflardır ve bu tür sınıflar runtime'da ölümcül olabilmektedir.
Bu da bazı conflictler çıkartabilir. Üst seviye sınıflar alt seviye sınıflara bağımlı 
olmamalır. Sınıflar arası bağımlıklar azaltılabilmeli. Ayrıca test edilebilirlik de 
bu prensip ile  kolaylaştırılmış olur. 
```