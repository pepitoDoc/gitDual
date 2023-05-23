window.addEventListener(
  "DOMContentLoaded",
  () => {
    document.querySelector("#botonRegistro").addEventListener(
      "click",
      (e) => {
        const nameInput = document.querySelector("#nickname").value;
        const passwordInput = document.querySelector("#password").value;
        const emailInput = document.querySelector("#email").value;
        if (nameInput != "" && passwordInput != "") {
            if (passwordInput.indexOf(" ") !== -1 || nameInput.indexOf(" ") !== -1) {
                alert("La contraseña y el nombre no pueden tener espacios");
            } else {
              const userData = {
                nickname: nameInput,
                password: passwordInput,
                email: emailInput
              };
              fetch("http://localhost:8080/WebProject/add-player", {
                method: "POST",
                headers: { "Content-Type": "application/json" },
                body: JSON.stringify(userData)
              })
                .then((response) => {
                  if (response.status == 500) {
                    window.location.replace("http://localhost:8080/WebProject/error/error.jsp");
                  } else {
                    return response.text()
                  }
                })
                .then((data) => {
                  if (data == "1") {
                    alert("Ya existe un usuario con ese nombre");
                  } else if (data == "2") {
                    alert("Ya existe un usuario con ese correo");
                  } else if (data == "0") {
                    alert("Usuario registrado");
                    window.location.replace("http://localhost:8080/WebProject/index.jsp");
                  } else if (data == "3") {
                    window.location.replace("http://localhost:8080/WebProject/error/error.jsp");
                  }
                })
                .catch((error) => {
                  window.location.replace("http://localhost:8080/WebProject/error/error.jsp");
                });
            }
        } else {
          alert("No puede haber campos en blanco");
        }
      },
      false
    );
  },
  false
);
