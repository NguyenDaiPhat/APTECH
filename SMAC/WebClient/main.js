// alert("a");
document.addEventListener('DOMContentLoaded', loadData);

async function loadData() {
    const response = await fetch('https://localhost:7127/api/Persons');
    const data = await response.json();
    
    const tableBody = document.querySelector('#data-table tbody');

    data.forEach(person => {
        const row = document.createElement('tr');
        const firstNameCell = document.createElement('td');
        const lastNameCell = document.createElement('td');
        const ageCell = document.createElement('td');

        firstNameCell.textContent = person.firstName;
        lastNameCell.textContent = person.lastName;
        ageCell.textContent = person.age;

        row.appendChild(firstNameCell);
        row.appendChild(lastNameCell);
        row.appendChild(ageCell);

        tableBody.appendChild(row);
    });
}
