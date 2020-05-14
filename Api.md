# How to use Api's:

To access the users: 

    - GET: https://userapi20200513114529.azurewebsites.net/api/users -> to get all users:
            https://userapi20200513114529.azurewebsites.net/api/users/{userID} -> to get a specific user (example userID: "6b1eea43-5597-45a6-bdea-e68c60564243");
    - POST: https://userapi20200513114529.azurewebsites.net/api/users  -> to post a new user int the database;
    - DELETE: https://userapi20200513114529.azurewebsites.net/api/users/{userID} -> to delete a user from database
    - Example of a valid user in json format:
         {
          "id": "6b1eea43-5597-45a6-bdea-e68c60564247", (id does not have to be secified in json when we want to create a new user because a random one will be generated)
          "userName": "BerceaSmen",
          "password": "MyPass",
          "height": 0,
          "weight": 0,
          "age": 0,
          "gender": 0
        }
        
To access the aliments:

    - GET: https://foodapi20200513104945.azurewebsites.net/api/aliments -> to get all the aliments from the databse;
           https://foodapi20200513104945.azurewebsites.net/api/aliments/6b1eea43-5597-45a6-bdea-e68c60564274 -> to get a specific aliment by id
           https://foodapi20200513104945.azurewebsites.net/api/alimentbyname/Lapte -> to get a specific aliment by name (Ex. Lapte)
    - DELETE: https://foodapi20200513104945.azurewebsites.net/api/aliments/{alimetId} -> to delete a specific aliment by id
    - POST : https://foodapi20200513104945.azurewebsites.net/api/aliments -> to add to database
    - Example of o a valid aliment in json format:
        {
          "id": "6b1e7a43-5597-45a6-bdea-e68c60564247", (id does not have to be secified in json when we want to create a new user because a random one will be generated)
          "name": "Macaroane",
          "caloriesPer100Gram": 2,
          "proteinPer100Gram": 1,
          "fatPer100Gram": 1,
          "carbohidratesPer100Gram": 3
        }
