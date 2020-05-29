class Aliment {
    contructor(name, calories, protein, fat, carbohydrates){
        this.name = name;
        this.calories = calories;
        this.protein = protein;
        this.fat = fat;
        this.carbohydrates = carbohydrates;
    }
}

const formAlimentName = document.getElementById('aliment');
const formQuantity = document.getElementById('quantity');
const alimetForm = document.getElementById('aliments-form');

alimetForm.addEventListener('submit', e => {
    
    alimentName = formAlimentName.value;
    quantity = formQuantity.value;

    console.log(alimentName);

    fetch(`https://foodapi20200513104945.azurewebsites.net/api/alimentbyname/${alimentName}`)
        .then(res => res.json())
        .then(data => {
           
            const list = document.getElementById('aliments-list');
            const row = document.createElement('tr');

            console.log(list);

            calories = (data.caloriesPer100Gram * quantity) / 100;
            protein = (data.proteinPer100Gram * quantity) / 100;
            fat = (data.fatPer100Gram * quantity) / 100;
            carbohidrates = (data.carbohidratesPer100Gram * quantity) / 100;

            console.log(data.name);
            console.log(calories);
            console.log(protein);
            console.log(fat);
            console.log(carbohidrates);

            row.innerHTML = `
                <td>${data.name}</td>
                <td>${calories}</td>
                <td>${protein}</td>
                <td>${fat}</td>
                <td>${carbohidrates}</td>
            `;

            list.appendChild(row);
        })
        .catch(err => console.log(err));

    e.preventDefault();
})

function showAlert(message, className)
{
    const div = document.createElement('div');
    div.className = `alert alert-${className}`;
    div.appendChild(document.createTextNode(message));
    const container = document.querySelector('.container');
    const form = document.getElementById('aliments-form');
    container.insertBefore(div, form);

    // Vanish in 3 seconds
    setTimeout(() => document.querySelector('.alert').remove(), 3000);
}
