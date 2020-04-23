document.getElementById("btn_newReq").addEventListener("click", function () {

    
    document.getElementById("ro1_section1").style.display = "none";
    //document.getElementById("cate_sel").style.display = "block";
    
    document.getElementById("P_selection").style.display = "block";
    //document.getElementById("land_M_1").style.visibility = "visible";
    
    
});



function weekpick() {

    var dat = document.getElementById("Week_selector").value;

    var curr = new Date(document.getElementById("Week_selector").value); // get current date
    var first = curr.getDate() - curr.getDay(); // First day is the day of the month - the day of the week

    var headerDate = [];
    var valueDate = [];
    for(var i = 0 ; i < 7 ; i++){
        headerDate[i] = new Date(curr.setDate(first + i)).toDateString();

        t_date = new Date(curr.setDate(first + i)).getDate();
        t_month = new Date(curr.setDate(first + i)).getMonth() + 1;
        t_Year = new Date(curr.setDate(first + i)).getFullYear();

        valueDate[i] = t_Year + "-" + (t_month <= 9 ? '0' + t_month : t_month) + "-" + (t_date <= 9 ? '0' + t_date : t_date);
    }

    document.getElementById("SUN").innerHTML = headerDate[0];
    document.getElementById("MON").innerHTML = headerDate[1];
    document.getElementById("TUE").innerHTML = headerDate[2];
    document.getElementById("WED").innerHTML = headerDate[3];
    document.getElementById("THU").innerHTML = headerDate[4];
    document.getElementById("FRI").innerHTML = headerDate[5];
    document.getElementById("SAT").innerHTML = headerDate[6];

    document.getElementsByClassName("Sunday_date").value = valueDate[0];
    document.getElementsByClassName("Monday_date").value = valueDate[1];
    document.getElementsByClassName("Tuesday_date").value = valueDate[2];
    document.getElementsByClassName("Wednesday_date").value = valueDate[3];
    document.getElementsByClassName("Thursday_date").value = valueDate[4];
    document.getElementsByClassName("Friday_date").value = valueDate[5];
    document.getElementsByClassName("Saturday_date").value = valueDate[6];

   // document.getElementsByClassName("jumbo2_part2").style.display = "none";
    $(".jumbo2_part2").show();
}



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

function goService(value) {

    ProgressUp(value);
    
    $("#P_selection").hide();
    $(".mah").show();
    $("#cate_sel").show();
    document.getElementById("land_M_1").style.visibility = "visible";
   // $(".Vehi_Details").show();
}

function goDetails(value){

    ProgressUp(value);

    $(".mah").hide();
    $("#pack_demo").show();
    document.getElementById("land_M_2").style.visibility = "visible";
    $(".Vehi_Details").show();
}
function goTime(value){
    ProgressUp(value);

    $(".Vehi_Details").hide();
    $(".Jumbo2").show();
    $("#Vehicle_details_Demo").show();
    document.getElementById("land_M_3").style.visibility = "visible";
}


function goInvoice(){
    ProgressUp(100);

    $(".Jumbo2").hide();
    $(".invoice").show();
    $("#Time_dimo").show();
    document.getElementById("land_M_4").style.visibility = "visible";
}






