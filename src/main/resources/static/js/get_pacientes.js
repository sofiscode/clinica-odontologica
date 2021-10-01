window.addEventListener('load', function () {

(function(){
  event.preventDefault();
  const url = '/pacientes/list';
  const settings = {
    method: 'GET'
}
  fetch(url,settings)
  .then(response => response.json())
  .then(data => {
     for(paciente of data){

       let deleteButton = '<button' +
                                  ' id=' + '\"' + 'btn_delete_' + paciente.id + '\"' +
                                  ' type="button" onclick="deleteBy('+paciente.id+')" class="btn btn-danger btn_delete">' +
                                  '&times' +
                                  '</button>';

      let get_More_Info_Btn = '<button' +
                                  ' id=' + '\"' + 'btn_id_' + paciente.id + '\"' +
                                  ' type="button" onclick="findBy('+paciente.id+')" class="btn btn-info btn_id">' +
                                  paciente.id +
                                  '</button>';

      let tr_id = 'tr_' + paciente.id;
      let pacienteRow = '<tr id=\"' + tr_id + "\"" + '>' +
                '<td>' + get_More_Info_Btn + '</td>' +
                '<td class=\"td_nombre\">' + paciente.nombre + '</td>' +
                '<td class=\"td_apellido\">' + paciente.apellido + '</td>' +
                '<td class=\"td_dni\">' + paciente.dni + '</td>' +
                '<td class=\"td_calle\">' + paciente.domicilio.calle + '</td>' +
                '<td class=\"td_numero\">' + paciente.domicilio.numero + '</td>' +
                '<td class=\"td_piso\">' + paciente.domicilio.piso + '</td>' +
                '<td class=\"td_localidad\">' + paciente.domicilio.localidad + '</td>' +
                '<td class=\"td_provincia\">' + paciente.domicilio.provincia + '</td>' +
                '<td class=\"td_fechaDeAlta\">' + paciente.fechaDeAlta + '</td>' +

                '<td>' + deleteButton + '</td>' +
                '</tr>';
      $('#pacienteTable tbody').append(pacienteRow);
    };

})
})

(function(){
  let pathname = window.location.pathname;
  if (pathname == "/pacientesList.html") {
      document.querySelector(".nav .nav-item a:last").addClass("active");
  }
})


})