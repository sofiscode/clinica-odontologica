window.addEventListener('load', function () {
    const formulario = document.querySelector('#update_paciente_form');
    formulario.addEventListener('submit', function (event) {
        let pacienteId = document.querySelector('#paciente_id').value;
        const formData = {
            id: document.querySelector('#paciente_id').value,
            usuario: document.querySelector('#usuario').value,
            password: document.querySelector('#password').value,
            nombre: document.querySelector('#nombre').value,
            apellido: document.querySelector('#apellido').value,
            dni: document.querySelector('#dni').value,
               domicilio: {id: document.querySelector('#domicilio').value,
                         calle: document.querySelector('#calle').value,
                         numero: document.querySelector('#numero').value,
                         piso: document.querySelector('#piso').value,
                         localidad: document.querySelector('#localidad').value,
                         provincia: document.querySelector('#provincia').value
                },
            fechaDeAlta: document.querySelector('#fechaDeAlta').value,
            rol: {id: document.querySelector('#rol').value}

        };

        const url = '/pacientes';
        const settings = {
            method: 'PUT',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify(formData)
        }
          fetch(url,settings)
          .then(response => response.json())

    })
 })

    function findBy(id) {
          const url = '/pacientes'+"/"+id;
          const settings = {
              method: 'GET'
          }
          fetch(url,settings)
          .then(response => response.json())
          .then(data => {
              let paciente = data;
              document.querySelector('#paciente_id').value = paciente.id;
              document.querySelector('#usuario').value = paciente.usuario;
              document.querySelector('#password').value = paciente.password;
              document.querySelector('#nombre').value = paciente.nombre;
              document.querySelector('#apellido').value = paciente.apellido;
              document.querySelector('#dni').value = paciente.dni;
              document.querySelector('#domicilio').value = paciente.domicilio.id;
              document.querySelector('#calle').value = paciente.domicilio.calle;
              document.querySelector('#numero').value = paciente.domicilio.numero;
              document.querySelector('#piso').value = paciente.domicilio.piso;
              document.querySelector('#localidad').value = paciente.domicilio.localidad;
              document.querySelector('#provincia').value = paciente.domicilio.provincia;
              document.querySelector('#fechaDeAlta').value = paciente.fechaDeAlta;
              document.querySelector('#rol').value = paciente.rol.id;


              document.querySelector('#div_paciente_updating').style.display = "block";
          }).catch(error => {
              alert("Error: " + error);
          })
      }