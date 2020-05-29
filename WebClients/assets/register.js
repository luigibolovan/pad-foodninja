const formUserName = document.getElementById('username');
const formPassword = document.getElementById('password');
const formConfPassword = document.getElementById('confirm-password');
const registerForm = document.getElementById('register-form');

registerForm.addEventListener('submit', e =>{
    const userName = formUserName.value;
    const password = formPassword.value;
    const confirmPassword = formConfPassword.value;

    let validation = true; 


    console.log(userName);
    console.log(password);
    console.log(confirmPassword);

    if(userName === ''){
        showMessage('Please fill in the username', 'alert-danger');
        validation = false;
    }
    if(password === ''){
        showMessage('Please fill in the password', 'alert-danger');
        validation = false;
    }
    if(confirmPassword === ''){
        showMessage('Please fill in the confirm pssword', 'alert-danger');
        validation = false;
    }
    if(password !== confirmPassword)
    {
        showMessage('Passwords do not match', 'alert-danger');
        validation = false;
    }

    if(validation === true){
        console.log('success enter in if');
        const objToPost ={
            userName: userName,
            password: password,
            height: 0,
            weight: 0,
            age: 0,
            gender: 0
        }

        const options = {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(objToPost)
        };

        fetch('http://localhost:11111/api/users', options);
    }

    

    e.preventDefault();
})

function showMessage(message, classN)
{
    //Create div
    const div = document.createElement('div');

    //Add Class
    div.className = `alert ${classN}`;

    //Add message text
    div.appendChild(document.createTextNode(message));

    //Get the parent container
    const loginContainer = document.getElementById('register-container');
    const login = document.getElementById('register');

    loginContainer.insertBefore(div, login);

    setTimeout(() => {
        document.querySelector('.alert').remove()
    }, 3000);

}