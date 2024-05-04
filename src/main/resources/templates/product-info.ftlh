<!DOCTYPE html>
<html>
<head>
    <title>MyProduct</title>
</head>
<body>
<h1>MyProduct</h1>
<hr>
<h4>Подробная информация о товаре</h4>
<b>Название товара: </b>${product.title}<br>
<b>Описание товара: </b>${product.description}<br>
<b>Цена: </b>${product.price}<br>
<hr>
<h3>Редактировать товар</h3>
<form action="/product/update/${product.id}" method="post">
    Название объявления: <input type="text" name="title" value="${product.title}" maxlength="255" required /><br><br>
    Описание объявления: <input type="text" name="description" value="${product.description}" maxlength="4096" /><br><br>
    Цена: <input type="number" name="price" value="${product.price!0}" min="0" /><br><br>
    Наличие: <input type="checkbox" name="available"/><br><br>

    <input type="submit" value="Редактировать товар"/>
</form>
<hr>

<form action="/product/delete/${product.id}" method="post">
    <input type="submit" value="Удалить товар"/>
</form>
</body>
</html>