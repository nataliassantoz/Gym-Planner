//captura o formulario preenchido
const perfil = document.getElementById("perfil");

//quando enviar o formualrio
perfil.addEventListener("submit", async(e) => {
    e.preventDefault();

    // Pega o ID do usuário salvo no localStorage (durante login/cadastro)
    const usuarioId = localStorage.getItem("usuarioId");

    //
    if (!usuarioId) {
        alert("Usuário não encontrado. Faça login novamente.");
        window.location.href = "/auth.html";
        return;
    }

      // Monta o objeto com os dados do formulário
    const perfil = {
        usuarioId: usuarioId,
        altura: document.getElementById("altura").value,
        peso: document.getElementById("peso").value,
        idade: document.querySelector("input[name='idade']").value,
        sexo: document.querySelector("input[name='sexo']:checked").value,
        objetivo: document.querySelector("input[name='objetivo']:checked").value,
        nivel: document.querySelector("input[name='nivel']:checked").value
    };

    try{

        const resposta = await fetch("http://localhost:8080/perfil/cadastrarPerfil", {
             method: "POST",
            headers: {
                "Content-Type": "application/json"
            },
            body: JSON.stringify(perfil)
        });

        const dados = await resposta.json();

        if (resposta.ok) {
            
            localStorage.setItem("usuarioId", dados.usuarioId);

            alert(dados.mensagem || "Perfil salvo com sucesso!");
            window.location.href = "/planner.html"; // Vai para o planner
        } else {
            alert("Erro: " + (dados.erro || dados.message || "Tente novamente"));
        }
    }
    catch (error) {
        alert("Erro na requisição: " + error);
    }

    
});