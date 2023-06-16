const express = require('express');
const cors = require('cors');
const app = express();

app.use(cors());
app.use(express.json());

let students = [
    { id: 1, name: 'MRA', age: 20, grade: 'A' },
    { id: 2, name: 'MRB', age: 22, grade: 'B' },
  ];

app.get('/lists', (req, res) => {
    res.json(students);
} )

app.post('/students', (req, res) => {
    const { id, name, age, grade } = req.body;
    const newStudent = { id, name, age, grade };
  
    students.push(newStudent);
  
    res.status(201).json(newStudent);
  });

const port = 3000;
app.listen(port, () => {
    console.log(`Listening on port ${port}`);
})