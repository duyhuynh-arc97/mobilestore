//Handle back button
function back() {
    document.getElementsByTagName("form")[0].setAttribute("action", "home.jsp");
}

//Get data from sessionstorage
var obj = JSON.parse(localStorage.getItem("orderlist"));

for (let i = 0; i < obj.length; i++) {
    document.querySelector(".item").innerHTML +=
        ` <tr>
    <td class="name">${obj[i].name}</td>
    <td class="quantity">${obj[i].quantity}</td>
    <td class="unitprice">${obj[i].unitprice}</td>
    <td class="price">${obj[i].price}</td>
    <td><button class="removebtn" type="button"><i class="fas fa-times"></i> Remove</button></td>
        </tr>`
}

//Calculate the total price
var a = document.getElementsByClassName("price");

function updatetotal() {
    var sum = 0;
    for (let i = 0; i < a.length; i++) {
        sum += parseInt(a[i].innerHTML);
    }
    document.getElementById("total").innerHTML = sum;
}

updatetotal();

//Handle remove buttons
var removebtns = document.getElementsByClassName("removebtn");
for (let i = 0; i < removebtns.length; i++) {
    var btn = removebtns[i];
    btn.addEventListener('click', function(e) {
        var btnclicked = e.target;
        var container = btnclicked.parentElement.parentElement;

        for (let i = 0; i < obj.length; i++) {
            if (obj[i].name == container.getElementsByClassName("name")[0].innerHTML) {
                obj.splice(i, 1);
                break;
            }
        }

        container.remove();
        localStorage.setItem("orderlist", JSON.stringify(obj));
        updatetotal();
    })
}

//Handle clear button
var clearbtn = document.getElementById("clearbtn");
clearbtn.addEventListener("click", function() {
    document.getElementsByClassName("item")[0].innerHTML = "";
    obj = [];
    localStorage.setItem("orderlist", JSON.stringify(obj));
    updatetotal();
});