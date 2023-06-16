fetch('http://localhost:3000/lists')
      .then(response => response.json())
      .then(data => {
        const table = document.getElementById('studentTable');

        data.forEach(student => {
            const row = table.insertRow();
            const idCell = row.insertCell();
            idCell.textContent = student.id;

            const nameCell = row.insertCell();
            nameCell.textContent = student.name;

            const ageCell = row.insertCell();
            ageCell.textContent = student.age;

            const gradeCell = row.insertCell();
            gradeCell.textContent = student.grade;
        })
      })
      .catch(error => {
        console.error('Error:', error);
      });