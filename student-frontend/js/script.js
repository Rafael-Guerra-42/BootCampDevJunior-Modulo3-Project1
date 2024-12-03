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

