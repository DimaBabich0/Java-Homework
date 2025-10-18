async function loadTheme() {
    try {
        const response = await fetch('cookie');
        if (!response.ok) throw new Error('Error with loading data');
        const data = await response.json();
        const theme = data.theme || 'light';
        setTheme(theme, false);
        setRadioButton(theme);
    } catch (e) {
        console.error(e);
        setTheme('light', false);
        setRadioButton('light');
    }
}

function setTheme(theme, updateServer = true) {
    document.body.classList.toggle('dark', theme === 'dark');
    document.body.classList.toggle('light', theme === 'light');

    if (updateServer) {
        fetch('cookie', {
            method: 'POST',
            headers: { 'Content-Type': 'application/x-www-form-urlencoded' },
            body: `theme=${encodeURIComponent(theme)}`
        }).catch(err => console.error('Ошибка при сохранении темы:', err));
    }
}

function setRadioButton(theme) {
    document.getElementById('light-theme').checked = theme === 'light';
    document.getElementById('dark-theme').checked = theme === 'dark';
}

function setupThemeSwitchers() {
    document.getElementById('light-theme').addEventListener('change', () => setTheme('light'));
    document.getElementById('dark-theme').addEventListener('change', () => setTheme('dark'));
}

window.onload = () => {
    loadTheme();
    setupThemeSwitchers();
};
