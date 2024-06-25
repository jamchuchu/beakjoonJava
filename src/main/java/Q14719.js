const readline = require('readline');

const rl = readline.createInterface({
    input: process.stdin,
    output: process.stdout
});


class Tower{
    constructor(height, idx){
        this.height = height;
        this.idx = idx;
    }
}


let input = [];
rl.on('line', (line) => {
    input.push(line);
}).on('close', () => {
    let answer = 0;
    let str = input[0].split(' ').map(Number);
    let n = str[0];
    let m = str[1];

    let nums = input[1].split(' ').map(Number);
    let towers = [];
    for(let i = 0 ; i< m; i++){
        towers.push(new Tower(nums[i], i+1));
    }

    let targets = [];

    while(true){
        if(towers.length == 0){
            break;
        }
        towers.sort((o1, o2) => o1.height - o2.height);

        let t = towers.shift();
        let right = 0;
        let left = 0;
        let flag = false;
        let temp = towers.slice();
        for(let side of temp){

            if(side.height > t.height){
                if(side.idx > t.idx){
                    right = side.idx;
                }else{
                    left = side.idx;
                }
            }
            if(right != 0 && left != 0){
                flag = true;
                break;
            }
        }
        if(!flag){
            targets.push(t);
        }
    }

    targets.sort((o1, o2) => o1.idx - o2.idx);
    let pre = targets.shift();
    while(targets.length != 0){
        let now = targets.shift();
        let min = Math.min(pre.height, now.height);
        for(let i = pre.idx ; i< now.idx -1 ; i++){
            answer += min- nums[i];
        }
        pre = now;
    }

    process.stdout.write(answer.toString());


});