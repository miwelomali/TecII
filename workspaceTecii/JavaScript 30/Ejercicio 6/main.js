const hero = document.querySelector('.hero');
const text = hero.querySelector('h1');
const walk = 500; // 500px
var count = 0;

function shadow(e) {
    const { offsetWidth: width, offsetHeight: height } = hero;
    let { offsetX: x, offsetY: y } = e;
    console.log(x, y);

    if (this !== e.target) {
        x = x + e.target.offsetLeft;
        y = y + e.target.offsetTop;
    }

    const xWalk = Math.round((x / width * walk) - (walk / 2));
    const yWalk = Math.round((y / height * walk) - (walk / 2));
    switch(count){
        case 0: 
        text.style.textShadow = `
      ${xWalk}px ${yWalk}px 0 rgba(255,0,255,0.7)  
    `;
    break;
    case 1:
        text.style.textShadow = `
      ${xWalk}px ${yWalk}px 0 rgba(255,0,255,0.7),
      ${xWalk * -1}px ${yWalk}px 0 rgba(0,255,255,0.7) 
    `;
    break;
    case 2:
        text.style.textShadow = `
      ${xWalk}px ${yWalk}px 0 rgba(255,0,255,0.7),
      ${xWalk * -1}px ${yWalk}px 0 rgba(0,255,255,0.7),
      ${yWalk}px ${xWalk * -1}px 0 rgba(0,255,0,0.7)
    `;
    break;
    case 3: //Codigo fuente.
        text.style.textShadow = `
      ${xWalk}px ${yWalk}px 0 rgba(255,0,255,0.7),
      ${xWalk * -1}px ${yWalk}px 0 rgba(0,255,255,0.7),
      ${yWalk}px ${xWalk * -1}px 0 rgba(0,255,0,0.7),
      ${yWalk * -1}px ${xWalk}px 0 rgba(0,0,255,0.7)
    `;
    break;
    }

  

}

function countClicks(){
    count ++;
    if(count>3){

        count = 0;
    }
    console.log(count);
}

hero.addEventListener('mousemove', shadow);
hero.addEventListener('click', countClicks);