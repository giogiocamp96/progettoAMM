function createElement(utente){
   
    
    var img = $("<img>")
            .attr("alt","foto profilo amico")
            .attr("class", "fotoprofilolato");
    
    if(utente.urlFoto == null || utente.urlFoto === "")
        img.attr("src", "M3/immagini/picture.png");     
    else img.attr("src", utente.urlFoto);
    
    var name = $("<a>")
            .append(img)
            .attr("href", "bacheca.html?postvisualizzati=true&idUsers="+utente.idUtente)
            .append(utente.nome+" "+utente.cognome);
    
    return $("<li>").append(name);
    
    
}

function stateSuccess(data){
    var utente = $("#people");
    
    $(utente).empty();
    for(var instance in data){
        $(utente).append(createElement(data[instance]));
    }
}
function stateFailure(data, state){
    
     console.log("failure");
    $("#people ul").empty();    
    $("#people ul").append($("<li>").append("Non trovo nessun utente"));    
}


function ricercaDinamica()
{

    var utenteCercato = $("#campoRicerca")[0].value;
        
        $.ajax({
            url: "Filter",
            data:{
                cmd:"search",
                cercaUtente: utenteCercato
            },
        dataType:"json",
        success: function(data, state){
            stateSuccess(data);
        },
        error: function(data, state){
            stateFailure(data, state);
        }
    });

}


$(document).ready(function(){
    $("#cercaUtente").click(function(){
        
        var utenteCercato = $("#campoRicerca")[0].value;
        
        $.ajax({
            url: "Filter",
            data:{
                cmd:"search",
                cercaUtente: utenteCercato
            },
            dataType:"json",
            success: function(data, state){
                stateSuccess(data)
            },
            error: function(data, state){
                stateFailure(data, state)
            }
        });
    })
});

