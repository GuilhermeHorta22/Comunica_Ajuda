function registrarCategoria() {
    const nome = document.getElementById("nomeCategoria").value;

    const myHeaders = new Headers();
    myHeaders.append("Content-Type", "application/json");

    const raw = JSON.stringify({
        nome
    });

    const requestOptions = {
    method: "POST",
    headers: myHeaders,
    body: raw
    };

    fetch("http://localhost:8080/apis/categoria", requestOptions)
    .then((response) => response.text())
    .then((result) => console.log(result))
  .catch((error) => console.error(error));
}



function registrarRelato()
{
    const titulo = document.getElementById("tituloRelato").value;
    const descricao = document.getElementById("descricaoRelato").value;
    const urgencia = document.getElementById("urgenciaRelato").value;
    const categoria = document.getElementById("categoriaRelato").value;
    const localizacao = document.getElementById("localizacaoRelato").value;
    const status = document.getElementById("statusRelato").value;
    const notaAdm = document.getElementById("notaAdmRelato").value;
    const criaEm = document.getElementById("criadoEmRelato").value;

    const myHeaders = new Headers();
    myHeaders.append("Content-Type", "application/json");

    const raw = JSON.stringify({
        titulo,
        descricao,
        urgencia,
        categoria: {
            id: parseInt(categoria)
        },
        localizacao,
        status,
        notaAdm,
        criaEm
    });

    const requestOptions = {
        method: "POST",
        headers: myHeaders,
        body: raw
    };

    fetch("http://localhost:8080/apis/relatos", requestOptions)
    .then((response) => response.text())
    .then((result) => console.log(result))
    .catch((error) => console.error(error));
}