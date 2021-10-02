window.addEventListener('load', function () {

(function(){
  event.preventDefault();
  const url = '/odontologos/list';
  const settings = {
    method: 'GET'
}
  fetch(url,settings)
  .then(response => response.json())
  .then(data => {
     for(odontologo of data){

       let deleteButton = '<button' +
                                  ' id=' + '\"' + 'btn_delete_' + odontologo.id + '\"' +
                                  ' type="button" onclick="deleteBy('+odontologo.id+')" class="btn btn-danger btn_delete">' +
                                  '&times' +
                                  '</button>';

    let get_More_Info_Btn = '<button' +
                                       ' id=' + '\"' + 'btn_id_' + odontologo.id + '\"' +
                                       ' type="button" onclick="findBy('+odontologo.id+')" class="btn btn-info btn_id">' +
                                       odontologo.id +
                                       '</button>';
    let turnosButton = '<button' +
                                       ' id=' + '\"' + 'btn_id_' + odontologo.id + '\"' +
                                       ' type="button" onclick=location.href="/turnosListPorOdontologo.html/?id='+odontologo.id+'&nombre='+odontologo.nombre+'&apellido='+odontologo.apellido+'" class="btn btn-info btn_id">Getionar turnos</button>';



    let tr_id = 'tr_' + odontologo.id;
    let odontologoRow = '<tr id=\"' + tr_id + "\"" + '>' +
                '<td>' + get_More_Info_Btn + '</td>' +
                '<td class=\"td_nombre\">' + odontologo.nombre + '</td>' +
                '<td class=\"td_apellido\">' + odontologo.apellido + '</td>' +
                '<td class=\"td_matricula\">' + odontologo.matricula + '</td>' +
                '<td class=\"td_usuario\">' + odontologo.usuario + '</td>' +
                '<td class=\"td_password\">' + odontologo.password + '</td>' +

                '<td>' + deleteButton + '</td>' +
                '<td>' + turnosButton + '</td>' +
                '</tr>';
      $('#odontologoTable tbody').append(odontologoRow);
    };

})
})

(function(){
  let pathname = window.location.pathname;
  if (pathname == "/odontologosList.html") {
      document.querySelector(".nav .nav-item a:last").addClass("active");
  }
})


})