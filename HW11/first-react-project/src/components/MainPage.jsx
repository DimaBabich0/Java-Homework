import { useEffect, useState } from "react";
import { useNavigate, useLocation } from "react-router-dom";
import { verifyToken } from "../services/api";

function MainPage() {
    const navigate = useNavigate();
    const location = useLocation();
    const [error, setError] = useState(null);

    useEffect(() => {
        const token = location?.state?.token;

        if (!token) {
            setError("Токен не знайден або він невірний.");
            navigate("/login");
            return;
        }

        verifyToken(token)
            .then((response) => {
                if (!response.success) {
                    setError(response.message);
                    navigate("/login");
                }
            })
            .catch(() => {
                setError("Сервер не працює");
                navigate("/login");
            });
    }, [location, navigate]);

    return (
        <div className="container">
            <h2>Головна сторінка</h2>
            {error ? <p>{error}</p> : <p>Тут лише текст. Доступ тільки після входу.</p>}
        </div>
    );
}

export default MainPage;
