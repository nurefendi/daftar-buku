# daftar-buku

## Getting Started
this project make using spring boot reactive.
<br>
build with separate modules based on functionality
- **entity** : Contains domain models or entity classes.
- **repository** : Contains interfaces or classes for data access.
- **rest-web** : Contains REST controllers.
- **service** : Contains service classes for business logic.
- **utility** : Holds utility or helper classes.

and for main class putted on **rest-web**
[Main.java](./rest-web/src/main/java/com/mazayaku/Main.java)
## Requirements

- Java Version : 17
- Maven : 3.8.1
- MySQL

## Usage
### Configuration
Migrating the database
```sql
create database perpusDb;

use perpusDb;

create table buku
(
    id           int auto_increment
        primary key,
    kode_buku    varchar(255)  not null,
    judul_buku   text          not null,
    pengarang    varchar(255)  null,
    penerbit     text          null,
    tahun_terbit datetime      null,
    jumlah_buku  int default 0 not null,
    created_date datetime      null,
    created_by   varchar(255)  null,
    updated_date datetime      null,
    updated_by   varchar(255)  null
);
```
Update `application.yml`

location
[application.yml](./rest-web/src/main/resources/application.yml)
```yaml
# /rest-web/src/main/resources/application.yml
datasource:
  url: jdbc:mysql://127.0.0.1:3306/perpusDb?zeroDateTimeBehavior=convertToNull&useSSL=false&useUnicode=yes&characterEncoding=UTF-8&serverTimezone=Asia/Jakarta
  username: root
  password:
  scanPackage: com.mazayaku.entity.dao
  driverClassName: com.mysql.cj.jdbc.Driver
  maxPoolSize: 3
  hibernate:
    hbm2ddl.method: validate
    show_sql: false
    format_sql: false
    dialect: org.hibernate.dialect.MySQL8Dialect
    use_jdbc_metadata_defaults: true
    enable_lazy_load_no_trans: true
    charset: utf8mb4
    charset_encoding: utf8mb4_bin
    use_unicode: true
    batch_size: 50
```
- change hostname : 127.0.0.1:3306
- change database name : **perpusDb**
- change username : 
- change password : 


### Running the Project
clone project
```shell
git clone https://github.com/nurefendi/daftar-buku.git
cd daftar-buku
```
build project

```shell
mvn clean install
```
run
```shell
mvn spring-boot:run
```

### Running the Project using IntelliJ IDEA
- clone project
```shell
git clone https://github.com/nurefendi/daftar-buku.git
```
- open project daftar-buku


### API Endpoints
- **GET v1/perpus/books:** get all books.
- **GET v1/perpus/books/{id}:** get one book.
- **PUT v1/perpus/books/{id}:** update book.
- **DELETE v1/perpus/books/{id}:** delete book.

### Postman 
[Postman](./Perpus.postman_collection.json)
