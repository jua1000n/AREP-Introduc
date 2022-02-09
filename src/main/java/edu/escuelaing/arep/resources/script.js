let numberc;
let numberf;
let res1;
let res2;


function inputValues() {
    const url = 'https://arep-backend-jc.herokuapp.com/convert';
    const devUrl = 'http://localhost:5000/convert';`ds`
    numberc = document.getElementsByName("numbercel")[0].value;
    numberf = document.getElementsByName("numberfah")[0].value;
    console.log(numberc, numberf);
    console.log(numberc==null, numberf == null);

    const url1 = `${url}/celsiusF?value=${numberc}`;
    const url2 = `${url}/fahrenheitC?value=${numberf}`;
    http://localhost:5000/convert/celsiusF?value=2let res1;

    if(numberc != "") {
        getapi(url1, "C");
    }
    if (numberf != "") {
        getapi(url2, "F");
    }
    console.log(res1.result, res2.result);
}

async function getapi (url, s) {
    try {
        const response = await fetch(url, {method: 'GET', headers: {'Content-Type': 'application/json'}});
        let data = await response.json();
        alert(`su resultado en ${s} es ${data.result}`);

    }catch (e) {
        console.log(e);
    }
}