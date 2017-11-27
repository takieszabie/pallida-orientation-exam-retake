'use strict'

const localhost = 'http://localhost:3000';
let solutionField = document.querySelector('#solutionfield');
const getButton = document.querySelector('#getbutton');

function ajax (method, url, callback) {
    let xhr = new XMLHttpRequest;
    xhr.open(method, url);
    solutionField.innerHTML = "";    
    solutionField.innerHTML += `<center><h1>Please wait for the data!`;
    xhr.onload = function () {
        callback( JSON.parse(xhr.responseText) );
    };
    xhr.send();
};


function createTable (response) {
    solutionField.innerHTML = "";
    solutionField.innerHTML = `<tr>
    <th>Item</th>
                                    <th>Manufacturer</th>
                                    <th>Category</th>
                                    <th>Size</th>
                                    <th>Unit pice</th>
                                    </tr>`;
    
                                    response.clothes.forEach(function(item){
                                        solutionField.innerHTML += `<tr>
                                        <td>${item.item_name}</td>
                                        <td>${item.manufacturer}</td>
                                        <td>${item.category}</td>
                                        <td>${item.size}</td>
                                        <td>${item.unit_price}</td>
                                    </tr>`;
                        });
};

function createReport (res) {
    let headerText = document.querySelector('#report');
    if (res.result !== "ok") {
        headerText.innerHTML = ""
        headerText.innerHTML += `Green Fox Fashion Web Storage
                                <br><div style="background-color:red">${res.result}</div>`;    
        solutionField.innerHTML = "";
    } else {
        headerText.innerHTML = ""
        headerText.innerHTML += `Green Fox Fashion Web Storage
                                <br><div style="background-color:green">Spended ${res.total_price}$. Thank you!</div>`;    
        solutionField.innerHTML = "";
    }
};

getButton.addEventListener('click', function(){
    let selectedItem = document.querySelector('#items');
    let selectedSize = document.querySelector('#sizes');
    let selectedQuantity = document.querySelector('#quantity');
    let query = `/price-check?item=${selectedItem.value}&size=${selectedSize.value}&quantity=${selectedQuantity.value}`;
    ajax('GET', localhost + query, createReport);
});

ajax('GET', localhost + "/warehouse", createTable);