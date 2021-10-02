window.addEventListener('load', function () {
    const formulario = document.querySelector('#add_new_paciente');
    formulario.addEventListener('submit', function (event) {
        event.preventDefault();
        const formData = {
           // id: document.querySelector('#paciente_id').value,
            usuario: document.querySelector('#usuario').value,
            password: document.querySelector('#password').value,
            nombre: document.querySelector('#nombre').value,
            apellido: document.querySelector('#apellido').value,
            dni: document.querySelector('#dni').value,
            domicilio: {
            //id: document.querySelector('#domicilio').value,
                        calle: document.querySelector('#calle').value,
                        numero: document.querySelector('#numero').value,
                        piso: document.querySelector('#piso').value,
                        localidad: document.querySelector('#localidad').value,
                        provincia: document.querySelector('#provincia').value
                        }
//            fechaDeAlta: document.querySelector('#fechaDeAlta').value,
//            rol: {id: document.querySelector('#rol').value}

        };

        const url = '/pacientes';
        const settings = {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify(formData)
        }

        fetch(url, settings)
            .then(response => response.json())
            .then(data => {
                 let successAlert = '<div class="alert alert-success alert-dismissible">' +
                     '<button type="button" class="close" data-dismiss="alert">&times;</button>' +
                     '<strong></strong> paciente agregado </div>'

                 document.querySelector('#response').innerHTML = successAlert;
                 document.querySelector('#response').style.display = "block";
                 resetUploadForm();

                 window.setTimeout(redirect, 2000);

            })
            .catch(error => {
                    let errorAlert = '<div class="alert alert-danger alert-dismissible">' +
                                     '<button type="button" class="close" data-dismiss="alert">&times;</button>' +
                                     '<strong> Error intente nuevamente</strong> </div>'

                      document.querySelector('#response').innerHTML = errorAlert;
                      document.querySelector('#response').style.display = "block";
                     resetUploadForm();})
    });
function redirect() {
        window.location = "/pacientesList.html";
   }
    function resetUploadForm(){
        document.querySelector('#usuario').value = "";
        document.querySelector('#password').value = "";
        document.querySelector('#nombre').value = "";
        document.querySelector('#apellido').value = "";
        document.querySelector('#dni').value = "";
//        document.querySelector('#domicilio').value = paciente.domicilio.id;
        document.querySelector('#calle').value = "";
        document.querySelector('#numero').value = "";
        document.querySelector('#piso').value = "";
        document.querySelector('#localidad').value = "";
        document.querySelector('#provincia').value = "";
//        document.querySelector('#fechaDeAlta').value = paciente.fechaDeAlta;
//        document.querySelector('#rol').value = paciente.rol.id;


    }

    (function(){
        let pathname = window.location.pathname;
        if(pathname === "/"){
            document.querySelector(".nav .nav-item a:first").addClass("active");
        } else if (pathname == "/pacientesList.html") {
            document.querySelector(".nav .nav-item a:last").addClass("active");
        }
    })();
});