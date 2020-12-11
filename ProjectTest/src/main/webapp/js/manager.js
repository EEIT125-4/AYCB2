var isShow = false;
var addShow = false;

function show1() {
    if (!isShow) {
        isShow = true;
        document.getElementById('ul1').style.display = 'block';
        document.getElementById('a1').innerText = "-";
    } else {
        isShow = false;
        document.getElementById('ul1').style.display = 'none';
        document.getElementById('a1').innerText = "+";
    }
}

function show2() {
    if (!isShow) {
        isShow = true;
        document.getElementById('ul2').style.display = 'block';
        document.getElementById('a2').innerText = "-";
    } else {
        isShow = false;
        document.getElementById('ul2').style.display = 'none';
        document.getElementById('a2').innerText = "+";
    }
}

function show3() {
    if (!isShow) {
        isShow = true;
        document.getElementById('ul3').style.display = 'block';
        document.getElementById('a3').innerText = "-";
    } else {
        isShow = false;
        document.getElementById('ul3').style.display = 'none';
        document.getElementById('a3').innerText = "+";
    }
}

function add() {
    if (!addShow) {
        addShow = true;
        document.getElementById('add').style.display = 'block';
    } else {
        addShow = false;
        document.getElementById('add').style.display = 'none';
    }
}

update.addEventListener("click", function () {
            infoprice.className = "updateprice";
            updatebox.style.display = "block";
            update.style.display = "none";
        });