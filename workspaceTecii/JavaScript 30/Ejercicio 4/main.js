const pressed = [];
const secretCode = 'kirby';
var typedHistory = "";



window.addEventListener('keyup', (e) => {
    console.log(e.key);
    pressed.push(e.key);

    typedHistory = typedHistory + (e.key);
    document.getElementById("typed").innerHTML = typedHistory;

    pressed.splice(-secretCode.length - 1, pressed.length - secretCode.length);
    if (pressed.join('').includes(secretCode)) {
        console.log('POYO!');
        cornify_add();
        playSound();
    }
    console.log(pressed);
});

function playSound() {
    const audio = document.getElementById('kirbysmash');
    document.getElementById("kirbo").style.visibility = "visible";

    if (!audio) return;

    const randomSecond = Math.random() * 34; // Genera un numero al azar entre 0 y 34
    audio.currentTime = randomSecond;
    audio.play();
}


function playPoyo() {
    const audio = document.getElementById('poyo');

    if (!audio) return;

    audio.currentTime = 0;
    audio.play();
}

document.getElementById("btnPoyo").addEventListener("click", playPoyo);


