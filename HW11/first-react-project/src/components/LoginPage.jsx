import { useState } from "react";
import { useNavigate } from "react-router-dom";
import { loginUser } from "../services/api";

function LoginPage() {
    const [formData, setFormData] = useState({
        login: '',
        password: '',
    })
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

        try {
            const response = await loginUser(formData);
            if (response.success) {
                navigate("/main", { state: { token: response.token } });
            } else {
                setError(response.message);
            }
        } catch (err) {
            setError("Сервер не працює: " + err);
        }
    };

    return (
        <div className="container">
            <h2>Увійти</h2>
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
                <button type="submit">Увійти</button>
            </form>
            <button className="btn-other" onClick={() => navigate("/register")}>Зареєструватися</button>
        </div>
    );
}

export default LoginPage;
