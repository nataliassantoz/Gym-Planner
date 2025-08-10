//Busca no HTML elementos com os IDs especificados e Retorna os elementos como objetos do DOM
const emailInput = document.getElementById("email");
const senhaInput = document.getElementById("senha");
const nomeInput = document.getElementById("nome");

const nomeField = document.getElementById("nome-field");
const btnLogin = document.getElementById("login");
const btnCadastro = document.getElementById("cadastro");
const btnSubmit = document.getElementById("submit");

let modo = "login"; 

btnLogin.addEventListener("click", () => {
    modo = "login"; 
    nomeField.classList.add("hidden");
    btnLogin.classList.add("active");
    btnCadastro.classList.remove("active");

});

btnCadastro.addEventListener("click", () => {
    modo = "cadastro";
    nomeField.classList.remove("hidden");
    btnCadastro.classList.add("active");
    btnLogin.classList.remove("active");
});


btnSubmit.addEventListener("click", async (e) => {
    e.preventDefault();

    const email = emailInput.value;
    const senha = senhaInput.value;
    const nome = nomeInput.value;

    if (!email || !senha || (modo === "cadastro" && !nome)) {
        alert("Preencha todos os campos obrigatórios.");
        return;
    }

    const url = modo === "login" ? "http://localhost:8080/auth/login" : "http://localhost:8080/auth/registro";


    const payload = modo === "login"  ? { email, senha } : { nome, email, senha, tipo: "CLIENTE" };


    try{

        const resposta = await fetch(url, {
            method: "POST",
            headers: {
                "Content-type": "application/json"
            },
            body: JSON.stringify(payload)
        });

        const dados = await resposta.json();

        if(resposta.ok){

            localStorage.setItem("usuarioId", dados.usuarioId);

            alert(dados.mensagem + "\nBem-vindo, " +  (dados.nome || nome));

            if (modo === "cadastro") {
                // Se acabou de se cadastrar, manda para a tela de completar perfil
                window.location.href = "../perfil/Perfil.html";
            } else {
                // Se fez login, manda direto para o planner
                window.location.href = "../planner/planner.html";
            }
        }
        else{
            alert("Erro: " + (dados.erro || dados.message || "Tente novamente"));
        }
    }
    catch(error){
        alert("Erro na requisição" + error);
    }

});
