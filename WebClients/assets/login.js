const loginForm = document.getElementById('#login-form');
const formUserName = document.getElementById('#username');
const formPassword = document.getElementById('#password');

const testUseraName = 'test';
const testPassword = 'test';

class User{
    constructor(userName, password){
        this.userName = userName;
        this.password = password;
    }
}



loginForm.addEventListener('submit', e => {
    const userName = formUserName.value;
    const password = formPassword.value;

    let loginFlag = 1;

    let dataOut;

    if(userName === '' || password === ''){
        showMessage('User name or password is empty', 'alert-danger');
    }
    else{
           fetch(`https://userapi20200513114529.azurewebsites.net/api/usernames/${userName}`)
            .then(res => res.json())
            .then(data => 
                {
                    if(data.userName === userName && data.password === password){
                        window.location = "home.html";
                    }
                    else{
                        window.location = "login.html";
                    }
                })
            .catch(err => console.log(err));
            console.log(loginFlag);
    }

    e.preventDefault();
});

function showMessage(message, classN)
{
    //Create div
    const div = document.createElement('div');

    //Add Class
    div.className = `alert ${classN}`;

    //Add message text
    div.appendChild(document.createTextNode(message));

    //Get the parent container
    const loginContainer = document.getElementById('#login-container');
    const login = document.getElementById('#login');

    loginContainer.insertBefore(div, login);

    setTimeout(() => {
        document.querySelector('.alert').remove()
    }, 3000);

}