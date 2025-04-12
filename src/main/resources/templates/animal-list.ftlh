<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Animal Gallery</title>
    <link rel="stylesheet" href="/css/style.css">
</head>

<body>

<header>
    <h1>Hello, and welcome to the 100% Confirmed Best Animal Gallery!</h1>
    <nav>
        <a href="/animals">Home</a>
        <a href="/animals/new" class="btn-create">Create New Animal</a>
    </nav>
</header>

<main>
    <h2>Meet the Animals! These are the best of the best!</h2>

    <div class="gallery">
        <#list animals as animal>
        <div class="animal">
            <h3>${animal.name}</h3>
            <p>${animal.description}</p>
            <p>Category: ${animal.category}</p>
            <a href="/animals/${animal.animalId}">View Details</a>
            |
            <a href="/animals/delete/${animal.animalId}" class="delete-link">Delete</a>
        </div>
    </#list>
    </div>
</main>

<footer>
    <p>&copy; 2024 100% Confirmed Best Animal Gallery. All rights reserved.</p>
</footer>

</body>
</html>
