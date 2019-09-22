function getQueryVariable(variable)
{
       var query = window.location.search.substring(1);
       var vars = query.split("&");
       for (var i=0;i<vars.length;i++) {
               var pair = vars[i].split("=");
               if(pair[0] == variable){return pair[1];}
       }
       return(false);
}
function getKeyVariable(variable){
   var key = getQueryVariable(variable);
}
function modalMostrar(){
    
    var urlparam = getQueryVariable('busqueda');
    if ((urlparam!=null) && (urlparam!="") && (urlparam!="BusqTodas")) {
        document.getElementsByName('busqueda')[0].setAttribute('value',urlparam);
        document.getElementsByName('criterioBusqueda')[0].setAttribute('value'," ");
        $(".modalBusqueda").modal('show');
    }     
}

function modalOcultar(){
    
    if($('.modalBusqueda').data('modal') && $('.modalBusqueda').data('modal').isShown) { 
        $('.modalBusqueda').modal('hide'); 
    
    } 
    
    
}


// function pasarBusq(){
  //   var criterio = document.getElementsByName("criterioBusqueda")[0].value;
    // var miTabladatos = document.getElementById("formtabla:tabladatos").value;
     //miTabladatos.DataTable().destroy();
    // criterio= criterio.trim();
     //var miTabla = ${'#peliculaController.Busqueda("' + criterio + '")'};
     //var lista = getLista(criterio);
    // var lista = getprueba2(criterio);
    // $('#tabladatos').DataTable();
    // console.log(criterio.trim());
     
    // $('#tabladatos').DataTable().destroy();
     //comprobar si hay datos.
    // $('#tabladatos').DataTable().dataSet=lista; 
     //console.log(criti);
     
//var miTabladatos = document.getElementById("tabladatos");
     //miTabladatos.setAttribute("value",nuevaLista);
     //var critBusq = document.getElementById("criterioBusqueda").value;
     //return critBusq;
     //var temp = '#{peliculaController.Busqueda(' + critBusq + ")}'";
     //document.getElementById("tabladatos").value='#{peliculaController.Busqueda(' + critBusq + ")}'";
     //console.log ("Criterio:  " +  temp);
 //}
    


