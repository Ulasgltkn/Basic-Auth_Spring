# 🌟 Basic Auth Projesi
Bu proje, JWT ve Spring Security kullanmadan, Basic Authentication yöntemi ile güvenliği sağlanmış basit bir web uygulamasıdır. Kullanıcı adı ve şifre kombinasyonu ile kimlik doğrulama gerçekleştirilir.

## 🚀 Başlarken
Gereksinimler
Java 8 veya üstü
Maven 3.6 veya üstü
Spring Data Jpa
MySql
Lombok

Kurulum
Projeyi Klonlayın:


git clone https://github.com/Ulasgltkn/Basic-Auth_Spring.git
cd proje
Bağımlılıkları Yükleyin:


## mvn clean install
Uygulamayı Başlatın:


## mvn spring-boot:run
##⚙️ Yapılandırma
Uygulama Ayarları
Uygulamanın ayarları application.properties dosyasında bulunur. Bu dosyada, temel ayarlar ve kullanıcı bilgileri tanımlanır:



# Kullanıcı bilgileri
app.user.name=kullanici
app.user.password=sifre
Kimlik Doğrulama
Uygulama, Basic Auth kullanarak kimlik doğrulama gerçekleştirir. Tarayıcı veya herhangi bir istemci uygulama kullanarak HTTP isteklerini yaparken kullanıcı adı ve şifreyi belirtmeniz gerekmektedir.

Örnek İstek
Bir REST istemcisi (örneğin Postman) kullanarak kimlik doğrulama gerçekleştirebilirsiniz.


Uygulamada bir veya birden fazla korunan endpoint bulunmaktadır. Bu endpoint'lere erişmek için doğru kullanıcı adı ve şifre kombinasyonunu kullanarak kimlik doğrulama yapmanız gerekmektedir.

##📁 Proje Yapısı
plaintext
Kodu kopyala
proje/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/
│   │   │       └── ornek/
│   │   │           └── proje/
│   │   │               └── ...
│   │   └── resources/
│   │       └── application.properties
├── .gitignore
├── pom.xml
└── README.md
## 🛠️ Kullanılan Teknolojiler
Spring Boot: Uygulamanın temelini oluşturan framework.
Basic Auth: Kimlik doğrulama yöntemi.