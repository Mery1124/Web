/*const express = require('express');
const bodyParser = require('body-parser');
const sqlite3 = require('sqlite3').verbose();
const bcrypt = require('bcrypt');
const path = require('path');
const session = require('express-session');

const app = express();
const db = new sqlite3.Database('./database.db');

app.use(bodyParser.urlencoded({ extended: true }));
app.use(express.static('public'));

// Сесии
app.use(session({
    secret: 'tajna', // Смени с нещо по-сигурно в продукция
    resave: false,
    saveUninitialized: true
}));

// Създаване на таблицата
db.run(`CREATE TABLE IF NOT EXISTS users (
  id INTEGER PRIMARY KEY AUTOINCREMENT,
  username TEXT UNIQUE,
  password TEXT,
  firstName TEXT,
  lastName TEXT,
  specialization TEXT
)`);

// Рут за регистрация
app.post('/register', async (req, res) => {
    const { username, password, confirmPassword, firstName, lastName, specialization } = req.body;

    if (password !== confirmPassword) {
        return res.send("Паролите не съвпадат. <a href='/'>Назад</a>");
    }

    try {
        const hashed = await bcrypt.hash(password, 10);

        db.run(
            "INSERT INTO users (username, password, firstName, lastName, specialization) VALUES (?, ?, ?, ?, ?)",
            [username, hashed, firstName, lastName, specialization],
            function (err) {
                if (err) {
                    return res.send("Грешка: Потребителското име вече съществува. <a href='/'>Назад</a>");
                }
                res.send("Регистрацията е успешна. <a href='/'>Влез тук</a>");
            }
        );
    } catch (error) {
        res.send("Възникна грешка. <a href='/'>Назад</a>");
    }
});

// Рут за вход
app.post('/login', (req, res) => {
    const { username, password } = req.body;

    db.get("SELECT * FROM users WHERE username = ?", [username], async (err, user) => {
        if (!user) return res.send("Невалидно потребителско име или парола. <a href='/'>Назад</a>");

        const valid = await bcrypt.compare(password, user.password);
        if (valid) {
            // Запазваме данните в сесията
            req.session.user = {
                id: user.id,
                username: user.username,
                firstName: user.firstName,
                lastName: user.lastName,
                specialization: user.specialization
            };
            res.redirect('/dashboard');
        } else {
            res.send("Невалидно потребителско име или парола. <a href='/'>Назад</a>");
        }
    });
});

// Потребителски панел
app.get('/dashboard', (req, res) => {
    if (!req.session.user) {
        return res.redirect('/');
    }

    const { firstName, lastName, specialization } = req.session.user;

    res.send(`
    <h2>Добре дошъл, д-р ${firstName} ${lastName}</h2>
    <p>Специализация: ${specialization}</p>
    <a href="/logout">Изход</a>
  `);
});

// Изход
app.get('/logout', (req, res) => {
    req.session.destroy();
    res.redirect('/');
});

// Стартираме сървъра
app.listen(3000, () => {
    console.log('Сървърът работи на http://localhost:3000');
});
*/