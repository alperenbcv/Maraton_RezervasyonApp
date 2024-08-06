# Restoran Rezervasyon Sistemi

Bu proje, restoranların yönetimi ve kullanıcıların restoranlarda rezervasyon yapabilmesi için bir uygulama sunar. Uygulama, kullanıcıların restoran ekleyip kaldırmalarını, restoranların listesini görüntülemelerini ve rezervasyon yapmalarını sağlar.

## Özellikler

- Kullanıcı Kayıt ve Giriş
- Kullanıcı Rolleri (Admin ve Müşteri) (Admin hesabı oluşturmak için Kayıt Kısmında kullaniciadi bolumune admin yazilmalidir. Bu sayede Admin özel menuleri goruntuleyebilirsiniz.)
- Restoran Ekleme, Silme ve Listeleme
- Rezervasyon Oluşturma ve İptal Etme
- Restoranların Durumunu ve Kapasitesini Yönetme

## Kullanıcı Rolleri

- **Admin**: Restoran ekleyebilir ve silebilir.
- **Müşteri**: Restoranları görüntüleyebilir ve rezervasyon yapabilir.

## Sınıflar ve Yapılar

### Entities

- **Kullanici**: Kullanıcı bilgilerini tutan temel sınıf.
- **Musteri**: Kullanıcı sınıfından türeyen müşteri sınıfı.
- **Yonetici**: Kullanıcı sınıfından türeyen yönetici sınıfı.
- **Restoran**: Restoran bilgilerini tutan sınıf.
- **Rezervasyon**: Rezervasyon bilgilerini tutan sınıf.

### Databases

- **KullaniciDB**: Kullanıcıları yönetmek için kullanılan veritabanı sınıfı.
- **RestoranDB**: Restoranları yönetmek için kullanılan veritabanı sınıfı.
- **RezervasyonDB**: Rezervasyonları yönetmek için kullanılan veritabanı sınıfı.

### Menus

- **AppMenu**: Ana menüyü yöneten sınıf.
- **KullaniciApp**: Kullanıcı işlemlerini yöneten sınıf.
- **RestoranApp**: Restoran işlemlerini yöneten sınıf.
- **RezervasyonApp**: Rezervasyon işlemlerini yöneten sınıf.

### Utilities

- **ERestoranDurum**: Restoran durumunu belirtmek için kullanılan enum.
- **ERestoranFiyat**: Restoran fiyat seviyesini belirtmek için kullanılan enum.
- **ERestoranTur**: Restoran türünü belirtmek için kullanılan enum.
- **ERole**: Kullanıcı rolünü belirtmek için kullanılan enum.
- **RandomRestoranGenerator**: Rastgele restoran oluşturmak için kullanılan sınıf.

### Hata Yönetimi
- Kullanıcı kaydı sırasında oluşabilecek hatalar henüz yönetilmedi.
- Uygulamada çoğu durum test edildi fakat tam randımanlı bir hata yönetme işlemi yapılmadı.
