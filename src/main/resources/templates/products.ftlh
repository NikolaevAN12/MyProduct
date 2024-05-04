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
    Описание объявления: <input type="text" name="description" maxlength="4096" /><br><br>
    Цена: <input type="number" name="price" value="${price!0}" min="0" /><br><br>
    Наличие: <input type="checkbox" name="available" /><br><br>
    <input type="submit" value="Добавить товар"/>
</form>
</body>
</html>