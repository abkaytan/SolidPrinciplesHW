package singleResponsibility;

import java.util.Date;

/** ÖZET :
 * UserInformation class' ı tüm kullanıcı bilgilerin kendi içerisinde tutmaktadır.
 * Bunun yerine User bilgisini ayrı adress bilgisini ayrı tutmak kuracağımız api mimarisi
 * için daha uygundur. Adres bilgisinde bir değişiklik yapmak istediğimizde sadece adres bilgilerinin
 * olduğu sınıfa müdahale etmek daha mantıklıdır. örneğin kat numarası bilgisini de eklemek istedik
 * müdahale ettiğimiz sınıf sadece adres bilgisine özeldir. Ayrıca ileride bir kullanıcıya ikinci bir adres
 * bilgisi eklemek istedik. İlk yapıda bu karışıklık oluşturur. İki farklı sınıf olduğu zaman OneToMany gibi
 * ilişkileri de aralarında kurarak tek kullanıcıya tek bir adres'in eklenebilmesi gibi bir eksikliğinde önüne
 * geçmiş oluruz.
 * */
class UserInformation {

    public long id;
    public String fullName;
    public Date birthDate;

    public String city;
    public String street;
    public String apartmentNumber;

}



class User{
    public long id;
    public String fullName;
    public Date birthDate;
}

class Address{
    public String city;
    public String street;
    public String apartmentNumber;
}
