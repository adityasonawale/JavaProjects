<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title> Register Here ! </title>
    <style>
        body {
            margin: 0;
            padding: 0;
            font-family: Arial, sans-serif;
            background: #000;
            color: #fff;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
        }

        .container {
            width: 300px;
            text-align: center;
        }

        h2 {
            font-size: 24px;
            margin-bottom: 20px;
        }

        input[type="text"],
        input[type="email"],
        input[type="number"],
        input[type="password"] {
            width: 100%;
            padding: 10px;
            margin-bottom: 20px;
            border: none;
            border-radius: 5px;
            background: #333;
            color: #fff;
            outline: none;
        }

        input[type="submit"] {
            width: 107%;
            padding: 10px;
            border: none;
            border-radius: 5px;
            background: #e50914;
            color: #fff;
            font-size: 16px;
            cursor: pointer;
            outline: none;
        }

        input[type="submit"]:hover {
            background: #ff3d2e;
        }

        .signup-link a {
            color: #e50914;
            text-decoration: none;
        }

    </style>
</head>
<body>
<div class="container">
    <h2>Register Here !</h2>
    <form action="#">
        <input type="text" placeholder="Username" name="username" required>
        <input type="email" placeholder="Email" name="emailId" required>
        <input type="password" placeholder="Password" name="password" required>
        <input type="number" placeholder="Mobile No" name="mobNo" required>
        <input type="submit" formaction="saveuser" value="Sign In">
    </form>
</div>
</body>
</html>