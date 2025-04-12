<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Create Animal</title>
    <link rel="stylesheet" href="/css/style.css">
</head>

<body>

<header>
    <h1>Add a New Animal</h1>
    <nav>
        <a href="/animals">Home</a>
    </nav>
</header>

<main>
    <form action="/animals/new" method="post">
        <label for="name">Name:</label>
        <input type="text" id="name" name="name" required><br><br>

        <label for="category">Category:</label>
        <input type="text" id="category" name="category" required><br><br>

        <label for="description">Description:</label><br>
        <textarea id="description" name="description" rows="4" cols="50" required></textarea><br><br>

        <button type="submit">Add Animal</button>
    </form>
</main>

<footer>
    <p>&copy; 2024 100% Confirmed Best Animal Gallery. All rights reserved.</p>
</footer>

</body>
</html>
