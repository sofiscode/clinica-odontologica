window.addEventListener('load', function () {
    const formulario = document.querySelector('#add_new_turno');
    formulario.addEventListener('submit', function (event) {
        event.preventDefault();

                const formData = {
                    fechaHora: document.querySelector('#fechaHora_turno').value,
                    paciente:{id: document.querySelector('#paciente_select').value,
                    },
                    odontologo:{id: document.querySelector('#odontologo_id').value,
                                }
                };

        const url = '/turnos';
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
                     '<strong>Turno agregado</strong> </div>'

                 document.querySelector('#response').innerHTML = successAlert;
                 document.querySelector('#response').style.display = "block";
                 resetUploadForm();

               //  window.setTimeout(redirect, 2000);
            })
            .catch(error => {
                    let errorAlert = '<div class="alert alert-danger alert-dismissible">' +
                                     '<button type="button" class="close" data-dismiss="alert">&times;</button>' +
                                     '<strong> Error intente nuevamente</strong> </div>'

                      document.querySelector('#response').innerHTML = errorAlert;
                      document.querySelector('#response').style.display = "block";
                     resetUploadForm();})
    });
const odontologoId= document.getElementById('odontologo_id').value;
 const odontologoNombre =document.getElementById('odontologoNombre').value;
 const odontologoApellido =document.getElementById('odontologoApellido').value;
//   function redirect() {
//        window.location = "/turnosListPorOdontologo.html/?id="+odontologoId+"'&nombre='"+odontologoNombre+'&apellido='+odontologoApellido'";
//   }
    function resetUploadForm(){
//        document.querySelector('#usuario').value = "";
//        document.querySelector('#password').value = "";
//        document.querySelector('#nombre').value = "";
//        document.querySelector('#apellido').value = "";
//        document.querySelector('#matricula').value = "";
    }

    (function(){
        let pathname = window.location.pathname;
        if(pathname === "/turnosList.html"){
            document.querySelector(".nav .nav-item a:first").addClass("active");
        } else if (pathname == "/turnosList.html") {
            document.querySelector(".nav .nav-item a:last").addClass("active");
        }
    })();
});