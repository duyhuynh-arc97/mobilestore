//Get information
var obj = JSON.parse(sessionStorage.getItem("gotitem"));

document.getElementById("image").src = obj.image;
document.getElementById("name").innerHTML = obj.name;
document.getElementById("desc").innerHTML = obj.desc;
document.getElementById("manufact").innerHTML = `<b>Manufacturer: </b>${obj.manufacturer}`;
document.getElementById("category").innerHTML = `<b>Category: </b><a style="color: rgb(25, 103, 248);">${obj.category}`;
document.getElementById("stock").innerHTML = `<b>Available units in stock: </b>${obj.instock}`;
document.getElementById("price").innerHTML = obj.unitprice + " USD";

//Handle backbutton
function back() {
    document.getElementsByTagName("form")[0].setAttribute("action", "home.jsp");
}

//Handle order buttons
var orderbtn = document.getElementById("orderbtn");
var list2 = JSON.parse(localStorage.getItem("listproduct"));
var a = JSON.parse(localStorage.getItem("orderlist"));

orderbtn.addEventListener("click", function() {
    var name = document.getElementById("name").innerHTML;
    var count = 0;

    for (let i = 0; i < list2.length; i++) {
        if (list2[i].name == name) {
            var selected2 = {
                name: list2[i].name,
                unitprice: list2[i].unitprice,
                price: list2[i].unitprice,
                quantity: 1
            }
        }
    }

    for (let i = 0; i < a.length; i++) {
        if (a[i].name == selected2.name) {
            a[i].quantity += 1;
            a[i].price = a[i].unitprice * a[i].quantity;
            count++;
            break;
        }
    }

    if (count == 0) {
        a.push(selected2);
    }
    localStorage.setItem("orderlist", JSON.stringify(a));
    alert("Order succesfully!");
})