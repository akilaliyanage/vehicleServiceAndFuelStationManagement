document.getElementById("btn_newReq").addEventListener("click", function () {

    
    document.getElementById("ro1_section1").style.display = "none";
    //document.getElementById("cate_sel").style.display = "block";
    
    document.getElementById("mah1").style.display = "block";
    //document.getElementById("land_M_1").style.visibility = "visible";
    
    
});

$(document).ready(function(){
    $('#btn_newReq').click(function(){
        var progressBar = document.getElementsByClassName("progress-bar");
        var progressPercent = parseInt($(progressBar).attr("data-progress"));

        $(progressBar).css("width", 3.5 + "%");
    });
});

function ProgressUp(value){
    var progressBar = document.getElementsByClassName("progress-bar");
    $(progressBar).css("width", value + "%");   
}

function goDetails(value){

    ProgressUp(value);

    $(".mah").hide();
    $("#cate_sel").show();
    document.getElementById("land_M_1").style.visibility = "visible";
    $(".Vehi_Details").show();
}
function goTime(value){
    ProgressUp(value);

    $(".Vehi_Details").hide();
    $(".Jumbo2").show();
    $("#Vehicle_details_Demo").show();
    document.getElementById("land_M_2").style.visibility = "visible";
}


function goInvoice(){
    ProgressUp(80);

    $(".Jumbo2").hide();
    $(".invoice").show();
    $("#Time_dimo").show();
    document.getElementById("land_M_3").style.visibility = "visible";
}
