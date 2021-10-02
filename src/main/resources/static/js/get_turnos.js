window.addEventListener('load', function () {
event.preventDefault();

//crear funcion para obtener datos de la url
const valores = window.location.search;
const urlParams=new URLSearchParams(valores);
const odontologoId=urlParams.get('id');
const odontologo =urlParams.get('nombre')+' '+urlParams.get('apellido');


    const titulo_turnos = document.getElementById('titulo_turnos');
    titulo_turnos.innerHTML = 'Turnos: Od. '+odontologo;

    document.getElementById('odontologo_nombre').value = odontologo;
    document.getElementById('odontologo_id').value = odontologoId;
document.getElementById('odontologoNombre').value = urlParams.get('nombre');
document.getElementById('odontologoApellido').value = urlParams.get('apellido');


    document.getElementById('fechaHora_turno').value = '2021-10-30T12:00:00	';



(function(){
  event.preventDefault();
  const url = '/turnos/list/';
  const settings = {
    method: 'GET'
    }


  fetch(url+odontologoId,settings)
  .then(response => response.json())
  .then(data => {
     for(turno of data){

       let deleteButton = '<button' +
                                  ' id=' + '\"' + 'btn_delete_' + turno.id + '\"' +
                                  ' type="button" onclick="deleteBy('+turno.id+')" class="btn btn-danger btn_delete">' +
                                  '&times' +
                                  '</button>';

     let get_More_Info_Btn = '<button' +
                                       ' id=' + '\"' + 'btn_id_' + turno.id + '\"' +
                                       ' type="button" onclick="" class="btn btn-info btn_id">' +
                                       turno.id +
                                       '</button>';

      let tr_id = 'tr_' + turno.id;

      let turnoRow = '<tr id=\"' + tr_id + "\"" + '>' +
                '<td>' + get_More_Info_Btn + '</td>' +
                  '<td class=\"td_disponible\">' + turno.disponible + '</td>' +
                  '<td class=\"td_fechaHora\">' + turno.fechaHora + '</td>' ;
      if(turno.paciente != null){
            turnoRow +='<td class=\"td_nombre\">' + turno.paciente.nombre + '</td>';
            turnoRow +='<td class=\"td_aApellido\">' + turno.paciente.apellido + '</td>';

      }else {turnoRow +='<td class=\"td_nombre\">  </td>'+
                        '<td class=\"td_apellido\">  </td>';}

            turnoRow += '<td>' + deleteButton + '</td>' +
                '</tr>';
      $('#turnosTable tbody').append(turnoRow);
    };

  })

  //select pacientes
  const paciente_select = document.getElementById('paciente_select');
  fetch('/pacientes/list/',settings)
    .then(response => response.json())
    .then(data => {
       for(paciente of data){
          paciente_select.innerHTML +=
              '<option value=\"'+paciente.id+'">'+paciente.dni+'-'+paciente.apellido+' '+paciente.nombre+'</option>';
       }
    })

})

(function(){
  let pathname = window.location.pathname;
  if (pathname == "/turnoList.html") {
      document.querySelector(".nav .nav-item a:last").addClass("active");
  }
})


})