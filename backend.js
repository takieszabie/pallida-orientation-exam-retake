'use strict'

const express = require('express');
const app = express();
const mysql = require('mysql');

app.use(express.json());

app.use(express.static(__dirname + '/assets'));

const connection = mysql.createConnection({
    host: 'localhost',
    user: 'root',
    password: 'root',
    database: 'clothing'
});

connection.connect(function (err){
    if(err){
        console.log('Error connecting to DB!');
        return;
    };
    console.log('Connected to the Database.');
});

app.get('/', function (req, res){
    res.sendFile(__dirname + '/assets/index.html');
});

app.get('/warehouse', function(req, res){

    let sqlCode = `SELECT * FROM warehouse`;
    
    connection.query(sqlCode, function(err, rows){
        res.send({
            "result": "ok",
            "clothes": rows
        });
    });
});

app.get('/price-check', function (req, res) {
    let sqlCode = `SELECT * FROM warehouse WHERE item_name LIKE "%${req.query.item}%" AND size="${req.query.size}"`;
    let quantity = req.query.quantity;

    connection.query(sqlCode, function (err, row){
        
        // WARNING!! FIGYELEM!! EZEKET AZÉRT KELLETT KI-COMMENT-ELNEM, MERT A FELADAT SQL FILE-JA NEM TARTALMAZOTT VALID DARABSZÁMOKAT! (Mindegyik értéke NULL volt! Ezt jeleztem is az itt lévő mentoroknak! Így nem lehet leellenőrizni, ill. nincs értelme. Azért bennehagyom, mert kb. így lett volna a megoldása...)

        // if (row.in_store > req.query.quantity){
        //     res.send({
        //         "result": "ok",
        //         "total_price": quantity * row[0].unit_price
        //     });
        // } else {
        //     res.send({
        //         "result": "error, we don't have enough items in store"
        //     });
        // };  

        if (req.query.quantity < 3) {
            res.send({
                "result": "please order at least 3, one for yourself, two for your friends"
            });
        } else {
            res.send({
                "result": "ok",
                "total_price": quantity * row[0].unit_price
            });
        };
    });
});

app.listen(3000, () => console.log('Server is running (port:3000)...'));