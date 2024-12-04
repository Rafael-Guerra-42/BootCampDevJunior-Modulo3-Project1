LoadCourses();
LoadShifts();
LoadStudents();
indexIncrement = 1;
document.getElementById("alert").hide();
function AddForm(){
    document.getElementById("alertPlace").innerHTML=""
    if(document.getElementById("name").value=="" || document.getElementById("email").value=="" || document.getElementById("phone").value==""){
        document.getElementById("alertPlace").innerHTML+=
        `
        <div class="alert alert-warning" id="alert">
            <strong>Favor preencher todos os campos para cadastrar.</strong>
        </div>
        `

    }else
    {
        indexIncrement++;
        document.getElementById("dataInsertion").innerHTML+=
        `
        <div class="row">
            <div class="col-1">${indexIncrement}</div>
            <div class="col-3">${document.getElementById("name").value}</div>
            <div class="col-3 d-none d-sm-block">${document.getElementById("email").value}</div>
            <div class="col-3 d-none d-sm-block">${document.getElementById("phone").value}</div>
            <div class="col-1 d-none d-sm-block">${document.getElementById("categorySelection").value}</div>
            <div class="col-1 d-none d-sm-block">${SelectedRadioButton(document.getElementsByName("exampleRadios"))}</div>
        </div>
        <hr>
        `;
        document.getElementById("name").value = "";
        document.getElementById("email").value = "";
        document.getElementById("phone").value = "";
    
    }
};
function SelectedRadioButton(radioButton){
    for (let i =0; i<radioButton.length; i++){

        if (radioButton[i].checked){
            return radioButton[i].value;
        }

    }
};

//

var students=[];
var courses= [];
var shifts = []

function save (){



}
function LoadCourses(){
    $.ajax({
            url: "http://localhost:8080/courses",
            type: "GET",
            async: false,
            success: (response) =>{
            courses = response;
            for (var c of courses){
                document.getElementById("courseSelection").innerHTML+= '<option value='+c.id+'>'+c.name+'</option>';
            }
            

            }

    });
}


function LoadShifts(){
    $.ajax({
            url: "http://localhost:8080/shifts",
            type: "GET",
            async: false,
            success: (response) =>{
            shifts = response;
            for (var s of shifts){
                shifts.push(s);
            }
            

            }

    });
}


function LoadStudents(){
    $.getJSON("http://localhost:8080/students", (response) =>{
        students = response;
            for(let stud of students){
                AddNewRow(stud);
            }



    });




}



function AddNewRow(stud){
    var table = document.getElementById("studentsTable");
    
    var newRow = table.insertRow();

    var idNode = document.createTextNode(stud.id);
    newRow.insertCell().appendChild(idNode);

    var nameNode = document.createTextNode(stud.name);
    newRow.insertCell().appendChild(nameNode);

    var emailNode = document.createTextNode(stud.email);
    newRow.insertCell().appendChild(emailNode);

    var phoneNode = document.createTextNode(stud.phone);
    newRow.insertCell().appendChild(phoneNode);

    var courseNode = document.createTextNode(courses[stud.idCourse-1].name);
    newRow.insertCell().appendChild(courseNode);

    var shiftNode = document.createTextNode(shifts[stud.idShift-1].name);
    newRow.insertCell().appendChild(shiftNode);


}