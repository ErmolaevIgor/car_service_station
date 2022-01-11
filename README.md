# Car service station
Простая CRM система учета клиентов СТО и их автомобилей

# Getting Started

1. Для старта проекта создайте БД PostgreSQL с именем car_service_station.
В случае Docker можно использовать команду:
```
docker run -it -e POSTGRES_DB=my_crm -p "5432:5432" postgres:9.6.14 
```

либо воспользуйтесь Docker-Compose:
```
docker-compose up
```
2. Выполните SQL скрипт initial.sql для создания схемы БД

3. Заполните таблицы тестовыми данными, которые находятся в файле customer_data.csv и customer_cars_data.csv
(класс utils/DataImport поможет их загрузить в БД). В строке 36 и 47 укажите правильный путь к файлу.
