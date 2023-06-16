const express = require('express');
const path = require('path');
const app = express();

app.use(express.urlencoded({ extended: true }));

app.get('/', (req, res) => {
    // __dirname D:\APTECH\NodeJs
    res.sendFile(path.join(__dirname, 'index.html'));
})


app.post('/calculate', (req, res) => {
    const { num1, num2 } = req.body; 
    const resultAdd = add(Number(num1), Number(num2));
    const resultSub = sub(Number(num1), Number(num2));
    const resultMulti = multi(Number(num1), Number(num2));
    const resultDiv = div(Number(num1), Number(num2));
    res.send(`Tong: ${resultAdd} Hieu: ${resultSub} Nhan: ${resultMulti} Chia: ${resultDiv}`)
    
})

function add(num1, num2) {
    return num1 + num2;
}

function sub(num1, num2) {
    return num1 - num2;
}

function multi(num1, num2) {
    return num1 * num2;
}

function div(num1, num2) {
    return num1 / num2;
}


const port = 3000;
app.listen(port, () => {
  console.log(`Server running at http://localhost:${port}/`);
});
