Тестовое задание.

Легенда

Ты java backend разработчик в поисках новой работы. К тебе обращается небольшая компания “РомашкаКо”, у которой есть интернет магазин “МоиТовары”. Компания хочет, чтобы ты сделал REST API для интернет магазина.
В пректе реализованно:

Задание 1. Базовая реализация REST API

Реализация @Controller для использования страницы .fthl

Задание 2. Подключение базы данных

Login:postgres
pasword: 123
продублированны в aplication.properties

Задание 3. Использование Docker

Реализация Docker file и Docker-compose

Задание 4. Добавление фильтрации и сортировки

Реализация сортировки и фильтрации

Задание 5 Бонус. Добавление продаж через сайт

Для проверки 5-го задания рекомендую использовать Postman
Запрос Curl для покупки
curl --location 'localhost:8090/supplier/create' \
--header 'Content-Type: application/json' \
--data '{
    "documentName": "Поставка Iphone",
    "countBought":54,
    "product": 
    {
        "id":1
    }
}'
Запрос  Curl для продажи
curl --location 'localhost:8090/sale/create' \
--header 'Content-Type: application/json' \
--data '{
    "documentName": "Продажа Iphone",
    "countSold":5,
    "product": 
    {
        "id":1
    }
}'
