<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="ru">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Цветы</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
    <style>
        body {
            background-color: #f5f5f5;
        }
        h2 {
            color: #009688; /* Бирюзовый цвет */
        }
        .table thead th {
            background-color: #009688; /* Бирюзовый цвет */
            color: #ffffff;
        }
        .btn-primary {
            background-color: #009688; /* Бирюзовый цвет */
            border-color: #00796b;
        }
        .btn-primary:hover {
            background-color: #00796b;
            border-color: #005f56;
        }
        .form-control:focus {
            border-color: #009688; /* Бирюзовый цвет */
            box-shadow: 0 0 0 0.2rem rgba(0, 150, 136, 0.25);
        }
    </style>
</head>
<body>

<div class="container">
    <h2 style="margin-top: 20px; margin-bottom: 20px;">Список цветов</h2>
    <table class="table">
        <thead>
        <tr>
            <th>Название</th>
            <th>Тип</th>
            <th>Длина(см)</th>
            <th>Цвет</th>
            <th>Цена(шт/руб)</th>
        </tr>
        </thead>
        <tbody>
        <!— Содержимое таблицы —>
        </tbody>
    </table>

    <hr style="margin-top: 60px;">

    <div class="container" style="margin-top: 60px; margin-bottom: 100px;">
        <h2>Добавить цветок</h2>
        <form action="flowers" method="post" id="addition">
            <div class="form-colum">
                <div class="form-group col-md-6">
                    <label for="name">Название:</label>
                    <input type="text" class="form-control" id="name" name="name">
                </div>
                <div class="form-group col-md-6">
                    <label for="type">Тип:</label>
                    <input type="text" class="form-control" id="type" name="type">
                </div>
                <div class="form-group col-md-6">
                    <label for="color">Цвет:</label>
                    <input type="text" class="form-control" id="color" name="color">
                </div>
                <div class="form-group col-md-6">
                    <label for="length">Длина(см):</label>
                    <input type="number" class="form-control" id="length" name="length">
                </div>
                <div class="form-group col-md-6">
                    <label for="price">Цена(шт/руб):</label>
                    <input type="number" class="form-control" id="price" name="price">
                </div>
            </div>
            <button type="submit" class="btn btn-primary" id="add">Добавить</button>
        </form>
    </div>
</div>

<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
<script src="script.js"></script>
</body>
</html>