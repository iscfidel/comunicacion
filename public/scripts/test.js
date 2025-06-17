document
    .getElementById("miFormulario")
    .addEventListener("submit", function (e) {
        e.preventDefault(); // Prevenir el envío del formulario por defecto

        // Obtener los datos del formulario
        const formData = {
            mensaje: document.getElementById("message").value,
        };

        // URL de tu API
        const apiUrl = "http://localhost:8080/api/test/saludo"; // API 1
        // Configuración de la solicitud Fetch...
        const requestOptions = {
            method: "POST", // Método HTTP
            headers: {
                "Content-Type": "application/json", // Tipo de contenido que estamos enviando...
            },
            body: JSON.stringify(formData), // Convertimos el objeto a una cadena JSON...
        };

        console.log("Enviando datos:", formData); // Log para depuración
        console.log("Configuración de la solicitud:", requestOptions);

        // Mostrar mensaje de envío dentro de nuestro archivo HTML...
        document.getElementById(
            "respuesta"
        ).innerHTML = "<p>Enviando datos...</p>";

        // Mostrar los datos que se están enviando de manera visual...
        document.getElementById(
            "datosEnviados"
        ).innerHTML = `<p>Datos enviados: ${JSON.stringify(formData)}</p>`;

        // Enviar la solicitud
        fetch(apiUrl, requestOptions)
            .then((response) => {
                if (!response.ok) {
                    throw new Error("Error en la respuesta de la red");
                }
                // Verificar si la respuesta tiene contenido antes de intentar parsear JSON
                return response.text().then((text) => {
                    try {
                        return text ? JSON.parse(text) : {};
                    } catch (e) {
                        throw new Error("La respuesta no es un JSON válido");
                    }
                });
            })
            .then((data) => {
                // Manejar la respuesta exitosa
                document.getElementById(
                    "respuesta"
                ).innerHTML = `<p>Éxito: ${JSON.stringify(data)}</p>`;
            })
            .catch((error) => {
                // Manejar errores
                document.getElementById(
                    "respuesta"
                ).innerHTML = `<p>Error: ${error.message}</p>`;
                console.error("Error al enviar el formulario:", error);
            });
    });
