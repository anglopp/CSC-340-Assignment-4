<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>${animal.name} Details</title>
    <link rel="stylesheet" href="/css/style.css">
</head>

<body>
<header>
    <h1>More About ${animal.name}</h1>
    <nav>
        <a href="/animals">Home</a>
        <a href="/animals/new">Add Animal</a>
        <a href="/animals">Back to Animal List</a>
    </nav>
</header>

<main>
    <section class="details">
        <h2>${animal.name}: ${animal.description}</h2>
        <p>Category: ${animal.category}</p>
    </section>

    <!-- Add a link for deleting the animal -->
    <section class="delete-action">
        <a href="/animals/delete/${animal.animalId}" class="delete-link" onclick="return confirm('Are you sure you want to delete this animal?');">Delete Animal</a>
    </section>
</main>

<footer>
    <p>&copy; 2024 100% Confirmed Best Animal Gallery. All rights reserved.</p>
</footer>

</body>
</html>
