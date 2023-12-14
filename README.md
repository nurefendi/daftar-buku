# daftar-buku

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
```shell
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

### API Endpoints
- **GET v1/perpus/books:** get all books.
- **GET v1/perpus/books/{id}:** get one book.
- **PUT v1/perpus/books/{id}:** update book.
- **DELETE v1/perpus/books/{id}:** delete book.

### Postman 
[Postman](./Perpus.postman_collection.json)
