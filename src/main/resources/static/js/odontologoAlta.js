const formulario = document.querySelector('#add_new_odontologo');
formulario.addEventListener('submit', function(event){
    event.preventDefault();
    const formData = {
        name: document.querySelector('#name').value,
        lastname: document.querySelector('#lastname').value,
        matricula: document.querySelector('#matricula').value,
    }

    const url = "/odontologos";
        const settings = {
        method:'POST',
        headers: {'Content-Type':'application/json',
        },
        body: JSON.stringify(formData)
        }
        fetch(url, settings)
        .then(response=>response.json())
        .then(data=>{
            let successAlert = '<div class="alert alert-success alert-dismissible">' +
                               '<button type="button" class="close" data-dismiss="alert">&times;</button>' +
                               '<strong></strong> Odontologo agregado </div>'
            $("#response").append(successAlert);
            $("#response").css({"display":"block"});
            resetUploadForm();
        })
           .catch(error => {  let errorAlert = '<div class="alert alert-danger alert-dismissible">' +
                           '<button type="button" class="close" data-dismiss="alert">&times;</button>' +
                           '<strong> Error intente nuevamente</strong> </div>'
               $("#response").append(errorAlert);
               $("#response").css({"display": "block"});
               resetUploadForm();
               })
});

