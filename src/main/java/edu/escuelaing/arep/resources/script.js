let numberc;
let numberf;
let res1;
let res2;
let res = "";



function inputValues() {
    const url = 'https://arep-backend-jc.herokuapp.com/convert';
    const devUrl = 'http://localhost:5000/convert';`ds`
    numberc = document.getElementsByName("numbercel")[0].value;
    numberf = document.getElementsByName("numberfah")[0].value;
    console.log(numberc, numberf);
    console.log(numberc==null, numberf == null);

    const url1 = `${url}/celsiusF?value=${numberc}`;
    const url2 = `${url}/fahrenheitC?value=${numberf}`;

    getapi(url1, url2, "C", "F");
}

async function getapi (url1, url2, s, c) {
    res1 = "";
    res2 = "";

    if(numberc != "") {
        try {
            const response = await fetch(url1, {method: 'GET', headers: {'Content-Type': 'application/json'}});
            let data = await response.json();
            res1 = `su resultado en ${s} es ${data.result}`;

        }catch (e) {
            console.log(e);
        }
    }
    if (numberf != "") {
        try {
            const response = await fetch(url2, {method: 'GET', headers: {'Content-Type': 'application/json'}});
            let data = await response.json();
            res2 = `su resultado en ${c} es ${data.result}`;

        }catch (e) {
            console.log(e);
        }
    }
    console.log(res1.result, res2.result);
    var x = document.getElementById("resultt");
    x.querySelector(".example").innerHTML = (res1 + "<br/>" + res2);
}
