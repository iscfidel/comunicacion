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
            .then(response => {
                if (!response.ok) throw new Error("Error en la respuesta");
                return response.text();  // Primero lee como texto
            })
            .then(text => {
                try {
                    const data = JSON.parse(text);  // Intenta parsear manualmente
                    document.getElementById("respuesta").innerHTML = `<p>Éxito: ${data.respuesta}</p>`;
                } catch (e) {
                    // Si no es JSON, muestra el texto plano
                    document.getElementById("respuesta").innerHTML = `<p>Éxito: ${text}</p>`;
                }
            })
            .catch(error => {
                console.error("Error:", error);
                document.getElementById("respuesta").innerHTML = `<p>Error: ${error.message}</p>`;
            });
    });
