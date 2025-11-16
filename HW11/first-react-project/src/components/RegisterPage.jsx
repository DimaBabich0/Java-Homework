import { useState } from "react";
import { useNavigate } from "react-router-dom";
import { registerUser } from "../services/api";

function RegisterPage() {
    const [formData, setFormData] = useState({
        login: '',
        password: '',
    })
    const [confirmPassword, setConfirmPassword] = useState("")
    const [error, setError] = useState("");
    const navigate = useNavigate();

    const handleChange = (e) => {
        setFormData({
            ...formData,
            [e.target.name]: e.target.value
        })
    }

    const handleSubmit = async (e) => {
        e.preventDefault();
        if (formData.password !== confirmPassword) {
            setError("Паролі не співпадають");
            return;
        }
        try {
            const response = await registerUser(formData);
            if (response.success) {
                navigate("/login");
            } else {
                setError(response.message);
            }
        } catch (err) {
            setError("Сервер не працює: " + err);
        }
    };

    return (
        <div className="container">
            <h2>Реєстрація</h2>
            {error && <p className="error">{error}</p>}
            <form onSubmit={handleSubmit}>
                <input
                    type="text"
                    id="login"
                    name="login"
                    placeholder="Логін"
                    value={formData.login}
                    onChange={handleChange}
                    required
                />
                <input
                    type="password"
                    id="password"
                    name="password"
                    placeholder="Пароль"
                    value={formData.password}
                    onChange={handleChange}
                    required
                />
                <input
                    type="password"
                    id="confirmPassword"
                    name="confirmPassword"
                    placeholder="Підтвердження паролю"
                    value={confirmPassword}
                    onChange={(e) => setConfirmPassword(e.target.value)}
                    required
                />
                <button type="submit">Зареєструватися</button>
            </form>
            <button className="btn-other"  onClick={() => navigate("/login")}>Повернутися до входу</button>
        </div>
    );
}

export default RegisterPage;
