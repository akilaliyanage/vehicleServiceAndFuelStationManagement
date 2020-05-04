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

function goDetails(value , SelectedServiceName , SelectedServiceDescription , servicePrice){

    ProgressUp(value);
    document.getElementById("SelectedServiceName").innerHTML = SelectedServiceName;
	document.getElementById("SelectedServiceDescription").innerHTML = SelectedServiceDescription;
    $(".mah").hide();
    $("#pack_demo").show();
    document.getElementById("land_M_2").style.visibility = "visible";
    $(".Vehi_Details").show();
    document.getElementsByClassName("Invoice_service_price").value = servicePrice;
	document.getElementById("Invoice_ServiceName").innerHTML = SelectedServiceName;
    
}
function goTime(value){
	
		if(document.getElementById("Vehicle_Nosa").value == ""){
			alert("Vehicle Number is Required... Please enter Vehicle Number");
			document.getElementById("Vehicle_Nosa").style.borderColor = "red"
			return false;
		}
		else if(document.getElementById("Vehicle_brand").value == ""){
			//document.getElementById("frameModalTop").style.visibility = "visible";
			alert("Vehicle Brand is Required... Please enter Vehicle Brand");
			document.getElementById("Vehicle_brand").style.borderStyle = "solid"
			document.getElementById("Vehicle_brand").style.borderColor = "red"
			return false;
		}
		else if(document.getElementById("Vehicle_model").value == ""){
			//document.getElementById("frameModalTop").style.visibility = "visible";
			alert("Vehicle Model is Required... Please enter Vehicle Model");
			document.getElementById("Vehicle_model").style.borderStyle = "solid"
			document.getElementById("Vehicle_model").style.borderColor = "red"
			return false;
		}
		else if(document.getElementById("Vehicle_year").value == ""){
			//document.getElementById("frameModalTop").style.visibility = "visible";
			alert("Vehicle Year is Required... Please enter Vehicle Year");
			document.getElementById("Vehicle_year").style.borderStyle = "solid"
			document.getElementById("Vehicle_year").style.borderColor = "red"
			return false;
		}
		else if(document.getElementById("Vehicle_trans").value == "Choose..."){
			//document.getElementById("frameModalTop").style.visibility = "visible";
			alert("Transmission Type Required... Please enter Transmission Type");
			document.getElementById("Vehicle_trans").style.borderStyle = "solid"
			document.getElementById("Vehicle_trans").style.borderColor = "red"
			return false;
		}
		else if(document.getElementById("Vehicle_fuel").value == "Choose..."){
			//document.getElementById("frameModalTop").style.visibility = "visible";
			alert("Fuel Type Required... Please enter Fuel Type");
			document.getElementById("Vehicle_fuel").style.borderStyle = "solid"
			document.getElementById("Vehicle_fuel").style.borderColor = "red"
			return false;
		}
		else{
			
			ProgressUp(value);

		    $(".Vehi_Details").hide();
		    $(".Jumbo2").show();
		    $("#Vehicle_details_Demo").show();
		    document.getElementById("land_M_3").style.visibility = "visible";
		    alert("please enter the phone number again" + document.getElementsById("Vehicle_Nosa").value);
		}
	   	
		
}


function goInvoice(){
    ProgressUp(100);

    $(".Jumbo2").hide();
    $(".invoice").show();
    $("#Time_dimo").show();
    document.getElementById("land_M_4").style.visibility = "visible";
}

function DispPack(PackName , PackDescription , PackPrice){
	document.getElementById("SelectedPackName").innerHTML = PackName;
	document.getElementById("InvoicePack_name").innerHTML = PackName;
	document.getElementById("SelectedPackDescription").innerHTML = PackDescription;
	document.getElementById("Invoice_package_price").innerHTML = PackPrice;
}

function getSpricejs(price) {
	document.getElementById("Invoice_package_price").innerHTML = price;
	document.getElementById("Invoice_package_price_amm").innerHTML = price;
	getSpricejs.PACprice = price;
}

function DispInvoiceServiceprice(price) {
	document.getElementById("Invoice_service_price").innerHTML = price;
	document.getElementById("Invoice_service_price_amm").innerHTML = price;
	
	var tot = +getSpricejs.PACprice + +price;
	document.getElementById("InvoiceTot").innerHTML = tot + ".00 Rs";
	var tax = +tot * +0.05;
	document.getElementById("InvoiceTax").innerHTML = tax + ".00 Rs";
	var final = +tot + -tax;
	document.getElementById("BillValue").innerHTML = final + ".00 Rs";
	
	document.getElementById("InvoiceDate").innerHTML = new Date().toDateString();
	
}

function ServiceImgSetter(path) {
	
	if(path == ""){
		document.getElementById("ServiceSelectionImg").src = "https://mdbootstrap.com/img/Mockups/Lightbox/Thumbnail/img%20(67).jpg";
	}
	else
		document.getElementById("ServiceSelectionImg").src = path;
}
function PackageImgSetter(path) {
	if(path == ""){
		document.getElementById("PackageSelectionImg").src = "https://mdbootstrap.com/img/Mockups/Lightbox/Thumbnail/img%20(67).jpg";
	}
	else
		document.getElementById("PackageSelectionImg").src = path;
}





