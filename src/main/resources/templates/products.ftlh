<!DOCTYPE html>
<html>
<head>
    <title>MyProduct</title>
</head>
<body>
<h1>MyProduct</h1>
<hr>
<h4>Товары со всей России</h4>
<#list products as product>

    <div><p><b>${product.title}</b> — <#if product.price == 0>
                бесплатно
            <#else>
                ${product.price} руб.
            </#if> | <b>Наличие: </b>
            <input type="checkbox" disabled ${product.isAvailable()?then('checked', '')}>
            <a href="/product/${product.id}">Подробнее...</a></p></div>
<#else>
    <h3>Товаров нет</h3>
</#list>
<hr>
<h3>Создать новый товар</h3>
<form action="/product/create" method="post">
    Название объявления: <input type="text" name="title" maxlength="255" required/><br><br>
    Описание объявления: <input type="text" name="description" maxlength="4096"/><br><br>
    Цена: <input type="number" name="price" value="${price!0}" min="0"/><br><br>
    Наличие: <input type="checkbox" name="available"/><br><br>
    <input type="submit" value="Добавить товар"/>
</form>

<br><br>
<h3>Сортировка и фильтрация</h3>
<form action="/filter" method="get">
    <label for="title">Название:</label>
    <input type="text" id="title" name="title"/><br><br>
    <label for="priceStart">Цена от:</label>
    <input type="number" id="priceStart" name="priceStart" min="0"/><br><br>
    <label for="priceEnd">Цена до:</label>
    <input type="number" id="priceEnd" name="priceEnd" min="0"/><br><br>
    <label for="available">Доступность:</label>
    <input type="checkbox" id="available" name="available" value="true"/><br><br>
    <label for="title">Количество записей:</label>
    <input type="number" id="limit" name="limit" min="1"/><br><br>
    <label for="sort">Сортировать по:</label>
    <select id="sort" name="sort">
        <option value="title">Названию</option>
        <option value="price">Цене</option>
        <option value="available">Доступности</option>
    </select>
    <input type="submit" value="Найти"/><br><br>


</form>

</body>
</html>