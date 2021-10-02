window.addEventListener('load', function () {
    const formulario = document.querySelector('#update_turno_form');
    formulario.addEventListener('submit', function (event) {
        let turnoId = document.querySelector('#turno_id').value;
        const formData = {
            fechaHora: document.querySelector('#fechaHora').value,
            paciente:{id: document.querySelector('#paciente_select').value,
            }
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
          fetch(url,settings)
          .then(response => response.json())

    })
 })

