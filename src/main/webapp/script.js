let request = new XMLHttpRequest();
request.open("GET", "flowers.json");

request.responseType = "json";
request.send();

// после загрузки файла JSON
request.onload = function() {
    let flowers = request.response;
    fillTable(flowers);
}

// заполнение таблицы из JSON файла
function fillTable(flowers) {
    let tbody = document.querySelector("tbody");

    flowers.forEach(flowers => {
        let newRow = document.createElement("tr");

        newRow.innerHTML = `<td>${flowers["name"]}</td><td>${flowers["type"]}</td><td>${flowers["color"]}</td><td>${flowers["length"]}</td><td>${flowers["price"]}</td>`;
        tbody.appendChild(newRow);
    });
}