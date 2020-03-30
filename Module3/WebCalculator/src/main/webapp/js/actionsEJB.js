/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
function plus() {
    var x = document.getElementById("txtX").value;
    var y = document.getElementById("txtY").value;
    var xhr = new XMLHttpRequest();
    var url = "resources/webCalc/plus";

    xhr.open("GET", url + "?x=" + x + "&y=" + y);
    xhr.onload = function () {
        z = xhr.responseText;
        document.getElementById("txtZ").value = z;
        document.getElementById("btnPlus").className = "pressed";
        document.getElementById("btnMinus").className = "";
    };
    xhr.send();
}
function minus() {
    var x = document.getElementById("txtX").value;
    var y = document.getElementById("txtY").value;
    var xhr = new XMLHttpRequest();
    var url = "resources/webCalc/minus";
    xhr.open("GET", url + "?x=" + x + "&y=" + y);
    xhr.onload = function () {
        z = xhr.responseText;

        document.getElementById("txtZ").value = z;
        document.getElementById("btnPlus").className = "";
        document.getElementById("btnMinus").className = "pressed";
    };
    xhr.send();
}


