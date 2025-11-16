const API_URL = "http://localhost:8080/api";

export const loginUser = async (formData) => {
    const res = await fetch(`${API_URL}/login`, {
        method: "POST",
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify(formData),
    });
    return await res.json();
};

export const registerUser = async (formData) => {
    const res = await fetch(`${API_URL}/register`, {
        method: "POST",
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify(formData),
    });
    return await res.json();
};

export const verifyToken = async (token) => {
    const res = await fetch(`${API_URL}/verify-token`, {
        method: "POST",
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify({ token }),
    });
    return await res.json();
};